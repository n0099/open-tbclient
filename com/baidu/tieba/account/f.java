package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.message.Hao123UpdateMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, AccountData> {
    final /* synthetic */ AccountActivity alO;
    private AccountData alR;
    private boolean alS;
    private int mType = 0;

    public f(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.alO = accountActivity;
        this.alS = false;
        this.alR = accountData;
        this.alS = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.alO.showLoadingDialog(this.alO.getPageContext().getString(com.baidu.tieba.z.deleting), new g(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public AccountData doInBackground(Object... objArr) {
        try {
            Thread.sleep(1000L);
            if (this.alS) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.alR.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.alR.getID()));
            n.deleteAccountAllInfo(this.alR.getID());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.og().remove("get_addresslist_switch" + this.alR.getID());
            if (this.alR.getID().equals(currentAccount)) {
                SapiAccountManager.getInstance().logout();
                this.mType = 2;
                updateHao123Cache();
                return null;
            }
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (!TextUtils.isEmpty(this.alR.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
                Iterator<SapiAccount> it = loginAccounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount next = it.next();
                    if (this.alR.getID().equals(next.uid)) {
                        SapiAccountManager.getInstance().removeLoginAccount(next);
                        break;
                    }
                }
            }
            this.mType = 0;
            return null;
        } catch (Exception e) {
            BdLog.detailException(e);
            return null;
        }
    }

    private void updateHao123Cache() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new Hao123UpdateMessage());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(AccountData accountData) {
        ArrayList arrayList;
        l lVar;
        if (this.alR != null) {
            new h(this.alO, this.alR.getBDUSS()).start();
        }
        this.alO.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkCoreApplication.setCurrentAccount(null, this.alO.getPageContext().getPageActivity());
        }
        switch (this.mType) {
            case 0:
                this.alO.showToast(this.alO.getPageContext().getString(com.baidu.tieba.z.success));
                arrayList = this.alO.alI;
                arrayList.remove(this.alR);
                this.alR = null;
                lVar = this.alO.alJ;
                lVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkCoreApplication.m255getInst().onUserChanged();
                com.baidu.tbadk.core.b.b.a(this.alO.getPageContext().getPageActivity(), 11, false);
                break;
        }
        this.alO.alN = null;
    }
}
