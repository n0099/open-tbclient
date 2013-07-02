package com.baidu.tieba.account;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask {
    ArrayList a;
    final /* synthetic */ LoginActivity b;
    private String d;
    private com.baidu.tieba.util.r c = null;
    private String e = null;

    public ac(LoginActivity loginActivity, String str, ArrayList arrayList) {
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
        InputMethodManager inputMethodManager = this.b.d;
        editText = this.b.s;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.b;
        InputMethodManager inputMethodManager2 = this.b.d;
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.model.al a(Object... objArr) {
        com.baidu.tieba.model.al alVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.r(this.d);
            this.c.a(this.a);
            this.e = this.c.j();
            if (this.e != null) {
                com.baidu.tieba.util.z.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.c() || this.e == null) {
                return null;
            }
            alVar = new com.baidu.tieba.model.al();
            try {
                alVar.a(this.e);
                return alVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return alVar;
            }
        } catch (Exception e3) {
            alVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.al alVar) {
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
        if (alVar != null) {
            this.b.R = alVar;
            this.b.q();
        } else if (this.c != null) {
            if ((!this.c.d() || this.c.e() != 5) && this.c.e() != 6) {
                textView2 = this.b.L;
                textView2.setVisibility(0);
                textView3 = this.b.L;
                textView3.setText(this.c.g());
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
                    textView6.setText(this.c.g());
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

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.c != null) {
            this.c.h();
            this.c = null;
        }
        progressBar = this.b.B;
        progressBar.setVisibility(8);
        textView = this.b.N;
        textView.setText(R.string.account_login);
        this.b.v();
    }
}
