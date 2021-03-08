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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    private Drawable fyS;
    private Drawable fyT;
    private TextView fyU;
    private View fyV;
    private View fyW;
    private View fyX;
    private a.InterfaceC0561a fyZ;
    private Activity mContext;
    private int size;
    private View fyB = null;
    private Dialog fyC = null;
    private EditText fyD = null;
    private RadioGroup fyE = null;
    private RadioGroup fyF = null;
    private CompoundButton.OnCheckedChangeListener fyG = null;
    private RadioButton fyH = null;
    private RadioButton fyI = null;
    private RadioButton fyJ = null;
    private TextView fyK = null;
    private C0577b fyL = null;
    private TextView fyM = null;
    private TextView bZF = null;
    private ProgressBar fyN = null;
    private TextView fyO = null;
    private AccountData fyP = null;
    private a fyQ = null;
    private a fyR = null;
    private boolean fyY = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.mContext = null;
        this.fyS = null;
        this.fyT = null;
        this.size = 0;
        this.mContext = activity;
        this.fyS = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.fyT = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.fyS.setBounds(0, 0, this.size, this.size);
        this.fyT.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0561a interfaceC0561a) {
        this.fyZ = interfaceC0561a;
    }

    public void setAccountData(AccountData accountData) {
        this.fyP = accountData;
    }

    public void a(a aVar) {
        this.fyQ = aVar;
    }

    public void b(a aVar) {
        this.fyR = aVar;
    }

    public void bzz() {
        qE(0);
    }

    public void qE(int i) {
        if (this.fyC == null) {
            this.fyB = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.fyU = (TextView) this.fyB.findViewById(R.id.tip_info);
            this.fyV = this.fyB.findViewById(R.id.divider_under_account);
            this.fyW = this.fyB.findViewById(R.id.divider_under_radiongroup);
            this.fyX = this.fyB.findViewById(R.id.divider_with_yes_no_button);
            this.fyD = (EditText) this.fyB.findViewById(R.id.account);
            this.fyD.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.fyK = (TextView) this.fyB.findViewById(R.id.back);
            this.fyK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bzD();
                    b.this.bzB();
                }
            });
            this.bZF = (TextView) this.fyB.findViewById(R.id.confirm);
            this.bZF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bzA();
                }
            });
            this.fyN = (ProgressBar) this.fyB.findViewById(R.id.confirm_progress);
            this.fyM = (TextView) this.fyB.findViewById(R.id.error_info);
            this.fyE = (RadioGroup) this.fyB.findViewById(R.id.names_group1);
            this.fyF = (RadioGroup) this.fyB.findViewById(R.id.names_group2);
            this.fyH = (RadioButton) this.fyB.findViewById(R.id.name1);
            this.fyI = (RadioButton) this.fyB.findViewById(R.id.name2);
            this.fyJ = (RadioButton) this.fyB.findViewById(R.id.name3);
            this.fyG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.fyH) {
                            b.this.fyF.clearCheck();
                            b.this.fyH.setChecked(true);
                            b.this.fyH.setCompoundDrawables(b.this.fyS, null, null, null);
                            b.this.fyI.setChecked(false);
                            b.this.fyI.setCompoundDrawables(b.this.fyT, null, null, null);
                            b.this.fyJ.setChecked(false);
                            b.this.fyJ.setCompoundDrawables(b.this.fyT, null, null, null);
                        } else if (compoundButton == b.this.fyI) {
                            b.this.fyF.clearCheck();
                            b.this.fyH.setChecked(false);
                            b.this.fyH.setCompoundDrawables(b.this.fyT, null, null, null);
                            b.this.fyI.setChecked(true);
                            b.this.fyI.setCompoundDrawables(b.this.fyS, null, null, null);
                            b.this.fyJ.setChecked(false);
                            b.this.fyJ.setCompoundDrawables(b.this.fyT, null, null, null);
                        } else if (compoundButton == b.this.fyJ) {
                            b.this.fyE.clearCheck();
                            b.this.fyH.setChecked(false);
                            b.this.fyH.setCompoundDrawables(b.this.fyT, null, null, null);
                            b.this.fyI.setChecked(false);
                            b.this.fyI.setCompoundDrawables(b.this.fyT, null, null, null);
                            b.this.fyJ.setChecked(true);
                            b.this.fyJ.setCompoundDrawables(b.this.fyS, null, null, null);
                        }
                        b.this.fyD.setText(compoundButton.getText());
                    }
                }
            };
            this.fyH.setOnCheckedChangeListener(this.fyG);
            this.fyI.setOnCheckedChangeListener(this.fyG);
            this.fyJ.setOnCheckedChangeListener(this.fyG);
            this.fyO = (TextView) this.fyB.findViewById(R.id.phone_info);
            bzC();
            this.fyC = new Dialog(this.mContext, R.style.input_username_dialog);
            this.fyC.setCanceledOnTouchOutside(false);
            this.fyC.setCancelable(false);
            this.fyC.setCanceledOnTouchOutside(false);
            bzq();
        }
        if (i == 1) {
            this.fyO.setText(R.string.tip_init_user_name);
        } else {
            this.fyO.setText(R.string.bar_friend);
        }
        if (!this.fyC.isShowing()) {
            this.fyD.setText((CharSequence) null);
            bzC();
            Cx(null);
            if (!this.mContext.isFinishing()) {
                this.fyC.setContentView(this.fyB);
                g.showDialog(this.fyC, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.fyD, 150);
                } else {
                    new Handler().postDelayed(new c(this.fyD), 150L);
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

    public void bzA() {
        String obj = this.fyD.getText().toString();
        if (obj == null || obj.length() <= 0) {
            Cx(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            Cx(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.fyL != null) {
                this.fyL.cancel();
            }
            if (!this.fyY && this.fyP != null) {
                this.fyN.setVisibility(0);
                this.bZF.setEnabled(false);
                Cx(null);
                bzC();
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
                        b.this.bzD();
                        l.showToast(b.this.mContext, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bkW().a(session.username, session.bduss, "", null, b.this.fyZ);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.Cx(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.fyY = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.fyN.setVisibility(8);
                        b.this.bZF.setEnabled(true);
                        b.this.fyY = false;
                    }
                }, this.fyP.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzB() {
        if (this.fyR != null) {
            this.fyR.g(null);
        }
    }

    public void F(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            Cx(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        Cx(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.fyE.clearCheck();
        this.fyF.clearCheck();
        this.fyE.setVisibility(0);
        this.fyF.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.fyH.setText(arrayList.get(0));
            this.fyH.setChecked(false);
            this.fyH.setCompoundDrawables(this.fyT, null, null, null);
            this.fyH.setVisibility(0);
            this.fyE.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.fyI.setText(arrayList.get(1));
            this.fyI.setChecked(false);
            this.fyI.setCompoundDrawables(this.fyT, null, null, null);
            this.fyI.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.fyJ.setText(arrayList.get(2));
            this.fyJ.setChecked(false);
            this.fyJ.setCompoundDrawables(this.fyT, null, null, null);
            this.fyJ.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.fyL != null) {
            this.fyL.cancel();
            this.fyL = null;
        }
        bzD();
    }

    public void bzC() {
        this.fyE.setVisibility(8);
        this.fyE.clearCheck();
        this.fyF.setVisibility(8);
        this.fyF.clearCheck();
        this.fyH.setVisibility(8);
        this.fyI.setVisibility(8);
        this.fyJ.setVisibility(8);
        this.fyH.setChecked(false);
        this.fyI.setChecked(false);
        this.fyJ.setChecked(false);
    }

    public void bzD() {
        if (this.fyC != null && this.fyC.isShowing()) {
            g.dismissDialog(this.fyC, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cx(String str) {
        if (str == null) {
            this.fyM.setVisibility(4);
            this.fyM.setText((CharSequence) null);
            return;
        }
        this.fyM.setVisibility(0);
        this.fyM.setText(str);
    }

    private void bzq() {
        ap.setBackgroundResource(this.fyB, R.drawable.dialog_background);
        ap.setViewTextColor(this.fyO, R.color.CAM_X0105);
        ap.setViewTextColor(this.fyU, R.color.CAM_X0106);
        ap.setViewTextColor(this.fyD, R.color.CAM_X0105);
        ap.setBackgroundResource(this.fyV, R.drawable.bg_search_input);
        ap.setViewTextColor(this.fyM, R.color.CAM_X0301);
        ap.setViewTextColor(this.fyH, R.color.CAM_X0105);
        ap.setViewTextColor(this.fyI, R.color.CAM_X0105);
        ap.setViewTextColor(this.fyJ, R.color.CAM_X0105);
        ap.setBackgroundColor(this.fyW, R.color.CAM_X0204);
        ap.setBackgroundResource(this.fyK, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.fyK, R.color.CAM_X0302);
        ap.setBackgroundColor(this.fyX, R.color.CAM_X0204);
        ap.setBackgroundResource(this.bZF, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.bZF, R.color.CAM_X0302);
        this.fyD.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.fyH.setCompoundDrawables(this.fyT, null, null, null);
        this.fyI.setCompoundDrawables(this.fyT, null, null, null);
        this.fyJ.setCompoundDrawables(this.fyT, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0577b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b fza;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.fza.fyL = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: O */
        public o doInBackground(String... strArr) {
            this.mNetwork = new aa(this.mUrl);
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
            this.fza.fyL = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.fza.Cx(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.fza.Cx(this.fza.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.fza.Cx(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.fza.F(oVar.bwt());
                }
            } else {
                this.fza.Cx(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fza.Cx(null);
            this.fza.bzC();
            super.onPreExecute();
        }
    }
}
