package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(String... strArr) {
        return d();
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
        super.a((u) bool2);
        this.a.l = null;
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        editText = this.a.i;
        if (editText.length() == 6) {
            relativeLayout = this.a.j;
            relativeLayout.setEnabled(true);
        }
        if (bool2.booleanValue()) {
            this.a.a();
            return;
        }
        String i = this.b.i();
        if (i == null || i.length() <= 0) {
            return;
        }
        textView = this.a.h;
        textView.setVisibility(0);
        textView2 = this.a.h;
        textView2.setText(i);
    }

    private u(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(ActivationActivity activationActivity, byte b) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.a.l = null;
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        editText = this.a.i;
        if (editText.length() == 6) {
            relativeLayout = this.a.j;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.j();
        }
        super.cancel(true);
    }

    private Boolean d() {
        RegistData registData;
        boolean z = false;
        try {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/getsmscode");
            com.baidu.tieba.util.ba baVar = this.b;
            registData = this.a.p;
            baVar.a("phonenum", registData.getPhone());
            this.b.l();
            if (this.b.c()) {
                z = true;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        progressBar = this.a.e;
        progressBar.setVisibility(0);
        textView = this.a.h;
        textView.setVisibility(4);
        textView2 = this.a.h;
        textView2.setText((CharSequence) null);
        relativeLayout = this.a.j;
        relativeLayout.setEnabled(false);
        super.b();
    }
}
