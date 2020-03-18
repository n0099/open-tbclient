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
    private Drawable dtf;
    private Drawable dtg;
    private TextView dth;
    private View dti;
    private View dtj;
    private View dtk;
    private a.InterfaceC0375a dtm;
    private Activity mContext;
    private int size;
    private View dsN = null;
    private Dialog dsO = null;
    private EditText dsP = null;
    private RadioGroup dsQ = null;
    private RadioGroup dsR = null;
    private CompoundButton.OnCheckedChangeListener dsS = null;
    private RadioButton dsT = null;
    private RadioButton dsU = null;
    private RadioButton dsV = null;
    private TextView dsW = null;
    private b dsX = null;
    private TextView dsY = null;
    private TextView dsZ = null;
    private ProgressBar dta = null;
    private TextView dtb = null;
    private AccountData dtc = null;
    private a dtd = null;
    private a dte = null;
    private boolean dtl = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.dtf = null;
        this.dtg = null;
        this.size = 0;
        this.mContext = activity;
        this.dtf = am.getDrawable(R.drawable.icon_tips_names_s);
        this.dtg = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.dtf.setBounds(0, 0, this.size, this.size);
        this.dtg.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0375a interfaceC0375a) {
        this.dtm = interfaceC0375a;
    }

    public void setAccountData(AccountData accountData) {
        this.dtc = accountData;
    }

    public void a(a aVar) {
        this.dtd = aVar;
    }

    public void b(a aVar) {
        this.dte = aVar;
    }

    public void aMO() {
        ma(0);
    }

    public void ma(int i) {
        if (this.dsO == null) {
            this.dsN = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.dth = (TextView) this.dsN.findViewById(R.id.tip_info);
            this.dti = this.dsN.findViewById(R.id.divider_under_account);
            this.dtj = this.dsN.findViewById(R.id.divider_under_radiongroup);
            this.dtk = this.dsN.findViewById(R.id.divider_with_yes_no_button);
            this.dsP = (EditText) this.dsN.findViewById(R.id.account);
            this.dsP.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.dsW = (TextView) this.dsN.findViewById(R.id.back);
            this.dsW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aMS();
                    c.this.aMQ();
                }
            });
            this.dsZ = (TextView) this.dsN.findViewById(R.id.confirm);
            this.dsZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aMP();
                }
            });
            this.dta = (ProgressBar) this.dsN.findViewById(R.id.confirm_progress);
            this.dsY = (TextView) this.dsN.findViewById(R.id.error_info);
            this.dsQ = (RadioGroup) this.dsN.findViewById(R.id.names_group1);
            this.dsR = (RadioGroup) this.dsN.findViewById(R.id.names_group2);
            this.dsT = (RadioButton) this.dsN.findViewById(R.id.name1);
            this.dsU = (RadioButton) this.dsN.findViewById(R.id.name2);
            this.dsV = (RadioButton) this.dsN.findViewById(R.id.name3);
            this.dsS = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.dsT) {
                            c.this.dsR.clearCheck();
                            c.this.dsT.setChecked(true);
                            c.this.dsT.setCompoundDrawables(c.this.dtf, null, null, null);
                            c.this.dsU.setChecked(false);
                            c.this.dsU.setCompoundDrawables(c.this.dtg, null, null, null);
                            c.this.dsV.setChecked(false);
                            c.this.dsV.setCompoundDrawables(c.this.dtg, null, null, null);
                        } else if (compoundButton == c.this.dsU) {
                            c.this.dsR.clearCheck();
                            c.this.dsT.setChecked(false);
                            c.this.dsT.setCompoundDrawables(c.this.dtg, null, null, null);
                            c.this.dsU.setChecked(true);
                            c.this.dsU.setCompoundDrawables(c.this.dtf, null, null, null);
                            c.this.dsV.setChecked(false);
                            c.this.dsV.setCompoundDrawables(c.this.dtg, null, null, null);
                        } else if (compoundButton == c.this.dsV) {
                            c.this.dsQ.clearCheck();
                            c.this.dsT.setChecked(false);
                            c.this.dsT.setCompoundDrawables(c.this.dtg, null, null, null);
                            c.this.dsU.setChecked(false);
                            c.this.dsU.setCompoundDrawables(c.this.dtg, null, null, null);
                            c.this.dsV.setChecked(true);
                            c.this.dsV.setCompoundDrawables(c.this.dtf, null, null, null);
                        }
                        c.this.dsP.setText(compoundButton.getText());
                    }
                }
            };
            this.dsT.setOnCheckedChangeListener(this.dsS);
            this.dsU.setOnCheckedChangeListener(this.dsS);
            this.dsV.setOnCheckedChangeListener(this.dsS);
            this.dtb = (TextView) this.dsN.findViewById(R.id.phone_info);
            aMR();
            this.dsO = new Dialog(this.mContext, R.style.input_username_dialog);
            this.dsO.setCanceledOnTouchOutside(false);
            this.dsO.setCancelable(false);
            this.dsO.setCanceledOnTouchOutside(false);
            aMG();
        }
        if (i == 1) {
            this.dtb.setText(R.string.tip_init_user_name);
        } else {
            this.dtb.setText(R.string.bar_friend);
        }
        if (!this.dsO.isShowing()) {
            this.dsP.setText((CharSequence) null);
            aMR();
            uD(null);
            if (!this.mContext.isFinishing()) {
                this.dsO.setContentView(this.dsN);
                g.showDialog(this.dsO, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.dsP, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0387c(this.dsP), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0387c implements Runnable {
        private View mView;

        public RunnableC0387c(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.mContext.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) c.this.mContext.getSystemService("input_method");
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

    public void aMP() {
        String obj = this.dsP.getText().toString();
        if (obj == null || obj.length() <= 0) {
            uD(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            uD(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.dsX != null) {
                this.dsX.cancel();
            }
            if (!this.dtl && this.dtc != null) {
                this.dta.setVisibility(0);
                this.dsZ.setEnabled(false);
                uD(null);
                aMR();
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
                        c.this.aMS();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.azS().a(session.username, session.bduss, "", null, c.this.dtm);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.uD(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.dtl = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.dta.setVisibility(8);
                        c.this.dsZ.setEnabled(true);
                        c.this.dtl = false;
                    }
                }, this.dtc.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMQ() {
        if (this.dte != null) {
            this.dte.g(null);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            uD(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        uD(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.dsQ.clearCheck();
        this.dsR.clearCheck();
        this.dsQ.setVisibility(0);
        this.dsR.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.dsT.setText(arrayList.get(0));
            this.dsT.setChecked(false);
            this.dsT.setCompoundDrawables(this.dtg, null, null, null);
            this.dsT.setVisibility(0);
            this.dsQ.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.dsU.setText(arrayList.get(1));
            this.dsU.setChecked(false);
            this.dsU.setCompoundDrawables(this.dtg, null, null, null);
            this.dsU.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.dsV.setText(arrayList.get(2));
            this.dsV.setChecked(false);
            this.dsV.setCompoundDrawables(this.dtg, null, null, null);
            this.dsV.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.dsX != null) {
            this.dsX.cancel();
            this.dsX = null;
        }
        aMS();
    }

    public void aMR() {
        this.dsQ.setVisibility(8);
        this.dsQ.clearCheck();
        this.dsR.setVisibility(8);
        this.dsR.clearCheck();
        this.dsT.setVisibility(8);
        this.dsU.setVisibility(8);
        this.dsV.setVisibility(8);
        this.dsT.setChecked(false);
        this.dsU.setChecked(false);
        this.dsV.setChecked(false);
    }

    public void aMS() {
        if (this.dsO != null && this.dsO.isShowing()) {
            g.dismissDialog(this.dsO, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(String str) {
        if (str == null) {
            this.dsY.setVisibility(4);
            this.dsY.setText((CharSequence) null);
            return;
        }
        this.dsY.setVisibility(0);
        this.dsY.setText(str);
    }

    private void aMG() {
        am.setBackgroundResource(this.dsN, R.drawable.dialog_background);
        am.setViewTextColor(this.dtb, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dth, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dsP, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.dti, R.drawable.bg_search_input);
        am.setViewTextColor(this.dsY, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.dsT, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsU, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsV, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.dtj, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dsW, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.dsW, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.dtk, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dsZ, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.dsZ, (int) R.color.cp_link_tip_a);
        this.dsP.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.dsT.setCompoundDrawables(this.dtg, null, null, null);
        this.dsU.setCompoundDrawables(this.dtg, null, null, null);
        this.dsV.setCompoundDrawables(this.dtg, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ c dtn;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.dtn.dsX = null;
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
            this.dtn.dsX = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.dtn.uD(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.dtn.uD(this.dtn.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.dtn.uD(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.dtn.D(kVar.aJw());
                }
            } else {
                this.dtn.uD(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dtn.uD(null);
            this.dtn.aMR();
            super.onPreExecute();
        }
    }
}
