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
    private Drawable dsF;
    private Drawable dsG;
    private TextView dsH;
    private View dsI;
    private View dsJ;
    private View dsK;
    private a.InterfaceC0375a dsM;
    private Activity mContext;
    private int size;
    private View dsm = null;
    private Dialog dsn = null;
    private EditText dso = null;
    private RadioGroup dsp = null;
    private RadioGroup dsq = null;
    private CompoundButton.OnCheckedChangeListener dsr = null;
    private RadioButton dss = null;
    private RadioButton dsu = null;
    private RadioButton dsv = null;
    private TextView dsw = null;
    private b dsx = null;
    private TextView dsy = null;
    private TextView dsz = null;
    private ProgressBar dsA = null;
    private TextView dsB = null;
    private AccountData dsC = null;
    private a dsD = null;
    private a dsE = null;
    private boolean dsL = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.dsF = null;
        this.dsG = null;
        this.size = 0;
        this.mContext = activity;
        this.dsF = am.getDrawable(R.drawable.icon_tips_names_s);
        this.dsG = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.dsF.setBounds(0, 0, this.size, this.size);
        this.dsG.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0375a interfaceC0375a) {
        this.dsM = interfaceC0375a;
    }

    public void setAccountData(AccountData accountData) {
        this.dsC = accountData;
    }

    public void a(a aVar) {
        this.dsD = aVar;
    }

    public void b(a aVar) {
        this.dsE = aVar;
    }

    public void aMJ() {
        lY(0);
    }

    public void lY(int i) {
        if (this.dsn == null) {
            this.dsm = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.dsH = (TextView) this.dsm.findViewById(R.id.tip_info);
            this.dsI = this.dsm.findViewById(R.id.divider_under_account);
            this.dsJ = this.dsm.findViewById(R.id.divider_under_radiongroup);
            this.dsK = this.dsm.findViewById(R.id.divider_with_yes_no_button);
            this.dso = (EditText) this.dsm.findViewById(R.id.account);
            this.dso.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.dsw = (TextView) this.dsm.findViewById(R.id.back);
            this.dsw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aMN();
                    c.this.aML();
                }
            });
            this.dsz = (TextView) this.dsm.findViewById(R.id.confirm);
            this.dsz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aMK();
                }
            });
            this.dsA = (ProgressBar) this.dsm.findViewById(R.id.confirm_progress);
            this.dsy = (TextView) this.dsm.findViewById(R.id.error_info);
            this.dsp = (RadioGroup) this.dsm.findViewById(R.id.names_group1);
            this.dsq = (RadioGroup) this.dsm.findViewById(R.id.names_group2);
            this.dss = (RadioButton) this.dsm.findViewById(R.id.name1);
            this.dsu = (RadioButton) this.dsm.findViewById(R.id.name2);
            this.dsv = (RadioButton) this.dsm.findViewById(R.id.name3);
            this.dsr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.dss) {
                            c.this.dsq.clearCheck();
                            c.this.dss.setChecked(true);
                            c.this.dss.setCompoundDrawables(c.this.dsF, null, null, null);
                            c.this.dsu.setChecked(false);
                            c.this.dsu.setCompoundDrawables(c.this.dsG, null, null, null);
                            c.this.dsv.setChecked(false);
                            c.this.dsv.setCompoundDrawables(c.this.dsG, null, null, null);
                        } else if (compoundButton == c.this.dsu) {
                            c.this.dsq.clearCheck();
                            c.this.dss.setChecked(false);
                            c.this.dss.setCompoundDrawables(c.this.dsG, null, null, null);
                            c.this.dsu.setChecked(true);
                            c.this.dsu.setCompoundDrawables(c.this.dsF, null, null, null);
                            c.this.dsv.setChecked(false);
                            c.this.dsv.setCompoundDrawables(c.this.dsG, null, null, null);
                        } else if (compoundButton == c.this.dsv) {
                            c.this.dsp.clearCheck();
                            c.this.dss.setChecked(false);
                            c.this.dss.setCompoundDrawables(c.this.dsG, null, null, null);
                            c.this.dsu.setChecked(false);
                            c.this.dsu.setCompoundDrawables(c.this.dsG, null, null, null);
                            c.this.dsv.setChecked(true);
                            c.this.dsv.setCompoundDrawables(c.this.dsF, null, null, null);
                        }
                        c.this.dso.setText(compoundButton.getText());
                    }
                }
            };
            this.dss.setOnCheckedChangeListener(this.dsr);
            this.dsu.setOnCheckedChangeListener(this.dsr);
            this.dsv.setOnCheckedChangeListener(this.dsr);
            this.dsB = (TextView) this.dsm.findViewById(R.id.phone_info);
            aMM();
            this.dsn = new Dialog(this.mContext, R.style.input_username_dialog);
            this.dsn.setCanceledOnTouchOutside(false);
            this.dsn.setCancelable(false);
            this.dsn.setCanceledOnTouchOutside(false);
            aMB();
        }
        if (i == 1) {
            this.dsB.setText(R.string.tip_init_user_name);
        } else {
            this.dsB.setText(R.string.bar_friend);
        }
        if (!this.dsn.isShowing()) {
            this.dso.setText((CharSequence) null);
            aMM();
            uD(null);
            if (!this.mContext.isFinishing()) {
                this.dsn.setContentView(this.dsm);
                g.showDialog(this.dsn, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.dso, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0387c(this.dso), 150L);
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

    public void aMK() {
        String obj = this.dso.getText().toString();
        if (obj == null || obj.length() <= 0) {
            uD(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            uD(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.dsx != null) {
                this.dsx.cancel();
            }
            if (!this.dsL && this.dsC != null) {
                this.dsA.setVisibility(0);
                this.dsz.setEnabled(false);
                uD(null);
                aMM();
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
                        c.this.aMN();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.azP().a(session.username, session.bduss, "", null, c.this.dsM);
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
                        c.this.dsL = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.dsA.setVisibility(8);
                        c.this.dsz.setEnabled(true);
                        c.this.dsL = false;
                    }
                }, this.dsC.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aML() {
        if (this.dsE != null) {
            this.dsE.g(null);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            uD(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        uD(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.dsp.clearCheck();
        this.dsq.clearCheck();
        this.dsp.setVisibility(0);
        this.dsq.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.dss.setText(arrayList.get(0));
            this.dss.setChecked(false);
            this.dss.setCompoundDrawables(this.dsG, null, null, null);
            this.dss.setVisibility(0);
            this.dsp.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.dsu.setText(arrayList.get(1));
            this.dsu.setChecked(false);
            this.dsu.setCompoundDrawables(this.dsG, null, null, null);
            this.dsu.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.dsv.setText(arrayList.get(2));
            this.dsv.setChecked(false);
            this.dsv.setCompoundDrawables(this.dsG, null, null, null);
            this.dsv.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.dsx != null) {
            this.dsx.cancel();
            this.dsx = null;
        }
        aMN();
    }

    public void aMM() {
        this.dsp.setVisibility(8);
        this.dsp.clearCheck();
        this.dsq.setVisibility(8);
        this.dsq.clearCheck();
        this.dss.setVisibility(8);
        this.dsu.setVisibility(8);
        this.dsv.setVisibility(8);
        this.dss.setChecked(false);
        this.dsu.setChecked(false);
        this.dsv.setChecked(false);
    }

    public void aMN() {
        if (this.dsn != null && this.dsn.isShowing()) {
            g.dismissDialog(this.dsn, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(String str) {
        if (str == null) {
            this.dsy.setVisibility(4);
            this.dsy.setText((CharSequence) null);
            return;
        }
        this.dsy.setVisibility(0);
        this.dsy.setText(str);
    }

    private void aMB() {
        am.setBackgroundResource(this.dsm, R.drawable.dialog_background);
        am.setViewTextColor(this.dsB, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsH, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dso, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.dsI, R.drawable.bg_search_input);
        am.setViewTextColor(this.dsy, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.dss, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsu, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dsv, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.dsJ, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dsw, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.dsw, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.dsK, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dsz, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.dsz, (int) R.color.cp_link_tip_a);
        this.dso.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.dss.setCompoundDrawables(this.dsG, null, null, null);
        this.dsu.setCompoundDrawables(this.dsG, null, null, null);
        this.dsv.setCompoundDrawables(this.dsG, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ c dsN;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.dsN.dsx = null;
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
            this.dsN.dsx = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.dsN.uD(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.dsN.uD(this.dsN.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.dsN.uD(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.dsN.D(kVar.aJr());
                }
            } else {
                this.dsN.uD(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dsN.uD(null);
            this.dsN.aMM();
            super.onPreExecute();
        }
    }
}
