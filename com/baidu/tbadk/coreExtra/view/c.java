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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private View doA;
    private View doB;
    private a.InterfaceC0365a doD;
    private Drawable dow;
    private Drawable dox;
    private TextView doy;
    private View doz;
    private Activity mContext;
    private int size;
    private View dod = null;
    private Dialog doe = null;
    private EditText dof = null;
    private RadioGroup dog = null;
    private RadioGroup doh = null;
    private CompoundButton.OnCheckedChangeListener doi = null;
    private RadioButton doj = null;
    private RadioButton dok = null;
    private RadioButton dol = null;
    private TextView dom = null;
    private b don = null;
    private TextView doo = null;
    private TextView dop = null;
    private ProgressBar doq = null;
    private TextView dor = null;
    private AccountData dos = null;
    private a dou = null;
    private a dov = null;
    private boolean doC = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.dow = null;
        this.dox = null;
        this.size = 0;
        this.mContext = activity;
        this.dow = am.getDrawable(R.drawable.icon_tips_names_s);
        this.dox = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.dow.setBounds(0, 0, this.size, this.size);
        this.dox.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0365a interfaceC0365a) {
        this.doD = interfaceC0365a;
    }

    public void setAccountData(AccountData accountData) {
        this.dos = accountData;
    }

    public void a(a aVar) {
        this.dou = aVar;
    }

    public void b(a aVar) {
        this.dov = aVar;
    }

    public void aKl() {
        lG(0);
    }

    public void lG(int i) {
        if (this.doe == null) {
            this.dod = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.doy = (TextView) this.dod.findViewById(R.id.tip_info);
            this.doz = this.dod.findViewById(R.id.divider_under_account);
            this.doA = this.dod.findViewById(R.id.divider_under_radiongroup);
            this.doB = this.dod.findViewById(R.id.divider_with_yes_no_button);
            this.dof = (EditText) this.dod.findViewById(R.id.account);
            this.dof.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.dom = (TextView) this.dod.findViewById(R.id.back);
            this.dom.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aKp();
                    c.this.aKn();
                }
            });
            this.dop = (TextView) this.dod.findViewById(R.id.confirm);
            this.dop.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aKm();
                }
            });
            this.doq = (ProgressBar) this.dod.findViewById(R.id.confirm_progress);
            this.doo = (TextView) this.dod.findViewById(R.id.error_info);
            this.dog = (RadioGroup) this.dod.findViewById(R.id.names_group1);
            this.doh = (RadioGroup) this.dod.findViewById(R.id.names_group2);
            this.doj = (RadioButton) this.dod.findViewById(R.id.name1);
            this.dok = (RadioButton) this.dod.findViewById(R.id.name2);
            this.dol = (RadioButton) this.dod.findViewById(R.id.name3);
            this.doi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.doj) {
                            c.this.doh.clearCheck();
                            c.this.doj.setChecked(true);
                            c.this.doj.setCompoundDrawables(c.this.dow, null, null, null);
                            c.this.dok.setChecked(false);
                            c.this.dok.setCompoundDrawables(c.this.dox, null, null, null);
                            c.this.dol.setChecked(false);
                            c.this.dol.setCompoundDrawables(c.this.dox, null, null, null);
                        } else if (compoundButton == c.this.dok) {
                            c.this.doh.clearCheck();
                            c.this.doj.setChecked(false);
                            c.this.doj.setCompoundDrawables(c.this.dox, null, null, null);
                            c.this.dok.setChecked(true);
                            c.this.dok.setCompoundDrawables(c.this.dow, null, null, null);
                            c.this.dol.setChecked(false);
                            c.this.dol.setCompoundDrawables(c.this.dox, null, null, null);
                        } else if (compoundButton == c.this.dol) {
                            c.this.dog.clearCheck();
                            c.this.doj.setChecked(false);
                            c.this.doj.setCompoundDrawables(c.this.dox, null, null, null);
                            c.this.dok.setChecked(false);
                            c.this.dok.setCompoundDrawables(c.this.dox, null, null, null);
                            c.this.dol.setChecked(true);
                            c.this.dol.setCompoundDrawables(c.this.dow, null, null, null);
                        }
                        c.this.dof.setText(compoundButton.getText());
                    }
                }
            };
            this.doj.setOnCheckedChangeListener(this.doi);
            this.dok.setOnCheckedChangeListener(this.doi);
            this.dol.setOnCheckedChangeListener(this.doi);
            this.dor = (TextView) this.dod.findViewById(R.id.phone_info);
            aKo();
            this.doe = new Dialog(this.mContext, R.style.input_username_dialog);
            this.doe.setCanceledOnTouchOutside(false);
            this.doe.setCancelable(false);
            this.doe.setCanceledOnTouchOutside(false);
            aKd();
        }
        if (i == 1) {
            this.dor.setText(R.string.tip_init_user_name);
        } else {
            this.dor.setText(R.string.bar_friend);
        }
        if (!this.doe.isShowing()) {
            this.dof.setText((CharSequence) null);
            aKo();
            um(null);
            if (!this.mContext.isFinishing()) {
                this.doe.setContentView(this.dod);
                g.showDialog(this.doe, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.dof, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0377c(this.dof), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0377c implements Runnable {
        private View mView;

        public RunnableC0377c(View view) {
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

    public void aKm() {
        String obj = this.dof.getText().toString();
        if (obj == null || obj.length() <= 0) {
            um(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            um(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.don != null) {
                this.don.cancel();
            }
            if (!this.doC && this.dos != null) {
                this.doq.setVisibility(0);
                this.dop.setEnabled(false);
                um(null);
                aKo();
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
                        c.this.aKp();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.axz().a(session.username, session.bduss, "", null, c.this.doD);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.um(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.doC = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.doq.setVisibility(8);
                        c.this.dop.setEnabled(true);
                        c.this.doC = false;
                    }
                }, this.dos.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKn() {
        if (this.dov != null) {
            this.dov.g(null);
        }
    }

    public void B(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            um(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        um(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.dog.clearCheck();
        this.doh.clearCheck();
        this.dog.setVisibility(0);
        this.doh.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.doj.setText(arrayList.get(0));
            this.doj.setChecked(false);
            this.doj.setCompoundDrawables(this.dox, null, null, null);
            this.doj.setVisibility(0);
            this.dog.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.dok.setText(arrayList.get(1));
            this.dok.setChecked(false);
            this.dok.setCompoundDrawables(this.dox, null, null, null);
            this.dok.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.dol.setText(arrayList.get(2));
            this.dol.setChecked(false);
            this.dol.setCompoundDrawables(this.dox, null, null, null);
            this.dol.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.don != null) {
            this.don.cancel();
            this.don = null;
        }
        aKp();
    }

    public void aKo() {
        this.dog.setVisibility(8);
        this.dog.clearCheck();
        this.doh.setVisibility(8);
        this.doh.clearCheck();
        this.doj.setVisibility(8);
        this.dok.setVisibility(8);
        this.dol.setVisibility(8);
        this.doj.setChecked(false);
        this.dok.setChecked(false);
        this.dol.setChecked(false);
    }

    public void aKp() {
        if (this.doe != null && this.doe.isShowing()) {
            g.dismissDialog(this.doe, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um(String str) {
        if (str == null) {
            this.doo.setVisibility(4);
            this.doo.setText((CharSequence) null);
            return;
        }
        this.doo.setVisibility(0);
        this.doo.setText(str);
    }

    private void aKd() {
        am.setBackgroundResource(this.dod, R.drawable.dialog_background);
        am.setViewTextColor(this.dor, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.doy, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dof, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.doz, R.drawable.bg_search_input);
        am.setViewTextColor(this.doo, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.doj, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dok, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dol, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.doA, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dom, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.dom, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.doB, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dop, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.dop, (int) R.color.cp_link_tip_a);
        this.dof.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.doj.setCompoundDrawables(this.dox, null, null, null);
        this.dok.setCompoundDrawables(this.dox, null, null, null);
        this.dol.setCompoundDrawables(this.dox, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c doE;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.doE.don = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: w */
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
            this.doE.don = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.doE.um(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.doE.um(this.doE.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.doE.um(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.doE.B(jVar.aGX());
                }
            } else {
                this.doE.um(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.doE.um(null);
            this.doE.aKo();
            super.onPreExecute();
        }
    }
}
