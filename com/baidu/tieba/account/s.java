package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Integer, com.baidu.tieba.data.d> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1092a;
    private com.baidu.tieba.util.ap b = null;
    private String c;
    private String d;

    public s(m mVar, String str, String str2) {
        this.f1092a = mVar;
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
        progressBar = this.f1092a.p;
        progressBar.setVisibility(8);
        button = this.f1092a.k;
        button.setEnabled(true);
        this.f1092a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.d a(String... strArr) {
        this.b = new com.baidu.tieba.util.ap(this.c);
        this.b.a("un", this.d);
        String l = this.b.l();
        if (!this.b.d() || this.b.e() != 36) {
            return null;
        }
        com.baidu.tieba.data.d dVar = new com.baidu.tieba.data.d();
        dVar.a(l);
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.d dVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.j jVar;
        super.a((s) dVar);
        this.f1092a.m = null;
        progressBar = this.f1092a.p;
        progressBar.setVisibility(8);
        button = this.f1092a.k;
        button.setEnabled(true);
        if (!this.b.d()) {
            this.f1092a.b(this.b.i());
        } else if (this.b.e() == 0) {
            m mVar = this.f1092a;
            jVar = this.f1092a.j;
            mVar.b(jVar.getString(R.string.name_not_use));
        } else if (this.b.e() == 36) {
            this.f1092a.b(this.b.i());
            if (dVar != null) {
                this.f1092a.a(dVar.b());
            }
        } else {
            this.f1092a.b(this.b.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f1092a.p;
        progressBar.setVisibility(0);
        button = this.f1092a.k;
        button.setEnabled(false);
        this.f1092a.b((String) null);
        this.f1092a.d();
        super.b();
    }
}
