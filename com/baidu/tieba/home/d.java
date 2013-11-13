package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CreateBarActivity f1448a;
    private com.baidu.tieba.util.ap b;
    private volatile boolean c;

    private d(CreateBarActivity createBarActivity) {
        this.f1448a = createBarActivity;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, a aVar) {
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
        progressBar = this.f1448a.n;
        progressBar.setVisibility(8);
        this.f1448a.p = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        try {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/f/anti/vcode");
            this.b.a("fid", SocialConstants.FALSE);
            this.b.a("pub_type", SocialConstants.FALSE);
            this.b.a("fname", "");
            this.b.a("tid", SocialConstants.FALSE);
            String j = this.b.j();
            if (this.b.c()) {
                com.baidu.tieba.data.be beVar = new com.baidu.tieba.data.be();
                beVar.a(j);
                if (beVar.b() == null || beVar.b().length() <= 0) {
                    return null;
                }
                this.f1448a.s = beVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new com.baidu.tieba.util.ap(beVar.b());
                return com.baidu.tieba.util.m.a(this.b.i());
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        progressBar = this.f1448a.n;
        progressBar.setVisibility(8);
        this.f1448a.p = null;
        if (bitmap != null) {
            imageView = this.f1448a.l;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        ImageView imageView;
        super.b();
        this.f1448a.s = null;
        progressBar = this.f1448a.n;
        progressBar.setVisibility(0);
        imageView = this.f1448a.l;
        imageView.setImageBitmap(null);
    }
}
