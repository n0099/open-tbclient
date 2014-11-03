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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.RegistData;
import com.baidu.tieba.topRec.TopRecActivity;
/* loaded from: classes.dex */
public class ActivationActivity extends BaseActivity {
    private static int aeK = 60;
    public NavigationBar mNavigationBar;
    private View Jt = null;
    private LinearLayout aeL = null;
    private ImageView aeM = null;
    private ProgressBar aeN = null;
    private ProgressBar aeO = null;
    private TextView aeP = null;
    private TextView Ov = null;
    private EditText aeQ = null;
    private RelativeLayout aeR = null;
    private RelativeLayout aeS = null;
    private s aeT = null;
    private r aeU = null;
    private boolean aeV = false;
    private int aeW = aeK;
    private RegistData aeX = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout KP = null;
    private View aeY = null;
    private TextView aeZ = null;
    private TextView afa = null;
    private int afb = 0;
    private int afc = 0;
    private int afd = 0;
    private final Runnable mRunnable = new n(this);
    private final View.OnClickListener mOnClickListener = new o(this);
    private final TextWatcher afe = new p(this);
    private final View.OnFocusChangeListener aff = new q(this);

    public static void a(Activity activity, RegistData registData, int i) {
        Intent intent = new Intent(activity, ActivationActivity.class);
        intent.putExtra("data", registData);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.account_register_activation);
        d(bundle);
        initUI();
        xg();
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.aeX = (RegistData) bundle.getSerializable("data");
        } else {
            this.aeX = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.aeX == null) {
            setResult(0);
            finish();
        } else if (this.aeX.getSmsCodeTime() > 0) {
            aeK = this.aeX.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aeX = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aeX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aeT != null) {
            this.aeT.cancel();
        }
        if (this.aeU != null) {
            this.aeU.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xg() {
        this.aeV = false;
        this.aeS.setEnabled(false);
        this.aeW = aeK;
        this.aeP.setText(String.format(getString(com.baidu.tieba.y.resend_code_second), Integer.valueOf(this.aeW)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.KP = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.aeY = findViewById(com.baidu.tieba.v.title);
        this.aeZ = (TextView) findViewById(com.baidu.tieba.v.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.Jt = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.create_bar));
        this.aeR = (RelativeLayout) findViewById(com.baidu.tieba.v.done);
        this.aeR.setEnabled(false);
        this.aeS = (RelativeLayout) findViewById(com.baidu.tieba.v.resend);
        this.Jt.setOnClickListener(this.mOnClickListener);
        this.aeR.setOnClickListener(this.mOnClickListener);
        this.aeS.setOnClickListener(this.mOnClickListener);
        this.aeP = (TextView) findViewById(com.baidu.tieba.v.resend_text);
        this.aeQ = (EditText) findViewById(com.baidu.tieba.v.edit_code);
        this.aeQ.addTextChangedListener(this.afe);
        this.aeQ.setOnFocusChangeListener(this.aff);
        this.aeN = (ProgressBar) findViewById(com.baidu.tieba.v.progress_resend);
        this.aeO = (ProgressBar) findViewById(com.baidu.tieba.v.progress_done);
        this.aeM = (ImageView) findViewById(com.baidu.tieba.v.del_code);
        this.aeM.setOnClickListener(this.mOnClickListener);
        this.Ov = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.aeL = (LinearLayout) findViewById(com.baidu.tieba.v.sms_code_input_bg);
        this.afb = this.aeL.getPaddingLeft();
        this.afc = this.aeL.getPaddingRight();
        this.aeL.setBackgroundResource(com.baidu.tieba.u.pass_input);
        this.aeL.setPadding(this.afb, 0, this.afc, 0);
        this.afa = (TextView) findViewById(com.baidu.tieba.v.no_receive_code);
        ShowSoftKeyPadDelay(this.aeQ, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aw.d(this.KP, i);
        aw.g(this.aeY, i);
        aw.a(this.aeZ, i);
        aw.a(this.aeP, i);
        aw.b(this.afa, i);
        this.mNavigationBar.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(boolean z) {
        this.aeQ.setEnabled(z);
        this.aeQ.setFocusable(z);
        this.aeQ.setFocusableInTouchMode(z);
        this.aeM.setEnabled(z);
        if (z) {
            this.aeQ.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
        } else {
            this.aeQ.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.j jVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(jVar.getUser().getUserName());
        if (jVar.getUser().getPassword() != null) {
            accountData.setPassword(jVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aeX.getPsw());
        }
        accountData.setID(jVar.getUser().getUserId());
        accountData.setBDUSS(jVar.getUser().getBDUSS());
        accountData.setPortrait(jVar.getUser().getPortrait());
        accountData.setIsActive(1);
        if (jVar.jZ() != null) {
            accountData.setTbs(jVar.jZ().getTbs());
        }
        com.baidu.tbadk.core.account.a.a(accountData);
        TbadkApplication.setCurrentAccount(accountData, getBaseContext());
        setResult(-1);
        finish();
        TopRecActivity.aj(this);
    }
}
