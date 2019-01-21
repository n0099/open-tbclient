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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private Drawable aUK;
    private Drawable aUL;
    private TextView aUM;
    private View aUN;
    private View aUO;
    private View aUP;
    private a.InterfaceC0155a aUR;
    private Activity mContext;
    private int size;
    private View aUs = null;
    private Dialog aUt = null;
    private EditText aUu = null;
    private RadioGroup aUv = null;
    private RadioGroup aUw = null;
    private CompoundButton.OnCheckedChangeListener aUx = null;
    private RadioButton aUy = null;
    private RadioButton aUz = null;
    private RadioButton aUA = null;
    private TextView aUB = null;
    private b aUC = null;
    private TextView aUD = null;
    private TextView aUE = null;
    private ProgressBar aUF = null;
    private TextView aUG = null;
    private AccountData aUH = null;
    private InterfaceC0165a aUI = null;
    private InterfaceC0165a aUJ = null;
    private boolean aUQ = false;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0165a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.mContext = null;
        this.aUK = null;
        this.aUL = null;
        this.size = 0;
        this.mContext = activity;
        this.aUK = al.getDrawable(e.f.icon_tips_names_s);
        this.aUL = al.getDrawable(e.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds26);
        this.aUK.setBounds(0, 0, this.size, this.size);
        this.aUL.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0155a interfaceC0155a) {
        this.aUR = interfaceC0155a;
    }

    public void setAccountData(AccountData accountData) {
        this.aUH = accountData;
    }

    public void a(InterfaceC0165a interfaceC0165a) {
        this.aUI = interfaceC0165a;
    }

    public void b(InterfaceC0165a interfaceC0165a) {
        this.aUJ = interfaceC0165a;
    }

    public void KG() {
        fs(0);
    }

    public void fs(int i) {
        if (this.aUt == null) {
            this.aUs = LayoutInflater.from(this.mContext).inflate(e.h.main_input_username, (ViewGroup) null);
            this.aUM = (TextView) this.aUs.findViewById(e.g.tip_info);
            this.aUN = this.aUs.findViewById(e.g.divider_under_account);
            this.aUO = this.aUs.findViewById(e.g.divider_under_radiongroup);
            this.aUP = this.aUs.findViewById(e.g.divider_with_yes_no_button);
            this.aUu = (EditText) this.aUs.findViewById(e.g.account);
            this.aUu.setHint(this.mContext.getString(e.j.hint_tip_input_name));
            this.aUB = (TextView) this.aUs.findViewById(e.g.back);
            this.aUB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.KK();
                    a.this.KI();
                }
            });
            this.aUE = (TextView) this.aUs.findViewById(e.g.confirm);
            this.aUE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.KH();
                }
            });
            this.aUF = (ProgressBar) this.aUs.findViewById(e.g.confirm_progress);
            this.aUD = (TextView) this.aUs.findViewById(e.g.error_info);
            this.aUv = (RadioGroup) this.aUs.findViewById(e.g.names_group1);
            this.aUw = (RadioGroup) this.aUs.findViewById(e.g.names_group2);
            this.aUy = (RadioButton) this.aUs.findViewById(e.g.name1);
            this.aUz = (RadioButton) this.aUs.findViewById(e.g.name2);
            this.aUA = (RadioButton) this.aUs.findViewById(e.g.name3);
            this.aUx = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aUy) {
                            a.this.aUw.clearCheck();
                            a.this.aUy.setChecked(true);
                            a.this.aUy.setCompoundDrawables(a.this.aUK, null, null, null);
                            a.this.aUz.setChecked(false);
                            a.this.aUz.setCompoundDrawables(a.this.aUL, null, null, null);
                            a.this.aUA.setChecked(false);
                            a.this.aUA.setCompoundDrawables(a.this.aUL, null, null, null);
                        } else if (compoundButton == a.this.aUz) {
                            a.this.aUw.clearCheck();
                            a.this.aUy.setChecked(false);
                            a.this.aUy.setCompoundDrawables(a.this.aUL, null, null, null);
                            a.this.aUz.setChecked(true);
                            a.this.aUz.setCompoundDrawables(a.this.aUK, null, null, null);
                            a.this.aUA.setChecked(false);
                            a.this.aUA.setCompoundDrawables(a.this.aUL, null, null, null);
                        } else if (compoundButton == a.this.aUA) {
                            a.this.aUv.clearCheck();
                            a.this.aUy.setChecked(false);
                            a.this.aUy.setCompoundDrawables(a.this.aUL, null, null, null);
                            a.this.aUz.setChecked(false);
                            a.this.aUz.setCompoundDrawables(a.this.aUL, null, null, null);
                            a.this.aUA.setChecked(true);
                            a.this.aUA.setCompoundDrawables(a.this.aUK, null, null, null);
                        }
                        a.this.aUu.setText(compoundButton.getText());
                    }
                }
            };
            this.aUy.setOnCheckedChangeListener(this.aUx);
            this.aUz.setOnCheckedChangeListener(this.aUx);
            this.aUA.setOnCheckedChangeListener(this.aUx);
            this.aUG = (TextView) this.aUs.findViewById(e.g.phone_info);
            KJ();
            this.aUt = new Dialog(this.mContext, e.k.input_username_dialog);
            this.aUt.setCanceledOnTouchOutside(false);
            this.aUt.setCancelable(false);
            this.aUt.setCanceledOnTouchOutside(false);
            KD();
        }
        if (i == 1) {
            this.aUG.setText(e.j.tip_init_user_name);
        } else {
            this.aUG.setText(e.j.bar_friend);
        }
        if (!this.aUt.isShowing()) {
            this.aUu.setText((CharSequence) null);
            KJ();
            hv(null);
            if (!this.mContext.isFinishing()) {
                this.aUt.setContentView(this.aUs);
                g.a(this.aUt, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.aUu, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aUu), 150L);
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
            if (!a.this.mContext.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) a.this.mContext.getSystemService("input_method");
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

    public void KH() {
        String obj = this.aUu.getText().toString();
        if (obj == null || obj.length() <= 0) {
            hv(this.mContext.getString(e.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            hv(this.mContext.getString(e.j.input_alias_limit_length_tip));
        } else {
            if (this.aUC != null) {
                this.aUC.cancel();
            }
            if (!this.aUQ && this.aUH != null) {
                this.aUF.setVisibility(0);
                this.aUE.setEnabled(false);
                hv(null);
                KJ();
                SapiAccountManager.getInstance().getAccountService().fillUsername(new FillUsernameCallback() { // from class: com.baidu.tbadk.coreExtra.view.a.4
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
                        a.this.KK();
                        l.showToast(a.this.mContext, e.j.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.xW().a(session.username, session.bduss, "", null, a.this.aUR);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            a.this.hv(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        a.this.aUQ = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        a.this.aUF.setVisibility(8);
                        a.this.aUE.setEnabled(true);
                        a.this.aUQ = false;
                    }
                }, this.aUH.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KI() {
        if (this.aUJ != null) {
            this.aUJ.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            hv(this.mContext.getString(e.j.suggest_no_name));
            return;
        }
        hv(this.mContext.getString(e.j.suggest_some_names));
        int size = arrayList.size();
        this.aUv.clearCheck();
        this.aUw.clearCheck();
        this.aUv.setVisibility(0);
        this.aUw.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aUy.setText(arrayList.get(0));
            this.aUy.setChecked(false);
            this.aUy.setCompoundDrawables(this.aUL, null, null, null);
            this.aUy.setVisibility(0);
            this.aUv.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aUz.setText(arrayList.get(1));
            this.aUz.setChecked(false);
            this.aUz.setCompoundDrawables(this.aUL, null, null, null);
            this.aUz.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aUA.setText(arrayList.get(2));
            this.aUA.setChecked(false);
            this.aUA.setCompoundDrawables(this.aUL, null, null, null);
            this.aUA.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aUC != null) {
            this.aUC.cancel();
            this.aUC = null;
        }
        KK();
    }

    public void KJ() {
        this.aUv.setVisibility(8);
        this.aUv.clearCheck();
        this.aUw.setVisibility(8);
        this.aUw.clearCheck();
        this.aUy.setVisibility(8);
        this.aUz.setVisibility(8);
        this.aUA.setVisibility(8);
        this.aUy.setChecked(false);
        this.aUz.setChecked(false);
        this.aUA.setChecked(false);
    }

    public void KK() {
        if (this.aUt != null && this.aUt.isShowing()) {
            g.b(this.aUt, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(String str) {
        if (str == null) {
            this.aUD.setVisibility(4);
            this.aUD.setText((CharSequence) null);
            return;
        }
        this.aUD.setVisibility(0);
        this.aUD.setText(str);
    }

    private void KD() {
        al.i(this.aUs, e.f.dialog_background);
        al.h(this.aUG, e.d.cp_cont_b);
        al.h(this.aUM, e.d.cp_cont_f);
        al.h(this.aUu, e.d.cp_cont_b);
        al.i(this.aUN, e.f.bg_search_input);
        al.h(this.aUD, e.d.cp_cont_h);
        al.h(this.aUy, e.d.cp_cont_b);
        al.h(this.aUz, e.d.cp_cont_b);
        al.h(this.aUA, e.d.cp_cont_b);
        al.j(this.aUO, e.d.cp_bg_line_a);
        al.i(this.aUB, e.f.dialog_left_button_selector);
        al.h(this.aUB, e.d.cp_link_tip_a);
        al.j(this.aUP, e.d.cp_bg_line_a);
        al.i(this.aUE, e.f.dialog_right_button_selector);
        al.h(this.aUE, e.d.cp_link_tip_a);
        this.aUu.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.aUy.setCompoundDrawables(this.aUL, null, null, null);
        this.aUz.setCompoundDrawables(this.aUL, null, null, null);
        this.aUA.setCompoundDrawables(this.aUL, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ a aUS;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aUS.aUC = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.x("un", this.mAccount);
            String CY = this.mNetwork.CY();
            if (!this.mNetwork.Dz() || this.mNetwork.DA() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(CY);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.aUS.aUC = null;
            if (!this.mNetwork.Dz()) {
                this.aUS.hv(this.mNetwork.getErrorString());
            } else if (this.mNetwork.DA() == 0) {
                this.aUS.hv(this.aUS.mContext.getString(e.j.name_not_use));
            } else if (this.mNetwork.DA() == 36) {
                this.aUS.hv(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.aUS.r(jVar.GT());
                }
            } else {
                this.aUS.hv(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aUS.hv(null);
            this.aUS.KJ();
            super.onPreExecute();
        }
    }
}
