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

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        LoginActivity loginActivity = this.b;
        InputMethodManager inputMethodManager = this.b.f;
        editText = this.b.s;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.b;
        InputMethodManager inputMethodManager2 = this.b.f;
        editText2 = this.b.t;
        loginActivity2.a(inputMethodManager2, editText2);
        progressBar = this.b.B;
        progressBar.setVisibility(0);
        textView = this.b.L;
        textView.setVisibility(4);
        textView2 = this.b.N;
        textView2.setText(R.string.account_login_loading);
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
                com.baidu.tieba.c.ag.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
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
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        String str;
        EditText editText;
        progressBar = this.b.B;
        progressBar.setVisibility(8);
        textView = this.b.N;
        textView.setText(R.string.account_login);
        this.b.u();
        if (gVar != null) {
            this.b.R = gVar;
            this.b.p();
        } else if (this.c != null) {
            if ((!this.c.c() || this.c.d() != 5) && this.c.d() != 6) {
                textView2 = this.b.L;
                textView2.setVisibility(0);
                textView3 = this.b.L;
                textView3.setText(this.c.f());
                textView4 = this.b.M;
                textView4.setVisibility(8);
                this.b.q();
            } else {
                com.baidu.tieba.a.aw awVar = new com.baidu.tieba.a.aw();
                awVar.a(this.e);
                if (awVar.b() == null) {
                    textView5 = this.b.L;
                    textView5.setVisibility(0);
                    textView6 = this.b.L;
                    textView6.setText(this.c.f());
                    textView7 = this.b.M;
                    textView7.setVisibility(8);
                    this.b.q();
                } else {
                    this.b.l = awVar.a();
                    this.b.m = awVar.b();
                    LoginActivity loginActivity = this.b;
                    str = this.b.m;
                    loginActivity.c(str);
                    this.b.r();
                    LoginActivity loginActivity2 = this.b;
                    editText = this.b.s;
                    loginActivity2.j = editText.getText().toString();
                }
            }
        }
        this.b.Q = null;
    }

    public void a() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.B;
        progressBar.setVisibility(8);
        textView = this.b.N;
        textView.setText(R.string.account_login);
        this.b.u();
    }
}
