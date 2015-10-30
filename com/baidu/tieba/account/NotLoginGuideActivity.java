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
    private View aFf;
    private ImageView aDq = null;
    private Bitmap mBitmap = null;
    private Button aFd = null;
    private Button aFe = null;
    private String mFrom = null;
    private com.baidu.tbadk.coreExtra.view.k auv = null;
    private boolean aFg = false;
    private int aFh = -1;
    CustomMessageListener aFi = new p(this, 0);
    private final a.InterfaceC0040a XS = new q(this);

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
        registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, this.aFi);
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
        this.aDq = (ImageView) findViewById(i.f.guide_bg);
        this.aFd = (Button) findViewById(i.f.guide_regist);
        this.aFe = (Button) findViewById(i.f.guide_login);
        this.aFf = findViewById(i.f.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((L * 0.2631579f) - (((L * 0.2631579f) - com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds190)) / 2.0f)) - com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), i.d.ds16));
        this.aFf.setLayoutParams(layoutParams);
        this.mBitmap = com.baidu.tbadk.core.util.c.f(getPageContext().getPageActivity(), i.e.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.aDq.setImageBitmap(this.mBitmap);
        }
        this.aFd.setOnClickListener(this);
        this.aFe.setOnClickListener(this);
        this.aFf.setOnClickListener(this);
    }

    private void FU() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aFd) {
            this.aFh = 2;
            FX();
        } else if (view == this.aFe) {
            this.aFh = 1;
            if (!FV()) {
                FW();
            }
        } else if (view == this.aFf) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aFg = false;
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
        if (this.auv != null) {
            this.auv.onDestroy();
        }
    }

    private void FF() {
        if (this.aDq != null) {
            this.aDq.setImageDrawable(null);
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
                FU();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra(RegisterActivityConfig.FAST_REG_USER_TYPE);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals(RegisterActivityConfig.LOGIN_USER)) {
                        FU();
                    } else if (stringExtra.equals(RegisterActivityConfig.REGIST_USER)) {
                        if (com.baidu.adp.lib.util.i.iM() && MessageManager.getInstance().findTask(CmdConfigCustom.NEW_USER_GUIDE_PAGE) != null) {
                            TbadkCoreApplication.m411getInst().setIsNewRegUser(true);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), true, false)));
                        } else {
                            FU();
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

    public boolean FV() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_start", 0, "", new Object[0]);
            com.baidu.tbadk.core.a.a.ra().a(session.username, session.bduss, session.ptoken, this.XS);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        if (this.auv == null) {
            this.auv = new com.baidu.tbadk.coreExtra.view.k(getPageContext());
            this.auv.a(new s(this));
        }
        this.auv.yO();
        this.auv.h(accountData);
        this.auv.yK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        com.baidu.adp.lib.g.k.hh().b(new t(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.g.W(TbadkCoreApplication.m411getInst());
        FU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FW() {
        if (!this.aFg) {
            this.aFg = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 4, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FX() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_2", "click", 1, new Object[0]);
        TiebaStatic.log("sapi_fast_regist_click");
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 4, 22002)));
    }
}
