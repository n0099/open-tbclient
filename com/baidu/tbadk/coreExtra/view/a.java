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
    private Drawable aUJ;
    private Drawable aUK;
    private TextView aUL;
    private View aUM;
    private View aUN;
    private View aUO;
    private a.InterfaceC0155a aUQ;
    private Activity mContext;
    private int size;
    private View aUr = null;
    private Dialog aUs = null;
    private EditText aUt = null;
    private RadioGroup aUu = null;
    private RadioGroup aUv = null;
    private CompoundButton.OnCheckedChangeListener aUw = null;
    private RadioButton aUx = null;
    private RadioButton aUy = null;
    private RadioButton aUz = null;
    private TextView aUA = null;
    private b aUB = null;
    private TextView aUC = null;
    private TextView aUD = null;
    private ProgressBar aUE = null;
    private TextView aUF = null;
    private AccountData aUG = null;
    private InterfaceC0165a aUH = null;
    private InterfaceC0165a aUI = null;
    private boolean aUP = false;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0165a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.mContext = null;
        this.aUJ = null;
        this.aUK = null;
        this.size = 0;
        this.mContext = activity;
        this.aUJ = al.getDrawable(e.f.icon_tips_names_s);
        this.aUK = al.getDrawable(e.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds26);
        this.aUJ.setBounds(0, 0, this.size, this.size);
        this.aUK.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0155a interfaceC0155a) {
        this.aUQ = interfaceC0155a;
    }

    public void setAccountData(AccountData accountData) {
        this.aUG = accountData;
    }

    public void a(InterfaceC0165a interfaceC0165a) {
        this.aUH = interfaceC0165a;
    }

    public void b(InterfaceC0165a interfaceC0165a) {
        this.aUI = interfaceC0165a;
    }

    public void KG() {
        fs(0);
    }

    public void fs(int i) {
        if (this.aUs == null) {
            this.aUr = LayoutInflater.from(this.mContext).inflate(e.h.main_input_username, (ViewGroup) null);
            this.aUL = (TextView) this.aUr.findViewById(e.g.tip_info);
            this.aUM = this.aUr.findViewById(e.g.divider_under_account);
            this.aUN = this.aUr.findViewById(e.g.divider_under_radiongroup);
            this.aUO = this.aUr.findViewById(e.g.divider_with_yes_no_button);
            this.aUt = (EditText) this.aUr.findViewById(e.g.account);
            this.aUt.setHint(this.mContext.getString(e.j.hint_tip_input_name));
            this.aUA = (TextView) this.aUr.findViewById(e.g.back);
            this.aUA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.KK();
                    a.this.KI();
                }
            });
            this.aUD = (TextView) this.aUr.findViewById(e.g.confirm);
            this.aUD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.KH();
                }
            });
            this.aUE = (ProgressBar) this.aUr.findViewById(e.g.confirm_progress);
            this.aUC = (TextView) this.aUr.findViewById(e.g.error_info);
            this.aUu = (RadioGroup) this.aUr.findViewById(e.g.names_group1);
            this.aUv = (RadioGroup) this.aUr.findViewById(e.g.names_group2);
            this.aUx = (RadioButton) this.aUr.findViewById(e.g.name1);
            this.aUy = (RadioButton) this.aUr.findViewById(e.g.name2);
            this.aUz = (RadioButton) this.aUr.findViewById(e.g.name3);
            this.aUw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aUx) {
                            a.this.aUv.clearCheck();
                            a.this.aUx.setChecked(true);
                            a.this.aUx.setCompoundDrawables(a.this.aUJ, null, null, null);
                            a.this.aUy.setChecked(false);
                            a.this.aUy.setCompoundDrawables(a.this.aUK, null, null, null);
                            a.this.aUz.setChecked(false);
                            a.this.aUz.setCompoundDrawables(a.this.aUK, null, null, null);
                        } else if (compoundButton == a.this.aUy) {
                            a.this.aUv.clearCheck();
                            a.this.aUx.setChecked(false);
                            a.this.aUx.setCompoundDrawables(a.this.aUK, null, null, null);
                            a.this.aUy.setChecked(true);
                            a.this.aUy.setCompoundDrawables(a.this.aUJ, null, null, null);
                            a.this.aUz.setChecked(false);
                            a.this.aUz.setCompoundDrawables(a.this.aUK, null, null, null);
                        } else if (compoundButton == a.this.aUz) {
                            a.this.aUu.clearCheck();
                            a.this.aUx.setChecked(false);
                            a.this.aUx.setCompoundDrawables(a.this.aUK, null, null, null);
                            a.this.aUy.setChecked(false);
                            a.this.aUy.setCompoundDrawables(a.this.aUK, null, null, null);
                            a.this.aUz.setChecked(true);
                            a.this.aUz.setCompoundDrawables(a.this.aUJ, null, null, null);
                        }
                        a.this.aUt.setText(compoundButton.getText());
                    }
                }
            };
            this.aUx.setOnCheckedChangeListener(this.aUw);
            this.aUy.setOnCheckedChangeListener(this.aUw);
            this.aUz.setOnCheckedChangeListener(this.aUw);
            this.aUF = (TextView) this.aUr.findViewById(e.g.phone_info);
            KJ();
            this.aUs = new Dialog(this.mContext, e.k.input_username_dialog);
            this.aUs.setCanceledOnTouchOutside(false);
            this.aUs.setCancelable(false);
            this.aUs.setCanceledOnTouchOutside(false);
            KD();
        }
        if (i == 1) {
            this.aUF.setText(e.j.tip_init_user_name);
        } else {
            this.aUF.setText(e.j.bar_friend);
        }
        if (!this.aUs.isShowing()) {
            this.aUt.setText((CharSequence) null);
            KJ();
            hv(null);
            if (!this.mContext.isFinishing()) {
                this.aUs.setContentView(this.aUr);
                g.a(this.aUs, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.aUt, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aUt), 150L);
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
        String obj = this.aUt.getText().toString();
        if (obj == null || obj.length() <= 0) {
            hv(this.mContext.getString(e.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            hv(this.mContext.getString(e.j.input_alias_limit_length_tip));
        } else {
            if (this.aUB != null) {
                this.aUB.cancel();
            }
            if (!this.aUP && this.aUG != null) {
                this.aUE.setVisibility(0);
                this.aUD.setEnabled(false);
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
                        com.baidu.tbadk.core.a.a.xW().a(session.username, session.bduss, "", null, a.this.aUQ);
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
                        a.this.aUP = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        a.this.aUE.setVisibility(8);
                        a.this.aUD.setEnabled(true);
                        a.this.aUP = false;
                    }
                }, this.aUG.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KI() {
        if (this.aUI != null) {
            this.aUI.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            hv(this.mContext.getString(e.j.suggest_no_name));
            return;
        }
        hv(this.mContext.getString(e.j.suggest_some_names));
        int size = arrayList.size();
        this.aUu.clearCheck();
        this.aUv.clearCheck();
        this.aUu.setVisibility(0);
        this.aUv.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aUx.setText(arrayList.get(0));
            this.aUx.setChecked(false);
            this.aUx.setCompoundDrawables(this.aUK, null, null, null);
            this.aUx.setVisibility(0);
            this.aUu.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aUy.setText(arrayList.get(1));
            this.aUy.setChecked(false);
            this.aUy.setCompoundDrawables(this.aUK, null, null, null);
            this.aUy.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aUz.setText(arrayList.get(2));
            this.aUz.setChecked(false);
            this.aUz.setCompoundDrawables(this.aUK, null, null, null);
            this.aUz.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aUB != null) {
            this.aUB.cancel();
            this.aUB = null;
        }
        KK();
    }

    public void KJ() {
        this.aUu.setVisibility(8);
        this.aUu.clearCheck();
        this.aUv.setVisibility(8);
        this.aUv.clearCheck();
        this.aUx.setVisibility(8);
        this.aUy.setVisibility(8);
        this.aUz.setVisibility(8);
        this.aUx.setChecked(false);
        this.aUy.setChecked(false);
        this.aUz.setChecked(false);
    }

    public void KK() {
        if (this.aUs != null && this.aUs.isShowing()) {
            g.b(this.aUs, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv(String str) {
        if (str == null) {
            this.aUC.setVisibility(4);
            this.aUC.setText((CharSequence) null);
            return;
        }
        this.aUC.setVisibility(0);
        this.aUC.setText(str);
    }

    private void KD() {
        al.i(this.aUr, e.f.dialog_background);
        al.h(this.aUF, e.d.cp_cont_b);
        al.h(this.aUL, e.d.cp_cont_f);
        al.h(this.aUt, e.d.cp_cont_b);
        al.i(this.aUM, e.f.bg_search_input);
        al.h(this.aUC, e.d.cp_cont_h);
        al.h(this.aUx, e.d.cp_cont_b);
        al.h(this.aUy, e.d.cp_cont_b);
        al.h(this.aUz, e.d.cp_cont_b);
        al.j(this.aUN, e.d.cp_bg_line_a);
        al.i(this.aUA, e.f.dialog_left_button_selector);
        al.h(this.aUA, e.d.cp_link_tip_a);
        al.j(this.aUO, e.d.cp_bg_line_a);
        al.i(this.aUD, e.f.dialog_right_button_selector);
        al.h(this.aUD, e.d.cp_link_tip_a);
        this.aUt.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.aUx.setCompoundDrawables(this.aUK, null, null, null);
        this.aUy.setCompoundDrawables(this.aUK, null, null, null);
        this.aUz.setCompoundDrawables(this.aUK, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ a aUR;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aUR.aUB = null;
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
            this.aUR.aUB = null;
            if (!this.mNetwork.Dz()) {
                this.aUR.hv(this.mNetwork.getErrorString());
            } else if (this.mNetwork.DA() == 0) {
                this.aUR.hv(this.aUR.mContext.getString(e.j.name_not_use));
            } else if (this.mNetwork.DA() == 36) {
                this.aUR.hv(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.aUR.r(jVar.GT());
                }
            } else {
                this.aUR.hv(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aUR.hv(null);
            this.aUR.KJ();
            super.onPreExecute();
        }
    }
}
