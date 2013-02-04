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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.a doInBackground(String... strArr) {
        String l;
        this.b = new com.baidu.tieba.c.t();
        if (this.d != null) {
            com.baidu.tieba.c.t tVar = this.b;
            String str = this.c;
            StringBuilder append = new StringBuilder(String.valueOf(this.d)).append('|');
            l = this.a.l();
            return com.baidu.tieba.a.a(tVar, str, append.append(l).toString());
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
        this.a.j = aVar;
        if (this.b != null) {
            this.a.m = this.b.f();
        }
        str = this.a.m;
        if (str == null) {
            this.a.m = this.a.getString(R.string.data_load_error);
        }
        this.b = null;
        this.a.b = null;
        long currentTimeMillis = 1000 - System.currentTimeMillis();
        j = this.a.l;
        long j2 = currentTimeMillis + j;
        if (j2 <= 0) {
            j2 = 0;
        }
        handler = this.a.n;
        runnable = this.a.o;
        handler.removeCallbacks(runnable);
        handler2 = this.a.n;
        runnable2 = this.a.o;
        handler2.postDelayed(runnable2, j2);
    }

    public boolean a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.b = null;
        return super.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.j = null;
        this.a.m = null;
        this.a.l = System.currentTimeMillis();
        this.a.a(0, this.a.getIntent().getStringExtra("uname"));
    }
}
