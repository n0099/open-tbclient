package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.aa Oi;
    final /* synthetic */ ActivationActivity avm;

    private aa(ActivationActivity activationActivity) {
        this.avm = activationActivity;
        this.Oi = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(ActivationActivity activationActivity, aa aaVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.avm.ava = null;
        progressBar = this.avm.auU;
        progressBar.setVisibility(8);
        editText = this.avm.auX;
        if (editText.length() == 6) {
            relativeLayout = this.avm.auY;
            relativeLayout.setEnabled(true);
        }
        if (this.Oi != null) {
            this.Oi.hh();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        RegistData registData;
        boolean z = false;
        try {
            this.Oi = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
            com.baidu.tbadk.core.util.aa aaVar = this.Oi;
            registData = this.avm.avd;
            aaVar.o("phonenum", registData.getPhone());
            this.Oi.rO();
            if (this.Oi.sp().tq().pv()) {
                z = true;
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        ProgressBar progressBar;
        EditText editText;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.onPostExecute(bool);
        this.avm.ava = null;
        progressBar = this.avm.auU;
        progressBar.setVisibility(8);
        editText = this.avm.auX;
        if (editText.length() == 6) {
            relativeLayout = this.avm.auY;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.avm.Ek();
            return;
        }
        String errorString = this.Oi.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.avm.aeO;
            textView.setVisibility(0);
            textView2 = this.avm.aeO;
            textView2.setText(errorString);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        progressBar = this.avm.auU;
        progressBar.setVisibility(0);
        textView = this.avm.aeO;
        textView.setVisibility(4);
        textView2 = this.avm.aeO;
        textView2.setText((CharSequence) null);
        relativeLayout = this.avm.auY;
        relativeLayout.setEnabled(false);
        super.onPreExecute();
    }
}
