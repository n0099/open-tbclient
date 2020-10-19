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
    private Activity bFt;
    private Drawable eVj;
    private Drawable eVk;
    private TextView eVl;
    private View eVm;
    private View eVn;
    private View eVo;
    private a.InterfaceC0548a eVq;
    private int size;
    private View eUR = null;
    private Dialog eUS = null;
    private EditText eUT = null;
    private RadioGroup eUU = null;
    private RadioGroup eUV = null;
    private CompoundButton.OnCheckedChangeListener eUW = null;
    private RadioButton eUX = null;
    private RadioButton eUY = null;
    private RadioButton eUZ = null;
    private TextView eVa = null;
    private C0562b eVb = null;
    private TextView eVc = null;
    private TextView eVd = null;
    private ProgressBar eVe = null;
    private TextView eVf = null;
    private AccountData eVg = null;
    private a eVh = null;
    private a eVi = null;
    private boolean eVp = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.bFt = null;
        this.eVj = null;
        this.eVk = null;
        this.size = 0;
        this.bFt = activity;
        this.eVj = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.eVk = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.bFt.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.eVj.setBounds(0, 0, this.size, this.size);
        this.eVk.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0548a interfaceC0548a) {
        this.eVq = interfaceC0548a;
    }

    public void setAccountData(AccountData accountData) {
        this.eVg = accountData;
    }

    public void a(a aVar) {
        this.eVh = aVar;
    }

    public void b(a aVar) {
        this.eVi = aVar;
    }

    public void btv() {
        qy(0);
    }

    public void qy(int i) {
        if (this.eUS == null) {
            this.eUR = LayoutInflater.from(this.bFt).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.eVl = (TextView) this.eUR.findViewById(R.id.tip_info);
            this.eVm = this.eUR.findViewById(R.id.divider_under_account);
            this.eVn = this.eUR.findViewById(R.id.divider_under_radiongroup);
            this.eVo = this.eUR.findViewById(R.id.divider_with_yes_no_button);
            this.eUT = (EditText) this.eUR.findViewById(R.id.account);
            this.eUT.setHint(this.bFt.getString(R.string.hint_tip_input_name));
            this.eVa = (TextView) this.eUR.findViewById(R.id.back);
            this.eVa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.btz();
                    b.this.btx();
                }
            });
            this.eVd = (TextView) this.eUR.findViewById(R.id.confirm);
            this.eVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.btw();
                }
            });
            this.eVe = (ProgressBar) this.eUR.findViewById(R.id.confirm_progress);
            this.eVc = (TextView) this.eUR.findViewById(R.id.error_info);
            this.eUU = (RadioGroup) this.eUR.findViewById(R.id.names_group1);
            this.eUV = (RadioGroup) this.eUR.findViewById(R.id.names_group2);
            this.eUX = (RadioButton) this.eUR.findViewById(R.id.name1);
            this.eUY = (RadioButton) this.eUR.findViewById(R.id.name2);
            this.eUZ = (RadioButton) this.eUR.findViewById(R.id.name3);
            this.eUW = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.eUX) {
                            b.this.eUV.clearCheck();
                            b.this.eUX.setChecked(true);
                            b.this.eUX.setCompoundDrawables(b.this.eVj, null, null, null);
                            b.this.eUY.setChecked(false);
                            b.this.eUY.setCompoundDrawables(b.this.eVk, null, null, null);
                            b.this.eUZ.setChecked(false);
                            b.this.eUZ.setCompoundDrawables(b.this.eVk, null, null, null);
                        } else if (compoundButton == b.this.eUY) {
                            b.this.eUV.clearCheck();
                            b.this.eUX.setChecked(false);
                            b.this.eUX.setCompoundDrawables(b.this.eVk, null, null, null);
                            b.this.eUY.setChecked(true);
                            b.this.eUY.setCompoundDrawables(b.this.eVj, null, null, null);
                            b.this.eUZ.setChecked(false);
                            b.this.eUZ.setCompoundDrawables(b.this.eVk, null, null, null);
                        } else if (compoundButton == b.this.eUZ) {
                            b.this.eUU.clearCheck();
                            b.this.eUX.setChecked(false);
                            b.this.eUX.setCompoundDrawables(b.this.eVk, null, null, null);
                            b.this.eUY.setChecked(false);
                            b.this.eUY.setCompoundDrawables(b.this.eVk, null, null, null);
                            b.this.eUZ.setChecked(true);
                            b.this.eUZ.setCompoundDrawables(b.this.eVj, null, null, null);
                        }
                        b.this.eUT.setText(compoundButton.getText());
                    }
                }
            };
            this.eUX.setOnCheckedChangeListener(this.eUW);
            this.eUY.setOnCheckedChangeListener(this.eUW);
            this.eUZ.setOnCheckedChangeListener(this.eUW);
            this.eVf = (TextView) this.eUR.findViewById(R.id.phone_info);
            bty();
            this.eUS = new Dialog(this.bFt, R.style.input_username_dialog);
            this.eUS.setCanceledOnTouchOutside(false);
            this.eUS.setCancelable(false);
            this.eUS.setCanceledOnTouchOutside(false);
            btm();
        }
        if (i == 1) {
            this.eVf.setText(R.string.tip_init_user_name);
        } else {
            this.eVf.setText(R.string.bar_friend);
        }
        if (!this.eUS.isShowing()) {
            this.eUT.setText((CharSequence) null);
            bty();
            Cz(null);
            if (!this.bFt.isFinishing()) {
                this.eUS.setContentView(this.eUR);
                g.showDialog(this.eUS, this.bFt);
                if (this.bFt instanceof BaseActivity) {
                    ((BaseActivity) this.bFt).ShowSoftKeyPadDelay(this.eUT, 150);
                } else {
                    new Handler().postDelayed(new c(this.eUT), 150L);
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
            if (!b.this.bFt.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.bFt.getSystemService("input_method");
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

    public void btw() {
        String obj = this.eUT.getText().toString();
        if (obj == null || obj.length() <= 0) {
            Cz(this.bFt.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            Cz(this.bFt.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.eVb != null) {
                this.eVb.cancel();
            }
            if (!this.eVp && this.eVg != null) {
                this.eVe.setVisibility(0);
                this.eVd.setEnabled(false);
                Cz(null);
                bty();
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
                        b.this.btz();
                        l.showToast(b.this.bFt, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bfp().a(session.username, session.bduss, "", null, b.this.eVq);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.Cz(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.eVp = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.eVe.setVisibility(8);
                        b.this.eVd.setEnabled(true);
                        b.this.eVp = false;
                    }
                }, this.eVg.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btx() {
        if (this.eVi != null) {
            this.eVi.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            Cz(this.bFt.getString(R.string.suggest_no_name));
            return;
        }
        Cz(this.bFt.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.eUU.clearCheck();
        this.eUV.clearCheck();
        this.eUU.setVisibility(0);
        this.eUV.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.eUX.setText(arrayList.get(0));
            this.eUX.setChecked(false);
            this.eUX.setCompoundDrawables(this.eVk, null, null, null);
            this.eUX.setVisibility(0);
            this.eUU.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.eUY.setText(arrayList.get(1));
            this.eUY.setChecked(false);
            this.eUY.setCompoundDrawables(this.eVk, null, null, null);
            this.eUY.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.eUZ.setText(arrayList.get(2));
            this.eUZ.setChecked(false);
            this.eUZ.setCompoundDrawables(this.eVk, null, null, null);
            this.eUZ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.eVb != null) {
            this.eVb.cancel();
            this.eVb = null;
        }
        btz();
    }

    public void bty() {
        this.eUU.setVisibility(8);
        this.eUU.clearCheck();
        this.eUV.setVisibility(8);
        this.eUV.clearCheck();
        this.eUX.setVisibility(8);
        this.eUY.setVisibility(8);
        this.eUZ.setVisibility(8);
        this.eUX.setChecked(false);
        this.eUY.setChecked(false);
        this.eUZ.setChecked(false);
    }

    public void btz() {
        if (this.eUS != null && this.eUS.isShowing()) {
            g.dismissDialog(this.eUS, this.bFt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz(String str) {
        if (str == null) {
            this.eVc.setVisibility(4);
            this.eVc.setText((CharSequence) null);
            return;
        }
        this.eVc.setVisibility(0);
        this.eVc.setText(str);
    }

    private void btm() {
        ap.setBackgroundResource(this.eUR, R.drawable.dialog_background);
        ap.setViewTextColor(this.eVf, R.color.cp_cont_b);
        ap.setViewTextColor(this.eVl, R.color.cp_cont_f);
        ap.setViewTextColor(this.eUT, R.color.cp_cont_b);
        ap.setBackgroundResource(this.eVm, R.drawable.bg_search_input);
        ap.setViewTextColor(this.eVc, R.color.cp_cont_h);
        ap.setViewTextColor(this.eUX, R.color.cp_cont_b);
        ap.setViewTextColor(this.eUY, R.color.cp_cont_b);
        ap.setViewTextColor(this.eUZ, R.color.cp_cont_b);
        ap.setBackgroundColor(this.eVn, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eVa, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.eVa, R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.eVo, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eVd, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.eVd, R.color.cp_link_tip_a);
        this.eUT.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.eUX.setCompoundDrawables(this.eVk, null, null, null);
        this.eUY.setCompoundDrawables(this.eVk, null, null, null);
        this.eUZ.setCompoundDrawables(this.eVk, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0562b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b eVr;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.eVr.eVb = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: E */
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
            this.eVr.eVb = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.eVr.Cz(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.eVr.Cz(this.eVr.bFt.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.eVr.Cz(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.eVr.K(oVar.bqo());
                }
            } else {
                this.eVr.Cz(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eVr.Cz(null);
            this.eVr.bty();
            super.onPreExecute();
        }
    }
}
