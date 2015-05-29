package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends BaseActivity<SapiFastRegActivity> {
    private SapiWebView abp;
    private boolean abu;
    private View abw;
    private TextView axR;
    private View mBack;
    private int mFrom;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.t abq = null;
    private String axQ = null;
    private final com.baidu.tbadk.core.a.b SV = new an(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(com.baidu.tieba.r.layout_sapi_webview_fastreg);
        initData(bundle);
        uX();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bq.a((View) this.abp, com.baidu.tieba.n.cp_link_tip_b, false);
        }
    }

    protected void uX() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.sapi_reg_navi);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.account_regedit));
        this.abw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.navigation_right_button_layout, (View.OnClickListener) null);
        this.axR = (TextView) this.abw.findViewById(com.baidu.tieba.q.right_textview);
        this.axR.setText(getPageContext().getString(com.baidu.tieba.t.login));
        ay.b(this.axR, com.baidu.tieba.n.navi_op_text, 1);
        this.axR.setOnClickListener(this);
        this.abp = (SapiWebView) findViewById(com.baidu.tieba.q.sapi_webview);
        com.baidu.tbadk.core.a.f.a(getPageContext().getContext(), this.abp);
        this.abp.setOnFinishCallback(new ao(this));
        this.abp.setAuthorizationListener(new ap(this));
        this.abp.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AccountData accountData) {
        if (this.abq == null) {
            this.abq = new com.baidu.tbadk.coreExtra.view.t(getPageContext());
            this.abq.a(new aq(this));
        }
        this.abq.xS();
        this.abq.k(accountData);
        this.abq.xO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fu() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.qi().a(session.username, session.bduss, session.ptoken, this.SV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(AccountData accountData) {
        com.baidu.tbadk.core.a.d.b(accountData);
        TbadkCoreApplication.setCurrentAccount(accountData, getBaseContext());
        if (this.mFrom == 4) {
            Intent intent = new Intent();
            intent.putExtra(RegisterActivityConfig.FAST_REG_USER_TYPE, this.axQ);
            setResult(-1, intent);
            finish();
            return;
        }
        vb();
        uY();
    }

    private void initData(Bundle bundle) {
        if (bundle == null) {
            this.mFrom = getIntent().getIntExtra("from", -1);
            this.abu = getIntent().getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
            return;
        }
        this.mFrom = bundle.getInt("from", -1);
        this.abu = bundle.getBoolean(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.axR) {
            if (this.mFrom == 1) {
                finish();
            } else {
                TbadkCoreApplication.m411getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), 2, true, 11038)));
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11038 && i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
    }

    private void uY() {
        int i = 1;
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.abu) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_11", "click", 1, new Object[0]);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    private void vb() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.l.ht().b(new ar(this));
        }
    }
}
