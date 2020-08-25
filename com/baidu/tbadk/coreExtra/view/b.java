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
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b {
    private Activity czY;
    private Drawable eGR;
    private Drawable eGS;
    private TextView eGT;
    private View eGU;
    private View eGV;
    private View eGW;
    private a.InterfaceC0536a eGY;
    private int size;
    private View eGz = null;
    private Dialog eGA = null;
    private EditText eGB = null;
    private RadioGroup eGC = null;
    private RadioGroup eGD = null;
    private CompoundButton.OnCheckedChangeListener eGE = null;
    private RadioButton eGF = null;
    private RadioButton eGG = null;
    private RadioButton eGH = null;
    private TextView eGI = null;
    private C0550b eGJ = null;
    private TextView eGK = null;
    private TextView eGL = null;
    private ProgressBar eGM = null;
    private TextView eGN = null;
    private AccountData eGO = null;
    private a eGP = null;
    private a eGQ = null;
    private boolean eGX = false;

    /* loaded from: classes2.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.czY = null;
        this.eGR = null;
        this.eGS = null;
        this.size = 0;
        this.czY = activity;
        this.eGR = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.eGS = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.czY.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.eGR.setBounds(0, 0, this.size, this.size);
        this.eGS.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0536a interfaceC0536a) {
        this.eGY = interfaceC0536a;
    }

    public void setAccountData(AccountData accountData) {
        this.eGO = accountData;
    }

    public void a(a aVar) {
        this.eGP = aVar;
    }

    public void b(a aVar) {
        this.eGQ = aVar;
    }

    public void bpQ() {
        pN(0);
    }

    public void pN(int i) {
        if (this.eGA == null) {
            this.eGz = LayoutInflater.from(this.czY).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.eGT = (TextView) this.eGz.findViewById(R.id.tip_info);
            this.eGU = this.eGz.findViewById(R.id.divider_under_account);
            this.eGV = this.eGz.findViewById(R.id.divider_under_radiongroup);
            this.eGW = this.eGz.findViewById(R.id.divider_with_yes_no_button);
            this.eGB = (EditText) this.eGz.findViewById(R.id.account);
            this.eGB.setHint(this.czY.getString(R.string.hint_tip_input_name));
            this.eGI = (TextView) this.eGz.findViewById(R.id.back);
            this.eGI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bpU();
                    b.this.bpS();
                }
            });
            this.eGL = (TextView) this.eGz.findViewById(R.id.confirm);
            this.eGL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bpR();
                }
            });
            this.eGM = (ProgressBar) this.eGz.findViewById(R.id.confirm_progress);
            this.eGK = (TextView) this.eGz.findViewById(R.id.error_info);
            this.eGC = (RadioGroup) this.eGz.findViewById(R.id.names_group1);
            this.eGD = (RadioGroup) this.eGz.findViewById(R.id.names_group2);
            this.eGF = (RadioButton) this.eGz.findViewById(R.id.name1);
            this.eGG = (RadioButton) this.eGz.findViewById(R.id.name2);
            this.eGH = (RadioButton) this.eGz.findViewById(R.id.name3);
            this.eGE = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.eGF) {
                            b.this.eGD.clearCheck();
                            b.this.eGF.setChecked(true);
                            b.this.eGF.setCompoundDrawables(b.this.eGR, null, null, null);
                            b.this.eGG.setChecked(false);
                            b.this.eGG.setCompoundDrawables(b.this.eGS, null, null, null);
                            b.this.eGH.setChecked(false);
                            b.this.eGH.setCompoundDrawables(b.this.eGS, null, null, null);
                        } else if (compoundButton == b.this.eGG) {
                            b.this.eGD.clearCheck();
                            b.this.eGF.setChecked(false);
                            b.this.eGF.setCompoundDrawables(b.this.eGS, null, null, null);
                            b.this.eGG.setChecked(true);
                            b.this.eGG.setCompoundDrawables(b.this.eGR, null, null, null);
                            b.this.eGH.setChecked(false);
                            b.this.eGH.setCompoundDrawables(b.this.eGS, null, null, null);
                        } else if (compoundButton == b.this.eGH) {
                            b.this.eGC.clearCheck();
                            b.this.eGF.setChecked(false);
                            b.this.eGF.setCompoundDrawables(b.this.eGS, null, null, null);
                            b.this.eGG.setChecked(false);
                            b.this.eGG.setCompoundDrawables(b.this.eGS, null, null, null);
                            b.this.eGH.setChecked(true);
                            b.this.eGH.setCompoundDrawables(b.this.eGR, null, null, null);
                        }
                        b.this.eGB.setText(compoundButton.getText());
                    }
                }
            };
            this.eGF.setOnCheckedChangeListener(this.eGE);
            this.eGG.setOnCheckedChangeListener(this.eGE);
            this.eGH.setOnCheckedChangeListener(this.eGE);
            this.eGN = (TextView) this.eGz.findViewById(R.id.phone_info);
            bpT();
            this.eGA = new Dialog(this.czY, R.style.input_username_dialog);
            this.eGA.setCanceledOnTouchOutside(false);
            this.eGA.setCancelable(false);
            this.eGA.setCanceledOnTouchOutside(false);
            bpH();
        }
        if (i == 1) {
            this.eGN.setText(R.string.tip_init_user_name);
        } else {
            this.eGN.setText(R.string.bar_friend);
        }
        if (!this.eGA.isShowing()) {
            this.eGB.setText((CharSequence) null);
            bpT();
            Bq(null);
            if (!this.czY.isFinishing()) {
                this.eGA.setContentView(this.eGz);
                g.showDialog(this.eGA, this.czY);
                if (this.czY instanceof BaseActivity) {
                    ((BaseActivity) this.czY).ShowSoftKeyPadDelay(this.eGB, 150);
                } else {
                    new Handler().postDelayed(new c(this.eGB), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        private View mView;

        public c(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.czY.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.czY.getSystemService("input_method");
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

    public void bpR() {
        String obj = this.eGB.getText().toString();
        if (obj == null || obj.length() <= 0) {
            Bq(this.czY.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            Bq(this.czY.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.eGJ != null) {
                this.eGJ.cancel();
            }
            if (!this.eGX && this.eGO != null) {
                this.eGM.setVisibility(0);
                this.eGL.setEnabled(false);
                Bq(null);
                bpT();
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
                        b.this.bpU();
                        l.showToast(b.this.czY, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bbN().a(session.username, session.bduss, "", null, b.this.eGY);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.Bq(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.eGX = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.eGM.setVisibility(8);
                        b.this.eGL.setEnabled(true);
                        b.this.eGX = false;
                    }
                }, this.eGO.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpS() {
        if (this.eGQ != null) {
            this.eGQ.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            Bq(this.czY.getString(R.string.suggest_no_name));
            return;
        }
        Bq(this.czY.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.eGC.clearCheck();
        this.eGD.clearCheck();
        this.eGC.setVisibility(0);
        this.eGD.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.eGF.setText(arrayList.get(0));
            this.eGF.setChecked(false);
            this.eGF.setCompoundDrawables(this.eGS, null, null, null);
            this.eGF.setVisibility(0);
            this.eGC.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.eGG.setText(arrayList.get(1));
            this.eGG.setChecked(false);
            this.eGG.setCompoundDrawables(this.eGS, null, null, null);
            this.eGG.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.eGH.setText(arrayList.get(2));
            this.eGH.setChecked(false);
            this.eGH.setCompoundDrawables(this.eGS, null, null, null);
            this.eGH.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.eGJ != null) {
            this.eGJ.cancel();
            this.eGJ = null;
        }
        bpU();
    }

    public void bpT() {
        this.eGC.setVisibility(8);
        this.eGC.clearCheck();
        this.eGD.setVisibility(8);
        this.eGD.clearCheck();
        this.eGF.setVisibility(8);
        this.eGG.setVisibility(8);
        this.eGH.setVisibility(8);
        this.eGF.setChecked(false);
        this.eGG.setChecked(false);
        this.eGH.setChecked(false);
    }

    public void bpU() {
        if (this.eGA != null && this.eGA.isShowing()) {
            g.dismissDialog(this.eGA, this.czY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq(String str) {
        if (str == null) {
            this.eGK.setVisibility(4);
            this.eGK.setText((CharSequence) null);
            return;
        }
        this.eGK.setVisibility(0);
        this.eGK.setText(str);
    }

    private void bpH() {
        ap.setBackgroundResource(this.eGz, R.drawable.dialog_background);
        ap.setViewTextColor(this.eGN, R.color.cp_cont_b);
        ap.setViewTextColor(this.eGT, R.color.cp_cont_f);
        ap.setViewTextColor(this.eGB, R.color.cp_cont_b);
        ap.setBackgroundResource(this.eGU, R.drawable.bg_search_input);
        ap.setViewTextColor(this.eGK, R.color.cp_cont_h);
        ap.setViewTextColor(this.eGF, R.color.cp_cont_b);
        ap.setViewTextColor(this.eGG, R.color.cp_cont_b);
        ap.setViewTextColor(this.eGH, R.color.cp_cont_b);
        ap.setBackgroundColor(this.eGV, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eGI, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.eGI, R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.eGW, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eGL, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.eGL, R.color.cp_link_tip_a);
        this.eGB.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.eGF.setCompoundDrawables(this.eGS, null, null, null);
        this.eGG.setCompoundDrawables(this.eGS, null, null, null);
        this.eGH.setCompoundDrawables(this.eGS, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0550b extends BdAsyncTask<String, Integer, n> {
        final /* synthetic */ b eGZ;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.eGZ.eGJ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
        public n doInBackground(String... strArr) {
            this.mNetwork = new aa(this.mUrl);
            this.mNetwork.addPostData("un", this.mAccount);
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.isNetSuccess() || this.mNetwork.getServerErrorCode() != 36) {
                return null;
            }
            n nVar = new n();
            nVar.parserJson(postNetData);
            return nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(n nVar) {
            super.onPostExecute(nVar);
            this.eGZ.eGJ = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.eGZ.Bq(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.eGZ.Bq(this.eGZ.czY.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.eGZ.Bq(this.mNetwork.getErrorString());
                if (nVar != null) {
                    this.eGZ.K(nVar.bmK());
                }
            } else {
                this.eGZ.Bq(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eGZ.Bq(null);
            this.eGZ.bpT();
            super.onPreExecute();
        }
    }
}
