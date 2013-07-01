package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f675a;
    private com.baidu.tieba.util.r b = null;
    private String c;
    private String d;

    public p(j jVar, String str, String str2) {
        this.f675a = jVar;
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
        progressBar = this.f675a.p;
        progressBar.setVisibility(8);
        button = this.f675a.k;
        button.setEnabled(true);
        this.f675a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.c a(String... strArr) {
        this.b = new com.baidu.tieba.util.r(this.c);
        this.b.a("un", this.d);
        String j = this.b.j();
        if (!this.b.d() || this.b.e() != 36) {
            return null;
        }
        com.baidu.tieba.data.c cVar = new com.baidu.tieba.data.c();
        cVar.a(j);
        return cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.c cVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.g gVar;
        super.a((Object) cVar);
        this.f675a.m = null;
        progressBar = this.f675a.p;
        progressBar.setVisibility(8);
        button = this.f675a.k;
        button.setEnabled(true);
        if (!this.b.d()) {
            this.f675a.b(this.b.g());
        } else if (this.b.e() == 0) {
            j jVar = this.f675a;
            gVar = this.f675a.j;
            jVar.b(gVar.getString(R.string.name_not_use));
        } else if (this.b.e() == 36) {
            this.f675a.b(this.b.g());
            if (cVar != null) {
                this.f675a.a(cVar.b());
            }
        } else {
            this.f675a.b(this.b.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f675a.p;
        progressBar.setVisibility(0);
        button = this.f675a.k;
        button.setEnabled(false);
        this.f675a.b((String) null);
        this.f675a.d();
        super.b();
    }
}
