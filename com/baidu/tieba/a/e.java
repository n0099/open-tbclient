package com.baidu.tieba.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.account.p;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<String, Integer, AccountData> {
    private final String OD;
    private volatile aa ZD = null;
    private final String bDB;
    private final com.baidu.tbadk.core.a.b bDC;
    private final boolean bDD;
    private final String mName;

    public e(String str, String str2, String str3, com.baidu.tbadk.core.a.b bVar, boolean z) {
        this.mName = str;
        this.bDB = str2;
        this.OD = str3;
        this.bDD = z;
        this.bDC = bVar == null ? new f(this) : bVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bDC.bO(this.mName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: s */
    public AccountData doInBackground(String... strArr) {
        com.baidu.tbadk.core.a.c a;
        this.ZD = new aa(TbConfig.LOGIN_FULL_ADDRESS);
        this.ZD.sp().tp().mIsUseCurrentBDUSS = false;
        this.ZD.o("bdusstoken", String.valueOf(this.bDB) + "|" + this.OD);
        this.ZD.o("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId());
        this.ZD.o("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId());
        this.ZD.sp().tp().VU = false;
        String rO = this.ZD.rO();
        if (this.ZD.sp().tq().pv() && rO != null) {
            n nVar = new n();
            nVar.parserJson(rO);
            AccountData accountData = new AccountData();
            accountData.setAccount(nVar.getUser().getUserName());
            accountData.setPassword("");
            accountData.setID(nVar.getUser().getUserId());
            String bduss = nVar.getUser().getBDUSS();
            if (this.bDD && (a = k.a(p.Ej().bN(bduss))) != null) {
                bduss = String.valueOf(a.xh) + "|" + a.OD;
            }
            accountData.setBDUSS(bduss);
            accountData.setPortrait(nVar.getUser().getPortrait());
            accountData.setIsActive(1);
            if (nVar.qe() != null) {
                accountData.setTbs(nVar.qe().getTbs());
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
        ReloginManager.rw().ag(false);
        if (accountData != null && accountData.getBDUSS() != null) {
            this.bDC.a(accountData);
            return;
        }
        if (this.ZD == null) {
            str = null;
            i = 0;
        } else {
            str = this.ZD.getErrorString();
            i = this.ZD.st();
        }
        if (str == null) {
            str = TbadkCoreApplication.m411getInst().getApp().getResources().getString(y.data_load_error);
        }
        this.bDC.c(this.mName, i, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.ZD != null) {
            this.ZD.hh();
        }
    }
}
