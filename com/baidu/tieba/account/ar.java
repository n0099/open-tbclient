package com.baidu.tieba.account;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ar extends BdAsyncTask<Object, Integer, com.baidu.tieba.model.at> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ LoginActivity b;
    private String d;
    private com.baidu.tieba.util.ba c = null;
    private String e = null;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.model.at a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.model.at atVar) {
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
        com.baidu.tieba.model.at atVar2 = atVar;
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(R.string.account_login);
        LoginActivity.f(this.b);
        if (atVar2 != null) {
            this.b.N = atVar2;
            LoginActivity.k(this.b);
        } else if (this.c != null) {
            if ((this.c.d() && this.c.e() == 5) || this.c.e() == 6) {
                com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
                bdVar.a(this.e);
                if (bdVar.b() != null) {
                    this.b.h = bdVar.a();
                    this.b.i = bdVar.b();
                    LoginActivity loginActivity = this.b;
                    str = this.b.i;
                    loginActivity.a(str);
                    LoginActivity.h(this.b);
                    LoginActivity loginActivity2 = this.b;
                    editText = this.b.o;
                    loginActivity2.f = editText.getText().toString();
                } else {
                    textView5 = this.b.G;
                    textView5.setVisibility(0);
                    textView6 = this.b.G;
                    textView6.setText(this.c.i());
                    textView7 = this.b.H;
                    textView7.setVisibility(8);
                    LoginActivity.j(this.b);
                }
            } else {
                textView2 = this.b.G;
                textView2.setVisibility(0);
                textView3 = this.b.G;
                textView3.setText(this.c.i());
                textView4 = this.b.H;
                textView4.setVisibility(8);
                LoginActivity.j(this.b);
            }
        }
        this.b.M = null;
    }

    public ar(LoginActivity loginActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = loginActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        LoginActivity loginActivity = this.b;
        InputMethodManager inputMethodManager = this.b.b;
        editText = this.b.o;
        loginActivity.HidenSoftKeyPad(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.b;
        InputMethodManager inputMethodManager2 = this.b.b;
        editText2 = this.b.p;
        loginActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.b.w;
        progressBar.setVisibility(0);
        textView = this.b.G;
        textView.setVisibility(4);
        textView2 = this.b.I;
        textView2.setText(R.string.account_login_loading);
    }

    private com.baidu.tieba.model.at d() {
        com.baidu.tieba.model.at atVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.ba(this.d);
            this.c.a(this.a);
            this.e = this.c.l();
            if (this.e != null) {
                com.baidu.adp.lib.util.e.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.c() || this.e == null) {
                return null;
            }
            atVar = new com.baidu.tieba.model.at();
            try {
                atVar.a(this.e);
                this.b.P = bt.a(a.a(atVar.a().getBDUSS()));
                return atVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.e.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return atVar;
            }
        } catch (Exception e3) {
            atVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.c != null) {
            this.c.j();
            this.c = null;
        }
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(R.string.account_login);
        LoginActivity.f(this.b);
    }
}
