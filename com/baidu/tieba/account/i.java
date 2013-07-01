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
    final /* synthetic */ ActivationActivity f669a;
    private com.baidu.tieba.util.r b;

    private i(ActivationActivity activationActivity) {
        this.f669a = activationActivity;
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
        this.f669a.n = null;
        progressBar = this.f669a.e;
        progressBar.setVisibility(8);
        editText = this.f669a.k;
        if (editText.length() == 6) {
            relativeLayout = this.f669a.l;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.h();
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
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/getsmscode");
            com.baidu.tieba.util.r rVar = this.b;
            registData = this.f669a.r;
            rVar.a("phonenum", registData.getPhone());
            this.b.j();
            if (this.b.c()) {
                z = true;
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f669a.n = null;
        progressBar = this.f669a.e;
        progressBar.setVisibility(8);
        editText = this.f669a.k;
        if (editText.length() == 6) {
            relativeLayout = this.f669a.l;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.f669a.b();
            return;
        }
        String g = this.b.g();
        if (g != null && g.length() > 0) {
            textView = this.f669a.j;
            textView.setVisibility(0);
            textView2 = this.f669a.j;
            textView2.setText(g);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        progressBar = this.f669a.e;
        progressBar.setVisibility(0);
        textView = this.f669a.j;
        textView.setVisibility(4);
        textView2 = this.f669a.j;
        textView2.setText((CharSequence) null);
        relativeLayout = this.f669a.l;
        relativeLayout.setEnabled(false);
        super.b();
    }
}
