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
    private Activity bIs;
    private Drawable fdF;
    private Drawable fdG;
    private TextView fdH;
    private View fdI;
    private View fdJ;
    private View fdK;
    private a.InterfaceC0562a fdM;
    private int size;
    private View fdo = null;
    private Dialog fdp = null;
    private EditText fdq = null;
    private RadioGroup fdr = null;
    private RadioGroup fds = null;
    private CompoundButton.OnCheckedChangeListener fdt = null;
    private RadioButton fdu = null;
    private RadioButton fdv = null;
    private RadioButton fdw = null;
    private TextView fdx = null;
    private C0576b fdy = null;
    private TextView fdz = null;
    private TextView bKg = null;
    private ProgressBar fdA = null;
    private TextView fdB = null;
    private AccountData fdC = null;
    private a fdD = null;
    private a fdE = null;
    private boolean fdL = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.bIs = null;
        this.fdF = null;
        this.fdG = null;
        this.size = 0;
        this.bIs = activity;
        this.fdF = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.fdG = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.bIs.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.fdF.setBounds(0, 0, this.size, this.size);
        this.fdG.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0562a interfaceC0562a) {
        this.fdM = interfaceC0562a;
    }

    public void setAccountData(AccountData accountData) {
        this.fdC = accountData;
    }

    public void a(a aVar) {
        this.fdD = aVar;
    }

    public void b(a aVar) {
        this.fdE = aVar;
    }

    public void bvo() {
        qJ(0);
    }

    public void qJ(int i) {
        if (this.fdp == null) {
            this.fdo = LayoutInflater.from(this.bIs).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.fdH = (TextView) this.fdo.findViewById(R.id.tip_info);
            this.fdI = this.fdo.findViewById(R.id.divider_under_account);
            this.fdJ = this.fdo.findViewById(R.id.divider_under_radiongroup);
            this.fdK = this.fdo.findViewById(R.id.divider_with_yes_no_button);
            this.fdq = (EditText) this.fdo.findViewById(R.id.account);
            this.fdq.setHint(this.bIs.getString(R.string.hint_tip_input_name));
            this.fdx = (TextView) this.fdo.findViewById(R.id.back);
            this.fdx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bvs();
                    b.this.bvq();
                }
            });
            this.bKg = (TextView) this.fdo.findViewById(R.id.confirm);
            this.bKg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bvp();
                }
            });
            this.fdA = (ProgressBar) this.fdo.findViewById(R.id.confirm_progress);
            this.fdz = (TextView) this.fdo.findViewById(R.id.error_info);
            this.fdr = (RadioGroup) this.fdo.findViewById(R.id.names_group1);
            this.fds = (RadioGroup) this.fdo.findViewById(R.id.names_group2);
            this.fdu = (RadioButton) this.fdo.findViewById(R.id.name1);
            this.fdv = (RadioButton) this.fdo.findViewById(R.id.name2);
            this.fdw = (RadioButton) this.fdo.findViewById(R.id.name3);
            this.fdt = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.fdu) {
                            b.this.fds.clearCheck();
                            b.this.fdu.setChecked(true);
                            b.this.fdu.setCompoundDrawables(b.this.fdF, null, null, null);
                            b.this.fdv.setChecked(false);
                            b.this.fdv.setCompoundDrawables(b.this.fdG, null, null, null);
                            b.this.fdw.setChecked(false);
                            b.this.fdw.setCompoundDrawables(b.this.fdG, null, null, null);
                        } else if (compoundButton == b.this.fdv) {
                            b.this.fds.clearCheck();
                            b.this.fdu.setChecked(false);
                            b.this.fdu.setCompoundDrawables(b.this.fdG, null, null, null);
                            b.this.fdv.setChecked(true);
                            b.this.fdv.setCompoundDrawables(b.this.fdF, null, null, null);
                            b.this.fdw.setChecked(false);
                            b.this.fdw.setCompoundDrawables(b.this.fdG, null, null, null);
                        } else if (compoundButton == b.this.fdw) {
                            b.this.fdr.clearCheck();
                            b.this.fdu.setChecked(false);
                            b.this.fdu.setCompoundDrawables(b.this.fdG, null, null, null);
                            b.this.fdv.setChecked(false);
                            b.this.fdv.setCompoundDrawables(b.this.fdG, null, null, null);
                            b.this.fdw.setChecked(true);
                            b.this.fdw.setCompoundDrawables(b.this.fdF, null, null, null);
                        }
                        b.this.fdq.setText(compoundButton.getText());
                    }
                }
            };
            this.fdu.setOnCheckedChangeListener(this.fdt);
            this.fdv.setOnCheckedChangeListener(this.fdt);
            this.fdw.setOnCheckedChangeListener(this.fdt);
            this.fdB = (TextView) this.fdo.findViewById(R.id.phone_info);
            bvr();
            this.fdp = new Dialog(this.bIs, R.style.input_username_dialog);
            this.fdp.setCanceledOnTouchOutside(false);
            this.fdp.setCancelable(false);
            this.fdp.setCanceledOnTouchOutside(false);
            bvf();
        }
        if (i == 1) {
            this.fdB.setText(R.string.tip_init_user_name);
        } else {
            this.fdB.setText(R.string.bar_friend);
        }
        if (!this.fdp.isShowing()) {
            this.fdq.setText((CharSequence) null);
            bvr();
            CS(null);
            if (!this.bIs.isFinishing()) {
                this.fdp.setContentView(this.fdo);
                g.showDialog(this.fdp, this.bIs);
                if (this.bIs instanceof BaseActivity) {
                    ((BaseActivity) this.bIs).ShowSoftKeyPadDelay(this.fdq, 150);
                } else {
                    new Handler().postDelayed(new c(this.fdq), 150L);
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
            if (!b.this.bIs.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.bIs.getSystemService("input_method");
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

    public void bvp() {
        String obj = this.fdq.getText().toString();
        if (obj == null || obj.length() <= 0) {
            CS(this.bIs.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            CS(this.bIs.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.fdy != null) {
                this.fdy.cancel();
            }
            if (!this.fdL && this.fdC != null) {
                this.fdA.setVisibility(0);
                this.bKg.setEnabled(false);
                CS(null);
                bvr();
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
                        b.this.bvs();
                        l.showToast(b.this.bIs, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bhi().a(session.username, session.bduss, "", null, b.this.fdM);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.CS(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.fdL = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.fdA.setVisibility(8);
                        b.this.bKg.setEnabled(true);
                        b.this.fdL = false;
                    }
                }, this.fdC.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvq() {
        if (this.fdE != null) {
            this.fdE.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            CS(this.bIs.getString(R.string.suggest_no_name));
            return;
        }
        CS(this.bIs.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.fdr.clearCheck();
        this.fds.clearCheck();
        this.fdr.setVisibility(0);
        this.fds.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.fdu.setText(arrayList.get(0));
            this.fdu.setChecked(false);
            this.fdu.setCompoundDrawables(this.fdG, null, null, null);
            this.fdu.setVisibility(0);
            this.fdr.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.fdv.setText(arrayList.get(1));
            this.fdv.setChecked(false);
            this.fdv.setCompoundDrawables(this.fdG, null, null, null);
            this.fdv.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.fdw.setText(arrayList.get(2));
            this.fdw.setChecked(false);
            this.fdw.setCompoundDrawables(this.fdG, null, null, null);
            this.fdw.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.fdy != null) {
            this.fdy.cancel();
            this.fdy = null;
        }
        bvs();
    }

    public void bvr() {
        this.fdr.setVisibility(8);
        this.fdr.clearCheck();
        this.fds.setVisibility(8);
        this.fds.clearCheck();
        this.fdu.setVisibility(8);
        this.fdv.setVisibility(8);
        this.fdw.setVisibility(8);
        this.fdu.setChecked(false);
        this.fdv.setChecked(false);
        this.fdw.setChecked(false);
    }

    public void bvs() {
        if (this.fdp != null && this.fdp.isShowing()) {
            g.dismissDialog(this.fdp, this.bIs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CS(String str) {
        if (str == null) {
            this.fdz.setVisibility(4);
            this.fdz.setText((CharSequence) null);
            return;
        }
        this.fdz.setVisibility(0);
        this.fdz.setText(str);
    }

    private void bvf() {
        ap.setBackgroundResource(this.fdo, R.drawable.dialog_background);
        ap.setViewTextColor(this.fdB, R.color.cp_cont_b);
        ap.setViewTextColor(this.fdH, R.color.cp_cont_f);
        ap.setViewTextColor(this.fdq, R.color.cp_cont_b);
        ap.setBackgroundResource(this.fdI, R.drawable.bg_search_input);
        ap.setViewTextColor(this.fdz, R.color.cp_cont_h);
        ap.setViewTextColor(this.fdu, R.color.cp_cont_b);
        ap.setViewTextColor(this.fdv, R.color.cp_cont_b);
        ap.setViewTextColor(this.fdw, R.color.cp_cont_b);
        ap.setBackgroundColor(this.fdJ, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.fdx, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.fdx, R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.fdK, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.bKg, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.bKg, R.color.cp_link_tip_a);
        this.fdq.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.fdu.setCompoundDrawables(this.fdG, null, null, null);
        this.fdv.setCompoundDrawables(this.fdG, null, null, null);
        this.fdw.setCompoundDrawables(this.fdG, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0576b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b fdN;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.fdN.fdy = null;
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
            this.fdN.fdy = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.fdN.CS(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.fdN.CS(this.fdN.bIs.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.fdN.CS(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.fdN.K(oVar.bsh());
                }
            } else {
                this.fdN.CS(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fdN.CS(null);
            this.fdN.bvr();
            super.onPreExecute();
        }
    }
}
