package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private View aEq;
    private ImageView aCs = null;
    private Bitmap mBitmap = null;
    private Button aEo = null;
    private Button aEp = null;
    private String mFrom = null;
    private com.baidu.tbadk.coreExtra.view.l agt = null;
    private boolean aEr = false;
    private int aEs = -1;
    CustomMessageListener aEt = new u(this, 0);
    private final a.InterfaceC0040a XQ = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        UtilHelper.commenDealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
        TbadkCoreApplication.setIntent(null);
        TiebaStatic.log("not_login_guide_page_pv");
        initData(bundle);
        initView();
        registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, this.aEt);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mFrom = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.mFrom = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [134=4] */
    private void initView() {
        setContentView(i.g.not_login_guide_activity);
        this.aCs = (ImageView) findViewById(i.f.guide_bg);
        this.aEo = (Button) findViewById(i.f.guide_regist);
        this.aEp = (Button) findViewById(i.f.guide_login);
        this.aEq = findViewById(i.f.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((L * 0.2631579f) - (((L * 0.2631579f) - com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds190)) / 2.0f)) - com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16));
        this.aEq.setLayoutParams(layoutParams);
        this.mBitmap = com.baidu.tbadk.core.util.c.f(getPageContext().getPageActivity(), i.e.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.aCs.setImageBitmap(this.mBitmap);
        }
        this.aEo.setOnClickListener(this);
        this.aEp.setOnClickListener(this);
        this.aEq.setOnClickListener(this);
    }

    private void wj() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.ts().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.ts().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aEo) {
            this.aEs = 2;
            FW();
        } else if (view == this.aEp) {
            this.aEs = 1;
            if (!FU()) {
                FV();
            }
        } else if (view == this.aEq) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aEr = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.mFrom)) {
                    com.baidu.tbadk.core.c.b.e(getPageContext().getPageActivity(), 200);
                }
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FF();
        if (this.agt != null) {
            this.agt.onDestroy();
        }
    }

    private void FF() {
        if (this.aCs != null) {
            this.aCs.setImageDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 11003) {
                wj();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra(RegisterActivityConfig.FAST_REG_USER_TYPE);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals(RegisterActivityConfig.LOGIN_USER)) {
                        wj();
                    } else if (stringExtra.equals(RegisterActivityConfig.REGIST_USER)) {
                        if (com.baidu.adp.lib.util.i.iO() && MessageManager.getInstance().findTask(CmdConfigCustom.NEW_USER_GUIDE_PAGE) != null) {
                            TbadkCoreApplication.m411getInst().setIsNewRegUser(true);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), true, false)));
                        } else {
                            wj();
                        }
                        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
                            TbadkCoreApplication.m411getInst().setUsed();
                        }
                        finish();
                    }
                }
            }
        }
    }

    public boolean FU() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_start", 0, "", new Object[0]);
            com.baidu.tbadk.core.a.a.rj().a(session.username, session.bduss, session.ptoken, this.XQ);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AccountData accountData) {
        if (this.agt == null) {
            this.agt = new com.baidu.tbadk.coreExtra.view.l(getPageContext());
            this.agt.a(new x(this));
        }
        this.agt.zc();
        this.agt.l(accountData);
        this.agt.yY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(AccountData accountData) {
        com.baidu.adp.lib.g.k.hj().b(new y(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.W(TbadkCoreApplication.m411getInst());
        wj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FV() {
        if (!this.aEr) {
            this.aEr = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 4, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FW() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_2", "click", 1, new Object[0]);
        TiebaStatic.log("sapi_fast_regist_click");
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 4, 22002)));
    }
}
