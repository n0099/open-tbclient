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
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.TopRecActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aMb = 60;
    public NavigationBar mNavigationBar;
    private View ajA = null;
    private LinearLayout aMc = null;
    private ImageView aMd = null;
    private ProgressBar aMe = null;
    private ProgressBar aMf = null;
    private TextView aMg = null;
    private TextView aoA = null;
    private EditText aMh = null;
    private RelativeLayout aMi = null;
    private RelativeLayout aMj = null;
    private b aMk = null;
    private a aMl = null;
    private boolean aMm = false;
    private int FI = aMb;
    private RegistData aMn = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aLG = null;
    private View aMo = null;
    private TextView aMp = null;
    private TextView aMq = null;
    private int aMr = 0;
    private int aMs = 0;
    private boolean anD = false;
    private int aMt = 0;
    private final Runnable mRunnable = new o(this);
    private final View.OnClickListener mOnClickListener = new p(this);
    private final TextWatcher aMu = new q(this);
    private final View.OnFocusChangeListener aMv = new r(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.account_register_activation);
        initData(bundle);
        pU();
        JI();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aMn = (RegistData) bundle.getSerializable("data");
            this.anD = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aMn = (RegistData) intent.getSerializableExtra("data");
            this.anD = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aMn == null) {
            setResult(0);
            finish();
        } else if (this.aMn.getSmsCodeTime() > 0) {
            aMb = this.aMn.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aMn = (RegistData) bundle.getSerializable("data");
        this.anD = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aMn);
        bundle.putBoolean(IntentConfig.CLOSE, this.anD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aMk != null) {
            this.aMk.cancel();
        }
        if (this.aMl != null) {
            this.aMl.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JI() {
        this.aMm = false;
        this.aMj.setEnabled(false);
        this.FI = aMb;
        this.aMg.setText(String.format(getPageContext().getString(t.j.resend_code_second), Integer.valueOf(this.FI)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void pU() {
        this.aLG = (RelativeLayout) findViewById(t.g.container);
        this.aMo = findViewById(t.g.title);
        this.aMp = (TextView) findViewById(t.g.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ajA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.create_bar));
        this.aMi = (RelativeLayout) findViewById(t.g.done);
        this.aMi.setEnabled(false);
        this.aMj = (RelativeLayout) findViewById(t.g.resend);
        this.ajA.setOnClickListener(this.mOnClickListener);
        this.aMi.setOnClickListener(this.mOnClickListener);
        this.aMj.setOnClickListener(this.mOnClickListener);
        this.aMg = (TextView) findViewById(t.g.resend_text);
        this.aMh = (EditText) findViewById(t.g.edit_code);
        this.aMh.addTextChangedListener(this.aMu);
        this.aMh.setOnFocusChangeListener(this.aMv);
        this.aMe = (ProgressBar) findViewById(t.g.progress_resend);
        this.aMf = (ProgressBar) findViewById(t.g.progress_done);
        this.aMd = (ImageView) findViewById(t.g.del_code);
        this.aMd.setOnClickListener(this.mOnClickListener);
        this.aoA = (TextView) findViewById(t.g.text_error);
        this.aMc = (LinearLayout) findViewById(t.g.sms_code_input_bg);
        this.aMr = this.aMc.getPaddingLeft();
        this.aMs = this.aMc.getPaddingRight();
        this.aMc.setBackgroundResource(t.f.pass_input);
        this.aMc.setPadding(this.aMr, 0, this.aMs, 0);
        this.aMq = (TextView) findViewById(t.g.no_receive_code);
        ShowSoftKeyPadDelay(this.aMh, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.g(this.aLG, i);
        at.i(this.aMo, i);
        at.b(this.aMp, i);
        at.b(this.aMg, i);
        at.c(this.aMq, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(boolean z) {
        this.aMh.setEnabled(z);
        this.aMh.setFocusable(z);
        this.aMh.setFocusableInTouchMode(z);
        this.aMd.setEnabled(z);
        if (z) {
            this.aMh.setTextColor(getResources().getColor(t.d.reg_font_color));
        } else {
            this.aMh.setTextColor(getResources().getColor(t.d.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.x xVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(xVar.getUser().getUserName());
        if (xVar.getUser().getPassword() != null) {
            accountData.setPassword(xVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aMn.getPsw());
        }
        accountData.setID(xVar.getUser().getUserId());
        accountData.setBDUSS(xVar.getUser().getBDUSS());
        accountData.setPortrait(xVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (xVar.sf() != null) {
            accountData.setTbs(xVar.sf().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.anD) {
            JJ();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.x> {
        private ab QV;

        private a() {
            this.QV = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tbadk.core.data.x doInBackground(String... strArr) {
            try {
                this.QV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.QV.p("un", ActivationActivity.this.aMn.getName());
                this.QV.p("phonenum", ActivationActivity.this.aMn.getPhone());
                this.QV.p("passwd", ActivationActivity.this.aMn.getPsw());
                if (ActivationActivity.this.aMn.getVcode() != null) {
                    this.QV.p("vcode", ActivationActivity.this.aMn.getVcode());
                }
                if (ActivationActivity.this.aMn.getVcodeMd5() != null) {
                    this.QV.p(CommonVcodeActivityConfig.VCODE_MD5, ActivationActivity.this.aMn.getVcodeMd5());
                }
                this.QV.p("smscode", ActivationActivity.this.aMh.getText().toString());
                String vw = this.QV.vw();
                if (this.QV.vU().wP().qC()) {
                    com.baidu.tbadk.core.data.x xVar = new com.baidu.tbadk.core.data.x();
                    xVar.parserJson(vw);
                    return xVar;
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
        public void onPostExecute(com.baidu.tbadk.core.data.x xVar) {
            super.onPostExecute(xVar);
            ActivationActivity.this.aMf.setVisibility(8);
            ActivationActivity.this.aMl = null;
            ActivationActivity.this.bT(true);
            if (ActivationActivity.this.aMm) {
                ActivationActivity.this.aMj.setEnabled(true);
            }
            if (xVar != null) {
                ActivationActivity.this.a(xVar);
                return;
            }
            String errorString = this.QV.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aoA.setVisibility(0);
                ActivationActivity.this.aoA.setText(errorString);
            }
            if (this.QV.vY() == 26) {
                ActivationActivity.this.aMt = 26;
                ActivationActivity.this.aMc.setBackgroundResource(t.f.pass_input_wrong);
                ActivationActivity.this.aMc.setPadding(ActivationActivity.this.aMr, 0, ActivationActivity.this.aMs, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aMf.setVisibility(0);
            ActivationActivity.this.aMj.setEnabled(false);
            ActivationActivity.this.bT(false);
            ActivationActivity.this.aoA.setVisibility(4);
            ActivationActivity.this.aoA.setText((CharSequence) null);
            ActivationActivity.this.aMc.setBackgroundResource(t.f.pass_input);
            ActivationActivity.this.aMc.setPadding(ActivationActivity.this.aMr, 0, ActivationActivity.this.aMs, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aMl = null;
            ActivationActivity.this.aMf.setVisibility(8);
            if (ActivationActivity.this.aMm) {
                ActivationActivity.this.aMj.setEnabled(true);
            }
            if (this.QV != null) {
                this.QV.gX();
            }
            ActivationActivity.this.bT(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private ab QV;

        private b() {
            this.QV = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aMk = null;
            ActivationActivity.this.aMe.setVisibility(8);
            if (ActivationActivity.this.aMh.length() == 6) {
                ActivationActivity.this.aMi.setEnabled(true);
            }
            if (this.QV != null) {
                this.QV.gX();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            boolean z = false;
            try {
                this.QV = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.QV.p("phonenum", ActivationActivity.this.aMn.getPhone());
                this.QV.vw();
                if (this.QV.vU().wP().qC()) {
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
            ActivationActivity.this.aMk = null;
            ActivationActivity.this.aMe.setVisibility(8);
            if (ActivationActivity.this.aMh.length() == 6) {
                ActivationActivity.this.aMi.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.JI();
                return;
            }
            String errorString = this.QV.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aoA.setVisibility(0);
                ActivationActivity.this.aoA.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aMe.setVisibility(0);
            ActivationActivity.this.aoA.setVisibility(4);
            ActivationActivity.this.aoA.setText((CharSequence) null);
            ActivationActivity.this.aMi.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void JJ() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.hy().b(new s(this));
        }
    }
}
