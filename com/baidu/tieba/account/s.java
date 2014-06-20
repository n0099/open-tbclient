package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ ActivationActivity a;
    private an b;

    private s(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(ActivationActivity activationActivity, s sVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        RegistData registData;
        boolean z = false;
        try {
            this.b = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
            an anVar = this.b;
            registData = this.a.q;
            anVar.a("phonenum", registData.getPhone());
            this.b.i();
            if (this.b.a().b().b()) {
                z = true;
            }
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
        }
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        ProgressBar progressBar;
        EditText editText;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.onPostExecute(bool);
        this.a.m = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        editText = this.a.j;
        if (editText.length() == 6) {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.a.a();
            return;
        }
        String f = this.b.f();
        if (f != null && f.length() > 0) {
            textView = this.a.i;
            textView.setVisibility(0);
            textView2 = this.a.i;
            textView2.setText(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
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
        super.onPreExecute();
    }
}
