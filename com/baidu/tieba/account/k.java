package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AccountActivity amF;
    private AccountData mAccount;

    public k(AccountActivity accountActivity, AccountData accountData) {
        this.amF = accountActivity;
        this.mAccount = null;
        this.mAccount = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        com.baidu.sapi2.SapiAccountManager.getInstance().validate(r0);
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean doInBackground(Object... objArr) {
        try {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            this.mAccount.setIsActive(1);
            com.baidu.tbadk.core.account.a.a(this.mAccount);
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (!TextUtils.isEmpty(this.mAccount.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
                Iterator<SapiAccount> it = loginAccounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount next = it.next();
                    if (this.mAccount.getID().equals(next.uid)) {
                        break;
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        TbadkCoreApplication.setCurrentAccount(this.mAccount, this.amF.getBaseContext());
        if (this.mAccount != null) {
            new l(this.amF, this.mAccount.getBDUSS()).start();
        }
        this.amF.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m255getInst().onUserChanged();
        com.baidu.tbadk.core.b.b.a(this.amF.getPageContext().getPageActivity(), 1, false);
        this.amF.amD = null;
    }
}
