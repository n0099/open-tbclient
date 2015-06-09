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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopRecActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int awC = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout awD = null;
    private ImageView awE = null;
    private ProgressBar awF = null;
    private ProgressBar awG = null;
    private TextView awH = null;
    private TextView afY = null;
    private EditText awI = null;
    private RelativeLayout awJ = null;
    private RelativeLayout awK = null;
    private ab awL = null;
    private aa awM = null;
    private boolean awN = false;
    private int EL = awC;
    private RegistData awO = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout awb = null;
    private View awP = null;
    private TextView mDoneText = null;
    private TextView awQ = null;
    private int awR = 0;
    private int awS = 0;
    private boolean aeX = false;
    private int awT = 0;
    private final Runnable mRunnable = new v(this);
    private final View.OnClickListener mOnClickListener = new w(this);
    private final TextWatcher awU = new x(this);
    private final View.OnFocusChangeListener awV = new y(this);

    public static void a(Activity activity, RegistData registData, int i, boolean z) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.c.CLOSE, registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(com.baidu.tieba.r.account_register_activation);
        initData(bundle);
        initUI();
        Fe();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.awO = (RegistData) bundle.getSerializable("data");
            this.aeX = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.awO = (RegistData) intent.getSerializableExtra("data");
            this.aeX = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
        }
        if (this.awO == null) {
            setResult(0);
            finish();
        } else if (this.awO.getSmsCodeTime() > 0) {
            awC = this.awO.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.awO = (RegistData) bundle.getSerializable("data");
        this.aeX = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.awO);
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.c.CLOSE, this.aeX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.awL != null) {
            this.awL.cancel();
        }
        if (this.awM != null) {
            this.awM.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fe() {
        this.awN = false;
        this.awK.setEnabled(false);
        this.EL = awC;
        this.awH.setText(String.format(getPageContext().getString(com.baidu.tieba.t.resend_code_second), Integer.valueOf(this.EL)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.awb = (RelativeLayout) findViewById(com.baidu.tieba.q.container);
        this.awP = findViewById(com.baidu.tieba.q.title);
        this.mDoneText = (TextView) findViewById(com.baidu.tieba.q.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.create_bar));
        this.awJ = (RelativeLayout) findViewById(com.baidu.tieba.q.done);
        this.awJ.setEnabled(false);
        this.awK = (RelativeLayout) findViewById(com.baidu.tieba.q.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.awJ.setOnClickListener(this.mOnClickListener);
        this.awK.setOnClickListener(this.mOnClickListener);
        this.awH = (TextView) findViewById(com.baidu.tieba.q.resend_text);
        this.awI = (EditText) findViewById(com.baidu.tieba.q.edit_code);
        this.awI.addTextChangedListener(this.awU);
        this.awI.setOnFocusChangeListener(this.awV);
        this.awF = (ProgressBar) findViewById(com.baidu.tieba.q.progress_resend);
        this.awG = (ProgressBar) findViewById(com.baidu.tieba.q.progress_done);
        this.awE = (ImageView) findViewById(com.baidu.tieba.q.del_code);
        this.awE.setOnClickListener(this.mOnClickListener);
        this.afY = (TextView) findViewById(com.baidu.tieba.q.text_error);
        this.awD = (LinearLayout) findViewById(com.baidu.tieba.q.sms_code_input_bg);
        this.awR = this.awD.getPaddingLeft();
        this.awS = this.awD.getPaddingRight();
        this.awD.setBackgroundResource(com.baidu.tieba.p.pass_input);
        this.awD.setPadding(this.awR, 0, this.awS, 0);
        this.awQ = (TextView) findViewById(com.baidu.tieba.q.no_receive_code);
        ShowSoftKeyPadDelay(this.awI, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ay.e(this.awb, i);
        ay.h(this.awP, i);
        ay.b(this.mDoneText, i);
        ay.b(this.awH, i);
        ay.c(this.awQ, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(boolean z) {
        this.awI.setEnabled(z);
        this.awI.setFocusable(z);
        this.awI.setFocusableInTouchMode(z);
        this.awE.setEnabled(z);
        if (z) {
            this.awI.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
        } else {
            this.awI.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(nVar.getUser().getUserName());
        if (nVar.getUser().getPassword() != null) {
            accountData.setPassword(nVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.awO.getPsw());
        }
        accountData.setID(nVar.getUser().getUserId());
        accountData.setBDUSS(nVar.getUser().getBDUSS());
        accountData.setPortrait(nVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (nVar.qK() != null) {
            accountData.setTbs(nVar.qK().getTbs());
        }
        com.baidu.tbadk.core.a.d.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        setResult(-1);
        finish();
        if (this.aeX) {
            vb();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
            return;
        }
        sendMessage(new CustomMessage(2002001, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }

    private void vb() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.l.ht().b(new z(this));
        }
    }
}
