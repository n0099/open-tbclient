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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private Drawable cmj;
    private Drawable cmk;
    private TextView cml;
    private View cmm;
    private View cmn;
    private View cmo;
    private a.InterfaceC0237a cmq;
    private Activity mContext;
    private int size;
    private View clQ = null;
    private Dialog clR = null;
    private EditText clS = null;
    private RadioGroup clT = null;
    private RadioGroup clU = null;
    private CompoundButton.OnCheckedChangeListener clV = null;
    private RadioButton clW = null;
    private RadioButton clX = null;
    private RadioButton clY = null;
    private TextView clZ = null;
    private b cma = null;
    private TextView cmb = null;
    private TextView cmc = null;
    private ProgressBar cme = null;
    private TextView cmf = null;
    private AccountData cmg = null;
    private a cmh = null;
    private a cmi = null;
    private boolean cmp = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.cmj = null;
        this.cmk = null;
        this.size = 0;
        this.mContext = activity;
        this.cmj = al.getDrawable(R.drawable.icon_tips_names_s);
        this.cmk = al.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.cmj.setBounds(0, 0, this.size, this.size);
        this.cmk.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0237a interfaceC0237a) {
        this.cmq = interfaceC0237a;
    }

    public void setAccountData(AccountData accountData) {
        this.cmg = accountData;
    }

    public void a(a aVar) {
        this.cmh = aVar;
    }

    public void b(a aVar) {
        this.cmi = aVar;
    }

    public void aph() {
        jN(0);
    }

    public void jN(int i) {
        if (this.clR == null) {
            this.clQ = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.cml = (TextView) this.clQ.findViewById(R.id.tip_info);
            this.cmm = this.clQ.findViewById(R.id.divider_under_account);
            this.cmn = this.clQ.findViewById(R.id.divider_under_radiongroup);
            this.cmo = this.clQ.findViewById(R.id.divider_with_yes_no_button);
            this.clS = (EditText) this.clQ.findViewById(R.id.account);
            this.clS.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.clZ = (TextView) this.clQ.findViewById(R.id.back);
            this.clZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.apm();
                    c.this.apk();
                }
            });
            this.cmc = (TextView) this.clQ.findViewById(R.id.confirm);
            this.cmc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.apj();
                }
            });
            this.cme = (ProgressBar) this.clQ.findViewById(R.id.confirm_progress);
            this.cmb = (TextView) this.clQ.findViewById(R.id.error_info);
            this.clT = (RadioGroup) this.clQ.findViewById(R.id.names_group1);
            this.clU = (RadioGroup) this.clQ.findViewById(R.id.names_group2);
            this.clW = (RadioButton) this.clQ.findViewById(R.id.name1);
            this.clX = (RadioButton) this.clQ.findViewById(R.id.name2);
            this.clY = (RadioButton) this.clQ.findViewById(R.id.name3);
            this.clV = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.clW) {
                            c.this.clU.clearCheck();
                            c.this.clW.setChecked(true);
                            c.this.clW.setCompoundDrawables(c.this.cmj, null, null, null);
                            c.this.clX.setChecked(false);
                            c.this.clX.setCompoundDrawables(c.this.cmk, null, null, null);
                            c.this.clY.setChecked(false);
                            c.this.clY.setCompoundDrawables(c.this.cmk, null, null, null);
                        } else if (compoundButton == c.this.clX) {
                            c.this.clU.clearCheck();
                            c.this.clW.setChecked(false);
                            c.this.clW.setCompoundDrawables(c.this.cmk, null, null, null);
                            c.this.clX.setChecked(true);
                            c.this.clX.setCompoundDrawables(c.this.cmj, null, null, null);
                            c.this.clY.setChecked(false);
                            c.this.clY.setCompoundDrawables(c.this.cmk, null, null, null);
                        } else if (compoundButton == c.this.clY) {
                            c.this.clT.clearCheck();
                            c.this.clW.setChecked(false);
                            c.this.clW.setCompoundDrawables(c.this.cmk, null, null, null);
                            c.this.clX.setChecked(false);
                            c.this.clX.setCompoundDrawables(c.this.cmk, null, null, null);
                            c.this.clY.setChecked(true);
                            c.this.clY.setCompoundDrawables(c.this.cmj, null, null, null);
                        }
                        c.this.clS.setText(compoundButton.getText());
                    }
                }
            };
            this.clW.setOnCheckedChangeListener(this.clV);
            this.clX.setOnCheckedChangeListener(this.clV);
            this.clY.setOnCheckedChangeListener(this.clV);
            this.cmf = (TextView) this.clQ.findViewById(R.id.phone_info);
            apl();
            this.clR = new Dialog(this.mContext, R.style.input_username_dialog);
            this.clR.setCanceledOnTouchOutside(false);
            this.clR.setCancelable(false);
            this.clR.setCanceledOnTouchOutside(false);
            aoY();
        }
        if (i == 1) {
            this.cmf.setText(R.string.tip_init_user_name);
        } else {
            this.cmf.setText(R.string.bar_friend);
        }
        if (!this.clR.isShowing()) {
            this.clS.setText((CharSequence) null);
            apl();
            ps(null);
            if (!this.mContext.isFinishing()) {
                this.clR.setContentView(this.clQ);
                g.a(this.clR, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.clS, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new RunnableC0249c(this.clS), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0249c implements Runnable {
        private View mView;

        public RunnableC0249c(View view) {
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

    public void apj() {
        String obj = this.clS.getText().toString();
        if (obj == null || obj.length() <= 0) {
            ps(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            ps(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.cma != null) {
                this.cma.cancel();
            }
            if (!this.cmp && this.cmg != null) {
                this.cme.setVisibility(0);
                this.cmc.setEnabled(false);
                ps(null);
                apl();
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
                        c.this.apm();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.abg().a(session.username, session.bduss, "", null, c.this.cmq);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.ps(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.cmp = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cme.setVisibility(8);
                        c.this.cmc.setEnabled(true);
                        c.this.cmp = false;
                    }
                }, this.cmg.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apk() {
        if (this.cmi != null) {
            this.cmi.g(null);
        }
    }

    public void w(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            ps(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        ps(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.clT.clearCheck();
        this.clU.clearCheck();
        this.clT.setVisibility(0);
        this.clU.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.clW.setText(arrayList.get(0));
            this.clW.setChecked(false);
            this.clW.setCompoundDrawables(this.cmk, null, null, null);
            this.clW.setVisibility(0);
            this.clT.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.clX.setText(arrayList.get(1));
            this.clX.setChecked(false);
            this.clX.setCompoundDrawables(this.cmk, null, null, null);
            this.clX.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.clY.setText(arrayList.get(2));
            this.clY.setChecked(false);
            this.clY.setCompoundDrawables(this.cmk, null, null, null);
            this.clY.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cma != null) {
            this.cma.cancel();
            this.cma = null;
        }
        apm();
    }

    public void apl() {
        this.clT.setVisibility(8);
        this.clT.clearCheck();
        this.clU.setVisibility(8);
        this.clU.clearCheck();
        this.clW.setVisibility(8);
        this.clX.setVisibility(8);
        this.clY.setVisibility(8);
        this.clW.setChecked(false);
        this.clX.setChecked(false);
        this.clY.setChecked(false);
    }

    public void apm() {
        if (this.clR != null && this.clR.isShowing()) {
            g.b(this.clR, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ps(String str) {
        if (str == null) {
            this.cmb.setVisibility(4);
            this.cmb.setText((CharSequence) null);
            return;
        }
        this.cmb.setVisibility(0);
        this.cmb.setText(str);
    }

    private void aoY() {
        al.k(this.clQ, R.drawable.dialog_background);
        al.j(this.cmf, R.color.cp_cont_b);
        al.j(this.cml, R.color.cp_cont_f);
        al.j(this.clS, R.color.cp_cont_b);
        al.k(this.cmm, R.drawable.bg_search_input);
        al.j(this.cmb, R.color.cp_cont_h);
        al.j(this.clW, R.color.cp_cont_b);
        al.j(this.clX, R.color.cp_cont_b);
        al.j(this.clY, R.color.cp_cont_b);
        al.l(this.cmn, R.color.cp_bg_line_a);
        al.k(this.clZ, R.drawable.dialog_left_button_selector);
        al.j(this.clZ, R.color.cp_link_tip_a);
        al.l(this.cmo, R.color.cp_bg_line_a);
        al.k(this.cmc, R.drawable.dialog_right_button_selector);
        al.j(this.cmc, R.color.cp_link_tip_a);
        this.clS.setHintTextColor(al.getColor(R.color.cp_cont_e));
        this.clW.setCompoundDrawables(this.cmk, null, null, null);
        this.clX.setCompoundDrawables(this.cmk, null, null, null);
        this.clY.setCompoundDrawables(this.cmk, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cmr;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cmr.cma = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.o("un", this.mAccount);
            String ahe = this.mNetwork.ahe();
            if (!this.mNetwork.ahF() || this.mNetwork.ahG() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(ahe);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.cmr.cma = null;
            if (!this.mNetwork.ahF()) {
                this.cmr.ps(this.mNetwork.getErrorString());
            } else if (this.mNetwork.ahG() == 0) {
                this.cmr.ps(this.cmr.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.ahG() == 36) {
                this.cmr.ps(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cmr.w(jVar.ali());
                }
            } else {
                this.cmr.ps(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cmr.ps(null);
            this.cmr.apl();
            super.onPreExecute();
        }
    }
}
