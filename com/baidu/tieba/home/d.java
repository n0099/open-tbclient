package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1149a;
    private com.baidu.tieba.util.u b;
    private volatile boolean c;

    private d(CreateBarActivity createBarActivity) {
        this.f1149a = createBarActivity;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, d dVar) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.i();
        }
        progressBar = this.f1149a.p;
        progressBar.setVisibility(8);
        this.f1149a.r = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/f/anti/vcode");
            this.b.a("fid", "0");
            this.b.a("pub_type", "0");
            this.b.a("fname", "");
            this.b.a("tid", "0");
            String k = this.b.k();
            if (this.b.d()) {
                bq bqVar = new bq();
                bqVar.a(k);
                if (bqVar.b() == null || bqVar.b().length() <= 0) {
                    return null;
                }
                this.f1149a.u = bqVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new com.baidu.tieba.util.u(bqVar.b());
                return com.baidu.tieba.util.e.a(this.b.j());
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.a((Object) bitmap);
        progressBar = this.f1149a.p;
        progressBar.setVisibility(8);
        this.f1149a.r = null;
        if (bitmap != null) {
            imageView = this.f1149a.n;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        ImageView imageView;
        super.b();
        this.f1149a.u = null;
        progressBar = this.f1149a.p;
        progressBar.setVisibility(0);
        imageView = this.f1149a.n;
        imageView.setImageBitmap(null);
    }
}
