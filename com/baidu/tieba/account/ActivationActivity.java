package com.baidu.tieba.account;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopRecActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aEx = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout aEy = null;
    private ImageView aEz = null;
    private ProgressBar aEA = null;
    private ProgressBar aEB = null;
    private TextView aEC = null;
    private TextView aks = null;
    private EditText aED = null;
    private RelativeLayout aEE = null;
    private RelativeLayout aEF = null;
    private b aEG = null;
    private a aEH = null;
    private boolean aEI = false;
    private int EM = aEx;
    private RegistData aEJ = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aEg = null;
    private View aEK = null;
    private TextView mDoneText = null;
    private TextView aEL = null;
    private int aEM = 0;
    private int aEN = 0;
    private boolean ajw = false;
    private int aEO = 0;
    private final Runnable mRunnable = new k(this);
    private final View.OnClickListener mOnClickListener = new l(this);
    private final TextWatcher aEP = new m(this);
    private final View.OnFocusChangeListener aEQ = new n(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.account_register_activation);
        initData(bundle);
        initUI();
        FW();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aEJ = (RegistData) bundle.getSerializable("data");
            this.ajw = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aEJ = (RegistData) intent.getSerializableExtra("data");
            this.ajw = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aEJ == null) {
            setResult(0);
            finish();
        } else if (this.aEJ.getSmsCodeTime() > 0) {
            aEx = this.aEJ.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aEJ = (RegistData) bundle.getSerializable("data");
        this.ajw = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aEJ);
        bundle.putBoolean(IntentConfig.CLOSE, this.ajw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aEG != null) {
            this.aEG.cancel();
        }
        if (this.aEH != null) {
            this.aEH.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FW() {
        this.aEI = false;
        this.aEF.setEnabled(false);
        this.EM = aEx;
        this.aEC.setText(String.format(getPageContext().getString(i.h.resend_code_second), Integer.valueOf(this.EM)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aEg = (RelativeLayout) findViewById(i.f.container);
        this.aEK = findViewById(i.f.title);
        this.mDoneText = (TextView) findViewById(i.f.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.create_bar));
        this.aEE = (RelativeLayout) findViewById(i.f.done);
        this.aEE.setEnabled(false);
        this.aEF = (RelativeLayout) findViewById(i.f.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.aEE.setOnClickListener(this.mOnClickListener);
        this.aEF.setOnClickListener(this.mOnClickListener);
        this.aEC = (TextView) findViewById(i.f.resend_text);
        this.aED = (EditText) findViewById(i.f.edit_code);
        this.aED.addTextChangedListener(this.aEP);
        this.aED.setOnFocusChangeListener(this.aEQ);
        this.aEA = (ProgressBar) findViewById(i.f.progress_resend);
        this.aEB = (ProgressBar) findViewById(i.f.progress_done);
        this.aEz = (ImageView) findViewById(i.f.del_code);
        this.aEz.setOnClickListener(this.mOnClickListener);
        this.aks = (TextView) findViewById(i.f.text_error);
        this.aEy = (LinearLayout) findViewById(i.f.sms_code_input_bg);
        this.aEM = this.aEy.getPaddingLeft();
        this.aEN = this.aEy.getPaddingRight();
        this.aEy.setBackgroundResource(i.e.pass_input);
        this.aEy.setPadding(this.aEM, 0, this.aEN, 0);
        this.aEL = (TextView) findViewById(i.f.no_receive_code);
        ShowSoftKeyPadDelay(this.aED, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.e(this.aEg, i);
        am.g(this.aEK, i);
        am.b(this.mDoneText, i);
        am.b(this.aEC, i);
        am.c(this.aEL, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(boolean z) {
        this.aED.setEnabled(z);
        this.aED.setFocusable(z);
        this.aED.setFocusableInTouchMode(z);
        this.aEz.setEnabled(z);
        if (z) {
            this.aED.setTextColor(getResources().getColor(i.c.reg_font_color));
        } else {
            this.aED.setTextColor(getResources().getColor(i.c.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.k kVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(kVar.getUser().getUserName());
        if (kVar.getUser().getPassword() != null) {
            accountData.setPassword(kVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aEJ.getPsw());
        }
        accountData.setID(kVar.getUser().getUserId());
        accountData.setBDUSS(kVar.getUser().getBDUSS());
        accountData.setPortrait(kVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (kVar.rF() != null) {
            accountData.setTbs(kVar.rF().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.ajw) {
            FX();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.k> {
        private w Th;

        private a() {
            this.Th = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public com.baidu.tbadk.core.data.k doInBackground(String... strArr) {
            try {
                this.Th = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Th.o("un", ActivationActivity.this.aEJ.getName());
                this.Th.o("phonenum", ActivationActivity.this.aEJ.getPhone());
                this.Th.o("passwd", ActivationActivity.this.aEJ.getPsw());
                if (ActivationActivity.this.aEJ.getVcode() != null) {
                    this.Th.o("vcode", ActivationActivity.this.aEJ.getVcode());
                }
                if (ActivationActivity.this.aEJ.getVcodeMd5() != null) {
                    this.Th.o("vcode_md5", ActivationActivity.this.aEJ.getVcodeMd5());
                }
                this.Th.o("smscode", ActivationActivity.this.aED.getText().toString());
                String tG = this.Th.tG();
                if (this.Th.uh().uY().qV()) {
                    com.baidu.tbadk.core.data.k kVar = new com.baidu.tbadk.core.data.k();
                    kVar.parserJson(tG);
                    return kVar;
                }
                return null;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(com.baidu.tbadk.core.data.k kVar) {
            super.onPostExecute(kVar);
            ActivationActivity.this.aEB.setVisibility(8);
            ActivationActivity.this.aEH = null;
            ActivationActivity.this.by(true);
            if (ActivationActivity.this.aEI) {
                ActivationActivity.this.aEF.setEnabled(true);
            }
            if (kVar != null) {
                ActivationActivity.this.a(kVar);
                return;
            }
            String errorString = this.Th.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aks.setVisibility(0);
                ActivationActivity.this.aks.setText(errorString);
            }
            if (this.Th.ul() == 26) {
                ActivationActivity.this.aEO = 26;
                ActivationActivity.this.aEy.setBackgroundResource(i.e.pass_input_wrong);
                ActivationActivity.this.aEy.setPadding(ActivationActivity.this.aEM, 0, ActivationActivity.this.aEN, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aEB.setVisibility(0);
            ActivationActivity.this.aEF.setEnabled(false);
            ActivationActivity.this.by(false);
            ActivationActivity.this.aks.setVisibility(4);
            ActivationActivity.this.aks.setText((CharSequence) null);
            ActivationActivity.this.aEy.setBackgroundResource(i.e.pass_input);
            ActivationActivity.this.aEy.setPadding(ActivationActivity.this.aEM, 0, ActivationActivity.this.aEN, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aEH = null;
            ActivationActivity.this.aEB.setVisibility(8);
            if (ActivationActivity.this.aEI) {
                ActivationActivity.this.aEF.setEnabled(true);
            }
            if (this.Th != null) {
                this.Th.gJ();
            }
            ActivationActivity.this.by(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private w Th;

        private b() {
            this.Th = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aEG = null;
            ActivationActivity.this.aEA.setVisibility(8);
            if (ActivationActivity.this.aED.length() == 6) {
                ActivationActivity.this.aEE.setEnabled(true);
            }
            if (this.Th != null) {
                this.Th.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            try {
                this.Th = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.Th.o("phonenum", ActivationActivity.this.aEJ.getPhone());
                this.Th.tG();
                if (this.Th.uh().uY().qV()) {
                    z = true;
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            ActivationActivity.this.aEG = null;
            ActivationActivity.this.aEA.setVisibility(8);
            if (ActivationActivity.this.aED.length() == 6) {
                ActivationActivity.this.aEE.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.FW();
                return;
            }
            String errorString = this.Th.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aks.setVisibility(0);
                ActivationActivity.this.aks.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aEA.setVisibility(0);
            ActivationActivity.this.aks.setVisibility(4);
            ActivationActivity.this.aks.setText((CharSequence) null);
            ActivationActivity.this.aEE.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void FX() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.k.hh().b(new o(this));
        }
    }
}
