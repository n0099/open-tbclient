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
    private static int aDC = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout aDD = null;
    private ImageView aDE = null;
    private ProgressBar aDF = null;
    private ProgressBar aDG = null;
    private TextView aDH = null;
    private TextView aky = null;
    private EditText aDI = null;
    private RelativeLayout aDJ = null;
    private RelativeLayout aDK = null;
    private b aDL = null;
    private a aDM = null;
    private boolean aDN = false;
    private int EO = aDC;
    private RegistData aDO = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aDl = null;
    private View aDP = null;
    private TextView mDoneText = null;
    private TextView aDQ = null;
    private int aDR = 0;
    private int aDS = 0;
    private boolean ajC = false;
    private int aDT = 0;
    private final Runnable mRunnable = new k(this);
    private final View.OnClickListener mOnClickListener = new l(this);
    private final TextWatcher aDU = new m(this);
    private final View.OnFocusChangeListener aDV = new n(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.account_register_activation);
        initData(bundle);
        initUI();
        FP();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aDO = (RegistData) bundle.getSerializable("data");
            this.ajC = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aDO = (RegistData) intent.getSerializableExtra("data");
            this.ajC = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aDO == null) {
            setResult(0);
            finish();
        } else if (this.aDO.getSmsCodeTime() > 0) {
            aDC = this.aDO.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aDO = (RegistData) bundle.getSerializable("data");
        this.ajC = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aDO);
        bundle.putBoolean(IntentConfig.CLOSE, this.ajC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aDL != null) {
            this.aDL.cancel();
        }
        if (this.aDM != null) {
            this.aDM.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        this.aDN = false;
        this.aDK.setEnabled(false);
        this.EO = aDC;
        this.aDH.setText(String.format(getPageContext().getString(i.h.resend_code_second), Integer.valueOf(this.EO)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aDl = (RelativeLayout) findViewById(i.f.container);
        this.aDP = findViewById(i.f.title);
        this.mDoneText = (TextView) findViewById(i.f.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.h.create_bar));
        this.aDJ = (RelativeLayout) findViewById(i.f.done);
        this.aDJ.setEnabled(false);
        this.aDK = (RelativeLayout) findViewById(i.f.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.aDJ.setOnClickListener(this.mOnClickListener);
        this.aDK.setOnClickListener(this.mOnClickListener);
        this.aDH = (TextView) findViewById(i.f.resend_text);
        this.aDI = (EditText) findViewById(i.f.edit_code);
        this.aDI.addTextChangedListener(this.aDU);
        this.aDI.setOnFocusChangeListener(this.aDV);
        this.aDF = (ProgressBar) findViewById(i.f.progress_resend);
        this.aDG = (ProgressBar) findViewById(i.f.progress_done);
        this.aDE = (ImageView) findViewById(i.f.del_code);
        this.aDE.setOnClickListener(this.mOnClickListener);
        this.aky = (TextView) findViewById(i.f.text_error);
        this.aDD = (LinearLayout) findViewById(i.f.sms_code_input_bg);
        this.aDR = this.aDD.getPaddingLeft();
        this.aDS = this.aDD.getPaddingRight();
        this.aDD.setBackgroundResource(i.e.pass_input);
        this.aDD.setPadding(this.aDR, 0, this.aDS, 0);
        this.aDQ = (TextView) findViewById(i.f.no_receive_code);
        ShowSoftKeyPadDelay(this.aDI, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        an.e(this.aDl, i);
        an.g(this.aDP, i);
        an.b(this.mDoneText, i);
        an.b(this.aDH, i);
        an.c(this.aDQ, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(boolean z) {
        this.aDI.setEnabled(z);
        this.aDI.setFocusable(z);
        this.aDI.setFocusableInTouchMode(z);
        this.aDE.setEnabled(z);
        if (z) {
            this.aDI.setTextColor(getResources().getColor(i.c.reg_font_color));
        } else {
            this.aDI.setTextColor(getResources().getColor(i.c.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.l lVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(lVar.getUser().getUserName());
        if (lVar.getUser().getPassword() != null) {
            accountData.setPassword(lVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aDO.getPsw());
        }
        accountData.setID(lVar.getUser().getUserId());
        accountData.setBDUSS(lVar.getUser().getBDUSS());
        accountData.setPortrait(lVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (lVar.rE() != null) {
            accountData.setTbs(lVar.rE().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.ajC) {
            FQ();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.l> {
        private w Tj;

        private a() {
            this.Tj = null;
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
                this.Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Tj.o("un", ActivationActivity.this.aDO.getName());
                this.Tj.o("phonenum", ActivationActivity.this.aDO.getPhone());
                this.Tj.o("passwd", ActivationActivity.this.aDO.getPsw());
                if (ActivationActivity.this.aDO.getVcode() != null) {
                    this.Tj.o("vcode", ActivationActivity.this.aDO.getVcode());
                }
                if (ActivationActivity.this.aDO.getVcodeMd5() != null) {
                    this.Tj.o("vcode_md5", ActivationActivity.this.aDO.getVcodeMd5());
                }
                this.Tj.o("smscode", ActivationActivity.this.aDI.getText().toString());
                String tG = this.Tj.tG();
                if (this.Tj.uh().va().qT()) {
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
            ActivationActivity.this.aDG.setVisibility(8);
            ActivationActivity.this.aDM = null;
            ActivationActivity.this.bA(true);
            if (ActivationActivity.this.aDN) {
                ActivationActivity.this.aDK.setEnabled(true);
            }
            if (lVar != null) {
                ActivationActivity.this.a(lVar);
                return;
            }
            String errorString = this.Tj.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aky.setVisibility(0);
                ActivationActivity.this.aky.setText(errorString);
            }
            if (this.Tj.ul() == 26) {
                ActivationActivity.this.aDT = 26;
                ActivationActivity.this.aDD.setBackgroundResource(i.e.pass_input_wrong);
                ActivationActivity.this.aDD.setPadding(ActivationActivity.this.aDR, 0, ActivationActivity.this.aDS, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aDG.setVisibility(0);
            ActivationActivity.this.aDK.setEnabled(false);
            ActivationActivity.this.bA(false);
            ActivationActivity.this.aky.setVisibility(4);
            ActivationActivity.this.aky.setText((CharSequence) null);
            ActivationActivity.this.aDD.setBackgroundResource(i.e.pass_input);
            ActivationActivity.this.aDD.setPadding(ActivationActivity.this.aDR, 0, ActivationActivity.this.aDS, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aDM = null;
            ActivationActivity.this.aDG.setVisibility(8);
            if (ActivationActivity.this.aDN) {
                ActivationActivity.this.aDK.setEnabled(true);
            }
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            ActivationActivity.this.bA(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private w Tj;

        private b() {
            this.Tj = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aDL = null;
            ActivationActivity.this.aDF.setVisibility(8);
            if (ActivationActivity.this.aDI.length() == 6) {
                ActivationActivity.this.aDJ.setEnabled(true);
            }
            if (this.Tj != null) {
                this.Tj.gJ();
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
                this.Tj = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.Tj.o("phonenum", ActivationActivity.this.aDO.getPhone());
                this.Tj.tG();
                if (this.Tj.uh().va().qT()) {
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
            ActivationActivity.this.aDL = null;
            ActivationActivity.this.aDF.setVisibility(8);
            if (ActivationActivity.this.aDI.length() == 6) {
                ActivationActivity.this.aDJ.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.FP();
                return;
            }
            String errorString = this.Tj.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aky.setVisibility(0);
                ActivationActivity.this.aky.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aDF.setVisibility(0);
            ActivationActivity.this.aky.setVisibility(4);
            ActivationActivity.this.aky.setText((CharSequence) null);
            ActivationActivity.this.aDJ.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void FQ() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.k.hi().b(new o(this));
        }
    }
}
