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
    private BdAsyncTask<?, ?, ?> aRG;
    private View aSv;
    private ImageView aSs = null;
    private Bitmap mBitmap = null;
    private Button aSt = null;
    private Button aSu = null;
    private String acU = null;
    private com.baidu.tbadk.coreExtra.view.j azc = null;
    private boolean aSw = false;
    private boolean aSx = false;
    private int aSy = -1;
    CustomMessageListener aSz = new u(this, CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME);
    private final a.InterfaceC0033a XY = new v(this);

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
        registerListener(this.aSz);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.acU = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.acU = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    private void initView() {
        setContentView(t.h.not_login_guide_activity);
        this.aSs = (ImageView) findViewById(t.g.guide_bg);
        this.aSt = (Button) findViewById(t.g.guide_regist);
        this.aSu = (Button) findViewById(t.g.guide_login);
        this.aSv = findViewById(t.g.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int L = com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((L * 0.2631579f) - (((L * 0.2631579f) - com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), t.e.ds190)) / 2.0f)) - com.baidu.adp.lib.util.k.e(getPageContext().getPageActivity(), t.e.ds16));
        this.aSv.setLayoutParams(layoutParams);
        this.mBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), t.f.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.aSs.setImageBitmap(this.mBitmap);
        }
        this.aSt.setOnClickListener(this);
        this.aSu.setOnClickListener(this);
        this.aSv.setOnClickListener(this);
    }

    private void LD() {
        com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            boolean OJ = com.baidu.tieba.d.a.OI().OJ();
            if (!this.aSx && !TbadkCoreApplication.m9getInst().getIsFirstUse() && OJ && MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                if (com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aSt) {
            this.aSy = 2;
            LH();
        } else if (view == this.aSu) {
            this.aSy = 1;
            if (!LF()) {
                LG();
            }
        } else if (view == this.aSv) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aSw = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.acU)) {
                    com.baidu.tbadk.core.d.b.f(getPageContext().getPageActivity(), 200);
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
        LE();
        if (this.azc != null) {
            this.azc.onDestroy();
        }
        if (this.aRG != null) {
            this.aRG.cancel();
        }
    }

    private void LE() {
        if (this.aSs != null) {
            this.aSs.setImageDrawable(null);
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
                LD();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra(RegisterActivityConfig.FAST_REG_USER_TYPE);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals(RegisterActivityConfig.LOGIN_USER)) {
                        LD();
                    } else if (stringExtra.equals(RegisterActivityConfig.REGIST_USER)) {
                        if (NewUserGuideActivityConfig.canResponse()) {
                            TbadkCoreApplication.m9getInst().setIsNewRegUser(true);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), true, false)));
                        } else {
                            this.aSx = true;
                            LD();
                        }
                        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
                            TbadkCoreApplication.m9getInst().setUsed();
                        }
                        finish();
                    }
                }
            }
        }
    }

    public boolean LF() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_start", 0, "", new Object[0]);
            if (this.aRG != null) {
                this.aRG.cancel();
            }
            this.aRG = com.baidu.tbadk.core.a.a.oO().a(session.username, session.bduss, "", null, this.XY);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.azc == null) {
            this.azc = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.azc.a(new x(this));
        }
        this.azc.AL();
        this.azc.i(accountData);
        this.azc.AH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(AccountData accountData) {
        com.baidu.adp.lib.h.k.eH().e(new y(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.R(TbadkCoreApplication.m9getInst());
        LD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LG() {
        if (!this.aSw) {
            this.aSw = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TiebaStatic.log("c10520");
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 4, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LH() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_2", "click", 1, new Object[0]);
        TiebaStatic.log("sapi_fast_regist_click");
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 4, 22002)));
    }
}
