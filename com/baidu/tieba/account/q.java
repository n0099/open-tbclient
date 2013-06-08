package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.lib.a.a {
    final /* synthetic */ j a;
    private com.baidu.tieba.d.t b = null;
    private String c;
    private String d;

    public q(j jVar, String str, String str2) {
        this.a = jVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // com.baidu.adp.lib.a.a
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
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.e eVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.a.a aVar;
        o oVar;
        o oVar2;
        com.baidu.tieba.a.a aVar2;
        super.a((Object) eVar);
        this.a.l = null;
        progressBar = this.a.q;
        progressBar.setVisibility(8);
        button = this.a.o;
        button.setEnabled(true);
        if (eVar == null) {
            this.a.b(this.b.f());
        } else if (eVar.a().c() == null) {
            this.a.b(this.b.f());
            this.a.a(eVar.b());
        } else {
            this.a.e();
            aVar = this.a.t;
            TiebaApplication.b(aVar);
            a.a().b();
            oVar = this.a.u;
            if (oVar != null) {
                oVar2 = this.a.u;
                aVar2 = this.a.t;
                oVar2.a(aVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
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
    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.a.e] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.baidu.tieba.a.a] */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.a.e a(String... strArr) {
        String str;
        Exception e;
        com.baidu.tieba.a.a aVar;
        String i;
        com.baidu.tieba.a.a aVar2;
        com.baidu.tieba.a.a aVar3;
        com.baidu.tieba.a.a aVar4;
        ?? r1;
        String str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        try {
            this.b = new com.baidu.tieba.d.t(this.c);
            this.b.a("un", this.d);
            com.baidu.tieba.d.t tVar = this.b;
            aVar = this.a.t;
            tVar.a("BDUSS", aVar.d());
            this.b.b(false);
            i = this.b.i();
        } catch (Exception e2) {
            str = str2;
            e = e2;
        }
        if (this.b.c()) {
            str = this.b.d();
            try {
                if (str == 0) {
                    com.baidu.tieba.a.e eVar = new com.baidu.tieba.a.e();
                    eVar.a(i);
                    String c = eVar.a().c();
                    String l = eVar.a().l();
                    str = eVar;
                    str = eVar;
                    str2 = c;
                    str2 = c;
                    if (c != null && l != null) {
                        aVar2 = this.a.t;
                        str = eVar;
                        str2 = c;
                        if (aVar2 != null) {
                            aVar3 = this.a.t;
                            aVar3.b(c);
                            aVar4 = this.a.t;
                            aVar4.d(l);
                            r1 = this.a.t;
                            com.baidu.tieba.d.k.a((com.baidu.tieba.a.a) r1);
                            str = eVar;
                            str2 = r1;
                        }
                    }
                } else if (this.b.d() == 36) {
                    com.baidu.tieba.a.e eVar2 = new com.baidu.tieba.a.e();
                    eVar2.a(i);
                    str = eVar2;
                } else if (this.b.d() == 1) {
                    this.a.e();
                    str = 0;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }
}
