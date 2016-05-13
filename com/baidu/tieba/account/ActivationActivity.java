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
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aIl = 60;
    public NavigationBar mNavigationBar;
    private View afm = null;
    private LinearLayout aIm = null;
    private ImageView aIn = null;
    private ProgressBar aIo = null;
    private ProgressBar aIp = null;
    private TextView aIq = null;
    private TextView ako = null;
    private EditText aIr = null;
    private RelativeLayout aIs = null;
    private RelativeLayout aIt = null;
    private b aIu = null;
    private a aIv = null;
    private boolean aIw = false;
    private int wa = aIl;
    private RegistData aIx = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aHR = null;
    private View aIy = null;
    private TextView aIz = null;
    private TextView aIA = null;
    private int aIB = 0;
    private int aIC = 0;
    private boolean ajr = false;
    private int aID = 0;
    private final Runnable mRunnable = new o(this);
    private final View.OnClickListener mOnClickListener = new p(this);
    private final TextWatcher aIE = new q(this);
    private final View.OnFocusChangeListener aIF = new r(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.account_register_activation);
        initData(bundle);
        nq();
        Ib();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aIx = (RegistData) bundle.getSerializable("data");
            this.ajr = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aIx = (RegistData) intent.getSerializableExtra("data");
            this.ajr = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aIx == null) {
            setResult(0);
            finish();
        } else if (this.aIx.getSmsCodeTime() > 0) {
            aIl = this.aIx.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aIx = (RegistData) bundle.getSerializable("data");
        this.ajr = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aIx);
        bundle.putBoolean(IntentConfig.CLOSE, this.ajr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aIu != null) {
            this.aIu.cancel();
        }
        if (this.aIv != null) {
            this.aIv.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib() {
        this.aIw = false;
        this.aIt.setEnabled(false);
        this.wa = aIl;
        this.aIq.setText(String.format(getPageContext().getString(t.j.resend_code_second), Integer.valueOf(this.wa)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void nq() {
        this.aHR = (RelativeLayout) findViewById(t.g.container);
        this.aIy = findViewById(t.g.title);
        this.aIz = (TextView) findViewById(t.g.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.afm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.create_bar));
        this.aIs = (RelativeLayout) findViewById(t.g.done);
        this.aIs.setEnabled(false);
        this.aIt = (RelativeLayout) findViewById(t.g.resend);
        this.afm.setOnClickListener(this.mOnClickListener);
        this.aIs.setOnClickListener(this.mOnClickListener);
        this.aIt.setOnClickListener(this.mOnClickListener);
        this.aIq = (TextView) findViewById(t.g.resend_text);
        this.aIr = (EditText) findViewById(t.g.edit_code);
        this.aIr.addTextChangedListener(this.aIE);
        this.aIr.setOnFocusChangeListener(this.aIF);
        this.aIo = (ProgressBar) findViewById(t.g.progress_resend);
        this.aIp = (ProgressBar) findViewById(t.g.progress_done);
        this.aIn = (ImageView) findViewById(t.g.del_code);
        this.aIn.setOnClickListener(this.mOnClickListener);
        this.ako = (TextView) findViewById(t.g.text_error);
        this.aIm = (LinearLayout) findViewById(t.g.sms_code_input_bg);
        this.aIB = this.aIm.getPaddingLeft();
        this.aIC = this.aIm.getPaddingRight();
        this.aIm.setBackgroundResource(t.f.pass_input);
        this.aIm.setPadding(this.aIB, 0, this.aIC, 0);
        this.aIA = (TextView) findViewById(t.g.no_receive_code);
        ShowSoftKeyPadDelay(this.aIr, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        at.g(this.aHR, i);
        at.i(this.aIy, i);
        at.b(this.aIz, i);
        at.b(this.aIq, i);
        at.c(this.aIA, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(boolean z) {
        this.aIr.setEnabled(z);
        this.aIr.setFocusable(z);
        this.aIr.setFocusableInTouchMode(z);
        this.aIn.setEnabled(z);
        if (z) {
            this.aIr.setTextColor(getResources().getColor(t.d.reg_font_color));
        } else {
            this.aIr.setTextColor(getResources().getColor(t.d.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(yVar.getUser().getUserName());
        if (yVar.getUser().getPassword() != null) {
            accountData.setPassword(yVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aIx.getPsw());
        }
        accountData.setID(yVar.getUser().getUserId());
        accountData.setBDUSS(yVar.getUser().getBDUSS());
        accountData.setPortrait(yVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (yVar.pz() != null) {
            accountData.setTbs(yVar.pz().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.ajr) {
            Ic();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, y> {
        private ab LL;

        private a() {
            this.LL = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public y doInBackground(String... strArr) {
            try {
                this.LL = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.LL.n("un", ActivationActivity.this.aIx.getName());
                this.LL.n("phonenum", ActivationActivity.this.aIx.getPhone());
                this.LL.n("passwd", ActivationActivity.this.aIx.getPsw());
                if (ActivationActivity.this.aIx.getVcode() != null) {
                    this.LL.n("vcode", ActivationActivity.this.aIx.getVcode());
                }
                if (ActivationActivity.this.aIx.getVcodeMd5() != null) {
                    this.LL.n(CommonVcodeActivityConfig.VCODE_MD5, ActivationActivity.this.aIx.getVcodeMd5());
                }
                this.LL.n("smscode", ActivationActivity.this.aIr.getText().toString());
                String td = this.LL.td();
                if (this.LL.tB().uw().nZ()) {
                    y yVar = new y();
                    yVar.parserJson(td);
                    return yVar;
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
        public void onPostExecute(y yVar) {
            super.onPostExecute(yVar);
            ActivationActivity.this.aIp.setVisibility(8);
            ActivationActivity.this.aIv = null;
            ActivationActivity.this.bZ(true);
            if (ActivationActivity.this.aIw) {
                ActivationActivity.this.aIt.setEnabled(true);
            }
            if (yVar != null) {
                ActivationActivity.this.a(yVar);
                return;
            }
            String errorString = this.LL.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.ako.setVisibility(0);
                ActivationActivity.this.ako.setText(errorString);
            }
            if (this.LL.tF() == 26) {
                ActivationActivity.this.aID = 26;
                ActivationActivity.this.aIm.setBackgroundResource(t.f.pass_input_wrong);
                ActivationActivity.this.aIm.setPadding(ActivationActivity.this.aIB, 0, ActivationActivity.this.aIC, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aIp.setVisibility(0);
            ActivationActivity.this.aIt.setEnabled(false);
            ActivationActivity.this.bZ(false);
            ActivationActivity.this.ako.setVisibility(4);
            ActivationActivity.this.ako.setText((CharSequence) null);
            ActivationActivity.this.aIm.setBackgroundResource(t.f.pass_input);
            ActivationActivity.this.aIm.setPadding(ActivationActivity.this.aIB, 0, ActivationActivity.this.aIC, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aIv = null;
            ActivationActivity.this.aIp.setVisibility(8);
            if (ActivationActivity.this.aIw) {
                ActivationActivity.this.aIt.setEnabled(true);
            }
            if (this.LL != null) {
                this.LL.dl();
            }
            ActivationActivity.this.bZ(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private ab LL;

        private b() {
            this.LL = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aIu = null;
            ActivationActivity.this.aIo.setVisibility(8);
            if (ActivationActivity.this.aIr.length() == 6) {
                ActivationActivity.this.aIs.setEnabled(true);
            }
            if (this.LL != null) {
                this.LL.dl();
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
                this.LL = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.LL.n("phonenum", ActivationActivity.this.aIx.getPhone());
                this.LL.td();
                if (this.LL.tB().uw().nZ()) {
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
            ActivationActivity.this.aIu = null;
            ActivationActivity.this.aIo.setVisibility(8);
            if (ActivationActivity.this.aIr.length() == 6) {
                ActivationActivity.this.aIs.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.Ib();
                return;
            }
            String errorString = this.LL.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.ako.setVisibility(0);
                ActivationActivity.this.ako.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aIo.setVisibility(0);
            ActivationActivity.this.ako.setVisibility(4);
            ActivationActivity.this.ako.setText((CharSequence) null);
            ActivationActivity.this.aIs.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void Ic() {
        if (TbadkCoreApplication.m11getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.dM().b(new s(this));
        }
    }
}
