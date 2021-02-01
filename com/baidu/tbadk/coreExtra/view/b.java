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
    private a.InterfaceC0555a fxA;
    private Drawable fxt;
    private Drawable fxu;
    private TextView fxv;
    private View fxw;
    private View fxx;
    private View fxy;
    private Activity mContext;
    private int size;
    private View fxc = null;
    private Dialog fxd = null;
    private EditText fxe = null;
    private RadioGroup fxf = null;
    private RadioGroup fxg = null;
    private CompoundButton.OnCheckedChangeListener fxh = null;
    private RadioButton fxi = null;
    private RadioButton fxj = null;
    private RadioButton fxk = null;
    private TextView fxl = null;
    private C0571b fxm = null;
    private TextView fxn = null;
    private TextView bYf = null;
    private ProgressBar fxo = null;
    private TextView fxp = null;
    private AccountData fxq = null;
    private a fxr = null;
    private a fxs = null;
    private boolean fxz = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.mContext = null;
        this.fxt = null;
        this.fxu = null;
        this.size = 0;
        this.mContext = activity;
        this.fxt = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.fxu = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.fxt.setBounds(0, 0, this.size, this.size);
        this.fxu.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0555a interfaceC0555a) {
        this.fxA = interfaceC0555a;
    }

    public void setAccountData(AccountData accountData) {
        this.fxq = accountData;
    }

    public void a(a aVar) {
        this.fxr = aVar;
    }

    public void b(a aVar) {
        this.fxs = aVar;
    }

    public void bzw() {
        qD(0);
    }

    public void qD(int i) {
        if (this.fxd == null) {
            this.fxc = LayoutInflater.from(this.mContext).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.fxv = (TextView) this.fxc.findViewById(R.id.tip_info);
            this.fxw = this.fxc.findViewById(R.id.divider_under_account);
            this.fxx = this.fxc.findViewById(R.id.divider_under_radiongroup);
            this.fxy = this.fxc.findViewById(R.id.divider_with_yes_no_button);
            this.fxe = (EditText) this.fxc.findViewById(R.id.account);
            this.fxe.setHint(this.mContext.getString(R.string.hint_tip_input_name));
            this.fxl = (TextView) this.fxc.findViewById(R.id.back);
            this.fxl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bzA();
                    b.this.bzy();
                }
            });
            this.bYf = (TextView) this.fxc.findViewById(R.id.confirm);
            this.bYf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bzx();
                }
            });
            this.fxo = (ProgressBar) this.fxc.findViewById(R.id.confirm_progress);
            this.fxn = (TextView) this.fxc.findViewById(R.id.error_info);
            this.fxf = (RadioGroup) this.fxc.findViewById(R.id.names_group1);
            this.fxg = (RadioGroup) this.fxc.findViewById(R.id.names_group2);
            this.fxi = (RadioButton) this.fxc.findViewById(R.id.name1);
            this.fxj = (RadioButton) this.fxc.findViewById(R.id.name2);
            this.fxk = (RadioButton) this.fxc.findViewById(R.id.name3);
            this.fxh = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.fxi) {
                            b.this.fxg.clearCheck();
                            b.this.fxi.setChecked(true);
                            b.this.fxi.setCompoundDrawables(b.this.fxt, null, null, null);
                            b.this.fxj.setChecked(false);
                            b.this.fxj.setCompoundDrawables(b.this.fxu, null, null, null);
                            b.this.fxk.setChecked(false);
                            b.this.fxk.setCompoundDrawables(b.this.fxu, null, null, null);
                        } else if (compoundButton == b.this.fxj) {
                            b.this.fxg.clearCheck();
                            b.this.fxi.setChecked(false);
                            b.this.fxi.setCompoundDrawables(b.this.fxu, null, null, null);
                            b.this.fxj.setChecked(true);
                            b.this.fxj.setCompoundDrawables(b.this.fxt, null, null, null);
                            b.this.fxk.setChecked(false);
                            b.this.fxk.setCompoundDrawables(b.this.fxu, null, null, null);
                        } else if (compoundButton == b.this.fxk) {
                            b.this.fxf.clearCheck();
                            b.this.fxi.setChecked(false);
                            b.this.fxi.setCompoundDrawables(b.this.fxu, null, null, null);
                            b.this.fxj.setChecked(false);
                            b.this.fxj.setCompoundDrawables(b.this.fxu, null, null, null);
                            b.this.fxk.setChecked(true);
                            b.this.fxk.setCompoundDrawables(b.this.fxt, null, null, null);
                        }
                        b.this.fxe.setText(compoundButton.getText());
                    }
                }
            };
            this.fxi.setOnCheckedChangeListener(this.fxh);
            this.fxj.setOnCheckedChangeListener(this.fxh);
            this.fxk.setOnCheckedChangeListener(this.fxh);
            this.fxp = (TextView) this.fxc.findViewById(R.id.phone_info);
            bzz();
            this.fxd = new Dialog(this.mContext, R.style.input_username_dialog);
            this.fxd.setCanceledOnTouchOutside(false);
            this.fxd.setCancelable(false);
            this.fxd.setCanceledOnTouchOutside(false);
            bzn();
        }
        if (i == 1) {
            this.fxp.setText(R.string.tip_init_user_name);
        } else {
            this.fxp.setText(R.string.bar_friend);
        }
        if (!this.fxd.isShowing()) {
            this.fxe.setText((CharSequence) null);
            bzz();
            Cq(null);
            if (!this.mContext.isFinishing()) {
                this.fxd.setContentView(this.fxc);
                g.showDialog(this.fxd, this.mContext);
                if (this.mContext instanceof BaseActivity) {
                    ((BaseActivity) this.mContext).ShowSoftKeyPadDelay(this.fxe, 150);
                } else {
                    new Handler().postDelayed(new c(this.fxe), 150L);
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

    public void bzx() {
        String obj = this.fxe.getText().toString();
        if (obj == null || obj.length() <= 0) {
            Cq(this.mContext.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            Cq(this.mContext.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.fxm != null) {
                this.fxm.cancel();
            }
            if (!this.fxz && this.fxq != null) {
                this.fxo.setVisibility(0);
                this.bYf.setEnabled(false);
                Cq(null);
                bzz();
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
                        b.this.bzA();
                        l.showToast(b.this.mContext, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.bkU().a(session.username, session.bduss, "", null, b.this.fxA);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.Cq(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.fxz = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.fxo.setVisibility(8);
                        b.this.bYf.setEnabled(true);
                        b.this.fxz = false;
                    }
                }, this.fxq.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzy() {
        if (this.fxs != null) {
            this.fxs.g(null);
        }
    }

    public void F(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            Cq(this.mContext.getString(R.string.suggest_no_name));
            return;
        }
        Cq(this.mContext.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.fxf.clearCheck();
        this.fxg.clearCheck();
        this.fxf.setVisibility(0);
        this.fxg.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.fxi.setText(arrayList.get(0));
            this.fxi.setChecked(false);
            this.fxi.setCompoundDrawables(this.fxu, null, null, null);
            this.fxi.setVisibility(0);
            this.fxf.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.fxj.setText(arrayList.get(1));
            this.fxj.setChecked(false);
            this.fxj.setCompoundDrawables(this.fxu, null, null, null);
            this.fxj.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.fxk.setText(arrayList.get(2));
            this.fxk.setChecked(false);
            this.fxk.setCompoundDrawables(this.fxu, null, null, null);
            this.fxk.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.fxm != null) {
            this.fxm.cancel();
            this.fxm = null;
        }
        bzA();
    }

    public void bzz() {
        this.fxf.setVisibility(8);
        this.fxf.clearCheck();
        this.fxg.setVisibility(8);
        this.fxg.clearCheck();
        this.fxi.setVisibility(8);
        this.fxj.setVisibility(8);
        this.fxk.setVisibility(8);
        this.fxi.setChecked(false);
        this.fxj.setChecked(false);
        this.fxk.setChecked(false);
    }

    public void bzA() {
        if (this.fxd != null && this.fxd.isShowing()) {
            g.dismissDialog(this.fxd, this.mContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cq(String str) {
        if (str == null) {
            this.fxn.setVisibility(4);
            this.fxn.setText((CharSequence) null);
            return;
        }
        this.fxn.setVisibility(0);
        this.fxn.setText(str);
    }

    private void bzn() {
        ap.setBackgroundResource(this.fxc, R.drawable.dialog_background);
        ap.setViewTextColor(this.fxp, R.color.CAM_X0105);
        ap.setViewTextColor(this.fxv, R.color.CAM_X0106);
        ap.setViewTextColor(this.fxe, R.color.CAM_X0105);
        ap.setBackgroundResource(this.fxw, R.drawable.bg_search_input);
        ap.setViewTextColor(this.fxn, R.color.CAM_X0301);
        ap.setViewTextColor(this.fxi, R.color.CAM_X0105);
        ap.setViewTextColor(this.fxj, R.color.CAM_X0105);
        ap.setViewTextColor(this.fxk, R.color.CAM_X0105);
        ap.setBackgroundColor(this.fxx, R.color.CAM_X0204);
        ap.setBackgroundResource(this.fxl, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.fxl, R.color.CAM_X0302);
        ap.setBackgroundColor(this.fxy, R.color.CAM_X0204);
        ap.setBackgroundResource(this.bYf, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.bYf, R.color.CAM_X0302);
        this.fxe.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.fxi.setCompoundDrawables(this.fxu, null, null, null);
        this.fxj.setCompoundDrawables(this.fxu, null, null, null);
        this.fxk.setCompoundDrawables(this.fxu, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0571b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b fxB;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.fxB.fxm = null;
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
            this.fxB.fxm = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.fxB.Cq(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.fxB.Cq(this.fxB.mContext.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.fxB.Cq(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.fxB.F(oVar.bwq());
                }
            } else {
                this.fxB.Cq(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fxB.Cq(null);
            this.fxB.bzz();
            super.onPreExecute();
        }
    }
}
