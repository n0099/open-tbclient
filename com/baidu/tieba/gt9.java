package com.baidu.tieba;

import android.content.Intent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountStorage;
import com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class gt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BaseActivity b;
    public ht9 c;
    public BdAsyncTask<?, ?, ?> d;
    public it9 e;
    public String f;
    public View.OnClickListener g;
    public final AccountLoginCoreHelper.IReLoginCallback h;

    public abstract void j(it9 it9Var);

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt9 a;

        public a(gt9 gt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;
        public final /* synthetic */ gt9 b;

        public b(gt9 gt9Var, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt9Var, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gt9Var;
            this.a = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.b.l();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.b.b.closeLoadingDialog();
                BaseActivity baseActivity = this.b.b;
                baseActivity.showToast(String.format(baseActivity.getString(R.string.obfuscated_res_0x7f0f168f), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.b.f();
                DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), this.b.f, this.a.name().toLowerCase());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AccountLoginCoreHelper.IReLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gt9 a;

        public c(gt9 gt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gt9Var;
        }

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onBeforeLogin(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.l();
            }
        }

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onSuccess(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
                this.a.b.closeLoadingDialog();
                this.a.e(accountData);
            }
        }

        @Override // com.baidu.tbadk.core.account.helper.AccountLoginCoreHelper.IReLoginCallback
        public void onFailure(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i, str2) == null) {
                this.a.b.closeLoadingDialog();
                this.a.b.showToast(str2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountData a;

        public d(gt9 gt9Var, AccountData accountData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gt9Var, accountData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AccountStorage.saveAccountData(this.a);
                Logger.addLog("account", -1L, 0, "login_activity_save_account_to_db", 0, "", new Object[0]);
            }
        }
    }

    public gt9(TbPageContext tbPageContext, ht9 ht9Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ht9Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.h = new c(this);
        this.a = tbPageContext;
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            this.b = (BaseActivity) tbPageContext.getPageActivity();
        }
        this.c = ht9Var;
        this.f = str;
        ht9Var.d(this.g);
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.b.setResult(i, new Intent());
            this.b.finish();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.c.b(z);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.c.e(z);
        }
    }

    public final void m(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new b(this, socialType), socialType);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new LoginActivityConfig(this.b, true, 25061).start();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            m(SocialType.QQ_SSO);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m(SocialType.WEIXIN);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            m(SocialType.SINA_WEIBO_SSO);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            m(SocialType.YY);
        }
    }

    public final void e(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            h(accountData);
            Logger.addLog("account", -1L, 0, "login_pass_cslogin_goMainTab", 0, "", new Object[0]);
            TbadkCoreApplication.getInst().onUserChanged(this.b.getIntent());
            c(-1);
            TbadkCoreApplication.getInst().onDeviceFirstLoginChanged(accountData);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(Boolean.TRUE));
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (session != null) {
                BdAsyncTask<?, ?, ?> bdAsyncTask = this.d;
                if (bdAsyncTask != null) {
                    bdAsyncTask.cancel();
                }
                this.d = AccountLoginCoreHelper.getInstance().asyncReLogin(session.username, session.bduss, "", null, this.h);
                return;
            }
            this.b.closeLoadingDialog();
            c(0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.b.getLoadingDialog() != null && this.b.getLoadingDialog().isShowing()) {
                return;
            }
            this.b.showLoadingDialog(this.a.getString(R.string.sapi_logining));
            if (this.b.getLoadingDialog() != null) {
                this.b.getLoadingDialog().setCancelable(false);
                this.b.getLoadingDialog().setCanceledOnTouchOutside(false);
            }
        }
    }

    public final void h(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, accountData) == null) {
            zb.a().c(new d(this, accountData));
            Logger.addLog("account", -1L, 0, "login_activity_save_account_to_application", 0, "", new Object[0]);
            TbadkCoreApplication.setCurrentAccount(accountData, this.a.getPageActivity());
            BrowserHelper.initCookie(TbadkCoreApplication.getInst());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921024, Boolean.TRUE));
        }
    }

    public void n(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f0904f4) {
                this.b.finish();
            } else if (view2.getId() == R.id.btn_skip) {
                this.b.finish();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091ed4) {
                g();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092b11) {
                o();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092b14) {
                p();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092b8f) {
                q();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091872) {
                d();
            }
        }
    }
}
