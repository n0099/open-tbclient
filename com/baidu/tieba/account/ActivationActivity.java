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
    private static int aIc = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout aId = null;
    private ImageView aIe = null;
    private ProgressBar aIf = null;
    private ProgressBar aIg = null;
    private TextView aIh = null;
    private TextView anq = null;
    private EditText aIi = null;
    private RelativeLayout aIj = null;
    private RelativeLayout aIk = null;
    private b aIl = null;
    private a aIm = null;
    private boolean aIn = false;
    private int Fp = aIc;
    private RegistData aIo = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aHI = null;
    private View aIp = null;
    private TextView mDoneText = null;
    private TextView aIq = null;
    private int aIr = 0;
    private int aIs = 0;
    private boolean amt = false;
    private int aIt = 0;
    private final Runnable mRunnable = new o(this);
    private final View.OnClickListener mOnClickListener = new p(this);
    private final TextWatcher aIu = new q(this);
    private final View.OnFocusChangeListener aIv = new r(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(n.h.account_register_activation);
        initData(bundle);
        initUI();
        GL();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aIo = (RegistData) bundle.getSerializable("data");
            this.amt = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aIo = (RegistData) intent.getSerializableExtra("data");
            this.amt = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aIo == null) {
            setResult(0);
            finish();
        } else if (this.aIo.getSmsCodeTime() > 0) {
            aIc = this.aIo.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aIo = (RegistData) bundle.getSerializable("data");
        this.amt = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aIo);
        bundle.putBoolean(IntentConfig.CLOSE, this.amt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aIl != null) {
            this.aIl.cancel();
        }
        if (this.aIm != null) {
            this.aIm.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GL() {
        this.aIn = false;
        this.aIk.setEnabled(false);
        this.Fp = aIc;
        this.aIh.setText(String.format(getPageContext().getString(n.j.resend_code_second), Integer.valueOf(this.Fp)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aHI = (RelativeLayout) findViewById(n.g.container);
        this.aIp = findViewById(n.g.title);
        this.mDoneText = (TextView) findViewById(n.g.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.j.create_bar));
        this.aIj = (RelativeLayout) findViewById(n.g.done);
        this.aIj.setEnabled(false);
        this.aIk = (RelativeLayout) findViewById(n.g.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.aIj.setOnClickListener(this.mOnClickListener);
        this.aIk.setOnClickListener(this.mOnClickListener);
        this.aIh = (TextView) findViewById(n.g.resend_text);
        this.aIi = (EditText) findViewById(n.g.edit_code);
        this.aIi.addTextChangedListener(this.aIu);
        this.aIi.setOnFocusChangeListener(this.aIv);
        this.aIf = (ProgressBar) findViewById(n.g.progress_resend);
        this.aIg = (ProgressBar) findViewById(n.g.progress_done);
        this.aIe = (ImageView) findViewById(n.g.del_code);
        this.aIe.setOnClickListener(this.mOnClickListener);
        this.anq = (TextView) findViewById(n.g.text_error);
        this.aId = (LinearLayout) findViewById(n.g.sms_code_input_bg);
        this.aIr = this.aId.getPaddingLeft();
        this.aIs = this.aId.getPaddingRight();
        this.aId.setBackgroundResource(n.f.pass_input);
        this.aId.setPadding(this.aIr, 0, this.aIs, 0);
        this.aIq = (TextView) findViewById(n.g.no_receive_code);
        ShowSoftKeyPadDelay(this.aIi, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        as.e(this.aHI, i);
        as.g(this.aIp, i);
        as.b(this.mDoneText, i);
        as.b(this.aIh, i);
        as.c(this.aIq, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        this.aIi.setEnabled(z);
        this.aIi.setFocusable(z);
        this.aIi.setFocusableInTouchMode(z);
        this.aIe.setEnabled(z);
        if (z) {
            this.aIi.setTextColor(getResources().getColor(n.d.reg_font_color));
        } else {
            this.aIi.setTextColor(getResources().getColor(n.d.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(nVar.getUser().getUserName());
        if (nVar.getUser().getPassword() != null) {
            accountData.setPassword(nVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aIo.getPsw());
        }
        accountData.setID(nVar.getUser().getUserId());
        accountData.setBDUSS(nVar.getUser().getBDUSS());
        accountData.setPortrait(nVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (nVar.rI() != null) {
            accountData.setTbs(nVar.rI().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.amt) {
            GM();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.n> {
        private ab Ua;

        private a() {
            this.Ua = null;
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
                this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Ua.o("un", ActivationActivity.this.aIo.getName());
                this.Ua.o("phonenum", ActivationActivity.this.aIo.getPhone());
                this.Ua.o("passwd", ActivationActivity.this.aIo.getPsw());
                if (ActivationActivity.this.aIo.getVcode() != null) {
                    this.Ua.o("vcode", ActivationActivity.this.aIo.getVcode());
                }
                if (ActivationActivity.this.aIo.getVcodeMd5() != null) {
                    this.Ua.o("vcode_md5", ActivationActivity.this.aIo.getVcodeMd5());
                }
                this.Ua.o("smscode", ActivationActivity.this.aIi.getText().toString());
                String tV = this.Ua.tV();
                if (this.Ua.uw().vq().qO()) {
                    com.baidu.tbadk.core.data.n nVar = new com.baidu.tbadk.core.data.n();
                    nVar.parserJson(tV);
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
            ActivationActivity.this.aIg.setVisibility(8);
            ActivationActivity.this.aIm = null;
            ActivationActivity.this.bJ(true);
            if (ActivationActivity.this.aIn) {
                ActivationActivity.this.aIk.setEnabled(true);
            }
            if (nVar != null) {
                ActivationActivity.this.a(nVar);
                return;
            }
            String errorString = this.Ua.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.anq.setVisibility(0);
                ActivationActivity.this.anq.setText(errorString);
            }
            if (this.Ua.uA() == 26) {
                ActivationActivity.this.aIt = 26;
                ActivationActivity.this.aId.setBackgroundResource(n.f.pass_input_wrong);
                ActivationActivity.this.aId.setPadding(ActivationActivity.this.aIr, 0, ActivationActivity.this.aIs, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aIg.setVisibility(0);
            ActivationActivity.this.aIk.setEnabled(false);
            ActivationActivity.this.bJ(false);
            ActivationActivity.this.anq.setVisibility(4);
            ActivationActivity.this.anq.setText((CharSequence) null);
            ActivationActivity.this.aId.setBackgroundResource(n.f.pass_input);
            ActivationActivity.this.aId.setPadding(ActivationActivity.this.aIr, 0, ActivationActivity.this.aIs, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aIm = null;
            ActivationActivity.this.aIg.setVisibility(8);
            if (ActivationActivity.this.aIn) {
                ActivationActivity.this.aIk.setEnabled(true);
            }
            if (this.Ua != null) {
                this.Ua.gL();
            }
            ActivationActivity.this.bJ(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private ab Ua;

        private b() {
            this.Ua = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aIl = null;
            ActivationActivity.this.aIf.setVisibility(8);
            if (ActivationActivity.this.aIi.length() == 6) {
                ActivationActivity.this.aIj.setEnabled(true);
            }
            if (this.Ua != null) {
                this.Ua.gL();
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
                this.Ua = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.Ua.o("phonenum", ActivationActivity.this.aIo.getPhone());
                this.Ua.tV();
                if (this.Ua.uw().vq().qO()) {
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
            ActivationActivity.this.aIl = null;
            ActivationActivity.this.aIf.setVisibility(8);
            if (ActivationActivity.this.aIi.length() == 6) {
                ActivationActivity.this.aIj.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.GL();
                return;
            }
            String errorString = this.Ua.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.anq.setVisibility(0);
                ActivationActivity.this.anq.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aIf.setVisibility(0);
            ActivationActivity.this.anq.setVisibility(4);
            ActivationActivity.this.anq.setText((CharSequence) null);
            ActivationActivity.this.aIj.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void GM() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.hk().b(new s(this));
        }
    }
}
