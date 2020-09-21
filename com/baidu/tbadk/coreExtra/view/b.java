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
    private Activity byQ;
    private Drawable eJc;
    private Drawable eJd;
    private TextView eJe;
    private View eJf;
    private View eJg;
    private View eJh;
    private a.InterfaceC0531a eJj;
    private int size;
    private View eIK = null;
    private Dialog eIL = null;
    private EditText eIM = null;
    private RadioGroup eIN = null;
    private RadioGroup eIO = null;
    private CompoundButton.OnCheckedChangeListener eIP = null;
    private RadioButton eIQ = null;
    private RadioButton eIR = null;
    private RadioButton eIS = null;
    private TextView eIT = null;
    private C0545b eIU = null;
    private TextView eIV = null;
    private TextView eIW = null;
    private ProgressBar eIX = null;
    private TextView eIY = null;
    private AccountData eIZ = null;
    private a eJa = null;
    private a eJb = null;
    private boolean eJi = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.byQ = null;
        this.eJc = null;
        this.eJd = null;
        this.size = 0;
        this.byQ = activity;
        this.eJc = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.eJd = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.byQ.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.eJc.setBounds(0, 0, this.size, this.size);
        this.eJd.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0531a interfaceC0531a) {
        this.eJj = interfaceC0531a;
    }

    public void setAccountData(AccountData accountData) {
        this.eIZ = accountData;
    }

    public void a(a aVar) {
        this.eJa = aVar;
    }

    public void b(a aVar) {
        this.eJb = aVar;
    }

    public void bqL() {
        qa(0);
    }

    public void qa(int i) {
        if (this.eIL == null) {
            this.eIK = LayoutInflater.from(this.byQ).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.eJe = (TextView) this.eIK.findViewById(R.id.tip_info);
            this.eJf = this.eIK.findViewById(R.id.divider_under_account);
            this.eJg = this.eIK.findViewById(R.id.divider_under_radiongroup);
            this.eJh = this.eIK.findViewById(R.id.divider_with_yes_no_button);
            this.eIM = (EditText) this.eIK.findViewById(R.id.account);
            this.eIM.setHint(this.byQ.getString(R.string.hint_tip_input_name));
            this.eIT = (TextView) this.eIK.findViewById(R.id.back);
            this.eIT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bqP();
                    b.this.bqN();
                }
            });
            this.eIW = (TextView) this.eIK.findViewById(R.id.confirm);
            this.eIW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bqM();
                }
            });
            this.eIX = (ProgressBar) this.eIK.findViewById(R.id.confirm_progress);
            this.eIV = (TextView) this.eIK.findViewById(R.id.error_info);
            this.eIN = (RadioGroup) this.eIK.findViewById(R.id.names_group1);
            this.eIO = (RadioGroup) this.eIK.findViewById(R.id.names_group2);
            this.eIQ = (RadioButton) this.eIK.findViewById(R.id.name1);
            this.eIR = (RadioButton) this.eIK.findViewById(R.id.name2);
            this.eIS = (RadioButton) this.eIK.findViewById(R.id.name3);
            this.eIP = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.eIQ) {
                            b.this.eIO.clearCheck();
                            b.this.eIQ.setChecked(true);
                            b.this.eIQ.setCompoundDrawables(b.this.eJc, null, null, null);
                            b.this.eIR.setChecked(false);
                            b.this.eIR.setCompoundDrawables(b.this.eJd, null, null, null);
                            b.this.eIS.setChecked(false);
                            b.this.eIS.setCompoundDrawables(b.this.eJd, null, null, null);
                        } else if (compoundButton == b.this.eIR) {
                            b.this.eIO.clearCheck();
                            b.this.eIQ.setChecked(false);
                            b.this.eIQ.setCompoundDrawables(b.this.eJd, null, null, null);
                            b.this.eIR.setChecked(true);
                            b.this.eIR.setCompoundDrawables(b.this.eJc, null, null, null);
                            b.this.eIS.setChecked(false);
                            b.this.eIS.setCompoundDrawables(b.this.eJd, null, null, null);
                        } else if (compoundButton == b.this.eIS) {
                            b.this.eIN.clearCheck();
                            b.this.eIQ.setChecked(false);
                            b.this.eIQ.setCompoundDrawables(b.this.eJd, null, null, null);
                            b.this.eIR.setChecked(false);
                            b.this.eIR.setCompoundDrawables(b.this.eJd, null, null, null);
                            b.this.eIS.setChecked(true);
                            b.this.eIS.setCompoundDrawables(b.this.eJc, null, null, null);
                        }
                        b.this.eIM.setText(compoundButton.getText());
                    }
                }
            };
            this.eIQ.setOnCheckedChangeListener(this.eIP);
            this.eIR.setOnCheckedChangeListener(this.eIP);
            this.eIS.setOnCheckedChangeListener(this.eIP);
            this.eIY = (TextView) this.eIK.findViewById(R.id.phone_info);
            bqO();
            this.eIL = new Dialog(this.byQ, R.style.input_username_dialog);
            this.eIL.setCanceledOnTouchOutside(false);
            this.eIL.setCancelable(false);
            this.eIL.setCanceledOnTouchOutside(false);
            bqC();
        }
        if (i == 1) {
            this.eIY.setText(R.string.tip_init_user_name);
        } else {
            this.eIY.setText(R.string.bar_friend);
        }
        if (!this.eIL.isShowing()) {
            this.eIM.setText((CharSequence) null);
            bqO();
            BN(null);
            if (!this.byQ.isFinishing()) {
                this.eIL.setContentView(this.eIK);
                g.showDialog(this.eIL, this.byQ);
                if (this.byQ instanceof BaseActivity) {
                    ((BaseActivity) this.byQ).ShowSoftKeyPadDelay(this.eIM, 150);
                } else {
                    new Handler().postDelayed(new c(this.eIM), 150L);
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
            if (!b.this.byQ.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.byQ.getSystemService("input_method");
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

    public void bqM() {
        String obj = this.eIM.getText().toString();
        if (obj == null || obj.length() <= 0) {
            BN(this.byQ.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            BN(this.byQ.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.eIU != null) {
                this.eIU.cancel();
            }
            if (!this.eJi && this.eIZ != null) {
                this.eIX.setVisibility(0);
                this.eIW.setEnabled(false);
                BN(null);
                bqO();
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
                        b.this.bqP();
                        l.showToast(b.this.byQ, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bcH().a(session.username, session.bduss, "", null, b.this.eJj);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.BN(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.eJi = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.eIX.setVisibility(8);
                        b.this.eIW.setEnabled(true);
                        b.this.eJi = false;
                    }
                }, this.eIZ.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqN() {
        if (this.eJb != null) {
            this.eJb.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            BN(this.byQ.getString(R.string.suggest_no_name));
            return;
        }
        BN(this.byQ.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.eIN.clearCheck();
        this.eIO.clearCheck();
        this.eIN.setVisibility(0);
        this.eIO.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.eIQ.setText(arrayList.get(0));
            this.eIQ.setChecked(false);
            this.eIQ.setCompoundDrawables(this.eJd, null, null, null);
            this.eIQ.setVisibility(0);
            this.eIN.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.eIR.setText(arrayList.get(1));
            this.eIR.setChecked(false);
            this.eIR.setCompoundDrawables(this.eJd, null, null, null);
            this.eIR.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.eIS.setText(arrayList.get(2));
            this.eIS.setChecked(false);
            this.eIS.setCompoundDrawables(this.eJd, null, null, null);
            this.eIS.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.eIU != null) {
            this.eIU.cancel();
            this.eIU = null;
        }
        bqP();
    }

    public void bqO() {
        this.eIN.setVisibility(8);
        this.eIN.clearCheck();
        this.eIO.setVisibility(8);
        this.eIO.clearCheck();
        this.eIQ.setVisibility(8);
        this.eIR.setVisibility(8);
        this.eIS.setVisibility(8);
        this.eIQ.setChecked(false);
        this.eIR.setChecked(false);
        this.eIS.setChecked(false);
    }

    public void bqP() {
        if (this.eIL != null && this.eIL.isShowing()) {
            g.dismissDialog(this.eIL, this.byQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BN(String str) {
        if (str == null) {
            this.eIV.setVisibility(4);
            this.eIV.setText((CharSequence) null);
            return;
        }
        this.eIV.setVisibility(0);
        this.eIV.setText(str);
    }

    private void bqC() {
        ap.setBackgroundResource(this.eIK, R.drawable.dialog_background);
        ap.setViewTextColor(this.eIY, R.color.cp_cont_b);
        ap.setViewTextColor(this.eJe, R.color.cp_cont_f);
        ap.setViewTextColor(this.eIM, R.color.cp_cont_b);
        ap.setBackgroundResource(this.eJf, R.drawable.bg_search_input);
        ap.setViewTextColor(this.eIV, R.color.cp_cont_h);
        ap.setViewTextColor(this.eIQ, R.color.cp_cont_b);
        ap.setViewTextColor(this.eIR, R.color.cp_cont_b);
        ap.setViewTextColor(this.eIS, R.color.cp_cont_b);
        ap.setBackgroundColor(this.eJg, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eIT, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.eIT, R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.eJh, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eIW, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.eIW, R.color.cp_link_tip_a);
        this.eIM.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.eIQ.setCompoundDrawables(this.eJd, null, null, null);
        this.eIR.setCompoundDrawables(this.eJd, null, null, null);
        this.eIS.setCompoundDrawables(this.eJd, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0545b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b eJk;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.eJk.eIU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: D */
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
            this.eJk.eIU = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.eJk.BN(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.eJk.BN(this.eJk.byQ.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.eJk.BN(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.eJk.K(oVar.bnE());
                }
            } else {
                this.eJk.BN(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eJk.BN(null);
            this.eJk.bqO();
            super.onPreExecute();
        }
    }
}
