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
    private Drawable aLh;
    private Drawable aLi;
    private TextView aLj;
    private View aLk;
    private View aLl;
    private View aLm;
    private a.InterfaceC0097a aLo;
    private Activity mContext;
    private int size;
    private View aKP = null;
    private Dialog aKQ = null;
    private EditText aKR = null;
    private RadioGroup aKS = null;
    private RadioGroup aKT = null;
    private CompoundButton.OnCheckedChangeListener aKU = null;
    private RadioButton aKV = null;
    private RadioButton aKW = null;
    private RadioButton aKX = null;
    private TextView aKY = null;
    private b aKZ = null;
    private TextView aLa = null;
    private TextView aLb = null;
    private ProgressBar aLc = null;
    private TextView aLd = null;
    private AccountData aLe = null;
    private InterfaceC0107a aLf = null;
    private InterfaceC0107a aLg = null;
    private boolean aLn = false;

    /* renamed from: com.baidu.tbadk.coreExtra.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0107a {
        void g(AccountData accountData);
    }

    public a(Activity activity) {
        this.mContext = null;
        this.aLh = null;
        this.aLi = null;
        this.size = 0;
        this.mContext = activity;
        this.aLh = al.getDrawable(e.f.icon_tips_names_s);
        this.aLi = al.getDrawable(e.f.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds26);
        this.aLh.setBounds(0, 0, this.size, this.size);
        this.aLi.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0097a interfaceC0097a) {
        this.aLo = interfaceC0097a;
    }

    public void setAccountData(AccountData accountData) {
        this.aLe = accountData;
    }

    public void a(InterfaceC0107a interfaceC0107a) {
        this.aLf = interfaceC0107a;
    }

    public void b(InterfaceC0107a interfaceC0107a) {
        this.aLg = interfaceC0107a;
    }

    public void GZ() {
        eG(0);
    }

    public void eG(int i) {
        if (this.aKQ == null) {
            this.aKP = LayoutInflater.from(this.mContext).inflate(e.h.main_input_username, (ViewGroup) null);
            this.aLj = (TextView) this.aKP.findViewById(e.g.tip_info);
            this.aLk = this.aKP.findViewById(e.g.divider_under_account);
            this.aLl = this.aKP.findViewById(e.g.divider_under_radiongroup);
            this.aLm = this.aKP.findViewById(e.g.divider_with_yes_no_button);
            this.aKR = (EditText) this.aKP.findViewById(e.g.account);
            this.aKR.setHint(this.mContext.getString(e.j.hint_tip_input_name));
            this.aKY = (TextView) this.aKP.findViewById(e.g.back);
            this.aKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Hd();
                    a.this.Hb();
                }
            });
            this.aLb = (TextView) this.aKP.findViewById(e.g.confirm);
            this.aLb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.Ha();
                }
            });
            this.aLc = (ProgressBar) this.aKP.findViewById(e.g.confirm_progress);
            this.aLa = (TextView) this.aKP.findViewById(e.g.error_info);
            this.aKS = (RadioGroup) this.aKP.findViewById(e.g.names_group1);
            this.aKT = (RadioGroup) this.aKP.findViewById(e.g.names_group2);
            this.aKV = (RadioButton) this.aKP.findViewById(e.g.name1);
            this.aKW = (RadioButton) this.aKP.findViewById(e.g.name2);
            this.aKX = (RadioButton) this.aKP.findViewById(e.g.name3);
            this.aKU = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.a.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == a.this.aKV) {
                            a.this.aKT.clearCheck();
                            a.this.aKV.setChecked(true);
                            a.this.aKV.setCompoundDrawables(a.this.aLh, null, null, null);
                            a.this.aKW.setChecked(false);
                            a.this.aKW.setCompoundDrawables(a.this.aLi, null, null, null);
                            a.this.aKX.setChecked(false);
                            a.this.aKX.setCompoundDrawables(a.this.aLi, null, null, null);
                        } else if (compoundButton == a.this.aKW) {
                            a.this.aKT.clearCheck();
                            a.this.aKV.setChecked(false);
                            a.this.aKV.setCompoundDrawables(a.this.aLi, null, null, null);
                            a.this.aKW.setChecked(true);
                            a.this.aKW.setCompoundDrawables(a.this.aLh, null, null, null);
                            a.this.aKX.setChecked(false);
                            a.this.aKX.setCompoundDrawables(a.this.aLi, null, null, null);
                        } else if (compoundButton == a.this.aKX) {
                            a.this.aKS.clearCheck();
                            a.this.aKV.setChecked(false);
                            a.this.aKV.setCompoundDrawables(a.this.aLi, null, null, null);
                            a.this.aKW.setChecked(false);
                            a.this.aKW.setCompoundDrawables(a.this.aLi, null, null, null);
                            a.this.aKX.setChecked(true);
                            a.this.aKX.setCompoundDrawables(a.this.aLh, null, null, null);
                        }
                        a.this.aKR.setText(compoundButton.getText());
                    }
                }
            };
            this.aKV.setOnCheckedChangeListener(this.aKU);
            this.aKW.setOnCheckedChangeListener(this.aKU);
            this.aKX.setOnCheckedChangeListener(this.aKU);
            this.aLd = (TextView) this.aKP.findViewById(e.g.phone_info);
            Hc();
            this.aKQ = new Dialog(this.mContext, e.k.input_username_dialog);
            this.aKQ.setCanceledOnTouchOutside(false);
            this.aKQ.setCancelable(false);
            this.aKQ.setCanceledOnTouchOutside(false);
            GW();
        }
        if (i == 1) {
            this.aLd.setText(e.j.tip_init_user_name);
        } else {
            this.aLd.setText(e.j.bar_friend);
        }
        if (!this.aKQ.isShowing()) {
            this.aKR.setText((CharSequence) null);
            Hc();
            gz(null);
            if (!this.mContext.isFinishing()) {
                this.aKQ.setContentView(this.aKP);
                g.a(this.aKQ, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.aKR, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new c(this.aKR), 150L);
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

    public void Ha() {
        String obj = this.aKR.getText().toString();
        if (obj == null || obj.length() <= 0) {
            gz(this.mContext.getString(e.j.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            gz(this.mContext.getString(e.j.input_alias_limit_length_tip));
        } else {
            if (this.aKZ != null) {
                this.aKZ.cancel();
            }
            if (!this.aLn) {
                this.aLc.setVisibility(0);
                this.aLb.setEnabled(false);
                gz(null);
                Hc();
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
                        a.this.Hd();
                        l.showToast(a.this.mContext, e.j.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.uo().a(session.username, session.bduss, "", null, a.this.aLo);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            a.this.gz(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        a.this.aLn = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        a.this.aLc.setVisibility(8);
                        a.this.aLb.setEnabled(true);
                        a.this.aLn = false;
                    }
                }, this.aLe.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hb() {
        if (this.aLg != null) {
            this.aLg.g(null);
        }
    }

    public void r(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            gz(this.mContext.getString(e.j.suggest_no_name));
            return;
        }
        gz(this.mContext.getString(e.j.suggest_some_names));
        int size = arrayList.size();
        this.aKS.clearCheck();
        this.aKT.clearCheck();
        this.aKS.setVisibility(0);
        this.aKT.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.aKV.setText(arrayList.get(0));
            this.aKV.setChecked(false);
            this.aKV.setCompoundDrawables(this.aLi, null, null, null);
            this.aKV.setVisibility(0);
            this.aKS.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.aKW.setText(arrayList.get(1));
            this.aKW.setChecked(false);
            this.aKW.setCompoundDrawables(this.aLi, null, null, null);
            this.aKW.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.aKX.setText(arrayList.get(2));
            this.aKX.setChecked(false);
            this.aKX.setCompoundDrawables(this.aLi, null, null, null);
            this.aKX.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.aKZ != null) {
            this.aKZ.cancel();
            this.aKZ = null;
        }
        Hd();
    }

    public void Hc() {
        this.aKS.setVisibility(8);
        this.aKS.clearCheck();
        this.aKT.setVisibility(8);
        this.aKT.clearCheck();
        this.aKV.setVisibility(8);
        this.aKW.setVisibility(8);
        this.aKX.setVisibility(8);
        this.aKV.setChecked(false);
        this.aKW.setChecked(false);
        this.aKX.setChecked(false);
    }

    public void Hd() {
        if (this.aKQ != null && this.aKQ.isShowing()) {
            g.b(this.aKQ, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(String str) {
        if (str == null) {
            this.aLa.setVisibility(4);
            this.aLa.setText((CharSequence) null);
            return;
        }
        this.aLa.setVisibility(0);
        this.aLa.setText(str);
    }

    private void GW() {
        al.i(this.aKP, e.f.dialog_background);
        al.h(this.aLd, e.d.cp_cont_b);
        al.h(this.aLj, e.d.cp_cont_f);
        al.h(this.aKR, e.d.cp_cont_b);
        al.i(this.aLk, e.f.bg_search_input);
        al.h(this.aLa, e.d.cp_cont_h);
        al.h(this.aKV, e.d.cp_cont_b);
        al.h(this.aKW, e.d.cp_cont_b);
        al.h(this.aKX, e.d.cp_cont_b);
        al.j(this.aLl, e.d.cp_bg_line_a);
        al.i(this.aKY, e.f.dialog_left_button_selector);
        al.h(this.aKY, e.d.cp_link_tip_a);
        al.j(this.aLm, e.d.cp_bg_line_a);
        al.i(this.aLb, e.f.dialog_right_button_selector);
        al.h(this.aLb, e.d.cp_link_tip_a);
        this.aKR.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.aKV.setCompoundDrawables(this.aLi, null, null, null);
        this.aKW.setCompoundDrawables(this.aLi, null, null, null);
        this.aKX.setCompoundDrawables(this.aLi, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, i> {
        final /* synthetic */ a aLp;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.aLp.aKZ = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public i doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.u("un", this.mAccount);
            String zt = this.mNetwork.zt();
            if (!this.mNetwork.zU() || this.mNetwork.zV() != 36) {
                return null;
            }
            i iVar = new i();
            iVar.parserJson(zt);
            return iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(i iVar) {
            super.onPostExecute(iVar);
            this.aLp.aKZ = null;
            if (!this.mNetwork.zU()) {
                this.aLp.gz(this.mNetwork.getErrorString());
            } else if (this.mNetwork.zV() == 0) {
                this.aLp.gz(this.aLp.mContext.getString(e.j.name_not_use));
            } else if (this.mNetwork.zV() == 36) {
                this.aLp.gz(this.mNetwork.getErrorString());
                if (iVar != null) {
                    this.aLp.r(iVar.Do());
                }
            } else {
                this.aLp.gz(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.aLp.gz(null);
            this.aLp.Hc();
            super.onPreExecute();
        }
    }
}
