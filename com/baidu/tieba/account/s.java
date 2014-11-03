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
public class s extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ ActivationActivity afg;
    private com.baidu.tbadk.core.util.ac mNetWork;

    private s(ActivationActivity activationActivity) {
        this.afg = activationActivity;
        this.mNetWork = null;
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
        this.afg.aeT = null;
        progressBar = this.afg.aeN;
        progressBar.setVisibility(8);
        editText = this.afg.aeQ;
        if (editText.length() == 6) {
            relativeLayout = this.afg.aeR;
            relativeLayout.setEnabled(true);
        }
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public Boolean doInBackground(String... strArr) {
        RegistData registData;
        boolean z = false;
        try {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
            com.baidu.tbadk.core.util.ac acVar = this.mNetWork;
            registData = this.afg.aeX;
            acVar.k("phonenum", registData.getPhone());
            this.mNetWork.lA();
            if (this.mNetWork.mc().nb().jq()) {
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
        this.afg.aeT = null;
        progressBar = this.afg.aeN;
        progressBar.setVisibility(8);
        editText = this.afg.aeQ;
        if (editText.length() == 6) {
            relativeLayout = this.afg.aeR;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.afg.xg();
            return;
        }
        String errorString = this.mNetWork.getErrorString();
        if (errorString != null && errorString.length() > 0) {
            textView = this.afg.Ov;
            textView.setVisibility(0);
            textView2 = this.afg.Ov;
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
        progressBar = this.afg.aeN;
        progressBar.setVisibility(0);
        textView = this.afg.Ov;
        textView.setVisibility(4);
        textView2 = this.afg.Ov;
        textView2.setText((CharSequence) null);
        relativeLayout = this.afg.aeR;
        relativeLayout.setEnabled(false);
        super.onPreExecute();
    }
}
