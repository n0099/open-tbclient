package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.os.Handler;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends AsyncTask {
    final /* synthetic */ ReLoginActivity a;
    private volatile com.baidu.tieba.c.t b = null;
    private String c;
    private String d;

    public ar(ReLoginActivity reLoginActivity, String str, String str2) {
        this.a = reLoginActivity;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.m = null;
        this.a.p = null;
        this.a.o = System.currentTimeMillis();
        this.a.a(0, this.a.getIntent().getStringExtra("uname"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.a doInBackground(String... strArr) {
        String n;
        this.b = new com.baidu.tieba.c.t();
        if (this.d != null) {
            com.baidu.tieba.c.t tVar = this.b;
            String str = this.c;
            StringBuilder append = new StringBuilder(String.valueOf(this.d)).append('|');
            n = this.a.n();
            return com.baidu.tieba.a.a(tVar, str, append.append(n).toString());
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.a aVar) {
        String str;
        long j;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        super.onPostExecute(aVar);
        this.a.m = aVar;
        if (this.b != null) {
            this.a.p = this.b.f();
        }
        str = this.a.p;
        if (str == null) {
            this.a.p = this.a.getString(R.string.data_load_error);
        }
        this.b = null;
        this.a.e = null;
        long currentTimeMillis = 1000 - System.currentTimeMillis();
        j = this.a.o;
        long j2 = currentTimeMillis + j;
        if (j2 <= 0) {
            j2 = 0;
        }
        handler = this.a.q;
        runnable = this.a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.a.q;
        runnable2 = this.a.r;
        handler2.postDelayed(runnable2, j2);
    }

    public boolean a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.e = null;
        return super.cancel(true);
    }
}
