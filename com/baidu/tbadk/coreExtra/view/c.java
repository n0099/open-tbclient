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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private Drawable cec;
    private Drawable ced;
    private TextView cee;
    private View cef;
    private View ceg;
    private View ceh;
    private a.InterfaceC0222a cej;
    private Activity mContext;
    private int size;
    private View cdK = null;
    private Dialog cdL = null;
    private EditText cdM = null;
    private RadioGroup cdN = null;
    private RadioGroup cdO = null;
    private CompoundButton.OnCheckedChangeListener cdP = null;
    private RadioButton cdQ = null;
    private RadioButton cdR = null;
    private RadioButton cdS = null;
    private TextView cdT = null;
    private b cdU = null;
    private TextView cdV = null;
    private TextView cdW = null;
    private ProgressBar cdX = null;
    private TextView cdY = null;
    private AccountData cdZ = null;
    private a cea = null;
    private a ceb = null;
    private boolean cei = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.cec = null;
        this.ced = null;
        this.size = 0;
        this.mContext = activity;
        this.cec = al.getDrawable(d.f.icon_tips_names_s);
        this.ced = al.getDrawable(d.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(d.e.ds26);
        this.cec.setBounds(0, 0, this.size, this.size);
        this.ced.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0222a interfaceC0222a) {
        this.cej = interfaceC0222a;
    }

    public void setAccountData(AccountData accountData) {
        this.cdZ = accountData;
    }

    public void a(a aVar) {
        this.cea = aVar;
    }

    public void b(a aVar) {
        this.ceb = aVar;
    }

    public void akf() {
        iZ(0);
    }

    public void iZ(int i) {
        if (this.cdL == null) {
            this.cdK = LayoutInflater.from(this.mContext).inflate(d.h.main_input_username, (ViewGroup) null);
            this.cee = (TextView) this.cdK.findViewById(d.g.tip_info);
            this.cef = this.cdK.findViewById(d.g.divider_under_account);
            this.ceg = this.cdK.findViewById(d.g.divider_under_radiongroup);
            this.ceh = this.cdK.findViewById(d.g.divider_with_yes_no_button);
            this.cdM = (EditText) this.cdK.findViewById(d.g.account);
            this.cdM.setHint(this.mContext.getString(d.j.hint_tip_input_name));
            this.cdT = (TextView) this.cdK.findViewById(d.g.back);
            this.cdT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.akj();
                    c.this.akh();
                }
            });
            this.cdW = (TextView) this.cdK.findViewById(d.g.confirm);
            this.cdW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.akg();
                }
            });
            this.cdX = (ProgressBar) this.cdK.findViewById(d.g.confirm_progress);
            this.cdV = (TextView) this.cdK.findViewById(d.g.error_info);
            this.cdN = (RadioGroup) this.cdK.findViewById(d.g.names_group1);
            this.cdO = (RadioGroup) this.cdK.findViewById(d.g.names_group2);
            this.cdQ = (RadioButton) this.cdK.findViewById(d.g.name1);
            this.cdR = (RadioButton) this.cdK.findViewById(d.g.name2);
            this.cdS = (RadioButton) this.cdK.findViewById(d.g.name3);
            this.cdP = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.cdQ) {
                            c.this.cdO.clearCheck();
                            c.this.cdQ.setChecked(true);
                            c.this.cdQ.setCompoundDrawables(c.this.cec, null, null, null);
                            c.this.cdR.setChecked(false);
                            c.this.cdR.setCompoundDrawables(c.this.ced, null, null, null);
                            c.this.cdS.setChecked(false);
                            c.this.cdS.setCompoundDrawables(c.this.ced, null, null, null);
                        } else if (compoundButton == c.this.cdR) {
                            c.this.cdO.clearCheck();
                            c.this.cdQ.setChecked(false);
                            c.this.cdQ.setCompoundDrawables(c.this.ced, null, null, null);
                            c.this.cdR.setChecked(true);
                            c.this.cdR.setCompoundDrawables(c.this.cec, null, null, null);
                            c.this.cdS.setChecked(false);
                            c.this.cdS.setCompoundDrawables(c.this.ced, null, null, null);
                        } else if (compoundButton == c.this.cdS) {
                            c.this.cdN.clearCheck();
                            c.this.cdQ.setChecked(false);
                            c.this.cdQ.setCompoundDrawables(c.this.ced, null, null, null);
                            c.this.cdR.setChecked(false);
                            c.this.cdR.setCompoundDrawables(c.this.ced, null, null, null);
                            c.this.cdS.setChecked(true);
                            c.this.cdS.setCompoundDrawables(c.this.cec, null, null, null);
                        }
                        c.this.cdM.setText(compoundButton.getText());
                    }
                }
            };
            this.cdQ.setOnCheckedChangeListener(this.cdP);
            this.cdR.setOnCheckedChangeListener(this.cdP);
            this.cdS.setOnCheckedChangeListener(this.cdP);
            this.cdY = (TextView) this.cdK.findViewById(d.g.phone_info);
            aki();
            this.cdL = new Dialog(this.mContext, d.k.input_username_dialog);
            this.cdL.setCanceledOnTouchOutside(false);
            this.cdL.setCancelable(false);
            this.cdL.setCanceledOnTouchOutside(false);
            ajX();
        }
        if (i == 1) {
            this.cdY.setText(d.j.tip_init_user_name);
        } else {
            this.cdY.setText(d.j.bar_friend);
        }
        if (!this.cdL.isShowing()) {
            this.cdM.setText((CharSequence) null);
            aki();
            oj(null);
            if (!this.mContext.isFinishing()) {
                this.cdL.setContentView(this.cdK);
                g.a(this.cdL, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.cdM, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new RunnableC0234c(this.cdM), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0234c implements Runnable {
        private View mView;

        public RunnableC0234c(View view) {
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

    public void akg() {
        String obj = this.cdM.getText().toString();
        if (obj == null || obj.length() <= 0) {
            oj(this.mContext.getString(d.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            oj(this.mContext.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.cdU != null) {
                this.cdU.cancel();
            }
            if (!this.cei && this.cdZ != null) {
                this.cdX.setVisibility(0);
                this.cdW.setEnabled(false);
                oj(null);
                aki();
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
                        c.this.akj();
                        l.showToast(c.this.mContext, d.j.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.WA().a(session.username, session.bduss, "", null, c.this.cej);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.oj(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.cei = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cdX.setVisibility(8);
                        c.this.cdW.setEnabled(true);
                        c.this.cei = false;
                    }
                }, this.cdZ.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akh() {
        if (this.ceb != null) {
            this.ceb.g(null);
        }
    }

    public void t(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            oj(this.mContext.getString(d.j.suggest_no_name));
            return;
        }
        oj(this.mContext.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.cdN.clearCheck();
        this.cdO.clearCheck();
        this.cdN.setVisibility(0);
        this.cdO.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.cdQ.setText(arrayList.get(0));
            this.cdQ.setChecked(false);
            this.cdQ.setCompoundDrawables(this.ced, null, null, null);
            this.cdQ.setVisibility(0);
            this.cdN.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.cdR.setText(arrayList.get(1));
            this.cdR.setChecked(false);
            this.cdR.setCompoundDrawables(this.ced, null, null, null);
            this.cdR.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.cdS.setText(arrayList.get(2));
            this.cdS.setChecked(false);
            this.cdS.setCompoundDrawables(this.ced, null, null, null);
            this.cdS.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cdU != null) {
            this.cdU.cancel();
            this.cdU = null;
        }
        akj();
    }

    public void aki() {
        this.cdN.setVisibility(8);
        this.cdN.clearCheck();
        this.cdO.setVisibility(8);
        this.cdO.clearCheck();
        this.cdQ.setVisibility(8);
        this.cdR.setVisibility(8);
        this.cdS.setVisibility(8);
        this.cdQ.setChecked(false);
        this.cdR.setChecked(false);
        this.cdS.setChecked(false);
    }

    public void akj() {
        if (this.cdL != null && this.cdL.isShowing()) {
            g.b(this.cdL, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(String str) {
        if (str == null) {
            this.cdV.setVisibility(4);
            this.cdV.setText((CharSequence) null);
            return;
        }
        this.cdV.setVisibility(0);
        this.cdV.setText(str);
    }

    private void ajX() {
        al.k(this.cdK, d.f.dialog_background);
        al.j(this.cdY, d.C0277d.cp_cont_b);
        al.j(this.cee, d.C0277d.cp_cont_f);
        al.j(this.cdM, d.C0277d.cp_cont_b);
        al.k(this.cef, d.f.bg_search_input);
        al.j(this.cdV, d.C0277d.cp_cont_h);
        al.j(this.cdQ, d.C0277d.cp_cont_b);
        al.j(this.cdR, d.C0277d.cp_cont_b);
        al.j(this.cdS, d.C0277d.cp_cont_b);
        al.l(this.ceg, d.C0277d.cp_bg_line_a);
        al.k(this.cdT, d.f.dialog_left_button_selector);
        al.j(this.cdT, d.C0277d.cp_link_tip_a);
        al.l(this.ceh, d.C0277d.cp_bg_line_a);
        al.k(this.cdW, d.f.dialog_right_button_selector);
        al.j(this.cdW, d.C0277d.cp_link_tip_a);
        this.cdM.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.cdQ.setCompoundDrawables(this.ced, null, null, null);
        this.cdR.setCompoundDrawables(this.ced, null, null, null);
        this.cdS.setCompoundDrawables(this.ced, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cek;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cek.cdU = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.x("un", this.mAccount);
            String acg = this.mNetwork.acg();
            if (!this.mNetwork.acH() || this.mNetwork.acI() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(acg);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.cek.cdU = null;
            if (!this.mNetwork.acH()) {
                this.cek.oj(this.mNetwork.getErrorString());
            } else if (this.mNetwork.acI() == 0) {
                this.cek.oj(this.cek.mContext.getString(d.j.name_not_use));
            } else if (this.mNetwork.acI() == 36) {
                this.cek.oj(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cek.t(jVar.agj());
                }
            } else {
                this.cek.oj(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cek.oj(null);
            this.cek.aki();
            super.onPreExecute();
        }
    }
}
