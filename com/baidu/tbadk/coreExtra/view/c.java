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
    private Drawable dok;
    private Drawable dol;
    private TextView dom;
    private View don;
    private View doo;
    private View dop;
    private a.InterfaceC0363a dor;
    private Activity mContext;
    private int size;
    private View dnR = null;
    private Dialog dnS = null;
    private EditText dnT = null;
    private RadioGroup dnU = null;
    private RadioGroup dnV = null;
    private CompoundButton.OnCheckedChangeListener dnW = null;
    private RadioButton dnX = null;
    private RadioButton dnY = null;
    private RadioButton dnZ = null;
    private TextView doa = null;
    private b dob = null;
    private TextView dod = null;
    private TextView doe = null;
    private ProgressBar dof = null;
    private TextView dog = null;
    private AccountData doh = null;
    private a doi = null;
    private a doj = null;
    private boolean doq = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public c(Activity activity) {
        this.mContext = null;
        this.dok = null;
        this.dol = null;
        this.size = 0;
        this.mContext = activity;
        this.dok = am.getDrawable(R.drawable.icon_tips_names_s);
        this.dol = am.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.dok.setBounds(0, 0, this.size, this.size);
        this.dol.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0363a interfaceC0363a) {
        this.dor = interfaceC0363a;
    }

    public void setAccountData(AccountData accountData) {
        this.doh = accountData;
    }

    public void a(a aVar) {
        this.doi = aVar;
    }

    public void b(a aVar) {
        this.doj = aVar;
    }

    public void aJS() {
        lG(0);
    }

    public void lG(int i) {
        if (this.dnS == null) {
            this.dnR = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.dom = (TextView) this.dnR.findViewById(R.id.tip_info);
            this.don = this.dnR.findViewById(R.id.divider_under_account);
            this.doo = this.dnR.findViewById(R.id.divider_under_radiongroup);
            this.dop = this.dnR.findViewById(R.id.divider_with_yes_no_button);
            this.dnT = (EditText) this.dnR.findViewById(R.id.account);
            this.dnT.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.doa = (TextView) this.dnR.findViewById(R.id.back);
            this.doa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aJW();
                    c.this.aJU();
                }
            });
            this.doe = (TextView) this.dnR.findViewById(R.id.confirm);
            this.doe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    c.this.aJT();
                }
            });
            this.dof = (ProgressBar) this.dnR.findViewById(R.id.confirm_progress);
            this.dod = (TextView) this.dnR.findViewById(R.id.error_info);
            this.dnU = (RadioGroup) this.dnR.findViewById(R.id.names_group1);
            this.dnV = (RadioGroup) this.dnR.findViewById(R.id.names_group2);
            this.dnX = (RadioButton) this.dnR.findViewById(R.id.name1);
            this.dnY = (RadioButton) this.dnR.findViewById(R.id.name2);
            this.dnZ = (RadioButton) this.dnR.findViewById(R.id.name3);
            this.dnW = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.c.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == c.this.dnX) {
                            c.this.dnV.clearCheck();
                            c.this.dnX.setChecked(true);
                            c.this.dnX.setCompoundDrawables(c.this.dok, null, null, null);
                            c.this.dnY.setChecked(false);
                            c.this.dnY.setCompoundDrawables(c.this.dol, null, null, null);
                            c.this.dnZ.setChecked(false);
                            c.this.dnZ.setCompoundDrawables(c.this.dol, null, null, null);
                        } else if (compoundButton == c.this.dnY) {
                            c.this.dnV.clearCheck();
                            c.this.dnX.setChecked(false);
                            c.this.dnX.setCompoundDrawables(c.this.dol, null, null, null);
                            c.this.dnY.setChecked(true);
                            c.this.dnY.setCompoundDrawables(c.this.dok, null, null, null);
                            c.this.dnZ.setChecked(false);
                            c.this.dnZ.setCompoundDrawables(c.this.dol, null, null, null);
                        } else if (compoundButton == c.this.dnZ) {
                            c.this.dnU.clearCheck();
                            c.this.dnX.setChecked(false);
                            c.this.dnX.setCompoundDrawables(c.this.dol, null, null, null);
                            c.this.dnY.setChecked(false);
                            c.this.dnY.setCompoundDrawables(c.this.dol, null, null, null);
                            c.this.dnZ.setChecked(true);
                            c.this.dnZ.setCompoundDrawables(c.this.dok, null, null, null);
                        }
                        c.this.dnT.setText(compoundButton.getText());
                    }
                }
            };
            this.dnX.setOnCheckedChangeListener(this.dnW);
            this.dnY.setOnCheckedChangeListener(this.dnW);
            this.dnZ.setOnCheckedChangeListener(this.dnW);
            this.dog = (TextView) this.dnR.findViewById(R.id.phone_info);
            aJV();
            this.dnS = new Dialog(this.mContext, R.style.input_username_dialog);
            this.dnS.setCanceledOnTouchOutside(false);
            this.dnS.setCancelable(false);
            this.dnS.setCanceledOnTouchOutside(false);
            aJJ();
        }
        if (i == 1) {
            this.dog.setText(R.string.tip_init_user_name);
        } else {
            this.dog.setText(R.string.bar_friend);
        }
        if (!this.dnS.isShowing()) {
            this.dnT.setText((CharSequence) null);
            aJV();
            uh(null);
            if (!this.mContext.isFinishing()) {
                this.dnS.setContentView(this.dnR);
                g.showDialog(this.dnS, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.dnT, 150);
                } else {
                    new Handler().postDelayed(new RunnableC0375c(this.dnT), 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0375c implements Runnable {
        private View mView;

        public RunnableC0375c(View view) {
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

    public void aJT() {
        String obj = this.dnT.getText().toString();
        if (obj == null || obj.length() <= 0) {
            uh(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            uh(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.dob != null) {
                this.dob.cancel();
            }
            if (!this.doq && this.doh != null) {
                this.dof.setVisibility(0);
                this.doe.setEnabled(false);
                uh(null);
                aJV();
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
                        c.this.aJW();
                        l.showToast(c.this.mContext, (int) R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.axg().a(session.username, session.bduss, "", null, c.this.dor);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            c.this.uh(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        c.this.doq = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        c.this.dof.setVisibility(8);
                        c.this.doe.setEnabled(true);
                        c.this.doq = false;
                    }
                }, this.doh.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJU() {
        if (this.doj != null) {
            this.doj.g(null);
        }
    }

    public void B(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            uh(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        uh(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.dnU.clearCheck();
        this.dnV.clearCheck();
        this.dnU.setVisibility(0);
        this.dnV.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.dnX.setText(arrayList.get(0));
            this.dnX.setChecked(false);
            this.dnX.setCompoundDrawables(this.dol, null, null, null);
            this.dnX.setVisibility(0);
            this.dnU.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.dnY.setText(arrayList.get(1));
            this.dnY.setChecked(false);
            this.dnY.setCompoundDrawables(this.dol, null, null, null);
            this.dnY.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.dnZ.setText(arrayList.get(2));
            this.dnZ.setChecked(false);
            this.dnZ.setCompoundDrawables(this.dol, null, null, null);
            this.dnZ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.dob != null) {
            this.dob.cancel();
            this.dob = null;
        }
        aJW();
    }

    public void aJV() {
        this.dnU.setVisibility(8);
        this.dnU.clearCheck();
        this.dnV.setVisibility(8);
        this.dnV.clearCheck();
        this.dnX.setVisibility(8);
        this.dnY.setVisibility(8);
        this.dnZ.setVisibility(8);
        this.dnX.setChecked(false);
        this.dnY.setChecked(false);
        this.dnZ.setChecked(false);
    }

    public void aJW() {
        if (this.dnS != null && this.dnS.isShowing()) {
            g.dismissDialog(this.dnS, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(String str) {
        if (str == null) {
            this.dod.setVisibility(4);
            this.dod.setText((CharSequence) null);
            return;
        }
        this.dod.setVisibility(0);
        this.dod.setText(str);
    }

    private void aJJ() {
        am.setBackgroundResource(this.dnR, R.drawable.dialog_background);
        am.setViewTextColor(this.dog, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dom, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.dnT, (int) R.color.cp_cont_b);
        am.setBackgroundResource(this.don, R.drawable.bg_search_input);
        am.setViewTextColor(this.dod, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.dnX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dnY, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.dnZ, (int) R.color.cp_cont_b);
        am.setBackgroundColor(this.doo, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.doa, R.drawable.dialog_left_button_selector);
        am.setViewTextColor(this.doa, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.dop, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.doe, R.drawable.dialog_right_button_selector);
        am.setViewTextColor(this.doe, (int) R.color.cp_link_tip_a);
        this.dnT.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.dnX.setCompoundDrawables(this.dol, null, null, null);
        this.dnY.setCompoundDrawables(this.dol, null, null, null);
        this.dnZ.setCompoundDrawables(this.dol, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, j> {
        final /* synthetic */ c dos;
        private String mAccount;
        private x mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.dos.dob = null;
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
            this.dos.dob = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.dos.uh(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.dos.uh(this.dos.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.dos.uh(this.mNetwork.getErrorString());
                if (jVar != null) {
                    this.dos.B(jVar.aGE());
                }
            } else {
                this.dos.uh(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.dos.uh(null);
            this.dos.aJV();
            super.onPreExecute();
        }
    }
}
