package com.baidu.tieba.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.account.k;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b {
    public static void a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a) {
        new a(str, str2, str3, interfaceC0040a, false).execute(new String[0]);
    }

    public static AccountData k(String str, String str2, String str3) {
        v vVar = new v(TbConfig.LOGIN_FULL_ADDRESS);
        vVar.uj().uZ().mIsUseCurrentBDUSS = false;
        vVar.o("bdusstoken", String.valueOf(str2) + "|" + str3);
        vVar.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        vVar.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        vVar.uj().uZ().abM = false;
        String tI = vVar.tI();
        if (vVar.uj().va().qZ() && tI != null) {
            l lVar = new l();
            lVar.parserJson(tI);
            AccountData accountData = new AccountData();
            accountData.setAccount(lVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(lVar.getUser().getUserId());
            accountData.setBDUSS(lVar.getUser().getBDUSS());
            accountData.setPortrait(lVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (lVar.rK() != null) {
                accountData.setTbs(lVar.rK().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<String, Integer, AccountData> {
        private final String TR;
        private volatile v afT = null;
        private final String bXj;
        private final a.InterfaceC0040a bXk;
        private final boolean bXl;
        private final String mName;

        public a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a, boolean z) {
            this.mName = str;
            this.bXj = str2;
            this.TR = str3;
            this.bXl = z;
            this.bXk = interfaceC0040a == null ? new c(this) : interfaceC0040a;
            setPriority(3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.bXk.cc(this.mName);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public AccountData doInBackground(String... strArr) {
            a.b a;
            this.afT = new v(TbConfig.LOGIN_FULL_ADDRESS);
            this.afT.uj().uZ().mIsUseCurrentBDUSS = false;
            this.afT.o("bdusstoken", String.valueOf(this.bXj) + "|" + this.TR);
            this.afT.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
            this.afT.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
            this.afT.uj().uZ().abM = false;
            String tI = this.afT.tI();
            if (this.afT.uj().va().qZ() && tI != null) {
                l lVar = new l();
                lVar.parserJson(tI);
                AccountData accountData = new AccountData();
                accountData.setAccount(lVar.getUser().getUserName());
                accountData.setPassword("");
                accountData.setID(lVar.getUser().getUserId());
                String bduss = lVar.getUser().getBDUSS();
                if (this.bXl && (a = g.a(k.Gc().cb(bduss))) != null) {
                    bduss = String.valueOf(a.wr) + "|" + a.TR;
                }
                accountData.setBDUSS(bduss);
                accountData.setPortrait(lVar.getUser().getPortrait());
                accountData.setIsActive(1);
                if (lVar.rK() != null) {
                    accountData.setTbs(lVar.rK().getTbs());
                    return accountData;
                }
                return accountData;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(AccountData accountData) {
            int i = 0;
            super.onPostExecute(accountData);
            ReloginManager.ts().aq(false);
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "cslogin_result", this.afT.un(), this.afT.getErrorString(), new Object[0]);
            if (accountData != null && accountData.getBDUSS() != null) {
                this.bXk.a(accountData);
                return;
            }
            String str = null;
            if (this.afT != null) {
                str = this.afT.getErrorString();
                i = this.afT.un();
            }
            if (str == null) {
                str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.data_load_error);
            }
            this.bXk.c(this.mName, i, str);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afT != null) {
                this.afT.gJ();
            }
        }
    }
}
