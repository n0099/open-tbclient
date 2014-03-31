package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Boolean a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        ProgressBar progressBar;
        EditText editText;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        Boolean bool2 = bool;
        super.a((s) bool2);
        this.a.m = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        editText = this.a.j;
        if (editText.length() == 6) {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(true);
        }
        if (bool2.booleanValue()) {
            this.a.a();
            return;
        }
        String f = this.b.f();
        if (f == null || f.length() <= 0) {
            return;
        }
        textView = this.a.i;
        textView.setVisibility(0);
        textView2 = this.a.i;
        textView2.setText(f);
    }

    private s(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(ActivationActivity activationActivity, byte b) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.a.m = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        editText = this.a.j;
        if (editText.length() == 6) {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    private Boolean a() {
        RegistData registData;
        boolean z = false;
        try {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/getsmscode");
            com.baidu.tbadk.core.util.ak akVar = this.b;
            registData = this.a.q;
            akVar.a("phonenum", registData.getPhone());
            this.b.i();
            if (this.b.a().b().b()) {
                z = true;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        progressBar = this.a.f;
        progressBar.setVisibility(0);
        textView = this.a.i;
        textView.setVisibility(4);
        textView2 = this.a.i;
        textView2.setText((CharSequence) null);
        relativeLayout = this.a.k;
        relativeLayout.setEnabled(false);
        super.c();
    }
}
