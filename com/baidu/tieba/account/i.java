package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AccountActivity a;
    private AccountData b;

    public i(AccountActivity accountActivity, AccountData accountData) {
        this.a = accountActivity;
        this.b = null;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.y.account_logining), new j(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
        com.baidu.sapi2.SapiAccountManager.getInstance().validate(r0);
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean doInBackground(Object... objArr) {
        try {
            Thread.sleep(1000L);
            this.b.setIsActive(1);
            com.baidu.tbadk.core.account.a.a(this.b);
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            if (!TextUtils.isEmpty(this.b.getID()) && loginAccounts != null && loginAccounts.size() > 0) {
                Iterator<SapiAccount> it = loginAccounts.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SapiAccount next = it.next();
                    if (this.b.getID().equals(next.uid)) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        TbadkApplication.setCurrentAccount(this.b, this.a.getBaseContext());
        if (this.b != null) {
            new k(this.a, this.b.getBDUSS()).start();
        }
        this.a.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkApplication.m252getInst().onUserChanged();
        MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
        MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
        com.baidu.tbadk.core.b.b.a(this.a, 1, false);
        this.a.h = null;
    }
}
