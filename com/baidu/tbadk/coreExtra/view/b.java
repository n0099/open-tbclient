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
    private Activity bMo;
    private Drawable fiG;
    private Drawable fiH;
    private TextView fiI;
    private View fiJ;
    private View fiK;
    private View fiL;
    private a.InterfaceC0572a fiN;
    private int size;
    private View fin = null;
    private Dialog fio = null;
    private EditText fiq = null;
    private RadioGroup fir = null;
    private RadioGroup fis = null;
    private CompoundButton.OnCheckedChangeListener fit = null;
    private RadioButton fiu = null;
    private RadioButton fiv = null;
    private RadioButton fiw = null;
    private TextView fiy = null;
    private C0587b fiz = null;
    private TextView fiA = null;
    private TextView bOc = null;
    private ProgressBar fiB = null;
    private TextView fiC = null;
    private AccountData fiD = null;
    private a fiE = null;
    private a fiF = null;
    private boolean fiM = false;

    /* loaded from: classes.dex */
    public interface a {
        void g(AccountData accountData);
    }

    public b(Activity activity) {
        this.bMo = null;
        this.fiG = null;
        this.fiH = null;
        this.size = 0;
        this.bMo = activity;
        this.fiG = ap.getDrawable(R.drawable.icon_tips_names_s);
        this.fiH = ap.getDrawable(R.drawable.icon_tips_names_n);
        this.size = this.bMo.getResources().getDimensionPixelSize(R.dimen.ds26);
        this.fiG.setBounds(0, 0, this.size, this.size);
        this.fiH.setBounds(0, 0, this.size, this.size);
    }

    public void a(a.InterfaceC0572a interfaceC0572a) {
        this.fiN = interfaceC0572a;
    }

    public void setAccountData(AccountData accountData) {
        this.fiD = accountData;
    }

    public void a(a aVar) {
        this.fiE = aVar;
    }

    public void b(a aVar) {
        this.fiF = aVar;
    }

    public void bxd() {
        rr(0);
    }

    public void rr(int i) {
        if (this.fio == null) {
            this.fin = LayoutInflater.from(this.bMo).inflate(R.layout.main_input_username, (ViewGroup) null);
            this.fiI = (TextView) this.fin.findViewById(R.id.tip_info);
            this.fiJ = this.fin.findViewById(R.id.divider_under_account);
            this.fiK = this.fin.findViewById(R.id.divider_under_radiongroup);
            this.fiL = this.fin.findViewById(R.id.divider_with_yes_no_button);
            this.fiq = (EditText) this.fin.findViewById(R.id.account);
            this.fiq.setHint(this.bMo.getString(R.string.hint_tip_input_name));
            this.fiy = (TextView) this.fin.findViewById(R.id.back);
            this.fiy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bxh();
                    b.this.bxf();
                }
            });
            this.bOc = (TextView) this.fin.findViewById(R.id.confirm);
            this.bOc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.view.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bxe();
                }
            });
            this.fiB = (ProgressBar) this.fin.findViewById(R.id.confirm_progress);
            this.fiA = (TextView) this.fin.findViewById(R.id.error_info);
            this.fir = (RadioGroup) this.fin.findViewById(R.id.names_group1);
            this.fis = (RadioGroup) this.fin.findViewById(R.id.names_group2);
            this.fiu = (RadioButton) this.fin.findViewById(R.id.name1);
            this.fiv = (RadioButton) this.fin.findViewById(R.id.name2);
            this.fiw = (RadioButton) this.fin.findViewById(R.id.name3);
            this.fit = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tbadk.coreExtra.view.b.3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        if (compoundButton == b.this.fiu) {
                            b.this.fis.clearCheck();
                            b.this.fiu.setChecked(true);
                            b.this.fiu.setCompoundDrawables(b.this.fiG, null, null, null);
                            b.this.fiv.setChecked(false);
                            b.this.fiv.setCompoundDrawables(b.this.fiH, null, null, null);
                            b.this.fiw.setChecked(false);
                            b.this.fiw.setCompoundDrawables(b.this.fiH, null, null, null);
                        } else if (compoundButton == b.this.fiv) {
                            b.this.fis.clearCheck();
                            b.this.fiu.setChecked(false);
                            b.this.fiu.setCompoundDrawables(b.this.fiH, null, null, null);
                            b.this.fiv.setChecked(true);
                            b.this.fiv.setCompoundDrawables(b.this.fiG, null, null, null);
                            b.this.fiw.setChecked(false);
                            b.this.fiw.setCompoundDrawables(b.this.fiH, null, null, null);
                        } else if (compoundButton == b.this.fiw) {
                            b.this.fir.clearCheck();
                            b.this.fiu.setChecked(false);
                            b.this.fiu.setCompoundDrawables(b.this.fiH, null, null, null);
                            b.this.fiv.setChecked(false);
                            b.this.fiv.setCompoundDrawables(b.this.fiH, null, null, null);
                            b.this.fiw.setChecked(true);
                            b.this.fiw.setCompoundDrawables(b.this.fiG, null, null, null);
                        }
                        b.this.fiq.setText(compoundButton.getText());
                    }
                }
            };
            this.fiu.setOnCheckedChangeListener(this.fit);
            this.fiv.setOnCheckedChangeListener(this.fit);
            this.fiw.setOnCheckedChangeListener(this.fit);
            this.fiC = (TextView) this.fin.findViewById(R.id.phone_info);
            bxg();
            this.fio = new Dialog(this.bMo, R.style.input_username_dialog);
            this.fio.setCanceledOnTouchOutside(false);
            this.fio.setCancelable(false);
            this.fio.setCanceledOnTouchOutside(false);
            bwU();
        }
        if (i == 1) {
            this.fiC.setText(R.string.tip_init_user_name);
        } else {
            this.fiC.setText(R.string.bar_friend);
        }
        if (!this.fio.isShowing()) {
            this.fiq.setText((CharSequence) null);
            bxg();
            CF(null);
            if (!this.bMo.isFinishing()) {
                this.fio.setContentView(this.fin);
                g.showDialog(this.fio, this.bMo);
                if (this.bMo instanceof BaseActivity) {
                    ((BaseActivity) this.bMo).ShowSoftKeyPadDelay(this.fiq, 150);
                } else {
                    new Handler().postDelayed(new c(this.fiq), 150L);
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
            if (!b.this.bMo.isFinishing()) {
                InputMethodManager inputMethodManager = (InputMethodManager) b.this.bMo.getSystemService("input_method");
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

    public void bxe() {
        String obj = this.fiq.getText().toString();
        if (obj == null || obj.length() <= 0) {
            CF(this.bMo.getString(R.string.error_tip_name_cannot_empty));
        } else if (UtilHelper.getFixedTextSize(obj) > 14) {
            CF(this.bMo.getString(R.string.input_alias_limit_length_tip));
        } else {
            if (this.fiz != null) {
                this.fiz.cancel();
            }
            if (!this.fiM && this.fiD != null) {
                this.fiB.setVisibility(0);
                this.bOc.setEnabled(false);
                CF(null);
                bxg();
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
                        b.this.bxh();
                        l.showToast(b.this.bMo, R.string.reset_success);
                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                        com.baidu.tbadk.core.a.a.biM().a(session.username, session.bduss, "", null, b.this.fiN);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(FillUsernameResult fillUsernameResult) {
                        if (!StringUtils.isNull(fillUsernameResult.getResultMsg())) {
                            b.this.CF(fillUsernameResult.getResultMsg());
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        b.this.fiM = true;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        b.this.fiB.setVisibility(8);
                        b.this.bOc.setEnabled(true);
                        b.this.fiM = false;
                    }
                }, this.fiD.getBDUSS(), obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxf() {
        if (this.fiF != null) {
            this.fiF.g(null);
        }
    }

    public void K(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            CF(this.bMo.getString(R.string.suggest_no_name));
            return;
        }
        CF(this.bMo.getString(R.string.suggest_some_names));
        int size = arrayList.size();
        this.fir.clearCheck();
        this.fis.clearCheck();
        this.fir.setVisibility(0);
        this.fis.setVisibility(0);
        if (size > 0 && arrayList.get(0) != null) {
            this.fiu.setText(arrayList.get(0));
            this.fiu.setChecked(false);
            this.fiu.setCompoundDrawables(this.fiH, null, null, null);
            this.fiu.setVisibility(0);
            this.fir.setVisibility(0);
        }
        if (size > 1 && arrayList.get(1) != null) {
            this.fiv.setText(arrayList.get(1));
            this.fiv.setChecked(false);
            this.fiv.setCompoundDrawables(this.fiH, null, null, null);
            this.fiv.setVisibility(0);
        }
        if (size > 2 && arrayList.get(2) != null) {
            this.fiw.setText(arrayList.get(2));
            this.fiw.setChecked(false);
            this.fiw.setCompoundDrawables(this.fiH, null, null, null);
            this.fiw.setVisibility(0);
        }
    }

    public void onDestroy() {
        if (this.fiz != null) {
            this.fiz.cancel();
            this.fiz = null;
        }
        bxh();
    }

    public void bxg() {
        this.fir.setVisibility(8);
        this.fir.clearCheck();
        this.fis.setVisibility(8);
        this.fis.clearCheck();
        this.fiu.setVisibility(8);
        this.fiv.setVisibility(8);
        this.fiw.setVisibility(8);
        this.fiu.setChecked(false);
        this.fiv.setChecked(false);
        this.fiw.setChecked(false);
    }

    public void bxh() {
        if (this.fio != null && this.fio.isShowing()) {
            g.dismissDialog(this.fio, this.bMo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CF(String str) {
        if (str == null) {
            this.fiA.setVisibility(4);
            this.fiA.setText((CharSequence) null);
            return;
        }
        this.fiA.setVisibility(0);
        this.fiA.setText(str);
    }

    private void bwU() {
        ap.setBackgroundResource(this.fin, R.drawable.dialog_background);
        ap.setViewTextColor(this.fiC, R.color.CAM_X0105);
        ap.setViewTextColor(this.fiI, R.color.CAM_X0106);
        ap.setViewTextColor(this.fiq, R.color.CAM_X0105);
        ap.setBackgroundResource(this.fiJ, R.drawable.bg_search_input);
        ap.setViewTextColor(this.fiA, R.color.CAM_X0301);
        ap.setViewTextColor(this.fiu, R.color.CAM_X0105);
        ap.setViewTextColor(this.fiv, R.color.CAM_X0105);
        ap.setViewTextColor(this.fiw, R.color.CAM_X0105);
        ap.setBackgroundColor(this.fiK, R.color.CAM_X0204);
        ap.setBackgroundResource(this.fiy, R.drawable.dialog_left_button_selector);
        ap.setViewTextColor(this.fiy, R.color.CAM_X0302);
        ap.setBackgroundColor(this.fiL, R.color.CAM_X0204);
        ap.setBackgroundResource(this.bOc, R.drawable.dialog_right_button_selector);
        ap.setViewTextColor(this.bOc, R.color.CAM_X0302);
        this.fiq.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.fiu.setCompoundDrawables(this.fiH, null, null, null);
        this.fiv.setCompoundDrawables(this.fiH, null, null, null);
        this.fiw.setCompoundDrawables(this.fiH, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.coreExtra.view.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0587b extends BdAsyncTask<String, Integer, o> {
        final /* synthetic */ b fiO;
        private String mAccount;
        private aa mNetwork;
        private String mUrl;

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            this.fiO.fiz = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: H */
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
            this.fiO.fiz = null;
            if (!this.mNetwork.isNetSuccess()) {
                this.fiO.CF(this.mNetwork.getErrorString());
            } else if (this.mNetwork.getServerErrorCode() == 0) {
                this.fiO.CF(this.fiO.bMo.getString(R.string.name_not_use));
            } else if (this.mNetwork.getServerErrorCode() == 36) {
                this.fiO.CF(this.mNetwork.getErrorString());
                if (oVar != null) {
                    this.fiO.K(oVar.btX());
                }
            } else {
                this.fiO.CF(this.mNetwork.getErrorString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            this.fiO.CF(null);
            this.fiO.bxg();
            super.onPreExecute();
        }
    }
}
