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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private View aVM;
    private BdAsyncTask<?, ?, ?> aVu;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private Button aVK = null;
    private Button aVL = null;
    private String ahM = null;
    private com.baidu.tbadk.coreExtra.view.j aDz = null;
    private boolean aVN = false;
    private boolean aVO = false;
    private int aVP = -1;
    CustomMessageListener aVQ = new p(this, CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME);
    private final a.InterfaceC0030a acU = new q(this);

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
        registerListener(this.aVQ);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.ahM = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.ahM = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    private void initView() {
        setContentView(w.j.not_login_guide_activity);
        this.mImage = (ImageView) findViewById(w.h.guide_bg);
        this.aVK = (Button) findViewById(w.h.guide_regist);
        this.aVL = (Button) findViewById(w.h.guide_login);
        this.aVM = findViewById(w.h.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int ag = com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((ag * 0.2631579f) - (((ag * 0.2631579f) - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds190)) / 2.0f)) - com.baidu.adp.lib.util.k.g(getPageContext().getPageActivity(), w.f.ds16));
        this.aVM.setLayoutParams(layoutParams);
        this.mBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), w.g.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.aVK.setOnClickListener(this);
        this.aVL.setOnClickListener(this);
        this.aVM.setOnClickListener(this);
    }

    private void Mb() {
        com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.m9getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else if (!this.aVO && !TbadkCoreApplication.m9getInst().getIsFirstUse() && MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aVK) {
            this.aVP = 2;
            Mf();
        } else if (view == this.aVL) {
            this.aVP = 1;
            if (!Md()) {
                Me();
            }
        } else if (view == this.aVM) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aVN = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.ahM)) {
                    com.baidu.tbadk.core.f.b.i(getPageContext().getPageActivity(), 200);
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
        Mc();
        if (this.aDz != null) {
            this.aDz.onDestroy();
        }
        if (this.aVu != null) {
            this.aVu.cancel();
        }
    }

    private void Mc() {
        if (this.mImage != null) {
            this.mImage.setImageDrawable(null);
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
                Mb();
            } else if ((i == 22002 || i == 11038) && intent != null) {
                String stringExtra = intent.getStringExtra(RegisterActivityConfig.FAST_REG_USER_TYPE);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals(RegisterActivityConfig.LOGIN_USER)) {
                        Mb();
                    } else if (stringExtra.equals(RegisterActivityConfig.REGIST_USER)) {
                        if (NewUserGuideActivityConfig.canResponse()) {
                            TbadkCoreApplication.m9getInst().setIsNewRegUser(true);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), true, false)));
                        } else {
                            this.aVO = true;
                            Mb();
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

    public boolean Md() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.e.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_start", 0, "", new Object[0]);
            if (this.aVu != null) {
                this.aVu.cancel();
            }
            this.aVu = com.baidu.tbadk.core.a.a.pw().a(session.username, session.bduss, "", null, this.acU);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aDz == null) {
            this.aDz = new com.baidu.tbadk.coreExtra.view.j(getPageContext());
            this.aDz.a(new s(this));
        }
        this.aDz.Bv();
        this.aDz.i(accountData);
        this.aDz.Br();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(AccountData accountData) {
        com.baidu.adp.lib.g.k.fS().e(new t(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.f.ar(TbadkCoreApplication.m9getInst());
        Mb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me() {
        if (!this.aVN) {
            this.aVN = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TiebaStatic.log("c10520");
            TbadkCoreApplication.m9getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 4, true, 11038)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mf() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_2", "click", 1, new Object[0]);
        TiebaStatic.log("sapi_fast_regist_click");
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 4, 22002)));
    }
}
