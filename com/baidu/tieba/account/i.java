package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AccountActivity aew;
    private AccountData mAccount;

    public i(AccountActivity accountActivity, AccountData accountData) {
        this.aew = accountActivity;
        this.mAccount = null;
        this.mAccount = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close("account changed");
        this.aew.showLoadingDialog(this.aew.getString(com.baidu.tieba.y.account_logining), new j(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        com.baidu.sapi2.SapiAccountManager.getInstance().validate(r0);
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean doInBackground(Object... objArr) {
        try {
            try {
                Thread.sleep(1000L);
                while (BdAsyncTask.getTaskNum(TiebaIMConfig.IM_ASYCTASK_UNIQUEID) > 0) {
                    Thread.sleep(200L);
                }
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
        TbadkApplication.setCurrentAccount(this.mAccount, this.aew.getBaseContext());
        if (this.mAccount != null) {
            new k(this.aew, this.mAccount.getBDUSS()).start();
        }
        this.aew.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkApplication.m251getInst().onUserChanged();
        com.baidu.tbadk.core.b.b.a(this.aew, 1, false);
        this.aew.aeu = null;
    }
}
