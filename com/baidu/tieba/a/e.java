package com.baidu.tieba.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.account.p;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<String, Integer, AccountData> {
    private final String Pc;
    private volatile aa aaG = null;
    private final String bGK;
    private final com.baidu.tbadk.core.a.b bGL;
    private final boolean bGM;
    private final String mName;

    public e(String str, String str2, String str3, com.baidu.tbadk.core.a.b bVar, boolean z) {
        this.mName = str;
        this.bGK = str2;
        this.Pc = str3;
        this.bGM = z;
        this.bGL = bVar == null ? new f(this) : bVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bGL.cb(this.mName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: t */
    public AccountData doInBackground(String... strArr) {
        com.baidu.tbadk.core.a.c a;
        this.aaG = new aa(TbConfig.LOGIN_FULL_ADDRESS);
        this.aaG.sX().tS().mIsUseCurrentBDUSS = false;
        this.aaG.o("bdusstoken", String.valueOf(this.bGK) + "|" + this.Pc);
        this.aaG.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        this.aaG.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        this.aaG.sX().tS().WD = false;
        String sw = this.aaG.sw();
        if (this.aaG.sX().tT().qa() && sw != null) {
            n nVar = new n();
            nVar.parserJson(sw);
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(nVar.getUser().getUserId());
            String bduss = nVar.getUser().getBDUSS();
            if (this.bGM && (a = k.a(p.Fd().ca(bduss))) != null) {
                bduss = String.valueOf(a.wk) + "|" + a.Pc;
            }
            accountData.setBDUSS(bduss);
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.qK() != null) {
                accountData.setTbs(nVar.qK().getTbs());
                return accountData;
            }
            return accountData;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(AccountData accountData) {
        String str;
        int i;
        super.onPostExecute(accountData);
        ReloginManager.sg().am(false);
        if (accountData != null && accountData.getBDUSS() != null) {
            this.bGL.a(accountData);
            return;
        }
        if (this.aaG == null) {
            str = null;
            i = 0;
        } else {
            str = this.aaG.getErrorString();
            i = this.aaG.tb();
        }
        if (str == null) {
            str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.data_load_error);
        }
        this.bGL.c(this.mName, i, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.aaG != null) {
            this.aaG.gS();
        }
    }
}
