package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f1084a;
    private com.baidu.tieba.util.ap b;

    private j(ActivationActivity activationActivity) {
        this.f1084a = activationActivity;
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
        this.f1084a.l = null;
        progressBar = this.f1084a.e;
        progressBar.setVisibility(8);
        editText = this.f1084a.i;
        if (editText.length() == 6) {
            relativeLayout = this.f1084a.j;
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
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/s/getsmscode");
            com.baidu.tieba.util.ap apVar = this.b;
            registData = this.f1084a.p;
            apVar.a("phonenum", registData.getPhone());
            this.b.j();
            if (this.b.c()) {
                z = true;
            }
        } catch (Exception e) {
            bg.b(getClass().getName(), "doInBackground", e.getMessage());
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
        this.f1084a.l = null;
        progressBar = this.f1084a.e;
        progressBar.setVisibility(8);
        editText = this.f1084a.i;
        if (editText.length() == 6) {
            relativeLayout = this.f1084a.j;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.f1084a.a();
            return;
        }
        String g = this.b.g();
        if (g != null && g.length() > 0) {
            textView = this.f1084a.h;
            textView.setVisibility(0);
            textView2 = this.f1084a.h;
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
        progressBar = this.f1084a.e;
        progressBar.setVisibility(0);
        textView = this.f1084a.h;
        textView.setVisibility(4);
        textView2 = this.f1084a.h;
        textView2.setText((CharSequence) null);
        relativeLayout = this.f1084a.j;
        relativeLayout.setEnabled(false);
        super.b();
    }
}
