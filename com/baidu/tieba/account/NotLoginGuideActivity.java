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
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.b;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private BdAsyncTask<?, ?, ?> fQR;
    private View fRk;
    private ImageView fRh = null;
    private Bitmap mBitmap = null;
    private Button fRi = null;
    private Button fRj = null;
    private String mFrom = null;
    private com.baidu.tbadk.coreExtra.view.b fbX = null;
    private boolean fRl = false;
    private boolean fRm = false;
    private int fRn = -1;
    CustomMessageListener mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME) { // from class: com.baidu.tieba.account.NotLoginGuideActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001385 && customResponsedMessage.getData() != null) {
                NotLoginGuideActivity.this.finish();
            }
        }
    };
    private final a.InterfaceC0574a fRo = new a.InterfaceC0574a() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.2
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0574a
        public void onBeforeLogin(String str) {
            if (NotLoginGuideActivity.this.getLoadingDialog() == null || !NotLoginGuideActivity.this.getLoadingDialog().isShowing()) {
                NotLoginGuideActivity.this.showLoadingDialog(NotLoginGuideActivity.this.getPageContext().getString(R.string.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.2.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        NotLoginGuideActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0574a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_success", 0, "", new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                NotLoginGuideActivity.this.n(accountData);
            } else {
                NotLoginGuideActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0574a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_fail", i, str2, new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (NotLoginGuideActivity.this.fRn == 1) {
                NotLoginGuideActivity.this.bJc();
            } else if (NotLoginGuideActivity.this.fRn == 2) {
                NotLoginGuideActivity.this.bJd();
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
        registerListener(this.mAccountChangeListener);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mFrom = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.mFrom = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    private void initView() {
        setContentView(R.layout.not_login_guide_activity);
        this.fRh = (ImageView) findViewById(R.id.guide_bg);
        this.fRi = (Button) findViewById(R.id.guide_regist);
        this.fRj = (Button) findViewById(R.id.guide_login);
        this.fRk = findViewById(R.id.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((equipmentHeight * 0.2631579f) - (((equipmentHeight * 0.2631579f) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds190)) / 2.0f)) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16));
        this.fRk.setLayoutParams(layoutParams);
        this.mBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), R.drawable.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.fRh.setImageBitmap(this.mBitmap);
        }
        this.fRi.setOnClickListener(this);
        this.fRj.setOnClickListener(this);
        this.fRk.setOnClickListener(this);
    }

    private void bJa() {
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else if (!this.fRm && !TbadkCoreApplication.getInst().getIsFirstUse() && MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fRi) {
            this.fRn = 2;
            bJd();
        } else if (view == this.fRj) {
            this.fRn = 1;
            if (!bJb()) {
                bJc();
            }
        } else if (view == this.fRk) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fRl = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.mFrom)) {
                    com.baidu.tbadk.core.e.b.r(getPageContext().getPageActivity(), 200);
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
        releaseResource();
        if (this.fbX != null) {
            this.fbX.onDestroy();
        }
        if (this.fQR != null) {
            this.fQR.cancel();
        }
    }

    private void releaseResource() {
        if (this.fRh != null) {
            this.fRh.setImageDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003) {
            bJa();
        }
    }

    public boolean bJb() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_start", 0, "", new Object[0]);
            if (this.fQR != null) {
                this.fQR.cancel();
            }
            this.fQR = com.baidu.tbadk.core.a.a.bjI().a(session.username, session.bduss, "", null, this.fRo);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.fbX == null) {
            this.fbX = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fbX.a(new b.a() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.3
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    NotLoginGuideActivity.this.n(accountData2);
                }
            });
        }
        this.fbX.bxR();
        this.fbX.setAccountData(accountData);
        this.fbX.bxN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final AccountData accountData) {
        h.mZ().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
            }
        });
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "not_login_guide_activity", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.initCookie(TbadkCoreApplication.getInst());
        bJa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJc() {
        if (!this.fRl) {
            this.fRl = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TiebaStatic.log("c10520");
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJd() {
        bJc();
    }
}
