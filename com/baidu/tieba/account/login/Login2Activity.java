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
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.t;
import com.baidu.tieba.s;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class Login2Activity extends BaseActivity<Login2Activity> {
    private j awE;
    private j awF;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String awG = null;
    private String mVcodeUrl = null;
    private int awH = 0;
    private boolean awI = true;
    private boolean aas = false;
    private boolean awJ = false;
    private boolean awK = true;
    private EditText awL = null;
    private EditText awM = null;
    private EditText avS = null;
    private View awN = null;
    private ImageView awa = null;
    private ImageView awO = null;
    private ImageView awP = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar awQ = null;
    private Button awR = null;
    private View avD = null;
    private View awS = null;
    private View awT = null;
    private View awU = null;
    private Button awV = null;
    private Button awW = null;
    private Button awX = null;
    private TextView awY = null;
    private TextView avO = null;
    private TextView awZ = null;
    private TextView axa = null;
    private Button axb = null;
    private Button axc = null;
    RelativeLayout aux = null;
    private l axd = null;
    private n axe = null;
    private k axf = null;
    InputMethodManager mInputManager = null;
    t aap = null;
    private AccountData afc = null;
    private String mInfo = null;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(w.account_login_activity);
        this.mInfo = getIntent().getStringExtra(LoginActivityConfig.INFO);
        initUI();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(LoginActivityConfig.ACCOUNT);
        this.awI = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.aas = intent.getBooleanExtra(LoginActivityConfig.CLOSE, false);
        if (bundle != null) {
            this.awH = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.awH = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.awH = 1;
        }
        if (stringExtra != null) {
            this.awL.setText(stringExtra);
        }
        this.awL.requestFocus();
        if (this.awI) {
            this.avD.setVisibility(4);
        } else {
            this.avD.setVisibility(0);
        }
        if (this.awH == 0) {
            el(v.normal_login);
        } else if (this.awH == 1) {
            el(v.mobile_login);
        }
        ShowSoftKeyPadDelay(this.awL, 150);
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.awH = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.awH);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            EO();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.aap != null) {
            this.aap.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.aap == null || !this.aap.isShowing()) {
            ShowSoftKeyPadDelay(this.awL, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.awI) {
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
        switch (i2) {
            case -1:
                up();
                return;
            default:
                return;
        }
    }

    public void up() {
        int i = 1;
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.aas) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), i, false);
        }
        us();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aux = (RelativeLayout) findViewById(v.container);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.avD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(y.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(y.account_regedit), new b(this));
        this.awL = (EditText) findViewById(v.login_edit_account);
        this.awM = (EditText) findViewById(v.login_edit_password);
        this.avS = (EditText) findViewById(v.edit_vcode);
        this.awS = findViewById(v.layout_account);
        this.awT = findViewById(v.layout_password);
        this.awU = findViewById(v.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(v.image_progress);
        this.awO = (ImageView) findViewById(v.image_vcode1);
        this.awP = (ImageView) findViewById(v.image_vcode2);
        this.awa = this.awO;
        this.awQ = (ProgressBar) findViewById(v.progress_login);
        this.awR = (Button) findViewById(v.button_vcode_refresh);
        this.awV = (Button) findViewById(v.button_account_del);
        this.awW = (Button) findViewById(v.button_pass_del);
        this.awX = (Button) findViewById(v.button_vcode_del);
        this.awY = (TextView) findViewById(v.text_title_account);
        this.avO = (TextView) findViewById(v.text_error);
        this.awZ = (TextView) findViewById(v.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.awZ.setText(this.mInfo);
            this.awZ.setVisibility(0);
        }
        this.axa = (TextView) findViewById(v.text_login);
        this.axb = (Button) findViewById(v.normal_login);
        this.axc = (Button) findViewById(v.mobile_login);
        c cVar = new c(this);
        this.awL.setOnFocusChangeListener(cVar);
        this.awM.setOnFocusChangeListener(cVar);
        this.avS.setOnFocusChangeListener(cVar);
        d dVar = new d(this);
        this.awM.setOnEditorActionListener(dVar);
        this.avS.setOnEditorActionListener(dVar);
        this.awL.addTextChangedListener(new e(this));
        this.awM.addTextChangedListener(new f(this));
        this.avS.addTextChangedListener(new g(this));
        this.awN = findViewById(v.layout_login);
        this.awN.setEnabled(false);
        this.awN.setOnClickListener(new h(this));
        EK();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ba.b(this.axa, i);
        ba.g(this.aux, i);
        if (i == 1) {
            this.awZ.setTextColor(getResources().getColor(s.skin_1_common_color));
        } else {
            this.awZ.setTextColor(-13279809);
        }
        EN();
        ED();
    }

    private void ED() {
        if (this.awH == 0) {
            if (this.mSkinType == 1) {
                this.axb.setTextColor(getResources().getColor(s.skin_1_common_color));
                this.axc.setTextColor(getResources().getColor(s.skin_1_tab_unsel_color));
            } else {
                this.axb.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.axc.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ba.i((View) this.axb, u.login_tab_pressed);
            ba.i((View) this.axc, u.login_tab_normal);
        } else if (this.awH == 1) {
            if (this.mSkinType == 1) {
                this.axc.setTextColor(getResources().getColor(s.skin_1_common_color));
                this.axb.setTextColor(getResources().getColor(s.skin_1_tab_unsel_color));
            } else {
                this.axc.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.axb.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ba.i((View) this.axc, u.login_tab_pressed);
            ba.i((View) this.axb, u.login_tab_normal);
        }
    }

    public void EE() {
        boolean z;
        String editable = this.awL.getText().toString();
        String editable2 = this.awM.getText().toString();
        String editable3 = this.avS.getText().toString();
        if (this.awU.getVisibility() == 8) {
            z = bd.isEmpty(editable) || bd.isEmpty(editable2);
        } else {
            z = bd.isEmpty(editable) || bd.isEmpty(editable2) || bd.isEmpty(editable3);
        }
        if (!z) {
            this.awN.setEnabled(true);
        } else {
            this.awN.setEnabled(false);
        }
    }

    private void el(int i) {
        if (i == v.normal_login) {
            this.awa = this.awO;
            this.awO.setVisibility(0);
            this.awP.setVisibility(8);
            EG();
            this.awH = 0;
            EF();
            this.awL.setHint(y.account_hint_normal);
            this.awY.setText(y.account_account);
            this.awL.requestFocus();
            this.awL.setInputType(1);
            ED();
        } else if (i == v.mobile_login) {
            this.awa = this.awP;
            this.awO.setVisibility(8);
            this.awP.setVisibility(0);
            EG();
            this.awH = 1;
            EF();
            this.awL.setHint(y.account_mobile);
            this.awY.setText(y.account_mobile);
            this.awL.requestFocus();
            this.awL.setInputType(3);
            ED();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == v.normal_login || id == v.mobile_login) {
            el(view.getId());
        } else if (id == v.button_account_del) {
            this.awL.setText((CharSequence) null);
        } else if (id == v.button_pass_del) {
            this.awM.setText((CharSequence) null);
        } else if (id == v.button_vcode_del) {
            this.avS.setText((CharSequence) null);
        } else if (id == v.button_vcode_refresh || id == v.image_vcode1 || id == v.image_vcode2) {
            eV(this.mVcodeUrl);
        }
    }

    private void EF() {
        if (this.awH == 0) {
            if (this.awE == null) {
                this.mAccount = null;
                this.awL.setText((CharSequence) null);
                this.awM.setText((CharSequence) null);
                this.avS.setText((CharSequence) null);
                this.awU.setVisibility(8);
                this.avO.setVisibility(4);
                this.awK = true;
                this.awJ = false;
            } else {
                this.mAccount = this.awE.mAccount;
                this.awL.setText(this.awE.mAccount);
                this.awM.setText(this.awE.mPassword);
                this.avS.setText(this.awE.mVcode);
                this.avO.setText(this.awE.So);
                this.awU.setVisibility(this.awE.axh);
                this.avO.setVisibility(this.awE.axi);
                this.awK = this.awE.awK;
                this.awJ = this.awE.axh == 0;
            }
        }
        if (this.awH == 1) {
            if (this.awF == null) {
                this.mAccount = null;
                this.awL.setText((CharSequence) null);
                this.awM.setText((CharSequence) null);
                this.avS.setText((CharSequence) null);
                this.awU.setVisibility(8);
                this.avO.setVisibility(4);
                this.awK = true;
                this.awJ = false;
            } else {
                this.mAccount = this.awF.mAccount;
                this.awL.setText(this.awF.mAccount);
                this.awM.setText(this.awF.mPassword);
                this.avS.setText(this.awF.mVcode);
                this.avO.setText(this.awF.So);
                this.awU.setVisibility(this.awF.axh);
                this.avO.setVisibility(this.awF.axi);
                this.awK = this.awF.awK;
                this.awJ = this.awF.axh == 0;
            }
        }
        EN();
        EE();
    }

    private void EG() {
        if (this.awH == 0) {
            this.awE = new j(this, null);
            this.awE.mAccount = this.awL.getText().toString();
            this.awE.mPassword = this.awM.getText().toString();
            this.awE.mVcode = this.avS.getText().toString();
            this.awE.So = this.avO.getText().toString();
            this.awE.axh = this.awU.getVisibility();
            this.awE.axi = this.avO.getVisibility();
            this.awE.awK = this.awK;
        }
        if (this.awH == 1) {
            this.awF = new j(this, null);
            this.awF.mAccount = this.awL.getText().toString();
            this.awF.mPassword = this.awM.getText().toString();
            this.awF.mVcode = this.avS.getText().toString();
            this.awF.So = this.avO.getText().toString();
            this.awF.axh = this.awU.getVisibility();
            this.awF.axi = this.avO.getVisibility();
            this.awF.awK = this.awK;
        }
    }

    public void EH() {
        if (this.axd == null) {
            String editable = this.awL.getText().toString();
            this.mPassword = com.baidu.adp.lib.util.c.m(this.awM.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.awJ || !bd.isEmpty(this.avS.getText().toString())) {
                    EL();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.awH)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId()));
                    if (this.awU != null && this.awU.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.avS.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.awG));
                    }
                    EO();
                    this.axd = new l(this, sb.toString(), arrayList);
                    this.axd.setPriority(3);
                    this.axd.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    public void uq() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.axe.getUser().getUserName());
        if (this.axe.getUser().getPassword() != null) {
            accountData.setPassword(this.axe.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.axe.getUser().getUserId());
        accountData.setBDUSS(this.axe.getUser().getBDUSS());
        accountData.setPortrait(this.axe.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.axe.qe() != null) {
            accountData.setTbs(this.axe.qe().getTbs());
        }
        this.afc = accountData;
        if (!TextUtils.isEmpty(this.afc.getAccount())) {
            com.baidu.tbadk.core.a.d.b(accountData);
            TbadkCoreApplication.setCurrentAccount(this.afc, getBaseContext());
            com.baidu.tbadk.coreExtra.act.l um = com.baidu.tbadk.coreExtra.act.a.um();
            if (um != null) {
                um.h(this.afc);
            }
            up();
            return;
        }
        if (this.aap == null) {
            this.aap = new t(getPageContext());
            this.aap.a(new i(this));
        }
        this.aap.xg();
        this.aap.setPhone(this.awL.getText().toString());
        this.aap.k(this.afc);
        this.aap.xc();
    }

    public void EI() {
        this.awK = false;
        EN();
    }

    public void eV(String str) {
        if (this.axf != null) {
            this.axf.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.awa.setImageDrawable(null);
        EO();
        this.axf = new k(this, null);
        this.axf.setPriority(3);
        this.axf.execute(str);
    }

    public void EJ() {
        this.awJ = true;
        this.awU.setVisibility(0);
        this.avS.setText((CharSequence) null);
        if (this.awK) {
            ba.i(this.awT, u.login_input_middle);
        } else {
            ba.i(this.awT, u.login_input_middlewrong);
        }
        EE();
    }

    public void EK() {
        this.awJ = false;
        this.awU.setVisibility(8);
        if (this.awK) {
            this.awT.setBackgroundResource(u.login_input_under);
        } else {
            this.awT.setBackgroundResource(u.login_input_underwrong);
        }
        EE();
    }

    private void EL() {
        this.awL.setEnabled(false);
        this.awM.setEnabled(false);
        this.avS.setEnabled(false);
        this.awR.setEnabled(false);
        this.awa.setEnabled(false);
        this.awV.setEnabled(false);
        this.awW.setEnabled(false);
        this.awX.setEnabled(false);
        this.axb.setEnabled(false);
        this.axc.setEnabled(false);
        this.awL.setTextColor(Color.rgb(136, 136, 136));
        this.awM.setTextColor(Color.rgb(136, 136, 136));
        this.avS.setTextColor(Color.rgb(136, 136, 136));
    }

    public void EM() {
        this.awL.setEnabled(true);
        this.awM.setEnabled(true);
        this.avS.setEnabled(true);
        this.awR.setEnabled(true);
        this.awa.setEnabled(true);
        this.awV.setEnabled(true);
        this.awW.setEnabled(true);
        this.awX.setEnabled(true);
        this.axb.setEnabled(true);
        this.axc.setEnabled(true);
        this.awL.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.awM.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.avS.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void EN() {
        if (this.awK) {
            ba.i(this.awS, u.login_input_top);
            if (this.awJ) {
                ba.i(this.awT, u.login_input_middle);
            } else {
                ba.i(this.awT, u.login_input_under);
            }
            ba.i(this.awU, u.login_input_under);
            return;
        }
        ba.i(this.awS, u.login_input_topwrong);
        if (this.awJ) {
            ba.i(this.awT, u.login_input_middlewrong);
        } else {
            ba.i(this.awT, u.login_input_underwrong);
        }
        ba.i(this.awU, u.login_input_underwrong);
    }

    public void EO() {
        if (this.axd != null) {
            this.axd.cancel();
            this.axd = null;
        }
        if (this.axf != null) {
            this.axf.cancel();
        }
    }

    public void yz() {
        EO();
        RegisterActivityConfig registerActivityConfig = new RegisterActivityConfig(getPageContext().getPageActivity());
        registerActivityConfig.setRequestCode(22002);
        registerActivityConfig.setIntentAction(IntentAction.ActivityForResult);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, registerActivityConfig));
    }

    private void us() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse() && MessageManager.getInstance().findTask(2015000) != null) {
            sendMessage(new CustomMessage(2015000, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
        } else {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }
}
