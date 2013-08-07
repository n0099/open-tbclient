package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f880a;
    private com.baidu.tieba.util.u b;

    private i(ActivationActivity activationActivity) {
        this.f880a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(ActivationActivity activationActivity, i iVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.f880a.n = null;
        progressBar = this.f880a.e;
        progressBar.setVisibility(8);
        editText = this.f880a.k;
        if (editText.length() == 6) {
            relativeLayout = this.f880a.l;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.i();
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
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/getsmscode");
            com.baidu.tieba.util.u uVar = this.b;
            registData = this.f880a.r;
            uVar.a("phonenum", registData.getPhone());
            this.b.k();
            if (this.b.d()) {
                z = true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
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
        super.a((Object) bool);
        this.f880a.n = null;
        progressBar = this.f880a.e;
        progressBar.setVisibility(8);
        editText = this.f880a.k;
        if (editText.length() == 6) {
            relativeLayout = this.f880a.l;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.f880a.b();
            return;
        }
        String h = this.b.h();
        if (h != null && h.length() > 0) {
            textView = this.f880a.j;
            textView.setVisibility(0);
            textView2 = this.f880a.j;
            textView2.setText(h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        progressBar = this.f880a.e;
        progressBar.setVisibility(0);
        textView = this.f880a.j;
        textView.setVisibility(4);
        textView2 = this.f880a.j;
        textView2.setText((CharSequence) null);
        relativeLayout = this.f880a.l;
        relativeLayout.setEnabled(false);
        super.b();
    }
}
