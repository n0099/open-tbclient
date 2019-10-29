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
    private a.InterfaceC0280a cBB;
    private Drawable cBu;
    private Drawable cBv;
    private TextView cBw;
    private View cBx;
    private View cBy;
    private View cBz;
    private Activity cft;
    private int size;
    private View cBc = null;
    private Dialog cBd = null;
    private EditText cBe = null;
    private RadioGroup cBf = null;
    private RadioGroup cBg = null;
    private CompoundButton.OnCheckedChangeListener cBh = null;
    private RadioButton cBi = null;
    private RadioButton cBj = null;
    private RadioButton cBk = null;
    private TextView cBl = null;
    private b cBm = null;
    private TextView cBn = null;
    private TextView cBo = null;
    private ProgressBar cBp = null;
    private TextView cBq = null;
    private AccountData cBr = null;
    private a cBs = null;
    private a cBt = null;
    private boolean cBA = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.cft = null;
        this.cBu = null;
        this.cBv = null;
        this.size = 0;
        this.cft = activity;
        this.cBu = am.getDrawable(R.drawable.icon_tips_names_s);
        this.cBv = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.cft.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.cBu.setBounds(0, 0, this.size, this.size);
        this.cBv.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0280a interfaceC0280a) {
        this.cBB = interfaceC0280a;
    }

    public void setAccountData(AccountData accountData) {
        this.cBr = accountData;
    }

    public void a(a aVar) {
        this.cBs = aVar;
    }

    public void b(a aVar) {
        this.cBt = aVar;
    }

    public void asv() {
        ju(0);
    }

    public void ju(int i) {
        if (this.cBd == null) {
            this.cBc = LayoutInflater.from(this.cft).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.cBw = (TextView) this.cBc.findViewById(R.id.tip_info);
            this.cBx = this.cBc.findViewById(R.id.divider_under_account);
            this.cBy = this.cBc.findViewById(R.id.divider_under_radiongroup);
            this.cBz = this.cBc.findViewById(R.id.divider_with_yes_no_button);
            this.cBe = (EditText) this.cBc.findViewById(R.id.account);
            this.cBe.setHint(this.cft.getString(R.string.hint_tip_input_name));
            this.cBl = (TextView) this.cBc.findViewById(R.id.back);
            this.cBl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.asz();
                    c.this.asx();
                }
            });
            this.cBo = (TextView) this.cBc.findViewById(R.id.confirm);
            this.cBo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.asw();
                }
            });
            this.cBp = (ProgressBar) this.cBc.findViewById(R.id.confirm_progress);
            this.cBn = (TextView) this.cBc.findViewById(R.id.error_info);
            this.cBf = (RadioGroup) this.cBc.findViewById(R.id.names_group1);
            this.cBg = (RadioGroup) this.cBc.findViewById(R.id.names_group2);
            this.cBi = (RadioButton) this.cBc.findViewById(R.id.name1);
            this.cBj = (RadioButton) this.cBc.findViewById(R.id.name2);
            this.cBk = (RadioButton) this.cBc.findViewById(R.id.name3);
            this.cBh = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.cBi) {
                            c.this.cBg.clearCheck();
                            c.this.cBi.setChecked(true);
                            c.this.cBi.setCompoundDrawables(c.this.cBu, null, null, null);
                            c.this.cBj.setChecked(false);
                            c.this.cBj.setCompoundDrawables(c.this.cBv, null, null, null);
                            c.this.cBk.setChecked(false);
                            c.this.cBk.setCompoundDrawables(c.this.cBv, null, null, null);
                        } else if (compoundButton == c.this.cBj) {
                            c.this.cBg.clearCheck();
                            c.this.cBi.setChecked(false);
                            c.this.cBi.setCompoundDrawables(c.this.cBv, null, null, null);
                            c.this.cBj.setChecked(true);
                            c.this.cBj.setCompoundDrawables(c.this.cBu, null, null, null);
                            c.this.cBk.setChecked(false);
                            c.this.cBk.setCompoundDrawables(c.this.cBv, null, null, null);
                        } else if (compoundButton == c.this.cBk) {
                            c.this.cBf.clearCheck();
                            c.this.cBi.setChecked(false);
                            c.this.cBi.setCompoundDrawables(c.this.cBv, null, null, null);
                            c.this.cBj.setChecked(false);
                            c.this.cBj.setCompoundDrawables(c.this.cBv, null, null, null);
                            c.this.cBk.setChecked(true);
                            c.this.cBk.setCompoundDrawables(c.this.cBu, null, null, null);
                        }
                        c.this.cBe.setText(compoundButton.getText());
                    }
                }
            };
            this.cBi.setOnCheckedChangeListener(this.cBh);
            this.cBj.setOnCheckedChangeListener(this.cBh);
            this.cBk.setOnCheckedChangeListener(this.cBh);
            this.cBq = (TextView) this.cBc.findViewById(R.id.phone_info);
            asy();
            this.cBd = new Dialog(this.cft, R.style.input_username_dialog);
            this.cBd.setCanceledOnTouchOutside(false);
            this.cBd.setCancelable(false);
            this.cBd.setCanceledOnTouchOutside(false);
            asm();
        }
        if (i == 1) {
            this.cBq.setText(R.string.tip_init_user_name);
        } else {
            this.cBq.setText(R.string.bar_friend);
        }
        if (!this.cBd.isShowing()) {
            this.cBe.setText((CharSequence) null);
            asy();
            pd(null);
            if (!this.cft.isFinishing()) {
                this.cBd.setContentView(this.cBc);
                g.showDialog(this.cBd, this.cft);
                if (this.cft instanceof BaseActivity) {
                    ((BaseActivity) this.cft).ShowSoftKeyPadDelay(this.cBe, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0292c(this.cBe), 150L);
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
            if (!c.this.cft.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) c.this.cft.getSystemService("input_method");
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

    public void asw() {
        String obj = this.cBe.getText().toString();
        if (obj == null || obj.length() <= 0) {
            pd(this.cft.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            pd(this.cft.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.cBm != null) {
                this.cBm.cancel();
            }
            if (!this.cBA && this.cBr != null) {
                this.cBp.setVisibility(0);
                this.cBo.setEnabled(false);
                pd(null);
                asy();
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
                        c.this.asz();
                        l.showToast(c.this.cft, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.agr().a(session.username, session.bduss, "", null, c.this.cBB);
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
                        c.this.cBA = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.cBp.setVisibility(8);
                        c.this.cBo.setEnabled(true);
                        c.this.cBA = false;
                    }
                }, this.cBr.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asx() {
        if (this.cBt != null) {
            this.cBt.g(null);
        }
    }

    public void y(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            pd(this.cft.getString(R.string.suggest_no_name));
            return;
        }
        pd(this.cft.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.cBf.clearCheck();
        this.cBg.clearCheck();
        this.cBf.setVisibility(0);
        this.cBg.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.cBi.setText(arrayList.get(0));
            this.cBi.setChecked(false);
            this.cBi.setCompoundDrawables(this.cBv, null, null, null);
            this.cBi.setVisibility(0);
            this.cBf.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.cBj.setText(arrayList.get(1));
            this.cBj.setChecked(false);
            this.cBj.setCompoundDrawables(this.cBv, null, null, null);
            this.cBj.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.cBk.setText(arrayList.get(2));
            this.cBk.setChecked(false);
            this.cBk.setCompoundDrawables(this.cBv, null, null, null);
            this.cBk.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.cBm != null) {
            this.cBm.cancel();
            this.cBm = null;
        }
        asz();
    }

    public void asy() {
        this.cBf.setVisibility(8);
        this.cBf.clearCheck();
        this.cBg.setVisibility(8);
        this.cBg.clearCheck();
        this.cBi.setVisibility(8);
        this.cBj.setVisibility(8);
        this.cBk.setVisibility(8);
        this.cBi.setChecked(false);
        this.cBj.setChecked(false);
        this.cBk.setChecked(false);
    }

    public void asz() {
        if (this.cBd != null && this.cBd.isShowing()) {
            g.dismissDialog(this.cBd, this.cft);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pd(String str) {
        if (str == null) {
            this.cBn.setVisibility(4);
            this.cBn.setText((CharSequence) null);
            return;
        }
        this.cBn.setVisibility(0);
        this.cBn.setText(str);
    }

    private void asm() {
        am.setBackgroundResource(this.cBc, R.drawable.dialog_background);
        am.setViewTextColor(this.cBq, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cBw, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.cBe, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.cBx, R.drawable.bg_search_input);
        am.setViewTextColor(this.cBn, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.cBi, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cBj, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.cBk, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.cBy, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cBl, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.cBl, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.cBz, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cBo, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.cBo, (int) R.color.cp_link_tip_a);
        this.cBe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.cBi.setCompoundDrawables(this.cBv, null, null, null);
        this.cBj.setCompoundDrawables(this.cBv, null, null, null);
        this.cBk.setCompoundDrawables(this.cBv, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c cBC;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.cBC.cBm = null;
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
            this.cBC.cBm = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.cBC.pd(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.cBC.pd(this.cBC.cft.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.cBC.pd(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.cBC.y(jVar.apg());
                }
            } else {
                this.cBC.pd(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.cBC.pd(null);
            this.cBC.asy();
            super.onPreExecute();
        }
    }
}
