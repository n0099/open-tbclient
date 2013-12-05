package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1488a;
    private String b;
    private String c;
    private com.baidu.tieba.util.am d = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.j();
        }
        progressBar = this.f1488a.m;
        progressBar.setVisibility(8);
        this.f1488a.o = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.f1488a = createBarActivity;
        this.b = null;
        this.c = null;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            this.d = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/forum/create");
            this.d.e(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            com.baidu.tieba.util.am amVar = this.d;
            str = this.f1488a.s;
            amVar.a("vcode_md5", str);
            this.d.l();
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        super.a((c) str);
        progressBar = this.f1488a.m;
        progressBar.setVisibility(8);
        this.f1488a.o = null;
        if (this.d.c()) {
            CreateBarSuccessActivity.a(this.f1488a, this.b);
            this.f1488a.finish();
            return;
        }
        this.f1488a.showToast(this.d.i());
        if (this.d.d()) {
            this.f1488a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.f1488a.m;
        progressBar.setVisibility(0);
    }
}
