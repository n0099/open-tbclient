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
    private static int aeC = 60;
    public NavigationBar mNavigationBar;
    private View Js = null;
    private LinearLayout aeD = null;
    private ImageView aeE = null;
    private ProgressBar aeF = null;
    private ProgressBar aeG = null;
    private TextView aeH = null;
    private TextView Or = null;
    private EditText aeI = null;
    private RelativeLayout aeJ = null;
    private RelativeLayout aeK = null;
    private s aeL = null;
    private r aeM = null;
    private boolean aeN = false;
    private int aeO = aeC;
    private RegistData aeP = null;
    private final Handler mHandler = new Handler();
    private RelativeLayout KO = null;
    private View aeQ = null;
    private TextView aeR = null;
    private TextView aeS = null;
    private int aeT = 0;
    private int aeU = 0;
    private int aeV = 0;
    private final Runnable mRunnable = new n(this);
    private final View.OnClickListener mOnClickListener = new o(this);
    private final TextWatcher aeW = new p(this);
    private final View.OnFocusChangeListener aeX = new q(this);

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
        xe();
    }

    private void d(Bundle bundle) {
        if (bundle != null) {
            this.aeP = (RegistData) bundle.getSerializable("data");
        } else {
            this.aeP = (RegistData) getIntent().getSerializableExtra("data");
        }
        if (this.aeP == null) {
            setResult(0);
            finish();
        } else if (this.aeP.getSmsCodeTime() > 0) {
            aeC = this.aeP.getSmsCodeTime();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aeP = (RegistData) bundle.getSerializable("data");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.aeP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.aeL != null) {
            this.aeL.cancel();
        }
        if (this.aeM != null) {
            this.aeM.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe() {
        this.aeN = false;
        this.aeK.setEnabled(false);
        this.aeO = aeC;
        this.aeH.setText(String.format(getString(com.baidu.tieba.y.resend_code_second), Integer.valueOf(this.aeO)));
        this.mHandler.postDelayed(this.mRunnable, 1000L);
    }

    private void initUI() {
        this.KO = (RelativeLayout) findViewById(com.baidu.tieba.v.container);
        this.aeQ = findViewById(com.baidu.tieba.v.title);
        this.aeR = (TextView) findViewById(com.baidu.tieba.v.done_text);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.Js = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, null);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.create_bar));
        this.aeJ = (RelativeLayout) findViewById(com.baidu.tieba.v.done);
        this.aeJ.setEnabled(false);
        this.aeK = (RelativeLayout) findViewById(com.baidu.tieba.v.resend);
        this.Js.setOnClickListener(this.mOnClickListener);
        this.aeJ.setOnClickListener(this.mOnClickListener);
        this.aeK.setOnClickListener(this.mOnClickListener);
        this.aeH = (TextView) findViewById(com.baidu.tieba.v.resend_text);
        this.aeI = (EditText) findViewById(com.baidu.tieba.v.edit_code);
        this.aeI.addTextChangedListener(this.aeW);
        this.aeI.setOnFocusChangeListener(this.aeX);
        this.aeF = (ProgressBar) findViewById(com.baidu.tieba.v.progress_resend);
        this.aeG = (ProgressBar) findViewById(com.baidu.tieba.v.progress_done);
        this.aeE = (ImageView) findViewById(com.baidu.tieba.v.del_code);
        this.aeE.setOnClickListener(this.mOnClickListener);
        this.Or = (TextView) findViewById(com.baidu.tieba.v.text_error);
        this.aeD = (LinearLayout) findViewById(com.baidu.tieba.v.sms_code_input_bg);
        this.aeT = this.aeD.getPaddingLeft();
        this.aeU = this.aeD.getPaddingRight();
        this.aeD.setBackgroundResource(com.baidu.tieba.u.pass_input);
        this.aeD.setPadding(this.aeT, 0, this.aeU, 0);
        this.aeS = (TextView) findViewById(com.baidu.tieba.v.no_receive_code);
        ShowSoftKeyPadDelay(this.aeI, 150);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aw.d(this.KO, i);
        aw.g(this.aeQ, i);
        aw.a(this.aeR, i);
        aw.a(this.aeH, i);
        aw.b(this.aeS, i);
        this.mNavigationBar.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(boolean z) {
        this.aeI.setEnabled(z);
        this.aeI.setFocusable(z);
        this.aeI.setFocusableInTouchMode(z);
        this.aeE.setEnabled(z);
        if (z) {
            this.aeI.setTextColor(getResources().getColor(com.baidu.tieba.s.reg_font_color));
        } else {
            this.aeI.setTextColor(getResources().getColor(com.baidu.tieba.s.text_hint_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.core.data.j jVar) {
        AccountData accountData = new AccountData();
        accountData.setAccount(jVar.getUser().getUserName());
        if (jVar.getUser().getPassword() != null) {
            accountData.setPassword(jVar.getUser().getPassword());
        } else {
            accountData.setPassword(this.aeP.getPsw());
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
