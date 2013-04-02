package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends AsyncTask {
    BasicNameValuePair a;
    final /* synthetic */ SearchActivity b;
    private com.baidu.tieba.c.t c = null;
    private String d;

    public at(SearchActivity searchActivity, String str, BasicNameValuePair basicNameValuePair, boolean z) {
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
    public com.baidu.tieba.b.x doInBackground(Object... objArr) {
        com.baidu.tieba.b.x xVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (!this.c.b() || i == null) {
                return null;
            }
            xVar = new com.baidu.tieba.b.x();
            try {
                xVar.a(i);
                return xVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return xVar;
            }
        } catch (Exception e3) {
            xVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.x xVar) {
        ProgressBar progressBar;
        progressBar = this.b.p;
        progressBar.setVisibility(8);
        if (xVar != null) {
            this.b.t = xVar;
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
