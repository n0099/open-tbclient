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
public class x extends BdAsyncTask<String, Integer, com.baidu.tbadk.coreExtra.data.a> {
    final /* synthetic */ q a;
    private com.baidu.tbadk.core.util.al b = null;
    private String c;
    private String d;

    public x(q qVar, String str, String str2) {
        this.a = qVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.a.l = null;
        progressBar = this.a.q;
        progressBar.setVisibility(8);
        button = this.a.o;
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
        v vVar;
        v vVar2;
        AccountData accountData2;
        super.onPostExecute(aVar);
        this.a.l = null;
        progressBar = this.a.q;
        progressBar.setVisibility(8);
        button = this.a.o;
        button.setEnabled(true);
        if (aVar == null) {
            this.a.b(this.b.f());
        } else if (aVar.a().getUserName() == null) {
            this.a.b(this.b.f());
            this.a.a(aVar.b());
        } else {
            this.a.e();
            accountData = this.a.t;
            baseActivity = this.a.j;
            TbadkApplication.setCurrentAccount(accountData, baseActivity);
            vVar = this.a.u;
            if (vVar != null) {
                vVar2 = this.a.u;
                accountData2 = this.a.t;
                vVar2.a(accountData2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.q;
        progressBar.setVisibility(0);
        button = this.a.o;
        button.setEnabled(false);
        this.a.b((String) null);
        this.a.d();
        super.onPreExecute();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00ad */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0099 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0099 */
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
    /* renamed from: a */
    public com.baidu.tbadk.coreExtra.data.a doInBackground(String... strArr) {
        String str;
        Exception e;
        AccountData accountData;
        String i;
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
            this.b = new com.baidu.tbadk.core.util.al(this.c);
            this.b.a("un", this.d);
            com.baidu.tbadk.core.util.al alVar = this.b;
            accountData = this.a.t;
            alVar.a("BDUSS", accountData.getBDUSS());
            this.b.a().a().b = false;
            i = this.b.i();
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        if (this.b.c()) {
            str = this.b.d();
            try {
            } catch (Exception e3) {
                e = e3;
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
            if (str == 0) {
                com.baidu.tbadk.coreExtra.data.a aVar = new com.baidu.tbadk.coreExtra.data.a();
                aVar.a(i);
                String userName = aVar.a().getUserName();
                String bduss = aVar.a().getBDUSS();
                str = aVar;
                str = aVar;
                str2 = userName;
                str2 = userName;
                if (userName != null && bduss != null) {
                    accountData2 = this.a.t;
                    str = aVar;
                    str2 = userName;
                    if (accountData2 != null) {
                        accountData3 = this.a.t;
                        accountData3.setAccount(userName);
                        accountData4 = this.a.t;
                        accountData4.setBDUSS(bduss);
                        accountData5 = this.a.t;
                        accountData5.setPortrait(aVar.a().getPortrait());
                        r1 = this.a.t;
                        com.baidu.tbadk.core.account.a.a((AccountData) r1);
                        str = aVar;
                        str2 = r1;
                    }
                }
            } else if (this.b.d() == 36) {
                com.baidu.tbadk.coreExtra.data.a aVar2 = new com.baidu.tbadk.coreExtra.data.a();
                aVar2.a(i);
                str = aVar2;
            } else if (this.b.d() == 1) {
                this.a.e();
                str = 0;
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }
}
