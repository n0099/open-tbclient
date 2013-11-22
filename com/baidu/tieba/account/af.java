package com.baidu.tieba.account;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.bd;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Object, Integer, be> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f1032a;
    final /* synthetic */ LoginActivity b;
    private String d;
    private com.baidu.tieba.util.ap c = null;
    private String e = null;

    public af(LoginActivity loginActivity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.b = loginActivity;
        this.d = null;
        this.f1032a = null;
        this.d = str;
        this.f1032a = arrayList;
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
    public be a(Object... objArr) {
        be beVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.util.ap(this.d);
            this.c.a(this.f1032a);
            this.e = this.c.l();
            if (this.e != null) {
                bg.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.c() || this.e == null) {
                return null;
            }
            beVar = new be();
            try {
                beVar.a(this.e);
                return beVar;
            } catch (Exception e2) {
                e = e2;
                bg.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return beVar;
            }
        } catch (Exception e3) {
            beVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(be beVar) {
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
        if (beVar != null) {
            this.b.N = beVar;
            this.b.h();
        } else if (this.c != null) {
            if ((!this.c.d() || this.c.e() != 5) && this.c.e() != 6) {
                textView2 = this.b.G;
                textView2.setVisibility(0);
                textView3 = this.b.G;
                textView3.setText(this.c.i());
                textView4 = this.b.H;
                textView4.setVisibility(8);
                this.b.i();
            } else {
                bd bdVar = new bd();
                bdVar.a(this.e);
                if (bdVar.b() == null) {
                    textView5 = this.b.G;
                    textView5.setVisibility(0);
                    textView6 = this.b.G;
                    textView6.setText(this.c.i());
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
            this.c.j();
            this.c = null;
        }
        progressBar = this.b.w;
        progressBar.setVisibility(8);
        textView = this.b.I;
        textView.setText(R.string.account_login);
        this.b.m();
    }
}
