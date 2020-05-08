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
    private Activity caN;
    private Drawable dTf;
    private Drawable dTg;
    private TextView dTh;
    private View dTi;
    private View dTj;
    private View dTk;
    private a.InterfaceC0426a dTm;
    private int size;
    private View dSN = null;
    private Dialog dSO = null;
    private EditText dSP = null;
    private RadioGroup dSQ = null;
    private RadioGroup dSR = null;
    private CompoundButton.OnCheckedChangeListener dSS = null;
    private RadioButton dST = null;
    private RadioButton dSU = null;
    private RadioButton dSV = null;
    private TextView dSW = null;
    private b dSX = null;
    private TextView dSY = null;
    private TextView dSZ = null;
    private ProgressBar dTa = null;
    private TextView dTb = null;
    private AccountData dTc = null;
    private a dTd = null;
    private a dTe = null;
    private boolean dTl = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.caN = null;
        this.dTf = null;
        this.dTg = null;
        this.size = 0;
        this.caN = activity;
        this.dTf = am.getDrawable(R.drawable.icon_tips_names_s);
        this.dTg = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.caN.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.dTf.setBounds(0, 0, this.size, this.size);
        this.dTg.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0426a interfaceC0426a) {
        this.dTm = interfaceC0426a;
    }

    public void setAccountData(AccountData accountData) {
        this.dTc = accountData;
    }

    public void a(a aVar) {
        this.dTd = aVar;
    }

    public void b(a aVar) {
        this.dTe = aVar;
    }

    public void aVj() {
        mm(0);
    }

    public void mm(int i) {
        if (this.dSO == null) {
            this.dSN = LayoutInflater.from(this.caN).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.dTh = (TextView) this.dSN.findViewById(R.id.tip_info);
            this.dTi = this.dSN.findViewById(R.id.divider_under_account);
            this.dTj = this.dSN.findViewById(R.id.divider_under_radiongroup);
            this.dTk = this.dSN.findViewById(R.id.divider_with_yes_no_button);
            this.dSP = (EditText) this.dSN.findViewById(R.id.account);
            this.dSP.setHint(this.caN.getString(R.string.hint_tip_input_name));
            this.dSW = (TextView) this.dSN.findViewById(R.id.back);
            this.dSW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aVn();
                    c.this.aVl();
                }
            });
            this.dSZ = (TextView) this.dSN.findViewById(R.id.confirm);
            this.dSZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aVk();
                }
            });
            this.dTa = (ProgressBar) this.dSN.findViewById(R.id.confirm_progress);
            this.dSY = (TextView) this.dSN.findViewById(R.id.error_info);
            this.dSQ = (RadioGroup) this.dSN.findViewById(R.id.names_group1);
            this.dSR = (RadioGroup) this.dSN.findViewById(R.id.names_group2);
            this.dST = (RadioButton) this.dSN.findViewById(R.id.name1);
            this.dSU = (RadioButton) this.dSN.findViewById(R.id.name2);
            this.dSV = (RadioButton) this.dSN.findViewById(R.id.name3);
            this.dSS = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.dST) {
                            c.this.dSR.clearCheck();
                            c.this.dST.setChecked(true);
                            c.this.dST.setCompoundDrawables(c.this.dTf, null, null, null);
                            c.this.dSU.setChecked(false);
                            c.this.dSU.setCompoundDrawables(c.this.dTg, null, null, null);
                            c.this.dSV.setChecked(false);
                            c.this.dSV.setCompoundDrawables(c.this.dTg, null, null, null);
                        } else if (compoundButton == c.this.dSU) {
                            c.this.dSR.clearCheck();
                            c.this.dST.setChecked(false);
                            c.this.dST.setCompoundDrawables(c.this.dTg, null, null, null);
                            c.this.dSU.setChecked(true);
                            c.this.dSU.setCompoundDrawables(c.this.dTf, null, null, null);
                            c.this.dSV.setChecked(false);
                            c.this.dSV.setCompoundDrawables(c.this.dTg, null, null, null);
                        } else if (compoundButton == c.this.dSV) {
                            c.this.dSQ.clearCheck();
                            c.this.dST.setChecked(false);
                            c.this.dST.setCompoundDrawables(c.this.dTg, null, null, null);
                            c.this.dSU.setChecked(false);
                            c.this.dSU.setCompoundDrawables(c.this.dTg, null, null, null);
                            c.this.dSV.setChecked(true);
                            c.this.dSV.setCompoundDrawables(c.this.dTf, null, null, null);
                        }
                        c.this.dSP.setText(compoundButton.getText());
                    }
                }
            };
            this.dST.setOnCheckedChangeListener(this.dSS);
            this.dSU.setOnCheckedChangeListener(this.dSS);
            this.dSV.setOnCheckedChangeListener(this.dSS);
            this.dTb = (TextView) this.dSN.findViewById(R.id.phone_info);
            aVm();
            this.dSO = new Dialog(this.caN, R.style.input_username_dialog);
            this.dSO.setCanceledOnTouchOutside(false);
            this.dSO.setCancelable(false);
            this.dSO.setCanceledOnTouchOutside(false);
            aVb();
        }
        if (i == 1) {
            this.dTb.setText(R.string.tip_init_user_name);
        } else {
            this.dTb.setText(R.string.bar_friend);
        }
        if (!this.dSO.isShowing()) {
            this.dSP.setText((CharSequence) null);
            aVm();
            vV(null);
            if (!this.caN.isFinishing()) {
                this.dSO.setContentView(this.dSN);
                g.showDialog(this.dSO, this.caN);
                if (this.caN instanceof BaseActivity) {
                    ((BaseActivity) this.caN).ShowSoftKeyPadDelay(this.dSP, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0439c(this.dSP), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0439c implements Runnable {
        private View mView;

        public RunnableC0439c(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.caN.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) c.this.caN.getSystemService("input_method");
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

    public void aVk() {
        String obj = this.dSP.getText().toString();
        if (obj == null || obj.length() <= 0) {
            vV(this.caN.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            vV(this.caN.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.dSX != null) {
                this.dSX.cancel();
            }
            if (!this.dTl && this.dTc != null) {
                this.dTa.setVisibility(0);
                this.dSZ.setEnabled(false);
                vV(null);
                aVm();
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
                        c.this.aVn();
                        l.showToast(c.this.caN, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.aId().a(session.username, session.bduss, "", null, c.this.dTm);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.vV(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.dTl = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.dTa.setVisibility(8);
                        c.this.dSZ.setEnabled(true);
                        c.this.dTl = false;
                    }
                }, this.dTc.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVl() {
        if (this.dTe != null) {
            this.dTe.g(null);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            vV(this.caN.getString(R.string.suggest_no_name));
            return;
        }
        vV(this.caN.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.dSQ.clearCheck();
        this.dSR.clearCheck();
        this.dSQ.setVisibility(0);
        this.dSR.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.dST.setText(arrayList.get(0));
            this.dST.setChecked(false);
            this.dST.setCompoundDrawables(this.dTg, null, null, null);
            this.dST.setVisibility(0);
            this.dSQ.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.dSU.setText(arrayList.get(1));
            this.dSU.setChecked(false);
            this.dSU.setCompoundDrawables(this.dTg, null, null, null);
            this.dSU.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.dSV.setText(arrayList.get(2));
            this.dSV.setChecked(false);
            this.dSV.setCompoundDrawables(this.dTg, null, null, null);
            this.dSV.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.dSX != null) {
            this.dSX.cancel();
            this.dSX = null;
        }
        aVn();
    }

    public void aVm() {
        this.dSQ.setVisibility(8);
        this.dSQ.clearCheck();
        this.dSR.setVisibility(8);
        this.dSR.clearCheck();
        this.dST.setVisibility(8);
        this.dSU.setVisibility(8);
        this.dSV.setVisibility(8);
        this.dST.setChecked(false);
        this.dSU.setChecked(false);
        this.dSV.setChecked(false);
    }

    public void aVn() {
        if (this.dSO != null && this.dSO.isShowing()) {
            g.dismissDialog(this.dSO, this.caN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV(String str) {
        if (str == null) {
            this.dSY.setVisibility(4);
            this.dSY.setText((CharSequence) null);
            return;
        }
        this.dSY.setVisibility(0);
        this.dSY.setText(str);
    }

    private void aVb() {
        am.setBackgroundResource(this.dSN, R.drawable.dialog_background);
        am.setViewTextColor(this.dTb, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dTh, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dSP, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.dTi, R.drawable.bg_search_input);
        am.setViewTextColor(this.dSY, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.dST, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dSU, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dSV, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.dTj, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dSW, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.dSW, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.dTk, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dSZ, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.dSZ, (int) R.color.cp_link_tip_a);
        this.dSP.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.dST.setCompoundDrawables(this.dTg, null, null, null);
        this.dSU.setCompoundDrawables(this.dTg, null, null, null);
        this.dSV.setCompoundDrawables(this.dTg, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ c dTn;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.dTn.dSX = null;
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
            this.dTn.dSX = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.dTn.vV(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.dTn.vV(this.dTn.caN.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.dTn.vV(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.dTn.D(kVar.aRQ());
                }
            } else {
                this.dTn.vV(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dTn.vV(null);
            this.dTn.aVm();
            super.onPreExecute();
        }
    }
}
