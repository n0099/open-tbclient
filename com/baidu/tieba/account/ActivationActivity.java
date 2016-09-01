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
import com.baidu.tbadk.core.data.ae;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aRW = 60;
    public NavigationBar mNavigationBar;
    private View ajw = null;
    private LinearLayout aRX = null;
    private ImageView aRY = null;
    private ProgressBar aRZ = null;
    private ProgressBar aSa = null;
    private TextView aSb = null;
    private TextView aoQ = null;
    private EditText aSc = null;
    private RelativeLayout aSd = null;
    private RelativeLayout aSe = null;
    private b aSf = null;
    private a aSg = null;
    private boolean aSh = false;
    private int yP = aRW;
    private RegistData aSi = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aRB = null;
    private View aSj = null;
    private TextView aSk = null;
    private TextView aSl = null;
    private int aSm = 0;
    private int aSn = 0;
    private boolean anS = false;
    private int aSo = 0;
    private final Runnable mRunnable = new p(this);
    private final View.OnClickListener mOnClickListener = new q(this);
    private final TextWatcher aSp = new r(this);
    private final View.OnFocusChangeListener aSq = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.account_register_activation);
        initData(bundle);
        initUI();
        LB();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aSi = (RegistData) bundle.getSerializable("data");
            this.anS = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aSi = (RegistData) intent.getSerializableExtra("data");
            this.anS = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aSi == null) {
            setResult(0);
            finish();
        } else if (this.aSi.getSmsCodeTime() > 0) {
            aRW = this.aSi.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aSi = (RegistData) bundle.getSerializable("data");
        this.anS = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aSi);
        bundle.putBoolean(IntentConfig.CLOSE, this.anS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aSf != null) {
            this.aSf.cancel();
        }
        if (this.aSg != null) {
            this.aSg.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LB() {
        this.aSh = false;
        this.aSe.setEnabled(false);
        this.yP = aRW;
        this.aSb.setText(String.format(getPageContext().getString(t.j.resend_code_second), Integer.valueOf(this.yP)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aRB = (RelativeLayout) findViewById(t.g.container);
        this.aSj = findViewById(t.g.title);
        this.aSk = (TextView) findViewById(t.g.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ajw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.create_bar));
        this.aSd = (RelativeLayout) findViewById(t.g.done);
        this.aSd.setEnabled(false);
        this.aSe = (RelativeLayout) findViewById(t.g.resend);
        this.ajw.setOnClickListener(this.mOnClickListener);
        this.aSd.setOnClickListener(this.mOnClickListener);
        this.aSe.setOnClickListener(this.mOnClickListener);
        this.aSb = (TextView) findViewById(t.g.resend_text);
        this.aSc = (EditText) findViewById(t.g.edit_code);
        this.aSc.addTextChangedListener(this.aSp);
        this.aSc.setOnFocusChangeListener(this.aSq);
        this.aRZ = (ProgressBar) findViewById(t.g.progress_resend);
        this.aSa = (ProgressBar) findViewById(t.g.progress_done);
        this.aRY = (ImageView) findViewById(t.g.del_code);
        this.aRY.setOnClickListener(this.mOnClickListener);
        this.aoQ = (TextView) findViewById(t.g.text_error);
        this.aRX = (LinearLayout) findViewById(t.g.sms_code_input_bg);
        this.aSm = this.aRX.getPaddingLeft();
        this.aSn = this.aRX.getPaddingRight();
        this.aRX.setBackgroundResource(t.f.pass_input);
        this.aRX.setPadding(this.aSm, 0, this.aSn, 0);
        this.aSl = (TextView) findViewById(t.g.no_receive_code);
        ShowSoftKeyPadDelay(this.aSc, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.g(this.aRB, i);
        av.i(this.aSj, i);
        av.b(this.aSk, i);
        av.b(this.aSb, i);
        av.c(this.aSl, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        this.aSc.setEnabled(z);
        this.aSc.setFocusable(z);
        this.aSc.setFocusableInTouchMode(z);
        this.aRY.setEnabled(z);
        if (z) {
            this.aSc.setTextColor(getResources().getColor(t.d.common_color_10046));
        } else {
            this.aSc.setTextColor(getResources().getColor(t.d.common_color_10003));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ae aeVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(aeVar.getUser().getUserName());
        if (aeVar.getUser().getPassword() != null) {
            accountData.setPassword(aeVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aSi.getPsw());
        }
        accountData.setID(aeVar.getUser().getUserId());
        accountData.setBDUSS(aeVar.getUser().getBDUSS());
        accountData.setPortrait(aeVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (aeVar.qf() != null) {
            accountData.setTbs(aeVar.qf().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.anS) {
            LC();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, ae> {
        private ab NX;

        private a() {
            this.NX = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public ae doInBackground(String... strArr) {
            try {
                this.NX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.NX.n("un", ActivationActivity.this.aSi.getName());
                this.NX.n("phonenum", ActivationActivity.this.aSi.getPhone());
                this.NX.n("passwd", ActivationActivity.this.aSi.getPsw());
                if (ActivationActivity.this.aSi.getVcode() != null) {
                    this.NX.n("vcode", ActivationActivity.this.aSi.getVcode());
                }
                if (ActivationActivity.this.aSi.getVcodeMd5() != null) {
                    this.NX.n(GraffitiVcodeActivityConfig.VCODE_MD5, ActivationActivity.this.aSi.getVcodeMd5());
                }
                this.NX.n("smscode", ActivationActivity.this.aSc.getText().toString());
                String ue = this.NX.ue();
                if (this.NX.uD().vA().oE()) {
                    ae aeVar = new ae();
                    aeVar.parserJson(ue);
                    return aeVar;
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
        public void onPostExecute(ae aeVar) {
            super.onPostExecute(aeVar);
            ActivationActivity.this.aSa.setVisibility(8);
            ActivationActivity.this.aSg = null;
            ActivationActivity.this.ck(true);
            if (ActivationActivity.this.aSh) {
                ActivationActivity.this.aSe.setEnabled(true);
            }
            if (aeVar != null) {
                ActivationActivity.this.a(aeVar);
                return;
            }
            String errorString = this.NX.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aoQ.setVisibility(0);
                ActivationActivity.this.aoQ.setText(errorString);
            }
            if (this.NX.uH() == 26) {
                ActivationActivity.this.aSo = 26;
                ActivationActivity.this.aRX.setBackgroundResource(t.f.pass_input_wrong);
                ActivationActivity.this.aRX.setPadding(ActivationActivity.this.aSm, 0, ActivationActivity.this.aSn, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aSa.setVisibility(0);
            ActivationActivity.this.aSe.setEnabled(false);
            ActivationActivity.this.ck(false);
            ActivationActivity.this.aoQ.setVisibility(4);
            ActivationActivity.this.aoQ.setText((CharSequence) null);
            ActivationActivity.this.aRX.setBackgroundResource(t.f.pass_input);
            ActivationActivity.this.aRX.setPadding(ActivationActivity.this.aSm, 0, ActivationActivity.this.aSn, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aSg = null;
            ActivationActivity.this.aSa.setVisibility(8);
            if (ActivationActivity.this.aSh) {
                ActivationActivity.this.aSe.setEnabled(true);
            }
            if (this.NX != null) {
                this.NX.eg();
            }
            ActivationActivity.this.ck(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private ab NX;

        private b() {
            this.NX = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aSf = null;
            ActivationActivity.this.aRZ.setVisibility(8);
            if (ActivationActivity.this.aSc.length() == 6) {
                ActivationActivity.this.aSd.setEnabled(true);
            }
            if (this.NX != null) {
                this.NX.eg();
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
                this.NX = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.NX.n("phonenum", ActivationActivity.this.aSi.getPhone());
                this.NX.ue();
                if (this.NX.uD().vA().oE()) {
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
            ActivationActivity.this.aSf = null;
            ActivationActivity.this.aRZ.setVisibility(8);
            if (ActivationActivity.this.aSc.length() == 6) {
                ActivationActivity.this.aSd.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.LB();
                return;
            }
            String errorString = this.NX.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aoQ.setVisibility(0);
                ActivationActivity.this.aoQ.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aRZ.setVisibility(0);
            ActivationActivity.this.aoQ.setVisibility(4);
            ActivationActivity.this.aoQ.setText((CharSequence) null);
            ActivationActivity.this.aSd.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void LC() {
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.eH().e(new t(this));
        }
    }
}
