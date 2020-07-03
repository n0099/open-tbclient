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
import com.baidu.adp.lib.f.g;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private Activity bdo;
    private Drawable epZ;
    private Drawable eqa;
    private TextView eqb;
    private View eqc;
    private View eqd;
    private View eqe;
    private a.InterfaceC0478a eqg;
    private int size;
    private View epH = null;
    private Dialog epI = null;
    private EditText epJ = null;
    private RadioGroup epK = null;
    private RadioGroup epL = null;
    private CompoundButton.OnCheckedChangeListener epM = null;
    private RadioButton epN = null;
    private RadioButton epO = null;
    private RadioButton epP = null;
    private TextView epQ = null;
    private C0492b epR = null;
    private TextView epS = null;
    private TextView epT = null;
    private ProgressBar epU = null;
    private TextView epV = null;
    private AccountData epW = null;
    private a epX = null;
    private a epY = null;
    private boolean eqf = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.bdo = null;
        this.epZ = null;
        this.eqa = null;
        this.size = 0;
        this.bdo = activity;
        this.epZ = an.getDrawable(R.drawable.icon_tips_names_s);
        this.eqa = an.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.bdo.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.epZ.setBounds(0, 0, this.size, this.size);
        this.eqa.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0478a interfaceC0478a) {
        this.eqg = interfaceC0478a;
    }

    public void setAccountData(AccountData accountData) {
        this.epW = accountData;
    }

    public void a(a aVar) {
        this.epX = aVar;
    }

    public void b(a aVar) {
        this.epY = aVar;
    }

    public void bdv() {
        nk(0);
    }

    public void nk(int i) {
        if (this.epI == null) {
            this.epH = LayoutInflater.from(this.bdo).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.eqb = (TextView) this.epH.findViewById(R.id.tip_info);
            this.eqc = this.epH.findViewById(R.id.divider_under_account);
            this.eqd = this.epH.findViewById(R.id.divider_under_radiongroup);
            this.eqe = this.epH.findViewById(R.id.divider_with_yes_no_button);
            this.epJ = (EditText) this.epH.findViewById(R.id.account);
            this.epJ.setHint(this.bdo.getString(R.string.hint_tip_input_name));
            this.epQ = (TextView) this.epH.findViewById(R.id.back);
            this.epQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bdz();
                    b.this.bdx();
                }
            });
            this.epT = (TextView) this.epH.findViewById(R.id.confirm);
            this.epT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bdw();
                }
            });
            this.epU = (ProgressBar) this.epH.findViewById(R.id.confirm_progress);
            this.epS = (TextView) this.epH.findViewById(R.id.error_info);
            this.epK = (RadioGroup) this.epH.findViewById(R.id.names_group1);
            this.epL = (RadioGroup) this.epH.findViewById(R.id.names_group2);
            this.epN = (RadioButton) this.epH.findViewById(R.id.name1);
            this.epO = (RadioButton) this.epH.findViewById(R.id.name2);
            this.epP = (RadioButton) this.epH.findViewById(R.id.name3);
            this.epM = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.epN) {
                            b.this.epL.clearCheck();
                            b.this.epN.setChecked(true);
                            b.this.epN.setCompoundDrawables(b.this.epZ, null, null, null);
                            b.this.epO.setChecked(false);
                            b.this.epO.setCompoundDrawables(b.this.eqa, null, null, null);
                            b.this.epP.setChecked(false);
                            b.this.epP.setCompoundDrawables(b.this.eqa, null, null, null);
                        } else if (compoundButton == b.this.epO) {
                            b.this.epL.clearCheck();
                            b.this.epN.setChecked(false);
                            b.this.epN.setCompoundDrawables(b.this.eqa, null, null, null);
                            b.this.epO.setChecked(true);
                            b.this.epO.setCompoundDrawables(b.this.epZ, null, null, null);
                            b.this.epP.setChecked(false);
                            b.this.epP.setCompoundDrawables(b.this.eqa, null, null, null);
                        } else if (compoundButton == b.this.epP) {
                            b.this.epK.clearCheck();
                            b.this.epN.setChecked(false);
                            b.this.epN.setCompoundDrawables(b.this.eqa, null, null, null);
                            b.this.epO.setChecked(false);
                            b.this.epO.setCompoundDrawables(b.this.eqa, null, null, null);
                            b.this.epP.setChecked(true);
                            b.this.epP.setCompoundDrawables(b.this.epZ, null, null, null);
                        }
                        b.this.epJ.setText(compoundButton.getText());
                    }
                }
            };
            this.epN.setOnCheckedChangeListener(this.epM);
            this.epO.setOnCheckedChangeListener(this.epM);
            this.epP.setOnCheckedChangeListener(this.epM);
            this.epV = (TextView) this.epH.findViewById(R.id.phone_info);
            bdy();
            this.epI = new Dialog(this.bdo, R.style.input_username_dialog);
            this.epI.setCanceledOnTouchOutside(false);
            this.epI.setCancelable(false);
            this.epI.setCanceledOnTouchOutside(false);
            bdo();
        }
        if (i == 1) {
            this.epV.setText(R.string.tip_init_user_name);
        } else {
            this.epV.setText(R.string.bar_friend);
        }
        if (!this.epI.isShowing()) {
            this.epJ.setText((CharSequence) null);
            bdy();
            xU(null);
            if (!this.bdo.isFinishing()) {
                this.epI.setContentView(this.epH);
                g.showDialog(this.epI, this.bdo);
                if (this.bdo instanceof BaseActivity) {
                    ((BaseActivity) this.bdo).ShowSoftKeyPadDelay(this.epJ, 150);
                } else {
                    new Handler().postDelayed(new c(this.epJ), 150L);
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
            if (!b.this.bdo.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.bdo.getSystemService("input_method");
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

    public void bdw() {
        String obj = this.epJ.getText().toString();
        if (obj == null || obj.length() <= 0) {
            xU(this.bdo.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            xU(this.bdo.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.epR != null) {
                this.epR.cancel();
            }
            if (!this.eqf && this.epW != null) {
                this.epU.setVisibility(0);
                this.epT.setEnabled(false);
                xU(null);
                bdy();
                SapiAccountManager.getInstance().getAccountService().fillUsername(new FillUsernameCallback() { // from class: com.baidu.tbadk.coreExtra.view.b.4
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
                        b.this.bdz();
                        l.showToast(b.this.bdo, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.aPB().a(session.username, session.bduss, "", null, b.this.eqg);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.xU(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.eqf = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.epU.setVisibility(8);
                        b.this.epT.setEnabled(true);
                        b.this.eqf = false;
                    }
                }, this.epW.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdx() {
        if (this.epY != null) {
            this.epY.g(null);
        }
    }

    public void D(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            xU(this.bdo.getString(R.string.suggest_no_name));
            return;
        }
        xU(this.bdo.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.epK.clearCheck();
        this.epL.clearCheck();
        this.epK.setVisibility(0);
        this.epL.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.epN.setText(arrayList.get(0));
            this.epN.setChecked(false);
            this.epN.setCompoundDrawables(this.eqa, null, null, null);
            this.epN.setVisibility(0);
            this.epK.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.epO.setText(arrayList.get(1));
            this.epO.setChecked(false);
            this.epO.setCompoundDrawables(this.eqa, null, null, null);
            this.epO.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.epP.setText(arrayList.get(2));
            this.epP.setChecked(false);
            this.epP.setCompoundDrawables(this.eqa, null, null, null);
            this.epP.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.epR != null) {
            this.epR.cancel();
            this.epR = null;
        }
        bdz();
    }

    public void bdy() {
        this.epK.setVisibility(8);
        this.epK.clearCheck();
        this.epL.setVisibility(8);
        this.epL.clearCheck();
        this.epN.setVisibility(8);
        this.epO.setVisibility(8);
        this.epP.setVisibility(8);
        this.epN.setChecked(false);
        this.epO.setChecked(false);
        this.epP.setChecked(false);
    }

    public void bdz() {
        if (this.epI != null && this.epI.isShowing()) {
            g.dismissDialog(this.epI, this.bdo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU(String str) {
        if (str == null) {
            this.epS.setVisibility(4);
            this.epS.setText((CharSequence) null);
            return;
        }
        this.epS.setVisibility(0);
        this.epS.setText(str);
    }

    private void bdo() {
        an.setBackgroundResource(this.epH, R.drawable.dialog_background);
        an.setViewTextColor(this.epV, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.eqb, (int) R.color.cp_cont_f);
        an.setViewTextColor(this.epJ, (int) R.color.cp_cont_b);
        an.setBackgroundResource(this.eqc, R.drawable.bg_search_input);
        an.setViewTextColor(this.epS, (int) R.color.cp_cont_h);
        an.setViewTextColor(this.epN, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.epO, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.epP, (int) R.color.cp_cont_b);
        an.setBackgroundColor(this.eqd, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.epQ, R.drawable.dialog_left_button_selector);
        an.setViewTextColor(this.epQ, (int) R.color.cp_link_tip_a);
        an.setBackgroundColor(this.eqe, R.color.cp_bg_line_c);
        an.setBackgroundResource(this.epT, R.drawable.dialog_right_button_selector);
        an.setViewTextColor(this.epT, (int) R.color.cp_link_tip_a);
        this.epJ.setHintTextColor(an.getColor(R.color.cp_cont_e));
        this.epN.setCompoundDrawables(this.eqa, null, null, null);
        this.epO.setCompoundDrawables(this.eqa, null, null, null);
        this.epP.setCompoundDrawables(this.eqa, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0492b extends BdAsyncTask<String, Integer, k> {
        final /* synthetic */ b eqh;
        private String mAccount;
        private y mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.eqh.epR = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: C */
        public k doInBackground(String... strArr) {
            this.mNetwork = new y(this.mUrl);
            this.mNetwork.addPostData("un", this.mAccount);
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.isNetSuccess() || this.mNetwork.getServerErrorCode() != 36) {
                return null;
            }
            k kVar = new k();
            kVar.parserJson(postNetData);
            return kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(k kVar) {
            super.onPostExecute(kVar);
            this.eqh.epR = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.eqh.xU(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.eqh.xU(this.eqh.bdo.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.eqh.xU(this.mNetwork.getErrorString());
                if (kVar != null) {
                    this.eqh.D(kVar.bad());
                }
            } else {
                this.eqh.xU(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.eqh.xU(null);
            this.eqh.bdy();
            super.onPreExecute();
        }
    }
}
