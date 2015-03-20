package com.baidu.tbadk.coreExtra.view;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    private com.baidu.tbadk.core.util.aa ZD = null;
    final /* synthetic */ t aeZ;
    private String mAccount;
    private String mUrl;

    public z(t tVar, String str, String str2) {
        this.aeZ = tVar;
        this.mUrl = null;
        this.mAccount = null;
        this.mUrl = str;
        this.mAccount = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.aeZ.aeM = null;
        progressBar = this.aeZ.aeQ;
        progressBar.setVisibility(8);
        textView = this.aeZ.aeP;
        textView.setEnabled(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.a aVar) {
        ProgressBar progressBar;
        TextView textView;
        AccountData accountData;
        TbPageContext tbPageContext;
        x xVar;
        x xVar2;
        AccountData accountData2;
        super.onPostExecute(aVar);
        this.aeZ.aeM = null;
        progressBar = this.aeZ.aeQ;
        progressBar.setVisibility(8);
        textView = this.aeZ.aeP;
        textView.setEnabled(true);
        if (aVar == null) {
            this.aeZ.dN(this.ZD.getErrorString());
        } else if (aVar.getUser().getUserName() != null) {
            this.aeZ.xa();
            accountData = this.aeZ.aeU;
            tbPageContext = this.aeZ.LN;
            TbadkCoreApplication.setCurrentAccount(accountData, tbPageContext.getPageActivity());
            xVar = this.aeZ.aeV;
            if (xVar != null) {
                xVar2 = this.aeZ.aeV;
                accountData2 = this.aeZ.aeU;
                xVar2.g(accountData2);
            }
        } else {
            this.aeZ.r(aVar.qf());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.aeZ.aeQ;
        progressBar.setVisibility(0);
        textView = this.aeZ.aeP;
        textView.setEnabled(false);
        this.aeZ.dN(null);
        this.aeZ.wZ();
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
    /* renamed from: j */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        String str;
        Exception e;
        AccountData accountData;
        String rO;
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
            this.ZD = new com.baidu.tbadk.core.util.aa(this.mUrl);
            this.ZD.o("un", this.mAccount);
            com.baidu.tbadk.core.util.aa aaVar = this.ZD;
            accountData = this.aeZ.aeU;
            aaVar.o("BDUSS", accountData.getBDUSS());
            this.ZD.sp().tp().VU = false;
            rO = this.ZD.rO();
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        if (this.ZD.ss()) {
            str = this.ZD.st();
            try {
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                return str;
            }
            if (str == 0) {
                com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
                aVar.parserJson(rO);
                String userName = aVar.getUser().getUserName();
                String bduss = aVar.getUser().getBDUSS();
                str = aVar;
                str = aVar;
                str2 = userName;
                str2 = userName;
                if (userName != null && bduss != null) {
                    accountData2 = this.aeZ.aeU;
                    str = aVar;
                    str2 = userName;
                    if (accountData2 != null) {
                        accountData3 = this.aeZ.aeU;
                        accountData3.setAccount(userName);
                        accountData4 = this.aeZ.aeU;
                        accountData4.setBDUSS(bduss);
                        accountData5 = this.aeZ.aeU;
                        accountData5.setPortrait(aVar.getUser().getPortrait());
                        r1 = this.aeZ.aeU;
                        com.baidu.tbadk.core.a.d.b(r1);
                        str = aVar;
                        str2 = r1;
                    }
                }
            } else if (this.ZD.st() == 36) {
                com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                aVar2.parserJson(rO);
                str = aVar2;
            } else if (this.ZD.st() == 1) {
                this.aeZ.xa();
                str = 0;
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }
}
