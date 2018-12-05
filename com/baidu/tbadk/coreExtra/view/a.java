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
    private Drawable aTY;
    private Drawable aTZ;
    private TextView aUa;
    private View aUb;
    private View aUc;
    private View aUd;
    private a.InterfaceC0155a aUf;
    private Activity mContext;
    private int size;
    private View aTG = null;
    private Dialog aTH = null;
    private EditText aTI = null;
    private RadioGroup aTJ = null;
    private RadioGroup aTK = null;
    private CompoundButton.OnCheckedChangeListener aTL = null;
    private RadioButton aTM = null;
    private RadioButton aTN = null;
    private RadioButton aTO = null;
    private TextView aTP = null;
    private b aTQ = null;
    private TextView aTR = null;
    private TextView aTS = null;
    private ProgressBar aTT = null;
    private TextView aTU = null;
    private AccountData aTV = null;
    private InterfaceC0165a aTW = null;
    private InterfaceC0165a aTX = null;
    private boolean aUe = false;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0165a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.mContext = null;
        this.aTY = null;
        this.aTZ = null;
        this.size = 0;
        this.mContext = activity;
        this.aTY = al.getDrawable(e.f.icon_tips_names_s);
        this.aTZ = al.getDrawable(e.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds26);
        this.aTY.setBounds(0, 0, this.size, this.size);
        this.aTZ.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0155a interfaceC0155a) {
        this.aUf = interfaceC0155a;
    }

    public void setAccountData(AccountData accountData) {
        this.aTV = accountData;
    }

    public void a(InterfaceC0165a interfaceC0165a) {
        this.aTW = interfaceC0165a;
    }

    public void b(InterfaceC0165a interfaceC0165a) {
        this.aTX = interfaceC0165a;
    }

    public void Kq() {
        fr(0);
    }

    public void fr(int i) {
        if (this.aTH == null) {
            this.aTG = LayoutInflater.from(this.mContext).inflate(e.h.main_input_username, (ViewGroup) null);
            this.aUa = (TextView) this.aTG.findViewById(e.g.tip_info);
            this.aUb = this.aTG.findViewById(e.g.divider_under_account);
            this.aUc = this.aTG.findViewById(e.g.divider_under_radiongroup);
            this.aUd = this.aTG.findViewById(e.g.divider_with_yes_no_button);
            this.aTI = (EditText) this.aTG.findViewById(e.g.account);
            this.aTI.setHint(this.mContext.getString(e.j.hint_tip_input_name));
            this.aTP = (TextView) this.aTG.findViewById(e.g.back);
            this.aTP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Ku();
                    a.this.Ks();
                }
            });
            this.aTS = (TextView) this.aTG.findViewById(e.g.confirm);
            this.aTS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Kr();
                }
            });
            this.aTT = (ProgressBar) this.aTG.findViewById(e.g.confirm_progress);
            this.aTR = (TextView) this.aTG.findViewById(e.g.error_info);
            this.aTJ = (RadioGroup) this.aTG.findViewById(e.g.names_group1);
            this.aTK = (RadioGroup) this.aTG.findViewById(e.g.names_group2);
            this.aTM = (RadioButton) this.aTG.findViewById(e.g.name1);
            this.aTN = (RadioButton) this.aTG.findViewById(e.g.name2);
            this.aTO = (RadioButton) this.aTG.findViewById(e.g.name3);
            this.aTL = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aTM) {
                            a.this.aTK.clearCheck();
                            a.this.aTM.setChecked(true);
                            a.this.aTM.setCompoundDrawables(a.this.aTY, null, null, null);
                            a.this.aTN.setChecked(false);
                            a.this.aTN.setCompoundDrawables(a.this.aTZ, null, null, null);
                            a.this.aTO.setChecked(false);
                            a.this.aTO.setCompoundDrawables(a.this.aTZ, null, null, null);
                        } else if (compoundButton == a.this.aTN) {
                            a.this.aTK.clearCheck();
                            a.this.aTM.setChecked(false);
                            a.this.aTM.setCompoundDrawables(a.this.aTZ, null, null, null);
                            a.this.aTN.setChecked(true);
                            a.this.aTN.setCompoundDrawables(a.this.aTY, null, null, null);
                            a.this.aTO.setChecked(false);
                            a.this.aTO.setCompoundDrawables(a.this.aTZ, null, null, null);
                        } else if (compoundButton == a.this.aTO) {
                            a.this.aTJ.clearCheck();
                            a.this.aTM.setChecked(false);
                            a.this.aTM.setCompoundDrawables(a.this.aTZ, null, null, null);
                            a.this.aTN.setChecked(false);
                            a.this.aTN.setCompoundDrawables(a.this.aTZ, null, null, null);
                            a.this.aTO.setChecked(true);
                            a.this.aTO.setCompoundDrawables(a.this.aTY, null, null, null);
                        }
                        a.this.aTI.setText(compoundButton.getText());
                    }
                }
            };
            this.aTM.setOnCheckedChangeListener(this.aTL);
            this.aTN.setOnCheckedChangeListener(this.aTL);
            this.aTO.setOnCheckedChangeListener(this.aTL);
            this.aTU = (TextView) this.aTG.findViewById(e.g.phone_info);
            Kt();
            this.aTH = new Dialog(this.mContext, e.k.input_username_dialog);
            this.aTH.setCanceledOnTouchOutside(false);
            this.aTH.setCancelable(false);
            this.aTH.setCanceledOnTouchOutside(false);
            Kn();
        }
        if (i == 1) {
            this.aTU.setText(e.j.tip_init_user_name);
        } else {
            this.aTU.setText(e.j.bar_friend);
        }
        if (!this.aTH.isShowing()) {
            this.aTI.setText((CharSequence) null);
            Kt();
            hg(null);
            if (!this.mContext.isFinishing()) {
                this.aTH.setContentView(this.aTG);
                g.a(this.aTH, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.aTI, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aTI), 150L);
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

    public void Kr() {
        String obj = this.aTI.getText().toString();
        if (obj == null || obj.length() <= 0) {
            hg(this.mContext.getString(e.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            hg(this.mContext.getString(e.j.input_alias_limit_length_tip));
        } else {
            if (this.aTQ != null) {
                this.aTQ.cancel();
            }
            if (!this.aUe && this.aTV != null) {
                this.aTT.setVisibility(0);
                this.aTS.setEnabled(false);
                hg(null);
                Kt();
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
                        a.this.Ku();
                        l.showToast(a.this.mContext, e.j.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.xJ().a(session.username, session.bduss, "", null, a.this.aUf);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            a.this.hg(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        a.this.aUe = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        a.this.aTT.setVisibility(8);
                        a.this.aTS.setEnabled(true);
                        a.this.aUe = false;
                    }
                }, this.aTV.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ks() {
        if (this.aTX != null) {
            this.aTX.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            hg(this.mContext.getString(e.j.suggest_no_name));
            return;
        }
        hg(this.mContext.getString(e.j.suggest_some_names));
        int size = arrayList.size();
        this.aTJ.clearCheck();
        this.aTK.clearCheck();
        this.aTJ.setVisibility(0);
        this.aTK.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aTM.setText(arrayList.get(0));
            this.aTM.setChecked(false);
            this.aTM.setCompoundDrawables(this.aTZ, null, null, null);
            this.aTM.setVisibility(0);
            this.aTJ.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aTN.setText(arrayList.get(1));
            this.aTN.setChecked(false);
            this.aTN.setCompoundDrawables(this.aTZ, null, null, null);
            this.aTN.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aTO.setText(arrayList.get(2));
            this.aTO.setChecked(false);
            this.aTO.setCompoundDrawables(this.aTZ, null, null, null);
            this.aTO.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aTQ != null) {
            this.aTQ.cancel();
            this.aTQ = null;
        }
        Ku();
    }

    public void Kt() {
        this.aTJ.setVisibility(8);
        this.aTJ.clearCheck();
        this.aTK.setVisibility(8);
        this.aTK.clearCheck();
        this.aTM.setVisibility(8);
        this.aTN.setVisibility(8);
        this.aTO.setVisibility(8);
        this.aTM.setChecked(false);
        this.aTN.setChecked(false);
        this.aTO.setChecked(false);
    }

    public void Ku() {
        if (this.aTH != null && this.aTH.isShowing()) {
            g.b(this.aTH, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg(String str) {
        if (str == null) {
            this.aTR.setVisibility(4);
            this.aTR.setText((CharSequence) null);
            return;
        }
        this.aTR.setVisibility(0);
        this.aTR.setText(str);
    }

    private void Kn() {
        al.i(this.aTG, e.f.dialog_background);
        al.h(this.aTU, e.d.cp_cont_b);
        al.h(this.aUa, e.d.cp_cont_f);
        al.h(this.aTI, e.d.cp_cont_b);
        al.i(this.aUb, e.f.bg_search_input);
        al.h(this.aTR, e.d.cp_cont_h);
        al.h(this.aTM, e.d.cp_cont_b);
        al.h(this.aTN, e.d.cp_cont_b);
        al.h(this.aTO, e.d.cp_cont_b);
        al.j(this.aUc, e.d.cp_bg_line_a);
        al.i(this.aTP, e.f.dialog_left_button_selector);
        al.h(this.aTP, e.d.cp_link_tip_a);
        al.j(this.aUd, e.d.cp_bg_line_a);
        al.i(this.aTS, e.f.dialog_right_button_selector);
        al.h(this.aTS, e.d.cp_link_tip_a);
        this.aTI.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.aTM.setCompoundDrawables(this.aTZ, null, null, null);
        this.aTN.setCompoundDrawables(this.aTZ, null, null, null);
        this.aTO.setCompoundDrawables(this.aTZ, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ a aUg;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aUg.aTQ = null;
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
            this.aUg.aTQ = null;
            if (!this.mNetwork.Dm()) {
                this.aUg.hg(this.mNetwork.getErrorString());
            } else if (this.mNetwork.Dn() == 0) {
                this.aUg.hg(this.aUg.mContext.getString(e.j.name_not_use));
            } else if (this.mNetwork.Dn() == 36) {
                this.aUg.hg(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.aUg.r(jVar.GF());
                }
            } else {
                this.aUg.hg(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aUg.hg(null);
            this.aUg.Kt();
            super.onPreExecute();
        }
    }
}
