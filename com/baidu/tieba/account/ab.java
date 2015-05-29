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
public class ab extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.aa OE;
    final /* synthetic */ ActivationActivity awV;

    private ab(ActivationActivity activationActivity) {
        this.awV = activationActivity;
        this.OE = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(ActivationActivity activationActivity, ab abVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.awV.awK = null;
        progressBar = this.awV.awE;
        progressBar.setVisibility(8);
        editText = this.awV.awH;
        if (editText.length() == 6) {
            relativeLayout = this.awV.awI;
            relativeLayout.setEnabled(true);
        }
        if (this.OE != null) {
            this.OE.gS();
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
            this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
            com.baidu.tbadk.core.util.aa aaVar = this.OE;
            registData = this.awV.awN;
            aaVar.o("phonenum", registData.getPhone());
            this.OE.sw();
            if (this.OE.sX().tT().qa()) {
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
        this.awV.awK = null;
        progressBar = this.awV.awE;
        progressBar.setVisibility(8);
        editText = this.awV.awH;
        if (editText.length() == 6) {
            relativeLayout = this.awV.awI;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.awV.Fd();
            return;
        }
        String errorString = this.OE.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.awV.afY;
            textView.setVisibility(0);
            textView2 = this.awV.afY;
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
        progressBar = this.awV.awE;
        progressBar.setVisibility(0);
        textView = this.awV.afY;
        textView.setVisibility(4);
        textView2 = this.awV.afY;
        textView2.setText((CharSequence) null);
        relativeLayout = this.awV.awI;
        relativeLayout.setEnabled(false);
        super.onPreExecute();
    }
}
