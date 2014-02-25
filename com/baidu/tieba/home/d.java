package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.bd;
import com.baidu.tieba.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ CreateBarActivity a;
    private ba b;
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

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.k();
        }
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.p = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        try {
            this.b = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/anti/vcode");
            this.b.a("fid", SocialConstants.FALSE);
            this.b.a("pub_type", SocialConstants.FALSE);
            this.b.a("fname", "");
            this.b.a("tid", SocialConstants.FALSE);
            String m = this.b.m();
            if (this.b.d()) {
                bd bdVar = new bd();
                bdVar.a(m);
                if (bdVar.b() == null || bdVar.b().length() <= 0) {
                    return null;
                }
                this.a.s = bdVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new ba(bdVar.b());
                return com.baidu.tieba.util.n.a(this.b.l());
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.a((d) bitmap);
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.p = null;
        if (bitmap != null) {
            imageView = this.a.l;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        ImageView imageView;
        super.b();
        this.a.s = null;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        imageView = this.a.l;
        imageView.setImageBitmap(null);
    }
}
