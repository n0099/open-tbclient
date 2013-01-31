package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends AsyncTask {
    final /* synthetic */ Register2Activity a;
    private com.baidu.tieba.c.t b = null;
    private String c;

    public bb(Register2Activity register2Activity, String str) {
        this.a = register2Activity;
        this.c = null;
        this.c = str;
    }

    public void a() {
        ProgressBar progressBar;
        this.a.Q = null;
        progressBar = this.a.I;
        progressBar.setVisibility(8);
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ImageView imageView;
        ProgressBar progressBar;
        imageView = this.a.J;
        imageView.setImageBitmap(null);
        progressBar = this.a.I;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        this.b = new com.baidu.tieba.c.t(this.c);
        return com.baidu.tieba.c.e.a(this.b.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute(bitmap);
        this.a.Q = null;
        progressBar = this.a.I;
        progressBar.setVisibility(8);
        imageView = this.a.J;
        imageView.setImageBitmap(bitmap);
    }
}
