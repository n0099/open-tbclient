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
public final class d extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ CreateBarActivity a;
    private ba b;
    private volatile boolean c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        Bitmap bitmap2 = bitmap;
        super.a((d) bitmap2);
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.p = null;
        if (bitmap2 != null) {
            imageView = this.a.l;
            imageView.setImageBitmap(bitmap2);
        }
    }

    private d(CreateBarActivity createBarActivity) {
        this.a = createBarActivity;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, byte b) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.j();
        }
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.p = null;
    }

    private Bitmap d() {
        try {
            this.b = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/anti/vcode");
            this.b.a("fid", SocialConstants.FALSE);
            this.b.a("pub_type", SocialConstants.FALSE);
            this.b.a("fname", "");
            this.b.a("tid", SocialConstants.FALSE);
            String l = this.b.l();
            if (this.b.c()) {
                bd bdVar = new bd();
                bdVar.a(l);
                if (bdVar.b() == null || bdVar.b().length() <= 0) {
                    return null;
                }
                this.a.s = bdVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new ba(bdVar.b());
                return com.baidu.tieba.util.n.a(this.b.k());
            }
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
        ImageView imageView;
        super.b();
        this.a.s = null;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        imageView = this.a.l;
        imageView.setImageBitmap(null);
    }
}
