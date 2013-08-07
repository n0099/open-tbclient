package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f887a;
    private com.baidu.tieba.util.u b = null;
    private String c;
    private String d;

    public q(k kVar, String str, String str2) {
        this.f887a = kVar;
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
        progressBar = this.f887a.p;
        progressBar.setVisibility(8);
        button = this.f887a.k;
        button.setEnabled(true);
        this.f887a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.data.c a(String... strArr) {
        this.b = new com.baidu.tieba.util.u(this.c);
        this.b.a("un", this.d);
        String k = this.b.k();
        if (!this.b.e() || this.b.f() != 36) {
            return null;
        }
        com.baidu.tieba.data.c cVar = new com.baidu.tieba.data.c();
        cVar.a(k);
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
        this.f887a.m = null;
        progressBar = this.f887a.p;
        progressBar.setVisibility(8);
        button = this.f887a.k;
        button.setEnabled(true);
        if (!this.b.e()) {
            this.f887a.b(this.b.h());
        } else if (this.b.f() == 0) {
            k kVar = this.f887a;
            gVar = this.f887a.j;
            kVar.b(gVar.getString(R.string.name_not_use));
        } else if (this.b.f() == 36) {
            this.f887a.b(this.b.h());
            if (cVar != null) {
                this.f887a.a(cVar.b());
            }
        } else {
            this.f887a.b(this.b.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.f887a.p;
        progressBar.setVisibility(0);
        button = this.f887a.k;
        button.setEnabled(false);
        this.f887a.b((String) null);
        this.f887a.d();
        super.b();
    }
}
