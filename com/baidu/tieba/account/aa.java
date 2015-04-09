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
    private com.baidu.tbadk.core.util.aa Ok;
    final /* synthetic */ ActivationActivity avu;

    private aa(ActivationActivity activationActivity) {
        this.avu = activationActivity;
        this.Ok = null;
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
        this.avu.avi = null;
        progressBar = this.avu.avc;
        progressBar.setVisibility(8);
        editText = this.avu.avf;
        if (editText.length() == 6) {
            relativeLayout = this.avu.avg;
            relativeLayout.setEnabled(true);
        }
        if (this.Ok != null) {
            this.Ok.hh();
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
            this.Ok = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
            com.baidu.tbadk.core.util.aa aaVar = this.Ok;
            registData = this.avu.avl;
            aaVar.o("phonenum", registData.getPhone());
            this.Ok.rO();
            if (this.Ok.sp().tq().pv()) {
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
        this.avu.avi = null;
        progressBar = this.avu.avc;
        progressBar.setVisibility(8);
        editText = this.avu.avf;
        if (editText.length() == 6) {
            relativeLayout = this.avu.avg;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.avu.Eq();
            return;
        }
        String errorString = this.Ok.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.avu.aeW;
            textView.setVisibility(0);
            textView2 = this.avu.aeW;
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
        progressBar = this.avu.avc;
        progressBar.setVisibility(0);
        textView = this.avu.aeW;
        textView.setVisibility(4);
        textView2 = this.avu.aeW;
        textView2.setText((CharSequence) null);
        relativeLayout = this.avu.avg;
        relativeLayout.setEnabled(false);
        super.onPreExecute();
    }
}
