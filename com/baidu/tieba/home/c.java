package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ CreateBarActivity a;
    private String b;
    private String c;
    private com.baidu.tieba.util.an d = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.j();
        }
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        this.a.o = null;
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
            this.d = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/c/forum/create");
            this.d.e(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            com.baidu.tieba.util.an anVar = this.d;
            str = this.a.s;
            anVar.a("vcode_md5", str);
            this.d.l();
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        super.a((c) str);
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        this.a.o = null;
        if (this.d.c()) {
            CreateBarSuccessActivity.a(this.a, this.b);
            this.a.finish();
            return;
        }
        this.a.showToast(this.d.i());
        if (this.d.d()) {
            this.a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.a.m;
        progressBar.setVisibility(0);
    }
}
