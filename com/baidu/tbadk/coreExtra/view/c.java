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
    private Drawable cea;
    private Drawable ceb;
    private TextView cec;
    private View ced;
    private View cee;
    private View cef;
    private a.InterfaceC0222a ceh;
    private Activity mContext;
    private int size;
    private View cdI = null;
    private Dialog cdJ = null;
    private EditText cdK = null;
    private RadioGroup cdL = null;
    private RadioGroup cdM = null;
    private CompoundButton.OnCheckedChangeListener cdN = null;
    private RadioButton cdO = null;
    private RadioButton cdP = null;
    private RadioButton cdQ = null;
    private TextView cdR = null;
    private b cdS = null;
    private TextView cdT = null;
    private TextView cdU = null;
    private ProgressBar cdV = null;
    private TextView cdW = null;
    private AccountData cdX = null;
    private a cdY = null;
    private a cdZ = null;
    private boolean ceg = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.cea = null;
        this.ceb = null;
        this.size = 0;
        this.mContext = activity;
        this.cea = al.getDrawable(d.f.icon_tips_names_s);
        this.ceb = al.getDrawable(d.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(d.e.ds26);
        this.cea.setBounds(0, 0, this.size, this.size);
        this.ceb.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0222a interfaceC0222a) {
        this.ceh = interfaceC0222a;
    }

    public void setAccountData(AccountData accountData) {
        this.cdX = accountData;
    }

    public void a(a aVar) {
        this.cdY = aVar;
    }

    public void b(a aVar) {
        this.cdZ = aVar;
    }

    public void aki() {
        ja(0);
    }

    public void ja(int i) {
        if (this.cdJ == null) {
            this.cdI = LayoutInflater.from(this.mContext).inflate(d.h.main_input_username, (ViewGroup) null);
            this.cec = (TextView) this.cdI.findViewById(d.g.tip_info);
            this.ced = this.cdI.findViewById(d.g.divider_under_account);
            this.cee = this.cdI.findViewById(d.g.divider_under_radiongroup);
            this.cef = this.cdI.findViewById(d.g.divider_with_yes_no_button);
            this.cdK = (EditText) this.cdI.findViewById(d.g.account);
            this.cdK.setHint(this.mContext.getString(d.j.hint_tip_input_name));
            this.cdR = (TextView) this.cdI.findViewById(d.g.back);
            this.cdR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.akm();
                    c.this.akk();
                }
            });
            this.cdU = (TextView) this.cdI.findViewById(d.g.confirm);
            this.cdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.akj();
                }
            });
            this.cdV = (ProgressBar) this.cdI.findViewById(d.g.confirm_progress);
            this.cdT = (TextView) this.cdI.findViewById(d.g.error_info);
            this.cdL = (RadioGroup) this.cdI.findViewById(d.g.names_group1);
            this.cdM = (RadioGroup) this.cdI.findViewById(d.g.names_group2);
            this.cdO = (RadioButton) this.cdI.findViewById(d.g.name1);
            this.cdP = (RadioButton) this.cdI.findViewById(d.g.name2);
            this.cdQ = (RadioButton) this.cdI.findViewById(d.g.name3);
            this.cdN = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.cdO) {
                            c.this.cdM.clearCheck();
                            c.this.cdO.setChecked(true);
                            c.this.cdO.setCompoundDrawables(c.this.cea, null, null, null);
                            c.this.cdP.setChecked(false);
                            c.this.cdP.setCompoundDrawables(c.this.ceb, null, null, null);
                            c.this.cdQ.setChecked(false);
                            c.this.cdQ.setCompoundDrawables(c.this.ceb, null, null, null);
                        } else if (compoundButton == c.this.cdP) {
                            c.this.cdM.clearCheck();
                            c.this.cdO.setChecked(false);
                            c.this.cdO.setCompoundDrawables(c.this.ceb, null, null, null);
                            c.this.cdP.setChecked(true);
                            c.this.cdP.setCompoundDrawables(c.this.cea, null, null, null);
                            c.this.cdQ.setChecked(false);
                            c.this.cdQ.setCompoundDrawables(c.this.ceb, null, null, null);
                        } else if (compoundButton == c.this.cdQ) {
                            c.this.cdL.clearCheck();
                            c.this.cdO.setChecked(false);
                            c.this.cdO.setCompoundDrawables(c.this.ceb, null, null, null);
                            c.this.cdP.setChecked(false);
                            c.this.cdP.setCompoundDrawables(c.this.ceb, null, null, null);
                            c.this.cdQ.setChecked(true);
                            c.this.cdQ.setCompoundDrawables(c.this.cea, null, null, null);
                        }
                        c.this.cdK.setText(compoundButton.getText());
                    }
                }
            };
            this.cdO.setOnCheckedChangeListener(this.cdN);
            this.cdP.setOnCheckedChangeListener(this.cdN);
            this.cdQ.setOnCheckedChangeListener(this.cdN);
            this.cdW = (TextView) this.cdI.findViewById(d.g.phone_info);
            akl();
            this.cdJ = new Dialog(this.mContext, d.k.input_username_dialog);
            this.cdJ.setCanceledOnTouchOutside(false);
            this.cdJ.setCancelable(false);
            this.cdJ.setCanceledOnTouchOutside(false);
            aka();
        }
        if (i == 1) {
            this.cdW.setText(d.j.tip_init_user_name);
        } else {
            this.cdW.setText(d.j.bar_friend);
        }
        if (!this.cdJ.isShowing()) {
            this.cdK.setText((CharSequence) null);
            akl();
            oi(null);
            if (!this.mContext.isFinishing()) {
                this.cdJ.setContentView(this.cdI);
                g.a(this.cdJ, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.cdK, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new RunnableC0234c(this.cdK), 150L);
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

    public void akj() {
        String obj = this.cdK.getText().toString();
        if (obj == null || obj.length() <= 0) {
            oi(this.mContext.getString(d.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            oi(this.mContext.getString(d.j.input_alias_limit_length_tip));
        } else {
            if (this.cdS != null) {
                this.cdS.cancel();
            }
            if (!this.ceg && this.cdX != null) {
                this.cdV.setVisibility(0);
                this.cdU.setEnabled(false);
                oi(null);
                akl();
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
                        c.this.akm();
                        l.showToast(c.this.mContext, d.j.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.WD().a(session.username, session.bduss, "", null, c.this.ceh);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.oi(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.ceg = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cdV.setVisibility(8);
                        c.this.cdU.setEnabled(true);
                        c.this.ceg = false;
                    }
                }, this.cdX.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akk() {
        if (this.cdZ != null) {
            this.cdZ.g(null);
        }
    }

    public void t(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            oi(this.mContext.getString(d.j.suggest_no_name));
            return;
        }
        oi(this.mContext.getString(d.j.suggest_some_names));
        int size = arrayList.size();
        this.cdL.clearCheck();
        this.cdM.clearCheck();
        this.cdL.setVisibility(0);
        this.cdM.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.cdO.setText(arrayList.get(0));
            this.cdO.setChecked(false);
            this.cdO.setCompoundDrawables(this.ceb, null, null, null);
            this.cdO.setVisibility(0);
            this.cdL.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.cdP.setText(arrayList.get(1));
            this.cdP.setChecked(false);
            this.cdP.setCompoundDrawables(this.ceb, null, null, null);
            this.cdP.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.cdQ.setText(arrayList.get(2));
            this.cdQ.setChecked(false);
            this.cdQ.setCompoundDrawables(this.ceb, null, null, null);
            this.cdQ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cdS != null) {
            this.cdS.cancel();
            this.cdS = null;
        }
        akm();
    }

    public void akl() {
        this.cdL.setVisibility(8);
        this.cdL.clearCheck();
        this.cdM.setVisibility(8);
        this.cdM.clearCheck();
        this.cdO.setVisibility(8);
        this.cdP.setVisibility(8);
        this.cdQ.setVisibility(8);
        this.cdO.setChecked(false);
        this.cdP.setChecked(false);
        this.cdQ.setChecked(false);
    }

    public void akm() {
        if (this.cdJ != null && this.cdJ.isShowing()) {
            g.b(this.cdJ, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(String str) {
        if (str == null) {
            this.cdT.setVisibility(4);
            this.cdT.setText((CharSequence) null);
            return;
        }
        this.cdT.setVisibility(0);
        this.cdT.setText(str);
    }

    private void aka() {
        al.k(this.cdI, d.f.dialog_background);
        al.j(this.cdW, d.C0277d.cp_cont_b);
        al.j(this.cec, d.C0277d.cp_cont_f);
        al.j(this.cdK, d.C0277d.cp_cont_b);
        al.k(this.ced, d.f.bg_search_input);
        al.j(this.cdT, d.C0277d.cp_cont_h);
        al.j(this.cdO, d.C0277d.cp_cont_b);
        al.j(this.cdP, d.C0277d.cp_cont_b);
        al.j(this.cdQ, d.C0277d.cp_cont_b);
        al.l(this.cee, d.C0277d.cp_bg_line_a);
        al.k(this.cdR, d.f.dialog_left_button_selector);
        al.j(this.cdR, d.C0277d.cp_link_tip_a);
        al.l(this.cef, d.C0277d.cp_bg_line_a);
        al.k(this.cdU, d.f.dialog_right_button_selector);
        al.j(this.cdU, d.C0277d.cp_link_tip_a);
        this.cdK.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.cdO.setCompoundDrawables(this.ceb, null, null, null);
        this.cdP.setCompoundDrawables(this.ceb, null, null, null);
        this.cdQ.setCompoundDrawables(this.ceb, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cei;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cei.cdS = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.x("un", this.mAccount);
            String acj = this.mNetwork.acj();
            if (!this.mNetwork.acK() || this.mNetwork.acL() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(acj);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.cei.cdS = null;
            if (!this.mNetwork.acK()) {
                this.cei.oi(this.mNetwork.getErrorString());
            } else if (this.mNetwork.acL() == 0) {
                this.cei.oi(this.cei.mContext.getString(d.j.name_not_use));
            } else if (this.mNetwork.acL() == 36) {
                this.cei.oi(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cei.t(jVar.agm());
                }
            } else {
                this.cei.oi(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cei.oi(null);
            this.cei.akl();
            super.onPreExecute();
        }
    }
}
