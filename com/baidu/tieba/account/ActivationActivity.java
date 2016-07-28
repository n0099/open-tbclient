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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.TopRecActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aMC = 60;
    public NavigationBar mNavigationBar;
    private View agC = null;
    private LinearLayout aMD = null;
    private ImageView aME = null;
    private ProgressBar aMF = null;
    private ProgressBar aMG = null;
    private TextView aMH = null;
    private TextView alK = null;
    private EditText aMI = null;
    private RelativeLayout aMJ = null;
    private RelativeLayout aMK = null;
    private b aML = null;
    private a aMM = null;
    private boolean aMN = false;
    private int wD = aMC;
    private RegistData aMO = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aMh = null;
    private View aMP = null;
    private TextView aMQ = null;
    private TextView aMR = null;
    private int aMS = 0;
    private int aMT = 0;
    private boolean akM = false;
    private int aMU = 0;
    private final Runnable mRunnable = new p(this);
    private final View.OnClickListener mOnClickListener = new q(this);
    private final TextWatcher aMV = new r(this);
    private final View.OnFocusChangeListener aMW = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(u.h.account_register_activation);
        initData(bundle);
        initUI();
        IZ();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aMO = (RegistData) bundle.getSerializable("data");
            this.akM = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aMO = (RegistData) intent.getSerializableExtra("data");
            this.akM = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aMO == null) {
            setResult(0);
            finish();
        } else if (this.aMO.getSmsCodeTime() > 0) {
            aMC = this.aMO.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aMO = (RegistData) bundle.getSerializable("data");
        this.akM = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aMO);
        bundle.putBoolean(IntentConfig.CLOSE, this.akM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aML != null) {
            this.aML.cancel();
        }
        if (this.aMM != null) {
            this.aMM.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IZ() {
        this.aMN = false;
        this.aMK.setEnabled(false);
        this.wD = aMC;
        this.aMH.setText(String.format(getPageContext().getString(u.j.resend_code_second), Integer.valueOf(this.wD)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aMh = (RelativeLayout) findViewById(u.g.container);
        this.aMP = findViewById(u.g.title);
        this.aMQ = (TextView) findViewById(u.g.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.agC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.create_bar));
        this.aMJ = (RelativeLayout) findViewById(u.g.done);
        this.aMJ.setEnabled(false);
        this.aMK = (RelativeLayout) findViewById(u.g.resend);
        this.agC.setOnClickListener(this.mOnClickListener);
        this.aMJ.setOnClickListener(this.mOnClickListener);
        this.aMK.setOnClickListener(this.mOnClickListener);
        this.aMH = (TextView) findViewById(u.g.resend_text);
        this.aMI = (EditText) findViewById(u.g.edit_code);
        this.aMI.addTextChangedListener(this.aMV);
        this.aMI.setOnFocusChangeListener(this.aMW);
        this.aMF = (ProgressBar) findViewById(u.g.progress_resend);
        this.aMG = (ProgressBar) findViewById(u.g.progress_done);
        this.aME = (ImageView) findViewById(u.g.del_code);
        this.aME.setOnClickListener(this.mOnClickListener);
        this.alK = (TextView) findViewById(u.g.text_error);
        this.aMD = (LinearLayout) findViewById(u.g.sms_code_input_bg);
        this.aMS = this.aMD.getPaddingLeft();
        this.aMT = this.aMD.getPaddingRight();
        this.aMD.setBackgroundResource(u.f.pass_input);
        this.aMD.setPadding(this.aMS, 0, this.aMT, 0);
        this.aMR = (TextView) findViewById(u.g.no_receive_code);
        ShowSoftKeyPadDelay(this.aMI, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.g(this.aMh, i);
        av.i(this.aMP, i);
        av.b(this.aMQ, i);
        av.b(this.aMH, i);
        av.c(this.aMR, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(boolean z) {
        this.aMI.setEnabled(z);
        this.aMI.setFocusable(z);
        this.aMI.setFocusableInTouchMode(z);
        this.aME.setEnabled(z);
        if (z) {
            this.aMI.setTextColor(getResources().getColor(u.d.common_color_10046));
        } else {
            this.aMI.setTextColor(getResources().getColor(u.d.common_color_10003));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ad adVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(adVar.getUser().getUserName());
        if (adVar.getUser().getPassword() != null) {
            accountData.setPassword(adVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aMO.getPsw());
        }
        accountData.setID(adVar.getUser().getUserId());
        accountData.setBDUSS(adVar.getUser().getBDUSS());
        accountData.setPortrait(adVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (adVar.pc() != null) {
            accountData.setTbs(adVar.pc().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.akM) {
            Ja();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, ad> {
        private ab LI;

        private a() {
            this.LI = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public ad doInBackground(String... strArr) {
            try {
                this.LI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.LI.n("un", ActivationActivity.this.aMO.getName());
                this.LI.n("phonenum", ActivationActivity.this.aMO.getPhone());
                this.LI.n("passwd", ActivationActivity.this.aMO.getPsw());
                if (ActivationActivity.this.aMO.getVcode() != null) {
                    this.LI.n("vcode", ActivationActivity.this.aMO.getVcode());
                }
                if (ActivationActivity.this.aMO.getVcodeMd5() != null) {
                    this.LI.n(GraffitiVcodeActivityConfig.VCODE_MD5, ActivationActivity.this.aMO.getVcodeMd5());
                }
                this.LI.n("smscode", ActivationActivity.this.aMI.getText().toString());
                String sZ = this.LI.sZ();
                if (this.LI.tx().uv().nJ()) {
                    ad adVar = new ad();
                    adVar.parserJson(sZ);
                    return adVar;
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
        public void onPostExecute(ad adVar) {
            super.onPostExecute(adVar);
            ActivationActivity.this.aMG.setVisibility(8);
            ActivationActivity.this.aMM = null;
            ActivationActivity.this.ce(true);
            if (ActivationActivity.this.aMN) {
                ActivationActivity.this.aMK.setEnabled(true);
            }
            if (adVar != null) {
                ActivationActivity.this.a(adVar);
                return;
            }
            String errorString = this.LI.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.alK.setVisibility(0);
                ActivationActivity.this.alK.setText(errorString);
            }
            if (this.LI.tB() == 26) {
                ActivationActivity.this.aMU = 26;
                ActivationActivity.this.aMD.setBackgroundResource(u.f.pass_input_wrong);
                ActivationActivity.this.aMD.setPadding(ActivationActivity.this.aMS, 0, ActivationActivity.this.aMT, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aMG.setVisibility(0);
            ActivationActivity.this.aMK.setEnabled(false);
            ActivationActivity.this.ce(false);
            ActivationActivity.this.alK.setVisibility(4);
            ActivationActivity.this.alK.setText((CharSequence) null);
            ActivationActivity.this.aMD.setBackgroundResource(u.f.pass_input);
            ActivationActivity.this.aMD.setPadding(ActivationActivity.this.aMS, 0, ActivationActivity.this.aMT, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aMM = null;
            ActivationActivity.this.aMG.setVisibility(8);
            if (ActivationActivity.this.aMN) {
                ActivationActivity.this.aMK.setEnabled(true);
            }
            if (this.LI != null) {
                this.LI.dl();
            }
            ActivationActivity.this.ce(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private ab LI;

        private b() {
            this.LI = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aML = null;
            ActivationActivity.this.aMF.setVisibility(8);
            if (ActivationActivity.this.aMI.length() == 6) {
                ActivationActivity.this.aMJ.setEnabled(true);
            }
            if (this.LI != null) {
                this.LI.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            try {
                this.LI = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.LI.n("phonenum", ActivationActivity.this.aMO.getPhone());
                this.LI.sZ();
                if (this.LI.tx().uv().nJ()) {
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
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            ActivationActivity.this.aML = null;
            ActivationActivity.this.aMF.setVisibility(8);
            if (ActivationActivity.this.aMI.length() == 6) {
                ActivationActivity.this.aMJ.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.IZ();
                return;
            }
            String errorString = this.LI.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.alK.setVisibility(0);
                ActivationActivity.this.alK.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aMF.setVisibility(0);
            ActivationActivity.this.alK.setVisibility(4);
            ActivationActivity.this.alK.setText((CharSequence) null);
            ActivationActivity.this.aMJ.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void Ja() {
        if (TbadkCoreApplication.m10getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.dM().e(new t(this));
        }
    }
}
