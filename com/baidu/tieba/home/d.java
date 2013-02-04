package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.a.av;
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
                av avVar = new av();
                avVar.a(i);
                if (avVar.b() == null || avVar.b().length() <= 0) {
                    return null;
                }
                this.a.p = avVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new com.baidu.tieba.c.t(avVar.b());
                return com.baidu.tieba.c.e.a(this.b.h());
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    public void a() {
        ProgressBar progressBar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.g();
        }
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        this.a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute(bitmap);
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        this.a.m = null;
        if (bitmap != null) {
            imageView = this.a.i;
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.a.p = null;
        progressBar = this.a.k;
        progressBar.setVisibility(0);
        imageView = this.a.i;
        imageView.setImageBitmap(null);
    }
}
