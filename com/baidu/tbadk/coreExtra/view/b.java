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
/* loaded from: classes.dex */
public class b {
    private Activity cAc;
    private Drawable eGV;
    private Drawable eGW;
    private TextView eGX;
    private View eGY;
    private View eGZ;
    private View eHa;
    private a.InterfaceC0536a eHc;
    private int size;
    private View eGD = null;
    private Dialog eGE = null;
    private EditText eGF = null;
    private RadioGroup eGG = null;
    private RadioGroup eGH = null;
    private CompoundButton.OnCheckedChangeListener eGI = null;
    private RadioButton eGJ = null;
    private RadioButton eGK = null;
    private RadioButton eGL = null;
    private TextView eGM = null;
    private C0550b eGN = null;
    private TextView eGO = null;
    private TextView eGP = null;
    private ProgressBar eGQ = null;
    private TextView eGR = null;
    private AccountData eGS = null;
    private a eGT = null;
    private a eGU = null;
    private boolean eHb = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.cAc = null;
        this.eGV = null;
        this.eGW = null;
        this.size = 0;
        this.cAc = activity;
        this.eGV = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.eGW = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.cAc.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.eGV.setBounds(0, 0, this.size, this.size);
        this.eGW.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0536a interfaceC0536a) {
        this.eHc = interfaceC0536a;
    }

    public void setAccountData(AccountData accountData) {
        this.eGS = accountData;
    }

    public void a(a aVar) {
        this.eGT = aVar;
    }

    public void b(a aVar) {
        this.eGU = aVar;
    }

    public void bpR() {
        pN(0);
    }

    public void pN(int i) {
        if (this.eGE == null) {
            this.eGD = LayoutInflater.from(this.cAc).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.eGX = (TextView) this.eGD.findViewById(R.id.tip_info);
            this.eGY = this.eGD.findViewById(R.id.divider_under_account);
            this.eGZ = this.eGD.findViewById(R.id.divider_under_radiongroup);
            this.eHa = this.eGD.findViewById(R.id.divider_with_yes_no_button);
            this.eGF = (EditText) this.eGD.findViewById(R.id.account);
            this.eGF.setHint(this.cAc.getString(R.string.hint_tip_input_name));
            this.eGM = (TextView) this.eGD.findViewById(R.id.back);
            this.eGM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bpV();
                    b.this.bpT();
                }
            });
            this.eGP = (TextView) this.eGD.findViewById(R.id.confirm);
            this.eGP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bpS();
                }
            });
            this.eGQ = (ProgressBar) this.eGD.findViewById(R.id.confirm_progress);
            this.eGO = (TextView) this.eGD.findViewById(R.id.error_info);
            this.eGG = (RadioGroup) this.eGD.findViewById(R.id.names_group1);
            this.eGH = (RadioGroup) this.eGD.findViewById(R.id.names_group2);
            this.eGJ = (RadioButton) this.eGD.findViewById(R.id.name1);
            this.eGK = (RadioButton) this.eGD.findViewById(R.id.name2);
            this.eGL = (RadioButton) this.eGD.findViewById(R.id.name3);
            this.eGI = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.eGJ) {
                            b.this.eGH.clearCheck();
                            b.this.eGJ.setChecked(true);
                            b.this.eGJ.setCompoundDrawables(b.this.eGV, null, null, null);
                            b.this.eGK.setChecked(false);
                            b.this.eGK.setCompoundDrawables(b.this.eGW, null, null, null);
                            b.this.eGL.setChecked(false);
                            b.this.eGL.setCompoundDrawables(b.this.eGW, null, null, null);
                        } else if (compoundButton == b.this.eGK) {
                            b.this.eGH.clearCheck();
                            b.this.eGJ.setChecked(false);
                            b.this.eGJ.setCompoundDrawables(b.this.eGW, null, null, null);
                            b.this.eGK.setChecked(true);
                            b.this.eGK.setCompoundDrawables(b.this.eGV, null, null, null);
                            b.this.eGL.setChecked(false);
                            b.this.eGL.setCompoundDrawables(b.this.eGW, null, null, null);
                        } else if (compoundButton == b.this.eGL) {
                            b.this.eGG.clearCheck();
                            b.this.eGJ.setChecked(false);
                            b.this.eGJ.setCompoundDrawables(b.this.eGW, null, null, null);
                            b.this.eGK.setChecked(false);
                            b.this.eGK.setCompoundDrawables(b.this.eGW, null, null, null);
                            b.this.eGL.setChecked(true);
                            b.this.eGL.setCompoundDrawables(b.this.eGV, null, null, null);
                        }
                        b.this.eGF.setText(compoundButton.getText());
                    }
                }
            };
            this.eGJ.setOnCheckedChangeListener(this.eGI);
            this.eGK.setOnCheckedChangeListener(this.eGI);
            this.eGL.setOnCheckedChangeListener(this.eGI);
            this.eGR = (TextView) this.eGD.findViewById(R.id.phone_info);
            bpU();
            this.eGE = new Dialog(this.cAc, R.style.input_username_dialog);
            this.eGE.setCanceledOnTouchOutside(false);
            this.eGE.setCancelable(false);
            this.eGE.setCanceledOnTouchOutside(false);
            bpI();
        }
        if (i == 1) {
            this.eGR.setText(R.string.tip_init_user_name);
        } else {
            this.eGR.setText(R.string.bar_friend);
        }
        if (!this.eGE.isShowing()) {
            this.eGF.setText((CharSequence) null);
            bpU();
            Br(null);
            if (!this.cAc.isFinishing()) {
                this.eGE.setContentView(this.eGD);
                g.showDialog(this.eGE, this.cAc);
                if (this.cAc instanceof BaseActivity) {
                    ((BaseActivity) this.cAc).ShowSoftKeyPadDelay(this.eGF, 150);
                } else {
                    new Handler().postDelayed(new c(this.eGF), 150L);
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
            if (!b.this.cAc.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.cAc.getSystemService("input_method");
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

    public void bpS() {
        String obj = this.eGF.getText().toString();
        if (obj == null || obj.length() <= 0) {
            Br(this.cAc.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            Br(this.cAc.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.eGN != null) {
                this.eGN.cancel();
            }
            if (!this.eHb && this.eGS != null) {
                this.eGQ.setVisibility(0);
                this.eGP.setEnabled(false);
                Br(null);
                bpU();
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
                        b.this.bpV();
                        l.showToast(b.this.cAc, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bbN().a(session.username, session.bduss, "", null, b.this.eHc);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.Br(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.eHb = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.eGQ.setVisibility(8);
                        b.this.eGP.setEnabled(true);
                        b.this.eHb = false;
                    }
                }, this.eGS.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpT() {
        if (this.eGU != null) {
            this.eGU.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            Br(this.cAc.getString(R.string.suggest_no_name));
            return;
        }
        Br(this.cAc.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.eGG.clearCheck();
        this.eGH.clearCheck();
        this.eGG.setVisibility(0);
        this.eGH.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.eGJ.setText(arrayList.get(0));
            this.eGJ.setChecked(false);
            this.eGJ.setCompoundDrawables(this.eGW, null, null, null);
            this.eGJ.setVisibility(0);
            this.eGG.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.eGK.setText(arrayList.get(1));
            this.eGK.setChecked(false);
            this.eGK.setCompoundDrawables(this.eGW, null, null, null);
            this.eGK.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.eGL.setText(arrayList.get(2));
            this.eGL.setChecked(false);
            this.eGL.setCompoundDrawables(this.eGW, null, null, null);
            this.eGL.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.eGN != null) {
            this.eGN.cancel();
            this.eGN = null;
        }
        bpV();
    }

    public void bpU() {
        this.eGG.setVisibility(8);
        this.eGG.clearCheck();
        this.eGH.setVisibility(8);
        this.eGH.clearCheck();
        this.eGJ.setVisibility(8);
        this.eGK.setVisibility(8);
        this.eGL.setVisibility(8);
        this.eGJ.setChecked(false);
        this.eGK.setChecked(false);
        this.eGL.setChecked(false);
    }

    public void bpV() {
        if (this.eGE != null && this.eGE.isShowing()) {
            g.dismissDialog(this.eGE, this.cAc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Br(String str) {
        if (str == null) {
            this.eGO.setVisibility(4);
            this.eGO.setText((CharSequence) null);
            return;
        }
        this.eGO.setVisibility(0);
        this.eGO.setText(str);
    }

    private void bpI() {
        ap.setBackgroundResource(this.eGD, R.drawable.dialog_background);
        ap.setViewTextColor(this.eGR, R.color.cp_cont_b);
        ap.setViewTextColor(this.eGX, R.color.cp_cont_f);
        ap.setViewTextColor(this.eGF, R.color.cp_cont_b);
        ap.setBackgroundResource(this.eGY, R.drawable.bg_search_input);
        ap.setViewTextColor(this.eGO, R.color.cp_cont_h);
        ap.setViewTextColor(this.eGJ, R.color.cp_cont_b);
        ap.setViewTextColor(this.eGK, R.color.cp_cont_b);
        ap.setViewTextColor(this.eGL, R.color.cp_cont_b);
        ap.setBackgroundColor(this.eGZ, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eGM, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.eGM, R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.eHa, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eGP, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.eGP, R.color.cp_link_tip_a);
        this.eGF.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.eGJ.setCompoundDrawables(this.eGW, null, null, null);
        this.eGK.setCompoundDrawables(this.eGW, null, null, null);
        this.eGL.setCompoundDrawables(this.eGW, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0550b extends BdAsyncTask<String, Integer, n> {
        final /* synthetic */ b eHd;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.eHd.eGN = null;
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
            this.eHd.eGN = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.eHd.Br(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.eHd.Br(this.eHd.cAc.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.eHd.Br(this.mNetwork.getErrorString());
                if (nVar != null) {
                    this.eHd.K(nVar.bmK());
                }
            } else {
                this.eHd.Br(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eHd.Br(null);
            this.eHd.bpU();
            super.onPreExecute();
        }
    }
}
