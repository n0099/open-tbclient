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
    private static int amV = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout amW = null;
    private ImageView amX = null;
    private ProgressBar amY = null;
    private ProgressBar amZ = null;
    private TextView ana = null;
    private TextView UN = null;
    private EditText anb = null;
    private RelativeLayout anc = null;
    private RelativeLayout and = null;
    private u ane = null;
    private t anf = null;
    private boolean ang = false;
    private int ud = amV;
    private RegistData anh = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout QB = null;
    private View ani = null;
    private TextView anj = null;
    private TextView ank = null;
    private int anl = 0;
    private int anm = 0;
    private int ann = 0;
    private final Runnable mRunnable = new p(this);
    private final View.OnClickListener mOnClickListener = new q(this);
    private final TextWatcher ano = new r(this);
    private final View.OnFocusChangeListener anp = new s(this);

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
        Ba();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.anh = (RegistData) bundle.getSerializable("data");
        } else {
            this.anh = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.anh == null) {
            setResult(0);
            finish();
        } else if (this.anh.getSmsCodeTime() > 0) {
            amV = this.anh.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.anh = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.anh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.ane != null) {
            this.ane.cancel();
        }
        if (this.anf != null) {
            this.anf.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        this.ang = false;
        this.and.setEnabled(false);
        this.ud = amV;
        this.ana.setText(String.format(getPageContext().getString(com.baidu.tieba.z.resend_code_second), Integer.valueOf(this.ud)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.QB = (RelativeLayout) findViewById(com.baidu.tieba.w.container);
        this.ani = findViewById(com.baidu.tieba.w.title);
        this.anj = (TextView) findViewById(com.baidu.tieba.w.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.create_bar));
        this.anc = (RelativeLayout) findViewById(com.baidu.tieba.w.done);
        this.anc.setEnabled(false);
        this.and = (RelativeLayout) findViewById(com.baidu.tieba.w.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.anc.setOnClickListener(this.mOnClickListener);
        this.and.setOnClickListener(this.mOnClickListener);
        this.ana = (TextView) findViewById(com.baidu.tieba.w.resend_text);
        this.anb = (EditText) findViewById(com.baidu.tieba.w.edit_code);
        this.anb.addTextChangedListener(this.ano);
        this.anb.setOnFocusChangeListener(this.anp);
        this.amY = (ProgressBar) findViewById(com.baidu.tieba.w.progress_resend);
        this.amZ = (ProgressBar) findViewById(com.baidu.tieba.w.progress_done);
        this.amX = (ImageView) findViewById(com.baidu.tieba.w.del_code);
        this.amX.setOnClickListener(this.mOnClickListener);
        this.UN = (TextView) findViewById(com.baidu.tieba.w.text_error);
        this.amW = (LinearLayout) findViewById(com.baidu.tieba.w.sms_code_input_bg);
        this.anl = this.amW.getPaddingLeft();
        this.anm = this.amW.getPaddingRight();
        this.amW.setBackgroundResource(com.baidu.tieba.v.pass_input);
        this.amW.setPadding(this.anl, 0, this.anm, 0);
        this.ank = (TextView) findViewById(com.baidu.tieba.w.no_receive_code);
        ShowSoftKeyPadDelay(this.anb, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bc.e(this.QB, i);
        bc.h(this.ani, i);
        bc.b(this.anj, i);
        bc.b(this.ana, i);
        bc.c(this.ank, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        this.anb.setEnabled(z);
        this.anb.setFocusable(z);
        this.anb.setFocusableInTouchMode(z);
        this.amX.setEnabled(z);
        if (z) {
            this.anb.setTextColor(getResources().getColor(com.baidu.tieba.t.reg_font_color));
        } else {
            this.anb.setTextColor(getResources().getColor(com.baidu.tieba.t.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.n nVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(nVar.getUser().getUserName());
        if (nVar.getUser().getPassword() != null) {
            accountData.setPassword(nVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.anh.getPsw());
        }
        accountData.setID(nVar.getUser().getUserId());
        accountData.setBDUSS(nVar.getUser().getBDUSS());
        accountData.setPortrait(nVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (nVar.mR() != null) {
            accountData.setTbs(nVar.mR().getTbs());
        }
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        setResult(-1);
        finish();
        sendMessage(new CustomMessage(2002001, new TopRecActivityConfig(getPageContext().getPageActivity())));
    }
}
