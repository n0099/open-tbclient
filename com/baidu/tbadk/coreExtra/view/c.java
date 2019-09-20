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
import com.baidu.adp.lib.g.g;
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
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private Drawable coA;
    private TextView coB;
    private View coC;
    private View coD;
    private View coE;
    private a.InterfaceC0248a coG;
    private Drawable coz;
    private Activity mContext;
    private int size;
    private View coh = null;
    private Dialog coi = null;
    private EditText coj = null;
    private RadioGroup cok = null;
    private RadioGroup col = null;

    /* renamed from: com  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f3com = null;
    private RadioButton con = null;
    private RadioButton coo = null;
    private RadioButton cop = null;
    private TextView coq = null;
    private b cor = null;
    private TextView cos = null;
    private TextView cot = null;
    private ProgressBar cou = null;
    private TextView cov = null;
    private AccountData cow = null;
    private a cox = null;
    private a coy = null;
    private boolean coF = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.coz = null;
        this.coA = null;
        this.size = 0;
        this.mContext = activity;
        this.coz = am.getDrawable(R.drawable.icon_tips_names_s);
        this.coA = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.coz.setBounds(0, 0, this.size, this.size);
        this.coA.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0248a interfaceC0248a) {
        this.coG = interfaceC0248a;
    }

    public void setAccountData(AccountData accountData) {
        this.cow = accountData;
    }

    public void a(a aVar) {
        this.cox = aVar;
    }

    public void b(a aVar) {
        this.coy = aVar;
    }

    public void aqB() {
        jX(0);
    }

    public void jX(int i) {
        if (this.coi == null) {
            this.coh = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.coB = (TextView) this.coh.findViewById(R.id.tip_info);
            this.coC = this.coh.findViewById(R.id.divider_under_account);
            this.coD = this.coh.findViewById(R.id.divider_under_radiongroup);
            this.coE = this.coh.findViewById(R.id.divider_with_yes_no_button);
            this.coj = (EditText) this.coh.findViewById(R.id.account);
            this.coj.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.coq = (TextView) this.coh.findViewById(R.id.back);
            this.coq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aqF();
                    c.this.aqD();
                }
            });
            this.cot = (TextView) this.coh.findViewById(R.id.confirm);
            this.cot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aqC();
                }
            });
            this.cou = (ProgressBar) this.coh.findViewById(R.id.confirm_progress);
            this.cos = (TextView) this.coh.findViewById(R.id.error_info);
            this.cok = (RadioGroup) this.coh.findViewById(R.id.names_group1);
            this.col = (RadioGroup) this.coh.findViewById(R.id.names_group2);
            this.con = (RadioButton) this.coh.findViewById(R.id.name1);
            this.coo = (RadioButton) this.coh.findViewById(R.id.name2);
            this.cop = (RadioButton) this.coh.findViewById(R.id.name3);
            this.f3com = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.con) {
                            c.this.col.clearCheck();
                            c.this.con.setChecked(true);
                            c.this.con.setCompoundDrawables(c.this.coz, null, null, null);
                            c.this.coo.setChecked(false);
                            c.this.coo.setCompoundDrawables(c.this.coA, null, null, null);
                            c.this.cop.setChecked(false);
                            c.this.cop.setCompoundDrawables(c.this.coA, null, null, null);
                        } else if (compoundButton == c.this.coo) {
                            c.this.col.clearCheck();
                            c.this.con.setChecked(false);
                            c.this.con.setCompoundDrawables(c.this.coA, null, null, null);
                            c.this.coo.setChecked(true);
                            c.this.coo.setCompoundDrawables(c.this.coz, null, null, null);
                            c.this.cop.setChecked(false);
                            c.this.cop.setCompoundDrawables(c.this.coA, null, null, null);
                        } else if (compoundButton == c.this.cop) {
                            c.this.cok.clearCheck();
                            c.this.con.setChecked(false);
                            c.this.con.setCompoundDrawables(c.this.coA, null, null, null);
                            c.this.coo.setChecked(false);
                            c.this.coo.setCompoundDrawables(c.this.coA, null, null, null);
                            c.this.cop.setChecked(true);
                            c.this.cop.setCompoundDrawables(c.this.coz, null, null, null);
                        }
                        c.this.coj.setText(compoundButton.getText());
                    }
                }
            };
            this.con.setOnCheckedChangeListener(this.f3com);
            this.coo.setOnCheckedChangeListener(this.f3com);
            this.cop.setOnCheckedChangeListener(this.f3com);
            this.cov = (TextView) this.coh.findViewById(R.id.phone_info);
            aqE();
            this.coi = new Dialog(this.mContext, R.style.input_username_dialog);
            this.coi.setCanceledOnTouchOutside(false);
            this.coi.setCancelable(false);
            this.coi.setCanceledOnTouchOutside(false);
            aqs();
        }
        if (i == 1) {
            this.cov.setText(R.string.tip_init_user_name);
        } else {
            this.cov.setText(R.string.bar_friend);
        }
        if (!this.coi.isShowing()) {
            this.coj.setText((CharSequence) null);
            aqE();
            pT(null);
            if (!this.mContext.isFinishing()) {
                this.coi.setContentView(this.coh);
                g.a(this.coi, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.coj, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new RunnableC0260c(this.coj), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0260c implements Runnable {
        private View mView;

        public RunnableC0260c(View view) {
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

    public void aqC() {
        String obj = this.coj.getText().toString();
        if (obj == null || obj.length() <= 0) {
            pT(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            pT(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.cor != null) {
                this.cor.cancel();
            }
            if (!this.coF && this.cow != null) {
                this.cou.setVisibility(0);
                this.cot.setEnabled(false);
                pT(null);
                aqE();
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
                        c.this.aqF();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.acj().a(session.username, session.bduss, "", null, c.this.coG);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.pT(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.coF = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cou.setVisibility(8);
                        c.this.cot.setEnabled(true);
                        c.this.coF = false;
                    }
                }, this.cow.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqD() {
        if (this.coy != null) {
            this.coy.g(null);
        }
    }

    public void w(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            pT(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        pT(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.cok.clearCheck();
        this.col.clearCheck();
        this.cok.setVisibility(0);
        this.col.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.con.setText(arrayList.get(0));
            this.con.setChecked(false);
            this.con.setCompoundDrawables(this.coA, null, null, null);
            this.con.setVisibility(0);
            this.cok.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.coo.setText(arrayList.get(1));
            this.coo.setChecked(false);
            this.coo.setCompoundDrawables(this.coA, null, null, null);
            this.coo.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.cop.setText(arrayList.get(2));
            this.cop.setChecked(false);
            this.cop.setCompoundDrawables(this.coA, null, null, null);
            this.cop.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cor != null) {
            this.cor.cancel();
            this.cor = null;
        }
        aqF();
    }

    public void aqE() {
        this.cok.setVisibility(8);
        this.cok.clearCheck();
        this.col.setVisibility(8);
        this.col.clearCheck();
        this.con.setVisibility(8);
        this.coo.setVisibility(8);
        this.cop.setVisibility(8);
        this.con.setChecked(false);
        this.coo.setChecked(false);
        this.cop.setChecked(false);
    }

    public void aqF() {
        if (this.coi != null && this.coi.isShowing()) {
            g.b(this.coi, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pT(String str) {
        if (str == null) {
            this.cos.setVisibility(4);
            this.cos.setText((CharSequence) null);
            return;
        }
        this.cos.setVisibility(0);
        this.cos.setText(str);
    }

    private void aqs() {
        am.k(this.coh, R.drawable.dialog_background);
        am.j(this.cov, R.color.cp_cont_b);
        am.j(this.coB, R.color.cp_cont_f);
        am.j(this.coj, R.color.cp_cont_b);
        am.k(this.coC, R.drawable.bg_search_input);
        am.j(this.cos, R.color.cp_cont_h);
        am.j(this.con, R.color.cp_cont_b);
        am.j(this.coo, R.color.cp_cont_b);
        am.j(this.cop, R.color.cp_cont_b);
        am.l(this.coD, R.color.cp_bg_line_c);
        am.k(this.coq, R.drawable.dialog_left_button_selector);
        am.j(this.coq, R.color.cp_link_tip_a);
        am.l(this.coE, R.color.cp_bg_line_c);
        am.k(this.cot, R.drawable.dialog_right_button_selector);
        am.j(this.cot, R.color.cp_link_tip_a);
        this.coj.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.con.setCompoundDrawables(this.coA, null, null, null);
        this.coo.setCompoundDrawables(this.coA, null, null, null);
        this.cop.setCompoundDrawables(this.coA, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c coH;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.coH.cor = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.o("un", this.mAccount);
            String aim = this.mNetwork.aim();
            if (!this.mNetwork.aiN() || this.mNetwork.aiO() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(aim);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.coH.cor = null;
            if (!this.mNetwork.aiN()) {
                this.coH.pT(this.mNetwork.getErrorString());
            } else if (this.mNetwork.aiO() == 0) {
                this.coH.pT(this.coH.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.aiO() == 36) {
                this.coH.pT(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.coH.w(jVar.amB());
                }
            } else {
                this.coH.pT(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.coH.pT(null);
            this.coH.aqE();
            super.onPreExecute();
        }
    }
}
