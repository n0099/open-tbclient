package com.baidu.tieba.home;

import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.a {
    final /* synthetic */ CreateBarActivity a;
    private String b;
    private String c;
    private com.baidu.tieba.d.t d = null;

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.g();
        }
        progressBar = this.a.o;
        progressBar.setVisibility(8);
        this.a.q = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.a = createBarActivity;
        this.b = null;
        this.c = null;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        String str;
        try {
            this.d = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/forum/create");
            this.d.d(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            com.baidu.tieba.d.t tVar = this.d;
            str = this.a.u;
            tVar.a("vcode_md5", str);
            this.d.i();
            return null;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        ProgressBar progressBar;
        super.a((Object) str);
        progressBar = this.a.o;
        progressBar.setVisibility(8);
        this.a.q = null;
        if (this.d.b()) {
            CreateBarSuccessActivity.a(this.a, this.b);
            this.a.finish();
            return;
        }
        this.a.a(this.d.f());
        if (this.d.c()) {
            this.a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.a.o;
        progressBar.setVisibility(0);
    }
}
