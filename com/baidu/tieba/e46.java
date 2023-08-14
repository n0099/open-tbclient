package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.account.safeManage.AccountSafeModel;
import com.baidu.tieba.setting.im.more.ResponsedPrivacyHttpMessage;
import com.baidu.tieba.setting.im.more.ResponsedPrivacySocketMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e46 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String e;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseActivity a;
    public f46 b;
    public AccountSafeModel c;
    public NetMessageListener d;

    /* loaded from: classes5.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e46 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e46 e46Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e46Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e46Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (this.a.c != null) {
                    this.a.c.U(false);
                }
                this.a.a.closeLoadingDialog();
                if (responsedMessage == null) {
                    return;
                }
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    l2a l2aVar = null;
                    if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                        l2aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                    }
                    if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                        l2aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                    }
                    if (this.a.c != null) {
                        this.a.c.T(l2aVar);
                    }
                    if (this.a.b != null && this.a.c != null && this.a.c.O() != null) {
                        this.a.b.d(this.a.c.O().f());
                        return;
                    }
                    return;
                }
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.a.a.getString(R.string.obfuscated_res_0x7f0f0e21);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                this.a.a.showToast(errorString);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684418, "Lcom/baidu/tieba/e46;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684418, "Lcom/baidu/tieba/e46;");
                return;
            }
        }
        e = TbConfig.TIEBA_ADDRESS + "mo/q/accountSecurity/accountOption";
    }

    public e46(BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
        this.d = aVar;
        this.a = baseActivity;
        baseActivity.registerListener(aVar);
        this.b = new f46(this.a, this);
        this.c = new AccountSafeModel(this.a);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            g();
        } else {
            this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090359) {
                TiebaStatic.log("c10013");
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                } else {
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{e});
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090068) {
                AccountSafeModel accountSafeModel = this.c;
                if (accountSafeModel != null) {
                    str = accountSafeModel.getJumpUrl();
                } else {
                    str = "";
                }
                AntiHelper.p(this.a, str);
            }
        }
    }

    public void e(int i) {
        f46 f46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (f46Var = this.b) != null) {
            f46Var.e(i);
        }
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.a();
        }
        return (View) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.closeLoadingDialog();
            AccountSafeModel accountSafeModel = this.c;
            if (accountSafeModel != null) {
                accountSafeModel.cancelLoadData();
            }
            f46 f46Var = this.b;
            if (f46Var != null) {
                f46Var.c();
            }
        }
    }

    public final void g() {
        AccountSafeModel accountSafeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (accountSafeModel = this.c) != null && !accountSafeModel.Q()) {
            this.c.S();
        }
    }
}
