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
    private Drawable aUb;
    private Drawable aUc;
    private TextView aUd;
    private View aUe;
    private View aUf;
    private View aUg;
    private a.InterfaceC0155a aUi;
    private Activity mContext;
    private int size;
    private View aTJ = null;
    private Dialog aTK = null;
    private EditText aTL = null;
    private RadioGroup aTM = null;
    private RadioGroup aTN = null;
    private CompoundButton.OnCheckedChangeListener aTO = null;
    private RadioButton aTP = null;
    private RadioButton aTQ = null;
    private RadioButton aTR = null;
    private TextView aTS = null;
    private b aTT = null;
    private TextView aTU = null;
    private TextView aTV = null;
    private ProgressBar aTW = null;
    private TextView aTX = null;
    private AccountData aTY = null;
    private InterfaceC0165a aTZ = null;
    private InterfaceC0165a aUa = null;
    private boolean aUh = false;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0165a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.mContext = null;
        this.aUb = null;
        this.aUc = null;
        this.size = 0;
        this.mContext = activity;
        this.aUb = al.getDrawable(e.f.icon_tips_names_s);
        this.aUc = al.getDrawable(e.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds26);
        this.aUb.setBounds(0, 0, this.size, this.size);
        this.aUc.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0155a interfaceC0155a) {
        this.aUi = interfaceC0155a;
    }

    public void setAccountData(AccountData accountData) {
        this.aTY = accountData;
    }

    public void a(InterfaceC0165a interfaceC0165a) {
        this.aTZ = interfaceC0165a;
    }

    public void b(InterfaceC0165a interfaceC0165a) {
        this.aUa = interfaceC0165a;
    }

    public void Kr() {
        fs(0);
    }

    public void fs(int i) {
        if (this.aTK == null) {
            this.aTJ = LayoutInflater.from(this.mContext).inflate(e.h.main_input_username, (ViewGroup) null);
            this.aUd = (TextView) this.aTJ.findViewById(e.g.tip_info);
            this.aUe = this.aTJ.findViewById(e.g.divider_under_account);
            this.aUf = this.aTJ.findViewById(e.g.divider_under_radiongroup);
            this.aUg = this.aTJ.findViewById(e.g.divider_with_yes_no_button);
            this.aTL = (EditText) this.aTJ.findViewById(e.g.account);
            this.aTL.setHint(this.mContext.getString(e.j.hint_tip_input_name));
            this.aTS = (TextView) this.aTJ.findViewById(e.g.back);
            this.aTS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Kv();
                    a.this.Kt();
                }
            });
            this.aTV = (TextView) this.aTJ.findViewById(e.g.confirm);
            this.aTV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Ks();
                }
            });
            this.aTW = (ProgressBar) this.aTJ.findViewById(e.g.confirm_progress);
            this.aTU = (TextView) this.aTJ.findViewById(e.g.error_info);
            this.aTM = (RadioGroup) this.aTJ.findViewById(e.g.names_group1);
            this.aTN = (RadioGroup) this.aTJ.findViewById(e.g.names_group2);
            this.aTP = (RadioButton) this.aTJ.findViewById(e.g.name1);
            this.aTQ = (RadioButton) this.aTJ.findViewById(e.g.name2);
            this.aTR = (RadioButton) this.aTJ.findViewById(e.g.name3);
            this.aTO = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aTP) {
                            a.this.aTN.clearCheck();
                            a.this.aTP.setChecked(true);
                            a.this.aTP.setCompoundDrawables(a.this.aUb, null, null, null);
                            a.this.aTQ.setChecked(false);
                            a.this.aTQ.setCompoundDrawables(a.this.aUc, null, null, null);
                            a.this.aTR.setChecked(false);
                            a.this.aTR.setCompoundDrawables(a.this.aUc, null, null, null);
                        } else if (compoundButton == a.this.aTQ) {
                            a.this.aTN.clearCheck();
                            a.this.aTP.setChecked(false);
                            a.this.aTP.setCompoundDrawables(a.this.aUc, null, null, null);
                            a.this.aTQ.setChecked(true);
                            a.this.aTQ.setCompoundDrawables(a.this.aUb, null, null, null);
                            a.this.aTR.setChecked(false);
                            a.this.aTR.setCompoundDrawables(a.this.aUc, null, null, null);
                        } else if (compoundButton == a.this.aTR) {
                            a.this.aTM.clearCheck();
                            a.this.aTP.setChecked(false);
                            a.this.aTP.setCompoundDrawables(a.this.aUc, null, null, null);
                            a.this.aTQ.setChecked(false);
                            a.this.aTQ.setCompoundDrawables(a.this.aUc, null, null, null);
                            a.this.aTR.setChecked(true);
                            a.this.aTR.setCompoundDrawables(a.this.aUb, null, null, null);
                        }
                        a.this.aTL.setText(compoundButton.getText());
                    }
                }
            };
            this.aTP.setOnCheckedChangeListener(this.aTO);
            this.aTQ.setOnCheckedChangeListener(this.aTO);
            this.aTR.setOnCheckedChangeListener(this.aTO);
            this.aTX = (TextView) this.aTJ.findViewById(e.g.phone_info);
            Ku();
            this.aTK = new Dialog(this.mContext, e.k.input_username_dialog);
            this.aTK.setCanceledOnTouchOutside(false);
            this.aTK.setCancelable(false);
            this.aTK.setCanceledOnTouchOutside(false);
            Ko();
        }
        if (i == 1) {
            this.aTX.setText(e.j.tip_init_user_name);
        } else {
            this.aTX.setText(e.j.bar_friend);
        }
        if (!this.aTK.isShowing()) {
            this.aTL.setText((CharSequence) null);
            Ku();
            hh(null);
            if (!this.mContext.isFinishing()) {
                this.aTK.setContentView(this.aTJ);
                g.a(this.aTK, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.aTL, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aTL), 150L);
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

    public void Ks() {
        String obj = this.aTL.getText().toString();
        if (obj == null || obj.length() <= 0) {
            hh(this.mContext.getString(e.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            hh(this.mContext.getString(e.j.input_alias_limit_length_tip));
        } else {
            if (this.aTT != null) {
                this.aTT.cancel();
            }
            if (!this.aUh && this.aTY != null) {
                this.aTW.setVisibility(0);
                this.aTV.setEnabled(false);
                hh(null);
                Ku();
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
                        a.this.Kv();
                        l.showToast(a.this.mContext, e.j.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.xJ().a(session.username, session.bduss, "", null, a.this.aUi);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            a.this.hh(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        a.this.aUh = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        a.this.aTW.setVisibility(8);
                        a.this.aTV.setEnabled(true);
                        a.this.aUh = false;
                    }
                }, this.aTY.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kt() {
        if (this.aUa != null) {
            this.aUa.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            hh(this.mContext.getString(e.j.suggest_no_name));
            return;
        }
        hh(this.mContext.getString(e.j.suggest_some_names));
        int size = arrayList.size();
        this.aTM.clearCheck();
        this.aTN.clearCheck();
        this.aTM.setVisibility(0);
        this.aTN.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aTP.setText(arrayList.get(0));
            this.aTP.setChecked(false);
            this.aTP.setCompoundDrawables(this.aUc, null, null, null);
            this.aTP.setVisibility(0);
            this.aTM.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aTQ.setText(arrayList.get(1));
            this.aTQ.setChecked(false);
            this.aTQ.setCompoundDrawables(this.aUc, null, null, null);
            this.aTQ.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aTR.setText(arrayList.get(2));
            this.aTR.setChecked(false);
            this.aTR.setCompoundDrawables(this.aUc, null, null, null);
            this.aTR.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aTT != null) {
            this.aTT.cancel();
            this.aTT = null;
        }
        Kv();
    }

    public void Ku() {
        this.aTM.setVisibility(8);
        this.aTM.clearCheck();
        this.aTN.setVisibility(8);
        this.aTN.clearCheck();
        this.aTP.setVisibility(8);
        this.aTQ.setVisibility(8);
        this.aTR.setVisibility(8);
        this.aTP.setChecked(false);
        this.aTQ.setChecked(false);
        this.aTR.setChecked(false);
    }

    public void Kv() {
        if (this.aTK != null && this.aTK.isShowing()) {
            g.b(this.aTK, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh(String str) {
        if (str == null) {
            this.aTU.setVisibility(4);
            this.aTU.setText((CharSequence) null);
            return;
        }
        this.aTU.setVisibility(0);
        this.aTU.setText(str);
    }

    private void Ko() {
        al.i(this.aTJ, e.f.dialog_background);
        al.h(this.aTX, e.d.cp_cont_b);
        al.h(this.aUd, e.d.cp_cont_f);
        al.h(this.aTL, e.d.cp_cont_b);
        al.i(this.aUe, e.f.bg_search_input);
        al.h(this.aTU, e.d.cp_cont_h);
        al.h(this.aTP, e.d.cp_cont_b);
        al.h(this.aTQ, e.d.cp_cont_b);
        al.h(this.aTR, e.d.cp_cont_b);
        al.j(this.aUf, e.d.cp_bg_line_a);
        al.i(this.aTS, e.f.dialog_left_button_selector);
        al.h(this.aTS, e.d.cp_link_tip_a);
        al.j(this.aUg, e.d.cp_bg_line_a);
        al.i(this.aTV, e.f.dialog_right_button_selector);
        al.h(this.aTV, e.d.cp_link_tip_a);
        this.aTL.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.aTP.setCompoundDrawables(this.aUc, null, null, null);
        this.aTQ.setCompoundDrawables(this.aUc, null, null, null);
        this.aTR.setCompoundDrawables(this.aUc, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ a aUj;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aUj.aTT = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.x("un", this.mAccount);
            String CL = this.mNetwork.CL();
            if (!this.mNetwork.Dm() || this.mNetwork.Dn() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(CL);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.aUj.aTT = null;
            if (!this.mNetwork.Dm()) {
                this.aUj.hh(this.mNetwork.getErrorString());
            } else if (this.mNetwork.Dn() == 0) {
                this.aUj.hh(this.aUj.mContext.getString(e.j.name_not_use));
            } else if (this.mNetwork.Dn() == 36) {
                this.aUj.hh(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.aUj.r(jVar.GG());
                }
            } else {
                this.aUj.hh(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aUj.hh(null);
            this.aUj.Ku();
            super.onPreExecute();
        }
    }
}
