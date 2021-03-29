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
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.b.e.m.h;
import d.b.b.e.p.l;
import d.b.h0.r.l.a;
import d.b.h0.s.i.b;
/* loaded from: classes4.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    public static final int ACTION_LOGIN = 1;
    public static final int ACTION_REGIST = 2;
    public static final float BOTTOM_SCALE = 0.2631579f;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public View unlogin_see;
    public ImageView mImage = null;
    public Bitmap mBitmap = null;
    public Button mQuickRegistBtn = null;
    public Button mLoginBtn = null;
    public String mFrom = null;
    public d.b.h0.s.i.b mInputUserNameDialog = null;
    public boolean toLogin = false;
    public boolean firstRegist = false;
    public int currAction = -1;
    public CustomMessageListener mAccountChangeListener = new a(2001385);
    public final a.InterfaceC1082a mReLoginCallback = new b();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001385 || customResponsedMessage.getData() == null) {
                return;
            }
            NotLoginGuideActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.InterfaceC1082a {

        /* loaded from: classes4.dex */
        public class a implements DialogInterface.OnCancelListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                NotLoginGuideActivity.this.destroyWaitingDialog();
            }
        }

        public b() {
        }

        @Override // d.b.h0.r.l.a.InterfaceC1082a
        public void a(String str, int i, String str2) {
            d.b.h0.r.z.a.a("account", -1L, 0, "login_silent_fail", i, str2, new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (NotLoginGuideActivity.this.currAction == 1) {
                NotLoginGuideActivity.this.goToLogin();
            } else if (NotLoginGuideActivity.this.currAction == 2) {
                NotLoginGuideActivity.this.goToRegist();
            }
        }

        @Override // d.b.h0.r.l.a.InterfaceC1082a
        public void b(String str) {
            if (NotLoginGuideActivity.this.getLoadingDialog() == null || !NotLoginGuideActivity.this.getLoadingDialog().c()) {
                NotLoginGuideActivity notLoginGuideActivity = NotLoginGuideActivity.this;
                notLoginGuideActivity.showLoadingDialog(notLoginGuideActivity.getPageContext().getString(R.string.sapi_logining), new a());
            }
        }

        @Override // d.b.h0.r.l.a.InterfaceC1082a
        public void c(AccountData accountData) {
            d.b.h0.r.z.a.a("account", -1L, 0, "login_silent_success", 0, "", new Object[0]);
            NotLoginGuideActivity.this.closeLoadingDialog();
            if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                NotLoginGuideActivity.this.loginSuccess(accountData);
            } else {
                NotLoginGuideActivity.this.showInputDialog(accountData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.e {
        public c() {
        }

        @Override // d.b.h0.s.i.b.e
        public void a(AccountData accountData) {
            NotLoginGuideActivity.this.loginSuccess(accountData);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f14485e;

        public d(AccountData accountData) {
            this.f14485e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.r.l.c.g(this.f14485e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToLogin() {
        if (this.toLogin) {
            return;
        }
        this.toLogin = true;
        TiebaStatic.log("sapi_go_to_login_click");
        TiebaStatic.log("c10520");
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToRegist() {
        goToLogin();
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
        this.mImage = (ImageView) findViewById(R.id.guide_bg);
        this.mQuickRegistBtn = (Button) findViewById(R.id.guide_regist);
        this.mLoginBtn = (Button) findViewById(R.id.guide_login);
        this.unlogin_see = findViewById(R.id.unlogin_see);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        float i = l.i(getPageContext().getPageActivity()) * 0.2631579f;
        layoutParams.bottomMargin = (int) ((i - ((i - l.g(getPageContext().getPageActivity(), R.dimen.ds190)) / 2.0f)) - l.g(getPageContext().getPageActivity(), R.dimen.ds16));
        this.unlogin_see.setLayoutParams(layoutParams);
        Bitmap logoBitmap = BitmapHelper.getLogoBitmap(getPageContext().getPageActivity(), R.drawable.not_login_guide_bg);
        this.mBitmap = logoBitmap;
        if (logoBitmap != null) {
            this.mImage.setImageBitmap(logoBitmap);
        }
        this.mQuickRegistBtn.setOnClickListener(this);
        this.mLoginBtn.setOnClickListener(this);
        this.unlogin_see.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSuccess(AccountData accountData) {
        h.a().c(new d(accountData));
        d.b.h0.r.z.a.a("account", -1L, 0, "not_login_guide_activity", 0, "", new Object[0]);
        TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
        d.b.h0.l.a.f(TbadkCoreApplication.getInst());
        startApp();
    }

    private void releaseResource() {
        ImageView imageView = this.mImage;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.mBitmap.recycle();
        this.mBitmap = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputDialog(AccountData accountData) {
        if (this.mInputUserNameDialog == null) {
            d.b.h0.s.i.b bVar = new d.b.h0.s.i.b(this);
            this.mInputUserNameDialog = bVar;
            bVar.w(new c());
        }
        this.mInputUserNameDialog.p();
        this.mInputUserNameDialog.u(accountData);
        this.mInputUserNameDialog.y();
    }

    private void startApp() {
        d.b.h0.r.z.a.a("account", -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            if (MessageManager.getInstance().findTask(2015001) != null) {
                sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
            } else {
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
        } else if (!this.firstRegist && !TbadkCoreApplication.getInst().getIsFirstUse() && MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
        } else {
            d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
            if (i.g("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                d.b.h0.r.d0.b i2 = d.b.h0.r.d0.b.i();
                i2.s("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }

    public boolean loginByPassAccount() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            d.b.h0.r.z.a.a("account", -1L, 0, "login_silent_start", 0, "", new Object[0]);
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            this.mAccountLoginTask = d.b.h0.r.l.a.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 11003) {
            startApp();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.mQuickRegistBtn) {
            this.currAction = 2;
            goToRegist();
        } else if (view == this.mLoginBtn) {
            this.currAction = 1;
            if (loginByPassAccount()) {
                return;
            }
            goToLogin();
        } else if (view == this.unlogin_see) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "notlogin_1", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            finish();
        }
    }

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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        releaseResource();
        d.b.h0.s.i.b bVar = this.mInputUserNameDialog;
        if (bVar != null) {
            bVar.s();
        }
        BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
        if (bdAsyncTask != null) {
            bdAsyncTask.cancel();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        closeActivity();
        if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.mFrom)) {
            d.b.h0.r.a0.b.e(getPageContext().getPageActivity(), 200);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.toLogin = false;
    }
}
