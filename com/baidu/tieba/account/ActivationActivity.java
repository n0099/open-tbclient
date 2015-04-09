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
    private static int auZ = 60;
    public NavigationBar mNavigationBar;
    private View mBack = null;
    private LinearLayout ava = null;
    private ImageView avb = null;
    private ProgressBar avc = null;
    private ProgressBar avd = null;
    private TextView ave = null;
    private TextView aeW = null;
    private EditText avf = null;
    private RelativeLayout avg = null;
    private RelativeLayout avh = null;
    private aa avi = null;
    private z avj = null;
    private boolean avk = false;
    private int EW = auZ;
    private RegistData avl = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout aux = null;
    private View avm = null;
    private TextView avn = null;
    private TextView avo = null;
    private int avp = 0;
    private int avq = 0;
    private int avr = 0;
    private final Runnable mRunnable = new v(this);
    private final View.OnClickListener mOnClickListener = new w(this);
    private final TextWatcher avs = new x(this);
    private final View.OnFocusChangeListener avt = new y(this);

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
        Eq();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.avl = (RegistData) bundle.getSerializable("data");
        } else {
            this.avl = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.avl == null) {
            setResult(0);
            finish();
        } else if (this.avl.getSmsCodeTime() > 0) {
            auZ = this.avl.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.avl = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.avl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.avi != null) {
            this.avi.cancel();
        }
        if (this.avj != null) {
            this.avj.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eq() {
        this.avk = false;
        this.avh.setEnabled(false);
        this.EW = auZ;
        this.ave.setText(String.format(getPageContext().getString(com.baidu.tieba.y.resend_code_second), Integer.valueOf(this.EW)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.aux = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.avm = findViewById(com.baidu.tieba.v.title);
        this.avn = (TextView) findViewById(com.baidu.tieba.v.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.create_bar));
        this.avg = (RelativeLayout) findViewById(com.baidu.tieba.v.done);
        this.avg.setEnabled(false);
        this.avh = (RelativeLayout) findViewById(com.baidu.tieba.v.resend);
        this.mBack.setOnClickListener(this.mOnClickListener);
        this.avg.setOnClickListener(this.mOnClickListener);
        this.avh.setOnClickListener(this.mOnClickListener);
        this.ave = (TextView) findViewById(com.baidu.tieba.v.resend_text);
        this.avf = (EditText) findViewById(com.baidu.tieba.v.edit_code);
        this.avf.addTextChangedListener(this.avs);
        this.avf.setOnFocusChangeListener(this.avt);
        this.avc = (ProgressBar) findViewById(com.baidu.tieba.v.progress_resend);
        this.avd = (ProgressBar) findViewById(com.baidu.tieba.v.progress_done);
        this.avb = (ImageView) findViewById(com.baidu.tieba.v.del_code);
        this.avb.setOnClickListener(this.mOnClickListener);
        this.aeW = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.ava = (LinearLayout) findViewById(com.baidu.tieba.v.sms_code_input_bg);
        this.avp = this.ava.getPaddingLeft();
        this.avq = this.ava.getPaddingRight();
        this.ava.setBackgroundResource(com.baidu.tieba.u.pass_input);
        this.ava.setPadding(this.avp, 0, this.avq, 0);
        this.avo = (TextView) findViewById(com.baidu.tieba.v.no_receive_code);
        ShowSoftKeyPadDelay(this.avf, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.e(this.aux, i);
        ba.h(this.avm, i);
        ba.b(this.avn, i);
        ba.b(this.ave, i);
        ba.c(this.avo, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(boolean z) {
        this.avf.setEnabled(z);
        this.avf.setFocusable(z);
        this.avf.setFocusableInTouchMode(z);
        this.avb.setEnabled(z);
        if (z) {
            this.avf.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
        } else {
            this.avf.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.core.data.n nVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(nVar.getUser().getUserName());
        if (nVar.getUser().getPassword() != null) {
            accountData.setPassword(nVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.avl.getPsw());
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
