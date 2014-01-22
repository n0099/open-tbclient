package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask<String, Integer, com.baidu.tieba.data.d> {
    final /* synthetic */ x a;
    private com.baidu.tieba.util.ax b = null;
    private String c;
    private String d;

    public ae(x xVar, String str, String str2) {
        this.a = xVar;
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
    public void a(com.baidu.tieba.data.d dVar) {
        ProgressBar progressBar;
        Button button;
        AccountData accountData;
        com.baidu.tieba.j jVar;
        ac acVar;
        ac acVar2;
        AccountData accountData2;
        super.a((ae) dVar);
        this.a.l = null;
        progressBar = this.a.q;
        progressBar.setVisibility(8);
        button = this.a.o;
        button.setEnabled(true);
        if (dVar == null) {
            this.a.b(this.b.j());
        } else if (dVar.a().getName() == null) {
            this.a.b(this.b.j());
            this.a.a(dVar.b());
        } else {
            this.a.e();
            accountData = this.a.t;
            jVar = this.a.j;
            TiebaApplication.a(accountData, jVar);
            acVar = this.a.u;
            if (acVar != null) {
                acVar2 = this.a.u;
                accountData2 = this.a.t;
                acVar2.a(accountData2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.q;
        progressBar.setVisibility(0);
        button = this.a.o;
        button.setEnabled(false);
        this.a.b((String) null);
        this.a.d();
        super.b();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x00a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x003e */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.baidu.tieba.data.d */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: com.baidu.tieba.data.d */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.baidu.tieba.data.d */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.data.d] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.d a(String... strArr) {
        com.baidu.tieba.data.d dVar;
        Exception e;
        AccountData accountData;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        AccountData accountData5;
        AccountData accountData6;
        try {
            this.b = new com.baidu.tieba.util.ax(this.c);
            this.b.a("un", this.d);
            com.baidu.tieba.util.ax axVar = this.b;
            accountData = this.a.t;
            axVar.a("BDUSS", accountData.getBDUSS());
            this.b.c(false);
            String m = this.b.m();
            if (this.b.e()) {
                dVar = this.b.f();
                try {
                    if (dVar == 0) {
                        com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                        dVar2.a(m);
                        String name = dVar2.a().getName();
                        String bduss = dVar2.a().getBDUSS();
                        dVar = dVar2;
                        dVar = dVar2;
                        if (name != null && bduss != null) {
                            accountData2 = this.a.t;
                            dVar = dVar2;
                            if (accountData2 != null) {
                                accountData3 = this.a.t;
                                accountData3.setAccount(name);
                                accountData4 = this.a.t;
                                accountData4.setBDUSS(bduss);
                                accountData5 = this.a.t;
                                accountData5.setPortrait(dVar2.a().getPortrait());
                                accountData6 = this.a.t;
                                DatabaseService.a(accountData6);
                                dVar = dVar2;
                            }
                        }
                    } else if (this.b.f() == 36) {
                        com.baidu.tieba.data.d dVar3 = new com.baidu.tieba.data.d();
                        dVar3.a(m);
                        dVar = dVar3;
                    } else if (this.b.f() == 1) {
                        this.a.e();
                    }
                    return dVar;
                } catch (Exception e2) {
                    e = e2;
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
                    return dVar;
                }
            }
            return null;
        } catch (Exception e3) {
            dVar = 0;
            e = e3;
        }
    }
}
