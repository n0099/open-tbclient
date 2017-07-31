package com.baidu.tieba.account;

import android.content.Context;
import android.content.DialogInterface;
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
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.coreExtra.view.d;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private BdAsyncTask<?, ?, ?> aXa;
    private View aXr;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private Button aXp = null;
    private Button aXq = null;
    private String ajt = null;
    private d aGZ = null;
    private boolean aXs = false;
    private boolean aXt = false;
    private int aXu = -1;
    CustomMessageListener aXv = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME) { // from class: com.baidu.tieba.account.NotLoginGuideActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001385 && customResponsedMessage.getData() != null) {
                NotLoginGuideActivity.this.finish();
            }
        }
    };
    private final a.InterfaceC0040a aeR = new a.InterfaceC0040a() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.2
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void cw(String str) {
            if (NotLoginGuideActivity.this.getLoadingDialog() == null || !NotLoginGuideActivity.this.getLoadingDialog().isShowing()) {
                NotLoginGuideActivity.this.showLoadingDialog(NotLoginGuideActivity.this.getPageContext().getString(d.l.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.2.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        NotLoginGuideActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_success", 0, "", new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (TextUtils.isEmpty(accountData.getAccount())) {
                NotLoginGuideActivity.this.k(accountData);
            } else {
                NotLoginGuideActivity.this.p(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0040a
        public void b(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_fail", i, str2, new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (NotLoginGuideActivity.this.aXu == 1) {
                NotLoginGuideActivity.this.KX();
            } else if (NotLoginGuideActivity.this.aXu == 2) {
                NotLoginGuideActivity.this.KY();
            }
        }
    };

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
        registerListener(this.aXv);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.ajt = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.ajt = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    private void initView() {
        setContentView(d.j.not_login_guide_activity);
        this.mImage = (ImageView) findViewById(d.h.guide_bg);
        this.aXp = (Button) findViewById(d.h.guide_regist);
        this.aXq = (Button) findViewById(d.h.guide_login);
        this.aXr = findViewById(d.h.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int ah = k.ah(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((ah * 0.2631579f) - (((ah * 0.2631579f) - k.g(getPageContext().getPageActivity(), d.f.ds190)) / 2.0f)) - k.g(getPageContext().getPageActivity(), d.f.ds16));
        this.aXr.setLayoutParams(layoutParams);
        this.mBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), d.g.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.aXp.setOnClickListener(this);
        this.aXq.setOnClickListener(this);
        this.aXr.setOnClickListener(this);
    }

    private void KU() {
        com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else if (!this.aXt && !TbadkCoreApplication.getInst().getIsFirstUse() && MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.aXp) {
            this.aXu = 2;
            KY();
        } else if (view == this.aXq) {
            this.aXu = 1;
            if (!KW()) {
                KX();
            }
        } else if (view == this.aXr) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aXs = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.ajt)) {
                    com.baidu.tbadk.core.e.b.i(getPageContext().getPageActivity(), 200);
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
        KV();
        if (this.aGZ != null) {
            this.aGZ.onDestroy();
        }
        if (this.aXa != null) {
            this.aXa.cancel();
        }
    }

    private void KV() {
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
                KU();
            } else if ((i == 22002 || i == 11038) && intent != null) {
                String stringExtra = intent.getStringExtra(RegisterActivityConfig.FAST_REG_USER_TYPE);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals(RegisterActivityConfig.LOGIN_USER)) {
                        KU();
                    } else if (stringExtra.equals(RegisterActivityConfig.REGIST_USER)) {
                        if (NewUserGuideActivityConfig.canResponse()) {
                            TbadkCoreApplication.getInst().setIsNewRegUser(true);
                            sendMessage(new CustomMessage((int) CmdConfigCustom.NEW_USER_GUIDE_PAGE, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), true, false)));
                        } else {
                            this.aXt = true;
                            KU();
                        }
                        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                            TbadkCoreApplication.getInst().setUsed();
                        }
                        finish();
                    }
                }
            }
        }
    }

    public boolean KW() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.d.a.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_silent_start", 0, "", new Object[0]);
            if (this.aXa != null) {
                this.aXa.cancel();
            }
            this.aXa = com.baidu.tbadk.core.a.a.pf().a(session.username, session.bduss, "", null, this.aeR);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(AccountData accountData) {
        if (this.aGZ == null) {
            this.aGZ = new com.baidu.tbadk.coreExtra.view.d(getPageContext());
            this.aGZ.a(new d.a() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.3
                @Override // com.baidu.tbadk.coreExtra.view.d.a
                public void j(AccountData accountData2) {
                    NotLoginGuideActivity.this.p(accountData2);
                }
            });
        }
        this.aGZ.Bn();
        this.aGZ.i(accountData);
        this.aGZ.Bj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final AccountData accountData) {
        h.gb().e(new Runnable() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
            }
        });
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.as(TbadkCoreApplication.getInst());
        KU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KX() {
        if (!this.aXs) {
            this.aXs = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TiebaStatic.log("c10520");
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 4, true, 11038)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KY() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_2", "click", 1, new Object[0]);
        TiebaStatic.log("sapi_fast_regist_click");
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RegisterActivityConfig(getPageContext().getPageActivity(), 4, 22002)));
    }
}
