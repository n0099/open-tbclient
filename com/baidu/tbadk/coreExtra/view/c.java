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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private Activity caH;
    private Drawable dTa;
    private Drawable dTb;
    private TextView dTc;
    private View dTd;
    private View dTe;
    private View dTf;
    private a.InterfaceC0405a dTh;
    private int size;
    private View dSI = null;
    private Dialog dSJ = null;
    private EditText dSK = null;
    private RadioGroup dSL = null;
    private RadioGroup dSM = null;
    private CompoundButton.OnCheckedChangeListener dSN = null;
    private RadioButton dSO = null;
    private RadioButton dSP = null;
    private RadioButton dSQ = null;
    private TextView dSR = null;
    private b dSS = null;
    private TextView dST = null;
    private TextView dSU = null;
    private ProgressBar dSV = null;
    private TextView dSW = null;
    private AccountData dSX = null;
    private a dSY = null;
    private a dSZ = null;
    private boolean dTg = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.caH = null;
        this.dTa = null;
        this.dTb = null;
        this.size = 0;
        this.caH = activity;
        this.dTa = am.getDrawable(R.drawable.icon_tips_names_s);
        this.dTb = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.caH.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.dTa.setBounds(0, 0, this.size, this.size);
        this.dTb.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0405a interfaceC0405a) {
        this.dTh = interfaceC0405a;
    }

    public void setAccountData(AccountData accountData) {
        this.dSX = accountData;
    }

    public void a(a aVar) {
        this.dSY = aVar;
    }

    public void b(a aVar) {
        this.dSZ = aVar;
    }

    public void aVl() {
        mm(0);
    }

    public void mm(int i) {
        if (this.dSJ == null) {
            this.dSI = LayoutInflater.from(this.caH).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.dTc = (TextView) this.dSI.findViewById(R.id.tip_info);
            this.dTd = this.dSI.findViewById(R.id.divider_under_account);
            this.dTe = this.dSI.findViewById(R.id.divider_under_radiongroup);
            this.dTf = this.dSI.findViewById(R.id.divider_with_yes_no_button);
            this.dSK = (EditText) this.dSI.findViewById(R.id.account);
            this.dSK.setHint(this.caH.getString(R.string.hint_tip_input_name));
            this.dSR = (TextView) this.dSI.findViewById(R.id.back);
            this.dSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aVp();
                    c.this.aVn();
                }
            });
            this.dSU = (TextView) this.dSI.findViewById(R.id.confirm);
            this.dSU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aVm();
                }
            });
            this.dSV = (ProgressBar) this.dSI.findViewById(R.id.confirm_progress);
            this.dST = (TextView) this.dSI.findViewById(R.id.error_info);
            this.dSL = (RadioGroup) this.dSI.findViewById(R.id.names_group1);
            this.dSM = (RadioGroup) this.dSI.findViewById(R.id.names_group2);
            this.dSO = (RadioButton) this.dSI.findViewById(R.id.name1);
            this.dSP = (RadioButton) this.dSI.findViewById(R.id.name2);
            this.dSQ = (RadioButton) this.dSI.findViewById(R.id.name3);
            this.dSN = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.dSO) {
                            c.this.dSM.clearCheck();
                            c.this.dSO.setChecked(true);
                            c.this.dSO.setCompoundDrawables(c.this.dTa, null, null, null);
                            c.this.dSP.setChecked(false);
                            c.this.dSP.setCompoundDrawables(c.this.dTb, null, null, null);
                            c.this.dSQ.setChecked(false);
                            c.this.dSQ.setCompoundDrawables(c.this.dTb, null, null, null);
                        } else if (compoundButton == c.this.dSP) {
                            c.this.dSM.clearCheck();
                            c.this.dSO.setChecked(false);
                            c.this.dSO.setCompoundDrawables(c.this.dTb, null, null, null);
                            c.this.dSP.setChecked(true);
                            c.this.dSP.setCompoundDrawables(c.this.dTa, null, null, null);
                            c.this.dSQ.setChecked(false);
                            c.this.dSQ.setCompoundDrawables(c.this.dTb, null, null, null);
                        } else if (compoundButton == c.this.dSQ) {
                            c.this.dSL.clearCheck();
                            c.this.dSO.setChecked(false);
                            c.this.dSO.setCompoundDrawables(c.this.dTb, null, null, null);
                            c.this.dSP.setChecked(false);
                            c.this.dSP.setCompoundDrawables(c.this.dTb, null, null, null);
                            c.this.dSQ.setChecked(true);
                            c.this.dSQ.setCompoundDrawables(c.this.dTa, null, null, null);
                        }
                        c.this.dSK.setText(compoundButton.getText());
                    }
                }
            };
            this.dSO.setOnCheckedChangeListener(this.dSN);
            this.dSP.setOnCheckedChangeListener(this.dSN);
            this.dSQ.setOnCheckedChangeListener(this.dSN);
            this.dSW = (TextView) this.dSI.findViewById(R.id.phone_info);
            aVo();
            this.dSJ = new Dialog(this.caH, R.style.input_username_dialog);
            this.dSJ.setCanceledOnTouchOutside(false);
            this.dSJ.setCancelable(false);
            this.dSJ.setCanceledOnTouchOutside(false);
            aVd();
        }
        if (i == 1) {
            this.dSW.setText(R.string.tip_init_user_name);
        } else {
            this.dSW.setText(R.string.bar_friend);
        }
        if (!this.dSJ.isShowing()) {
            this.dSK.setText((CharSequence) null);
            aVo();
            vS(null);
            if (!this.caH.isFinishing()) {
                this.dSJ.setContentView(this.dSI);
                g.showDialog(this.dSJ, this.caH);
                if (this.caH instanceof BaseActivity) {
                    ((BaseActivity) this.caH).ShowSoftKeyPadDelay(this.dSK, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0418c(this.dSK), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0418c implements Runnable {
        private View mView;

        public RunnableC0418c(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.caH.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) c.this.caH.getSystemService("input_method");
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

    public void aVm() {
        String obj = this.dSK.getText().toString();
        if (obj == null || obj.length() <= 0) {
            vS(this.caH.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            vS(this.caH.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.dSS != null) {
                this.dSS.cancel();
            }
            if (!this.dTg && this.dSX != null) {
                this.dSV.setVisibility(0);
                this.dSU.setEnabled(false);
                vS(null);
                aVo();
                SapiAccountManager.getInstance().getAccountService().fillUsername(new FillUsernameCallback() { // from class: com.baidu.tbadk.coreExtra.view.c.4
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
                        c.this.aVp();
                        l.showToast(c.this.caH, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.aIf().a(session.username, session.bduss, "", null, c.this.dTh);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.vS(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.dTg = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.dSV.setVisibility(8);
                        c.this.dSU.setEnabled(true);
                        c.this.dTg = false;
                    }
                }, this.dSX.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVn() {
        if (this.dSZ != null) {
            this.dSZ.g(null);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            vS(this.caH.getString(R.string.suggest_no_name));
            return;
        }
        vS(this.caH.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.dSL.clearCheck();
        this.dSM.clearCheck();
        this.dSL.setVisibility(0);
        this.dSM.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.dSO.setText(arrayList.get(0));
            this.dSO.setChecked(false);
            this.dSO.setCompoundDrawables(this.dTb, null, null, null);
            this.dSO.setVisibility(0);
            this.dSL.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.dSP.setText(arrayList.get(1));
            this.dSP.setChecked(false);
            this.dSP.setCompoundDrawables(this.dTb, null, null, null);
            this.dSP.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.dSQ.setText(arrayList.get(2));
            this.dSQ.setChecked(false);
            this.dSQ.setCompoundDrawables(this.dTb, null, null, null);
            this.dSQ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.dSS != null) {
            this.dSS.cancel();
            this.dSS = null;
        }
        aVp();
    }

    public void aVo() {
        this.dSL.setVisibility(8);
        this.dSL.clearCheck();
        this.dSM.setVisibility(8);
        this.dSM.clearCheck();
        this.dSO.setVisibility(8);
        this.dSP.setVisibility(8);
        this.dSQ.setVisibility(8);
        this.dSO.setChecked(false);
        this.dSP.setChecked(false);
        this.dSQ.setChecked(false);
    }

    public void aVp() {
        if (this.dSJ != null && this.dSJ.isShowing()) {
            g.dismissDialog(this.dSJ, this.caH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(String str) {
        if (str == null) {
            this.dST.setVisibility(4);
            this.dST.setText((CharSequence) null);
            return;
        }
        this.dST.setVisibility(0);
        this.dST.setText(str);
    }

    private void aVd() {
        am.setBackgroundResource(this.dSI, R.drawable.dialog_background);
        am.setViewTextColor(this.dSW, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dTc, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dSK, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.dTd, R.drawable.bg_search_input);
        am.setViewTextColor(this.dST, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.dSO, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dSP, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dSQ, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.dTe, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dSR, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.dSR, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.dTf, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dSU, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.dSU, (int) R.color.cp_link_tip_a);
        this.dSK.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.dSO.setCompoundDrawables(this.dTb, null, null, null);
        this.dSP.setCompoundDrawables(this.dTb, null, null, null);
        this.dSQ.setCompoundDrawables(this.dTb, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ c dTi;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.dTi.dSS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: A */
        public k doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.addPostData("un", this.mAccount);
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.isNetSuccess() || this.mNetwork.getServerErrorCode() != 36) {
                return null;
            }
            k kVar = new k();
            kVar.parserJson(postNetData);
            return kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(k kVar) {
            super.onPostExecute(kVar);
            this.dTi.dSS = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.dTi.vS(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.dTi.vS(this.dTi.caH.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.dTi.vS(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.dTi.D(kVar.aRT());
                }
            } else {
                this.dTi.vS(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dTi.vS(null);
            this.dTi.aVo();
            super.onPreExecute();
        }
    }
}
