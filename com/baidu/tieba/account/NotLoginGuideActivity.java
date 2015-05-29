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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NewUserGuideActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    private View awY;
    private ImageView avb = null;
    private Bitmap mBitmap = null;
    private Button awW = null;
    private Button awX = null;
    private String mFrom = null;
    private com.baidu.tbadk.coreExtra.view.t abq = null;
    private boolean awZ = false;
    private int axa = -1;
    private final com.baidu.tbadk.core.a.b SV = new ac(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        com.baidu.tbadk.core.k.A(getPageContext().getContext(), "not_login_guide_page_pv");
        initData(bundle);
        initView();
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.mFrom = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
        } else {
            this.mFrom = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [109=4] */
    private void initView() {
        setContentView(com.baidu.tieba.r.not_login_guide_activity);
        this.avb = (ImageView) findViewById(com.baidu.tieba.q.guide_bg);
        this.awW = (Button) findViewById(com.baidu.tieba.q.guide_regist);
        this.awX = (Button) findViewById(com.baidu.tieba.q.guide_login);
        this.awY = findViewById(com.baidu.tieba.q.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int N = com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity());
        layoutParams.bottomMargin = (int) (((N * 0.2631579f) - (((N * 0.2631579f) - com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), com.baidu.tieba.o.ds190)) / 2.0f)) - com.baidu.adp.lib.util.n.d(getPageContext().getPageActivity(), com.baidu.tieba.o.ds16));
        this.awY.setLayoutParams(layoutParams);
        this.mBitmap = com.baidu.tbadk.core.util.c.f(getPageContext().getContext(), com.baidu.tieba.p.not_login_guide_bg);
        if (this.mBitmap != null) {
            this.avb.setImageBitmap(this.mBitmap);
        }
        this.awW.setOnClickListener(this);
        this.awX.setOnClickListener(this);
        this.awY.setOnClickListener(this);
    }

    private void Fe() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(2015001) != null) {
                sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
            } else {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else {
            if (com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.awW) {
            this.axa = 2;
            if (!Ff()) {
                Fh();
            }
        } else if (view == this.awX) {
            this.axa = 1;
            if (!Ff()) {
                Fg();
            }
        } else if (view == this.awY) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", "click", 1, new Object[0]);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.awZ = false;
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
        EO();
    }

    private void EO() {
        if (this.avb != null) {
            this.avb.setImageDrawable(null);
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
                Fe();
            } else if (i == 22002 && intent != null) {
                String stringExtra = intent.getStringExtra(RegisterActivityConfig.FAST_REG_USER_TYPE);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equals(RegisterActivityConfig.LOGIN_USER)) {
                        Fe();
                    } else if (stringExtra.equals(RegisterActivityConfig.REGIST_USER)) {
                        if (UtilHelper.isNetOk() && MessageManager.getInstance().findTask(2012116) != null) {
                            TbadkCoreApplication.m411getInst().setIsNewRegUser(true);
                            sendMessage(new CustomMessage(2012116, new NewUserGuideActivityConfig(getPageContext().getPageActivity(), true, false)));
                        } else {
                            Fe();
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

    public boolean Ff() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.qi().a(session.username, session.bduss, session.ptoken, this.SV);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AccountData accountData) {
        if (this.abq == null) {
            this.abq = new com.baidu.tbadk.coreExtra.view.t(getPageContext());
            this.abq.a(new ae(this));
        }
        this.abq.xS();
        this.abq.k(accountData);
        this.abq.xO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(AccountData accountData) {
        com.baidu.adp.lib.g.l.ht().b(new af(this, accountData));
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        com.baidu.tbadk.browser.f.U(TbadkCoreApplication.m411getInst());
        Fe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fg() {
        if (!this.awZ) {
            this.awZ = true;
            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "sapi_go_to_login_click");
            TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), (String) null, true, 11003)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh() {
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_2", "click", 1, new Object[0]);
        com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "sapi_fast_regist_click");
        sendMessage(new CustomMessage(2002001, new RegisterActivityConfig(getPageContext().getPageActivity(), 4, 22002)));
    }
}
