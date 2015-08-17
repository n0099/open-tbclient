package com.baidu.tieba.account;

import android.app.Activity;
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
    private static int aDT = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout aDU = null;
    private ImageView aDV = null;
    private ProgressBar aDW = null;
    private ProgressBar aDX = null;
    private TextView aDY = null;
    private TextView alf = null;
    private EditText aDZ = null;
    private RelativeLayout aEa = null;
    private RelativeLayout aEb = null;
    private b aEc = null;
    private a aEd = null;
    private boolean aEe = false;
    private int EM = aDT;
    private RegistData aEf = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aDt = null;
    private View aEg = null;
    private TextView mDoneText = null;
    private TextView aEh = null;
    private int aEi = 0;
    private int aEj = 0;
    private boolean ake = false;
    private int aEk = 0;
    private final Runnable mRunnable = new p(this);
    private final View.OnClickListener mOnClickListener = new q(this);
    private final TextWatcher aEl = new r(this);
    private final View.OnFocusChangeListener aEm = new s(this);

    public static void a(Activity activity, RegistData registData, int i, boolean z) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        intent.putExtra(IntentConfig.CLOSE, registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.account_register_activation);
        initData(bundle);
        initUI();
        FT();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aEf = (RegistData) bundle.getSerializable("data");
            this.ake = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aEf = (RegistData) intent.getSerializableExtra("data");
            this.ake = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aEf == null) {
            setResult(0);
            finish();
        } else if (this.aEf.getSmsCodeTime() > 0) {
            aDT = this.aEf.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aEf = (RegistData) bundle.getSerializable("data");
        this.ake = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aEf);
        bundle.putBoolean(IntentConfig.CLOSE, this.ake);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aEc != null) {
            this.aEc.cancel();
        }
        if (this.aEd != null) {
            this.aEd.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT() {
        this.aEe = false;
        this.aEb.setEnabled(false);
        this.EM = aDT;
        this.aDY.setText(String.format(getPageContext().getString(i.C0057i.resend_code_second), Integer.valueOf(this.EM)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aDt = (RelativeLayout) findViewById(i.f.container);
        this.aEg = findViewById(i.f.title);
        this.mDoneText = (TextView) findViewById(i.f.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.create_bar));
        this.aEa = (RelativeLayout) findViewById(i.f.done);
        this.aEa.setEnabled(false);
        this.aEb = (RelativeLayout) findViewById(i.f.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.aEa.setOnClickListener(this.mOnClickListener);
        this.aEb.setOnClickListener(this.mOnClickListener);
        this.aDY = (TextView) findViewById(i.f.resend_text);
        this.aDZ = (EditText) findViewById(i.f.edit_code);
        this.aDZ.addTextChangedListener(this.aEl);
        this.aDZ.setOnFocusChangeListener(this.aEm);
        this.aDW = (ProgressBar) findViewById(i.f.progress_resend);
        this.aDX = (ProgressBar) findViewById(i.f.progress_done);
        this.aDV = (ImageView) findViewById(i.f.del_code);
        this.aDV.setOnClickListener(this.mOnClickListener);
        this.alf = (TextView) findViewById(i.f.text_error);
        this.aDU = (LinearLayout) findViewById(i.f.sms_code_input_bg);
        this.aEi = this.aDU.getPaddingLeft();
        this.aEj = this.aDU.getPaddingRight();
        this.aDU.setBackgroundResource(i.e.pass_input);
        this.aDU.setPadding(this.aEi, 0, this.aEj, 0);
        this.aEh = (TextView) findViewById(i.f.no_receive_code);
        ShowSoftKeyPadDelay(this.aDZ, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.e(this.aDt, i);
        al.h(this.aEg, i);
        al.b(this.mDoneText, i);
        al.b(this.aDY, i);
        al.c(this.aEh, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        this.aDZ.setEnabled(z);
        this.aDZ.setFocusable(z);
        this.aDZ.setFocusableInTouchMode(z);
        this.aDV.setEnabled(z);
        if (z) {
            this.aDZ.setTextColor(getResources().getColor(i.c.reg_font_color));
        } else {
            this.aDZ.setTextColor(getResources().getColor(i.c.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.m mVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(mVar.getUser().getUserName());
        if (mVar.getUser().getPassword() != null) {
            accountData.setPassword(mVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aEf.getPsw());
        }
        accountData.setID(mVar.getUser().getUserId());
        accountData.setBDUSS(mVar.getUser().getBDUSS());
        accountData.setPortrait(mVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (mVar.rM() != null) {
            accountData.setTbs(mVar.rM().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.ake) {
            wh();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.m> {
        private com.baidu.tbadk.core.util.v Tu;

        private a() {
            this.Tu = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public com.baidu.tbadk.core.data.m doInBackground(String... strArr) {
            try {
                this.Tu = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Tu.o("un", ActivationActivity.this.aEf.getName());
                this.Tu.o("phonenum", ActivationActivity.this.aEf.getPhone());
                this.Tu.o("passwd", ActivationActivity.this.aEf.getPsw());
                if (ActivationActivity.this.aEf.getVcode() != null) {
                    this.Tu.o("vcode", ActivationActivity.this.aEf.getVcode());
                }
                if (ActivationActivity.this.aEf.getVcodeMd5() != null) {
                    this.Tu.o("vcode_md5", ActivationActivity.this.aEf.getVcodeMd5());
                }
                this.Tu.o("smscode", ActivationActivity.this.aDZ.getText().toString());
                String tD = this.Tu.tD();
                if (this.Tu.ue().uW().rb()) {
                    com.baidu.tbadk.core.data.m mVar = new com.baidu.tbadk.core.data.m();
                    mVar.parserJson(tD);
                    return mVar;
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
        public void onPostExecute(com.baidu.tbadk.core.data.m mVar) {
            super.onPostExecute(mVar);
            ActivationActivity.this.aDX.setVisibility(8);
            ActivationActivity.this.aEd = null;
            ActivationActivity.this.bu(true);
            if (ActivationActivity.this.aEe) {
                ActivationActivity.this.aEb.setEnabled(true);
            }
            if (mVar != null) {
                ActivationActivity.this.a(mVar);
                return;
            }
            String errorString = this.Tu.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.alf.setVisibility(0);
                ActivationActivity.this.alf.setText(errorString);
            }
            if (this.Tu.ui() == 26) {
                ActivationActivity.this.aEk = 26;
                ActivationActivity.this.aDU.setBackgroundResource(i.e.pass_input_wrong);
                ActivationActivity.this.aDU.setPadding(ActivationActivity.this.aEi, 0, ActivationActivity.this.aEj, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aDX.setVisibility(0);
            ActivationActivity.this.aEb.setEnabled(false);
            ActivationActivity.this.bu(false);
            ActivationActivity.this.alf.setVisibility(4);
            ActivationActivity.this.alf.setText((CharSequence) null);
            ActivationActivity.this.aDU.setBackgroundResource(i.e.pass_input);
            ActivationActivity.this.aDU.setPadding(ActivationActivity.this.aEi, 0, ActivationActivity.this.aEj, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aEd = null;
            ActivationActivity.this.aDX.setVisibility(8);
            if (ActivationActivity.this.aEe) {
                ActivationActivity.this.aEb.setEnabled(true);
            }
            if (this.Tu != null) {
                this.Tu.gM();
            }
            ActivationActivity.this.bu(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private com.baidu.tbadk.core.util.v Tu;

        private b() {
            this.Tu = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aEc = null;
            ActivationActivity.this.aDW.setVisibility(8);
            if (ActivationActivity.this.aDZ.length() == 6) {
                ActivationActivity.this.aEa.setEnabled(true);
            }
            if (this.Tu != null) {
                this.Tu.gM();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            try {
                this.Tu = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.Tu.o("phonenum", ActivationActivity.this.aEf.getPhone());
                this.Tu.tD();
                if (this.Tu.ue().uW().rb()) {
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
            ActivationActivity.this.aEc = null;
            ActivationActivity.this.aDW.setVisibility(8);
            if (ActivationActivity.this.aDZ.length() == 6) {
                ActivationActivity.this.aEa.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.FT();
                return;
            }
            String errorString = this.Tu.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.alf.setVisibility(0);
                ActivationActivity.this.alf.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aDW.setVisibility(0);
            ActivationActivity.this.alf.setVisibility(4);
            ActivationActivity.this.alf.setText((CharSequence) null);
            ActivationActivity.this.aEa.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void wh() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.k.hj().b(new t(this));
        }
    }
}
