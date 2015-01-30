package com.baidu.tbadk.coreExtra.view;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    private com.baidu.tbadk.core.util.ad CX = null;
    final /* synthetic */ t UV;
    private String mAccount;
    private String mUrl;

    public aa(t tVar, String str, String str2) {
        this.UV = tVar;
        this.mUrl = null;
        this.mAccount = null;
        this.mUrl = str;
        this.mAccount = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.UV.UL = null;
        progressBar = this.UV.UQ;
        progressBar.setVisibility(8);
        button = this.UV.mConfirm;
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
        y yVar;
        y yVar2;
        AccountData accountData2;
        super.onPostExecute(aVar);
        this.UV.UL = null;
        progressBar = this.UV.UQ;
        progressBar.setVisibility(8);
        button = this.UV.mConfirm;
        button.setEnabled(true);
        if (aVar == null) {
            this.UV.dH(this.CX.getErrorString());
        } else if (aVar.getUser().getUserName() == null) {
            this.UV.dH(this.CX.getErrorString());
            this.UV.u(aVar.mS());
        } else {
            this.UV.tM();
            accountData = this.UV.QF;
            baseActivity = this.UV.UJ;
            TbadkCoreApplication.setCurrentAccount(accountData, baseActivity.getPageContext().getPageActivity());
            yVar = this.UV.UT;
            if (yVar != null) {
                yVar2 = this.UV.UT;
                accountData2 = this.UV.QF;
                yVar2.f(accountData2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.UV.UQ;
        progressBar.setVisibility(0);
        button = this.UV.mConfirm;
        button.setEnabled(false);
        this.UV.dH(null);
        this.UV.tL();
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
    /* renamed from: o */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        String str;
        Exception e;
        AccountData accountData;
        String oy;
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
            this.CX = new com.baidu.tbadk.core.util.ad(this.mUrl);
            this.CX.o("un", this.mAccount);
            com.baidu.tbadk.core.util.ad adVar = this.CX;
            accountData = this.UV.QF;
            adVar.o("BDUSS", accountData.getBDUSS());
            this.CX.oZ().qg().Kx = false;
            oy = this.CX.oy();
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        if (this.CX.pc()) {
            str = this.CX.pd();
            try {
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
            if (str == 0) {
                com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
                aVar.parserJson(oy);
                String userName = aVar.getUser().getUserName();
                String bduss = aVar.getUser().getBDUSS();
                str = aVar;
                str = aVar;
                str2 = userName;
                str2 = userName;
                if (userName != null && bduss != null) {
                    accountData2 = this.UV.QF;
                    str = aVar;
                    str2 = userName;
                    if (accountData2 != null) {
                        accountData3 = this.UV.QF;
                        accountData3.setAccount(userName);
                        accountData4 = this.UV.QF;
                        accountData4.setBDUSS(bduss);
                        accountData5 = this.UV.QF;
                        accountData5.setPortrait(aVar.getUser().getPortrait());
                        r1 = this.UV.QF;
                        com.baidu.tbadk.core.account.a.a(r1);
                        str = aVar;
                        str2 = r1;
                    }
                }
            } else if (this.CX.pd() == 36) {
                com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                aVar2.parserJson(oy);
                str = aVar2;
            } else if (this.CX.pd() == 1) {
                this.UV.tM();
                str = 0;
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }
}
