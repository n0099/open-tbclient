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
    private Drawable cmk;
    private Drawable cml;
    private TextView cmm;
    private View cmn;
    private View cmo;
    private View cmp;
    private a.InterfaceC0237a cmr;
    private Activity mContext;
    private int size;
    private View clR = null;
    private Dialog clS = null;
    private EditText clT = null;
    private RadioGroup clU = null;
    private RadioGroup clV = null;
    private CompoundButton.OnCheckedChangeListener clW = null;
    private RadioButton clX = null;
    private RadioButton clY = null;
    private RadioButton clZ = null;
    private TextView cma = null;
    private b cmb = null;
    private TextView cmc = null;
    private TextView cme = null;
    private ProgressBar cmf = null;
    private TextView cmg = null;
    private AccountData cmh = null;
    private a cmi = null;
    private a cmj = null;
    private boolean cmq = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.cmk = null;
        this.cml = null;
        this.size = 0;
        this.mContext = activity;
        this.cmk = al.getDrawable(R.drawable.icon_tips_names_s);
        this.cml = al.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.cmk.setBounds(0, 0, this.size, this.size);
        this.cml.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0237a interfaceC0237a) {
        this.cmr = interfaceC0237a;
    }

    public void setAccountData(AccountData accountData) {
        this.cmh = accountData;
    }

    public void a(a aVar) {
        this.cmi = aVar;
    }

    public void b(a aVar) {
        this.cmj = aVar;
    }

    public void aph() {
        jN(0);
    }

    public void jN(int i) {
        if (this.clS == null) {
            this.clR = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.cmm = (TextView) this.clR.findViewById(R.id.tip_info);
            this.cmn = this.clR.findViewById(R.id.divider_under_account);
            this.cmo = this.clR.findViewById(R.id.divider_under_radiongroup);
            this.cmp = this.clR.findViewById(R.id.divider_with_yes_no_button);
            this.clT = (EditText) this.clR.findViewById(R.id.account);
            this.clT.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.cma = (TextView) this.clR.findViewById(R.id.back);
            this.cma.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.apm();
                    c.this.apk();
                }
            });
            this.cme = (TextView) this.clR.findViewById(R.id.confirm);
            this.cme.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.apj();
                }
            });
            this.cmf = (ProgressBar) this.clR.findViewById(R.id.confirm_progress);
            this.cmc = (TextView) this.clR.findViewById(R.id.error_info);
            this.clU = (RadioGroup) this.clR.findViewById(R.id.names_group1);
            this.clV = (RadioGroup) this.clR.findViewById(R.id.names_group2);
            this.clX = (RadioButton) this.clR.findViewById(R.id.name1);
            this.clY = (RadioButton) this.clR.findViewById(R.id.name2);
            this.clZ = (RadioButton) this.clR.findViewById(R.id.name3);
            this.clW = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.clX) {
                            c.this.clV.clearCheck();
                            c.this.clX.setChecked(true);
                            c.this.clX.setCompoundDrawables(c.this.cmk, null, null, null);
                            c.this.clY.setChecked(false);
                            c.this.clY.setCompoundDrawables(c.this.cml, null, null, null);
                            c.this.clZ.setChecked(false);
                            c.this.clZ.setCompoundDrawables(c.this.cml, null, null, null);
                        } else if (compoundButton == c.this.clY) {
                            c.this.clV.clearCheck();
                            c.this.clX.setChecked(false);
                            c.this.clX.setCompoundDrawables(c.this.cml, null, null, null);
                            c.this.clY.setChecked(true);
                            c.this.clY.setCompoundDrawables(c.this.cmk, null, null, null);
                            c.this.clZ.setChecked(false);
                            c.this.clZ.setCompoundDrawables(c.this.cml, null, null, null);
                        } else if (compoundButton == c.this.clZ) {
                            c.this.clU.clearCheck();
                            c.this.clX.setChecked(false);
                            c.this.clX.setCompoundDrawables(c.this.cml, null, null, null);
                            c.this.clY.setChecked(false);
                            c.this.clY.setCompoundDrawables(c.this.cml, null, null, null);
                            c.this.clZ.setChecked(true);
                            c.this.clZ.setCompoundDrawables(c.this.cmk, null, null, null);
                        }
                        c.this.clT.setText(compoundButton.getText());
                    }
                }
            };
            this.clX.setOnCheckedChangeListener(this.clW);
            this.clY.setOnCheckedChangeListener(this.clW);
            this.clZ.setOnCheckedChangeListener(this.clW);
            this.cmg = (TextView) this.clR.findViewById(R.id.phone_info);
            apl();
            this.clS = new Dialog(this.mContext, R.style.input_username_dialog);
            this.clS.setCanceledOnTouchOutside(false);
            this.clS.setCancelable(false);
            this.clS.setCanceledOnTouchOutside(false);
            aoY();
        }
        if (i == 1) {
            this.cmg.setText(R.string.tip_init_user_name);
        } else {
            this.cmg.setText(R.string.bar_friend);
        }
        if (!this.clS.isShowing()) {
            this.clT.setText((CharSequence) null);
            apl();
            pr(null);
            if (!this.mContext.isFinishing()) {
                this.clS.setContentView(this.clR);
                g.a(this.clS, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.clT, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new RunnableC0249c(this.clT), 150L);
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
        String obj = this.clT.getText().toString();
        if (obj == null || obj.length() <= 0) {
            pr(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            pr(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.cmb != null) {
                this.cmb.cancel();
            }
            if (!this.cmq && this.cmh != null) {
                this.cmf.setVisibility(0);
                this.cme.setEnabled(false);
                pr(null);
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
                        com.baidu.tbadk.core.a.a.abg().a(session.username, session.bduss, "", null, c.this.cmr);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.pr(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.cmq = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cmf.setVisibility(8);
                        c.this.cme.setEnabled(true);
                        c.this.cmq = false;
                    }
                }, this.cmh.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apk() {
        if (this.cmj != null) {
            this.cmj.g(null);
        }
    }

    public void w(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            pr(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        pr(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.clU.clearCheck();
        this.clV.clearCheck();
        this.clU.setVisibility(0);
        this.clV.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.clX.setText(arrayList.get(0));
            this.clX.setChecked(false);
            this.clX.setCompoundDrawables(this.cml, null, null, null);
            this.clX.setVisibility(0);
            this.clU.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.clY.setText(arrayList.get(1));
            this.clY.setChecked(false);
            this.clY.setCompoundDrawables(this.cml, null, null, null);
            this.clY.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.clZ.setText(arrayList.get(2));
            this.clZ.setChecked(false);
            this.clZ.setCompoundDrawables(this.cml, null, null, null);
            this.clZ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cmb != null) {
            this.cmb.cancel();
            this.cmb = null;
        }
        apm();
    }

    public void apl() {
        this.clU.setVisibility(8);
        this.clU.clearCheck();
        this.clV.setVisibility(8);
        this.clV.clearCheck();
        this.clX.setVisibility(8);
        this.clY.setVisibility(8);
        this.clZ.setVisibility(8);
        this.clX.setChecked(false);
        this.clY.setChecked(false);
        this.clZ.setChecked(false);
    }

    public void apm() {
        if (this.clS != null && this.clS.isShowing()) {
            g.b(this.clS, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(String str) {
        if (str == null) {
            this.cmc.setVisibility(4);
            this.cmc.setText((CharSequence) null);
            return;
        }
        this.cmc.setVisibility(0);
        this.cmc.setText(str);
    }

    private void aoY() {
        al.k(this.clR, R.drawable.dialog_background);
        al.j(this.cmg, R.color.cp_cont_b);
        al.j(this.cmm, R.color.cp_cont_f);
        al.j(this.clT, R.color.cp_cont_b);
        al.k(this.cmn, R.drawable.bg_search_input);
        al.j(this.cmc, R.color.cp_cont_h);
        al.j(this.clX, R.color.cp_cont_b);
        al.j(this.clY, R.color.cp_cont_b);
        al.j(this.clZ, R.color.cp_cont_b);
        al.l(this.cmo, R.color.cp_bg_line_a);
        al.k(this.cma, R.drawable.dialog_left_button_selector);
        al.j(this.cma, R.color.cp_link_tip_a);
        al.l(this.cmp, R.color.cp_bg_line_a);
        al.k(this.cme, R.drawable.dialog_right_button_selector);
        al.j(this.cme, R.color.cp_link_tip_a);
        this.clT.setHintTextColor(al.getColor(R.color.cp_cont_e));
        this.clX.setCompoundDrawables(this.cml, null, null, null);
        this.clY.setCompoundDrawables(this.cml, null, null, null);
        this.clZ.setCompoundDrawables(this.cml, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cms;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cms.cmb = null;
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
            this.cms.cmb = null;
            if (!this.mNetwork.ahF()) {
                this.cms.pr(this.mNetwork.getErrorString());
            } else if (this.mNetwork.ahG() == 0) {
                this.cms.pr(this.cms.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.ahG() == 36) {
                this.cms.pr(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cms.w(jVar.ali());
                }
            } else {
                this.cms.pr(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cms.pr(null);
            this.cms.apl();
            super.onPreExecute();
        }
    }
}
