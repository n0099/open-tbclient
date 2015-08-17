package com.baidu.tieba.account.login;

import android.content.Intent;
import android.graphics.Bitmap;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.location.a0;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.m;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.l;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class Login2Activity extends BaseActivity<Login2Activity> {
    private a aFC;
    private a aFD;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String aFE = null;
    private String mVcodeUrl = null;
    private int aFF = 0;
    private boolean aFG = true;
    private boolean agx = false;
    private boolean aFH = false;
    private boolean aFI = true;
    private int mFrom = -1;
    private EditText aFJ = null;
    private EditText aFK = null;
    private EditText aEP = null;
    private View aFL = null;
    private ImageView aEX = null;
    private ImageView aFM = null;
    private ImageView aFN = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar aFO = null;
    private Button aFP = null;
    private View aEA = null;
    private View aFQ = null;
    private View aFR = null;
    private View aFS = null;
    private Button aFT = null;
    private Button aFU = null;
    private Button aFV = null;
    private TextView aFW = null;
    private TextView aEL = null;
    private TextView aFX = null;
    private TextView aFY = null;
    private Button aFZ = null;
    private Button aGa = null;
    private RelativeLayout aGb = null;
    private c aGc = null;
    private m aGd = null;
    private b aGe = null;
    InputMethodManager mInputManager = null;
    l agt = null;
    private AccountData alk = null;
    private String mInfo = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(i.g.account_login_activity);
        this.mInfo = getIntent().getStringExtra(LoginActivityConfig.INFO);
        initUI();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(LoginActivityConfig.ACCOUNT);
        this.aFG = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.agx = intent.getBooleanExtra(IntentConfig.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        if (bundle != null) {
            this.aFF = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.aFF = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.aFF = 1;
        }
        if (stringExtra != null) {
            this.aFJ.setText(stringExtra);
        }
        this.aFJ.requestFocus();
        if (this.aFG) {
            this.aEA.setVisibility(4);
        } else {
            this.aEA.setVisibility(0);
        }
        if (this.aFF == 0) {
            eD(i.f.normal_login);
        } else if (this.aFF == 1) {
            eD(i.f.mobile_login);
        }
        ShowSoftKeyPadDelay(this.aFJ, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.aFF = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.aFF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            Gt();
            System.gc();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.agt != null) {
            this.agt.onDestroy();
        }
        if (this.mNavigationBar != null) {
            this.mNavigationBar.release();
        }
        if (this.aGb != null) {
            this.aGb.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        if (this.agt == null || !this.agt.isShowing()) {
            ShowSoftKeyPadDelay(this.aFJ, SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.aFG) {
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
    public void wc() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_local_goMainTab", 0, "", new Object[0]);
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.agx) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                if (com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                    intExtra = 1;
                } else {
                    intExtra = 1;
                }
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), intExtra, false);
        }
        finish();
    }

    private void initUI() {
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        this.aGb = (RelativeLayout) findViewById(i.f.layout_root);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.aEA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new com.baidu.tieba.account.login.a(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(i.C0057i.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(i.C0057i.account_regedit), new com.baidu.tieba.account.login.c(this));
        this.aFJ = (EditText) findViewById(i.f.login_edit_account);
        this.aFK = (EditText) findViewById(i.f.login_edit_password);
        this.aEP = (EditText) findViewById(i.f.edit_vcode);
        this.aFQ = findViewById(i.f.layout_account);
        this.aFR = findViewById(i.f.layout_password);
        this.aFS = findViewById(i.f.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(i.f.image_progress);
        this.aFM = (ImageView) findViewById(i.f.image_vcode1);
        this.aFN = (ImageView) findViewById(i.f.image_vcode2);
        this.aEX = this.aFM;
        this.aFO = (ProgressBar) findViewById(i.f.progress_login);
        this.aFP = (Button) findViewById(i.f.button_vcode_refresh);
        this.aFT = (Button) findViewById(i.f.button_account_del);
        this.aFU = (Button) findViewById(i.f.button_pass_del);
        this.aFV = (Button) findViewById(i.f.button_vcode_del);
        this.aFW = (TextView) findViewById(i.f.text_title_account);
        this.aEL = (TextView) findViewById(i.f.text_error);
        this.aFX = (TextView) findViewById(i.f.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.aFX.setText(this.mInfo);
            this.aFX.setVisibility(0);
        }
        this.aFY = (TextView) findViewById(i.f.text_login);
        this.aFZ = (Button) findViewById(i.f.normal_login);
        this.aGa = (Button) findViewById(i.f.mobile_login);
        this.aFZ.setOnClickListener(this);
        this.aGa.setOnClickListener(this);
        this.aFT.setOnClickListener(this);
        this.aFU.setOnClickListener(this);
        this.aFV.setOnClickListener(this);
        this.aFP.setOnClickListener(this);
        this.aFM.setOnClickListener(this);
        this.aFN.setOnClickListener(this);
        d dVar = new d(this);
        this.aFJ.setOnFocusChangeListener(dVar);
        this.aFK.setOnFocusChangeListener(dVar);
        this.aEP.setOnFocusChangeListener(dVar);
        e eVar = new e(this);
        this.aFK.setOnEditorActionListener(eVar);
        this.aEP.setOnEditorActionListener(eVar);
        this.aFJ.addTextChangedListener(new f(this));
        this.aFK.addTextChangedListener(new g(this));
        this.aEP.addTextChangedListener(new h(this));
        this.aFL = findViewById(i.f.layout_login);
        this.aFL.setEnabled(false);
        this.aFL.setOnClickListener(new i(this));
        Gp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        al.b(this.aFY, i);
        al.g(this.aGb, i);
        if (i == 1) {
            this.aFX.setTextColor(getResources().getColor(i.c.skin_1_common_color));
        } else {
            this.aFX.setTextColor(-13279809);
        }
        Gs();
        Gk();
    }

    private void Gk() {
        if (this.aFF == 0) {
            if (this.mSkinType == 1) {
                this.aFZ.setTextColor(getResources().getColor(i.c.skin_1_common_color));
                this.aGa.setTextColor(getResources().getColor(i.c.skin_1_tab_unsel_color));
            } else {
                this.aFZ.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.aGa.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            al.i((View) this.aFZ, i.e.login_tab_pressed);
            al.i((View) this.aGa, i.e.login_tab_normal);
        } else if (this.aFF == 1) {
            if (this.mSkinType == 1) {
                this.aGa.setTextColor(getResources().getColor(i.c.skin_1_common_color));
                this.aFZ.setTextColor(getResources().getColor(i.c.skin_1_tab_unsel_color));
            } else {
                this.aGa.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.aFZ.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            al.i((View) this.aGa, i.e.login_tab_pressed);
            al.i((View) this.aFZ, i.e.login_tab_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gl() {
        boolean z;
        String editable = this.aFJ.getText().toString();
        String editable2 = this.aFK.getText().toString();
        String editable3 = this.aEP.getText().toString();
        if (this.aFS.getVisibility() == 8) {
            z = aq.isEmpty(editable) || aq.isEmpty(editable2);
        } else {
            z = aq.isEmpty(editable) || aq.isEmpty(editable2) || aq.isEmpty(editable3);
        }
        if (!z) {
            this.aFL.setEnabled(true);
        } else {
            this.aFL.setEnabled(false);
        }
    }

    private void eD(int i) {
        if (i == i.f.normal_login) {
            this.aEX = this.aFM;
            this.aFM.setVisibility(0);
            this.aFN.setVisibility(8);
            Gn();
            this.aFF = 0;
            Gm();
            this.aFJ.setHint(i.C0057i.account_hint_normal);
            this.aFW.setText(i.C0057i.account_account);
            this.aFJ.requestFocus();
            this.aFJ.setInputType(1);
            Gk();
        } else if (i == i.f.mobile_login) {
            this.aEX = this.aFN;
            this.aFM.setVisibility(8);
            this.aFN.setVisibility(0);
            Gn();
            this.aFF = 1;
            Gm();
            this.aFJ.setHint(i.C0057i.account_mobile);
            this.aFW.setText(i.C0057i.account_mobile);
            this.aFJ.requestFocus();
            this.aFJ.setInputType(3);
            Gk();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == i.f.normal_login || id == i.f.mobile_login) {
            eD(view.getId());
        } else if (id == i.f.button_account_del) {
            this.aFJ.setText((CharSequence) null);
        } else if (id == i.f.button_pass_del) {
            this.aFK.setText((CharSequence) null);
        } else if (id == i.f.button_vcode_del) {
            this.aEP.setText((CharSequence) null);
        } else if (id == i.f.button_vcode_refresh || id == i.f.image_vcode1 || id == i.f.image_vcode2) {
            fK(this.mVcodeUrl);
        }
    }

    private void Gm() {
        if (this.aFF == 0) {
            if (this.aFC == null) {
                this.mAccount = null;
                this.aFJ.setText((CharSequence) null);
                this.aFK.setText((CharSequence) null);
                this.aEP.setText((CharSequence) null);
                this.aFS.setVisibility(8);
                this.aEL.setVisibility(4);
                this.aFI = true;
                this.aFH = false;
            } else {
                this.mAccount = this.aFC.mAccount;
                this.aFJ.setText(this.aFC.mAccount);
                this.aFK.setText(this.aFC.mPassword);
                this.aEP.setText(this.aFC.mVcode);
                this.aEL.setText(this.aFC.XT);
                this.aFS.setVisibility(this.aFC.aGg);
                this.aEL.setVisibility(this.aFC.aGh);
                this.aFI = this.aFC.aFI;
                this.aFH = this.aFC.aGg == 0;
            }
        }
        if (this.aFF == 1) {
            if (this.aFD == null) {
                this.mAccount = null;
                this.aFJ.setText((CharSequence) null);
                this.aFK.setText((CharSequence) null);
                this.aEP.setText((CharSequence) null);
                this.aFS.setVisibility(8);
                this.aEL.setVisibility(4);
                this.aFI = true;
                this.aFH = false;
            } else {
                this.mAccount = this.aFD.mAccount;
                this.aFJ.setText(this.aFD.mAccount);
                this.aFK.setText(this.aFD.mPassword);
                this.aEP.setText(this.aFD.mVcode);
                this.aEL.setText(this.aFD.XT);
                this.aFS.setVisibility(this.aFD.aGg);
                this.aEL.setVisibility(this.aFD.aGh);
                this.aFI = this.aFD.aFI;
                this.aFH = this.aFD.aGg == 0;
            }
        }
        Gs();
        Gl();
    }

    private void Gn() {
        if (this.aFF == 0) {
            this.aFC = new a(this, null);
            this.aFC.mAccount = this.aFJ.getText().toString();
            this.aFC.mPassword = this.aFK.getText().toString();
            this.aFC.mVcode = this.aEP.getText().toString();
            this.aFC.XT = this.aEL.getText().toString();
            this.aFC.aGg = this.aFS.getVisibility();
            this.aFC.aGh = this.aEL.getVisibility();
            this.aFC.aFI = this.aFI;
        }
        if (this.aFF == 1) {
            this.aFD = new a(this, null);
            this.aFD.mAccount = this.aFJ.getText().toString();
            this.aFD.mPassword = this.aFK.getText().toString();
            this.aFD.mVcode = this.aEP.getText().toString();
            this.aFD.XT = this.aEL.getText().toString();
            this.aFD.aGg = this.aFS.getVisibility();
            this.aFD.aGh = this.aEL.getVisibility();
            this.aFD.aFI = this.aFI;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go() {
        if (this.aGc == null) {
            String editable = this.aFJ.getText().toString();
            this.mPassword = com.baidu.adp.lib.util.c.encodeBytes(this.aFK.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.aFH || !aq.isEmpty(this.aEP.getText().toString())) {
                    Gq();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.aFF)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId()));
                    if (this.aFS != null && this.aFS.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.aEP.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.aFE));
                    }
                    Gt();
                    this.aGc = new c(sb.toString(), arrayList);
                    this.aGc.setPriority(3);
                    this.aGc.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wd() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_local_success", 0, "", new Object[0]);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.aGd.getUser().getUserName());
        if (this.aGd.getUser().getPassword() != null) {
            accountData.setPassword(this.aGd.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.aGd.getUser().getUserId());
        accountData.setBDUSS(this.aGd.getUser().getBDUSS());
        accountData.setPortrait(this.aGd.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.aGd.rM() != null) {
            accountData.setTbs(this.aGd.rM().getTbs());
        }
        this.alk = accountData;
        if (!TextUtils.isEmpty(this.alk.getAccount())) {
            com.baidu.tbadk.core.a.b.b(accountData);
            TbadkCoreApplication.setCurrentAccount(this.alk, getPageContext().getPageActivity());
            com.baidu.tbadk.coreExtra.act.l vZ = com.baidu.tbadk.coreExtra.act.a.vZ();
            if (vZ != null) {
                vZ.h(this.alk);
            }
            wh();
            wc();
            return;
        }
        if (this.agt == null) {
            this.agt = new l(getPageContext());
            this.agt.a(new j(this));
        }
        this.agt.zc();
        this.agt.setPhone(this.aFJ.getText().toString());
        this.agt.l(this.alk);
        this.agt.yY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i, String str) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_local_fail", i, str, new Object[0]);
        this.aFI = false;
        Gs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(String str) {
        if (this.aGe != null) {
            this.aGe.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aEX.setImageDrawable(null);
        Gt();
        this.aGe = new b(this, null);
        this.aGe.setPriority(3);
        this.aGe.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, String str) {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_local_showvcode", i, str, new Object[0]);
        this.aFH = true;
        this.aFS.setVisibility(0);
        this.aEP.setText((CharSequence) null);
        if (this.aFI) {
            al.i(this.aFR, i.e.login_input_middle);
        } else {
            al.i(this.aFR, i.e.login_input_middlewrong);
        }
        Gl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp() {
        this.aFH = false;
        this.aFS.setVisibility(8);
        if (this.aFI) {
            this.aFR.setBackgroundResource(i.e.login_input_under);
        } else {
            this.aFR.setBackgroundResource(i.e.login_input_underwrong);
        }
        Gl();
    }

    private void Gq() {
        this.aFJ.setEnabled(false);
        this.aFK.setEnabled(false);
        this.aEP.setEnabled(false);
        this.aFP.setEnabled(false);
        this.aEX.setEnabled(false);
        this.aFT.setEnabled(false);
        this.aFU.setEnabled(false);
        this.aFV.setEnabled(false);
        this.aFZ.setEnabled(false);
        this.aGa.setEnabled(false);
        this.aFJ.setTextColor(Color.rgb(136, 136, 136));
        this.aFK.setTextColor(Color.rgb(136, 136, 136));
        this.aEP.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gr() {
        this.aFJ.setEnabled(true);
        this.aFK.setEnabled(true);
        this.aEP.setEnabled(true);
        this.aFP.setEnabled(true);
        this.aEX.setEnabled(true);
        this.aFT.setEnabled(true);
        this.aFU.setEnabled(true);
        this.aFV.setEnabled(true);
        this.aFZ.setEnabled(true);
        this.aGa.setEnabled(true);
        this.aFJ.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.aFK.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.aEP.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gs() {
        if (this.aFI) {
            al.i(this.aFQ, i.e.login_input_top);
            if (this.aFH) {
                al.i(this.aFR, i.e.login_input_middle);
            } else {
                al.i(this.aFR, i.e.login_input_under);
            }
            al.i(this.aFS, i.e.login_input_under);
            return;
        }
        al.i(this.aFQ, i.e.login_input_topwrong);
        if (this.aFH) {
            al.i(this.aFR, i.e.login_input_middlewrong);
        } else {
            al.i(this.aFR, i.e.login_input_underwrong);
        }
        al.i(this.aFS, i.e.login_input_underwrong);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt() {
        if (this.aGc != null) {
            this.aGc.cancel();
            this.aGc = null;
        }
        if (this.aGe != null) {
            this.aGe.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, m> {
        ArrayList<BasicNameValuePair> aGj;
        private String mUrl;
        private v afJ = null;
        private String aGk = null;

        public c(String str, ArrayList<BasicNameValuePair> arrayList) {
            this.mUrl = null;
            this.aGj = null;
            this.mUrl = str;
            this.aGj = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Login2Activity.this.HidenSoftKeyPad(Login2Activity.this.mInputManager, Login2Activity.this.aFJ);
            Login2Activity.this.HidenSoftKeyPad(Login2Activity.this.mInputManager, Login2Activity.this.aFK);
            Login2Activity.this.aFO.setVisibility(0);
            Login2Activity.this.aEL.setVisibility(4);
            Login2Activity.this.aFY.setText(i.C0057i.account_login_loading);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public m doInBackground(Object... objArr) {
            m mVar;
            Exception e;
            try {
                this.afJ = new v(this.mUrl);
                this.afJ.m(this.aGj);
                this.aGk = this.afJ.tD();
                if (!this.afJ.ue().uW().rb() || this.aGk == null) {
                    return null;
                }
                mVar = new m();
                try {
                    mVar.parserJson(this.aGk);
                    return mVar;
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    return mVar;
                }
            } catch (Exception e3) {
                mVar = null;
                e = e3;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(m mVar) {
            Login2Activity.this.aFO.setVisibility(8);
            Login2Activity.this.aFY.setText(i.C0057i.account_login);
            Login2Activity.this.Gr();
            if (mVar != null) {
                Login2Activity.this.aGd = mVar;
                Login2Activity.this.wd();
            } else if (this.afJ != null) {
                if ((!this.afJ.uh() || this.afJ.ui() != 5) && this.afJ.ui() != 6) {
                    Login2Activity.this.aEL.setVisibility(0);
                    Login2Activity.this.aEL.setText(this.afJ.getErrorString());
                    Login2Activity.this.aFX.setVisibility(8);
                    Login2Activity.this.x(this.afJ.uj(), this.afJ.getErrorString());
                } else {
                    com.baidu.tbadk.coreExtra.data.l lVar = new com.baidu.tbadk.coreExtra.data.l();
                    lVar.parserJson(this.aGk);
                    if (lVar.getVcode_pic_url() == null) {
                        Login2Activity.this.aEL.setVisibility(0);
                        Login2Activity.this.aEL.setText(this.afJ.getErrorString());
                        Login2Activity.this.aFX.setVisibility(8);
                        Login2Activity.this.x(this.afJ.uj(), this.afJ.getErrorString());
                    } else {
                        Login2Activity.this.aFE = lVar.getVcode_md5();
                        Login2Activity.this.mVcodeUrl = lVar.getVcode_pic_url();
                        Login2Activity.this.y(this.afJ.uj(), this.afJ.getErrorString());
                        Login2Activity.this.fK(Login2Activity.this.mVcodeUrl);
                        Login2Activity.this.mAccount = Login2Activity.this.aFJ.getText().toString();
                    }
                }
            }
            Login2Activity.this.aGc = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.afJ != null) {
                this.afJ.gM();
                this.afJ = null;
            }
            Login2Activity.this.aFO.setVisibility(8);
            Login2Activity.this.aFY.setText(i.C0057i.account_login);
            Login2Activity.this.Gr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, Bitmap> {
        v Tu;
        private volatile boolean aGi;

        private b() {
            this.Tu = null;
            this.aGi = false;
        }

        /* synthetic */ b(Login2Activity login2Activity, b bVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Login2Activity.this.aGe = null;
            if (this.Tu != null) {
                this.Tu.gM();
                this.Tu = null;
            }
            this.aGi = true;
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Login2Activity.this.aEX.setImageDrawable(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0 || this.aGi) {
                return null;
            }
            this.Tu = new v(str);
            return com.baidu.tbadk.core.util.c.N(this.Tu.tE());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Login2Activity.this.aGe = null;
            if (bitmap != null) {
                Login2Activity.this.aEX.setImageBitmap(bitmap);
            } else {
                Login2Activity.this.aEX.setImageResource(i.e.background);
            }
            Login2Activity.this.mProgressBar.setVisibility(8);
            super.onPostExecute((b) bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        String XT;
        boolean aFI;
        int aGg;
        int aGh;
        String mAccount;
        String mPassword;
        String mVcode;

        private a() {
        }

        /* synthetic */ a(Login2Activity login2Activity, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ() {
        Gt();
        if (this.mFrom == 2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 1, true, 11038)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            k.hj().b(new com.baidu.tieba.account.login.b(this));
        }
    }
}
