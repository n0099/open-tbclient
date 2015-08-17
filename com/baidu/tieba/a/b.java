package com.baidu.tieba.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.account.k;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b {
    public static void a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a) {
        new a(str, str2, str3, interfaceC0040a, false).execute(new String[0]);
    }

    public static AccountData j(String str, String str2, String str3) {
        v vVar = new v(TbConfig.LOGIN_FULL_ADDRESS);
        vVar.ue().uV().mIsUseCurrentBDUSS = false;
        vVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        vVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        vVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        vVar.ue().uV().abE = false;
        String tD = vVar.tD();
        if (vVar.ue().uW().rb() && tD != null) {
            m mVar = new m();
            mVar.parserJson(tD);
            AccountData accountData = new AccountData();
            accountData.setAccount(mVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(mVar.getUser().getUserId());
            accountData.setBDUSS(mVar.getUser().getBDUSS());
            accountData.setPortrait(mVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (mVar.rM() != null) {
                accountData.setTbs(mVar.rM().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String TQ;
        private volatile v afJ = null;
        private final String bWD;
        private final a.InterfaceC0040a bWE;
        private final boolean bWF;
        private final String mName;

        public a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a, boolean z) {
            this.mName = str;
            this.bWD = str2;
            this.TQ = str3;
            this.bWF = z;
            this.bWE = interfaceC0040a == null ? new c(this) : interfaceC0040a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bWE.cb(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.afJ = new v(TbConfig.LOGIN_FULL_ADDRESS);
            this.afJ.ue().uV().mIsUseCurrentBDUSS = false;
            this.afJ.o("bdusstoken", String.valueOf(this.bWD) + "|" + this.TQ);
            this.afJ.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.afJ.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.afJ.ue().uV().abE = false;
            String tD = this.afJ.tD();
            if (this.afJ.ue().uW().rb() && tD != null) {
                m mVar = new m();
                mVar.parserJson(tD);
                AccountData accountData = new AccountData();
                accountData.setAccount(mVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(mVar.getUser().getUserId());
                String bduss = mVar.getUser().getBDUSS();
                if (this.bWF && (a = g.a(k.FS().ca(bduss))) != null) {
                    bduss = String.valueOf(a.wt) + "|" + a.TQ;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(mVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (mVar.rM() != null) {
                    accountData.setTbs(mVar.rM().getTbs());
                    return accountData;
                }
                return accountData;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.tn().aq(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.afJ.ui(), this.afJ.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.bWE.a(accountData);
                return;
            }
            String str = null;
            if (this.afJ != null) {
                str = this.afJ.getErrorString();
                i = this.afJ.ui();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.C0057i.data_load_error);
            }
            this.bWE.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afJ != null) {
                this.afJ.gM();
            }
        }
    }
}
