package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.util.an b;

    private t(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(ActivationActivity activationActivity, o oVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        RegistData registData;
        boolean z = false;
        try {
            this.b = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/s/getsmscode");
            com.baidu.tieba.util.an anVar = this.b;
            registData = this.a.p;
            anVar.a("phonenum", registData.getPhone());
            this.b.l();
            if (this.b.c()) {
                z = true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        ProgressBar progressBar;
        EditText editText;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.a((t) bool);
        this.a.l = null;
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        editText = this.a.i;
        if (editText.length() == 6) {
            relativeLayout = this.a.j;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.a.a();
            return;
        }
        String i = this.b.i();
        if (i != null && i.length() > 0) {
            textView = this.a.h;
            textView.setVisibility(0);
            textView2 = this.a.h;
            textView2.setText(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
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
