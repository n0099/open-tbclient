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
/* loaded from: classes16.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private BdAsyncTask<?, ?, ?> fbQ;
    private View fcj;
    private ImageView fcg = null;
    private Bitmap mBitmap = null;
    private Button fch = null;
    private Button fci = null;
    private String mFrom = null;
    private com.baidu.tbadk.coreExtra.view.b epl = null;
    private boolean fck = false;
    private boolean fcl = false;
    private int fcm = -1;
    CustomMessageListener mAccountChangeListener = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_ON_RESUME) { // from class: com.baidu.tieba.account.NotLoginGuideActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001385 && customResponsedMessage.getData() != null) {
                NotLoginGuideActivity.this.finish();
            }
        }
    };
    private final a.InterfaceC0490a fcn = new a.InterfaceC0490a() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.2
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0490a
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

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0490a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_success", 0, "", new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                NotLoginGuideActivity.this.n(accountData);
            } else {
                NotLoginGuideActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0490a
        public void onFailure(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_fail", i, str2, new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (NotLoginGuideActivity.this.fcm == 1) {
                NotLoginGuideActivity.this.brO();
            } else if (NotLoginGuideActivity.this.fcm == 2) {
                NotLoginGuideActivity.this.brP();
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
        this.fcg = (ImageView) findViewById(R.id.guide_bg);
        this.fch = (Button) findViewById(R.id.guide_regist);
        this.fci = (Button) findViewById(R.id.guide_login);
        this.fcj = findViewById(R.id.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((equipmentHeight * 0.2631579f) - (((equipmentHeight * 0.2631579f) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds190)) / 2.0f)) - l.getDimens(getPageContext().getPageActivity(), R.dimen.ds16));
        this.fcj.setLayoutParams(layoutParams);
        this.mBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), R.drawable.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.fcg.setImageBitmap(this.mBitmap);
        }
        this.fch.setOnClickListener(this);
        this.fci.setOnClickListener(this);
        this.fcj.setOnClickListener(this);
    }

    private void brM() {
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else if (!this.fcl && !TbadkCoreApplication.getInst().getIsFirstUse() && MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.ACCOUNT_FIRST_LOGIN + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fch) {
            this.fcm = 2;
            brP();
        } else if (view == this.fci) {
            this.fcm = 1;
            if (!brN()) {
                brO();
            }
        } else if (view == this.fcj) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fck = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.mFrom)) {
                    com.baidu.tbadk.core.e.b.q(getPageContext().getPageActivity(), 200);
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
        if (this.epl != null) {
            this.epl.onDestroy();
        }
        if (this.fbQ != null) {
            this.fbQ.cancel();
        }
    }

    private void releaseResource() {
        if (this.fcg != null) {
            this.fcg.setImageDrawable(null);
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
            brM();
        }
    }

    public boolean brN() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_start", 0, "", new Object[0]);
            if (this.fbQ != null) {
                this.fbQ.cancel();
            }
            this.fbQ = com.baidu.tbadk.core.a.a.aTw().a(session.username, session.bduss, "", null, this.fcn);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.epl == null) {
            this.epl = new com.baidu.tbadk.coreExtra.view.b(this);
            this.epl.a(new b.a() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.3
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    NotLoginGuideActivity.this.n(accountData2);
                }
            });
        }
        this.epl.bhi();
        this.epl.setAccountData(accountData);
        this.epl.bhe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final AccountData accountData) {
        h.lu().submitTaskToSingleThread(new Runnable() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
            }
        });
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "not_login_guide_activity", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.initCookie(TbadkCoreApplication.getInst());
        brM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brO() {
        if (!this.fck) {
            this.fck = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TiebaStatic.log("c10520");
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brP() {
        brO();
    }
}
