package com.baidu.tieba.home;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1435a;
    private String b;
    private String c;
    private com.baidu.tieba.util.ap d = null;

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.j();
        }
        progressBar = this.f1435a.m;
        progressBar.setVisibility(8);
        this.f1435a.o = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.f1435a = createBarActivity;
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
            this.d = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/c/forum/create");
            this.d.e(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            com.baidu.tieba.util.ap apVar = this.d;
            str = this.f1435a.s;
            apVar.a("vcode_md5", str);
            this.d.l();
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        super.a((c) str);
        progressBar = this.f1435a.m;
        progressBar.setVisibility(8);
        this.f1435a.o = null;
        if (this.d.c()) {
            CreateBarSuccessActivity.a(this.f1435a, this.b);
            this.f1435a.finish();
            return;
        }
        this.f1435a.showToast(this.d.i());
        if (this.d.d()) {
            this.f1435a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.f1435a.m;
        progressBar.setVisibility(0);
    }
}
