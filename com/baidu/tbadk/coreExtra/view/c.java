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
    private Drawable ced;
    private Drawable cee;
    private TextView cef;
    private View ceg;
    private View ceh;
    private View cei;
    private a.InterfaceC0222a cek;
    private Activity mContext;
    private int size;
    private View cdL = null;
    private Dialog cdM = null;
    private EditText cdN = null;
    private RadioGroup cdO = null;
    private RadioGroup cdP = null;
    private CompoundButton.OnCheckedChangeListener cdQ = null;
    private RadioButton cdR = null;
    private RadioButton cdS = null;
    private RadioButton cdT = null;
    private TextView cdU = null;
    private b cdV = null;
    private TextView cdW = null;
    private TextView cdX = null;
    private ProgressBar cdY = null;
    private TextView cdZ = null;
    private AccountData cea = null;
    private a ceb = null;
    private a cec = null;
    private boolean cej = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.ced = null;
        this.cee = null;
        this.size = 0;
        this.mContext = activity;
        this.ced = al.getDrawable(d.f.icon_tips_names_s);
        this.cee = al.getDrawable(d.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(d.e.ds26);
        this.ced.setBounds(0, 0, this.size, this.size);
        this.cee.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0222a interfaceC0222a) {
        this.cek = interfaceC0222a;
    }

    public void setAccountData(AccountData accountData) {
        this.cea = accountData;
    }

    public void a(a aVar) {
        this.ceb = aVar;
    }

    public void b(a aVar) {
        this.cec = aVar;
    }

    public void akf() {
        iZ(0);
    }

    public void iZ(int i) {
        if (this.cdM == null) {
            this.cdL = LayoutInflater.from(this.mContext).inflate(d.h.main_input_username, (ViewGroup) null);
            this.cef = (TextView) this.cdL.findViewById(d.g.tip_info);
            this.ceg = this.cdL.findViewById(d.g.divider_under_account);
            this.ceh = this.cdL.findViewById(d.g.divider_under_radiongroup);
            this.cei = this.cdL.findViewById(d.g.divider_with_yes_no_button);
            this.cdN = (EditText) this.cdL.findViewById(d.g.account);
            this.cdN.setHint(this.mContext.getString(d.j.hint_tip_input_name));
            this.cdU = (TextView) this.cdL.findViewById(d.g.back);
            this.cdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.akj();
                    c.this.akh();
                }
            });
            this.cdX = (TextView) this.cdL.findViewById(d.g.confirm);
            this.cdX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.akg();
                }
            });
            this.cdY = (ProgressBar) this.cdL.findViewById(d.g.confirm_progress);
            this.cdW = (TextView) this.cdL.findViewById(d.g.error_info);
            this.cdO = (RadioGroup) this.cdL.findViewById(d.g.names_group1);
            this.cdP = (RadioGroup) this.cdL.findViewById(d.g.names_group2);
            this.cdR = (RadioButton) this.cdL.findViewById(d.g.name1);
            this.cdS = (RadioButton) this.cdL.findViewById(d.g.name2);
            this.cdT = (RadioButton) this.cdL.findViewById(d.g.name3);
            this.cdQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.cdR) {
                            c.this.cdP.clearCheck();
                            c.this.cdR.setChecked(true);
                            c.this.cdR.setCompoundDrawables(c.this.ced, null, null, null);
                            c.this.cdS.setChecked(false);
                            c.this.cdS.setCompoundDrawables(c.this.cee, null, null, null);
                            c.this.cdT.setChecked(false);
                            c.this.cdT.setCompoundDrawables(c.this.cee, null, null, null);
                        } else if (compoundButton == c.this.cdS) {
                            c.this.cdP.clearCheck();
                            c.this.cdR.setChecked(false);
                            c.this.cdR.setCompoundDrawables(c.this.cee, null, null, null);
                            c.this.cdS.setChecked(true);
                            c.this.cdS.setCompoundDrawables(c.this.ced, null, null, null);
                            c.this.cdT.setChecked(false);
                            c.this.cdT.setCompoundDrawables(c.this.cee, null, null, null);
                        } else if (compoundButton == c.this.cdT) {
                            c.this.cdO.clearCheck();
                            c.this.cdR.setChecked(false);
                            c.this.cdR.setCompoundDrawables(c.this.cee, null, null, null);
                            c.this.cdS.setChecked(false);
                            c.this.cdS.setCompoundDrawables(c.this.cee, null, null, null);
                            c.this.cdT.setChecked(true);
                            c.this.cdT.setCompoundDrawables(c.this.ced, null, null, null);
                        }
                        c.this.cdN.setText(compoundButton.getText());
                    }
                }
            };
            this.cdR.setOnCheckedChangeListener(this.cdQ);
            this.cdS.setOnCheckedChangeListener(this.cdQ);
            this.cdT.setOnCheckedChangeListener(this.cdQ);
            this.cdZ = (TextView) this.cdL.findViewById(d.g.phone_info);
            aki();
            this.cdM = new Dialog(this.mContext, d.k.input_username_dialog);
            this.cdM.setCanceledOnTouchOutside(false);
            this.cdM.setCancelable(false);
            this.cdM.setCanceledOnTouchOutside(false);
            ajX();
        }
        if (i == 1) {
            this.cdZ.setText(d.j.tip_init_user_name);
        } else {
            this.cdZ.setText(d.j.bar_friend);
        }
        if (!this.cdM.isShowing()) {
            this.cdN.setText((CharSequence) null);
            aki();
            oj(null);
            if (!this.mContext.isFinishing()) {
                this.cdM.setContentView(this.cdL);
                g.a(this.cdM, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.cdN, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new RunnableC0234c(this.cdN), 150L);
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
        String obj = this.cdN.getText().toString();
        if (obj == null || obj.length() <= 0) {
            oj(this.mContext.getString(d.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            oj(this.mContext.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.cdV != null) {
                this.cdV.cancel();
            }
            if (!this.cej && this.cea != null) {
                this.cdY.setVisibility(0);
                this.cdX.setEnabled(false);
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
                        com.baidu.tbadk.core.a.a.WA().a(session.username, session.bduss, "", null, c.this.cek);
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
                        c.this.cej = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cdY.setVisibility(8);
                        c.this.cdX.setEnabled(true);
                        c.this.cej = false;
                    }
                }, this.cea.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akh() {
        if (this.cec != null) {
            this.cec.g(null);
        }
    }

    public void t(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            oj(this.mContext.getString(d.j.suggest_no_name));
            return;
        }
        oj(this.mContext.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.cdO.clearCheck();
        this.cdP.clearCheck();
        this.cdO.setVisibility(0);
        this.cdP.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.cdR.setText(arrayList.get(0));
            this.cdR.setChecked(false);
            this.cdR.setCompoundDrawables(this.cee, null, null, null);
            this.cdR.setVisibility(0);
            this.cdO.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.cdS.setText(arrayList.get(1));
            this.cdS.setChecked(false);
            this.cdS.setCompoundDrawables(this.cee, null, null, null);
            this.cdS.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.cdT.setText(arrayList.get(2));
            this.cdT.setChecked(false);
            this.cdT.setCompoundDrawables(this.cee, null, null, null);
            this.cdT.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cdV != null) {
            this.cdV.cancel();
            this.cdV = null;
        }
        akj();
    }

    public void aki() {
        this.cdO.setVisibility(8);
        this.cdO.clearCheck();
        this.cdP.setVisibility(8);
        this.cdP.clearCheck();
        this.cdR.setVisibility(8);
        this.cdS.setVisibility(8);
        this.cdT.setVisibility(8);
        this.cdR.setChecked(false);
        this.cdS.setChecked(false);
        this.cdT.setChecked(false);
    }

    public void akj() {
        if (this.cdM != null && this.cdM.isShowing()) {
            g.b(this.cdM, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(String str) {
        if (str == null) {
            this.cdW.setVisibility(4);
            this.cdW.setText((CharSequence) null);
            return;
        }
        this.cdW.setVisibility(0);
        this.cdW.setText(str);
    }

    private void ajX() {
        al.k(this.cdL, d.f.dialog_background);
        al.j(this.cdZ, d.C0277d.cp_cont_b);
        al.j(this.cef, d.C0277d.cp_cont_f);
        al.j(this.cdN, d.C0277d.cp_cont_b);
        al.k(this.ceg, d.f.bg_search_input);
        al.j(this.cdW, d.C0277d.cp_cont_h);
        al.j(this.cdR, d.C0277d.cp_cont_b);
        al.j(this.cdS, d.C0277d.cp_cont_b);
        al.j(this.cdT, d.C0277d.cp_cont_b);
        al.l(this.ceh, d.C0277d.cp_bg_line_a);
        al.k(this.cdU, d.f.dialog_left_button_selector);
        al.j(this.cdU, d.C0277d.cp_link_tip_a);
        al.l(this.cei, d.C0277d.cp_bg_line_a);
        al.k(this.cdX, d.f.dialog_right_button_selector);
        al.j(this.cdX, d.C0277d.cp_link_tip_a);
        this.cdN.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.cdR.setCompoundDrawables(this.cee, null, null, null);
        this.cdS.setCompoundDrawables(this.cee, null, null, null);
        this.cdT.setCompoundDrawables(this.cee, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cel;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cel.cdV = null;
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
            this.cel.cdV = null;
            if (!this.mNetwork.acH()) {
                this.cel.oj(this.mNetwork.getErrorString());
            } else if (this.mNetwork.acI() == 0) {
                this.cel.oj(this.cel.mContext.getString(d.j.name_not_use));
            } else if (this.mNetwork.acI() == 36) {
                this.cel.oj(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cel.t(jVar.agj());
                }
            } else {
                this.cel.oj(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cel.oj(null);
            this.cel.aki();
            super.onPreExecute();
        }
    }
}
