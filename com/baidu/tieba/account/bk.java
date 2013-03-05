package com.baidu.tieba.account;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends AsyncTask {
    ArrayList a;
    final /* synthetic */ RegisterActivity b;
    private String d;
    private com.baidu.tieba.c.t c = null;
    private String e = null;

    public bk(RegisterActivity registerActivity, String str, ArrayList arrayList) {
        this.b = registerActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        EditText editText;
        EditText editText2;
        EditText editText3;
        DialogInterface.OnCancelListener onCancelListener;
        RegisterActivity registerActivity = this.b;
        InputMethodManager inputMethodManager = this.b.c;
        editText = this.b.d;
        registerActivity.a(inputMethodManager, editText);
        RegisterActivity registerActivity2 = this.b;
        InputMethodManager inputMethodManager2 = this.b.c;
        editText2 = this.b.e;
        registerActivity2.a(inputMethodManager2, editText2);
        RegisterActivity registerActivity3 = this.b;
        InputMethodManager inputMethodManager3 = this.b.c;
        editText3 = this.b.f;
        registerActivity3.a(inputMethodManager3, editText3);
        RegisterActivity registerActivity4 = this.b;
        String string = this.b.getString(R.string.sending);
        onCancelListener = this.b.u;
        registerActivity4.a(string, onCancelListener);
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
        String str;
        String str2;
        int i;
        this.b.d();
        if (gVar != null) {
            this.b.t = gVar;
            this.b.m();
        } else if (this.c != null) {
            if ((this.c.c() && this.c.d() == 5) || this.c.d() == 6) {
                com.baidu.tieba.a.aw awVar = new com.baidu.tieba.a.aw();
                awVar.a(this.e);
                if (awVar.b() != null) {
                    RegisterActivity registerActivity = this.b;
                    str = this.b.n;
                    str2 = this.b.o;
                    i = this.b.q;
                    AccountVcodeActivity.a(registerActivity, str, str2, i, awVar.a(), awVar.b());
                } else {
                    this.b.b(this.c.f());
                    this.b.n();
                }
            } else {
                this.b.b(this.c.f());
                this.b.n();
            }
        }
        this.b.s = null;
    }

    public void a() {
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        super.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        if (this.c != null) {
            this.c.g();
        }
        super.onCancelled();
    }
}
