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
    final /* synthetic */ Login2Activity ayM;
    ArrayList<BasicNameValuePair> ayQ;
    private String mUrl;
    private aa aaG = null;
    private String ayR = null;

    public m(Login2Activity login2Activity, String str, ArrayList<BasicNameValuePair> arrayList) {
        this.ayM = login2Activity;
        this.mUrl = null;
        this.ayQ = null;
        this.mUrl = str;
        this.ayQ = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        EditText editText;
        EditText editText2;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        Login2Activity login2Activity = this.ayM;
        InputMethodManager inputMethodManager = this.ayM.mInputManager;
        editText = this.ayM.ayr;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.ayM;
        InputMethodManager inputMethodManager2 = this.ayM.mInputManager;
        editText2 = this.ayM.ays;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        progressBar = this.ayM.ayw;
        progressBar.setVisibility(0);
        textView = this.ayM.axt;
        textView.setVisibility(4);
        textView2 = this.ayM.ayG;
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
            this.aaG.n(this.ayQ);
            this.ayR = this.aaG.sw();
            if (!this.aaG.sX().tT().qa() || this.ayR == null) {
                return null;
            }
            nVar = new n();
            try {
                nVar.parserJson(this.ayR);
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
        progressBar = this.ayM.ayw;
        progressBar.setVisibility(8);
        textView = this.ayM.ayG;
        textView.setText(t.account_login);
        this.ayM.FE();
        if (nVar != null) {
            this.ayM.ayK = nVar;
            this.ayM.uZ();
        } else if (this.aaG != null) {
            if ((!this.aaG.ta() || this.aaG.tb() != 5) && this.aaG.tb() != 6) {
                textView2 = this.ayM.axt;
                textView2.setVisibility(0);
                textView3 = this.ayM.axt;
                textView3.setText(this.aaG.getErrorString());
                textView4 = this.ayM.ayF;
                textView4.setVisibility(8);
                this.ayM.FA();
            } else {
                com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                lVar.parserJson(this.ayR);
                if (lVar.getVcode_pic_url() == null) {
                    textView5 = this.ayM.axt;
                    textView5.setVisibility(0);
                    textView6 = this.ayM.axt;
                    textView6.setText(this.aaG.getErrorString());
                    textView7 = this.ayM.ayF;
                    textView7.setVisibility(8);
                    this.ayM.FA();
                } else {
                    this.ayM.aym = lVar.getVcode_md5();
                    this.ayM.mVcodeUrl = lVar.getVcode_pic_url();
                    Login2Activity login2Activity = this.ayM;
                    str = this.ayM.mVcodeUrl;
                    login2Activity.fq(str);
                    this.ayM.FB();
                    Login2Activity login2Activity2 = this.ayM;
                    editText = this.ayM.ayr;
                    login2Activity2.mAccount = editText.getText().toString();
                }
            }
        }
        this.ayM.ayJ = null;
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
        progressBar = this.ayM.ayw;
        progressBar.setVisibility(8);
        textView = this.ayM.ayG;
        textView.setText(t.account_login);
        this.ayM.FE();
    }
}
