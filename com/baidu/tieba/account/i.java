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
    final /* synthetic */ AccountActivity amI;
    private AccountData amM;
    private boolean amN;
    private int mType = 0;

    public i(AccountActivity accountActivity, boolean z, AccountData accountData) {
        this.amI = accountActivity;
        this.amN = false;
        this.amM = accountData;
        this.amN = z;
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
            if (this.amN) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, this.amM.getID()));
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001193, this.amM.getID()));
            o.deleteAccountAllInfo(this.amM.getID());
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            com.baidu.tbadk.core.sharedPref.b.oj().remove("get_addresslist_switch" + this.amM.getID());
            if (this.amM.getID().equals(currentAccount)) {
                SapiAccountManager.getInstance().logout();
                this.mType = 2;
                return null;
            }
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (!TextUtils.isEmpty(this.amM.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
                Iterator<SapiAccount> it = loginAccounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount next = it.next();
                    if (this.amM.getID().equals(next.uid)) {
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
        if (this.amM != null) {
            new j(this.amI, this.amM.getBDUSS()).start();
        }
        this.amI.closeLoadingDialog();
        if (this.mType != 0) {
            TbadkCoreApplication.setCurrentAccount(null, this.amI.getPageContext().getPageActivity());
        }
        switch (this.mType) {
            case 0:
                this.amI.showToast(this.amI.getPageContext().getString(com.baidu.tieba.z.success));
                arrayList = this.amI.amC;
                arrayList.remove(this.amM);
                this.amM = null;
                mVar = this.amI.amD;
                mVar.notifyDataSetChanged();
                break;
            case 2:
                TbadkCoreApplication.m255getInst().onUserChanged();
                com.baidu.tbadk.core.b.b.a(this.amI.getPageContext().getPageActivity(), 11, false);
                break;
        }
        this.amI.amH = null;
    }
}
