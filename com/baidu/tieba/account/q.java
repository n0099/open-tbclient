package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<String, Integer, com.baidu.tieba.data.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f924a;
    private com.baidu.tieba.util.z b = null;
    private String c;
    private String d;

    public q(k kVar, String str, String str2) {
        this.f924a = kVar;
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
        progressBar = this.f924a.p;
        progressBar.setVisibility(8);
        button = this.f924a.k;
        button.setEnabled(true);
        this.f924a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.c a(String... strArr) {
        this.b = new com.baidu.tieba.util.z(this.c);
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
        com.baidu.tieba.j jVar;
        super.a((q) cVar);
        this.f924a.m = null;
        progressBar = this.f924a.p;
        progressBar.setVisibility(8);
        button = this.f924a.k;
        button.setEnabled(true);
        if (!this.b.d()) {
            this.f924a.b(this.b.g());
        } else if (this.b.e() == 0) {
            k kVar = this.f924a;
            jVar = this.f924a.j;
            kVar.b(jVar.getString(R.string.name_not_use));
        } else if (this.b.e() == 36) {
            this.f924a.b(this.b.g());
            if (cVar != null) {
                this.f924a.a(cVar.b());
            }
        } else {
            this.f924a.b(this.b.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f924a.p;
        progressBar.setVisibility(0);
        button = this.f924a.k;
        button.setEnabled(false);
        this.f924a.b((String) null);
        this.f924a.d();
        super.b();
    }
}
