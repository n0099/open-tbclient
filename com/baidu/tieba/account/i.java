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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, AccountData> {
    final /* synthetic */ AccountActivity amF;
    private AccountData amJ;
    private boolean amK;
    private int mType = 0;

    public i(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.amF = accountActivity;
        this.amK = false;
        this.amJ = accountData;
        this.amK = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public AccountData doInBackground(Object... objArr) {
        try {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            if (this.amK) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.amJ.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.amJ.getID()));
            o.deleteAccountAllInfo(this.amJ.getID());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.oc().remove("get_addresslist_switch" + this.amJ.getID());
            if (this.amJ.getID().equals(currentAccount)) {
                SapiAccountManager.getInstance().logout();
                this.mType = 2;
                return null;
            }
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (!TextUtils.isEmpty(this.amJ.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
                Iterator<SapiAccount> it = loginAccounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount next = it.next();
                    if (this.amJ.getID().equals(next.uid)) {
                        SapiAccountManager.getInstance().removeLoginAccount(next);
                        break;
                    }
                }
            }
            this.mType = 0;
            return null;
        } catch (Exception e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(AccountData accountData) {
        ArrayList arrayList;
        m mVar;
        if (this.amJ != null) {
            new j(this.amF, this.amJ.getBDUSS()).start();
        }
        this.amF.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkCoreApplication.setCurrentAccount(null, this.amF.getPageContext().getPageActivity());
        }
        switch (this.mType) {
            case 0:
                this.amF.showToast(this.amF.getPageContext().getString(com.baidu.tieba.z.success));
                arrayList = this.amF.amz;
                arrayList.remove(this.amJ);
                this.amJ = null;
                mVar = this.amF.amA;
                mVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkCoreApplication.m255getInst().onUserChanged();
                com.baidu.tbadk.core.b.b.a(this.amF.getPageContext().getPageActivity(), 11, false);
                break;
        }
        this.amF.amE = null;
    }
}
