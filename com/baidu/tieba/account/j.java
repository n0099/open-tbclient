package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1095a;
    private com.baidu.tieba.util.am b;

    private j(ActivationActivity activationActivity) {
        this.f1095a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(ActivationActivity activationActivity, e eVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.f1095a.l = null;
        progressBar = this.f1095a.e;
        progressBar.setVisibility(8);
        editText = this.f1095a.i;
        if (editText.length() == 6) {
            relativeLayout = this.f1095a.j;
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
            this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/getsmscode");
            com.baidu.tieba.util.am amVar = this.b;
            registData = this.f1095a.p;
            amVar.a("phonenum", registData.getPhone());
            this.b.l();
            if (this.b.c()) {
                z = true;
            }
        } catch (Exception e) {
            bd.b(getClass().getName(), "doInBackground", e.getMessage());
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
        super.a((j) bool);
        this.f1095a.l = null;
        progressBar = this.f1095a.e;
        progressBar.setVisibility(8);
        editText = this.f1095a.i;
        if (editText.length() == 6) {
            relativeLayout = this.f1095a.j;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.f1095a.a();
            return;
        }
        String i = this.b.i();
        if (i != null && i.length() > 0) {
            textView = this.f1095a.h;
            textView.setVisibility(0);
            textView2 = this.f1095a.h;
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
        progressBar = this.f1095a.e;
        progressBar.setVisibility(0);
        textView = this.f1095a.h;
        textView.setVisibility(4);
        textView2 = this.f1095a.h;
        textView2.setText((CharSequence) null);
        relativeLayout = this.f1095a.j;
        relativeLayout.setEnabled(false);
        super.b();
    }
}
