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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private BdAsyncTask<?, ?, ?> aLL;
    private View aMA;
    private ImageView aMx = null;
    private Bitmap mBitmap = null;
    private Button aMy = null;
    private Button aMz = null;
    private String adH = null;
    private com.baidu.tbadk.coreExtra.view.j ayp = null;
    private boolean aMB = false;
    private boolean aMC = false;
    private int aMD = -1;
    CustomMessageListener aME = new t(this, CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME);
    private final a.InterfaceC0042a YU = new u(this);

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
        registerListener(this.aME);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.adH = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.adH = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    private void initView() {
        setContentView(t.h.not_login_guide_activity);
        this.aMx = (ImageView) findViewById(t.g.guide_bg);
        this.aMy = (Button) findViewById(t.g.guide_regist);
        this.aMz = (Button) findViewById(t.g.guide_login);
        this.aMA = findViewById(t.g.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int C = com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((C * 0.2631579f) - (((C * 0.2631579f) - com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds190)) / 2.0f)) - com.baidu.adp.lib.util.k.c(getPageContext().getPageActivity(), t.e.ds16));
        this.aMA.setLayoutParams(layoutParams);
        this.mBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), t.f.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.aMx.setImageBitmap(this.mBitmap);
        }
        this.aMy.setOnClickListener(this);
        this.aMz.setOnClickListener(this);
        this.aMA.setOnClickListener(this);
    }

    private void JK() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            boolean Mx = com.baidu.tieba.a.a.Mw().Mx();
            if (!this.aMC && !TbadkCoreApplication.m411getInst().getIsFirstUse() && Mx && MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                if (com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aMy) {
            this.aMD = 2;
            JP();
        } else if (view == this.aMz) {
            this.aMD = 1;
            if (!JN()) {
                JO();
            }
        } else if (view == this.aMA) {
            JL();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    private void JL() {
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_DISABLE_JUMP_IN_ENTER_FORUM);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DISABLE_JUMP_IN_ENTER_FORUM));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aMB = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.adH)) {
                    com.baidu.tbadk.core.d.b.d(getPageContext().getPageActivity(), 200);
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
        JM();
        if (this.ayp != null) {
            this.ayp.onDestroy();
        }
        if (this.aLL != null) {
            this.aLL.cancel();
        }
    }

    private void JM() {
        if (this.aMx != null) {
            this.aMx.setImageDrawable(null);
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
                JK();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra(RegisterActivityConfig.FAST_REG_USER_TYPE);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals(RegisterActivityConfig.LOGIN_USER)) {
                        JK();
                    } else if (stringExtra.equals(RegisterActivityConfig.REGIST_USER)) {
                        if (com.baidu.adp.lib.util.i.jf() && MessageManager.getInstance().findTask(CmdConfigCustom.NEW_USER_GUIDE_PAGE) != null) {
                            TbadkCoreApplication.m411getInst().setIsNewRegUser(true);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), true, false)));
                        } else {
                            this.aMC = true;
                            JK();
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

    public boolean JN() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_start", 0, "", new Object[0]);
            if (this.aLL != null) {
                this.aLL.cancel();
            }
            this.aLL = com.baidu.tbadk.core.a.a.qM().a(session.username, session.bduss, session.ptoken, this.YU);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(AccountData accountData) {
        if (this.ayp == null) {
            this.ayp = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.ayp.a(new w(this));
        }
        this.ayp.Bw();
        this.ayp.h(accountData);
        this.ayp.Bs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        com.baidu.adp.lib.h.k.hy().b(new x(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.J(TbadkCoreApplication.m411getInst());
        JK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        if (!this.aMB) {
            this.aMB = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TiebaStatic.log("c10520");
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 4, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_2", "click", 1, new Object[0]);
        TiebaStatic.log("sapi_fast_regist_click");
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 4, 22002)));
    }
}
