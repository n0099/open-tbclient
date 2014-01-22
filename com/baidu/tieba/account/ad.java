package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BdAsyncTask<String, Integer, com.baidu.tieba.data.d> {
    final /* synthetic */ x a;
    private com.baidu.tieba.util.ax b = null;
    private String c;
    private String d;

    public ad(x xVar, String str, String str2) {
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
        super.cancel(true);
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        this.a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.d a(String... strArr) {
        this.b = new com.baidu.tieba.util.ax(this.c);
        this.b.a("un", this.d);
        String m = this.b.m();
        if (!this.b.e() || this.b.f() != 36) {
            return null;
        }
        com.baidu.tieba.data.d dVar = new com.baidu.tieba.data.d();
        dVar.a(m);
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.d dVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.j jVar;
        super.a((ad) dVar);
        this.a.m = null;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        if (!this.b.e()) {
            this.a.b(this.b.j());
        } else if (this.b.f() == 0) {
            x xVar = this.a;
            jVar = this.a.j;
            xVar.b(jVar.getString(R.string.name_not_use));
        } else if (this.b.f() == 36) {
            this.a.b(this.b.j());
            if (dVar != null) {
                this.a.a(dVar.b());
            }
        } else {
            this.a.b(this.b.j());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.p;
        progressBar.setVisibility(0);
        button = this.a.k;
        button.setEnabled(false);
        this.a.b((String) null);
        this.a.d();
        super.b();
    }
}
