package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends AsyncTask {
    BasicNameValuePair a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.c.t c = null;
    private String d;

    public aw(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
        this.b = searchActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = basicNameValuePair;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        FrameLayout frameLayout;
        progressBar = this.b.p;
        progressBar.setVisibility(0);
        textView = this.b.s;
        textView.setVisibility(8);
        frameLayout = this.b.j;
        frameLayout.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.w doInBackground(Object... objArr) {
        com.baidu.tieba.b.w wVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (!this.c.b() || i == null) {
                return null;
            }
            wVar = new com.baidu.tieba.b.w();
            try {
                wVar.a(i);
                return wVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return wVar;
            }
        } catch (Exception e3) {
            wVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.w wVar) {
        ProgressBar progressBar;
        progressBar = this.b.p;
        progressBar.setVisibility(8);
        if (wVar != null) {
            this.b.t = wVar;
            this.b.q();
        }
        this.b.v = null;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.p;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
