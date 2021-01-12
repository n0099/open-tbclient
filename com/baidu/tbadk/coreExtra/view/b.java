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
    private Drawable fvd;
    private Drawable fve;
    private TextView fvf;
    private View fvg;
    private View fvh;
    private View fvi;
    private a.InterfaceC0558a fvk;
    private Activity mContext;
    private int size;
    private View fuM = null;
    private Dialog fuN = null;
    private EditText fuO = null;
    private RadioGroup fuP = null;
    private RadioGroup fuQ = null;
    private CompoundButton.OnCheckedChangeListener fuR = null;
    private RadioButton fuS = null;
    private RadioButton fuT = null;
    private RadioButton fuU = null;
    private TextView fuV = null;
    private C0574b fuW = null;
    private TextView fuX = null;
    private TextView bUg = null;
    private ProgressBar fuY = null;
    private TextView fuZ = null;
    private AccountData fva = null;
    private a fvb = null;
    private a fvc = null;
    private boolean fvj = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.mContext = null;
        this.fvd = null;
        this.fve = null;
        this.size = 0;
        this.mContext = activity;
        this.fvd = ao.getDrawable(R.drawable.icon_tips_names_s);
        this.fve = ao.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.fvd.setBounds(0, 0, this.size, this.size);
        this.fve.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0558a interfaceC0558a) {
        this.fvk = interfaceC0558a;
    }

    public void setAccountData(AccountData accountData) {
        this.fva = accountData;
    }

    public void a(a aVar) {
        this.fvb = aVar;
    }

    public void b(a aVar) {
        this.fvc = aVar;
    }

    public void bze() {
        qy(0);
    }

    public void qy(int i) {
        if (this.fuN == null) {
            this.fuM = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.fvf = (TextView) this.fuM.findViewById(R.id.tip_info);
            this.fvg = this.fuM.findViewById(R.id.divider_under_account);
            this.fvh = this.fuM.findViewById(R.id.divider_under_radiongroup);
            this.fvi = this.fuM.findViewById(R.id.divider_with_yes_no_button);
            this.fuO = (EditText) this.fuM.findViewById(R.id.account);
            this.fuO.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.fuV = (TextView) this.fuM.findViewById(R.id.back);
            this.fuV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bzi();
                    b.this.bzg();
                }
            });
            this.bUg = (TextView) this.fuM.findViewById(R.id.confirm);
            this.bUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bzf();
                }
            });
            this.fuY = (ProgressBar) this.fuM.findViewById(R.id.confirm_progress);
            this.fuX = (TextView) this.fuM.findViewById(R.id.error_info);
            this.fuP = (RadioGroup) this.fuM.findViewById(R.id.names_group1);
            this.fuQ = (RadioGroup) this.fuM.findViewById(R.id.names_group2);
            this.fuS = (RadioButton) this.fuM.findViewById(R.id.name1);
            this.fuT = (RadioButton) this.fuM.findViewById(R.id.name2);
            this.fuU = (RadioButton) this.fuM.findViewById(R.id.name3);
            this.fuR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.fuS) {
                            b.this.fuQ.clearCheck();
                            b.this.fuS.setChecked(true);
                            b.this.fuS.setCompoundDrawables(b.this.fvd, null, null, null);
                            b.this.fuT.setChecked(false);
                            b.this.fuT.setCompoundDrawables(b.this.fve, null, null, null);
                            b.this.fuU.setChecked(false);
                            b.this.fuU.setCompoundDrawables(b.this.fve, null, null, null);
                        } else if (compoundButton == b.this.fuT) {
                            b.this.fuQ.clearCheck();
                            b.this.fuS.setChecked(false);
                            b.this.fuS.setCompoundDrawables(b.this.fve, null, null, null);
                            b.this.fuT.setChecked(true);
                            b.this.fuT.setCompoundDrawables(b.this.fvd, null, null, null);
                            b.this.fuU.setChecked(false);
                            b.this.fuU.setCompoundDrawables(b.this.fve, null, null, null);
                        } else if (compoundButton == b.this.fuU) {
                            b.this.fuP.clearCheck();
                            b.this.fuS.setChecked(false);
                            b.this.fuS.setCompoundDrawables(b.this.fve, null, null, null);
                            b.this.fuT.setChecked(false);
                            b.this.fuT.setCompoundDrawables(b.this.fve, null, null, null);
                            b.this.fuU.setChecked(true);
                            b.this.fuU.setCompoundDrawables(b.this.fvd, null, null, null);
                        }
                        b.this.fuO.setText(compoundButton.getText());
                    }
                }
            };
            this.fuS.setOnCheckedChangeListener(this.fuR);
            this.fuT.setOnCheckedChangeListener(this.fuR);
            this.fuU.setOnCheckedChangeListener(this.fuR);
            this.fuZ = (TextView) this.fuM.findViewById(R.id.phone_info);
            bzh();
            this.fuN = new Dialog(this.mContext, R.style.input_username_dialog);
            this.fuN.setCanceledOnTouchOutside(false);
            this.fuN.setCancelable(false);
            this.fuN.setCanceledOnTouchOutside(false);
            byV();
        }
        if (i == 1) {
            this.fuZ.setText(R.string.tip_init_user_name);
        } else {
            this.fuZ.setText(R.string.bar_friend);
        }
        if (!this.fuN.isShowing()) {
            this.fuO.setText((CharSequence) null);
            bzh();
            BZ(null);
            if (!this.mContext.isFinishing()) {
                this.fuN.setContentView(this.fuM);
                g.showDialog(this.fuN, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.fuO, 150);
                } else {
                    new Handler().postDelayed(new c(this.fuO), 150L);
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

    public void bzf() {
        String obj = this.fuO.getText().toString();
        if (obj == null || obj.length() <= 0) {
            BZ(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            BZ(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.fuW != null) {
                this.fuW.cancel();
            }
            if (!this.fvj && this.fva != null) {
                this.fuY.setVisibility(0);
                this.bUg.setEnabled(false);
                BZ(null);
                bzh();
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
                        b.this.bzi();
                        l.showToast(b.this.mContext, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bkC().a(session.username, session.bduss, "", null, b.this.fvk);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.BZ(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.fvj = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.fuY.setVisibility(8);
                        b.this.bUg.setEnabled(true);
                        b.this.fvj = false;
                    }
                }, this.fva.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzg() {
        if (this.fvc != null) {
            this.fvc.g(null);
        }
    }

    public void F(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            BZ(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        BZ(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.fuP.clearCheck();
        this.fuQ.clearCheck();
        this.fuP.setVisibility(0);
        this.fuQ.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.fuS.setText(arrayList.get(0));
            this.fuS.setChecked(false);
            this.fuS.setCompoundDrawables(this.fve, null, null, null);
            this.fuS.setVisibility(0);
            this.fuP.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.fuT.setText(arrayList.get(1));
            this.fuT.setChecked(false);
            this.fuT.setCompoundDrawables(this.fve, null, null, null);
            this.fuT.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.fuU.setText(arrayList.get(2));
            this.fuU.setChecked(false);
            this.fuU.setCompoundDrawables(this.fve, null, null, null);
            this.fuU.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.fuW != null) {
            this.fuW.cancel();
            this.fuW = null;
        }
        bzi();
    }

    public void bzh() {
        this.fuP.setVisibility(8);
        this.fuP.clearCheck();
        this.fuQ.setVisibility(8);
        this.fuQ.clearCheck();
        this.fuS.setVisibility(8);
        this.fuT.setVisibility(8);
        this.fuU.setVisibility(8);
        this.fuS.setChecked(false);
        this.fuT.setChecked(false);
        this.fuU.setChecked(false);
    }

    public void bzi() {
        if (this.fuN != null && this.fuN.isShowing()) {
            g.dismissDialog(this.fuN, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BZ(String str) {
        if (str == null) {
            this.fuX.setVisibility(4);
            this.fuX.setText((CharSequence) null);
            return;
        }
        this.fuX.setVisibility(0);
        this.fuX.setText(str);
    }

    private void byV() {
        ao.setBackgroundResource(this.fuM, R.drawable.dialog_background);
        ao.setViewTextColor(this.fuZ, R.color.CAM_X0105);
        ao.setViewTextColor(this.fvf, R.color.CAM_X0106);
        ao.setViewTextColor(this.fuO, R.color.CAM_X0105);
        ao.setBackgroundResource(this.fvg, R.drawable.bg_search_input);
        ao.setViewTextColor(this.fuX, R.color.CAM_X0301);
        ao.setViewTextColor(this.fuS, R.color.CAM_X0105);
        ao.setViewTextColor(this.fuT, R.color.CAM_X0105);
        ao.setViewTextColor(this.fuU, R.color.CAM_X0105);
        ao.setBackgroundColor(this.fvh, R.color.CAM_X0204);
        ao.setBackgroundResource(this.fuV, R.drawable.dialog_left_button_selector);
        ao.setViewTextColor(this.fuV, R.color.CAM_X0302);
        ao.setBackgroundColor(this.fvi, R.color.CAM_X0204);
        ao.setBackgroundResource(this.bUg, R.drawable.dialog_right_button_selector);
        ao.setViewTextColor(this.bUg, R.color.CAM_X0302);
        this.fuO.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        this.fuS.setCompoundDrawables(this.fve, null, null, null);
        this.fuT.setCompoundDrawables(this.fve, null, null, null);
        this.fuU.setCompoundDrawables(this.fve, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0574b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b fvl;
        private String mAccount;
        private z mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.fvl.fuW = null;
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
            this.fvl.fuW = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.fvl.BZ(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.fvl.BZ(this.fvl.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.fvl.BZ(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.fvl.F(oVar.bvY());
                }
            } else {
                this.fvl.BZ(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fvl.BZ(null);
            this.fvl.bzh();
            super.onPreExecute();
        }
    }
}
