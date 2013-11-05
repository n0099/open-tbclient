package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, com.baidu.tieba.data.d> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1054a;
    private com.baidu.tieba.util.ag b = null;
    private String c;
    private String d;

    public r(l lVar, String str, String str2) {
        this.f1054a = lVar;
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
        progressBar = this.f1054a.p;
        progressBar.setVisibility(8);
        button = this.f1054a.k;
        button.setEnabled(true);
        this.f1054a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.d a(String... strArr) {
        this.b = new com.baidu.tieba.util.ag(this.c);
        this.b.a("un", this.d);
        String j = this.b.j();
        if (!this.b.d() || this.b.e() != 36) {
            return null;
        }
        com.baidu.tieba.data.d dVar = new com.baidu.tieba.data.d();
        dVar.a(j);
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.d dVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.j jVar;
        super.a((r) dVar);
        this.f1054a.m = null;
        progressBar = this.f1054a.p;
        progressBar.setVisibility(8);
        button = this.f1054a.k;
        button.setEnabled(true);
        if (!this.b.d()) {
            this.f1054a.b(this.b.g());
        } else if (this.b.e() == 0) {
            l lVar = this.f1054a;
            jVar = this.f1054a.j;
            lVar.b(jVar.getString(R.string.name_not_use));
        } else if (this.b.e() == 36) {
            this.f1054a.b(this.b.g());
            if (dVar != null) {
                this.f1054a.a(dVar.b());
            }
        } else {
            this.f1054a.b(this.b.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f1054a.p;
        progressBar.setVisibility(0);
        button = this.f1054a.k;
        button.setEnabled(false);
        this.f1054a.b((String) null);
        this.f1054a.d();
        super.b();
    }
}
