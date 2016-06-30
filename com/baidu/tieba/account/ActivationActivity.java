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
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aLI = 60;
    public NavigationBar mNavigationBar;
    private View afN = null;
    private LinearLayout aLJ = null;
    private ImageView aLK = null;
    private ProgressBar aLL = null;
    private ProgressBar aLM = null;
    private TextView aLN = null;
    private TextView akU = null;
    private EditText aLO = null;
    private RelativeLayout aLP = null;
    private RelativeLayout aLQ = null;
    private b aLR = null;
    private a aLS = null;
    private boolean aLT = false;
    private int wc = aLI;
    private RegistData aLU = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aLn = null;
    private View aLV = null;
    private TextView aLW = null;
    private TextView aLX = null;
    private int aLY = 0;
    private int aLZ = 0;
    private boolean ajX = false;
    private int aMa = 0;
    private final Runnable mRunnable = new p(this);
    private final View.OnClickListener mOnClickListener = new q(this);
    private final TextWatcher aMb = new r(this);
    private final View.OnFocusChangeListener aMc = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(u.h.account_register_activation);
        initData(bundle);
        nl();
        Ja();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aLU = (RegistData) bundle.getSerializable("data");
            this.ajX = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aLU = (RegistData) intent.getSerializableExtra("data");
            this.ajX = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aLU == null) {
            setResult(0);
            finish();
        } else if (this.aLU.getSmsCodeTime() > 0) {
            aLI = this.aLU.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aLU = (RegistData) bundle.getSerializable("data");
        this.ajX = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aLU);
        bundle.putBoolean(IntentConfig.CLOSE, this.ajX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aLR != null) {
            this.aLR.cancel();
        }
        if (this.aLS != null) {
            this.aLS.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja() {
        this.aLT = false;
        this.aLQ.setEnabled(false);
        this.wc = aLI;
        this.aLN.setText(String.format(getPageContext().getString(u.j.resend_code_second), Integer.valueOf(this.wc)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void nl() {
        this.aLn = (RelativeLayout) findViewById(u.g.container);
        this.aLV = findViewById(u.g.title);
        this.aLW = (TextView) findViewById(u.g.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.afN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(u.j.create_bar));
        this.aLP = (RelativeLayout) findViewById(u.g.done);
        this.aLP.setEnabled(false);
        this.aLQ = (RelativeLayout) findViewById(u.g.resend);
        this.afN.setOnClickListener(this.mOnClickListener);
        this.aLP.setOnClickListener(this.mOnClickListener);
        this.aLQ.setOnClickListener(this.mOnClickListener);
        this.aLN = (TextView) findViewById(u.g.resend_text);
        this.aLO = (EditText) findViewById(u.g.edit_code);
        this.aLO.addTextChangedListener(this.aMb);
        this.aLO.setOnFocusChangeListener(this.aMc);
        this.aLL = (ProgressBar) findViewById(u.g.progress_resend);
        this.aLM = (ProgressBar) findViewById(u.g.progress_done);
        this.aLK = (ImageView) findViewById(u.g.del_code);
        this.aLK.setOnClickListener(this.mOnClickListener);
        this.akU = (TextView) findViewById(u.g.text_error);
        this.aLJ = (LinearLayout) findViewById(u.g.sms_code_input_bg);
        this.aLY = this.aLJ.getPaddingLeft();
        this.aLZ = this.aLJ.getPaddingRight();
        this.aLJ.setBackgroundResource(u.f.pass_input);
        this.aLJ.setPadding(this.aLY, 0, this.aLZ, 0);
        this.aLX = (TextView) findViewById(u.g.no_receive_code);
        ShowSoftKeyPadDelay(this.aLO, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        av.g(this.aLn, i);
        av.i(this.aLV, i);
        av.b(this.aLW, i);
        av.b(this.aLN, i);
        av.c(this.aLX, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(boolean z) {
        this.aLO.setEnabled(z);
        this.aLO.setFocusable(z);
        this.aLO.setFocusableInTouchMode(z);
        this.aLK.setEnabled(z);
        if (z) {
            this.aLO.setTextColor(getResources().getColor(u.d.common_color_10046));
        } else {
            this.aLO.setTextColor(getResources().getColor(u.d.common_color_10003));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aa aaVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(aaVar.getUser().getUserName());
        if (aaVar.getUser().getPassword() != null) {
            accountData.setPassword(aaVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aLU.getPsw());
        }
        accountData.setID(aaVar.getUser().getUserId());
        accountData.setBDUSS(aaVar.getUser().getBDUSS());
        accountData.setPortrait(aaVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (aaVar.pt() != null) {
            accountData.setTbs(aaVar.pt().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.ajX) {
            Jb();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, aa> {
        private ab LK;

        private a() {
            this.LK = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(ActivationActivity activationActivity, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: s */
        public aa doInBackground(String... strArr) {
            try {
                this.LK = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.LK.n("un", ActivationActivity.this.aLU.getName());
                this.LK.n("phonenum", ActivationActivity.this.aLU.getPhone());
                this.LK.n("passwd", ActivationActivity.this.aLU.getPsw());
                if (ActivationActivity.this.aLU.getVcode() != null) {
                    this.LK.n("vcode", ActivationActivity.this.aLU.getVcode());
                }
                if (ActivationActivity.this.aLU.getVcodeMd5() != null) {
                    this.LK.n(GraffitiVcodeActivityConfig.VCODE_MD5, ActivationActivity.this.aLU.getVcodeMd5());
                }
                this.LK.n("smscode", ActivationActivity.this.aLO.getText().toString());
                String ta = this.LK.ta();
                if (this.LK.ty().uv().nU()) {
                    aa aaVar = new aa();
                    aaVar.parserJson(ta);
                    return aaVar;
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
        public void onPostExecute(aa aaVar) {
            super.onPostExecute(aaVar);
            ActivationActivity.this.aLM.setVisibility(8);
            ActivationActivity.this.aLS = null;
            ActivationActivity.this.cc(true);
            if (ActivationActivity.this.aLT) {
                ActivationActivity.this.aLQ.setEnabled(true);
            }
            if (aaVar != null) {
                ActivationActivity.this.a(aaVar);
                return;
            }
            String errorString = this.LK.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.akU.setVisibility(0);
                ActivationActivity.this.akU.setText(errorString);
            }
            if (this.LK.tC() == 26) {
                ActivationActivity.this.aMa = 26;
                ActivationActivity.this.aLJ.setBackgroundResource(u.f.pass_input_wrong);
                ActivationActivity.this.aLJ.setPadding(ActivationActivity.this.aLY, 0, ActivationActivity.this.aLZ, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aLM.setVisibility(0);
            ActivationActivity.this.aLQ.setEnabled(false);
            ActivationActivity.this.cc(false);
            ActivationActivity.this.akU.setVisibility(4);
            ActivationActivity.this.akU.setText((CharSequence) null);
            ActivationActivity.this.aLJ.setBackgroundResource(u.f.pass_input);
            ActivationActivity.this.aLJ.setPadding(ActivationActivity.this.aLY, 0, ActivationActivity.this.aLZ, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aLS = null;
            ActivationActivity.this.aLM.setVisibility(8);
            if (ActivationActivity.this.aLT) {
                ActivationActivity.this.aLQ.setEnabled(true);
            }
            if (this.LK != null) {
                this.LK.dm();
            }
            ActivationActivity.this.cc(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private ab LK;

        private b() {
            this.LK = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aLR = null;
            ActivationActivity.this.aLL.setVisibility(8);
            if (ActivationActivity.this.aLO.length() == 6) {
                ActivationActivity.this.aLP.setEnabled(true);
            }
            if (this.LK != null) {
                this.LK.dm();
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
                this.LK = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.LK.n("phonenum", ActivationActivity.this.aLU.getPhone());
                this.LK.ta();
                if (this.LK.ty().uv().nU()) {
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
            ActivationActivity.this.aLR = null;
            ActivationActivity.this.aLL.setVisibility(8);
            if (ActivationActivity.this.aLO.length() == 6) {
                ActivationActivity.this.aLP.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.Ja();
                return;
            }
            String errorString = this.LK.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.akU.setVisibility(0);
                ActivationActivity.this.akU.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aLL.setVisibility(0);
            ActivationActivity.this.akU.setVisibility(4);
            ActivationActivity.this.akU.setText((CharSequence) null);
            ActivationActivity.this.aLP.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void Jb() {
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.dN().b(new t(this));
        }
    }
}
