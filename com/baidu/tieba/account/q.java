package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {
    final /* synthetic */ j a;
    private com.baidu.tieba.util.r b = null;
    private String c;
    private String d;

    public q(j jVar, String str, String str2) {
        this.a = jVar;
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
    public void a(com.baidu.tieba.data.c cVar) {
        ProgressBar progressBar;
        Button button;
        AccountData accountData;
        o oVar;
        o oVar2;
        AccountData accountData2;
        super.a((Object) cVar);
        this.a.l = null;
        progressBar = this.a.q;
        progressBar.setVisibility(8);
        button = this.a.o;
        button.setEnabled(true);
        if (cVar == null) {
            this.a.b(this.b.g());
        } else if (cVar.a().getName() == null) {
            this.a.b(this.b.g());
            this.a.a(cVar.b());
        } else {
            this.a.e();
            accountData = this.a.t;
            TiebaApplication.b(accountData);
            a.a().b();
            oVar = this.a.u;
            if (oVar != null) {
                oVar2 = this.a.u;
                accountData2 = this.a.t;
                oVar2.a(accountData2);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0093 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0001 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x007f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:? */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.data.c] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.baidu.tieba.data.AccountData] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.c a(String... strArr) {
        String str;
        Exception e;
        AccountData accountData;
        String j;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        ?? r1;
        String str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        try {
            this.b = new com.baidu.tieba.util.r(this.c);
            this.b.a("un", this.d);
            com.baidu.tieba.util.r rVar = this.b;
            accountData = this.a.t;
            rVar.a("BDUSS", accountData.getBDUSS());
            this.b.b(false);
            j = this.b.j();
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        if (this.b.d()) {
            str = this.b.e();
            try {
                if (str == 0) {
                    com.baidu.tieba.data.c cVar = new com.baidu.tieba.data.c();
                    cVar.a(j);
                    String name = cVar.a().getName();
                    String bduss = cVar.a().getBDUSS();
                    str = cVar;
                    str = cVar;
                    str2 = name;
                    str2 = name;
                    if (name != null && bduss != null) {
                        accountData2 = this.a.t;
                        str = cVar;
                        str2 = name;
                        if (accountData2 != null) {
                            accountData3 = this.a.t;
                            accountData3.setAccount(name);
                            accountData4 = this.a.t;
                            accountData4.setBDUSS(bduss);
                            r1 = this.a.t;
                            DatabaseService.a((AccountData) r1);
                            str = cVar;
                            str2 = r1;
                        }
                    }
                } else if (this.b.e() == 36) {
                    com.baidu.tieba.data.c cVar2 = new com.baidu.tieba.data.c();
                    cVar2.a(j);
                    str = cVar2;
                } else if (this.b.e() == 1) {
                    this.a.e();
                    str = 0;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }
}
