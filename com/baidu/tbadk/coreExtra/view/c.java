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
    private Drawable cAD;
    private Drawable cAE;
    private TextView cAF;
    private View cAG;
    private View cAH;
    private View cAI;
    private a.InterfaceC0280a cAK;
    private Activity ceC;
    private int size;
    private View cAl = null;
    private Dialog cAm = null;
    private EditText cAn = null;
    private RadioGroup cAo = null;
    private RadioGroup cAp = null;
    private CompoundButton.OnCheckedChangeListener cAq = null;
    private RadioButton cAr = null;
    private RadioButton cAs = null;
    private RadioButton cAt = null;
    private TextView cAu = null;
    private b cAv = null;
    private TextView cAw = null;
    private TextView cAx = null;
    private ProgressBar cAy = null;
    private TextView cAz = null;
    private AccountData cAA = null;
    private a cAB = null;
    private a cAC = null;
    private boolean cAJ = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.ceC = null;
        this.cAD = null;
        this.cAE = null;
        this.size = 0;
        this.ceC = activity;
        this.cAD = am.getDrawable(R.drawable.icon_tips_names_s);
        this.cAE = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.ceC.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.cAD.setBounds(0, 0, this.size, this.size);
        this.cAE.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0280a interfaceC0280a) {
        this.cAK = interfaceC0280a;
    }

    public void setAccountData(AccountData accountData) {
        this.cAA = accountData;
    }

    public void a(a aVar) {
        this.cAB = aVar;
    }

    public void b(a aVar) {
        this.cAC = aVar;
    }

    public void ast() {
        jt(0);
    }

    public void jt(int i) {
        if (this.cAm == null) {
            this.cAl = LayoutInflater.from(this.ceC).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.cAF = (TextView) this.cAl.findViewById(R.id.tip_info);
            this.cAG = this.cAl.findViewById(R.id.divider_under_account);
            this.cAH = this.cAl.findViewById(R.id.divider_under_radiongroup);
            this.cAI = this.cAl.findViewById(R.id.divider_with_yes_no_button);
            this.cAn = (EditText) this.cAl.findViewById(R.id.account);
            this.cAn.setHint(this.ceC.getString(R.string.hint_tip_input_name));
            this.cAu = (TextView) this.cAl.findViewById(R.id.back);
            this.cAu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.asx();
                    c.this.asv();
                }
            });
            this.cAx = (TextView) this.cAl.findViewById(R.id.confirm);
            this.cAx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.asu();
                }
            });
            this.cAy = (ProgressBar) this.cAl.findViewById(R.id.confirm_progress);
            this.cAw = (TextView) this.cAl.findViewById(R.id.error_info);
            this.cAo = (RadioGroup) this.cAl.findViewById(R.id.names_group1);
            this.cAp = (RadioGroup) this.cAl.findViewById(R.id.names_group2);
            this.cAr = (RadioButton) this.cAl.findViewById(R.id.name1);
            this.cAs = (RadioButton) this.cAl.findViewById(R.id.name2);
            this.cAt = (RadioButton) this.cAl.findViewById(R.id.name3);
            this.cAq = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.cAr) {
                            c.this.cAp.clearCheck();
                            c.this.cAr.setChecked(true);
                            c.this.cAr.setCompoundDrawables(c.this.cAD, null, null, null);
                            c.this.cAs.setChecked(false);
                            c.this.cAs.setCompoundDrawables(c.this.cAE, null, null, null);
                            c.this.cAt.setChecked(false);
                            c.this.cAt.setCompoundDrawables(c.this.cAE, null, null, null);
                        } else if (compoundButton == c.this.cAs) {
                            c.this.cAp.clearCheck();
                            c.this.cAr.setChecked(false);
                            c.this.cAr.setCompoundDrawables(c.this.cAE, null, null, null);
                            c.this.cAs.setChecked(true);
                            c.this.cAs.setCompoundDrawables(c.this.cAD, null, null, null);
                            c.this.cAt.setChecked(false);
                            c.this.cAt.setCompoundDrawables(c.this.cAE, null, null, null);
                        } else if (compoundButton == c.this.cAt) {
                            c.this.cAo.clearCheck();
                            c.this.cAr.setChecked(false);
                            c.this.cAr.setCompoundDrawables(c.this.cAE, null, null, null);
                            c.this.cAs.setChecked(false);
                            c.this.cAs.setCompoundDrawables(c.this.cAE, null, null, null);
                            c.this.cAt.setChecked(true);
                            c.this.cAt.setCompoundDrawables(c.this.cAD, null, null, null);
                        }
                        c.this.cAn.setText(compoundButton.getText());
                    }
                }
            };
            this.cAr.setOnCheckedChangeListener(this.cAq);
            this.cAs.setOnCheckedChangeListener(this.cAq);
            this.cAt.setOnCheckedChangeListener(this.cAq);
            this.cAz = (TextView) this.cAl.findViewById(R.id.phone_info);
            asw();
            this.cAm = new Dialog(this.ceC, R.style.input_username_dialog);
            this.cAm.setCanceledOnTouchOutside(false);
            this.cAm.setCancelable(false);
            this.cAm.setCanceledOnTouchOutside(false);
            ask();
        }
        if (i == 1) {
            this.cAz.setText(R.string.tip_init_user_name);
        } else {
            this.cAz.setText(R.string.bar_friend);
        }
        if (!this.cAm.isShowing()) {
            this.cAn.setText((CharSequence) null);
            asw();
            pd(null);
            if (!this.ceC.isFinishing()) {
                this.cAm.setContentView(this.cAl);
                g.showDialog(this.cAm, this.ceC);
                if (this.ceC instanceof BaseActivity) {
                    ((BaseActivity) this.ceC).ShowSoftKeyPadDelay(this.cAn, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0292c(this.cAn), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0292c implements Runnable {
        private View mView;

        public RunnableC0292c(View view) {
            this.mView = null;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!c.this.ceC.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) c.this.ceC.getSystemService("input_method");
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

    public void asu() {
        String obj = this.cAn.getText().toString();
        if (obj == null || obj.length() <= 0) {
            pd(this.ceC.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            pd(this.ceC.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.cAv != null) {
                this.cAv.cancel();
            }
            if (!this.cAJ && this.cAA != null) {
                this.cAy.setVisibility(0);
                this.cAx.setEnabled(false);
                pd(null);
                asw();
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
                        c.this.asx();
                        l.showToast(c.this.ceC, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.agp().a(session.username, session.bduss, "", null, c.this.cAK);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.pd(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.cAJ = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cAy.setVisibility(8);
                        c.this.cAx.setEnabled(true);
                        c.this.cAJ = false;
                    }
                }, this.cAA.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asv() {
        if (this.cAC != null) {
            this.cAC.g(null);
        }
    }

    public void y(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            pd(this.ceC.getString(R.string.suggest_no_name));
            return;
        }
        pd(this.ceC.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.cAo.clearCheck();
        this.cAp.clearCheck();
        this.cAo.setVisibility(0);
        this.cAp.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.cAr.setText(arrayList.get(0));
            this.cAr.setChecked(false);
            this.cAr.setCompoundDrawables(this.cAE, null, null, null);
            this.cAr.setVisibility(0);
            this.cAo.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.cAs.setText(arrayList.get(1));
            this.cAs.setChecked(false);
            this.cAs.setCompoundDrawables(this.cAE, null, null, null);
            this.cAs.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.cAt.setText(arrayList.get(2));
            this.cAt.setChecked(false);
            this.cAt.setCompoundDrawables(this.cAE, null, null, null);
            this.cAt.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cAv != null) {
            this.cAv.cancel();
            this.cAv = null;
        }
        asx();
    }

    public void asw() {
        this.cAo.setVisibility(8);
        this.cAo.clearCheck();
        this.cAp.setVisibility(8);
        this.cAp.clearCheck();
        this.cAr.setVisibility(8);
        this.cAs.setVisibility(8);
        this.cAt.setVisibility(8);
        this.cAr.setChecked(false);
        this.cAs.setChecked(false);
        this.cAt.setChecked(false);
    }

    public void asx() {
        if (this.cAm != null && this.cAm.isShowing()) {
            g.dismissDialog(this.cAm, this.ceC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pd(String str) {
        if (str == null) {
            this.cAw.setVisibility(4);
            this.cAw.setText((CharSequence) null);
            return;
        }
        this.cAw.setVisibility(0);
        this.cAw.setText(str);
    }

    private void ask() {
        am.setBackgroundResource(this.cAl, R.drawable.dialog_background);
        am.setViewTextColor(this.cAz, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cAF, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.cAn, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.cAG, R.drawable.bg_search_input);
        am.setViewTextColor(this.cAw, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.cAr, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cAs, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cAt, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.cAH, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cAu, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.cAu, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.cAI, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cAx, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.cAx, (int) R.color.cp_link_tip_a);
        this.cAn.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.cAr.setCompoundDrawables(this.cAE, null, null, null);
        this.cAs.setCompoundDrawables(this.cAE, null, null, null);
        this.cAt.setCompoundDrawables(this.cAE, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cAL;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cAL.cAv = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public j doInBackground(String... strArr) {
            this.mNetwork = new x(this.mUrl);
            this.mNetwork.addPostData("un", this.mAccount);
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.isNetSuccess() || this.mNetwork.getServerErrorCode() != 36) {
                return null;
            }
            j jVar = new j();
            jVar.parserJson(postNetData);
            return jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            this.cAL.cAv = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.cAL.pd(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.cAL.pd(this.cAL.ceC.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.cAL.pd(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cAL.y(jVar.ape());
                }
            } else {
                this.cAL.pd(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cAL.pd(null);
            this.cAL.asw();
            super.onPreExecute();
        }
    }
}
