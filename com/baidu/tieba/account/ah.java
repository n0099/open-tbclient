package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends AsyncTask {
    ArrayList a;
    final /* synthetic */ LoginActivity b;
    private String d;
    private com.baidu.tieba.c.t c = null;
    private String e = null;

    public ah(LoginActivity loginActivity, String str, ArrayList arrayList) {
        this.b = loginActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.g doInBackground(Object... objArr) {
        com.baidu.tieba.b.g gVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            this.e = this.c.i();
            if (this.e != null) {
                com.baidu.tieba.c.ae.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.b() || this.e == null) {
                return null;
            }
            gVar = new com.baidu.tieba.b.g();
            try {
                gVar.a(this.e);
                return gVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return gVar;
            }
        } catch (Exception e3) {
            gVar = null;
            e = e3;
        }
    }

    public void a() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.x;
        progressBar.setVisibility(8);
        textView = this.b.J;
        textView.setText(R.string.account_login);
        this.b.r();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.g gVar) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        String str;
        EditText editText;
        progressBar = this.b.x;
        progressBar.setVisibility(8);
        textView = this.b.J;
        textView.setText(R.string.account_login);
        this.b.r();
        if (gVar != null) {
            this.b.N = gVar;
            this.b.m();
        } else if (this.c != null) {
            if ((this.c.c() && this.c.d() == 5) || this.c.d() == 6) {
                com.baidu.tieba.a.av avVar = new com.baidu.tieba.a.av();
                avVar.a(this.e);
                if (avVar.b() != null) {
                    this.b.h = avVar.a();
                    this.b.i = avVar.b();
                    LoginActivity loginActivity = this.b;
                    str = this.b.i;
                    loginActivity.c(str);
                    this.b.o();
                    LoginActivity loginActivity2 = this.b;
                    editText = this.b.o;
                    loginActivity2.f = editText.getText().toString();
                } else {
                    textView5 = this.b.H;
                    textView5.setVisibility(0);
                    textView6 = this.b.H;
                    textView6.setText(this.c.f());
                    textView7 = this.b.I;
                    textView7.setVisibility(8);
                    this.b.n();
                }
            } else {
                textView2 = this.b.H;
                textView2.setVisibility(0);
                textView3 = this.b.H;
                textView3.setText(this.c.f());
                textView4 = this.b.I;
                textView4.setVisibility(8);
                this.b.n();
            }
        }
        this.b.M = null;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        LoginActivity loginActivity = this.b;
        InputMethodManager inputMethodManager = this.b.b;
        editText = this.b.o;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.b;
        InputMethodManager inputMethodManager2 = this.b.b;
        editText2 = this.b.p;
        loginActivity2.a(inputMethodManager2, editText2);
        progressBar = this.b.x;
        progressBar.setVisibility(0);
        textView = this.b.H;
        textView.setVisibility(4);
        textView2 = this.b.J;
        textView2.setText(R.string.account_login_loading);
    }
}
