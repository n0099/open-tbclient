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
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private Drawable aPJ;
    private Drawable aPK;
    private TextView aPL;
    private View aPM;
    private View aPN;
    private View aPO;
    private a.InterfaceC0121a aPQ;
    private Activity mContext;
    private int size;
    private View aPr = null;
    private Dialog aPs = null;
    private EditText aPt = null;
    private RadioGroup aPu = null;
    private RadioGroup aPv = null;
    private CompoundButton.OnCheckedChangeListener aPw = null;
    private RadioButton aPx = null;
    private RadioButton aPy = null;
    private RadioButton aPz = null;
    private TextView aPA = null;
    private b aPB = null;
    private TextView aPC = null;
    private TextView aPD = null;
    private ProgressBar aPE = null;
    private TextView aPF = null;
    private AccountData aPG = null;
    private InterfaceC0131a aPH = null;
    private InterfaceC0131a aPI = null;
    private boolean aPP = false;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0131a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.mContext = null;
        this.aPJ = null;
        this.aPK = null;
        this.size = 0;
        this.mContext = activity;
        this.aPJ = al.getDrawable(e.f.icon_tips_names_s);
        this.aPK = al.getDrawable(e.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds26);
        this.aPJ.setBounds(0, 0, this.size, this.size);
        this.aPK.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0121a interfaceC0121a) {
        this.aPQ = interfaceC0121a;
    }

    public void setAccountData(AccountData accountData) {
        this.aPG = accountData;
    }

    public void a(InterfaceC0131a interfaceC0131a) {
        this.aPH = interfaceC0131a;
    }

    public void b(InterfaceC0131a interfaceC0131a) {
        this.aPI = interfaceC0131a;
    }

    public void Ja() {
        eP(0);
    }

    public void eP(int i) {
        if (this.aPs == null) {
            this.aPr = LayoutInflater.from(this.mContext).inflate(e.h.main_input_username, (ViewGroup) null);
            this.aPL = (TextView) this.aPr.findViewById(e.g.tip_info);
            this.aPM = this.aPr.findViewById(e.g.divider_under_account);
            this.aPN = this.aPr.findViewById(e.g.divider_under_radiongroup);
            this.aPO = this.aPr.findViewById(e.g.divider_with_yes_no_button);
            this.aPt = (EditText) this.aPr.findViewById(e.g.account);
            this.aPt.setHint(this.mContext.getString(e.j.hint_tip_input_name));
            this.aPA = (TextView) this.aPr.findViewById(e.g.back);
            this.aPA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Je();
                    a.this.Jc();
                }
            });
            this.aPD = (TextView) this.aPr.findViewById(e.g.confirm);
            this.aPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Jb();
                }
            });
            this.aPE = (ProgressBar) this.aPr.findViewById(e.g.confirm_progress);
            this.aPC = (TextView) this.aPr.findViewById(e.g.error_info);
            this.aPu = (RadioGroup) this.aPr.findViewById(e.g.names_group1);
            this.aPv = (RadioGroup) this.aPr.findViewById(e.g.names_group2);
            this.aPx = (RadioButton) this.aPr.findViewById(e.g.name1);
            this.aPy = (RadioButton) this.aPr.findViewById(e.g.name2);
            this.aPz = (RadioButton) this.aPr.findViewById(e.g.name3);
            this.aPw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aPx) {
                            a.this.aPv.clearCheck();
                            a.this.aPx.setChecked(true);
                            a.this.aPx.setCompoundDrawables(a.this.aPJ, null, null, null);
                            a.this.aPy.setChecked(false);
                            a.this.aPy.setCompoundDrawables(a.this.aPK, null, null, null);
                            a.this.aPz.setChecked(false);
                            a.this.aPz.setCompoundDrawables(a.this.aPK, null, null, null);
                        } else if (compoundButton == a.this.aPy) {
                            a.this.aPv.clearCheck();
                            a.this.aPx.setChecked(false);
                            a.this.aPx.setCompoundDrawables(a.this.aPK, null, null, null);
                            a.this.aPy.setChecked(true);
                            a.this.aPy.setCompoundDrawables(a.this.aPJ, null, null, null);
                            a.this.aPz.setChecked(false);
                            a.this.aPz.setCompoundDrawables(a.this.aPK, null, null, null);
                        } else if (compoundButton == a.this.aPz) {
                            a.this.aPu.clearCheck();
                            a.this.aPx.setChecked(false);
                            a.this.aPx.setCompoundDrawables(a.this.aPK, null, null, null);
                            a.this.aPy.setChecked(false);
                            a.this.aPy.setCompoundDrawables(a.this.aPK, null, null, null);
                            a.this.aPz.setChecked(true);
                            a.this.aPz.setCompoundDrawables(a.this.aPJ, null, null, null);
                        }
                        a.this.aPt.setText(compoundButton.getText());
                    }
                }
            };
            this.aPx.setOnCheckedChangeListener(this.aPw);
            this.aPy.setOnCheckedChangeListener(this.aPw);
            this.aPz.setOnCheckedChangeListener(this.aPw);
            this.aPF = (TextView) this.aPr.findViewById(e.g.phone_info);
            Jd();
            this.aPs = new Dialog(this.mContext, e.k.input_username_dialog);
            this.aPs.setCanceledOnTouchOutside(false);
            this.aPs.setCancelable(false);
            this.aPs.setCanceledOnTouchOutside(false);
            IX();
        }
        if (i == 1) {
            this.aPF.setText(e.j.tip_init_user_name);
        } else {
            this.aPF.setText(e.j.bar_friend);
        }
        if (!this.aPs.isShowing()) {
            this.aPt.setText((CharSequence) null);
            Jd();
            gN(null);
            if (!this.mContext.isFinishing()) {
                this.aPs.setContentView(this.aPr);
                g.a(this.aPs, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.aPt, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aPt), 150L);
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

    public void Jb() {
        String obj = this.aPt.getText().toString();
        if (obj == null || obj.length() <= 0) {
            gN(this.mContext.getString(e.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            gN(this.mContext.getString(e.j.input_alias_limit_length_tip));
        } else {
            if (this.aPB != null) {
                this.aPB.cancel();
            }
            if (!this.aPP) {
                this.aPE.setVisibility(0);
                this.aPD.setEnabled(false);
                gN(null);
                Jd();
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
                        a.this.Je();
                        l.showToast(a.this.mContext, e.j.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.wx().a(session.username, session.bduss, "", null, a.this.aPQ);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            a.this.gN(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        a.this.aPP = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        a.this.aPE.setVisibility(8);
                        a.this.aPD.setEnabled(true);
                        a.this.aPP = false;
                    }
                }, this.aPG.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jc() {
        if (this.aPI != null) {
            this.aPI.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            gN(this.mContext.getString(e.j.suggest_no_name));
            return;
        }
        gN(this.mContext.getString(e.j.suggest_some_names));
        int size = arrayList.size();
        this.aPu.clearCheck();
        this.aPv.clearCheck();
        this.aPu.setVisibility(0);
        this.aPv.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aPx.setText(arrayList.get(0));
            this.aPx.setChecked(false);
            this.aPx.setCompoundDrawables(this.aPK, null, null, null);
            this.aPx.setVisibility(0);
            this.aPu.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aPy.setText(arrayList.get(1));
            this.aPy.setChecked(false);
            this.aPy.setCompoundDrawables(this.aPK, null, null, null);
            this.aPy.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aPz.setText(arrayList.get(2));
            this.aPz.setChecked(false);
            this.aPz.setCompoundDrawables(this.aPK, null, null, null);
            this.aPz.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aPB != null) {
            this.aPB.cancel();
            this.aPB = null;
        }
        Je();
    }

    public void Jd() {
        this.aPu.setVisibility(8);
        this.aPu.clearCheck();
        this.aPv.setVisibility(8);
        this.aPv.clearCheck();
        this.aPx.setVisibility(8);
        this.aPy.setVisibility(8);
        this.aPz.setVisibility(8);
        this.aPx.setChecked(false);
        this.aPy.setChecked(false);
        this.aPz.setChecked(false);
    }

    public void Je() {
        if (this.aPs != null && this.aPs.isShowing()) {
            g.b(this.aPs, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gN(String str) {
        if (str == null) {
            this.aPC.setVisibility(4);
            this.aPC.setText((CharSequence) null);
            return;
        }
        this.aPC.setVisibility(0);
        this.aPC.setText(str);
    }

    private void IX() {
        al.i(this.aPr, e.f.dialog_background);
        al.h(this.aPF, e.d.cp_cont_b);
        al.h(this.aPL, e.d.cp_cont_f);
        al.h(this.aPt, e.d.cp_cont_b);
        al.i(this.aPM, e.f.bg_search_input);
        al.h(this.aPC, e.d.cp_cont_h);
        al.h(this.aPx, e.d.cp_cont_b);
        al.h(this.aPy, e.d.cp_cont_b);
        al.h(this.aPz, e.d.cp_cont_b);
        al.j(this.aPN, e.d.cp_bg_line_a);
        al.i(this.aPA, e.f.dialog_left_button_selector);
        al.h(this.aPA, e.d.cp_link_tip_a);
        al.j(this.aPO, e.d.cp_bg_line_a);
        al.i(this.aPD, e.f.dialog_right_button_selector);
        al.h(this.aPD, e.d.cp_link_tip_a);
        this.aPt.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.aPx.setCompoundDrawables(this.aPK, null, null, null);
        this.aPy.setCompoundDrawables(this.aPK, null, null, null);
        this.aPz.setCompoundDrawables(this.aPK, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, i> {
        final /* synthetic */ a aPR;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aPR.aPB = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public i doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.x("un", this.mAccount);
            String BA = this.mNetwork.BA();
            if (!this.mNetwork.Cb() || this.mNetwork.Cc() != 36) {
                return null;
            }
            i iVar = new i();
            iVar.parserJson(BA);
            return iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(i iVar) {
            super.onPostExecute(iVar);
            this.aPR.aPB = null;
            if (!this.mNetwork.Cb()) {
                this.aPR.gN(this.mNetwork.getErrorString());
            } else if (this.mNetwork.Cc() == 0) {
                this.aPR.gN(this.aPR.mContext.getString(e.j.name_not_use));
            } else if (this.mNetwork.Cc() == 36) {
                this.aPR.gN(this.mNetwork.getErrorString());
                if (iVar != null) {
                    this.aPR.r(iVar.Fp());
                }
            } else {
                this.aPR.gN(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aPR.gN(null);
            this.aPR.Jd();
            super.onPreExecute();
        }
    }
}
