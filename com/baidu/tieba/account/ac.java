package com.baidu.tieba.account;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.a.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.lib.a.a {
    ArrayList a;
    final /* synthetic */ LoginActivity b;
    private String d;
    private com.baidu.tieba.d.t c = null;
    private String e = null;

    public ac(LoginActivity loginActivity, String str, ArrayList arrayList) {
        this.b = loginActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
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
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public com.baidu.tieba.c.af a(Object... objArr) {
        com.baidu.tieba.c.af afVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.d.t(this.d);
            this.c.a(this.a);
            this.e = this.c.i();
            if (this.e != null) {
                com.baidu.tieba.d.ae.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.b() || this.e == null) {
                return null;
            }
            afVar = new com.baidu.tieba.c.af();
            try {
                afVar.a(this.e);
                return afVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.d.ae.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return afVar;
            }
        } catch (Exception e3) {
            afVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.c.af afVar) {
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
        this.b.v();
        if (afVar != null) {
            this.b.R = afVar;
            this.b.q();
        } else if (this.c != null) {
            if ((!this.c.c() || this.c.d() != 5) && this.c.d() != 6) {
                textView2 = this.b.L;
                textView2.setVisibility(0);
                textView3 = this.b.L;
                textView3.setText(this.c.f());
                textView4 = this.b.M;
                textView4.setVisibility(8);
                this.b.r();
            } else {
                be beVar = new be();
                beVar.a(this.e);
                if (beVar.b() == null) {
                    textView5 = this.b.L;
                    textView5.setVisibility(0);
                    textView6 = this.b.L;
                    textView6.setText(this.c.f());
                    textView7 = this.b.M;
                    textView7.setVisibility(8);
                    this.b.r();
                } else {
                    this.b.l = beVar.a();
                    this.b.m = beVar.b();
                    LoginActivity loginActivity = this.b;
                    str = this.b.m;
                    loginActivity.c(str);
                    this.b.s();
                    LoginActivity loginActivity2 = this.b;
                    editText = this.b.s;
                    loginActivity2.j = editText.getText().toString();
                }
            }
        }
        this.b.Q = null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
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
        this.b.v();
    }
}
