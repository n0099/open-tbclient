package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends AsyncTask {
    BasicNameValuePair a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.c.t c = null;
    private String d;

    public an(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = basicNameValuePair;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.s doInBackground(Object... objArr) {
        com.baidu.tieba.b.s sVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (!this.c.b() || i == null) {
                return null;
            }
            sVar = new com.baidu.tieba.b.s();
            try {
                sVar.a(i);
                return sVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return sVar;
            }
        } catch (Exception e3) {
            sVar = null;
            e = e3;
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.s sVar) {
        ProgressBar progressBar;
        progressBar = this.b.l;
        progressBar.setVisibility(8);
        if (sVar != null) {
            this.b.p = sVar;
            this.b.m();
        }
        this.b.q = null;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.b.l;
        progressBar.setVisibility(0);
        textView = this.b.o;
        textView.setVisibility(8);
    }
}
