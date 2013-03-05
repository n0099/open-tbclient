package com.baidu.tieba.account;

import android.graphics.Bitmap;
import android.os.AsyncTask;
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

    public void a() {
        LoginActivity.a(this.b, (ag) null);
        if (this.a != null) {
            this.a.g();
            this.a = null;
        }
        this.c = true;
        super.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        LoginActivity.l(this.b).setImageBitmap(null);
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        LoginActivity.a(this.b, (ag) null);
        if (bitmap != null) {
            LoginActivity.l(this.b).setImageBitmap(bitmap);
        } else {
            LoginActivity.l(this.b).setImageResource(R.drawable.background);
        }
        LoginActivity.m(this.b).setVisibility(8);
        super.onPostExecute(bitmap);
    }
}
