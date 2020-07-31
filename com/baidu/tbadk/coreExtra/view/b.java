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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private Activity bdG;
    private Drawable ewr;
    private Drawable ews;
    private TextView ewt;
    private View ewu;
    private View ewv;
    private View eww;
    private a.InterfaceC0490a ewy;
    private int size;
    private View evZ = null;
    private Dialog ewa = null;
    private EditText ewb = null;
    private RadioGroup ewc = null;
    private RadioGroup ewd = null;
    private CompoundButton.OnCheckedChangeListener ewe = null;
    private RadioButton ewf = null;
    private RadioButton ewg = null;
    private RadioButton ewh = null;
    private TextView ewi = null;
    private C0504b ewj = null;
    private TextView ewk = null;
    private TextView ewl = null;
    private ProgressBar ewm = null;
    private TextView ewn = null;
    private AccountData ewo = null;
    private a ewp = null;
    private a ewq = null;
    private boolean ewx = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.bdG = null;
        this.ewr = null;
        this.ews = null;
        this.size = 0;
        this.bdG = activity;
        this.ewr = ao.getDrawable(R.drawable.icon_tips_names_s);
        this.ews = ao.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.bdG.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.ewr.setBounds(0, 0, this.size, this.size);
        this.ews.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0490a interfaceC0490a) {
        this.ewy = interfaceC0490a;
    }

    public void setAccountData(AccountData accountData) {
        this.ewo = accountData;
    }

    public void a(a aVar) {
        this.ewp = aVar;
    }

    public void b(a aVar) {
        this.ewq = aVar;
    }

    public void bhe() {
        nC(0);
    }

    public void nC(int i) {
        if (this.ewa == null) {
            this.evZ = LayoutInflater.from(this.bdG).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.ewt = (TextView) this.evZ.findViewById(R.id.tip_info);
            this.ewu = this.evZ.findViewById(R.id.divider_under_account);
            this.ewv = this.evZ.findViewById(R.id.divider_under_radiongroup);
            this.eww = this.evZ.findViewById(R.id.divider_with_yes_no_button);
            this.ewb = (EditText) this.evZ.findViewById(R.id.account);
            this.ewb.setHint(this.bdG.getString(R.string.hint_tip_input_name));
            this.ewi = (TextView) this.evZ.findViewById(R.id.back);
            this.ewi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bhi();
                    b.this.bhg();
                }
            });
            this.ewl = (TextView) this.evZ.findViewById(R.id.confirm);
            this.ewl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bhf();
                }
            });
            this.ewm = (ProgressBar) this.evZ.findViewById(R.id.confirm_progress);
            this.ewk = (TextView) this.evZ.findViewById(R.id.error_info);
            this.ewc = (RadioGroup) this.evZ.findViewById(R.id.names_group1);
            this.ewd = (RadioGroup) this.evZ.findViewById(R.id.names_group2);
            this.ewf = (RadioButton) this.evZ.findViewById(R.id.name1);
            this.ewg = (RadioButton) this.evZ.findViewById(R.id.name2);
            this.ewh = (RadioButton) this.evZ.findViewById(R.id.name3);
            this.ewe = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.ewf) {
                            b.this.ewd.clearCheck();
                            b.this.ewf.setChecked(true);
                            b.this.ewf.setCompoundDrawables(b.this.ewr, null, null, null);
                            b.this.ewg.setChecked(false);
                            b.this.ewg.setCompoundDrawables(b.this.ews, null, null, null);
                            b.this.ewh.setChecked(false);
                            b.this.ewh.setCompoundDrawables(b.this.ews, null, null, null);
                        } else if (compoundButton == b.this.ewg) {
                            b.this.ewd.clearCheck();
                            b.this.ewf.setChecked(false);
                            b.this.ewf.setCompoundDrawables(b.this.ews, null, null, null);
                            b.this.ewg.setChecked(true);
                            b.this.ewg.setCompoundDrawables(b.this.ewr, null, null, null);
                            b.this.ewh.setChecked(false);
                            b.this.ewh.setCompoundDrawables(b.this.ews, null, null, null);
                        } else if (compoundButton == b.this.ewh) {
                            b.this.ewc.clearCheck();
                            b.this.ewf.setChecked(false);
                            b.this.ewf.setCompoundDrawables(b.this.ews, null, null, null);
                            b.this.ewg.setChecked(false);
                            b.this.ewg.setCompoundDrawables(b.this.ews, null, null, null);
                            b.this.ewh.setChecked(true);
                            b.this.ewh.setCompoundDrawables(b.this.ewr, null, null, null);
                        }
                        b.this.ewb.setText(compoundButton.getText());
                    }
                }
            };
            this.ewf.setOnCheckedChangeListener(this.ewe);
            this.ewg.setOnCheckedChangeListener(this.ewe);
            this.ewh.setOnCheckedChangeListener(this.ewe);
            this.ewn = (TextView) this.evZ.findViewById(R.id.phone_info);
            bhh();
            this.ewa = new Dialog(this.bdG, R.style.input_username_dialog);
            this.ewa.setCanceledOnTouchOutside(false);
            this.ewa.setCancelable(false);
            this.ewa.setCanceledOnTouchOutside(false);
            bgV();
        }
        if (i == 1) {
            this.ewn.setText(R.string.tip_init_user_name);
        } else {
            this.ewn.setText(R.string.bar_friend);
        }
        if (!this.ewa.isShowing()) {
            this.ewb.setText((CharSequence) null);
            bhh();
            za(null);
            if (!this.bdG.isFinishing()) {
                this.ewa.setContentView(this.evZ);
                g.showDialog(this.ewa, this.bdG);
                if (this.bdG instanceof BaseActivity) {
                    ((BaseActivity) this.bdG).ShowSoftKeyPadDelay(this.ewb, 150);
                } else {
                    new Handler().postDelayed(new c(this.ewb), 150L);
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
            if (!b.this.bdG.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.bdG.getSystemService("input_method");
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

    public void bhf() {
        String obj = this.ewb.getText().toString();
        if (obj == null || obj.length() <= 0) {
            za(this.bdG.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            za(this.bdG.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.ewj != null) {
                this.ewj.cancel();
            }
            if (!this.ewx && this.ewo != null) {
                this.ewm.setVisibility(0);
                this.ewl.setEnabled(false);
                za(null);
                bhh();
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
                        b.this.bhi();
                        l.showToast(b.this.bdG, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.aTw().a(session.username, session.bduss, "", null, b.this.ewy);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.za(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.ewx = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.ewm.setVisibility(8);
                        b.this.ewl.setEnabled(true);
                        b.this.ewx = false;
                    }
                }, this.ewo.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhg() {
        if (this.ewq != null) {
            this.ewq.g(null);
        }
    }

    public void E(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            za(this.bdG.getString(R.string.suggest_no_name));
            return;
        }
        za(this.bdG.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.ewc.clearCheck();
        this.ewd.clearCheck();
        this.ewc.setVisibility(0);
        this.ewd.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.ewf.setText(arrayList.get(0));
            this.ewf.setChecked(false);
            this.ewf.setCompoundDrawables(this.ews, null, null, null);
            this.ewf.setVisibility(0);
            this.ewc.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.ewg.setText(arrayList.get(1));
            this.ewg.setChecked(false);
            this.ewg.setCompoundDrawables(this.ews, null, null, null);
            this.ewg.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.ewh.setText(arrayList.get(2));
            this.ewh.setChecked(false);
            this.ewh.setCompoundDrawables(this.ews, null, null, null);
            this.ewh.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.ewj != null) {
            this.ewj.cancel();
            this.ewj = null;
        }
        bhi();
    }

    public void bhh() {
        this.ewc.setVisibility(8);
        this.ewc.clearCheck();
        this.ewd.setVisibility(8);
        this.ewd.clearCheck();
        this.ewf.setVisibility(8);
        this.ewg.setVisibility(8);
        this.ewh.setVisibility(8);
        this.ewf.setChecked(false);
        this.ewg.setChecked(false);
        this.ewh.setChecked(false);
    }

    public void bhi() {
        if (this.ewa != null && this.ewa.isShowing()) {
            g.dismissDialog(this.ewa, this.bdG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za(String str) {
        if (str == null) {
            this.ewk.setVisibility(4);
            this.ewk.setText((CharSequence) null);
            return;
        }
        this.ewk.setVisibility(0);
        this.ewk.setText(str);
    }

    private void bgV() {
        ao.setBackgroundResource(this.evZ, R.drawable.dialog_background);
        ao.setViewTextColor(this.ewn, R.color.cp_cont_b);
        ao.setViewTextColor(this.ewt, R.color.cp_cont_f);
        ao.setViewTextColor(this.ewb, R.color.cp_cont_b);
        ao.setBackgroundResource(this.ewu, R.drawable.bg_search_input);
        ao.setViewTextColor(this.ewk, R.color.cp_cont_h);
        ao.setViewTextColor(this.ewf, R.color.cp_cont_b);
        ao.setViewTextColor(this.ewg, R.color.cp_cont_b);
        ao.setViewTextColor(this.ewh, R.color.cp_cont_b);
        ao.setBackgroundColor(this.ewv, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.ewi, R.drawable.dialog_left_button_selector);
        ao.setViewTextColor(this.ewi, R.color.cp_link_tip_a);
        ao.setBackgroundColor(this.eww, R.color.cp_bg_line_c);
        ao.setBackgroundResource(this.ewl, R.drawable.dialog_right_button_selector);
        ao.setViewTextColor(this.ewl, R.color.cp_link_tip_a);
        this.ewb.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        this.ewf.setCompoundDrawables(this.ews, null, null, null);
        this.ewg.setCompoundDrawables(this.ews, null, null, null);
        this.ewh.setCompoundDrawables(this.ews, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0504b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ b ewz;
        private String mAccount;
        private z mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.ewz.ewj = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public k doInBackground(String... strArr) {
            this.mNetwork = new z(this.mUrl);
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
            this.ewz.ewj = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.ewz.za(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.ewz.za(this.ewz.bdG.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.ewz.za(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.ewz.E(kVar.bea());
                }
            } else {
                this.ewz.za(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.ewz.za(null);
            this.ewz.bhh();
            super.onPreExecute();
        }
    }
}
