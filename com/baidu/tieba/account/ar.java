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
public class ar extends BdAsyncTask<Object, Integer, com.baidu.tieba.model.at> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ LoginActivity b;
    private String d;
    private com.baidu.tieba.util.ba c = null;
    private String e = null;

    public ar(LoginActivity loginActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = loginActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.model.at a(Object... objArr) {
        com.baidu.tieba.model.at atVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.ba(this.d);
            this.c.a(this.a);
            this.e = this.c.m();
            if (this.e != null) {
                com.baidu.adp.lib.util.f.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.d() || this.e == null) {
                return null;
            }
            atVar = new com.baidu.tieba.model.at();
            try {
                atVar.a(this.e);
                this.b.P = bt.a(a.a(atVar.a().getBDUSS()));
                return atVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return atVar;
            }
        } catch (Exception e3) {
            atVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.at atVar) {
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
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(R.string.account_login);
        this.b.m();
        if (atVar != null) {
            this.b.N = atVar;
            this.b.h();
        } else if (this.c != null) {
            if ((!this.c.e() || this.c.f() != 5) && this.c.f() != 6) {
                textView2 = this.b.G;
                textView2.setVisibility(0);
                textView3 = this.b.G;
                textView3.setText(this.c.j());
                textView4 = this.b.H;
                textView4.setVisibility(8);
                this.b.i();
            } else {
                com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
                bdVar.a(this.e);
                if (bdVar.b() == null) {
                    textView5 = this.b.G;
                    textView5.setVisibility(0);
                    textView6 = this.b.G;
                    textView6.setText(this.c.j());
                    textView7 = this.b.H;
                    textView7.setVisibility(8);
                    this.b.i();
                } else {
                    this.b.h = bdVar.a();
                    this.b.i = bdVar.b();
                    LoginActivity loginActivity = this.b;
                    str = this.b.i;
                    loginActivity.a(str);
                    this.b.j();
                    LoginActivity loginActivity2 = this.b;
                    editText = this.b.o;
                    loginActivity2.f = editText.getText().toString();
                }
            }
        }
        this.b.M = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.c != null) {
            this.c.k();
            this.c = null;
        }
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(R.string.account_login);
        this.b.m();
    }
}
