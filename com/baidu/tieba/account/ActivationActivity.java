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
import com.baidu.tbadk.core.atomData.TopRecActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aGB = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout aGC = null;
    private ImageView aGD = null;
    private ProgressBar aGE = null;
    private ProgressBar aGF = null;
    private TextView aGG = null;
    private TextView amj = null;
    private EditText aGH = null;
    private RelativeLayout aGI = null;
    private RelativeLayout aGJ = null;
    private b aGK = null;
    private a aGL = null;
    private boolean aGM = false;
    private int Fd = aGB;
    private RegistData aGN = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aGi = null;
    private View aGO = null;
    private TextView mDoneText = null;
    private TextView aGP = null;
    private int aGQ = 0;
    private int aGR = 0;
    private boolean aln = false;
    private int aGS = 0;
    private final Runnable mRunnable = new n(this);
    private final View.OnClickListener mOnClickListener = new o(this);
    private final TextWatcher aGT = new p(this);
    private final View.OnFocusChangeListener aGU = new q(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(n.g.account_register_activation);
        initData(bundle);
        initUI();
        GW();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aGN = (RegistData) bundle.getSerializable("data");
            this.aln = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aGN = (RegistData) intent.getSerializableExtra("data");
            this.aln = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aGN == null) {
            setResult(0);
            finish();
        } else if (this.aGN.getSmsCodeTime() > 0) {
            aGB = this.aGN.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aGN = (RegistData) bundle.getSerializable("data");
        this.aln = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aGN);
        bundle.putBoolean(IntentConfig.CLOSE, this.aln);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aGK != null) {
            this.aGK.cancel();
        }
        if (this.aGL != null) {
            this.aGL.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW() {
        this.aGM = false;
        this.aGJ.setEnabled(false);
        this.Fd = aGB;
        this.aGG.setText(String.format(getPageContext().getString(n.i.resend_code_second), Integer.valueOf(this.Fd)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aGi = (RelativeLayout) findViewById(n.f.container);
        this.aGO = findViewById(n.f.title);
        this.mDoneText = (TextView) findViewById(n.f.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.i.create_bar));
        this.aGI = (RelativeLayout) findViewById(n.f.done);
        this.aGI.setEnabled(false);
        this.aGJ = (RelativeLayout) findViewById(n.f.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.aGI.setOnClickListener(this.mOnClickListener);
        this.aGJ.setOnClickListener(this.mOnClickListener);
        this.aGG = (TextView) findViewById(n.f.resend_text);
        this.aGH = (EditText) findViewById(n.f.edit_code);
        this.aGH.addTextChangedListener(this.aGT);
        this.aGH.setOnFocusChangeListener(this.aGU);
        this.aGE = (ProgressBar) findViewById(n.f.progress_resend);
        this.aGF = (ProgressBar) findViewById(n.f.progress_done);
        this.aGD = (ImageView) findViewById(n.f.del_code);
        this.aGD.setOnClickListener(this.mOnClickListener);
        this.amj = (TextView) findViewById(n.f.text_error);
        this.aGC = (LinearLayout) findViewById(n.f.sms_code_input_bg);
        this.aGQ = this.aGC.getPaddingLeft();
        this.aGR = this.aGC.getPaddingRight();
        this.aGC.setBackgroundResource(n.e.pass_input);
        this.aGC.setPadding(this.aGQ, 0, this.aGR, 0);
        this.aGP = (TextView) findViewById(n.f.no_receive_code);
        ShowSoftKeyPadDelay(this.aGH, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.e(this.aGi, i);
        as.g(this.aGO, i);
        as.b(this.mDoneText, i);
        as.b(this.aGG, i);
        as.c(this.aGP, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        this.aGH.setEnabled(z);
        this.aGH.setFocusable(z);
        this.aGH.setFocusableInTouchMode(z);
        this.aGD.setEnabled(z);
        if (z) {
            this.aGH.setTextColor(getResources().getColor(n.c.reg_font_color));
        } else {
            this.aGH.setTextColor(getResources().getColor(n.c.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(nVar.getUser().getUserName());
        if (nVar.getUser().getPassword() != null) {
            accountData.setPassword(nVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aGN.getPsw());
        }
        accountData.setID(nVar.getUser().getUserId());
        accountData.setBDUSS(nVar.getUser().getBDUSS());
        accountData.setPortrait(nVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (nVar.rZ() != null) {
            accountData.setTbs(nVar.rZ().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.aln) {
            GX();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.n> {
        private ab Ty;

        private a() {
            this.Ty = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public com.baidu.tbadk.core.data.n doInBackground(String... strArr) {
            try {
                this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Ty.o("un", ActivationActivity.this.aGN.getName());
                this.Ty.o("phonenum", ActivationActivity.this.aGN.getPhone());
                this.Ty.o("passwd", ActivationActivity.this.aGN.getPsw());
                if (ActivationActivity.this.aGN.getVcode() != null) {
                    this.Ty.o("vcode", ActivationActivity.this.aGN.getVcode());
                }
                if (ActivationActivity.this.aGN.getVcodeMd5() != null) {
                    this.Ty.o("vcode_md5", ActivationActivity.this.aGN.getVcodeMd5());
                }
                this.Ty.o("smscode", ActivationActivity.this.aGH.getText().toString());
                String ul = this.Ty.ul();
                if (this.Ty.uM().vG().rf()) {
                    com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                    nVar.parserJson(ul);
                    return nVar;
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
        public void onPostExecute(com.baidu.tbadk.core.data.n nVar) {
            super.onPostExecute(nVar);
            ActivationActivity.this.aGF.setVisibility(8);
            ActivationActivity.this.aGL = null;
            ActivationActivity.this.bJ(true);
            if (ActivationActivity.this.aGM) {
                ActivationActivity.this.aGJ.setEnabled(true);
            }
            if (nVar != null) {
                ActivationActivity.this.a(nVar);
                return;
            }
            String errorString = this.Ty.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.amj.setVisibility(0);
                ActivationActivity.this.amj.setText(errorString);
            }
            if (this.Ty.uQ() == 26) {
                ActivationActivity.this.aGS = 26;
                ActivationActivity.this.aGC.setBackgroundResource(n.e.pass_input_wrong);
                ActivationActivity.this.aGC.setPadding(ActivationActivity.this.aGQ, 0, ActivationActivity.this.aGR, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aGF.setVisibility(0);
            ActivationActivity.this.aGJ.setEnabled(false);
            ActivationActivity.this.bJ(false);
            ActivationActivity.this.amj.setVisibility(4);
            ActivationActivity.this.amj.setText((CharSequence) null);
            ActivationActivity.this.aGC.setBackgroundResource(n.e.pass_input);
            ActivationActivity.this.aGC.setPadding(ActivationActivity.this.aGQ, 0, ActivationActivity.this.aGR, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aGL = null;
            ActivationActivity.this.aGF.setVisibility(8);
            if (ActivationActivity.this.aGM) {
                ActivationActivity.this.aGJ.setEnabled(true);
            }
            if (this.Ty != null) {
                this.Ty.gL();
            }
            ActivationActivity.this.bJ(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private ab Ty;

        private b() {
            this.Ty = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aGK = null;
            ActivationActivity.this.aGE.setVisibility(8);
            if (ActivationActivity.this.aGH.length() == 6) {
                ActivationActivity.this.aGI.setEnabled(true);
            }
            if (this.Ty != null) {
                this.Ty.gL();
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
                this.Ty = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.Ty.o("phonenum", ActivationActivity.this.aGN.getPhone());
                this.Ty.ul();
                if (this.Ty.uM().vG().rf()) {
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
            ActivationActivity.this.aGK = null;
            ActivationActivity.this.aGE.setVisibility(8);
            if (ActivationActivity.this.aGH.length() == 6) {
                ActivationActivity.this.aGI.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.GW();
                return;
            }
            String errorString = this.Ty.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.amj.setVisibility(0);
                ActivationActivity.this.amj.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aGE.setVisibility(0);
            ActivationActivity.this.amj.setVisibility(4);
            ActivationActivity.this.amj.setText((CharSequence) null);
            ActivationActivity.this.aGI.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void GX() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.hk().b(new r(this));
        }
    }
}
