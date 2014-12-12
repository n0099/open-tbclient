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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.RegistData;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int amb = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout amc = null;
    private ImageView amd = null;
    private ProgressBar ame = null;
    private ProgressBar amf = null;
    private TextView amg = null;
    private TextView Uh = null;
    private EditText amh = null;
    private RelativeLayout ami = null;
    private RelativeLayout amj = null;
    private t amk = null;
    private s aml = null;
    private boolean amm = false;
    private int tW = amb;
    private RegistData amn = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout Qa = null;
    private View amo = null;
    private TextView amp = null;
    private TextView amq = null;
    private int amr = 0;
    private int ams = 0;
    private int amt = 0;
    private final Runnable mRunnable = new o(this);
    private final View.OnClickListener mOnClickListener = new p(this);
    private final TextWatcher amu = new q(this);
    private final View.OnFocusChangeListener amv = new r(this);

    public static void a(Activity activity, RegistData registData, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.account_register_activation);
        initData(bundle);
        initUI();
        Az();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.amn = (RegistData) bundle.getSerializable("data");
        } else {
            this.amn = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.amn == null) {
            setResult(0);
            finish();
        } else if (this.amn.getSmsCodeTime() > 0) {
            amb = this.amn.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.amn = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.amn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.amk != null) {
            this.amk.cancel();
        }
        if (this.aml != null) {
            this.aml.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az() {
        this.amm = false;
        this.amj.setEnabled(false);
        this.tW = amb;
        this.amg.setText(String.format(getPageContext().getString(com.baidu.tieba.z.resend_code_second), Integer.valueOf(this.tW)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.Qa = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.amo = findViewById(com.baidu.tieba.w.title);
        this.amp = (TextView) findViewById(com.baidu.tieba.w.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.create_bar));
        this.ami = (RelativeLayout) findViewById(com.baidu.tieba.w.done);
        this.ami.setEnabled(false);
        this.amj = (RelativeLayout) findViewById(com.baidu.tieba.w.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.ami.setOnClickListener(this.mOnClickListener);
        this.amj.setOnClickListener(this.mOnClickListener);
        this.amg = (TextView) findViewById(com.baidu.tieba.w.resend_text);
        this.amh = (EditText) findViewById(com.baidu.tieba.w.edit_code);
        this.amh.addTextChangedListener(this.amu);
        this.amh.setOnFocusChangeListener(this.amv);
        this.ame = (ProgressBar) findViewById(com.baidu.tieba.w.progress_resend);
        this.amf = (ProgressBar) findViewById(com.baidu.tieba.w.progress_done);
        this.amd = (ImageView) findViewById(com.baidu.tieba.w.del_code);
        this.amd.setOnClickListener(this.mOnClickListener);
        this.Uh = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.amc = (LinearLayout) findViewById(com.baidu.tieba.w.sms_code_input_bg);
        this.amr = this.amc.getPaddingLeft();
        this.ams = this.amc.getPaddingRight();
        this.amc.setBackgroundResource(com.baidu.tieba.v.pass_input);
        this.amc.setPadding(this.amr, 0, this.ams, 0);
        this.amq = (TextView) findViewById(com.baidu.tieba.w.no_receive_code);
        ShowSoftKeyPadDelay(this.amh, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ax.e(this.Qa, i);
        ax.h(this.amo, i);
        ax.b(this.amp, i);
        ax.b(this.amg, i);
        ax.c(this.amq, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(boolean z) {
        this.amh.setEnabled(z);
        this.amh.setFocusable(z);
        this.amh.setFocusableInTouchMode(z);
        this.amd.setEnabled(z);
        if (z) {
            this.amh.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
        } else {
            this.amh.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.m mVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(mVar.getUser().getUserName());
        if (mVar.getUser().getPassword() != null) {
            accountData.setPassword(mVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.amn.getPsw());
        }
        accountData.setID(mVar.getUser().getUserId());
        accountData.setBDUSS(mVar.getUser().getBDUSS());
        accountData.setPortrait(mVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (mVar.mP() != null) {
            accountData.setTbs(mVar.mP().getTbs());
        }
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        setResult(-1);
        finish();
        sendMessage(new CustomMessage(2002001, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }
}
