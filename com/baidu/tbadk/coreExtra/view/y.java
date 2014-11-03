package com.baidu.tbadk.coreExtra.view;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    final /* synthetic */ r OC;
    private String mAccount;
    private String mUrl;
    private com.baidu.tbadk.core.util.ac yV = null;

    public y(r rVar, String str, String str2) {
        this.OC = rVar;
        this.mUrl = null;
        this.mAccount = null;
        this.mUrl = str;
        this.mAccount = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.OC.Ot = null;
        progressBar = this.OC.Ox;
        progressBar.setVisibility(8);
        button = this.OC.mConfirm;
        button.setEnabled(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
        ProgressBar progressBar;
        Button button;
        AccountData accountData;
        BaseActivity baseActivity;
        w wVar;
        w wVar2;
        AccountData accountData2;
        super.onPostExecute(aVar);
        this.OC.Ot = null;
        progressBar = this.OC.Ox;
        progressBar.setVisibility(8);
        button = this.OC.mConfirm;
        button.setEnabled(true);
        if (aVar == null) {
            this.OC.cM(this.yV.getErrorString());
        } else if (aVar.getUser().getUserName() == null) {
            this.OC.cM(this.yV.getErrorString());
            this.OC.j(aVar.ka());
        } else {
            this.OC.qc();
            accountData = this.OC.KT;
            baseActivity = this.OC.Or;
            TbadkApplication.setCurrentAccount(accountData, baseActivity);
            wVar = this.OC.OA;
            if (wVar != null) {
                wVar2 = this.OC.OA;
                accountData2 = this.OC.KT;
                wVar2.f(accountData2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.OC.Ox;
        progressBar.setVisibility(0);
        button = this.OC.mConfirm;
        button.setEnabled(false);
        this.OC.cM(null);
        this.OC.qb();
        super.onPreExecute();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00ab */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0097 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0045 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0097 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0001 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tbadk.coreExtra.data.a] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.baidu.tbadk.core.data.AccountData] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        String str;
        Exception e;
        AccountData accountData;
        String lA;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        AccountData accountData5;
        ?? r1;
        String str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        try {
            this.yV = new com.baidu.tbadk.core.util.ac(this.mUrl);
            this.yV.k("un", this.mAccount);
            com.baidu.tbadk.core.util.ac acVar = this.yV;
            accountData = this.OC.KT;
            acVar.k("BDUSS", accountData.getBDUSS());
            this.yV.mc().na().FU = false;
            lA = this.yV.lA();
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        if (this.yV.mf()) {
            str = this.yV.mg();
            try {
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
            if (str == 0) {
                com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
                aVar.parserJson(lA);
                String userName = aVar.getUser().getUserName();
                String bduss = aVar.getUser().getBDUSS();
                str = aVar;
                str = aVar;
                str2 = userName;
                str2 = userName;
                if (userName != null && bduss != null) {
                    accountData2 = this.OC.KT;
                    str = aVar;
                    str2 = userName;
                    if (accountData2 != null) {
                        accountData3 = this.OC.KT;
                        accountData3.setAccount(userName);
                        accountData4 = this.OC.KT;
                        accountData4.setBDUSS(bduss);
                        accountData5 = this.OC.KT;
                        accountData5.setPortrait(aVar.getUser().getPortrait());
                        r1 = this.OC.KT;
                        com.baidu.tbadk.core.account.a.a(r1);
                        str = aVar;
                        str2 = r1;
                    }
                }
            } else if (this.yV.mg() == 36) {
                com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                aVar2.parserJson(lA);
                str = aVar2;
            } else if (this.yV.mg() == 1) {
                this.OC.qc();
                str = 0;
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }
}
