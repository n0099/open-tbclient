package com.baidu.tieba.account.login;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.y;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Object, Integer, n> {
    final /* synthetic */ Login2Activity awY;
    ArrayList<BasicNameValuePair> axb;
    private String mUrl;
    private aa ZD = null;
    private String axc = null;

    public l(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.awY = login2Activity;
        this.mUrl = null;
        this.axb = null;
        this.mUrl = str;
        this.axb = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.awY;
        InputMethodManager inputMethodManager = this.awY.mInputManager;
        editText = this.awY.awD;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.awY;
        InputMethodManager inputMethodManager2 = this.awY.mInputManager;
        editText2 = this.awY.awE;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.awY.awI;
        progressBar.setVisibility(0);
        textView = this.awY.avG;
        textView.setVisibility(4);
        textView2 = this.awY.awS;
        textView2.setText(y.account_login_loading);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public n doInBackground(Object... objArr) {
        n nVar;
        Exception e;
        try {
            this.ZD = new aa(this.mUrl);
            this.ZD.o(this.axb);
            this.axc = this.ZD.rO();
            if (!this.ZD.sp().tq().pv() || this.axc == null) {
                return null;
            }
            nVar = new n();
            try {
                nVar.parserJson(this.axc);
                return nVar;
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return nVar;
            }
        } catch (Exception e3) {
            nVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(n nVar) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        String str;
        EditText editText;
        progressBar = this.awY.awI;
        progressBar.setVisibility(8);
        textView = this.awY.awS;
        textView.setText(y.account_login);
        this.awY.EG();
        if (nVar != null) {
            this.awY.awW = nVar;
            this.awY.uq();
        } else if (this.ZD != null) {
            if ((!this.ZD.ss() || this.ZD.st() != 5) && this.ZD.st() != 6) {
                textView2 = this.awY.avG;
                textView2.setVisibility(0);
                textView3 = this.awY.avG;
                textView3.setText(this.ZD.getErrorString());
                textView4 = this.awY.awR;
                textView4.setVisibility(8);
                this.awY.EC();
            } else {
                com.baidu.tbadk.coreExtra.data.k kVar = new com.baidu.tbadk.coreExtra.data.k();
                kVar.parserJson(this.axc);
                if (kVar.getVcode_pic_url() == null) {
                    textView5 = this.awY.avG;
                    textView5.setVisibility(0);
                    textView6 = this.awY.avG;
                    textView6.setText(this.ZD.getErrorString());
                    textView7 = this.awY.awR;
                    textView7.setVisibility(8);
                    this.awY.EC();
                } else {
                    this.awY.awy = kVar.getVcode_md5();
                    this.awY.mVcodeUrl = kVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.awY;
                    str = this.awY.mVcodeUrl;
                    login2Activity.eS(str);
                    this.awY.ED();
                    Login2Activity login2Activity2 = this.awY;
                    editText = this.awY.awD;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.awY.awV = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.ZD != null) {
            this.ZD.hh();
            this.ZD = null;
        }
        progressBar = this.awY.awI;
        progressBar.setVisibility(8);
        textView = this.awY.awS;
        textView.setText(y.account_login);
        this.awY.EG();
    }
}
