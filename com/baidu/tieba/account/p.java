package com.baidu.tieba.account;

import android.widget.Button;
import android.widget.ProgressBar;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.lib.a.a {
    final /* synthetic */ j a;
    private com.baidu.tieba.d.t b = null;
    private String c;
    private String d;

    public p(j jVar, String str, String str2) {
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
        super.cancel(true);
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        this.a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.a.e a(String... strArr) {
        this.b = new com.baidu.tieba.d.t(this.c);
        this.b.a("un", this.d);
        String i = this.b.i();
        if (!this.b.c() || this.b.d() != 36) {
            return null;
        }
        com.baidu.tieba.a.e eVar = new com.baidu.tieba.a.e();
        eVar.a(i);
        return eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.a.e eVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.e eVar2;
        super.a((Object) eVar);
        this.a.m = null;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        if (!this.b.c()) {
            this.a.b(this.b.f());
        } else if (this.b.d() == 0) {
            j jVar = this.a;
            eVar2 = this.a.j;
            jVar.b(eVar2.getString(R.string.name_not_use));
        } else if (this.b.d() == 36) {
            this.a.b(this.b.f());
            if (eVar != null) {
                this.a.a(eVar.b());
            }
        } else {
            this.a.b(this.b.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
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
