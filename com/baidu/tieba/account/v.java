package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends AsyncTask {
    final /* synthetic */ o a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;

    public v(o oVar, String str, String str2) {
        this.a = oVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
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
    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.a.d] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.baidu.tieba.a.a] */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.d doInBackground(String... strArr) {
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
            this.b = new com.baidu.tieba.c.t(this.c);
            this.b.a("un", this.d);
            com.baidu.tieba.c.t tVar = this.b;
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
                    com.baidu.tieba.a.d dVar = new com.baidu.tieba.a.d();
                    dVar.a(i);
                    String b = dVar.a().b();
                    String j = dVar.a().j();
                    str = dVar;
                    str = dVar;
                    str2 = b;
                    str2 = b;
                    if (b != null && j != null) {
                        aVar2 = this.a.t;
                        str = dVar;
                        str2 = b;
                        if (aVar2 != null) {
                            aVar3 = this.a.t;
                            aVar3.b(b);
                            aVar4 = this.a.t;
                            aVar4.d(j);
                            r1 = this.a.t;
                            com.baidu.tieba.c.k.a((com.baidu.tieba.a.a) r1);
                            str = dVar;
                            str2 = r1;
                        }
                    }
                } else if (this.b.d() == 36) {
                    com.baidu.tieba.a.d dVar2 = new com.baidu.tieba.a.d();
                    dVar2.a(i);
                    str = dVar2;
                } else if (this.b.d() == 1) {
                    this.a.e();
                    str = 0;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
            return str;
        }
        str = 0;
        return str;
    }

    public void a() {
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.d dVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.a.a aVar;
        t tVar;
        t tVar2;
        com.baidu.tieba.a.a aVar2;
        super.onPostExecute(dVar);
        this.a.l = null;
        progressBar = this.a.q;
        progressBar.setVisibility(8);
        button = this.a.o;
        button.setEnabled(true);
        if (dVar == null) {
            this.a.b(this.b.f());
        } else if (dVar.a().b() == null) {
            this.a.b(this.b.f());
            this.a.a(dVar.b());
        } else {
            this.a.e();
            aVar = this.a.t;
            TiebaApplication.b(aVar);
            a.a().b();
            tVar = this.a.u;
            if (tVar != null) {
                tVar2 = this.a.u;
                aVar2 = this.a.t;
                tVar2.a(aVar2);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
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
}
