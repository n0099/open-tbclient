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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private Drawable fzL;
    private Drawable fzM;
    private TextView fzN;
    private View fzO;
    private View fzP;
    private View fzQ;
    private a.InterfaceC0575a fzS;
    private Activity mContext;
    private int size;
    private View fzu = null;
    private Dialog fzv = null;
    private EditText fzw = null;
    private RadioGroup fzx = null;
    private RadioGroup fzy = null;
    private CompoundButton.OnCheckedChangeListener fzz = null;
    private RadioButton fzA = null;
    private RadioButton fzB = null;
    private RadioButton fzC = null;
    private TextView fzD = null;
    private C0591b fzE = null;
    private TextView fzF = null;
    private TextView bYS = null;
    private ProgressBar fzG = null;
    private TextView fzH = null;
    private AccountData fzI = null;
    private a fzJ = null;
    private a fzK = null;
    private boolean fzR = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.mContext = null;
        this.fzL = null;
        this.fzM = null;
        this.size = 0;
        this.mContext = activity;
        this.fzL = ao.getDrawable(R.drawable.icon_tips_names_s);
        this.fzM = ao.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.fzL.setBounds(0, 0, this.size, this.size);
        this.fzM.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0575a interfaceC0575a) {
        this.fzS = interfaceC0575a;
    }

    public void setAccountData(AccountData accountData) {
        this.fzI = accountData;
    }

    public void a(a aVar) {
        this.fzJ = aVar;
    }

    public void b(a aVar) {
        this.fzK = aVar;
    }

    public void bCY() {
        se(0);
    }

    public void se(int i) {
        if (this.fzv == null) {
            this.fzu = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.fzN = (TextView) this.fzu.findViewById(R.id.tip_info);
            this.fzO = this.fzu.findViewById(R.id.divider_under_account);
            this.fzP = this.fzu.findViewById(R.id.divider_under_radiongroup);
            this.fzQ = this.fzu.findViewById(R.id.divider_with_yes_no_button);
            this.fzw = (EditText) this.fzu.findViewById(R.id.account);
            this.fzw.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.fzD = (TextView) this.fzu.findViewById(R.id.back);
            this.fzD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bDc();
                    b.this.bDa();
                }
            });
            this.bYS = (TextView) this.fzu.findViewById(R.id.confirm);
            this.bYS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bCZ();
                }
            });
            this.fzG = (ProgressBar) this.fzu.findViewById(R.id.confirm_progress);
            this.fzF = (TextView) this.fzu.findViewById(R.id.error_info);
            this.fzx = (RadioGroup) this.fzu.findViewById(R.id.names_group1);
            this.fzy = (RadioGroup) this.fzu.findViewById(R.id.names_group2);
            this.fzA = (RadioButton) this.fzu.findViewById(R.id.name1);
            this.fzB = (RadioButton) this.fzu.findViewById(R.id.name2);
            this.fzC = (RadioButton) this.fzu.findViewById(R.id.name3);
            this.fzz = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.fzA) {
                            b.this.fzy.clearCheck();
                            b.this.fzA.setChecked(true);
                            b.this.fzA.setCompoundDrawables(b.this.fzL, null, null, null);
                            b.this.fzB.setChecked(false);
                            b.this.fzB.setCompoundDrawables(b.this.fzM, null, null, null);
                            b.this.fzC.setChecked(false);
                            b.this.fzC.setCompoundDrawables(b.this.fzM, null, null, null);
                        } else if (compoundButton == b.this.fzB) {
                            b.this.fzy.clearCheck();
                            b.this.fzA.setChecked(false);
                            b.this.fzA.setCompoundDrawables(b.this.fzM, null, null, null);
                            b.this.fzB.setChecked(true);
                            b.this.fzB.setCompoundDrawables(b.this.fzL, null, null, null);
                            b.this.fzC.setChecked(false);
                            b.this.fzC.setCompoundDrawables(b.this.fzM, null, null, null);
                        } else if (compoundButton == b.this.fzC) {
                            b.this.fzx.clearCheck();
                            b.this.fzA.setChecked(false);
                            b.this.fzA.setCompoundDrawables(b.this.fzM, null, null, null);
                            b.this.fzB.setChecked(false);
                            b.this.fzB.setCompoundDrawables(b.this.fzM, null, null, null);
                            b.this.fzC.setChecked(true);
                            b.this.fzC.setCompoundDrawables(b.this.fzL, null, null, null);
                        }
                        b.this.fzw.setText(compoundButton.getText());
                    }
                }
            };
            this.fzA.setOnCheckedChangeListener(this.fzz);
            this.fzB.setOnCheckedChangeListener(this.fzz);
            this.fzC.setOnCheckedChangeListener(this.fzz);
            this.fzH = (TextView) this.fzu.findViewById(R.id.phone_info);
            bDb();
            this.fzv = new Dialog(this.mContext, R.style.input_username_dialog);
            this.fzv.setCanceledOnTouchOutside(false);
            this.fzv.setCancelable(false);
            this.fzv.setCanceledOnTouchOutside(false);
            bCP();
        }
        if (i == 1) {
            this.fzH.setText(R.string.tip_init_user_name);
        } else {
            this.fzH.setText(R.string.bar_friend);
        }
        if (!this.fzv.isShowing()) {
            this.fzw.setText((CharSequence) null);
            bDb();
            Dk(null);
            if (!this.mContext.isFinishing()) {
                this.fzv.setContentView(this.fzu);
                g.showDialog(this.fzv, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.fzw, 150);
                } else {
                    new Handler().postDelayed(new c(this.fzw), 150L);
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
            if (!b.this.mContext.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.mContext.getSystemService("input_method");
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

    public void bCZ() {
        String obj = this.fzw.getText().toString();
        if (obj == null || obj.length() <= 0) {
            Dk(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            Dk(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.fzE != null) {
                this.fzE.cancel();
            }
            if (!this.fzR && this.fzI != null) {
                this.fzG.setVisibility(0);
                this.bYS.setEnabled(false);
                Dk(null);
                bDb();
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
                        b.this.bDc();
                        l.showToast(b.this.mContext, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bow().a(session.username, session.bduss, "", null, b.this.fzS);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.Dk(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.fzR = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.fzG.setVisibility(8);
                        b.this.bYS.setEnabled(true);
                        b.this.fzR = false;
                    }
                }, this.fzI.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDa() {
        if (this.fzK != null) {
            this.fzK.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            Dk(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        Dk(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.fzx.clearCheck();
        this.fzy.clearCheck();
        this.fzx.setVisibility(0);
        this.fzy.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.fzA.setText(arrayList.get(0));
            this.fzA.setChecked(false);
            this.fzA.setCompoundDrawables(this.fzM, null, null, null);
            this.fzA.setVisibility(0);
            this.fzx.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.fzB.setText(arrayList.get(1));
            this.fzB.setChecked(false);
            this.fzB.setCompoundDrawables(this.fzM, null, null, null);
            this.fzB.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.fzC.setText(arrayList.get(2));
            this.fzC.setChecked(false);
            this.fzC.setCompoundDrawables(this.fzM, null, null, null);
            this.fzC.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.fzE != null) {
            this.fzE.cancel();
            this.fzE = null;
        }
        bDc();
    }

    public void bDb() {
        this.fzx.setVisibility(8);
        this.fzx.clearCheck();
        this.fzy.setVisibility(8);
        this.fzy.clearCheck();
        this.fzA.setVisibility(8);
        this.fzB.setVisibility(8);
        this.fzC.setVisibility(8);
        this.fzA.setChecked(false);
        this.fzB.setChecked(false);
        this.fzC.setChecked(false);
    }

    public void bDc() {
        if (this.fzv != null && this.fzv.isShowing()) {
            g.dismissDialog(this.fzv, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dk(String str) {
        if (str == null) {
            this.fzF.setVisibility(4);
            this.fzF.setText((CharSequence) null);
            return;
        }
        this.fzF.setVisibility(0);
        this.fzF.setText(str);
    }

    private void bCP() {
        ao.setBackgroundResource(this.fzu, R.drawable.dialog_background);
        ao.setViewTextColor(this.fzH, R.color.CAM_X0105);
        ao.setViewTextColor(this.fzN, R.color.CAM_X0106);
        ao.setViewTextColor(this.fzw, R.color.CAM_X0105);
        ao.setBackgroundResource(this.fzO, R.drawable.bg_search_input);
        ao.setViewTextColor(this.fzF, R.color.CAM_X0301);
        ao.setViewTextColor(this.fzA, R.color.CAM_X0105);
        ao.setViewTextColor(this.fzB, R.color.CAM_X0105);
        ao.setViewTextColor(this.fzC, R.color.CAM_X0105);
        ao.setBackgroundColor(this.fzP, R.color.CAM_X0204);
        ao.setBackgroundResource(this.fzD, R.drawable.dialog_left_button_selector);
        ao.setViewTextColor(this.fzD, R.color.CAM_X0302);
        ao.setBackgroundColor(this.fzQ, R.color.CAM_X0204);
        ao.setBackgroundResource(this.bYS, R.drawable.dialog_right_button_selector);
        ao.setViewTextColor(this.bYS, R.color.CAM_X0302);
        this.fzw.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        this.fzA.setCompoundDrawables(this.fzM, null, null, null);
        this.fzB.setCompoundDrawables(this.fzM, null, null, null);
        this.fzC.setCompoundDrawables(this.fzM, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0591b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b fzT;
        private String mAccount;
        private z mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.fzT.fzE = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public o doInBackground(String... strArr) {
            this.mNetwork = new z(this.mUrl);
            this.mNetwork.addPostData("un", this.mAccount);
            String postNetData = this.mNetwork.postNetData();
            if (!this.mNetwork.isNetSuccess() || this.mNetwork.getServerErrorCode() != 36) {
                return null;
            }
            o oVar = new o();
            oVar.parserJson(postNetData);
            return oVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(o oVar) {
            super.onPostExecute(oVar);
            this.fzT.fzE = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.fzT.Dk(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.fzT.Dk(this.fzT.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.fzT.Dk(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.fzT.K(oVar.bzS());
                }
            } else {
                this.fzT.Dk(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fzT.Dk(null);
            this.fzT.bDb();
            super.onPreExecute();
        }
    }
}
