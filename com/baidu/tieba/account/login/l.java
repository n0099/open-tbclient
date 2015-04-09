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
    final /* synthetic */ Login2Activity axg;
    ArrayList<BasicNameValuePair> axj;
    private String mUrl;
    private aa ZF = null;
    private String axk = null;

    public l(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.axg = login2Activity;
        this.mUrl = null;
        this.axj = null;
        this.mUrl = str;
        this.axj = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.axg;
        InputMethodManager inputMethodManager = this.axg.mInputManager;
        editText = this.axg.awL;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.axg;
        InputMethodManager inputMethodManager2 = this.axg.mInputManager;
        editText2 = this.axg.awM;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.axg.awQ;
        progressBar.setVisibility(0);
        textView = this.axg.avO;
        textView.setVisibility(4);
        textView2 = this.axg.axa;
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
            this.ZF = new aa(this.mUrl);
            this.ZF.o(this.axj);
            this.axk = this.ZF.rO();
            if (!this.ZF.sp().tq().pv() || this.axk == null) {
                return null;
            }
            nVar = new n();
            try {
                nVar.parserJson(this.axk);
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
        progressBar = this.axg.awQ;
        progressBar.setVisibility(8);
        textView = this.axg.axa;
        textView.setText(y.account_login);
        this.axg.EM();
        if (nVar != null) {
            this.axg.axe = nVar;
            this.axg.uq();
        } else if (this.ZF != null) {
            if ((!this.ZF.ss() || this.ZF.st() != 5) && this.ZF.st() != 6) {
                textView2 = this.axg.avO;
                textView2.setVisibility(0);
                textView3 = this.axg.avO;
                textView3.setText(this.ZF.getErrorString());
                textView4 = this.axg.awZ;
                textView4.setVisibility(8);
                this.axg.EI();
            } else {
                com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                lVar.parserJson(this.axk);
                if (lVar.getVcode_pic_url() == null) {
                    textView5 = this.axg.avO;
                    textView5.setVisibility(0);
                    textView6 = this.axg.avO;
                    textView6.setText(this.ZF.getErrorString());
                    textView7 = this.axg.awZ;
                    textView7.setVisibility(8);
                    this.axg.EI();
                } else {
                    this.axg.awG = lVar.getVcode_md5();
                    this.axg.mVcodeUrl = lVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.axg;
                    str = this.axg.mVcodeUrl;
                    login2Activity.eV(str);
                    this.axg.EJ();
                    Login2Activity login2Activity2 = this.axg;
                    editText = this.axg.awL;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.axg.axd = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.ZF != null) {
            this.ZF.hh();
            this.ZF = null;
        }
        progressBar = this.axg.awQ;
        progressBar.setVisibility(8);
        textView = this.axg.axa;
        textView.setText(y.account_login);
        this.axg.EM();
    }
}
