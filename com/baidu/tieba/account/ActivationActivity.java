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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.RegistData;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity<ActivationActivity> {
    private static int amS = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout amT = null;
    private ImageView amU = null;
    private ProgressBar amV = null;
    private ProgressBar amW = null;
    private TextView amX = null;
    private TextView UK = null;
    private EditText amY = null;
    private RelativeLayout amZ = null;
    private RelativeLayout ana = null;
    private u anb = null;
    private t anc = null;
    private boolean and = false;
    private int ua = amS;
    private RegistData ane = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout Qx = null;
    private View anf = null;
    private TextView ang = null;
    private TextView anh = null;
    private int ani = 0;
    private int anj = 0;
    private int ank = 0;
    private final Runnable mRunnable = new p(this);
    private final View.OnClickListener mOnClickListener = new q(this);
    private final TextWatcher anl = new r(this);
    private final View.OnFocusChangeListener anm = new s(this);

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
        AU();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.ane = (RegistData) bundle.getSerializable("data");
        } else {
            this.ane = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.ane == null) {
            setResult(0);
            finish();
        } else if (this.ane.getSmsCodeTime() > 0) {
            amS = this.ane.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.ane = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.ane);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.anb != null) {
            this.anb.cancel();
        }
        if (this.anc != null) {
            this.anc.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        this.and = false;
        this.ana.setEnabled(false);
        this.ua = amS;
        this.amX.setText(String.format(getPageContext().getString(com.baidu.tieba.z.resend_code_second), Integer.valueOf(this.ua)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.Qx = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.anf = findViewById(com.baidu.tieba.w.title);
        this.ang = (TextView) findViewById(com.baidu.tieba.w.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.create_bar));
        this.amZ = (RelativeLayout) findViewById(com.baidu.tieba.w.done);
        this.amZ.setEnabled(false);
        this.ana = (RelativeLayout) findViewById(com.baidu.tieba.w.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.amZ.setOnClickListener(this.mOnClickListener);
        this.ana.setOnClickListener(this.mOnClickListener);
        this.amX = (TextView) findViewById(com.baidu.tieba.w.resend_text);
        this.amY = (EditText) findViewById(com.baidu.tieba.w.edit_code);
        this.amY.addTextChangedListener(this.anl);
        this.amY.setOnFocusChangeListener(this.anm);
        this.amV = (ProgressBar) findViewById(com.baidu.tieba.w.progress_resend);
        this.amW = (ProgressBar) findViewById(com.baidu.tieba.w.progress_done);
        this.amU = (ImageView) findViewById(com.baidu.tieba.w.del_code);
        this.amU.setOnClickListener(this.mOnClickListener);
        this.UK = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.amT = (LinearLayout) findViewById(com.baidu.tieba.w.sms_code_input_bg);
        this.ani = this.amT.getPaddingLeft();
        this.anj = this.amT.getPaddingRight();
        this.amT.setBackgroundResource(com.baidu.tieba.v.pass_input);
        this.amT.setPadding(this.ani, 0, this.anj, 0);
        this.anh = (TextView) findViewById(com.baidu.tieba.w.no_receive_code);
        ShowSoftKeyPadDelay(this.amY, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.e(this.Qx, i);
        bc.h(this.anf, i);
        bc.b(this.ang, i);
        bc.b(this.amX, i);
        bc.c(this.anh, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        this.amY.setEnabled(z);
        this.amY.setFocusable(z);
        this.amY.setFocusableInTouchMode(z);
        this.amU.setEnabled(z);
        if (z) {
            this.amY.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
        } else {
            this.amY.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.n nVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(nVar.getUser().getUserName());
        if (nVar.getUser().getPassword() != null) {
            accountData.setPassword(nVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.ane.getPsw());
        }
        accountData.setID(nVar.getUser().getUserId());
        accountData.setBDUSS(nVar.getUser().getBDUSS());
        accountData.setPortrait(nVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (nVar.mK() != null) {
            accountData.setTbs(nVar.mK().getTbs());
        }
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        setResult(-1);
        finish();
        sendMessage(new CustomMessage(2002001, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }
}
