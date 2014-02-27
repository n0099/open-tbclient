package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ CreateBarActivity a;
    private String b;
    private String c;
    private ba d = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
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
            CreateBarActivity.c(this.a);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
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

    private String d() {
        String str;
        try {
            this.d = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/forum/create");
            this.d.e(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            ba baVar = this.d;
            str = this.a.s;
            baVar.a("vcode_md5", str);
            this.d.l();
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.a.m;
        progressBar.setVisibility(0);
    }
}
