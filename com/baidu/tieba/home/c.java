package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask {
    final /* synthetic */ CreateBarActivity a;
    private String b;
    private String c;
    private com.baidu.tieba.util.r d = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.h();
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            this.d = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/forum/create");
            this.d.d(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            com.baidu.tieba.util.r rVar = this.d;
            str = this.a.u;
            rVar.a("vcode_md5", str);
            this.d.j();
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        super.a((Object) str);
        progressBar = this.a.o;
        progressBar.setVisibility(8);
        this.a.q = null;
        if (this.d.c()) {
            CreateBarSuccessActivity.a(this.a, this.b);
            this.a.finish();
            return;
        }
        this.a.a(this.d.g());
        if (this.d.d()) {
            this.a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.a.o;
        progressBar.setVisibility(0);
    }
}
