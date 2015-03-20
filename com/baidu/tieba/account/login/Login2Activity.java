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
    private j aww;
    private j awx;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String awy = null;
    private String mVcodeUrl = null;
    private int awz = 0;
    private boolean awA = true;
    private boolean aaq = false;
    private boolean awB = false;
    private boolean awC = true;
    private EditText awD = null;
    private EditText awE = null;
    private EditText avK = null;
    private View awF = null;
    private ImageView avS = null;
    private ImageView awG = null;
    private ImageView awH = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar awI = null;
    private Button awJ = null;
    private View avv = null;
    private View awK = null;
    private View awL = null;
    private View awM = null;
    private Button awN = null;
    private Button awO = null;
    private Button awP = null;
    private TextView awQ = null;
    private TextView avG = null;
    private TextView awR = null;
    private TextView awS = null;
    private Button awT = null;
    private Button awU = null;
    RelativeLayout aup = null;
    private l awV = null;
    private n awW = null;
    private k awX = null;
    InputMethodManager mInputManager = null;
    t aan = null;
    private AccountData aeU = null;
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
        this.awA = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.aaq = intent.getBooleanExtra(LoginActivityConfig.CLOSE, false);
        if (bundle != null) {
            this.awz = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.awz = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.awz = 1;
        }
        if (stringExtra != null) {
            this.awD.setText(stringExtra);
        }
        this.awD.requestFocus();
        if (this.awA) {
            this.avv.setVisibility(4);
        } else {
            this.avv.setVisibility(0);
        }
        if (this.awz == 0) {
            el(v.normal_login);
        } else if (this.awz == 1) {
            el(v.mobile_login);
        }
        ShowSoftKeyPadDelay(this.awD, 150);
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.awz = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.awz);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            EI();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.aan != null) {
            this.aan.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.aan == null || !this.aan.isShowing()) {
            ShowSoftKeyPadDelay(this.awD, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.awA) {
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
        if (this.aaq) {
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
        this.aup = (RelativeLayout) findViewById(v.container);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.avv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(y.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(y.account_regedit), new b(this));
        this.awD = (EditText) findViewById(v.login_edit_account);
        this.awE = (EditText) findViewById(v.login_edit_password);
        this.avK = (EditText) findViewById(v.edit_vcode);
        this.awK = findViewById(v.layout_account);
        this.awL = findViewById(v.layout_password);
        this.awM = findViewById(v.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(v.image_progress);
        this.awG = (ImageView) findViewById(v.image_vcode1);
        this.awH = (ImageView) findViewById(v.image_vcode2);
        this.avS = this.awG;
        this.awI = (ProgressBar) findViewById(v.progress_login);
        this.awJ = (Button) findViewById(v.button_vcode_refresh);
        this.awN = (Button) findViewById(v.button_account_del);
        this.awO = (Button) findViewById(v.button_pass_del);
        this.awP = (Button) findViewById(v.button_vcode_del);
        this.awQ = (TextView) findViewById(v.text_title_account);
        this.avG = (TextView) findViewById(v.text_error);
        this.awR = (TextView) findViewById(v.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.awR.setText(this.mInfo);
            this.awR.setVisibility(0);
        }
        this.awS = (TextView) findViewById(v.text_login);
        this.awT = (Button) findViewById(v.normal_login);
        this.awU = (Button) findViewById(v.mobile_login);
        c cVar = new c(this);
        this.awD.setOnFocusChangeListener(cVar);
        this.awE.setOnFocusChangeListener(cVar);
        this.avK.setOnFocusChangeListener(cVar);
        d dVar = new d(this);
        this.awE.setOnEditorActionListener(dVar);
        this.avK.setOnEditorActionListener(dVar);
        this.awD.addTextChangedListener(new e(this));
        this.awE.addTextChangedListener(new f(this));
        this.avK.addTextChangedListener(new g(this));
        this.awF = findViewById(v.layout_login);
        this.awF.setEnabled(false);
        this.awF.setOnClickListener(new h(this));
        EE();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ba.b(this.awS, i);
        ba.g(this.aup, i);
        if (i == 1) {
            this.awR.setTextColor(getResources().getColor(s.skin_1_common_color));
        } else {
            this.awR.setTextColor(-13279809);
        }
        EH();
        Ex();
    }

    private void Ex() {
        if (this.awz == 0) {
            if (this.mSkinType == 1) {
                this.awT.setTextColor(getResources().getColor(s.skin_1_common_color));
                this.awU.setTextColor(getResources().getColor(s.skin_1_tab_unsel_color));
            } else {
                this.awT.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.awU.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ba.i((View) this.awT, u.login_tab_pressed);
            ba.i((View) this.awU, u.login_tab_normal);
        } else if (this.awz == 1) {
            if (this.mSkinType == 1) {
                this.awU.setTextColor(getResources().getColor(s.skin_1_common_color));
                this.awT.setTextColor(getResources().getColor(s.skin_1_tab_unsel_color));
            } else {
                this.awU.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.awT.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ba.i((View) this.awU, u.login_tab_pressed);
            ba.i((View) this.awT, u.login_tab_normal);
        }
    }

    public void Ey() {
        boolean z;
        String editable = this.awD.getText().toString();
        String editable2 = this.awE.getText().toString();
        String editable3 = this.avK.getText().toString();
        if (this.awM.getVisibility() == 8) {
            z = bd.isEmpty(editable) || bd.isEmpty(editable2);
        } else {
            z = bd.isEmpty(editable) || bd.isEmpty(editable2) || bd.isEmpty(editable3);
        }
        if (!z) {
            this.awF.setEnabled(true);
        } else {
            this.awF.setEnabled(false);
        }
    }

    private void el(int i) {
        if (i == v.normal_login) {
            this.avS = this.awG;
            this.awG.setVisibility(0);
            this.awH.setVisibility(8);
            EA();
            this.awz = 0;
            Ez();
            this.awD.setHint(y.account_hint_normal);
            this.awQ.setText(y.account_account);
            this.awD.requestFocus();
            this.awD.setInputType(1);
            Ex();
        } else if (i == v.mobile_login) {
            this.avS = this.awH;
            this.awG.setVisibility(8);
            this.awH.setVisibility(0);
            EA();
            this.awz = 1;
            Ez();
            this.awD.setHint(y.account_mobile);
            this.awQ.setText(y.account_mobile);
            this.awD.requestFocus();
            this.awD.setInputType(3);
            Ex();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == v.normal_login || id == v.mobile_login) {
            el(view.getId());
        } else if (id == v.button_account_del) {
            this.awD.setText((CharSequence) null);
        } else if (id == v.button_pass_del) {
            this.awE.setText((CharSequence) null);
        } else if (id == v.button_vcode_del) {
            this.avK.setText((CharSequence) null);
        } else if (id == v.button_vcode_refresh || id == v.image_vcode1 || id == v.image_vcode2) {
            eS(this.mVcodeUrl);
        }
    }

    private void Ez() {
        if (this.awz == 0) {
            if (this.aww == null) {
                this.mAccount = null;
                this.awD.setText((CharSequence) null);
                this.awE.setText((CharSequence) null);
                this.avK.setText((CharSequence) null);
                this.awM.setVisibility(8);
                this.avG.setVisibility(4);
                this.awC = true;
                this.awB = false;
            } else {
                this.mAccount = this.aww.mAccount;
                this.awD.setText(this.aww.mAccount);
                this.awE.setText(this.aww.mPassword);
                this.avK.setText(this.aww.mVcode);
                this.avG.setText(this.aww.Sm);
                this.awM.setVisibility(this.aww.awZ);
                this.avG.setVisibility(this.aww.axa);
                this.awC = this.aww.awC;
                this.awB = this.aww.awZ == 0;
            }
        }
        if (this.awz == 1) {
            if (this.awx == null) {
                this.mAccount = null;
                this.awD.setText((CharSequence) null);
                this.awE.setText((CharSequence) null);
                this.avK.setText((CharSequence) null);
                this.awM.setVisibility(8);
                this.avG.setVisibility(4);
                this.awC = true;
                this.awB = false;
            } else {
                this.mAccount = this.awx.mAccount;
                this.awD.setText(this.awx.mAccount);
                this.awE.setText(this.awx.mPassword);
                this.avK.setText(this.awx.mVcode);
                this.avG.setText(this.awx.Sm);
                this.awM.setVisibility(this.awx.awZ);
                this.avG.setVisibility(this.awx.axa);
                this.awC = this.awx.awC;
                this.awB = this.awx.awZ == 0;
            }
        }
        EH();
        Ey();
    }

    private void EA() {
        if (this.awz == 0) {
            this.aww = new j(this, null);
            this.aww.mAccount = this.awD.getText().toString();
            this.aww.mPassword = this.awE.getText().toString();
            this.aww.mVcode = this.avK.getText().toString();
            this.aww.Sm = this.avG.getText().toString();
            this.aww.awZ = this.awM.getVisibility();
            this.aww.axa = this.avG.getVisibility();
            this.aww.awC = this.awC;
        }
        if (this.awz == 1) {
            this.awx = new j(this, null);
            this.awx.mAccount = this.awD.getText().toString();
            this.awx.mPassword = this.awE.getText().toString();
            this.awx.mVcode = this.avK.getText().toString();
            this.awx.Sm = this.avG.getText().toString();
            this.awx.awZ = this.awM.getVisibility();
            this.awx.axa = this.avG.getVisibility();
            this.awx.awC = this.awC;
        }
    }

    public void EB() {
        if (this.awV == null) {
            String editable = this.awD.getText().toString();
            this.mPassword = com.baidu.adp.lib.util.c.m(this.awE.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.awB || !bd.isEmpty(this.avK.getText().toString())) {
                    EF();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.awz)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId()));
                    if (this.awM != null && this.awM.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.avK.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.awy));
                    }
                    EI();
                    this.awV = new l(this, sb.toString(), arrayList);
                    this.awV.setPriority(3);
                    this.awV.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    public void uq() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.awW.getUser().getUserName());
        if (this.awW.getUser().getPassword() != null) {
            accountData.setPassword(this.awW.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.awW.getUser().getUserId());
        accountData.setBDUSS(this.awW.getUser().getBDUSS());
        accountData.setPortrait(this.awW.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.awW.qe() != null) {
            accountData.setTbs(this.awW.qe().getTbs());
        }
        this.aeU = accountData;
        if (!TextUtils.isEmpty(this.aeU.getAccount())) {
            com.baidu.tbadk.core.a.d.b(accountData);
            TbadkCoreApplication.setCurrentAccount(this.aeU, getBaseContext());
            com.baidu.tbadk.coreExtra.act.l um = com.baidu.tbadk.coreExtra.act.a.um();
            if (um != null) {
                um.h(this.aeU);
            }
            up();
            return;
        }
        if (this.aan == null) {
            this.aan = new t(getPageContext());
            this.aan.a(new i(this));
        }
        this.aan.xa();
        this.aan.setPhone(this.awD.getText().toString());
        this.aan.k(this.aeU);
        this.aan.wW();
    }

    public void EC() {
        this.awC = false;
        EH();
    }

    public void eS(String str) {
        if (this.awX != null) {
            this.awX.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.avS.setImageDrawable(null);
        EI();
        this.awX = new k(this, null);
        this.awX.setPriority(3);
        this.awX.execute(str);
    }

    public void ED() {
        this.awB = true;
        this.awM.setVisibility(0);
        this.avK.setText((CharSequence) null);
        if (this.awC) {
            ba.i(this.awL, u.login_input_middle);
        } else {
            ba.i(this.awL, u.login_input_middlewrong);
        }
        Ey();
    }

    public void EE() {
        this.awB = false;
        this.awM.setVisibility(8);
        if (this.awC) {
            this.awL.setBackgroundResource(u.login_input_under);
        } else {
            this.awL.setBackgroundResource(u.login_input_underwrong);
        }
        Ey();
    }

    private void EF() {
        this.awD.setEnabled(false);
        this.awE.setEnabled(false);
        this.avK.setEnabled(false);
        this.awJ.setEnabled(false);
        this.avS.setEnabled(false);
        this.awN.setEnabled(false);
        this.awO.setEnabled(false);
        this.awP.setEnabled(false);
        this.awT.setEnabled(false);
        this.awU.setEnabled(false);
        this.awD.setTextColor(Color.rgb(136, 136, 136));
        this.awE.setTextColor(Color.rgb(136, 136, 136));
        this.avK.setTextColor(Color.rgb(136, 136, 136));
    }

    public void EG() {
        this.awD.setEnabled(true);
        this.awE.setEnabled(true);
        this.avK.setEnabled(true);
        this.awJ.setEnabled(true);
        this.avS.setEnabled(true);
        this.awN.setEnabled(true);
        this.awO.setEnabled(true);
        this.awP.setEnabled(true);
        this.awT.setEnabled(true);
        this.awU.setEnabled(true);
        this.awD.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.awE.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.avK.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public void EH() {
        if (this.awC) {
            ba.i(this.awK, u.login_input_top);
            if (this.awB) {
                ba.i(this.awL, u.login_input_middle);
            } else {
                ba.i(this.awL, u.login_input_under);
            }
            ba.i(this.awM, u.login_input_under);
            return;
        }
        ba.i(this.awK, u.login_input_topwrong);
        if (this.awB) {
            ba.i(this.awL, u.login_input_middlewrong);
        } else {
            ba.i(this.awL, u.login_input_underwrong);
        }
        ba.i(this.awM, u.login_input_underwrong);
    }

    public void EI() {
        if (this.awV != null) {
            this.awV.cancel();
            this.awV = null;
        }
        if (this.awX != null) {
            this.awX.cancel();
        }
    }

    public void yt() {
        EI();
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
