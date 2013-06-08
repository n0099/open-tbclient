package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.a.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.a.a {
    final /* synthetic */ CreateBarActivity a;
    private com.baidu.tieba.d.t b;
    private volatile boolean c;

    private d(CreateBarActivity createBarActivity) {
        this.a = createBarActivity;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, d dVar) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.g();
        }
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        this.a.r = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Bitmap a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/f/anti/vcode");
            this.b.a("fid", "0");
            this.b.a("pub_type", "0");
            this.b.a("fname", "");
            this.b.a("tid", "0");
            String i = this.b.i();
            if (this.b.b()) {
                bf bfVar = new bf();
                bfVar.a(i);
                if (bfVar.b() == null || bfVar.b().length() <= 0) {
                    return null;
                }
                this.a.u = bfVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new com.baidu.tieba.d.t(bfVar.b());
                return com.baidu.tieba.d.d.a(this.b.h());
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.a((Object) bitmap);
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        this.a.r = null;
        if (bitmap != null) {
            imageView = this.a.n;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        ImageView imageView;
        super.b();
        this.a.u = null;
        progressBar = this.a.p;
        progressBar.setVisibility(0);
        imageView = this.a.n;
        imageView.setImageBitmap(null);
    }
}
