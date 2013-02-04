package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends AsyncTask {
    com.baidu.tieba.c.t a;
    final /* synthetic */ LoginActivity b;
    private volatile boolean c;

    private ag(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.a = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(LoginActivity loginActivity, ag agVar) {
        this(loginActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null || str.length() <= 0 || this.c) {
            return null;
        }
        this.a = new com.baidu.tieba.c.t(str);
        return com.baidu.tieba.c.e.a(this.a.h());
    }

    public void a() {
        this.b.O = null;
        if (this.a != null) {
            this.a.g();
            this.a = null;
        }
        this.c = true;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        ProgressBar progressBar;
        ImageView imageView2;
        this.b.O = null;
        if (bitmap != null) {
            imageView2 = this.b.t;
            imageView2.setImageBitmap(bitmap);
        } else {
            imageView = this.b.t;
            imageView.setImageResource(R.drawable.background);
        }
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        super.onPostExecute(bitmap);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ImageView imageView;
        imageView = this.b.t;
        imageView.setImageBitmap(null);
    }
}
