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
    private Drawable dsE;
    private Drawable dsF;
    private TextView dsG;
    private View dsH;
    private View dsI;
    private View dsJ;
    private a.InterfaceC0375a dsL;
    private Activity mContext;
    private int size;
    private View dsl = null;
    private Dialog dsm = null;
    private EditText dsn = null;
    private RadioGroup dso = null;
    private RadioGroup dsp = null;
    private CompoundButton.OnCheckedChangeListener dsq = null;
    private RadioButton dsr = null;
    private RadioButton dss = null;
    private RadioButton dsu = null;
    private TextView dsv = null;
    private b dsw = null;
    private TextView dsx = null;
    private TextView dsy = null;
    private ProgressBar dsz = null;
    private TextView dsA = null;
    private AccountData dsB = null;
    private a dsC = null;
    private a dsD = null;
    private boolean dsK = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.dsE = null;
        this.dsF = null;
        this.size = 0;
        this.mContext = activity;
        this.dsE = am.getDrawable(R.drawable.icon_tips_names_s);
        this.dsF = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.dsE.setBounds(0, 0, this.size, this.size);
        this.dsF.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0375a interfaceC0375a) {
        this.dsL = interfaceC0375a;
    }

    public void setAccountData(AccountData accountData) {
        this.dsB = accountData;
    }

    public void a(a aVar) {
        this.dsC = aVar;
    }

    public void b(a aVar) {
        this.dsD = aVar;
    }

    public void aMH() {
        lY(0);
    }

    public void lY(int i) {
        if (this.dsm == null) {
            this.dsl = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.dsG = (TextView) this.dsl.findViewById(R.id.tip_info);
            this.dsH = this.dsl.findViewById(R.id.divider_under_account);
            this.dsI = this.dsl.findViewById(R.id.divider_under_radiongroup);
            this.dsJ = this.dsl.findViewById(R.id.divider_with_yes_no_button);
            this.dsn = (EditText) this.dsl.findViewById(R.id.account);
            this.dsn.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.dsv = (TextView) this.dsl.findViewById(R.id.back);
            this.dsv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aML();
                    c.this.aMJ();
                }
            });
            this.dsy = (TextView) this.dsl.findViewById(R.id.confirm);
            this.dsy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aMI();
                }
            });
            this.dsz = (ProgressBar) this.dsl.findViewById(R.id.confirm_progress);
            this.dsx = (TextView) this.dsl.findViewById(R.id.error_info);
            this.dso = (RadioGroup) this.dsl.findViewById(R.id.names_group1);
            this.dsp = (RadioGroup) this.dsl.findViewById(R.id.names_group2);
            this.dsr = (RadioButton) this.dsl.findViewById(R.id.name1);
            this.dss = (RadioButton) this.dsl.findViewById(R.id.name2);
            this.dsu = (RadioButton) this.dsl.findViewById(R.id.name3);
            this.dsq = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.dsr) {
                            c.this.dsp.clearCheck();
                            c.this.dsr.setChecked(true);
                            c.this.dsr.setCompoundDrawables(c.this.dsE, null, null, null);
                            c.this.dss.setChecked(false);
                            c.this.dss.setCompoundDrawables(c.this.dsF, null, null, null);
                            c.this.dsu.setChecked(false);
                            c.this.dsu.setCompoundDrawables(c.this.dsF, null, null, null);
                        } else if (compoundButton == c.this.dss) {
                            c.this.dsp.clearCheck();
                            c.this.dsr.setChecked(false);
                            c.this.dsr.setCompoundDrawables(c.this.dsF, null, null, null);
                            c.this.dss.setChecked(true);
                            c.this.dss.setCompoundDrawables(c.this.dsE, null, null, null);
                            c.this.dsu.setChecked(false);
                            c.this.dsu.setCompoundDrawables(c.this.dsF, null, null, null);
                        } else if (compoundButton == c.this.dsu) {
                            c.this.dso.clearCheck();
                            c.this.dsr.setChecked(false);
                            c.this.dsr.setCompoundDrawables(c.this.dsF, null, null, null);
                            c.this.dss.setChecked(false);
                            c.this.dss.setCompoundDrawables(c.this.dsF, null, null, null);
                            c.this.dsu.setChecked(true);
                            c.this.dsu.setCompoundDrawables(c.this.dsE, null, null, null);
                        }
                        c.this.dsn.setText(compoundButton.getText());
                    }
                }
            };
            this.dsr.setOnCheckedChangeListener(this.dsq);
            this.dss.setOnCheckedChangeListener(this.dsq);
            this.dsu.setOnCheckedChangeListener(this.dsq);
            this.dsA = (TextView) this.dsl.findViewById(R.id.phone_info);
            aMK();
            this.dsm = new Dialog(this.mContext, R.style.input_username_dialog);
            this.dsm.setCanceledOnTouchOutside(false);
            this.dsm.setCancelable(false);
            this.dsm.setCanceledOnTouchOutside(false);
            aMz();
        }
        if (i == 1) {
            this.dsA.setText(R.string.tip_init_user_name);
        } else {
            this.dsA.setText(R.string.bar_friend);
        }
        if (!this.dsm.isShowing()) {
            this.dsn.setText((CharSequence) null);
            aMK();
            uD(null);
            if (!this.mContext.isFinishing()) {
                this.dsm.setContentView(this.dsl);
                g.showDialog(this.dsm, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.dsn, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0387c(this.dsn), 150L);
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

    public void aMI() {
        String obj = this.dsn.getText().toString();
        if (obj == null || obj.length() <= 0) {
            uD(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            uD(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.dsw != null) {
                this.dsw.cancel();
            }
            if (!this.dsK && this.dsB != null) {
                this.dsz.setVisibility(0);
                this.dsy.setEnabled(false);
                uD(null);
                aMK();
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
                        c.this.aML();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.azN().a(session.username, session.bduss, "", null, c.this.dsL);
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
                        c.this.dsK = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.dsz.setVisibility(8);
                        c.this.dsy.setEnabled(true);
                        c.this.dsK = false;
                    }
                }, this.dsB.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMJ() {
        if (this.dsD != null) {
            this.dsD.g(null);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            uD(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        uD(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.dso.clearCheck();
        this.dsp.clearCheck();
        this.dso.setVisibility(0);
        this.dsp.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.dsr.setText(arrayList.get(0));
            this.dsr.setChecked(false);
            this.dsr.setCompoundDrawables(this.dsF, null, null, null);
            this.dsr.setVisibility(0);
            this.dso.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.dss.setText(arrayList.get(1));
            this.dss.setChecked(false);
            this.dss.setCompoundDrawables(this.dsF, null, null, null);
            this.dss.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.dsu.setText(arrayList.get(2));
            this.dsu.setChecked(false);
            this.dsu.setCompoundDrawables(this.dsF, null, null, null);
            this.dsu.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.dsw != null) {
            this.dsw.cancel();
            this.dsw = null;
        }
        aML();
    }

    public void aMK() {
        this.dso.setVisibility(8);
        this.dso.clearCheck();
        this.dsp.setVisibility(8);
        this.dsp.clearCheck();
        this.dsr.setVisibility(8);
        this.dss.setVisibility(8);
        this.dsu.setVisibility(8);
        this.dsr.setChecked(false);
        this.dss.setChecked(false);
        this.dsu.setChecked(false);
    }

    public void aML() {
        if (this.dsm != null && this.dsm.isShowing()) {
            g.dismissDialog(this.dsm, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(String str) {
        if (str == null) {
            this.dsx.setVisibility(4);
            this.dsx.setText((CharSequence) null);
            return;
        }
        this.dsx.setVisibility(0);
        this.dsx.setText(str);
    }

    private void aMz() {
        am.setBackgroundResource(this.dsl, R.drawable.dialog_background);
        am.setViewTextColor(this.dsA, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsG, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dsn, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.dsH, R.drawable.bg_search_input);
        am.setViewTextColor(this.dsx, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.dsr, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dss, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsu, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.dsI, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dsv, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.dsv, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.dsJ, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dsy, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.dsy, (int) R.color.cp_link_tip_a);
        this.dsn.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.dsr.setCompoundDrawables(this.dsF, null, null, null);
        this.dss.setCompoundDrawables(this.dsF, null, null, null);
        this.dsu.setCompoundDrawables(this.dsF, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ c dsM;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.dsM.dsw = null;
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
            this.dsM.dsw = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.dsM.uD(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.dsM.uD(this.dsM.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.dsM.uD(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.dsM.D(kVar.aJp());
                }
            } else {
                this.dsM.uD(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dsM.uD(null);
            this.dsM.aMK();
            super.onPreExecute();
        }
    }
}
