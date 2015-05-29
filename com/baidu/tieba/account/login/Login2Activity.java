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
    private k ayk;
    private k ayl;
    private NavigationBar mNavigationBar;
    private String mAccount = null;
    private String mPassword = null;
    private String aym = null;
    private String mVcodeUrl = null;
    private int ayn = 0;
    private boolean ayo = true;
    private boolean abu = false;
    private boolean ayp = false;
    private boolean ayq = true;
    private int mFrom = -1;
    private EditText ayr = null;
    private EditText ays = null;
    private EditText axx = null;
    private View ayt = null;
    private ImageView axF = null;
    private ImageView ayu = null;
    private ImageView ayv = null;
    private ProgressBar mProgressBar = null;
    private ProgressBar ayw = null;
    private Button ayx = null;
    private View axi = null;
    private View ayy = null;
    private View ayz = null;
    private View ayA = null;
    private Button ayB = null;
    private Button ayC = null;
    private Button ayD = null;
    private TextView ayE = null;
    private TextView axt = null;
    private TextView ayF = null;
    private TextView ayG = null;
    private Button ayH = null;
    private Button ayI = null;
    RelativeLayout awa = null;
    private m ayJ = null;
    private n ayK = null;
    private l ayL = null;
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
        this.ayo = intent.getBooleanExtra(LoginActivityConfig.HAS_EXIT_DIALOG, true);
        this.abu = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        if (bundle != null) {
            this.ayn = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
        } else {
            this.ayn = 0;
        }
        if (intent.getIntExtra(LoginActivityConfig.LOGIN_TYPE, 0) == 1) {
            this.ayn = 1;
        }
        if (stringExtra != null) {
            this.ayr.setText(stringExtra);
        }
        this.ayr.requestFocus();
        if (this.ayo) {
            this.axi.setVisibility(4);
        } else {
            this.axi.setVisibility(0);
        }
        if (this.ayn == 0) {
            ex(q.normal_login);
        } else if (this.ayn == 1) {
            ex(q.mobile_login);
        }
        ShowSoftKeyPadDelay(this.ayr, 150);
        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp(), TbConfig.ST_TYPE_LOGIN, null, 1, new Object[0]);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.ayn = bundle.getInt(LoginActivityConfig.TYPE_LOGIN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(LoginActivityConfig.TYPE_LOGIN, this.ayn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            FG();
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
            ShowSoftKeyPadDelay(this.ayr, 150);
        }
        super.onResume();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ayo) {
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
        this.awa = (RelativeLayout) findViewById(q.container);
        this.mNavigationBar = (NavigationBar) findViewById(q.view_navigation_bar);
        this.axi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.title_login));
        this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.t.account_regedit), new c(this));
        this.ayr = (EditText) findViewById(q.login_edit_account);
        this.ays = (EditText) findViewById(q.login_edit_password);
        this.axx = (EditText) findViewById(q.edit_vcode);
        this.ayy = findViewById(q.layout_account);
        this.ayz = findViewById(q.layout_password);
        this.ayA = findViewById(q.layout_vcode);
        this.mProgressBar = (ProgressBar) findViewById(q.image_progress);
        this.ayu = (ImageView) findViewById(q.image_vcode1);
        this.ayv = (ImageView) findViewById(q.image_vcode2);
        this.axF = this.ayu;
        this.ayw = (ProgressBar) findViewById(q.progress_login);
        this.ayx = (Button) findViewById(q.button_vcode_refresh);
        this.ayB = (Button) findViewById(q.button_account_del);
        this.ayC = (Button) findViewById(q.button_pass_del);
        this.ayD = (Button) findViewById(q.button_vcode_del);
        this.ayE = (TextView) findViewById(q.text_title_account);
        this.axt = (TextView) findViewById(q.text_error);
        this.ayF = (TextView) findViewById(q.text_info);
        if (this.mInfo != null && this.mInfo.length() > 0) {
            this.ayF.setText(this.mInfo);
            this.ayF.setVisibility(0);
        }
        this.ayG = (TextView) findViewById(q.text_login);
        this.ayH = (Button) findViewById(q.normal_login);
        this.ayI = (Button) findViewById(q.mobile_login);
        this.ayH.setOnClickListener(this);
        this.ayI.setOnClickListener(this);
        this.ayB.setOnClickListener(this);
        this.ayC.setOnClickListener(this);
        this.ayD.setOnClickListener(this);
        this.ayx.setOnClickListener(this);
        this.ayu.setOnClickListener(this);
        this.ayv.setOnClickListener(this);
        d dVar = new d(this);
        this.ayr.setOnFocusChangeListener(dVar);
        this.ays.setOnFocusChangeListener(dVar);
        this.axx.setOnFocusChangeListener(dVar);
        e eVar = new e(this);
        this.ays.setOnEditorActionListener(eVar);
        this.axx.setOnEditorActionListener(eVar);
        this.ayr.addTextChangedListener(new f(this));
        this.ays.addTextChangedListener(new g(this));
        this.axx.addTextChangedListener(new h(this));
        this.ayt = findViewById(q.layout_login);
        this.ayt.setEnabled(false);
        this.ayt.setOnClickListener(new i(this));
        FC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ay.b(this.ayG, i);
        ay.g(this.awa, i);
        if (i == 1) {
            this.ayF.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_common_color));
        } else {
            this.ayF.setTextColor(-13279809);
        }
        FF();
        Fv();
    }

    private void Fv() {
        if (this.ayn == 0) {
            if (this.mSkinType == 1) {
                this.ayH.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_common_color));
                this.ayI.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_tab_unsel_color));
            } else {
                this.ayH.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.ayI.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ay.i((View) this.ayH, p.login_tab_pressed);
            ay.i((View) this.ayI, p.login_tab_normal);
        } else if (this.ayn == 1) {
            if (this.mSkinType == 1) {
                this.ayI.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_common_color));
                this.ayH.setTextColor(getResources().getColor(com.baidu.tieba.n.skin_1_tab_unsel_color));
            } else {
                this.ayI.setTextColor(Color.rgb(50, 137, (int) a0.f35if));
                this.ayH.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            ay.i((View) this.ayI, p.login_tab_pressed);
            ay.i((View) this.ayH, p.login_tab_normal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fw() {
        boolean z;
        String editable = this.ayr.getText().toString();
        String editable2 = this.ays.getText().toString();
        String editable3 = this.axx.getText().toString();
        if (this.ayA.getVisibility() == 8) {
            z = bb.isEmpty(editable) || bb.isEmpty(editable2);
        } else {
            z = bb.isEmpty(editable) || bb.isEmpty(editable2) || bb.isEmpty(editable3);
        }
        if (!z) {
            this.ayt.setEnabled(true);
        } else {
            this.ayt.setEnabled(false);
        }
    }

    private void ex(int i) {
        if (i == q.normal_login) {
            this.axF = this.ayu;
            this.ayu.setVisibility(0);
            this.ayv.setVisibility(8);
            Fy();
            this.ayn = 0;
            Fx();
            this.ayr.setHint(com.baidu.tieba.t.account_hint_normal);
            this.ayE.setText(com.baidu.tieba.t.account_account);
            this.ayr.requestFocus();
            this.ayr.setInputType(1);
            Fv();
        } else if (i == q.mobile_login) {
            this.axF = this.ayv;
            this.ayu.setVisibility(8);
            this.ayv.setVisibility(0);
            Fy();
            this.ayn = 1;
            Fx();
            this.ayr.setHint(com.baidu.tieba.t.account_mobile);
            this.ayE.setText(com.baidu.tieba.t.account_mobile);
            this.ayr.requestFocus();
            this.ayr.setInputType(3);
            Fv();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == q.normal_login || id == q.mobile_login) {
            ex(view.getId());
        } else if (id == q.button_account_del) {
            this.ayr.setText((CharSequence) null);
        } else if (id == q.button_pass_del) {
            this.ays.setText((CharSequence) null);
        } else if (id == q.button_vcode_del) {
            this.axx.setText((CharSequence) null);
        } else if (id == q.button_vcode_refresh || id == q.image_vcode1 || id == q.image_vcode2) {
            fq(this.mVcodeUrl);
        }
    }

    private void Fx() {
        if (this.ayn == 0) {
            if (this.ayk == null) {
                this.mAccount = null;
                this.ayr.setText((CharSequence) null);
                this.ays.setText((CharSequence) null);
                this.axx.setText((CharSequence) null);
                this.ayA.setVisibility(8);
                this.axt.setVisibility(4);
                this.ayq = true;
                this.ayp = false;
            } else {
                this.mAccount = this.ayk.mAccount;
                this.ayr.setText(this.ayk.mAccount);
                this.ays.setText(this.ayk.mPassword);
                this.axx.setText(this.ayk.mVcode);
                this.axt.setText(this.ayk.SY);
                this.ayA.setVisibility(this.ayk.ayN);
                this.axt.setVisibility(this.ayk.ayO);
                this.ayq = this.ayk.ayq;
                this.ayp = this.ayk.ayN == 0;
            }
        }
        if (this.ayn == 1) {
            if (this.ayl == null) {
                this.mAccount = null;
                this.ayr.setText((CharSequence) null);
                this.ays.setText((CharSequence) null);
                this.axx.setText((CharSequence) null);
                this.ayA.setVisibility(8);
                this.axt.setVisibility(4);
                this.ayq = true;
                this.ayp = false;
            } else {
                this.mAccount = this.ayl.mAccount;
                this.ayr.setText(this.ayl.mAccount);
                this.ays.setText(this.ayl.mPassword);
                this.axx.setText(this.ayl.mVcode);
                this.axt.setText(this.ayl.SY);
                this.ayA.setVisibility(this.ayl.ayN);
                this.axt.setVisibility(this.ayl.ayO);
                this.ayq = this.ayl.ayq;
                this.ayp = this.ayl.ayN == 0;
            }
        }
        FF();
        Fw();
    }

    private void Fy() {
        if (this.ayn == 0) {
            this.ayk = new k(this, null);
            this.ayk.mAccount = this.ayr.getText().toString();
            this.ayk.mPassword = this.ays.getText().toString();
            this.ayk.mVcode = this.axx.getText().toString();
            this.ayk.SY = this.axt.getText().toString();
            this.ayk.ayN = this.ayA.getVisibility();
            this.ayk.ayO = this.axt.getVisibility();
            this.ayk.ayq = this.ayq;
        }
        if (this.ayn == 1) {
            this.ayl = new k(this, null);
            this.ayl.mAccount = this.ayr.getText().toString();
            this.ayl.mPassword = this.ays.getText().toString();
            this.ayl.mVcode = this.axx.getText().toString();
            this.ayl.SY = this.axt.getText().toString();
            this.ayl.ayN = this.ayA.getVisibility();
            this.ayl.ayO = this.axt.getVisibility();
            this.ayl.ayq = this.ayq;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fz() {
        if (this.ayJ == null) {
            String editable = this.ayr.getText().toString();
            this.mPassword = com.baidu.adp.lib.util.c.m(this.ays.getText().toString().getBytes());
            if (editable.length() > 0 && this.mPassword.length() > 0) {
                if (!this.ayp || !bb.isEmpty(this.axx.getText().toString())) {
                    FD();
                    StringBuilder sb = new StringBuilder(30);
                    sb.append(TbConfig.LOGIN_FULL_ADDRESS);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BasicNameValuePair("un", editable));
                    arrayList.add(new BasicNameValuePair("passwd", this.mPassword));
                    arrayList.add(new BasicNameValuePair("isphone", String.valueOf(this.ayn)));
                    arrayList.add(new BasicNameValuePair("channel_id", TbadkCoreApplication.m411getInst().getPushChannelId()));
                    arrayList.add(new BasicNameValuePair("channel_uid", TbadkCoreApplication.m411getInst().getPushChannelUserId()));
                    if (this.ayA != null && this.ayA.getVisibility() == 0) {
                        arrayList.add(new BasicNameValuePair("vcode", this.axx.getText().toString()));
                        arrayList.add(new BasicNameValuePair("vcode_md5", this.aym));
                    }
                    FG();
                    this.ayJ = new m(this, sb.toString(), arrayList);
                    this.ayJ.setPriority(3);
                    this.ayJ.execute(sb.toString(), arrayList);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        AccountData accountData = new AccountData();
        accountData.setAccount(this.ayK.getUser().getUserName());
        if (this.ayK.getUser().getPassword() != null) {
            accountData.setPassword(this.ayK.getUser().getPassword());
        } else {
            accountData.setPassword(this.mPassword);
        }
        accountData.setID(this.ayK.getUser().getUserId());
        accountData.setBDUSS(this.ayK.getUser().getBDUSS());
        accountData.setPortrait(this.ayK.getUser().getPortrait());
        accountData.setIsActive(1);
        if (this.ayK.qK() != null) {
            accountData.setTbs(this.ayK.qK().getTbs());
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
        this.abq.xS();
        this.abq.setPhone(this.ayr.getText().toString());
        this.abq.k(this.agd);
        this.abq.xO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        this.ayq = false;
        FF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(String str) {
        if (this.ayL != null) {
            this.ayL.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.axF.setImageDrawable(null);
        FG();
        this.ayL = new l(this, null);
        this.ayL.setPriority(3);
        this.ayL.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FB() {
        this.ayp = true;
        this.ayA.setVisibility(0);
        this.axx.setText((CharSequence) null);
        if (this.ayq) {
            ay.i(this.ayz, p.login_input_middle);
        } else {
            ay.i(this.ayz, p.login_input_middlewrong);
        }
        Fw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC() {
        this.ayp = false;
        this.ayA.setVisibility(8);
        if (this.ayq) {
            this.ayz.setBackgroundResource(p.login_input_under);
        } else {
            this.ayz.setBackgroundResource(p.login_input_underwrong);
        }
        Fw();
    }

    private void FD() {
        this.ayr.setEnabled(false);
        this.ays.setEnabled(false);
        this.axx.setEnabled(false);
        this.ayx.setEnabled(false);
        this.axF.setEnabled(false);
        this.ayB.setEnabled(false);
        this.ayC.setEnabled(false);
        this.ayD.setEnabled(false);
        this.ayH.setEnabled(false);
        this.ayI.setEnabled(false);
        this.ayr.setTextColor(Color.rgb(136, 136, 136));
        this.ays.setTextColor(Color.rgb(136, 136, 136));
        this.axx.setTextColor(Color.rgb(136, 136, 136));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FE() {
        this.ayr.setEnabled(true);
        this.ays.setEnabled(true);
        this.axx.setEnabled(true);
        this.ayx.setEnabled(true);
        this.axF.setEnabled(true);
        this.ayB.setEnabled(true);
        this.ayC.setEnabled(true);
        this.ayD.setEnabled(true);
        this.ayH.setEnabled(true);
        this.ayI.setEnabled(true);
        this.ayr.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.ays.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.axx.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FF() {
        if (this.ayq) {
            ay.i(this.ayy, p.login_input_top);
            if (this.ayp) {
                ay.i(this.ayz, p.login_input_middle);
            } else {
                ay.i(this.ayz, p.login_input_under);
            }
            ay.i(this.ayA, p.login_input_under);
            return;
        }
        ay.i(this.ayy, p.login_input_topwrong);
        if (this.ayp) {
            ay.i(this.ayz, p.login_input_middlewrong);
        } else {
            ay.i(this.ayz, p.login_input_underwrong);
        }
        ay.i(this.ayA, p.login_input_underwrong);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1631)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:332)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
     */
    public static /* synthetic */ void x(Login2Activity login2Activity) {
        login2Activity.FG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        if (this.ayJ != null) {
            this.ayJ.cancel();
            this.ayJ = null;
        }
        if (this.ayL != null) {
            this.ayL.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm() {
        FG();
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
