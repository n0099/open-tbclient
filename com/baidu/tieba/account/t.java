package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.data.RegistData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ ActivationActivity amw;

    private t(ActivationActivity activationActivity) {
        this.amw = activationActivity;
        this.AR = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(ActivationActivity activationActivity, t tVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.amw.amk = null;
        progressBar = this.amw.ame;
        progressBar.setVisibility(8);
        editText = this.amw.amh;
        if (editText.length() == 6) {
            relativeLayout = this.amw.ami;
            relativeLayout.setEnabled(true);
        }
        if (this.AR != null) {
            this.AR.dL();
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
            this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
            com.baidu.tbadk.core.util.ad adVar = this.AR;
            registData = this.amw.amn;
            adVar.o("phonenum", registData.getPhone());
            this.AR.ov();
            if (this.AR.oW().pW().ma()) {
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
        this.amw.amk = null;
        progressBar = this.amw.ame;
        progressBar.setVisibility(8);
        editText = this.amw.amh;
        if (editText.length() == 6) {
            relativeLayout = this.amw.ami;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.amw.Az();
            return;
        }
        String errorString = this.AR.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.amw.Uh;
            textView.setVisibility(0);
            textView2 = this.amw.Uh;
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
        progressBar = this.amw.ame;
        progressBar.setVisibility(0);
        textView = this.amw.Uh;
        textView.setVisibility(4);
        textView2 = this.amw.Uh;
        textView2.setText((CharSequence) null);
        relativeLayout = this.amw.ami;
        relativeLayout.setEnabled(false);
        super.onPreExecute();
    }
}
