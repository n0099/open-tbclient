package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f888a;
    private com.baidu.tieba.util.u b = null;
    private String c;
    private String d;

    public r(k kVar, String str, String str2) {
        this.f888a = kVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.f888a.l = null;
        progressBar = this.f888a.q;
        progressBar.setVisibility(8);
        button = this.f888a.o;
        button.setEnabled(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.c cVar) {
        ProgressBar progressBar;
        Button button;
        AccountData accountData;
        com.baidu.tieba.g gVar;
        p pVar;
        p pVar2;
        AccountData accountData2;
        super.a((Object) cVar);
        this.f888a.l = null;
        progressBar = this.f888a.q;
        progressBar.setVisibility(8);
        button = this.f888a.o;
        button.setEnabled(true);
        if (cVar == null) {
            this.f888a.b(this.b.h());
        } else if (cVar.a().getName() == null) {
            this.f888a.b(this.b.h());
            this.f888a.a(cVar.b());
        } else {
            this.f888a.e();
            accountData = this.f888a.t;
            gVar = this.f888a.j;
            TiebaApplication.a(accountData, gVar);
            a.a().b();
            pVar = this.f888a.u;
            if (pVar != null) {
                pVar2 = this.f888a.u;
                accountData2 = this.f888a.t;
                pVar2.a(accountData2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f888a.q;
        progressBar.setVisibility(0);
        button = this.f888a.o;
        button.setEnabled(false);
        this.f888a.b((String) null);
        this.f888a.d();
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
        String k;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        ?? r1;
        String str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        try {
            this.b = new com.baidu.tieba.util.u(this.c);
            this.b.a("un", this.d);
            com.baidu.tieba.util.u uVar = this.b;
            accountData = this.f888a.t;
            uVar.a("BDUSS", accountData.getBDUSS());
            this.b.c(false);
            k = this.b.k();
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        if (this.b.e()) {
            str = this.b.f();
            try {
                if (str == 0) {
                    com.baidu.tieba.data.c cVar = new com.baidu.tieba.data.c();
                    cVar.a(k);
                    String name = cVar.a().getName();
                    String bduss = cVar.a().getBDUSS();
                    str = cVar;
                    str = cVar;
                    str2 = name;
                    str2 = name;
                    if (name != null && bduss != null) {
                        accountData2 = this.f888a.t;
                        str = cVar;
                        str2 = name;
                        if (accountData2 != null) {
                            accountData3 = this.f888a.t;
                            accountData3.setAccount(name);
                            accountData4 = this.f888a.t;
                            accountData4.setBDUSS(bduss);
                            r1 = this.f888a.t;
                            DatabaseService.a((AccountData) r1);
                            str = cVar;
                            str2 = r1;
                        }
                    }
                } else if (this.b.f() == 36) {
                    com.baidu.tieba.data.c cVar2 = new com.baidu.tieba.data.c();
                    cVar2.a(k);
                    str = cVar2;
                } else if (this.b.f() == 1) {
                    this.f888a.e();
                    str = 0;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }
}
