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
public class u extends BdAsyncTask<String, Integer, Boolean> {
    private com.baidu.tbadk.core.util.ad AO;
    final /* synthetic */ ActivationActivity ann;

    private u(ActivationActivity activationActivity) {
        this.ann = activationActivity;
        this.AO = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(ActivationActivity activationActivity, u uVar) {
        this(activationActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.ann.anb = null;
        progressBar = this.ann.amV;
        progressBar.setVisibility(8);
        editText = this.ann.amY;
        if (editText.length() == 6) {
            relativeLayout = this.ann.amZ;
            relativeLayout.setEnabled(true);
        }
        if (this.AO != null) {
            this.AO.dJ();
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
            this.AO = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
            com.baidu.tbadk.core.util.ad adVar = this.AO;
            registData = this.ann.ane;
            adVar.o("phonenum", registData.getPhone());
            this.AO.or();
            if (this.AO.oS().qa().lT()) {
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
        this.ann.anb = null;
        progressBar = this.ann.amV;
        progressBar.setVisibility(8);
        editText = this.ann.amY;
        if (editText.length() == 6) {
            relativeLayout = this.ann.amZ;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.ann.AU();
            return;
        }
        String errorString = this.AO.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.ann.UK;
            textView.setVisibility(0);
            textView2 = this.ann.UK;
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
        progressBar = this.ann.amV;
        progressBar.setVisibility(0);
        textView = this.ann.UK;
        textView.setVisibility(4);
        textView2 = this.ann.UK;
        textView2.setText((CharSequence) null);
        relativeLayout = this.ann.amZ;
        relativeLayout.setEnabled(false);
        super.onPreExecute();
    }
}
