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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int aJf = 60;
    public NavigationBar mNavigationBar;
    private View ajk = null;
    private LinearLayout aJg = null;
    private ImageView aJh = null;
    private ProgressBar aJi = null;
    private ProgressBar aJj = null;
    private TextView aJk = null;
    private TextView aoj = null;
    private EditText aJl = null;
    private RelativeLayout aJm = null;
    private RelativeLayout aJn = null;
    private b aJo = null;
    private a aJp = null;
    private boolean aJq = false;
    private int FC = aJf;
    private RegistData aJr = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aIK = null;
    private View aJs = null;
    private TextView aJt = null;
    private TextView aJu = null;
    private int aJv = 0;
    private int aJw = 0;
    private boolean anm = false;
    private int aJx = 0;
    private final Runnable mRunnable = new p(this);
    private final View.OnClickListener mOnClickListener = new q(this);
    private final TextWatcher aJy = new r(this);
    private final View.OnFocusChangeListener aJz = new s(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(t.h.account_register_activation);
        initData(bundle);
        qD();
        Im();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.aJr = (RegistData) bundle.getSerializable("data");
            this.anm = bundle.getBoolean(IntentConfig.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.aJr = (RegistData) intent.getSerializableExtra("data");
            this.anm = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        }
        if (this.aJr == null) {
            setResult(0);
            finish();
        } else if (this.aJr.getSmsCodeTime() > 0) {
            aJf = this.aJr.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aJr = (RegistData) bundle.getSerializable("data");
        this.anm = bundle.getBoolean(IntentConfig.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aJr);
        bundle.putBoolean(IntentConfig.CLOSE, this.anm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aJo != null) {
            this.aJo.cancel();
        }
        if (this.aJp != null) {
            this.aJp.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im() {
        this.aJq = false;
        this.aJn.setEnabled(false);
        this.FC = aJf;
        this.aJk.setText(String.format(getPageContext().getString(t.j.resend_code_second), Integer.valueOf(this.FC)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void qD() {
        this.aIK = (RelativeLayout) findViewById(t.g.container);
        this.aJs = findViewById(t.g.title);
        this.aJt = (TextView) findViewById(t.g.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.ajk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.create_bar));
        this.aJm = (RelativeLayout) findViewById(t.g.done);
        this.aJm.setEnabled(false);
        this.aJn = (RelativeLayout) findViewById(t.g.resend);
        this.ajk.setOnClickListener(this.mOnClickListener);
        this.aJm.setOnClickListener(this.mOnClickListener);
        this.aJn.setOnClickListener(this.mOnClickListener);
        this.aJk = (TextView) findViewById(t.g.resend_text);
        this.aJl = (EditText) findViewById(t.g.edit_code);
        this.aJl.addTextChangedListener(this.aJy);
        this.aJl.setOnFocusChangeListener(this.aJz);
        this.aJi = (ProgressBar) findViewById(t.g.progress_resend);
        this.aJj = (ProgressBar) findViewById(t.g.progress_done);
        this.aJh = (ImageView) findViewById(t.g.del_code);
        this.aJh.setOnClickListener(this.mOnClickListener);
        this.aoj = (TextView) findViewById(t.g.text_error);
        this.aJg = (LinearLayout) findViewById(t.g.sms_code_input_bg);
        this.aJv = this.aJg.getPaddingLeft();
        this.aJw = this.aJg.getPaddingRight();
        this.aJg.setBackgroundResource(t.f.pass_input);
        this.aJg.setPadding(this.aJv, 0, this.aJw, 0);
        this.aJu = (TextView) findViewById(t.g.no_receive_code);
        ShowSoftKeyPadDelay(this.aJl, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ar.g(this.aIK, i);
        ar.i(this.aJs, i);
        ar.b(this.aJt, i);
        ar.b(this.aJk, i);
        ar.c(this.aJu, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        this.aJl.setEnabled(z);
        this.aJl.setFocusable(z);
        this.aJl.setFocusableInTouchMode(z);
        this.aJh.setEnabled(z);
        if (z) {
            this.aJl.setTextColor(getResources().getColor(t.d.reg_font_color));
        } else {
            this.aJl.setTextColor(getResources().getColor(t.d.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.r rVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(rVar.getUser().getUserName());
        if (rVar.getUser().getPassword() != null) {
            accountData.setPassword(rVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aJr.getPsw());
        }
        accountData.setID(rVar.getUser().getUserId());
        accountData.setBDUSS(rVar.getUser().getBDUSS());
        accountData.setPortrait(rVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (rVar.so() != null) {
            accountData.setTbs(rVar.so().getTbs());
        }
        com.baidu.tbadk.core.a.b.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        setResult(-1);
        finish();
        if (this.anm) {
            In();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, com.baidu.tbadk.core.data.r> {
        private aa Ty;

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
        /* renamed from: q */
        public com.baidu.tbadk.core.data.r doInBackground(String... strArr) {
            try {
                this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/regreal");
                this.Ty.p("un", ActivationActivity.this.aJr.getName());
                this.Ty.p("phonenum", ActivationActivity.this.aJr.getPhone());
                this.Ty.p("passwd", ActivationActivity.this.aJr.getPsw());
                if (ActivationActivity.this.aJr.getVcode() != null) {
                    this.Ty.p("vcode", ActivationActivity.this.aJr.getVcode());
                }
                if (ActivationActivity.this.aJr.getVcodeMd5() != null) {
                    this.Ty.p("vcode_md5", ActivationActivity.this.aJr.getVcodeMd5());
                }
                this.Ty.p("smscode", ActivationActivity.this.aJl.getText().toString());
                String uZ = this.Ty.uZ();
                if (this.Ty.vB().ww().rl()) {
                    com.baidu.tbadk.core.data.r rVar = new com.baidu.tbadk.core.data.r();
                    rVar.parserJson(uZ);
                    return rVar;
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
        public void onPostExecute(com.baidu.tbadk.core.data.r rVar) {
            super.onPostExecute(rVar);
            ActivationActivity.this.aJj.setVisibility(8);
            ActivationActivity.this.aJp = null;
            ActivationActivity.this.bK(true);
            if (ActivationActivity.this.aJq) {
                ActivationActivity.this.aJn.setEnabled(true);
            }
            if (rVar != null) {
                ActivationActivity.this.a(rVar);
                return;
            }
            String errorString = this.Ty.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aoj.setVisibility(0);
                ActivationActivity.this.aoj.setText(errorString);
            }
            if (this.Ty.vF() == 26) {
                ActivationActivity.this.aJx = 26;
                ActivationActivity.this.aJg.setBackgroundResource(t.f.pass_input_wrong);
                ActivationActivity.this.aJg.setPadding(ActivationActivity.this.aJv, 0, ActivationActivity.this.aJw, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aJj.setVisibility(0);
            ActivationActivity.this.aJn.setEnabled(false);
            ActivationActivity.this.bK(false);
            ActivationActivity.this.aoj.setVisibility(4);
            ActivationActivity.this.aoj.setText((CharSequence) null);
            ActivationActivity.this.aJg.setBackgroundResource(t.f.pass_input);
            ActivationActivity.this.aJg.setPadding(ActivationActivity.this.aJv, 0, ActivationActivity.this.aJw, 0);
            super.onPreExecute();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aJp = null;
            ActivationActivity.this.aJj.setVisibility(8);
            if (ActivationActivity.this.aJq) {
                ActivationActivity.this.aJn.setEnabled(true);
            }
            if (this.Ty != null) {
                this.Ty.gT();
            }
            ActivationActivity.this.bK(true);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Boolean> {
        private aa Ty;

        private b() {
            this.Ty = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ b(ActivationActivity activationActivity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ActivationActivity.this.aJo = null;
            ActivationActivity.this.aJi.setVisibility(8);
            if (ActivationActivity.this.aJl.length() == 6) {
                ActivationActivity.this.aJm.setEnabled(true);
            }
            if (this.Ty != null) {
                this.Ty.gT();
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
                this.Ty = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/s/getsmscode");
                this.Ty.p("phonenum", ActivationActivity.this.aJr.getPhone());
                this.Ty.uZ();
                if (this.Ty.vB().ww().rl()) {
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
            ActivationActivity.this.aJo = null;
            ActivationActivity.this.aJi.setVisibility(8);
            if (ActivationActivity.this.aJl.length() == 6) {
                ActivationActivity.this.aJm.setEnabled(true);
            }
            if (bool.booleanValue()) {
                ActivationActivity.this.Im();
                return;
            }
            String errorString = this.Ty.getErrorString();
            if (errorString != null && errorString.length() > 0) {
                ActivationActivity.this.aoj.setVisibility(0);
                ActivationActivity.this.aoj.setText(errorString);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ActivationActivity.this.aJi.setVisibility(0);
            ActivationActivity.this.aoj.setVisibility(4);
            ActivationActivity.this.aoj.setText((CharSequence) null);
            ActivationActivity.this.aJm.setEnabled(false);
            super.onPreExecute();
        }
    }

    private void In() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.h.k.hs().b(new t(this));
        }
    }
}
