package com.baidu.tieba.account.login;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tieba.t;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, n> {
    final /* synthetic */ Login2Activity ayN;
    ArrayList<BasicNameValuePair> ayR;
    private String mUrl;
    private aa aaG = null;
    private String ayS = null;

    public m(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.ayN = login2Activity;
        this.mUrl = null;
        this.ayR = null;
        this.mUrl = str;
        this.ayR = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.ayN;
        InputMethodManager inputMethodManager = this.ayN.mInputManager;
        editText = this.ayN.ays;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.ayN;
        InputMethodManager inputMethodManager2 = this.ayN.mInputManager;
        editText2 = this.ayN.ayt;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.ayN.ayx;
        progressBar.setVisibility(0);
        textView = this.ayN.axu;
        textView.setVisibility(4);
        textView2 = this.ayN.ayH;
        textView2.setText(t.account_login_loading);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public n doInBackground(Object... objArr) {
        n nVar;
        Exception e;
        try {
            this.aaG = new aa(this.mUrl);
            this.aaG.n(this.ayR);
            this.ayS = this.aaG.sw();
            if (!this.aaG.sX().tT().qa() || this.ayS == null) {
                return null;
            }
            nVar = new n();
            try {
                nVar.parserJson(this.ayS);
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
        progressBar = this.ayN.ayx;
        progressBar.setVisibility(8);
        textView = this.ayN.ayH;
        textView.setText(t.account_login);
        this.ayN.FF();
        if (nVar != null) {
            this.ayN.ayL = nVar;
            this.ayN.uZ();
        } else if (this.aaG != null) {
            if ((!this.aaG.ta() || this.aaG.tb() != 5) && this.aaG.tb() != 6) {
                textView2 = this.ayN.axu;
                textView2.setVisibility(0);
                textView3 = this.ayN.axu;
                textView3.setText(this.aaG.getErrorString());
                textView4 = this.ayN.ayG;
                textView4.setVisibility(8);
                this.ayN.FB();
            } else {
                com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                lVar.parserJson(this.ayS);
                if (lVar.getVcode_pic_url() == null) {
                    textView5 = this.ayN.axu;
                    textView5.setVisibility(0);
                    textView6 = this.ayN.axu;
                    textView6.setText(this.aaG.getErrorString());
                    textView7 = this.ayN.ayG;
                    textView7.setVisibility(8);
                    this.ayN.FB();
                } else {
                    this.ayN.ayn = lVar.getVcode_md5();
                    this.ayN.mVcodeUrl = lVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.ayN;
                    str = this.ayN.mVcodeUrl;
                    login2Activity.fq(str);
                    this.ayN.FC();
                    Login2Activity login2Activity2 = this.ayN;
                    editText = this.ayN.ays;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.ayN.ayK = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        super.cancel(true);
        if (this.aaG != null) {
            this.aaG.gS();
            this.aaG = null;
        }
        progressBar = this.ayN.ayx;
        progressBar.setVisibility(8);
        textView = this.ayN.ayH;
        textView.setText(t.account_login);
        this.ayN.FF();
    }
}
