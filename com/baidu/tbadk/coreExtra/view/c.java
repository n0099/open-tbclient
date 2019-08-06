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
    private Drawable cnE;
    private Drawable cnF;
    private TextView cnG;
    private View cnH;
    private View cnI;
    private View cnJ;
    private a.InterfaceC0239a cnL;
    private Activity mContext;
    private int size;
    private View cnl = null;
    private Dialog cnm = null;
    private EditText cnn = null;
    private RadioGroup cno = null;
    private RadioGroup cnp = null;
    private CompoundButton.OnCheckedChangeListener cnq = null;
    private RadioButton cnr = null;
    private RadioButton cns = null;
    private RadioButton cnu = null;
    private TextView cnv = null;
    private b cnw = null;
    private TextView cnx = null;
    private TextView cny = null;
    private ProgressBar cnz = null;
    private TextView cnA = null;
    private AccountData cnB = null;
    private a cnC = null;
    private a cnD = null;
    private boolean cnK = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.cnE = null;
        this.cnF = null;
        this.size = 0;
        this.mContext = activity;
        this.cnE = am.getDrawable(R.drawable.icon_tips_names_s);
        this.cnF = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.cnE.setBounds(0, 0, this.size, this.size);
        this.cnF.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0239a interfaceC0239a) {
        this.cnL = interfaceC0239a;
    }

    public void setAccountData(AccountData accountData) {
        this.cnB = accountData;
    }

    public void a(a aVar) {
        this.cnC = aVar;
    }

    public void b(a aVar) {
        this.cnD = aVar;
    }

    public void aqp() {
        jU(0);
    }

    public void jU(int i) {
        if (this.cnm == null) {
            this.cnl = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.cnG = (TextView) this.cnl.findViewById(R.id.tip_info);
            this.cnH = this.cnl.findViewById(R.id.divider_under_account);
            this.cnI = this.cnl.findViewById(R.id.divider_under_radiongroup);
            this.cnJ = this.cnl.findViewById(R.id.divider_with_yes_no_button);
            this.cnn = (EditText) this.cnl.findViewById(R.id.account);
            this.cnn.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.cnv = (TextView) this.cnl.findViewById(R.id.back);
            this.cnv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aqt();
                    c.this.aqr();
                }
            });
            this.cny = (TextView) this.cnl.findViewById(R.id.confirm);
            this.cny.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aqq();
                }
            });
            this.cnz = (ProgressBar) this.cnl.findViewById(R.id.confirm_progress);
            this.cnx = (TextView) this.cnl.findViewById(R.id.error_info);
            this.cno = (RadioGroup) this.cnl.findViewById(R.id.names_group1);
            this.cnp = (RadioGroup) this.cnl.findViewById(R.id.names_group2);
            this.cnr = (RadioButton) this.cnl.findViewById(R.id.name1);
            this.cns = (RadioButton) this.cnl.findViewById(R.id.name2);
            this.cnu = (RadioButton) this.cnl.findViewById(R.id.name3);
            this.cnq = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.cnr) {
                            c.this.cnp.clearCheck();
                            c.this.cnr.setChecked(true);
                            c.this.cnr.setCompoundDrawables(c.this.cnE, null, null, null);
                            c.this.cns.setChecked(false);
                            c.this.cns.setCompoundDrawables(c.this.cnF, null, null, null);
                            c.this.cnu.setChecked(false);
                            c.this.cnu.setCompoundDrawables(c.this.cnF, null, null, null);
                        } else if (compoundButton == c.this.cns) {
                            c.this.cnp.clearCheck();
                            c.this.cnr.setChecked(false);
                            c.this.cnr.setCompoundDrawables(c.this.cnF, null, null, null);
                            c.this.cns.setChecked(true);
                            c.this.cns.setCompoundDrawables(c.this.cnE, null, null, null);
                            c.this.cnu.setChecked(false);
                            c.this.cnu.setCompoundDrawables(c.this.cnF, null, null, null);
                        } else if (compoundButton == c.this.cnu) {
                            c.this.cno.clearCheck();
                            c.this.cnr.setChecked(false);
                            c.this.cnr.setCompoundDrawables(c.this.cnF, null, null, null);
                            c.this.cns.setChecked(false);
                            c.this.cns.setCompoundDrawables(c.this.cnF, null, null, null);
                            c.this.cnu.setChecked(true);
                            c.this.cnu.setCompoundDrawables(c.this.cnE, null, null, null);
                        }
                        c.this.cnn.setText(compoundButton.getText());
                    }
                }
            };
            this.cnr.setOnCheckedChangeListener(this.cnq);
            this.cns.setOnCheckedChangeListener(this.cnq);
            this.cnu.setOnCheckedChangeListener(this.cnq);
            this.cnA = (TextView) this.cnl.findViewById(R.id.phone_info);
            aqs();
            this.cnm = new Dialog(this.mContext, R.style.input_username_dialog);
            this.cnm.setCanceledOnTouchOutside(false);
            this.cnm.setCancelable(false);
            this.cnm.setCanceledOnTouchOutside(false);
            aqg();
        }
        if (i == 1) {
            this.cnA.setText(R.string.tip_init_user_name);
        } else {
            this.cnA.setText(R.string.bar_friend);
        }
        if (!this.cnm.isShowing()) {
            this.cnn.setText((CharSequence) null);
            aqs();
            pI(null);
            if (!this.mContext.isFinishing()) {
                this.cnm.setContentView(this.cnl);
                g.a(this.cnm, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.cnn, BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
                } else {
                    new Handler().postDelayed(new RunnableC0251c(this.cnn), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0251c implements Runnable {
        private View mView;

        public RunnableC0251c(View view) {
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

    public void aqq() {
        String obj = this.cnn.getText().toString();
        if (obj == null || obj.length() <= 0) {
            pI(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            pI(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.cnw != null) {
                this.cnw.cancel();
            }
            if (!this.cnK && this.cnB != null) {
                this.cnz.setVisibility(0);
                this.cny.setEnabled(false);
                pI(null);
                aqs();
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
                        c.this.aqt();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.acf().a(session.username, session.bduss, "", null, c.this.cnL);
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
                        c.this.cnK = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cnz.setVisibility(8);
                        c.this.cny.setEnabled(true);
                        c.this.cnK = false;
                    }
                }, this.cnB.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqr() {
        if (this.cnD != null) {
            this.cnD.g(null);
        }
    }

    public void w(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            pI(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        pI(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.cno.clearCheck();
        this.cnp.clearCheck();
        this.cno.setVisibility(0);
        this.cnp.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.cnr.setText(arrayList.get(0));
            this.cnr.setChecked(false);
            this.cnr.setCompoundDrawables(this.cnF, null, null, null);
            this.cnr.setVisibility(0);
            this.cno.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.cns.setText(arrayList.get(1));
            this.cns.setChecked(false);
            this.cns.setCompoundDrawables(this.cnF, null, null, null);
            this.cns.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.cnu.setText(arrayList.get(2));
            this.cnu.setChecked(false);
            this.cnu.setCompoundDrawables(this.cnF, null, null, null);
            this.cnu.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cnw != null) {
            this.cnw.cancel();
            this.cnw = null;
        }
        aqt();
    }

    public void aqs() {
        this.cno.setVisibility(8);
        this.cno.clearCheck();
        this.cnp.setVisibility(8);
        this.cnp.clearCheck();
        this.cnr.setVisibility(8);
        this.cns.setVisibility(8);
        this.cnu.setVisibility(8);
        this.cnr.setChecked(false);
        this.cns.setChecked(false);
        this.cnu.setChecked(false);
    }

    public void aqt() {
        if (this.cnm != null && this.cnm.isShowing()) {
            g.b(this.cnm, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI(String str) {
        if (str == null) {
            this.cnx.setVisibility(4);
            this.cnx.setText((CharSequence) null);
            return;
        }
        this.cnx.setVisibility(0);
        this.cnx.setText(str);
    }

    private void aqg() {
        am.k(this.cnl, R.drawable.dialog_background);
        am.j(this.cnA, R.color.cp_cont_b);
        am.j(this.cnG, R.color.cp_cont_f);
        am.j(this.cnn, R.color.cp_cont_b);
        am.k(this.cnH, R.drawable.bg_search_input);
        am.j(this.cnx, R.color.cp_cont_h);
        am.j(this.cnr, R.color.cp_cont_b);
        am.j(this.cns, R.color.cp_cont_b);
        am.j(this.cnu, R.color.cp_cont_b);
        am.l(this.cnI, R.color.cp_bg_line_a);
        am.k(this.cnv, R.drawable.dialog_left_button_selector);
        am.j(this.cnv, R.color.cp_link_tip_a);
        am.l(this.cnJ, R.color.cp_bg_line_a);
        am.k(this.cny, R.drawable.dialog_right_button_selector);
        am.j(this.cny, R.color.cp_link_tip_a);
        this.cnn.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.cnr.setCompoundDrawables(this.cnF, null, null, null);
        this.cns.setCompoundDrawables(this.cnF, null, null, null);
        this.cnu.setCompoundDrawables(this.cnF, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cnM;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cnM.cnw = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.o("un", this.mAccount);
            String aii = this.mNetwork.aii();
            if (!this.mNetwork.aiJ() || this.mNetwork.aiK() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(aii);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.cnM.cnw = null;
            if (!this.mNetwork.aiJ()) {
                this.cnM.pI(this.mNetwork.getErrorString());
            } else if (this.mNetwork.aiK() == 0) {
                this.cnM.pI(this.cnM.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.aiK() == 36) {
                this.cnM.pI(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cnM.w(jVar.amp());
                }
            } else {
                this.cnM.pI(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cnM.pI(null);
            this.cnM.aqs();
            super.onPreExecute();
        }
    }
}
