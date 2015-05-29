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
    private static int awB = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout awC = null;
    private ImageView awD = null;
    private ProgressBar awE = null;
    private ProgressBar awF = null;
    private TextView awG = null;
    private TextView afY = null;
    private EditText awH = null;
    private RelativeLayout awI = null;
    private RelativeLayout awJ = null;
    private ab awK = null;
    private aa awL = null;
    private boolean awM = false;
    private int EL = awB;
    private RegistData awN = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout awa = null;
    private View awO = null;
    private TextView mDoneText = null;
    private TextView awP = null;
    private int awQ = 0;
    private int awR = 0;
    private boolean aeX = false;
    private int awS = 0;
    private final Runnable mRunnable = new v(this);
    private final View.OnClickListener mOnClickListener = new w(this);
    private final TextWatcher awT = new x(this);
    private final View.OnFocusChangeListener awU = new y(this);

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
        Fd();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.awN = (RegistData) bundle.getSerializable("data");
            this.aeX = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
        } else {
            Intent intent = getIntent();
            this.awN = (RegistData) intent.getSerializableExtra("data");
            this.aeX = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
        }
        if (this.awN == null) {
            setResult(0);
            finish();
        } else if (this.awN.getSmsCodeTime() > 0) {
            awB = this.awN.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.awN = (RegistData) bundle.getSerializable("data");
        this.aeX = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.awN);
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.c.CLOSE, this.aeX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.awK != null) {
            this.awK.cancel();
        }
        if (this.awL != null) {
            this.awL.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        this.awM = false;
        this.awJ.setEnabled(false);
        this.EL = awB;
        this.awG.setText(String.format(getPageContext().getString(com.baidu.tieba.t.resend_code_second), Integer.valueOf(this.EL)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.awa = (RelativeLayout) findViewById(com.baidu.tieba.q.container);
        this.awO = findViewById(com.baidu.tieba.q.title);
        this.mDoneText = (TextView) findViewById(com.baidu.tieba.q.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.create_bar));
        this.awI = (RelativeLayout) findViewById(com.baidu.tieba.q.done);
        this.awI.setEnabled(false);
        this.awJ = (RelativeLayout) findViewById(com.baidu.tieba.q.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.awI.setOnClickListener(this.mOnClickListener);
        this.awJ.setOnClickListener(this.mOnClickListener);
        this.awG = (TextView) findViewById(com.baidu.tieba.q.resend_text);
        this.awH = (EditText) findViewById(com.baidu.tieba.q.edit_code);
        this.awH.addTextChangedListener(this.awT);
        this.awH.setOnFocusChangeListener(this.awU);
        this.awE = (ProgressBar) findViewById(com.baidu.tieba.q.progress_resend);
        this.awF = (ProgressBar) findViewById(com.baidu.tieba.q.progress_done);
        this.awD = (ImageView) findViewById(com.baidu.tieba.q.del_code);
        this.awD.setOnClickListener(this.mOnClickListener);
        this.afY = (TextView) findViewById(com.baidu.tieba.q.text_error);
        this.awC = (LinearLayout) findViewById(com.baidu.tieba.q.sms_code_input_bg);
        this.awQ = this.awC.getPaddingLeft();
        this.awR = this.awC.getPaddingRight();
        this.awC.setBackgroundResource(com.baidu.tieba.p.pass_input);
        this.awC.setPadding(this.awQ, 0, this.awR, 0);
        this.awP = (TextView) findViewById(com.baidu.tieba.q.no_receive_code);
        ShowSoftKeyPadDelay(this.awH, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ay.e(this.awa, i);
        ay.h(this.awO, i);
        ay.b(this.mDoneText, i);
        ay.b(this.awG, i);
        ay.c(this.awP, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(boolean z) {
        this.awH.setEnabled(z);
        this.awH.setFocusable(z);
        this.awH.setFocusableInTouchMode(z);
        this.awD.setEnabled(z);
        if (z) {
            this.awH.setTextColor(getResources().getColor(com.baidu.tieba.n.reg_font_color));
        } else {
            this.awH.setTextColor(getResources().getColor(com.baidu.tieba.n.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(nVar.getUser().getUserName());
        if (nVar.getUser().getPassword() != null) {
            accountData.setPassword(nVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.awN.getPsw());
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
