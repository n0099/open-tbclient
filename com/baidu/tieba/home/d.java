package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends AsyncTask {
    final /* synthetic */ CreateBarActivity a;
    private com.baidu.tieba.c.t b;
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

    public void a() {
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
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/anti/vcode");
            this.b.a("fid", "0");
            this.b.a("pub_type", "0");
            this.b.a("fname", "");
            this.b.a("tid", "0");
            String i = this.b.i();
            if (this.b.b()) {
                com.baidu.tieba.a.aw awVar = new com.baidu.tieba.a.aw();
                awVar.a(i);
                if (awVar.b() == null || awVar.b().length() <= 0) {
                    return null;
                }
                this.a.u = awVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new com.baidu.tieba.c.t(awVar.b());
                return com.baidu.tieba.c.e.a(this.b.h());
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute(bitmap);
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        this.a.r = null;
        if (bitmap != null) {
            imageView = this.a.n;
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.a.u = null;
        progressBar = this.a.p;
        progressBar.setVisibility(0);
        imageView = this.a.n;
        imageView.setImageBitmap(null);
    }
}
