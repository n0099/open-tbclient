package com.baidu.tieba.account.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.a0;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.t;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class Login2Activity extends BaseActivity<Login2Activity> {
    private k ayl;
    private k aym;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String ayn = null;
    private String mVcodeUrl = null;
    private int ayo = 0;
    private boolean ayp = true;
    private boolean abu = false;
    private boolean ayq = false;
    private boolean ayr = true;
    private int mFrom = -1;
    private EditText ays = null;
    private EditText ayt = null;
    private EditText axy = null;
    private View ayu = null;
    private ImageView axG = null;
    private ImageView ayv = null;
    private ImageView ayw = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar ayx = null;
    private Button ayy = null;
    private View axj = null;
    private View ayz = null;
    private View ayA = null;
    private View ayB = null;
    private Button ayC = null;
    private Button ayD = null;
    private Button ayE = null;
    private TextView ayF = null;
    private TextView axu = null;
    private TextView ayG = null;
    private TextView ayH = null;
    private Button ayI = null;
    private Button ayJ = null;
    RelativeLayout awb = null;
    private m ayK = null;
    private n ayL = null;
    private l ayM = null;
    InputMethodManager mInputManager = null;
    t abq = null;
    private AccountData agd = null;
    private String mInfo = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(r.account_login_activity);
        this.mInfo = getIntent().getStringExtra(LoginActivityConfig.INFO);
        initUI();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(LoginActivityConfig.ACCOUNT);
        this.ayp = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.abu = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        if (bundle != null) {
            this.ayo = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.ayo = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.ayo = 1;
        }
        if (stringExtra != null) {
            this.ays.setText(stringExtra);
        }
        this.ays.requestFocus();
        if (this.ayp) {
            this.axj.setVisibility(4);
        } else {
            this.axj.setVisibility(0);
        }
        if (this.ayo == 0) {
            ex(q.normal_login);
        } else if (this.ayo == 1) {
            ex(q.mobile_login);
        }
        ShowSoftKeyPadDelay(this.ays, 150);
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.ayo = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.ayo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            FH();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.abq != null) {
            this.abq.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.abq == null || !this.abq.isShowing()) {
            ShowSoftKeyPadDelay(this.ays, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ayp) {
                quitDialog();
            } else {
                finish();
            }
            return true;
        }
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY() {
        int i = 1;
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.abu) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.awb = (RelativeLayout) findViewById(q.container);
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.axj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.t.account_regedit), new c(this));
        this.ays = (EditText) findViewById(q.login_edit_account);
        this.ayt = (EditText) findViewById(q.login_edit_password);
        this.axy = (EditText) findViewById(q.edit_vcode);
        this.ayz = findViewById(q.layout_account);
        this.ayA = findViewById(q.layout_password);
        this.ayB = findViewById(q.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(q.image_progress);
        this.ayv = (ImageView) findViewById(q.image_vcode1);
        this.ayw = (ImageView) findViewById(q.image_vcode2);
        this.axG = this.ayv;
        this.ayx = (ProgressBar) findViewById(q.progress_login);
        this.ayy = (Button) findViewById(q.button_vcode_refresh);
        this.ayC = (Button) findViewById(q.button_account_del);
        this.ayD = (Button) findViewById(q.button_pass_del);
        this.ayE = (Button) findViewById(q.button_vcode_del);
        this.ayF = (TextView) findViewById(q.text_title_account);
        this.axu = (TextView) findViewById(q.text_error);
        this.ayG = (TextView) findViewById(q.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.ayG.setText(this.mInfo);
            this.ayG.setVisibility(0);
        }
        this.ayH = (TextView) findViewById(q.text_login);
        this.ayI = (Button) findViewById(q.normal_login);
        this.ayJ = (Button) findViewById(q.mobile_login);
        this.ayI.setOnClickListener(this);
        this.ayJ.setOnClickListener(this);
        this.ayC.setOnClickListener(this);
        this.ayD.setOnClickListener(this);
        this.ayE.setOnClickListener(this);
        this.ayy.setOnClickListener(this);
        this.ayv.setOnClickListener(this);
        this.ayw.setOnClickListener(this);
        d dVar = new d(this);
        this.ays.setOnFocusChangeListener(dVar);
        this.ayt.setOnFocusChangeListener(dVar);
        this.axy.setOnFocusChangeListener(dVar);
        e eVar = new e(this);
        this.ayt.setOnEditorActionListener(eVar);
        this.axy.setOnEditorActionListener(eVar);
        this.ays.addTextChangedListener(new f(this));
        this.ayt.addTextChangedListener(new g(this));
        this.axy.addTextChangedListener(new h(this));
        this.ayu = findViewById(q.layout_login);
        this.ayu.setEnabled(false);
        this.ayu.setOnClickListener(new i(this));
        FD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ay.b(this.ayH, i);
        ay.g(this.awb, i);
        if (i == 1) {
            this.ayG.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_common_color));
        } else {
            this.ayG.setTextColor(-13279809);
        }
        FG();
        Fw();
    }

    private void Fw() {
        if (this.ayo == 0) {
            if (this.mSkinType == 1) {
                this.ayI.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_common_color));
                this.ayJ.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_tab_unsel_color));
            } else {
                this.ayI.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.ayJ.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ay.i((View) this.ayI, p.login_tab_pressed);
            ay.i((View) this.ayJ, p.login_tab_normal);
        } else if (this.ayo == 1) {
            if (this.mSkinType == 1) {
                this.ayJ.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_common_color));
                this.ayI.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_tab_unsel_color));
            } else {
                this.ayJ.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.ayI.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ay.i((View) this.ayJ, p.login_tab_pressed);
            ay.i((View) this.ayI, p.login_tab_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fx() {
        boolean z;
        String editable = this.ays.getText().toString();
        String editable2 = this.ayt.getText().toString();
        String editable3 = this.axy.getText().toString();
        if (this.ayB.getVisibility() == 8) {
            z = bb.isEmpty(editable) || bb.isEmpty(editable2);
        } else {
            z = bb.isEmpty(editable) || bb.isEmpty(editable2) || bb.isEmpty(editable3);
        }
        if (!z) {
            this.ayu.setEnabled(true);
        } else {
            this.ayu.setEnabled(false);
        }
    }

    private void ex(int i) {
        if (i == q.normal_login) {
            this.axG = this.ayv;
            this.ayv.setVisibility(0);
            this.ayw.setVisibility(8);
            Fz();
            this.ayo = 0;
            Fy();
            this.ays.setHint(com.baidu.tieba.t.account_hint_normal);
            this.ayF.setText(com.baidu.tieba.t.account_account);
            this.ays.requestFocus();
            this.ays.setInputType(1);
            Fw();
        } else if (i == q.mobile_login) {
            this.axG = this.ayw;
            this.ayv.setVisibility(8);
            this.ayw.setVisibility(0);
            Fz();
            this.ayo = 1;
            Fy();
            this.ays.setHint(com.baidu.tieba.t.account_mobile);
            this.ayF.setText(com.baidu.tieba.t.account_mobile);
            this.ays.requestFocus();
            this.ays.setInputType(3);
            Fw();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == q.normal_login || id == q.mobile_login) {
            ex(view.getId());
        } else if (id == q.button_account_del) {
            this.ays.setText((CharSequence) null);
        } else if (id == q.button_pass_del) {
            this.ayt.setText((CharSequence) null);
        } else if (id == q.button_vcode_del) {
            this.axy.setText((CharSequence) null);
        } else if (id == q.button_vcode_refresh || id == q.image_vcode1 || id == q.image_vcode2) {
            fq(this.mVcodeUrl);
        }
    }

    private void Fy() {
        if (this.ayo == 0) {
            if (this.ayl == null) {
                this.mAccount = null;
                this.ays.setText((CharSequence) null);
                this.ayt.setText((CharSequence) null);
                this.axy.setText((CharSequence) null);
                this.ayB.setVisibility(8);
                this.axu.setVisibility(4);
                this.ayr = true;
                this.ayq = false;
            } else {
                this.mAccount = this.ayl.mAccount;
                this.ays.setText(this.ayl.mAccount);
                this.ayt.setText(this.ayl.mPassword);
                this.axy.setText(this.ayl.mVcode);
                this.axu.setText(this.ayl.SY);
                this.ayB.setVisibility(this.ayl.ayO);
                this.axu.setVisibility(this.ayl.ayP);
                this.ayr = this.ayl.ayr;
                this.ayq = this.ayl.ayO == 0;
            }
        }
        if (this.ayo == 1) {
            if (this.aym == null) {
                this.mAccount = null;
                this.ays.setText((CharSequence) null);
                this.ayt.setText((CharSequence) null);
                this.axy.setText((CharSequence) null);
                this.ayB.setVisibility(8);
                this.axu.setVisibility(4);
                this.ayr = true;
                this.ayq = false;
            } else {
                this.mAccount = this.aym.mAccount;
                this.ays.setText(this.aym.mAccount);
                this.ayt.setText(this.aym.mPassword);
                this.axy.setText(this.aym.mVcode);
                this.axu.setText(this.aym.SY);
                this.ayB.setVisibility(this.aym.ayO);
                this.axu.setVisibility(this.aym.ayP);
                this.ayr = this.aym.ayr;
                this.ayq = this.aym.ayO == 0;
            }
        }
        FG();
        Fx();
    }

    private void Fz() {
        if (this.ayo == 0) {
            this.ayl = new k(this, null);
            this.ayl.mAccount = this.ays.getText().toString();
            this.ayl.mPassword = this.ayt.getText().toString();
            this.ayl.mVcode = this.axy.getText().toString();
            this.ayl.SY = this.axu.getText().toString();
            this.ayl.ayO = this.ayB.getVisibility();
            this.ayl.ayP = this.axu.getVisibility();
            this.ayl.ayr = this.ayr;
        }
        if (this.ayo == 1) {
            this.aym = new k(this, null);
            this.aym.mAccount = this.ays.getText().toString();
            this.aym.mPassword = this.ayt.getText().toString();
            this.aym.mVcode = this.axy.getText().toString();
            this.aym.SY = this.axu.getText().toString();
            this.aym.ayO = this.ayB.getVisibility();
            this.aym.ayP = this.axu.getVisibility();
            this.aym.ayr = this.ayr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.ayK == null) {
            String editable = this.ays.getText().toString();
            this.mPassword = com.baidu.adp.lib.util.c.m(this.ayt.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.ayq || !bb.isEmpty(this.axy.getText().toString())) {
                    FE();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.ayo)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId()));
                    if (this.ayB != null && this.ayB.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.axy.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.ayn));
                    }
                    FH();
                    this.ayK = new m(this, sb.toString(), arrayList);
                    this.ayK.setPriority(3);
                    this.ayK.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.ayL.getUser().getUserName());
        if (this.ayL.getUser().getPassword() != null) {
            accountData.setPassword(this.ayL.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.ayL.getUser().getUserId());
        accountData.setBDUSS(this.ayL.getUser().getBDUSS());
        accountData.setPortrait(this.ayL.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.ayL.qK() != null) {
            accountData.setTbs(this.ayL.qK().getTbs());
        }
        this.agd = accountData;
        if (!TextUtils.isEmpty(this.agd.getAccount())) {
            com.baidu.tbadk.core.a.d.b(accountData);
            TbadkCoreApplication.setCurrentAccount(this.agd, getBaseContext());
            com.baidu.tbadk.coreExtra.act.l uV = com.baidu.tbadk.coreExtra.act.a.uV();
            if (uV != null) {
                uV.h(this.agd);
            }
            vb();
            uY();
            return;
        }
        if (this.abq == null) {
            this.abq = new t(getPageContext());
            this.abq.a(new j(this));
        }
        this.abq.xT();
        this.abq.setPhone(this.ays.getText().toString());
        this.abq.k(this.agd);
        this.abq.xP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FB() {
        this.ayr = false;
        FG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(String str) {
        if (this.ayM != null) {
            this.ayM.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.axG.setImageDrawable(null);
        FH();
        this.ayM = new l(this, null);
        this.ayM.setPriority(3);
        this.ayM.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        this.ayq = true;
        this.ayB.setVisibility(0);
        this.axy.setText((CharSequence) null);
        if (this.ayr) {
            ay.i(this.ayA, p.login_input_middle);
        } else {
            ay.i(this.ayA, p.login_input_middlewrong);
        }
        Fx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        this.ayq = false;
        this.ayB.setVisibility(8);
        if (this.ayr) {
            this.ayA.setBackgroundResource(p.login_input_under);
        } else {
            this.ayA.setBackgroundResource(p.login_input_underwrong);
        }
        Fx();
    }

    private void FE() {
        this.ays.setEnabled(false);
        this.ayt.setEnabled(false);
        this.axy.setEnabled(false);
        this.ayy.setEnabled(false);
        this.axG.setEnabled(false);
        this.ayC.setEnabled(false);
        this.ayD.setEnabled(false);
        this.ayE.setEnabled(false);
        this.ayI.setEnabled(false);
        this.ayJ.setEnabled(false);
        this.ays.setTextColor(Color.rgb(136, 136, 136));
        this.ayt.setTextColor(Color.rgb(136, 136, 136));
        this.axy.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF() {
        this.ays.setEnabled(true);
        this.ayt.setEnabled(true);
        this.axy.setEnabled(true);
        this.ayy.setEnabled(true);
        this.axG.setEnabled(true);
        this.ayC.setEnabled(true);
        this.ayD.setEnabled(true);
        this.ayE.setEnabled(true);
        this.ayI.setEnabled(true);
        this.ayJ.setEnabled(true);
        this.ays.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.ayt.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.axy.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        if (this.ayr) {
            ay.i(this.ayz, p.login_input_top);
            if (this.ayq) {
                ay.i(this.ayA, p.login_input_middle);
            } else {
                ay.i(this.ayA, p.login_input_under);
            }
            ay.i(this.ayB, p.login_input_under);
            return;
        }
        ay.i(this.ayz, p.login_input_topwrong);
        if (this.ayq) {
            ay.i(this.ayA, p.login_input_middlewrong);
        } else {
            ay.i(this.ayA, p.login_input_underwrong);
        }
        ay.i(this.ayB, p.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH() {
        if (this.ayK != null) {
            this.ayK.cancel();
            this.ayK = null;
        }
        if (this.ayM != null) {
            this.ayM.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zn() {
        FH();
        if (this.mFrom == 2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2002001, new RegisterActivityConfig(getPageContext().getPageActivity(), 1, true, 11038)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.l.ht().b(new b(this));
        }
    }
}
