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
    private Drawable aQA;
    private TextView aQB;
    private View aQC;
    private View aQD;
    private View aQE;
    private a.InterfaceC0145a aQG;
    private Drawable aQz;
    private Activity mContext;
    private int size;
    private View aQh = null;
    private Dialog aQi = null;
    private EditText aQj = null;
    private RadioGroup aQk = null;
    private RadioGroup aQl = null;
    private CompoundButton.OnCheckedChangeListener aQm = null;
    private RadioButton aQn = null;
    private RadioButton aQo = null;
    private RadioButton aQp = null;
    private TextView aQq = null;
    private b aQr = null;
    private TextView aQs = null;
    private TextView aQt = null;
    private ProgressBar aQu = null;
    private TextView aQv = null;
    private AccountData aQw = null;
    private InterfaceC0155a aQx = null;
    private InterfaceC0155a aQy = null;
    private boolean aQF = false;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0155a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.mContext = null;
        this.aQz = null;
        this.aQA = null;
        this.size = 0;
        this.mContext = activity;
        this.aQz = al.getDrawable(e.f.icon_tips_names_s);
        this.aQA = al.getDrawable(e.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds26);
        this.aQz.setBounds(0, 0, this.size, this.size);
        this.aQA.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0145a interfaceC0145a) {
        this.aQG = interfaceC0145a;
    }

    public void setAccountData(AccountData accountData) {
        this.aQw = accountData;
    }

    public void a(InterfaceC0155a interfaceC0155a) {
        this.aQx = interfaceC0155a;
    }

    public void b(InterfaceC0155a interfaceC0155a) {
        this.aQy = interfaceC0155a;
    }

    public void Jm() {
        fd(0);
    }

    public void fd(int i) {
        if (this.aQi == null) {
            this.aQh = LayoutInflater.from(this.mContext).inflate(e.h.main_input_username, (ViewGroup) null);
            this.aQB = (TextView) this.aQh.findViewById(e.g.tip_info);
            this.aQC = this.aQh.findViewById(e.g.divider_under_account);
            this.aQD = this.aQh.findViewById(e.g.divider_under_radiongroup);
            this.aQE = this.aQh.findViewById(e.g.divider_with_yes_no_button);
            this.aQj = (EditText) this.aQh.findViewById(e.g.account);
            this.aQj.setHint(this.mContext.getString(e.j.hint_tip_input_name));
            this.aQq = (TextView) this.aQh.findViewById(e.g.back);
            this.aQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Jq();
                    a.this.Jo();
                }
            });
            this.aQt = (TextView) this.aQh.findViewById(e.g.confirm);
            this.aQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Jn();
                }
            });
            this.aQu = (ProgressBar) this.aQh.findViewById(e.g.confirm_progress);
            this.aQs = (TextView) this.aQh.findViewById(e.g.error_info);
            this.aQk = (RadioGroup) this.aQh.findViewById(e.g.names_group1);
            this.aQl = (RadioGroup) this.aQh.findViewById(e.g.names_group2);
            this.aQn = (RadioButton) this.aQh.findViewById(e.g.name1);
            this.aQo = (RadioButton) this.aQh.findViewById(e.g.name2);
            this.aQp = (RadioButton) this.aQh.findViewById(e.g.name3);
            this.aQm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aQn) {
                            a.this.aQl.clearCheck();
                            a.this.aQn.setChecked(true);
                            a.this.aQn.setCompoundDrawables(a.this.aQz, null, null, null);
                            a.this.aQo.setChecked(false);
                            a.this.aQo.setCompoundDrawables(a.this.aQA, null, null, null);
                            a.this.aQp.setChecked(false);
                            a.this.aQp.setCompoundDrawables(a.this.aQA, null, null, null);
                        } else if (compoundButton == a.this.aQo) {
                            a.this.aQl.clearCheck();
                            a.this.aQn.setChecked(false);
                            a.this.aQn.setCompoundDrawables(a.this.aQA, null, null, null);
                            a.this.aQo.setChecked(true);
                            a.this.aQo.setCompoundDrawables(a.this.aQz, null, null, null);
                            a.this.aQp.setChecked(false);
                            a.this.aQp.setCompoundDrawables(a.this.aQA, null, null, null);
                        } else if (compoundButton == a.this.aQp) {
                            a.this.aQk.clearCheck();
                            a.this.aQn.setChecked(false);
                            a.this.aQn.setCompoundDrawables(a.this.aQA, null, null, null);
                            a.this.aQo.setChecked(false);
                            a.this.aQo.setCompoundDrawables(a.this.aQA, null, null, null);
                            a.this.aQp.setChecked(true);
                            a.this.aQp.setCompoundDrawables(a.this.aQz, null, null, null);
                        }
                        a.this.aQj.setText(compoundButton.getText());
                    }
                }
            };
            this.aQn.setOnCheckedChangeListener(this.aQm);
            this.aQo.setOnCheckedChangeListener(this.aQm);
            this.aQp.setOnCheckedChangeListener(this.aQm);
            this.aQv = (TextView) this.aQh.findViewById(e.g.phone_info);
            Jp();
            this.aQi = new Dialog(this.mContext, e.k.input_username_dialog);
            this.aQi.setCanceledOnTouchOutside(false);
            this.aQi.setCancelable(false);
            this.aQi.setCanceledOnTouchOutside(false);
            Jj();
        }
        if (i == 1) {
            this.aQv.setText(e.j.tip_init_user_name);
        } else {
            this.aQv.setText(e.j.bar_friend);
        }
        if (!this.aQi.isShowing()) {
            this.aQj.setText((CharSequence) null);
            Jp();
            gO(null);
            if (!this.mContext.isFinishing()) {
                this.aQi.setContentView(this.aQh);
                g.a(this.aQi, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.aQj, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aQj), 150L);
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

    public void Jn() {
        String obj = this.aQj.getText().toString();
        if (obj == null || obj.length() <= 0) {
            gO(this.mContext.getString(e.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            gO(this.mContext.getString(e.j.input_alias_limit_length_tip));
        } else {
            if (this.aQr != null) {
                this.aQr.cancel();
            }
            if (!this.aQF) {
                this.aQu.setVisibility(0);
                this.aQt.setEnabled(false);
                gO(null);
                Jp();
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
                        a.this.Jq();
                        l.showToast(a.this.mContext, e.j.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.wF().a(session.username, session.bduss, "", null, a.this.aQG);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            a.this.gO(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        a.this.aQF = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        a.this.aQu.setVisibility(8);
                        a.this.aQt.setEnabled(true);
                        a.this.aQF = false;
                    }
                }, this.aQw.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jo() {
        if (this.aQy != null) {
            this.aQy.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            gO(this.mContext.getString(e.j.suggest_no_name));
            return;
        }
        gO(this.mContext.getString(e.j.suggest_some_names));
        int size = arrayList.size();
        this.aQk.clearCheck();
        this.aQl.clearCheck();
        this.aQk.setVisibility(0);
        this.aQl.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aQn.setText(arrayList.get(0));
            this.aQn.setChecked(false);
            this.aQn.setCompoundDrawables(this.aQA, null, null, null);
            this.aQn.setVisibility(0);
            this.aQk.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aQo.setText(arrayList.get(1));
            this.aQo.setChecked(false);
            this.aQo.setCompoundDrawables(this.aQA, null, null, null);
            this.aQo.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aQp.setText(arrayList.get(2));
            this.aQp.setChecked(false);
            this.aQp.setCompoundDrawables(this.aQA, null, null, null);
            this.aQp.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aQr != null) {
            this.aQr.cancel();
            this.aQr = null;
        }
        Jq();
    }

    public void Jp() {
        this.aQk.setVisibility(8);
        this.aQk.clearCheck();
        this.aQl.setVisibility(8);
        this.aQl.clearCheck();
        this.aQn.setVisibility(8);
        this.aQo.setVisibility(8);
        this.aQp.setVisibility(8);
        this.aQn.setChecked(false);
        this.aQo.setChecked(false);
        this.aQp.setChecked(false);
    }

    public void Jq() {
        if (this.aQi != null && this.aQi.isShowing()) {
            g.b(this.aQi, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(String str) {
        if (str == null) {
            this.aQs.setVisibility(4);
            this.aQs.setText((CharSequence) null);
            return;
        }
        this.aQs.setVisibility(0);
        this.aQs.setText(str);
    }

    private void Jj() {
        al.i(this.aQh, e.f.dialog_background);
        al.h(this.aQv, e.d.cp_cont_b);
        al.h(this.aQB, e.d.cp_cont_f);
        al.h(this.aQj, e.d.cp_cont_b);
        al.i(this.aQC, e.f.bg_search_input);
        al.h(this.aQs, e.d.cp_cont_h);
        al.h(this.aQn, e.d.cp_cont_b);
        al.h(this.aQo, e.d.cp_cont_b);
        al.h(this.aQp, e.d.cp_cont_b);
        al.j(this.aQD, e.d.cp_bg_line_a);
        al.i(this.aQq, e.f.dialog_left_button_selector);
        al.h(this.aQq, e.d.cp_link_tip_a);
        al.j(this.aQE, e.d.cp_bg_line_a);
        al.i(this.aQt, e.f.dialog_right_button_selector);
        al.h(this.aQt, e.d.cp_link_tip_a);
        this.aQj.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.aQn.setCompoundDrawables(this.aQA, null, null, null);
        this.aQo.setCompoundDrawables(this.aQA, null, null, null);
        this.aQp.setCompoundDrawables(this.aQA, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ a aQH;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aQH.aQr = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.x("un", this.mAccount);
            String BH = this.mNetwork.BH();
            if (!this.mNetwork.Ci() || this.mNetwork.Cj() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(BH);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.aQH.aQr = null;
            if (!this.mNetwork.Ci()) {
                this.aQH.gO(this.mNetwork.getErrorString());
            } else if (this.mNetwork.Cj() == 0) {
                this.aQH.gO(this.aQH.mContext.getString(e.j.name_not_use));
            } else if (this.mNetwork.Cj() == 36) {
                this.aQH.gO(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.aQH.r(jVar.FB());
                }
            } else {
                this.aQH.gO(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aQH.gO(null);
            this.aQH.Jp();
            super.onPreExecute();
        }
    }
}
