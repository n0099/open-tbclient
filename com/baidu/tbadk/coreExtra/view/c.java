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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private View cnA;
    private View cnB;
    private View cnC;
    private a.InterfaceC0234a cnE;
    private Drawable cnx;
    private Drawable cny;
    private TextView cnz;
    private Activity mContext;
    private int size;
    private View cne = null;
    private Dialog cnf = null;
    private EditText cng = null;
    private RadioGroup cnh = null;
    private RadioGroup cni = null;
    private CompoundButton.OnCheckedChangeListener cnj = null;
    private RadioButton cnk = null;
    private RadioButton cnl = null;
    private RadioButton cnm = null;
    private TextView cnn = null;
    private b cno = null;
    private TextView cnp = null;
    private TextView cnq = null;
    private ProgressBar cnr = null;
    private TextView cns = null;
    private AccountData cnu = null;
    private a cnv = null;
    private a cnw = null;
    private boolean cnD = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.cnx = null;
        this.cny = null;
        this.size = 0;
        this.mContext = activity;
        this.cnx = am.getDrawable(R.drawable.icon_tips_names_s);
        this.cny = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.cnx.setBounds(0, 0, this.size, this.size);
        this.cny.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0234a interfaceC0234a) {
        this.cnE = interfaceC0234a;
    }

    public void setAccountData(AccountData accountData) {
        this.cnu = accountData;
    }

    public void a(a aVar) {
        this.cnv = aVar;
    }

    public void b(a aVar) {
        this.cnw = aVar;
    }

    public void aqn() {
        jT(0);
    }

    public void jT(int i) {
        if (this.cnf == null) {
            this.cne = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.cnz = (TextView) this.cne.findViewById(R.id.tip_info);
            this.cnA = this.cne.findViewById(R.id.divider_under_account);
            this.cnB = this.cne.findViewById(R.id.divider_under_radiongroup);
            this.cnC = this.cne.findViewById(R.id.divider_with_yes_no_button);
            this.cng = (EditText) this.cne.findViewById(R.id.account);
            this.cng.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.cnn = (TextView) this.cne.findViewById(R.id.back);
            this.cnn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aqr();
                    c.this.aqp();
                }
            });
            this.cnq = (TextView) this.cne.findViewById(R.id.confirm);
            this.cnq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aqo();
                }
            });
            this.cnr = (ProgressBar) this.cne.findViewById(R.id.confirm_progress);
            this.cnp = (TextView) this.cne.findViewById(R.id.error_info);
            this.cnh = (RadioGroup) this.cne.findViewById(R.id.names_group1);
            this.cni = (RadioGroup) this.cne.findViewById(R.id.names_group2);
            this.cnk = (RadioButton) this.cne.findViewById(R.id.name1);
            this.cnl = (RadioButton) this.cne.findViewById(R.id.name2);
            this.cnm = (RadioButton) this.cne.findViewById(R.id.name3);
            this.cnj = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.cnk) {
                            c.this.cni.clearCheck();
                            c.this.cnk.setChecked(true);
                            c.this.cnk.setCompoundDrawables(c.this.cnx, null, null, null);
                            c.this.cnl.setChecked(false);
                            c.this.cnl.setCompoundDrawables(c.this.cny, null, null, null);
                            c.this.cnm.setChecked(false);
                            c.this.cnm.setCompoundDrawables(c.this.cny, null, null, null);
                        } else if (compoundButton == c.this.cnl) {
                            c.this.cni.clearCheck();
                            c.this.cnk.setChecked(false);
                            c.this.cnk.setCompoundDrawables(c.this.cny, null, null, null);
                            c.this.cnl.setChecked(true);
                            c.this.cnl.setCompoundDrawables(c.this.cnx, null, null, null);
                            c.this.cnm.setChecked(false);
                            c.this.cnm.setCompoundDrawables(c.this.cny, null, null, null);
                        } else if (compoundButton == c.this.cnm) {
                            c.this.cnh.clearCheck();
                            c.this.cnk.setChecked(false);
                            c.this.cnk.setCompoundDrawables(c.this.cny, null, null, null);
                            c.this.cnl.setChecked(false);
                            c.this.cnl.setCompoundDrawables(c.this.cny, null, null, null);
                            c.this.cnm.setChecked(true);
                            c.this.cnm.setCompoundDrawables(c.this.cnx, null, null, null);
                        }
                        c.this.cng.setText(compoundButton.getText());
                    }
                }
            };
            this.cnk.setOnCheckedChangeListener(this.cnj);
            this.cnl.setOnCheckedChangeListener(this.cnj);
            this.cnm.setOnCheckedChangeListener(this.cnj);
            this.cns = (TextView) this.cne.findViewById(R.id.phone_info);
            aqq();
            this.cnf = new Dialog(this.mContext, R.style.input_username_dialog);
            this.cnf.setCanceledOnTouchOutside(false);
            this.cnf.setCancelable(false);
            this.cnf.setCanceledOnTouchOutside(false);
            aqe();
        }
        if (i == 1) {
            this.cns.setText(R.string.tip_init_user_name);
        } else {
            this.cns.setText(R.string.bar_friend);
        }
        if (!this.cnf.isShowing()) {
            this.cng.setText((CharSequence) null);
            aqq();
            pI(null);
            if (!this.mContext.isFinishing()) {
                this.cnf.setContentView(this.cne);
                g.a(this.cnf, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.cng, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new RunnableC0246c(this.cng), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0246c implements Runnable {
        private View mView;

        public RunnableC0246c(View view) {
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

    public void aqo() {
        String obj = this.cng.getText().toString();
        if (obj == null || obj.length() <= 0) {
            pI(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            pI(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.cno != null) {
                this.cno.cancel();
            }
            if (!this.cnD && this.cnu != null) {
                this.cnr.setVisibility(0);
                this.cnq.setEnabled(false);
                pI(null);
                aqq();
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
                        c.this.aqr();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.acf().a(session.username, session.bduss, "", null, c.this.cnE);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.pI(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.cnD = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cnr.setVisibility(8);
                        c.this.cnq.setEnabled(true);
                        c.this.cnD = false;
                    }
                }, this.cnu.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqp() {
        if (this.cnw != null) {
            this.cnw.g(null);
        }
    }

    public void w(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            pI(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        pI(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.cnh.clearCheck();
        this.cni.clearCheck();
        this.cnh.setVisibility(0);
        this.cni.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.cnk.setText(arrayList.get(0));
            this.cnk.setChecked(false);
            this.cnk.setCompoundDrawables(this.cny, null, null, null);
            this.cnk.setVisibility(0);
            this.cnh.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.cnl.setText(arrayList.get(1));
            this.cnl.setChecked(false);
            this.cnl.setCompoundDrawables(this.cny, null, null, null);
            this.cnl.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.cnm.setText(arrayList.get(2));
            this.cnm.setChecked(false);
            this.cnm.setCompoundDrawables(this.cny, null, null, null);
            this.cnm.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cno != null) {
            this.cno.cancel();
            this.cno = null;
        }
        aqr();
    }

    public void aqq() {
        this.cnh.setVisibility(8);
        this.cnh.clearCheck();
        this.cni.setVisibility(8);
        this.cni.clearCheck();
        this.cnk.setVisibility(8);
        this.cnl.setVisibility(8);
        this.cnm.setVisibility(8);
        this.cnk.setChecked(false);
        this.cnl.setChecked(false);
        this.cnm.setChecked(false);
    }

    public void aqr() {
        if (this.cnf != null && this.cnf.isShowing()) {
            g.b(this.cnf, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI(String str) {
        if (str == null) {
            this.cnp.setVisibility(4);
            this.cnp.setText((CharSequence) null);
            return;
        }
        this.cnp.setVisibility(0);
        this.cnp.setText(str);
    }

    private void aqe() {
        am.k(this.cne, R.drawable.dialog_background);
        am.j(this.cns, R.color.cp_cont_b);
        am.j(this.cnz, R.color.cp_cont_f);
        am.j(this.cng, R.color.cp_cont_b);
        am.k(this.cnA, R.drawable.bg_search_input);
        am.j(this.cnp, R.color.cp_cont_h);
        am.j(this.cnk, R.color.cp_cont_b);
        am.j(this.cnl, R.color.cp_cont_b);
        am.j(this.cnm, R.color.cp_cont_b);
        am.l(this.cnB, R.color.cp_bg_line_a);
        am.k(this.cnn, R.drawable.dialog_left_button_selector);
        am.j(this.cnn, R.color.cp_link_tip_a);
        am.l(this.cnC, R.color.cp_bg_line_a);
        am.k(this.cnq, R.drawable.dialog_right_button_selector);
        am.j(this.cnq, R.color.cp_link_tip_a);
        this.cng.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.cnk.setCompoundDrawables(this.cny, null, null, null);
        this.cnl.setCompoundDrawables(this.cny, null, null, null);
        this.cnm.setCompoundDrawables(this.cny, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cnF;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cnF.cno = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.o("un", this.mAccount);
            String aig = this.mNetwork.aig();
            if (!this.mNetwork.aiH() || this.mNetwork.aiI() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(aig);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.cnF.cno = null;
            if (!this.mNetwork.aiH()) {
                this.cnF.pI(this.mNetwork.getErrorString());
            } else if (this.mNetwork.aiI() == 0) {
                this.cnF.pI(this.cnF.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.aiI() == 36) {
                this.cnF.pI(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cnF.w(jVar.amn());
                }
            } else {
                this.cnF.pI(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cnF.pI(null);
            this.cnF.aqq();
            super.onPreExecute();
        }
    }
}
