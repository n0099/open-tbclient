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
    private Drawable dsS;
    private Drawable dsT;
    private TextView dsU;
    private View dsV;
    private View dsW;
    private View dsX;
    private a.InterfaceC0375a dsZ;
    private Activity mContext;
    private int size;
    private View dsA = null;
    private Dialog dsB = null;
    private EditText dsC = null;
    private RadioGroup dsD = null;
    private RadioGroup dsE = null;
    private CompoundButton.OnCheckedChangeListener dsF = null;
    private RadioButton dsG = null;
    private RadioButton dsH = null;
    private RadioButton dsI = null;
    private TextView dsJ = null;
    private b dsK = null;
    private TextView dsL = null;
    private TextView dsM = null;
    private ProgressBar dsN = null;
    private TextView dsO = null;
    private AccountData dsP = null;
    private a dsQ = null;
    private a dsR = null;
    private boolean dsY = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.dsS = null;
        this.dsT = null;
        this.size = 0;
        this.mContext = activity;
        this.dsS = am.getDrawable(R.drawable.icon_tips_names_s);
        this.dsT = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.dsS.setBounds(0, 0, this.size, this.size);
        this.dsT.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0375a interfaceC0375a) {
        this.dsZ = interfaceC0375a;
    }

    public void setAccountData(AccountData accountData) {
        this.dsP = accountData;
    }

    public void a(a aVar) {
        this.dsQ = aVar;
    }

    public void b(a aVar) {
        this.dsR = aVar;
    }

    public void aMK() {
        lY(0);
    }

    public void lY(int i) {
        if (this.dsB == null) {
            this.dsA = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.dsU = (TextView) this.dsA.findViewById(R.id.tip_info);
            this.dsV = this.dsA.findViewById(R.id.divider_under_account);
            this.dsW = this.dsA.findViewById(R.id.divider_under_radiongroup);
            this.dsX = this.dsA.findViewById(R.id.divider_with_yes_no_button);
            this.dsC = (EditText) this.dsA.findViewById(R.id.account);
            this.dsC.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.dsJ = (TextView) this.dsA.findViewById(R.id.back);
            this.dsJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aMO();
                    c.this.aMM();
                }
            });
            this.dsM = (TextView) this.dsA.findViewById(R.id.confirm);
            this.dsM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aML();
                }
            });
            this.dsN = (ProgressBar) this.dsA.findViewById(R.id.confirm_progress);
            this.dsL = (TextView) this.dsA.findViewById(R.id.error_info);
            this.dsD = (RadioGroup) this.dsA.findViewById(R.id.names_group1);
            this.dsE = (RadioGroup) this.dsA.findViewById(R.id.names_group2);
            this.dsG = (RadioButton) this.dsA.findViewById(R.id.name1);
            this.dsH = (RadioButton) this.dsA.findViewById(R.id.name2);
            this.dsI = (RadioButton) this.dsA.findViewById(R.id.name3);
            this.dsF = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.dsG) {
                            c.this.dsE.clearCheck();
                            c.this.dsG.setChecked(true);
                            c.this.dsG.setCompoundDrawables(c.this.dsS, null, null, null);
                            c.this.dsH.setChecked(false);
                            c.this.dsH.setCompoundDrawables(c.this.dsT, null, null, null);
                            c.this.dsI.setChecked(false);
                            c.this.dsI.setCompoundDrawables(c.this.dsT, null, null, null);
                        } else if (compoundButton == c.this.dsH) {
                            c.this.dsE.clearCheck();
                            c.this.dsG.setChecked(false);
                            c.this.dsG.setCompoundDrawables(c.this.dsT, null, null, null);
                            c.this.dsH.setChecked(true);
                            c.this.dsH.setCompoundDrawables(c.this.dsS, null, null, null);
                            c.this.dsI.setChecked(false);
                            c.this.dsI.setCompoundDrawables(c.this.dsT, null, null, null);
                        } else if (compoundButton == c.this.dsI) {
                            c.this.dsD.clearCheck();
                            c.this.dsG.setChecked(false);
                            c.this.dsG.setCompoundDrawables(c.this.dsT, null, null, null);
                            c.this.dsH.setChecked(false);
                            c.this.dsH.setCompoundDrawables(c.this.dsT, null, null, null);
                            c.this.dsI.setChecked(true);
                            c.this.dsI.setCompoundDrawables(c.this.dsS, null, null, null);
                        }
                        c.this.dsC.setText(compoundButton.getText());
                    }
                }
            };
            this.dsG.setOnCheckedChangeListener(this.dsF);
            this.dsH.setOnCheckedChangeListener(this.dsF);
            this.dsI.setOnCheckedChangeListener(this.dsF);
            this.dsO = (TextView) this.dsA.findViewById(R.id.phone_info);
            aMN();
            this.dsB = new Dialog(this.mContext, R.style.input_username_dialog);
            this.dsB.setCanceledOnTouchOutside(false);
            this.dsB.setCancelable(false);
            this.dsB.setCanceledOnTouchOutside(false);
            aMC();
        }
        if (i == 1) {
            this.dsO.setText(R.string.tip_init_user_name);
        } else {
            this.dsO.setText(R.string.bar_friend);
        }
        if (!this.dsB.isShowing()) {
            this.dsC.setText((CharSequence) null);
            aMN();
            uE(null);
            if (!this.mContext.isFinishing()) {
                this.dsB.setContentView(this.dsA);
                g.showDialog(this.dsB, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.dsC, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0387c(this.dsC), 150L);
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

    public void aML() {
        String obj = this.dsC.getText().toString();
        if (obj == null || obj.length() <= 0) {
            uE(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            uE(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.dsK != null) {
                this.dsK.cancel();
            }
            if (!this.dsY && this.dsP != null) {
                this.dsN.setVisibility(0);
                this.dsM.setEnabled(false);
                uE(null);
                aMN();
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
                        c.this.aMO();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.azP().a(session.username, session.bduss, "", null, c.this.dsZ);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.uE(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.dsY = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.dsN.setVisibility(8);
                        c.this.dsM.setEnabled(true);
                        c.this.dsY = false;
                    }
                }, this.dsP.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMM() {
        if (this.dsR != null) {
            this.dsR.g(null);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            uE(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        uE(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.dsD.clearCheck();
        this.dsE.clearCheck();
        this.dsD.setVisibility(0);
        this.dsE.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.dsG.setText(arrayList.get(0));
            this.dsG.setChecked(false);
            this.dsG.setCompoundDrawables(this.dsT, null, null, null);
            this.dsG.setVisibility(0);
            this.dsD.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.dsH.setText(arrayList.get(1));
            this.dsH.setChecked(false);
            this.dsH.setCompoundDrawables(this.dsT, null, null, null);
            this.dsH.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.dsI.setText(arrayList.get(2));
            this.dsI.setChecked(false);
            this.dsI.setCompoundDrawables(this.dsT, null, null, null);
            this.dsI.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.dsK != null) {
            this.dsK.cancel();
            this.dsK = null;
        }
        aMO();
    }

    public void aMN() {
        this.dsD.setVisibility(8);
        this.dsD.clearCheck();
        this.dsE.setVisibility(8);
        this.dsE.clearCheck();
        this.dsG.setVisibility(8);
        this.dsH.setVisibility(8);
        this.dsI.setVisibility(8);
        this.dsG.setChecked(false);
        this.dsH.setChecked(false);
        this.dsI.setChecked(false);
    }

    public void aMO() {
        if (this.dsB != null && this.dsB.isShowing()) {
            g.dismissDialog(this.dsB, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(String str) {
        if (str == null) {
            this.dsL.setVisibility(4);
            this.dsL.setText((CharSequence) null);
            return;
        }
        this.dsL.setVisibility(0);
        this.dsL.setText(str);
    }

    private void aMC() {
        am.setBackgroundResource(this.dsA, R.drawable.dialog_background);
        am.setViewTextColor(this.dsO, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsU, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dsC, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.dsV, R.drawable.bg_search_input);
        am.setViewTextColor(this.dsL, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.dsG, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsH, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsI, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.dsW, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dsJ, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.dsJ, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.dsX, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dsM, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.dsM, (int) R.color.cp_link_tip_a);
        this.dsC.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.dsG.setCompoundDrawables(this.dsT, null, null, null);
        this.dsH.setCompoundDrawables(this.dsT, null, null, null);
        this.dsI.setCompoundDrawables(this.dsT, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ c dta;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.dta.dsK = null;
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
            this.dta.dsK = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.dta.uE(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.dta.uE(this.dta.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.dta.uE(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.dta.D(kVar.aJs());
                }
            } else {
                this.dta.uE(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dta.uE(null);
            this.dta.aMN();
            super.onPreExecute();
        }
    }
}
