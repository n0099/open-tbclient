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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aEI = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout aEJ = null;
    private ImageView aEK = null;
    private ProgressBar aEL = null;
    private ProgressBar aEM = null;
    private TextView aEN = null;
    private TextView akt = null;
    private EditText aEO = null;
    private RelativeLayout aEP = null;
    private RelativeLayout aEQ = null;
    private b aER = null;
    private a aES = null;
    private boolean aET = false;
    private int EN = aEI;
    private RegistData aEU = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aEr = null;
    private View aEV = null;
    private TextView mDoneText = null;
    private TextView aEW = null;
    private int aEX = 0;
    private int aEY = 0;
    private boolean ajx = false;
    private int aEZ = 0;
    private final Runnable mRunnable = new k(this);
    private final View.OnClickListener mOnClickListener = new l(this);
    private final TextWatcher aFa = new m(this);
    private final View.OnFocusChangeListener aFb = new n(this);

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
            this.aEU = (RegistData) bundle.getSerializable("data");
            this.ajx = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aEU = (RegistData) intent.getSerializableExtra("data");
            this.ajx = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aEU == null) {
            setResult(0);
            finish();
        } else if (this.aEU.getSmsCodeTime() > 0) {
            aEI = this.aEU.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aEU = (RegistData) bundle.getSerializable("data");
        this.ajx = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aEU);
        bundle.putBoolean(IntentConfig.CLOSE, this.ajx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aER != null) {
            this.aER.cancel();
        }
        if (this.aES != null) {
            this.aES.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FW() {
        this.aET = false;
        this.aEQ.setEnabled(false);
        this.EN = aEI;
        this.aEN.setText(String.format(getPageContext().getString(i.h.resend_code_second), Integer.valueOf(this.EN)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aEr = (RelativeLayout) findViewById(i.f.container);
        this.aEV = findViewById(i.f.title);
        this.mDoneText = (TextView) findViewById(i.f.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.create_bar));
        this.aEP = (RelativeLayout) findViewById(i.f.done);
        this.aEP.setEnabled(false);
        this.aEQ = (RelativeLayout) findViewById(i.f.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.aEP.setOnClickListener(this.mOnClickListener);
        this.aEQ.setOnClickListener(this.mOnClickListener);
        this.aEN = (TextView) findViewById(i.f.resend_text);
        this.aEO = (EditText) findViewById(i.f.edit_code);
        this.aEO.addTextChangedListener(this.aFa);
        this.aEO.setOnFocusChangeListener(this.aFb);
        this.aEL = (ProgressBar) findViewById(i.f.progress_resend);
        this.aEM = (ProgressBar) findViewById(i.f.progress_done);
        this.aEK = (ImageView) findViewById(i.f.del_code);
        this.aEK.setOnClickListener(this.mOnClickListener);
        this.akt = (TextView) findViewById(i.f.text_error);
        this.aEJ = (LinearLayout) findViewById(i.f.sms_code_input_bg);
        this.aEX = this.aEJ.getPaddingLeft();
        this.aEY = this.aEJ.getPaddingRight();
        this.aEJ.setBackgroundResource(i.e.pass_input);
        this.aEJ.setPadding(this.aEX, 0, this.aEY, 0);
        this.aEW = (TextView) findViewById(i.f.no_receive_code);
        ShowSoftKeyPadDelay(this.aEO, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.e(this.aEr, i);
        an.g(this.aEV, i);
        an.b(this.mDoneText, i);
        an.b(this.aEN, i);
        an.c(this.aEW, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(boolean z) {
        this.aEO.setEnabled(z);
        this.aEO.setFocusable(z);
        this.aEO.setFocusableInTouchMode(z);
        this.aEK.setEnabled(z);
        if (z) {
            this.aEO.setTextColor(getResources().getColor(i.c.reg_font_color));
        } else {
            this.aEO.setTextColor(getResources().getColor(i.c.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.l lVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(lVar.getUser().getUserName());
        if (lVar.getUser().getPassword() != null) {
            accountData.setPassword(lVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aEU.getPsw());
        }
        accountData.setID(lVar.getUser().getUserId());
        accountData.setBDUSS(lVar.getUser().getBDUSS());
        accountData.setPortrait(lVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (lVar.rF() != null) {
            accountData.setTbs(lVar.rF().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.ajx) {
            FX();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.l> {
        private w Ti;

        private a() {
            this.Ti = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public com.baidu.tbadk.core.data.l doInBackground(String... strArr) {
            try {
                this.Ti = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Ti.o("un", ActivationActivity.this.aEU.getName());
                this.Ti.o("phonenum", ActivationActivity.this.aEU.getPhone());
                this.Ti.o("passwd", ActivationActivity.this.aEU.getPsw());
                if (ActivationActivity.this.aEU.getVcode() != null) {
                    this.Ti.o("vcode", ActivationActivity.this.aEU.getVcode());
                }
                if (ActivationActivity.this.aEU.getVcodeMd5() != null) {
                    this.Ti.o("vcode_md5", ActivationActivity.this.aEU.getVcodeMd5());
                }
                this.Ti.o("smscode", ActivationActivity.this.aEO.getText().toString());
                String tG = this.Ti.tG();
                if (this.Ti.uh().uZ().qV()) {
                    com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                    lVar.parserJson(tG);
                    return lVar;
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
        public void onPostExecute(com.baidu.tbadk.core.data.l lVar) {
            super.onPostExecute(lVar);
            ActivationActivity.this.aEM.setVisibility(8);
            ActivationActivity.this.aES = null;
            ActivationActivity.this.by(true);
            if (ActivationActivity.this.aET) {
                ActivationActivity.this.aEQ.setEnabled(true);
            }
            if (lVar != null) {
                ActivationActivity.this.a(lVar);
                return;
            }
            String errorString = this.Ti.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.akt.setVisibility(0);
                ActivationActivity.this.akt.setText(errorString);
            }
            if (this.Ti.ul() == 26) {
                ActivationActivity.this.aEZ = 26;
                ActivationActivity.this.aEJ.setBackgroundResource(i.e.pass_input_wrong);
                ActivationActivity.this.aEJ.setPadding(ActivationActivity.this.aEX, 0, ActivationActivity.this.aEY, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aEM.setVisibility(0);
            ActivationActivity.this.aEQ.setEnabled(false);
            ActivationActivity.this.by(false);
            ActivationActivity.this.akt.setVisibility(4);
            ActivationActivity.this.akt.setText((CharSequence) null);
            ActivationActivity.this.aEJ.setBackgroundResource(i.e.pass_input);
            ActivationActivity.this.aEJ.setPadding(ActivationActivity.this.aEX, 0, ActivationActivity.this.aEY, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aES = null;
            ActivationActivity.this.aEM.setVisibility(8);
            if (ActivationActivity.this.aET) {
                ActivationActivity.this.aEQ.setEnabled(true);
            }
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            ActivationActivity.this.by(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private w Ti;

        private b() {
            this.Ti = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aER = null;
            ActivationActivity.this.aEL.setVisibility(8);
            if (ActivationActivity.this.aEO.length() == 6) {
                ActivationActivity.this.aEP.setEnabled(true);
            }
            if (this.Ti != null) {
                this.Ti.gJ();
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
                this.Ti = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.Ti.o("phonenum", ActivationActivity.this.aEU.getPhone());
                this.Ti.tG();
                if (this.Ti.uh().uZ().qV()) {
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
            ActivationActivity.this.aER = null;
            ActivationActivity.this.aEL.setVisibility(8);
            if (ActivationActivity.this.aEO.length() == 6) {
                ActivationActivity.this.aEP.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.FW();
                return;
            }
            String errorString = this.Ti.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.akt.setVisibility(0);
                ActivationActivity.this.akt.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aEL.setVisibility(0);
            ActivationActivity.this.akt.setVisibility(4);
            ActivationActivity.this.akt.setText((CharSequence) null);
            ActivationActivity.this.aEP.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void FX() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.k.hh().b(new o(this));
        }
    }
}
