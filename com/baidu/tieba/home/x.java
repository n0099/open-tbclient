package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends AsyncTask {
    ArrayList a;
    final /* synthetic */ HomeActivity b;
    private com.baidu.tieba.c.t c = null;
    private String d;

    public x(HomeActivity homeActivity, String str, ArrayList arrayList) {
        this.b = homeActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.b.k;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.g doInBackground(Object... objArr) {
        com.baidu.tieba.b.g gVar;
        Exception e;
        Boolean bool;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            String i = this.c.i();
            if (!this.c.b() || i == null) {
                return null;
            }
            gVar = new com.baidu.tieba.b.g();
            try {
                gVar.a(i);
                if (gVar.a()) {
                    this.b.t = Boolean.valueOf(gVar.b() == 1);
                    bool = this.b.t;
                    if (bool.booleanValue()) {
                        com.baidu.tieba.c.k.d(i);
                    } else {
                        com.baidu.tieba.c.k.a(i, "0");
                    }
                } else {
                    gVar = null;
                }
                return gVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return gVar;
            }
        } catch (Exception e3) {
            gVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.g gVar) {
        ProgressBar progressBar;
        progressBar = this.b.k;
        progressBar.setVisibility(8);
        if (gVar != null) {
            this.b.n = gVar;
            TiebaApplication.b().g(false);
            this.b.n();
        } else if (this.c != null) {
            this.b.b(this.c.f());
        }
        this.b.m = null;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
