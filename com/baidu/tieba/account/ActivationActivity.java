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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int auR = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout auS = null;
    private ImageView auT = null;
    private ProgressBar auU = null;
    private ProgressBar auV = null;
    private TextView auW = null;
    private TextView aeO = null;
    private EditText auX = null;
    private RelativeLayout auY = null;
    private RelativeLayout auZ = null;
    private aa ava = null;
    private z avb = null;
    private boolean avc = false;
    private int EU = auR;
    private RegistData avd = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aup = null;
    private View ave = null;
    private TextView avf = null;
    private TextView avg = null;
    private int avh = 0;
    private int avi = 0;
    private int avj = 0;
    private final Runnable mRunnable = new v(this);
    private final View.OnClickListener mOnClickListener = new w(this);
    private final TextWatcher avk = new x(this);
    private final View.OnFocusChangeListener avl = new y(this);

    public static void a(Activity activity, RegistData registData, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(com.baidu.tieba.w.account_register_activation);
        initData(bundle);
        initUI();
        Ek();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.avd = (RegistData) bundle.getSerializable("data");
        } else {
            this.avd = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.avd == null) {
            setResult(0);
            finish();
        } else if (this.avd.getSmsCodeTime() > 0) {
            auR = this.avd.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.avd = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.avd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.ava != null) {
            this.ava.cancel();
        }
        if (this.avb != null) {
            this.avb.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ek() {
        this.avc = false;
        this.auZ.setEnabled(false);
        this.EU = auR;
        this.auW.setText(String.format(getPageContext().getString(com.baidu.tieba.y.resend_code_second), Integer.valueOf(this.EU)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aup = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.ave = findViewById(com.baidu.tieba.v.title);
        this.avf = (TextView) findViewById(com.baidu.tieba.v.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.create_bar));
        this.auY = (RelativeLayout) findViewById(com.baidu.tieba.v.done);
        this.auY.setEnabled(false);
        this.auZ = (RelativeLayout) findViewById(com.baidu.tieba.v.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.auY.setOnClickListener(this.mOnClickListener);
        this.auZ.setOnClickListener(this.mOnClickListener);
        this.auW = (TextView) findViewById(com.baidu.tieba.v.resend_text);
        this.auX = (EditText) findViewById(com.baidu.tieba.v.edit_code);
        this.auX.addTextChangedListener(this.avk);
        this.auX.setOnFocusChangeListener(this.avl);
        this.auU = (ProgressBar) findViewById(com.baidu.tieba.v.progress_resend);
        this.auV = (ProgressBar) findViewById(com.baidu.tieba.v.progress_done);
        this.auT = (ImageView) findViewById(com.baidu.tieba.v.del_code);
        this.auT.setOnClickListener(this.mOnClickListener);
        this.aeO = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.auS = (LinearLayout) findViewById(com.baidu.tieba.v.sms_code_input_bg);
        this.avh = this.auS.getPaddingLeft();
        this.avi = this.auS.getPaddingRight();
        this.auS.setBackgroundResource(com.baidu.tieba.u.pass_input);
        this.auS.setPadding(this.avh, 0, this.avi, 0);
        this.avg = (TextView) findViewById(com.baidu.tieba.v.no_receive_code);
        ShowSoftKeyPadDelay(this.auX, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.e(this.aup, i);
        ba.h(this.ave, i);
        ba.b(this.avf, i);
        ba.b(this.auW, i);
        ba.c(this.avg, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(boolean z) {
        this.auX.setEnabled(z);
        this.auX.setFocusable(z);
        this.auX.setFocusableInTouchMode(z);
        this.auT.setEnabled(z);
        if (z) {
            this.auX.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
        } else {
            this.auX.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(nVar.getUser().getUserName());
        if (nVar.getUser().getPassword() != null) {
            accountData.setPassword(nVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.avd.getPsw());
        }
        accountData.setID(nVar.getUser().getUserId());
        accountData.setBDUSS(nVar.getUser().getBDUSS());
        accountData.setPortrait(nVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (nVar.qe() != null) {
            accountData.setTbs(nVar.qe().getTbs());
        }
        com.baidu.tbadk.core.a.d.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        setResult(-1);
        finish();
        sendMessage(new CustomMessage(2002001, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }
}
