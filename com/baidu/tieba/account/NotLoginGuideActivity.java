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
import c.a.e.e.m.h;
import c.a.e.e.p.l;
import c.a.q0.s.l.a;
import c.a.q0.t.i.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NotLoginGuideActivity extends BaseActivity<NotLoginGuideActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTION_LOGIN = 1;
    public static final int ACTION_REGIST = 2;
    public static final float BOTTOM_SCALE = 0.2631579f;
    public transient /* synthetic */ FieldHolder $fh;
    public int currAction;
    public boolean firstRegist;
    public CustomMessageListener mAccountChangeListener;
    public BdAsyncTask<?, ?, ?> mAccountLoginTask;
    public Bitmap mBitmap;
    public String mFrom;
    public ImageView mImage;
    public c.a.q0.t.i.b mInputUserNameDialog;
    public Button mLoginBtn;
    public Button mQuickRegistBtn;
    public final a.InterfaceC0687a mReLoginCallback;
    public boolean toLogin;
    public View unlogin_see;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NotLoginGuideActivity f49230a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NotLoginGuideActivity notLoginGuideActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {notLoginGuideActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49230a = notLoginGuideActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001385 || customResponsedMessage.getData() == null) {
                return;
            }
            this.f49230a.finish();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.InterfaceC0687a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NotLoginGuideActivity f49231a;

        /* loaded from: classes6.dex */
        public class a implements DialogInterface.OnCancelListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f49232e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49232e = bVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                    this.f49232e.f49231a.destroyWaitingDialog();
                }
            }
        }

        public b(NotLoginGuideActivity notLoginGuideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {notLoginGuideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49231a = notLoginGuideActivity;
        }

        @Override // c.a.q0.s.l.a.InterfaceC0687a
        public void a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
                c.a.q0.s.z.a.a("account", -1L, 0, "login_silent_fail", i2, str2, new Object[0]);
                this.f49231a.closeLoadingDialog();
                if (this.f49231a.currAction == 1) {
                    this.f49231a.goToLogin();
                } else if (this.f49231a.currAction == 2) {
                    this.f49231a.goToRegist();
                }
            }
        }

        @Override // c.a.q0.s.l.a.InterfaceC0687a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.f49231a.getLoadingDialog() == null || !this.f49231a.getLoadingDialog().c()) {
                    NotLoginGuideActivity notLoginGuideActivity = this.f49231a;
                    notLoginGuideActivity.showLoadingDialog(notLoginGuideActivity.getPageContext().getString(R.string.sapi_logining), new a(this));
                }
            }
        }

        @Override // c.a.q0.s.l.a.InterfaceC0687a
        public void c(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                c.a.q0.s.z.a.a("account", -1L, 0, "login_silent_success", 0, "", new Object[0]);
                this.f49231a.closeLoadingDialog();
                if (!TbadkCoreApplication.getInst().shouldNeedCheckUserNameDialog() || !TextUtils.isEmpty(accountData.getAccount())) {
                    this.f49231a.loginSuccess(accountData);
                } else {
                    this.f49231a.showInputDialog(accountData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NotLoginGuideActivity f49233a;

        public c(NotLoginGuideActivity notLoginGuideActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {notLoginGuideActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49233a = notLoginGuideActivity;
        }

        @Override // c.a.q0.t.i.b.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) {
                this.f49233a.loginSuccess(accountData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AccountData f49234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NotLoginGuideActivity f49235f;

        public d(NotLoginGuideActivity notLoginGuideActivity, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {notLoginGuideActivity, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49235f = notLoginGuideActivity;
            this.f49234e = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.s.l.c.g(this.f49234e);
            }
        }
    }

    public NotLoginGuideActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImage = null;
        this.mBitmap = null;
        this.mQuickRegistBtn = null;
        this.mLoginBtn = null;
        this.mFrom = null;
        this.mInputUserNameDialog = null;
        this.toLogin = false;
        this.firstRegist = false;
        this.currAction = -1;
        this.mAccountChangeListener = new a(this, 2001385);
        this.mReLoginCallback = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToLogin() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.toLogin) {
            return;
        }
        this.toLogin = true;
        TiebaStatic.log("sapi_go_to_login_click");
        TiebaStatic.log("c10520");
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToRegist() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            goToLogin();
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, bundle) == null) {
            if (bundle != null) {
                this.mFrom = bundle.getString(NotLoginGuideActivityConfig.FROM_PAGE);
            } else {
                this.mFrom = getIntent().getStringExtra(NotLoginGuideActivityConfig.FROM_PAGE);
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            setContentView(R.layout.not_login_guide_activity);
            this.mImage = (ImageView) findViewById(R.id.guide_bg);
            this.mQuickRegistBtn = (Button) findViewById(R.id.guide_regist);
            this.mLoginBtn = (Button) findViewById(R.id.guide_login);
            this.unlogin_see = findViewById(R.id.unlogin_see);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            float i2 = l.i(getPageContext().getPageActivity()) * 0.2631579f;
            layoutParams.bottomMargin = (int) ((i2 - ((i2 - l.g(getPageContext().getPageActivity(), R.dimen.ds190)) / 2.0f)) - l.g(getPageContext().getPageActivity(), R.dimen.ds16));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSuccess(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, accountData) == null) {
            h.a().c(new d(this, accountData));
            c.a.q0.s.z.a.a("account", -1L, 0, "not_login_guide_activity", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, getPageContext().getPageActivity());
            c.a.q0.m.a.f(TbadkCoreApplication.getInst());
            startApp();
        }
    }

    private void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputDialog(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, accountData) == null) {
            if (this.mInputUserNameDialog == null) {
                c.a.q0.t.i.b bVar = new c.a.q0.t.i.b(this);
                this.mInputUserNameDialog = bVar;
                bVar.w(new c(this));
            }
            this.mInputUserNameDialog.p();
            this.mInputUserNameDialog.u(accountData);
            this.mInputUserNameDialog.y();
        }
    }

    private void startApp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            c.a.q0.s.z.a.a("account", -1L, 0, "login_silent_startapp", 0, "", new Object[0]);
            if (TbadkCoreApplication.getInst().getIsFirstUse()) {
                if (MessageManager.getInstance().findTask(2015001) != null) {
                    sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, false)));
                } else {
                    sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
            } else if (!this.firstRegist && !TbadkCoreApplication.getInst().getIsFirstUse() && MessageManager.getInstance().findTask(2015001) != null) {
                sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, true)));
            } else {
                c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
                if (j2.g("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                    c.a.q0.s.d0.b j3 = c.a.q0.s.d0.b.j();
                    j3.t("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
                }
                sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
            }
            finish();
        }
    }

    public boolean loginByPassAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                c.a.q0.s.z.a.a("account", -1L, 0, "login_silent_start", 0, "", new Object[0]);
                BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
                if (bdAsyncTask != null) {
                    bdAsyncTask.cancel();
                }
                this.mAccountLoginTask = c.a.q0.s.l.a.b().a(session.username, session.bduss, "", null, this.mReLoginCallback);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 11003) {
                startApp();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            UtilHelper.commenDealIntent(getPageContext().getPageActivity(), TbadkCoreApplication.getIntent());
            TbadkCoreApplication.setIntent(null);
            TiebaStatic.log("not_login_guide_page_pv");
            initData(bundle);
            initView();
            registerListener(this.mAccountChangeListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            releaseResource();
            c.a.q0.t.i.b bVar = this.mInputUserNameDialog;
            if (bVar != null) {
                bVar.s();
            }
            BdAsyncTask<?, ?, ?> bdAsyncTask = this.mAccountLoginTask;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 != 4) {
                return super.onKeyDown(i2, keyEvent);
            }
            closeActivity();
            if (NotLoginGuideActivityConfig.FROM_ACCOUNT.equals(this.mFrom)) {
                c.a.q0.s.a0.b.e(getPageContext().getPageActivity(), 200);
                return true;
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            this.toLogin = false;
        }
    }
}
