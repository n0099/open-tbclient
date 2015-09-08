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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aFB = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout aFC = null;
    private ImageView aFD = null;
    private ProgressBar aFE = null;
    private ProgressBar aFF = null;
    private TextView aFG = null;
    private TextView alx = null;
    private EditText aFH = null;
    private RelativeLayout aFI = null;
    private RelativeLayout aFJ = null;
    private b aFK = null;
    private a aFL = null;
    private boolean aFM = false;
    private int EM = aFB;
    private RegistData aFN = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aFb = null;
    private View aFO = null;
    private TextView mDoneText = null;
    private TextView aFP = null;
    private int aFQ = 0;
    private int aFR = 0;
    private boolean akw = false;
    private int aFS = 0;
    private final Runnable mRunnable = new p(this);
    private final View.OnClickListener mOnClickListener = new q(this);
    private final TextWatcher aFT = new r(this);
    private final View.OnFocusChangeListener aFU = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.account_register_activation);
        initData(bundle);
        initUI();
        Gd();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aFN = (RegistData) bundle.getSerializable("data");
            this.akw = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aFN = (RegistData) intent.getSerializableExtra("data");
            this.akw = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aFN == null) {
            setResult(0);
            finish();
        } else if (this.aFN.getSmsCodeTime() > 0) {
            aFB = this.aFN.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aFN = (RegistData) bundle.getSerializable("data");
        this.akw = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aFN);
        bundle.putBoolean(IntentConfig.CLOSE, this.akw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aFK != null) {
            this.aFK.cancel();
        }
        if (this.aFL != null) {
            this.aFL.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gd() {
        this.aFM = false;
        this.aFJ.setEnabled(false);
        this.EM = aFB;
        this.aFG.setText(String.format(getPageContext().getString(i.h.resend_code_second), Integer.valueOf(this.EM)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aFb = (RelativeLayout) findViewById(i.f.container);
        this.aFO = findViewById(i.f.title);
        this.mDoneText = (TextView) findViewById(i.f.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.create_bar));
        this.aFI = (RelativeLayout) findViewById(i.f.done);
        this.aFI.setEnabled(false);
        this.aFJ = (RelativeLayout) findViewById(i.f.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.aFI.setOnClickListener(this.mOnClickListener);
        this.aFJ.setOnClickListener(this.mOnClickListener);
        this.aFG = (TextView) findViewById(i.f.resend_text);
        this.aFH = (EditText) findViewById(i.f.edit_code);
        this.aFH.addTextChangedListener(this.aFT);
        this.aFH.setOnFocusChangeListener(this.aFU);
        this.aFE = (ProgressBar) findViewById(i.f.progress_resend);
        this.aFF = (ProgressBar) findViewById(i.f.progress_done);
        this.aFD = (ImageView) findViewById(i.f.del_code);
        this.aFD.setOnClickListener(this.mOnClickListener);
        this.alx = (TextView) findViewById(i.f.text_error);
        this.aFC = (LinearLayout) findViewById(i.f.sms_code_input_bg);
        this.aFQ = this.aFC.getPaddingLeft();
        this.aFR = this.aFC.getPaddingRight();
        this.aFC.setBackgroundResource(i.e.pass_input);
        this.aFC.setPadding(this.aFQ, 0, this.aFR, 0);
        this.aFP = (TextView) findViewById(i.f.no_receive_code);
        ShowSoftKeyPadDelay(this.aFH, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.e(this.aFb, i);
        al.g(this.aFO, i);
        al.b(this.mDoneText, i);
        al.b(this.aFG, i);
        al.c(this.aFP, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        this.aFH.setEnabled(z);
        this.aFH.setFocusable(z);
        this.aFH.setFocusableInTouchMode(z);
        this.aFD.setEnabled(z);
        if (z) {
            this.aFH.setTextColor(getResources().getColor(i.c.reg_font_color));
        } else {
            this.aFH.setTextColor(getResources().getColor(i.c.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.l lVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(lVar.getUser().getUserName());
        if (lVar.getUser().getPassword() != null) {
            accountData.setPassword(lVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aFN.getPsw());
        }
        accountData.setID(lVar.getUser().getUserId());
        accountData.setBDUSS(lVar.getUser().getBDUSS());
        accountData.setPortrait(lVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (lVar.rK() != null) {
            accountData.setTbs(lVar.rK().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.akw) {
            wm();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.l> {
        private com.baidu.tbadk.core.util.v Tv;

        private a() {
            this.Tv = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tbadk.core.data.l doInBackground(String... strArr) {
            try {
                this.Tv = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Tv.o("un", ActivationActivity.this.aFN.getName());
                this.Tv.o("phonenum", ActivationActivity.this.aFN.getPhone());
                this.Tv.o("passwd", ActivationActivity.this.aFN.getPsw());
                if (ActivationActivity.this.aFN.getVcode() != null) {
                    this.Tv.o("vcode", ActivationActivity.this.aFN.getVcode());
                }
                if (ActivationActivity.this.aFN.getVcodeMd5() != null) {
                    this.Tv.o("vcode_md5", ActivationActivity.this.aFN.getVcodeMd5());
                }
                this.Tv.o("smscode", ActivationActivity.this.aFH.getText().toString());
                String tI = this.Tv.tI();
                if (this.Tv.uj().va().qZ()) {
                    com.baidu.tbadk.core.data.l lVar = new com.baidu.tbadk.core.data.l();
                    lVar.parserJson(tI);
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
            ActivationActivity.this.aFF.setVisibility(8);
            ActivationActivity.this.aFL = null;
            ActivationActivity.this.bB(true);
            if (ActivationActivity.this.aFM) {
                ActivationActivity.this.aFJ.setEnabled(true);
            }
            if (lVar != null) {
                ActivationActivity.this.a(lVar);
                return;
            }
            String errorString = this.Tv.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.alx.setVisibility(0);
                ActivationActivity.this.alx.setText(errorString);
            }
            if (this.Tv.un() == 26) {
                ActivationActivity.this.aFS = 26;
                ActivationActivity.this.aFC.setBackgroundResource(i.e.pass_input_wrong);
                ActivationActivity.this.aFC.setPadding(ActivationActivity.this.aFQ, 0, ActivationActivity.this.aFR, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aFF.setVisibility(0);
            ActivationActivity.this.aFJ.setEnabled(false);
            ActivationActivity.this.bB(false);
            ActivationActivity.this.alx.setVisibility(4);
            ActivationActivity.this.alx.setText((CharSequence) null);
            ActivationActivity.this.aFC.setBackgroundResource(i.e.pass_input);
            ActivationActivity.this.aFC.setPadding(ActivationActivity.this.aFQ, 0, ActivationActivity.this.aFR, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aFL = null;
            ActivationActivity.this.aFF.setVisibility(8);
            if (ActivationActivity.this.aFM) {
                ActivationActivity.this.aFJ.setEnabled(true);
            }
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            ActivationActivity.this.bB(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private com.baidu.tbadk.core.util.v Tv;

        private b() {
            this.Tv = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aFK = null;
            ActivationActivity.this.aFE.setVisibility(8);
            if (ActivationActivity.this.aFH.length() == 6) {
                ActivationActivity.this.aFI.setEnabled(true);
            }
            if (this.Tv != null) {
                this.Tv.gJ();
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
                this.Tv = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.Tv.o("phonenum", ActivationActivity.this.aFN.getPhone());
                this.Tv.tI();
                if (this.Tv.uj().va().qZ()) {
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
            ActivationActivity.this.aFK = null;
            ActivationActivity.this.aFE.setVisibility(8);
            if (ActivationActivity.this.aFH.length() == 6) {
                ActivationActivity.this.aFI.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.Gd();
                return;
            }
            String errorString = this.Tv.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.alx.setVisibility(0);
                ActivationActivity.this.alx.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aFE.setVisibility(0);
            ActivationActivity.this.alx.setVisibility(4);
            ActivationActivity.this.alx.setText((CharSequence) null);
            ActivationActivity.this.aFI.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void wm() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.k.hg().b(new t(this));
        }
    }
}
