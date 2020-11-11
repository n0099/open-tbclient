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
    private Activity bNY;
    private TextView fjA;
    private View fjB;
    private View fjC;
    private View fjD;
    private a.InterfaceC0574a fjF;
    private Drawable fjy;
    private Drawable fjz;
    private int size;
    private View fjh = null;
    private Dialog fji = null;
    private EditText fjj = null;
    private RadioGroup fjk = null;
    private RadioGroup fjl = null;
    private CompoundButton.OnCheckedChangeListener fjm = null;
    private RadioButton fjn = null;
    private RadioButton fjo = null;
    private RadioButton fjp = null;
    private TextView fjq = null;
    private C0588b fjr = null;
    private TextView fjs = null;
    private TextView bPM = null;
    private ProgressBar fjt = null;
    private TextView fju = null;
    private AccountData fjv = null;
    private a fjw = null;
    private a fjx = null;
    private boolean fjE = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.bNY = null;
        this.fjy = null;
        this.fjz = null;
        this.size = 0;
        this.bNY = activity;
        this.fjy = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.fjz = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.bNY.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.fjy.setBounds(0, 0, this.size, this.size);
        this.fjz.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0574a interfaceC0574a) {
        this.fjF = interfaceC0574a;
    }

    public void setAccountData(AccountData accountData) {
        this.fjv = accountData;
    }

    public void a(a aVar) {
        this.fjw = aVar;
    }

    public void b(a aVar) {
        this.fjx = aVar;
    }

    public void bxN() {
        qT(0);
    }

    public void qT(int i) {
        if (this.fji == null) {
            this.fjh = LayoutInflater.from(this.bNY).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.fjA = (TextView) this.fjh.findViewById(R.id.tip_info);
            this.fjB = this.fjh.findViewById(R.id.divider_under_account);
            this.fjC = this.fjh.findViewById(R.id.divider_under_radiongroup);
            this.fjD = this.fjh.findViewById(R.id.divider_with_yes_no_button);
            this.fjj = (EditText) this.fjh.findViewById(R.id.account);
            this.fjj.setHint(this.bNY.getString(R.string.hint_tip_input_name));
            this.fjq = (TextView) this.fjh.findViewById(R.id.back);
            this.fjq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bxR();
                    b.this.bxP();
                }
            });
            this.bPM = (TextView) this.fjh.findViewById(R.id.confirm);
            this.bPM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bxO();
                }
            });
            this.fjt = (ProgressBar) this.fjh.findViewById(R.id.confirm_progress);
            this.fjs = (TextView) this.fjh.findViewById(R.id.error_info);
            this.fjk = (RadioGroup) this.fjh.findViewById(R.id.names_group1);
            this.fjl = (RadioGroup) this.fjh.findViewById(R.id.names_group2);
            this.fjn = (RadioButton) this.fjh.findViewById(R.id.name1);
            this.fjo = (RadioButton) this.fjh.findViewById(R.id.name2);
            this.fjp = (RadioButton) this.fjh.findViewById(R.id.name3);
            this.fjm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.fjn) {
                            b.this.fjl.clearCheck();
                            b.this.fjn.setChecked(true);
                            b.this.fjn.setCompoundDrawables(b.this.fjy, null, null, null);
                            b.this.fjo.setChecked(false);
                            b.this.fjo.setCompoundDrawables(b.this.fjz, null, null, null);
                            b.this.fjp.setChecked(false);
                            b.this.fjp.setCompoundDrawables(b.this.fjz, null, null, null);
                        } else if (compoundButton == b.this.fjo) {
                            b.this.fjl.clearCheck();
                            b.this.fjn.setChecked(false);
                            b.this.fjn.setCompoundDrawables(b.this.fjz, null, null, null);
                            b.this.fjo.setChecked(true);
                            b.this.fjo.setCompoundDrawables(b.this.fjy, null, null, null);
                            b.this.fjp.setChecked(false);
                            b.this.fjp.setCompoundDrawables(b.this.fjz, null, null, null);
                        } else if (compoundButton == b.this.fjp) {
                            b.this.fjk.clearCheck();
                            b.this.fjn.setChecked(false);
                            b.this.fjn.setCompoundDrawables(b.this.fjz, null, null, null);
                            b.this.fjo.setChecked(false);
                            b.this.fjo.setCompoundDrawables(b.this.fjz, null, null, null);
                            b.this.fjp.setChecked(true);
                            b.this.fjp.setCompoundDrawables(b.this.fjy, null, null, null);
                        }
                        b.this.fjj.setText(compoundButton.getText());
                    }
                }
            };
            this.fjn.setOnCheckedChangeListener(this.fjm);
            this.fjo.setOnCheckedChangeListener(this.fjm);
            this.fjp.setOnCheckedChangeListener(this.fjm);
            this.fju = (TextView) this.fjh.findViewById(R.id.phone_info);
            bxQ();
            this.fji = new Dialog(this.bNY, R.style.input_username_dialog);
            this.fji.setCanceledOnTouchOutside(false);
            this.fji.setCancelable(false);
            this.fji.setCanceledOnTouchOutside(false);
            bxE();
        }
        if (i == 1) {
            this.fju.setText(R.string.tip_init_user_name);
        } else {
            this.fju.setText(R.string.bar_friend);
        }
        if (!this.fji.isShowing()) {
            this.fjj.setText((CharSequence) null);
            bxQ();
            Dg(null);
            if (!this.bNY.isFinishing()) {
                this.fji.setContentView(this.fjh);
                g.showDialog(this.fji, this.bNY);
                if (this.bNY instanceof BaseActivity) {
                    ((BaseActivity) this.bNY).ShowSoftKeyPadDelay(this.fjj, 150);
                } else {
                    new Handler().postDelayed(new c(this.fjj), 150L);
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
            if (!b.this.bNY.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.bNY.getSystemService("input_method");
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

    public void bxO() {
        String obj = this.fjj.getText().toString();
        if (obj == null || obj.length() <= 0) {
            Dg(this.bNY.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            Dg(this.bNY.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.fjr != null) {
                this.fjr.cancel();
            }
            if (!this.fjE && this.fjv != null) {
                this.fjt.setVisibility(0);
                this.bPM.setEnabled(false);
                Dg(null);
                bxQ();
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
                        b.this.bxR();
                        l.showToast(b.this.bNY, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bjI().a(session.username, session.bduss, "", null, b.this.fjF);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.Dg(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.fjE = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.fjt.setVisibility(8);
                        b.this.bPM.setEnabled(true);
                        b.this.fjE = false;
                    }
                }, this.fjv.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxP() {
        if (this.fjx != null) {
            this.fjx.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            Dg(this.bNY.getString(R.string.suggest_no_name));
            return;
        }
        Dg(this.bNY.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.fjk.clearCheck();
        this.fjl.clearCheck();
        this.fjk.setVisibility(0);
        this.fjl.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.fjn.setText(arrayList.get(0));
            this.fjn.setChecked(false);
            this.fjn.setCompoundDrawables(this.fjz, null, null, null);
            this.fjn.setVisibility(0);
            this.fjk.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.fjo.setText(arrayList.get(1));
            this.fjo.setChecked(false);
            this.fjo.setCompoundDrawables(this.fjz, null, null, null);
            this.fjo.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.fjp.setText(arrayList.get(2));
            this.fjp.setChecked(false);
            this.fjp.setCompoundDrawables(this.fjz, null, null, null);
            this.fjp.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.fjr != null) {
            this.fjr.cancel();
            this.fjr = null;
        }
        bxR();
    }

    public void bxQ() {
        this.fjk.setVisibility(8);
        this.fjk.clearCheck();
        this.fjl.setVisibility(8);
        this.fjl.clearCheck();
        this.fjn.setVisibility(8);
        this.fjo.setVisibility(8);
        this.fjp.setVisibility(8);
        this.fjn.setChecked(false);
        this.fjo.setChecked(false);
        this.fjp.setChecked(false);
    }

    public void bxR() {
        if (this.fji != null && this.fji.isShowing()) {
            g.dismissDialog(this.fji, this.bNY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg(String str) {
        if (str == null) {
            this.fjs.setVisibility(4);
            this.fjs.setText((CharSequence) null);
            return;
        }
        this.fjs.setVisibility(0);
        this.fjs.setText(str);
    }

    private void bxE() {
        ap.setBackgroundResource(this.fjh, R.drawable.dialog_background);
        ap.setViewTextColor(this.fju, R.color.cp_cont_b);
        ap.setViewTextColor(this.fjA, R.color.cp_cont_f);
        ap.setViewTextColor(this.fjj, R.color.cp_cont_b);
        ap.setBackgroundResource(this.fjB, R.drawable.bg_search_input);
        ap.setViewTextColor(this.fjs, R.color.cp_cont_h);
        ap.setViewTextColor(this.fjn, R.color.cp_cont_b);
        ap.setViewTextColor(this.fjo, R.color.cp_cont_b);
        ap.setViewTextColor(this.fjp, R.color.cp_cont_b);
        ap.setBackgroundColor(this.fjC, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fjq, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.fjq, R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.fjD, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.bPM, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.bPM, R.color.cp_link_tip_a);
        this.fjj.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.fjn.setCompoundDrawables(this.fjz, null, null, null);
        this.fjo.setCompoundDrawables(this.fjz, null, null, null);
        this.fjp.setCompoundDrawables(this.fjz, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0588b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b fjG;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.fjG.fjr = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: F */
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
            this.fjG.fjr = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.fjG.Dg(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.fjG.Dg(this.fjG.bNY.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.fjG.Dg(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.fjG.K(oVar.buH());
                }
            } else {
                this.fjG.Dg(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fjG.Dg(null);
            this.fjG.bxQ();
            super.onPreExecute();
        }
    }
}
