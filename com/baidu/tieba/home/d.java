package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f925a;
    private com.baidu.tieba.util.r b;
    private volatile boolean c;

    private d(CreateBarActivity createBarActivity) {
        this.f925a = createBarActivity;
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
            this.b.h();
        }
        progressBar = this.f925a.p;
        progressBar.setVisibility(8);
        this.f925a.r = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/f/anti/vcode");
            this.b.a("fid", "0");
            this.b.a("pub_type", "0");
            this.b.a("fname", "");
            this.b.a("tid", "0");
            String j = this.b.j();
            if (this.b.c()) {
                com.baidu.tieba.data.be beVar = new com.baidu.tieba.data.be();
                beVar.a(j);
                if (beVar.b() == null || beVar.b().length() <= 0) {
                    return null;
                }
                this.f925a.u = beVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new com.baidu.tieba.util.r(beVar.b());
                return com.baidu.tieba.util.d.a(this.b.i());
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
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
        progressBar = this.f925a.p;
        progressBar.setVisibility(8);
        this.f925a.r = null;
        if (bitmap != null) {
            imageView = this.f925a.n;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        ImageView imageView;
        super.b();
        this.f925a.u = null;
        progressBar = this.f925a.p;
        progressBar.setVisibility(0);
        imageView = this.f925a.n;
        imageView.setImageBitmap(null);
    }
}
