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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private View bmN;
    private BdAsyncTask<?, ?, ?> bmv;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private Button bmL = null;
    private Button bmM = null;
    private String mFrom = null;
    private com.baidu.tbadk.coreExtra.view.a aAX = null;
    private boolean bmO = false;
    private boolean bmP = false;
    private int bmQ = -1;
    CustomMessageListener bmR = new CustomMessageListener(2001385) { // from class: com.baidu.tieba.account.NotLoginGuideActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001385 && customResponsedMessage.getData() != null) {
                NotLoginGuideActivity.this.finish();
            }
        }
    };
    private final a.InterfaceC0098a bmS = new a.InterfaceC0098a() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.2
        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void db(String str) {
            if (NotLoginGuideActivity.this.getLoadingDialog() == null || !NotLoginGuideActivity.this.getLoadingDialog().isShowing()) {
                NotLoginGuideActivity.this.showLoadingDialog(NotLoginGuideActivity.this.getPageContext().getString(d.j.sapi_logining), new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.2.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        NotLoginGuideActivity.this.destroyWaitingDialog();
                    }
                });
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void a(AccountData accountData) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_success", 0, "", new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                NotLoginGuideActivity.this.n(accountData);
            } else {
                NotLoginGuideActivity.this.i(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.a.a.InterfaceC0098a
        public void c(String str, int i, String str2) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_fail", i, str2, new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (NotLoginGuideActivity.this.bmQ == 1) {
                NotLoginGuideActivity.this.QT();
            } else if (NotLoginGuideActivity.this.bmQ == 2) {
                NotLoginGuideActivity.this.QU();
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
        registerListener(this.bmR);
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mFrom = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.mFrom = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    private void initView() {
        setContentView(d.h.not_login_guide_activity);
        this.mImage = (ImageView) findViewById(d.g.guide_bg);
        this.bmL = (Button) findViewById(d.g.guide_regist);
        this.bmM = (Button) findViewById(d.g.guide_login);
        this.bmN = findViewById(d.g.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int aj = l.aj(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((aj * 0.2631579f) - (((aj * 0.2631579f) - l.f(getPageContext().getPageActivity(), d.e.ds190)) / 2.0f)) - l.f(getPageContext().getPageActivity(), d.e.ds16));
        this.bmN.setLayoutParams(layoutParams);
        this.mBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), d.f.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.mImage.setImageBitmap(this.mBitmap);
        }
        this.bmL.setOnClickListener(this);
        this.bmM.setOnClickListener(this);
        this.bmN.setOnClickListener(this);
    }

    private void QR() {
        com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(2015001) != null) {
                sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else if (!this.bmP && !TbadkCoreApplication.getInst().getIsFirstUse() && MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.bmL) {
            this.bmQ = 2;
            QU();
        } else if (view == this.bmM) {
            this.bmQ = 1;
            if (!QS()) {
                QT();
            }
        } else if (view == this.bmN) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bmO = false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                closeActivity();
                if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.mFrom)) {
                    com.baidu.tbadk.core.e.b.h(getPageContext().getPageActivity(), 200);
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
        if (this.aAX != null) {
            this.aAX.onDestroy();
        }
        if (this.bmv != null) {
            this.bmv.cancel();
        }
    }

    private void releaseResource() {
        if (this.mImage != null) {
            this.mImage.setImageDrawable(null);
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
            QR();
        }
    }

    public boolean QS() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "login_silent_start", 0, "", new Object[0]);
            if (this.bmv != null) {
                this.bmv.cancel();
            }
            this.bmv = com.baidu.tbadk.core.a.a.tl().a(session.username, session.bduss, "", null, this.bmS);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AccountData accountData) {
        if (this.aAX == null) {
            this.aAX = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aAX.a(new a.InterfaceC0107a() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.3
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0107a
                public void g(AccountData accountData2) {
                    NotLoginGuideActivity.this.n(accountData2);
                }
            });
        }
        this.aAX.FN();
        this.aAX.setAccountData(accountData);
        this.aAX.FJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final AccountData accountData) {
        h.io().c(new Runnable() { // from class: com.baidu.tieba.account.NotLoginGuideActivity.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.tbadk.core.a.b.b(accountData);
            }
        });
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        com.baidu.tbadk.browser.a.aC(TbadkCoreApplication.getInst());
        QR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QT() {
        if (!this.bmO) {
            this.bmO = true;
            TiebaStatic.log("sapi_go_to_login_click");
            TiebaStatic.log("c10520");
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QU() {
        QT();
    }
}
