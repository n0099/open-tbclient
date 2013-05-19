package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.d.t b;

    private i(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(ActivationActivity activationActivity, i iVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.a.n = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        editText = this.a.k;
        if (editText.length() == 6) {
            relativeLayout = this.a.l;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(String... strArr) {
        com.baidu.tieba.a.at atVar;
        boolean z = false;
        try {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/getsmscode");
            com.baidu.tieba.d.t tVar = this.b;
            atVar = this.a.r;
            tVar.a("phonenum", atVar.c());
            this.b.i();
            if (this.b.b()) {
                z = true;
            }
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        ProgressBar progressBar;
        EditText editText;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((Object) bool);
        this.a.n = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        editText = this.a.k;
        if (editText.length() == 6) {
            relativeLayout = this.a.l;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.a.b();
            return;
        }
        String f = this.b.f();
        if (f != null && f.length() > 0) {
            textView = this.a.j;
            textView.setVisibility(0);
            textView2 = this.a.j;
            textView2.setText(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
        textView = this.a.j;
        textView.setVisibility(4);
        textView2 = this.a.j;
        textView2.setText((CharSequence) null);
        relativeLayout = this.a.l;
        relativeLayout.setEnabled(false);
        super.b();
    }
}
