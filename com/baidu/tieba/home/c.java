package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1146a;
    private String b;
    private String c;
    private com.baidu.tieba.util.u d = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.i();
        }
        progressBar = this.f1146a.o;
        progressBar.setVisibility(8);
        this.f1146a.q = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.f1146a = createBarActivity;
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
            this.d = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/c/forum/create");
            this.d.e(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            com.baidu.tieba.util.u uVar = this.d;
            str = this.f1146a.u;
            uVar.a("vcode_md5", str);
            this.d.k();
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        super.a((Object) str);
        progressBar = this.f1146a.o;
        progressBar.setVisibility(8);
        this.f1146a.q = null;
        if (this.d.d()) {
            CreateBarSuccessActivity.a(this.f1146a, this.b);
            this.f1146a.finish();
            return;
        }
        this.f1146a.a(this.d.h());
        if (this.d.e()) {
            this.f1146a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.f1146a.o;
        progressBar.setVisibility(0);
    }
}
