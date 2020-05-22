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
public class b {
    private Activity clq;
    private Drawable ehp;
    private Drawable ehq;
    private TextView ehr;
    private View ehs;
    private View eht;
    private View ehu;
    private a.InterfaceC0472a ehw;
    private int size;
    private View egX = null;
    private Dialog egY = null;
    private EditText egZ = null;
    private RadioGroup eha = null;
    private RadioGroup ehb = null;
    private CompoundButton.OnCheckedChangeListener ehc = null;
    private RadioButton ehd = null;
    private RadioButton ehe = null;
    private RadioButton ehf = null;
    private TextView ehg = null;
    private C0486b ehh = null;
    private TextView ehi = null;
    private TextView ehj = null;
    private ProgressBar ehk = null;
    private TextView ehl = null;
    private AccountData ehm = null;
    private a ehn = null;
    private a eho = null;
    private boolean ehv = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.clq = null;
        this.ehp = null;
        this.ehq = null;
        this.size = 0;
        this.clq = activity;
        this.ehp = am.getDrawable(R.drawable.icon_tips_names_s);
        this.ehq = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.clq.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.ehp.setBounds(0, 0, this.size, this.size);
        this.ehq.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0472a interfaceC0472a) {
        this.ehw = interfaceC0472a;
    }

    public void setAccountData(AccountData accountData) {
        this.ehm = accountData;
    }

    public void a(a aVar) {
        this.ehn = aVar;
    }

    public void b(a aVar) {
        this.eho = aVar;
    }

    public void bbs() {
        mO(0);
    }

    public void mO(int i) {
        if (this.egY == null) {
            this.egX = LayoutInflater.from(this.clq).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.ehr = (TextView) this.egX.findViewById(R.id.tip_info);
            this.ehs = this.egX.findViewById(R.id.divider_under_account);
            this.eht = this.egX.findViewById(R.id.divider_under_radiongroup);
            this.ehu = this.egX.findViewById(R.id.divider_with_yes_no_button);
            this.egZ = (EditText) this.egX.findViewById(R.id.account);
            this.egZ.setHint(this.clq.getString(R.string.hint_tip_input_name));
            this.ehg = (TextView) this.egX.findViewById(R.id.back);
            this.ehg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bbw();
                    b.this.bbu();
                }
            });
            this.ehj = (TextView) this.egX.findViewById(R.id.confirm);
            this.ehj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bbt();
                }
            });
            this.ehk = (ProgressBar) this.egX.findViewById(R.id.confirm_progress);
            this.ehi = (TextView) this.egX.findViewById(R.id.error_info);
            this.eha = (RadioGroup) this.egX.findViewById(R.id.names_group1);
            this.ehb = (RadioGroup) this.egX.findViewById(R.id.names_group2);
            this.ehd = (RadioButton) this.egX.findViewById(R.id.name1);
            this.ehe = (RadioButton) this.egX.findViewById(R.id.name2);
            this.ehf = (RadioButton) this.egX.findViewById(R.id.name3);
            this.ehc = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.ehd) {
                            b.this.ehb.clearCheck();
                            b.this.ehd.setChecked(true);
                            b.this.ehd.setCompoundDrawables(b.this.ehp, null, null, null);
                            b.this.ehe.setChecked(false);
                            b.this.ehe.setCompoundDrawables(b.this.ehq, null, null, null);
                            b.this.ehf.setChecked(false);
                            b.this.ehf.setCompoundDrawables(b.this.ehq, null, null, null);
                        } else if (compoundButton == b.this.ehe) {
                            b.this.ehb.clearCheck();
                            b.this.ehd.setChecked(false);
                            b.this.ehd.setCompoundDrawables(b.this.ehq, null, null, null);
                            b.this.ehe.setChecked(true);
                            b.this.ehe.setCompoundDrawables(b.this.ehp, null, null, null);
                            b.this.ehf.setChecked(false);
                            b.this.ehf.setCompoundDrawables(b.this.ehq, null, null, null);
                        } else if (compoundButton == b.this.ehf) {
                            b.this.eha.clearCheck();
                            b.this.ehd.setChecked(false);
                            b.this.ehd.setCompoundDrawables(b.this.ehq, null, null, null);
                            b.this.ehe.setChecked(false);
                            b.this.ehe.setCompoundDrawables(b.this.ehq, null, null, null);
                            b.this.ehf.setChecked(true);
                            b.this.ehf.setCompoundDrawables(b.this.ehp, null, null, null);
                        }
                        b.this.egZ.setText(compoundButton.getText());
                    }
                }
            };
            this.ehd.setOnCheckedChangeListener(this.ehc);
            this.ehe.setOnCheckedChangeListener(this.ehc);
            this.ehf.setOnCheckedChangeListener(this.ehc);
            this.ehl = (TextView) this.egX.findViewById(R.id.phone_info);
            bbv();
            this.egY = new Dialog(this.clq, R.style.input_username_dialog);
            this.egY.setCanceledOnTouchOutside(false);
            this.egY.setCancelable(false);
            this.egY.setCanceledOnTouchOutside(false);
            bbl();
        }
        if (i == 1) {
            this.ehl.setText(R.string.tip_init_user_name);
        } else {
            this.ehl.setText(R.string.bar_friend);
        }
        if (!this.egY.isShowing()) {
            this.egZ.setText((CharSequence) null);
            bbv();
            xB(null);
            if (!this.clq.isFinishing()) {
                this.egY.setContentView(this.egX);
                g.showDialog(this.egY, this.clq);
                if (this.clq instanceof BaseActivity) {
                    ((BaseActivity) this.clq).ShowSoftKeyPadDelay(this.egZ, 150);
                } else {
                    new Handler().postDelayed(new c(this.egZ), 150L);
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
            if (!b.this.clq.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.clq.getSystemService("input_method");
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

    public void bbt() {
        String obj = this.egZ.getText().toString();
        if (obj == null || obj.length() <= 0) {
            xB(this.clq.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            xB(this.clq.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.ehh != null) {
                this.ehh.cancel();
            }
            if (!this.ehv && this.ehm != null) {
                this.ehk.setVisibility(0);
                this.ehj.setEnabled(false);
                xB(null);
                bbv();
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
                        b.this.bbw();
                        l.showToast(b.this.clq, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.aNR().a(session.username, session.bduss, "", null, b.this.ehw);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.xB(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.ehv = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.ehk.setVisibility(8);
                        b.this.ehj.setEnabled(true);
                        b.this.ehv = false;
                    }
                }, this.ehm.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbu() {
        if (this.eho != null) {
            this.eho.g(null);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            xB(this.clq.getString(R.string.suggest_no_name));
            return;
        }
        xB(this.clq.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.eha.clearCheck();
        this.ehb.clearCheck();
        this.eha.setVisibility(0);
        this.ehb.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.ehd.setText(arrayList.get(0));
            this.ehd.setChecked(false);
            this.ehd.setCompoundDrawables(this.ehq, null, null, null);
            this.ehd.setVisibility(0);
            this.eha.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.ehe.setText(arrayList.get(1));
            this.ehe.setChecked(false);
            this.ehe.setCompoundDrawables(this.ehq, null, null, null);
            this.ehe.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.ehf.setText(arrayList.get(2));
            this.ehf.setChecked(false);
            this.ehf.setCompoundDrawables(this.ehq, null, null, null);
            this.ehf.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.ehh != null) {
            this.ehh.cancel();
            this.ehh = null;
        }
        bbw();
    }

    public void bbv() {
        this.eha.setVisibility(8);
        this.eha.clearCheck();
        this.ehb.setVisibility(8);
        this.ehb.clearCheck();
        this.ehd.setVisibility(8);
        this.ehe.setVisibility(8);
        this.ehf.setVisibility(8);
        this.ehd.setChecked(false);
        this.ehe.setChecked(false);
        this.ehf.setChecked(false);
    }

    public void bbw() {
        if (this.egY != null && this.egY.isShowing()) {
            g.dismissDialog(this.egY, this.clq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xB(String str) {
        if (str == null) {
            this.ehi.setVisibility(4);
            this.ehi.setText((CharSequence) null);
            return;
        }
        this.ehi.setVisibility(0);
        this.ehi.setText(str);
    }

    private void bbl() {
        am.setBackgroundResource(this.egX, R.drawable.dialog_background);
        am.setViewTextColor(this.ehl, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ehr, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.egZ, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.ehs, R.drawable.bg_search_input);
        am.setViewTextColor(this.ehi, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.ehd, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ehe, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.ehf, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.eht, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ehg, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.ehg, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.ehu, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.ehj, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.ehj, (int) R.color.cp_link_tip_a);
        this.egZ.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.ehd.setCompoundDrawables(this.ehq, null, null, null);
        this.ehe.setCompoundDrawables(this.ehq, null, null, null);
        this.ehf.setCompoundDrawables(this.ehq, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0486b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ b ehx;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.ehx.ehh = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
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
            this.ehx.ehh = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.ehx.xB(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.ehx.xB(this.ehx.clq.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.ehx.xB(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.ehx.D(kVar.aXX());
                }
            } else {
                this.ehx.xB(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ehx.xB(null);
            this.ehx.bbv();
            super.onPreExecute();
        }
    }
}
