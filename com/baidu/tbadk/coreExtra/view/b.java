package com.baidu.tbadk.coreExtra.view;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private Activity beD;
    private Drawable fqe;
    private Drawable fqf;
    private TextView fqg;
    private View fqh;
    private View fqi;
    private View fqj;
    private a.InterfaceC0584a fql;
    private int size;
    private View fpN = null;
    private Dialog fpO = null;
    private EditText fpP = null;
    private RadioGroup fpQ = null;
    private RadioGroup fpR = null;
    private CompoundButton.OnCheckedChangeListener fpS = null;
    private RadioButton fpT = null;
    private RadioButton fpU = null;
    private RadioButton fpV = null;
    private TextView fpW = null;
    private C0600b fpX = null;
    private TextView fpY = null;
    private TextView bTi = null;
    private ProgressBar fpZ = null;
    private TextView fqa = null;
    private AccountData fqb = null;
    private a fqc = null;
    private a fqd = null;
    private boolean fqk = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.beD = null;
        this.fqe = null;
        this.fqf = null;
        this.size = 0;
        this.beD = activity;
        this.fqe = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.fqf = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.beD.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.fqe.setBounds(0, 0, this.size, this.size);
        this.fqf.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0584a interfaceC0584a) {
        this.fql = interfaceC0584a;
    }

    public void setAccountData(AccountData accountData) {
        this.fqb = accountData;
    }

    public void a(a aVar) {
        this.fqc = aVar;
    }

    public void b(a aVar) {
        this.fqd = aVar;
    }

    public void bAD() {
        rS(0);
    }

    public void rS(int i) {
        if (this.fpO == null) {
            this.fpN = LayoutInflater.from(this.beD).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.fqg = (TextView) this.fpN.findViewById(R.id.tip_info);
            this.fqh = this.fpN.findViewById(R.id.divider_under_account);
            this.fqi = this.fpN.findViewById(R.id.divider_under_radiongroup);
            this.fqj = this.fpN.findViewById(R.id.divider_with_yes_no_button);
            this.fpP = (EditText) this.fpN.findViewById(R.id.account);
            this.fpP.setHint(this.beD.getString(R.string.hint_tip_input_name));
            this.fpW = (TextView) this.fpN.findViewById(R.id.back);
            this.fpW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bAH();
                    b.this.bAF();
                }
            });
            this.bTi = (TextView) this.fpN.findViewById(R.id.confirm);
            this.bTi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bAE();
                }
            });
            this.fpZ = (ProgressBar) this.fpN.findViewById(R.id.confirm_progress);
            this.fpY = (TextView) this.fpN.findViewById(R.id.error_info);
            this.fpQ = (RadioGroup) this.fpN.findViewById(R.id.names_group1);
            this.fpR = (RadioGroup) this.fpN.findViewById(R.id.names_group2);
            this.fpT = (RadioButton) this.fpN.findViewById(R.id.name1);
            this.fpU = (RadioButton) this.fpN.findViewById(R.id.name2);
            this.fpV = (RadioButton) this.fpN.findViewById(R.id.name3);
            this.fpS = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.fpT) {
                            b.this.fpR.clearCheck();
                            b.this.fpT.setChecked(true);
                            b.this.fpT.setCompoundDrawables(b.this.fqe, null, null, null);
                            b.this.fpU.setChecked(false);
                            b.this.fpU.setCompoundDrawables(b.this.fqf, null, null, null);
                            b.this.fpV.setChecked(false);
                            b.this.fpV.setCompoundDrawables(b.this.fqf, null, null, null);
                        } else if (compoundButton == b.this.fpU) {
                            b.this.fpR.clearCheck();
                            b.this.fpT.setChecked(false);
                            b.this.fpT.setCompoundDrawables(b.this.fqf, null, null, null);
                            b.this.fpU.setChecked(true);
                            b.this.fpU.setCompoundDrawables(b.this.fqe, null, null, null);
                            b.this.fpV.setChecked(false);
                            b.this.fpV.setCompoundDrawables(b.this.fqf, null, null, null);
                        } else if (compoundButton == b.this.fpV) {
                            b.this.fpQ.clearCheck();
                            b.this.fpT.setChecked(false);
                            b.this.fpT.setCompoundDrawables(b.this.fqf, null, null, null);
                            b.this.fpU.setChecked(false);
                            b.this.fpU.setCompoundDrawables(b.this.fqf, null, null, null);
                            b.this.fpV.setChecked(true);
                            b.this.fpV.setCompoundDrawables(b.this.fqe, null, null, null);
                        }
                        b.this.fpP.setText(compoundButton.getText());
                    }
                }
            };
            this.fpT.setOnCheckedChangeListener(this.fpS);
            this.fpU.setOnCheckedChangeListener(this.fpS);
            this.fpV.setOnCheckedChangeListener(this.fpS);
            this.fqa = (TextView) this.fpN.findViewById(R.id.phone_info);
            bAG();
            this.fpO = new Dialog(this.beD, R.style.input_username_dialog);
            this.fpO.setCanceledOnTouchOutside(false);
            this.fpO.setCancelable(false);
            this.fpO.setCanceledOnTouchOutside(false);
            bAu();
        }
        if (i == 1) {
            this.fqa.setText(R.string.tip_init_user_name);
        } else {
            this.fqa.setText(R.string.bar_friend);
        }
        if (!this.fpO.isShowing()) {
            this.fpP.setText((CharSequence) null);
            bAG();
            Dn(null);
            if (!this.beD.isFinishing()) {
                this.fpO.setContentView(this.fpN);
                g.showDialog(this.fpO, this.beD);
                if (this.beD instanceof BaseActivity) {
                    ((BaseActivity) this.beD).ShowSoftKeyPadDelay(this.fpP, 150);
                } else {
                    new Handler().postDelayed(new c(this.fpP), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        private View mView;

        public c(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.beD.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.beD.getSystemService("input_method");
                try {
                    if (this.mView != null && inputMethodManager != null) {
                        inputMethodManager.showSoftInput(this.mView, 0);
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
        }
    }

    public void bAE() {
        String obj = this.fpP.getText().toString();
        if (obj == null || obj.length() <= 0) {
            Dn(this.beD.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            Dn(this.beD.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.fpX != null) {
                this.fpX.cancel();
            }
            if (!this.fqk && this.fqb != null) {
                this.fpZ.setVisibility(0);
                this.bTi.setEnabled(false);
                Dn(null);
                bAG();
                SapiAccountManager.getInstance().getAccountService().fillUsername(new FillUsernameCallback() { // from class: com.baidu.tbadk.coreExtra.view.b.4
                    @Override // com.baidu.sapi2.callback.FillUsernameCallback
                    public void onUserHaveUsername(FillUsernameResult fillUsernameResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    /* renamed from: a */
                    public void onBdussExpired(FillUsernameResult fillUsernameResult) {
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: b */
                    public void onSuccess(FillUsernameResult fillUsernameResult) {
                        b.this.bAH();
                        l.showToast(b.this.beD, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.blW().a(session.username, session.bduss, "", null, b.this.fql);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.Dn(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.fqk = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.fpZ.setVisibility(8);
                        b.this.bTi.setEnabled(true);
                        b.this.fqk = false;
                    }
                }, this.fqb.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAF() {
        if (this.fqd != null) {
            this.fqd.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            Dn(this.beD.getString(R.string.suggest_no_name));
            return;
        }
        Dn(this.beD.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.fpQ.clearCheck();
        this.fpR.clearCheck();
        this.fpQ.setVisibility(0);
        this.fpR.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.fpT.setText(arrayList.get(0));
            this.fpT.setChecked(false);
            this.fpT.setCompoundDrawables(this.fqf, null, null, null);
            this.fpT.setVisibility(0);
            this.fpQ.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.fpU.setText(arrayList.get(1));
            this.fpU.setChecked(false);
            this.fpU.setCompoundDrawables(this.fqf, null, null, null);
            this.fpU.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.fpV.setText(arrayList.get(2));
            this.fpV.setChecked(false);
            this.fpV.setCompoundDrawables(this.fqf, null, null, null);
            this.fpV.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.fpX != null) {
            this.fpX.cancel();
            this.fpX = null;
        }
        bAH();
    }

    public void bAG() {
        this.fpQ.setVisibility(8);
        this.fpQ.clearCheck();
        this.fpR.setVisibility(8);
        this.fpR.clearCheck();
        this.fpT.setVisibility(8);
        this.fpU.setVisibility(8);
        this.fpV.setVisibility(8);
        this.fpT.setChecked(false);
        this.fpU.setChecked(false);
        this.fpV.setChecked(false);
    }

    public void bAH() {
        if (this.fpO != null && this.fpO.isShowing()) {
            g.dismissDialog(this.fpO, this.beD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dn(String str) {
        if (str == null) {
            this.fpY.setVisibility(4);
            this.fpY.setText((CharSequence) null);
            return;
        }
        this.fpY.setVisibility(0);
        this.fpY.setText(str);
    }

    private void bAu() {
        ap.setBackgroundResource(this.fpN, R.drawable.dialog_background);
        ap.setViewTextColor(this.fqa, R.color.CAM_X0105);
        ap.setViewTextColor(this.fqg, R.color.CAM_X0106);
        ap.setViewTextColor(this.fpP, R.color.CAM_X0105);
        ap.setBackgroundResource(this.fqh, R.drawable.bg_search_input);
        ap.setViewTextColor(this.fpY, R.color.CAM_X0301);
        ap.setViewTextColor(this.fpT, R.color.CAM_X0105);
        ap.setViewTextColor(this.fpU, R.color.CAM_X0105);
        ap.setViewTextColor(this.fpV, R.color.CAM_X0105);
        ap.setBackgroundColor(this.fqi, R.color.CAM_X0204);
        ap.setBackgroundResource(this.fpW, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.fpW, R.color.CAM_X0302);
        ap.setBackgroundColor(this.fqj, R.color.CAM_X0204);
        ap.setBackgroundResource(this.bTi, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.bTi, R.color.CAM_X0302);
        this.fpP.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.fpT.setCompoundDrawables(this.fqf, null, null, null);
        this.fpU.setCompoundDrawables(this.fqf, null, null, null);
        this.fpV.setCompoundDrawables(this.fqf, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0600b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b fqm;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.fqm.fpX = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
        public o doInBackground(String... strArr) {
            this.mNetwork = new aa(this.mUrl);
            this.mNetwork.addPostData("un", this.mAccount);
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.isNetSuccess() || this.mNetwork.getServerErrorCode() != 36) {
                return null;
            }
            o oVar = new o();
            oVar.parserJson(postNetData);
            return oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(o oVar) {
            super.onPostExecute(oVar);
            this.fqm.fpX = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.fqm.Dn(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.fqm.Dn(this.fqm.beD.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.fqm.Dn(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.fqm.K(oVar.bxx());
                }
            } else {
                this.fqm.Dn(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fqm.Dn(null);
            this.fqm.bAG();
            super.onPreExecute();
        }
    }
}
