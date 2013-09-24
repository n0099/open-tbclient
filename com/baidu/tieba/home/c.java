package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1212a;
    private String b;
    private String c;
    private com.baidu.tieba.util.z d = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.h();
        }
        progressBar = this.f1212a.o;
        progressBar.setVisibility(8);
        this.f1212a.q = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.f1212a = createBarActivity;
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
            this.d = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/forum/create");
            this.d.e(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            com.baidu.tieba.util.z zVar = this.d;
            str = this.f1212a.u;
            zVar.a("vcode_md5", str);
            this.d.j();
            return null;
        } catch (Exception e) {
            av.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        super.a((c) str);
        progressBar = this.f1212a.o;
        progressBar.setVisibility(8);
        this.f1212a.q = null;
        if (this.d.c()) {
            CreateBarSuccessActivity.a(this.f1212a, this.b);
            this.f1212a.finish();
            return;
        }
        this.f1212a.a(this.d.g());
        if (this.d.d()) {
            this.f1212a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.f1212a.o;
        progressBar.setVisibility(0);
    }
}
