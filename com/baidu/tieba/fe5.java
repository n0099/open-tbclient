package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fe5 {
    public static /* synthetic */ Interceptable $ic;
    public static fe5 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947761267, "Lcom/baidu/tieba/fe5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947761267, "Lcom/baidu/tieba/fe5;");
        }
    }

    public fe5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized fe5 c() {
        InterceptResult invokeV;
        fe5 fe5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (fe5.class) {
                if (a == null) {
                    a = new fe5();
                }
                fe5Var = a;
            }
            return fe5Var;
        }
        return (fe5) invokeV.objValue;
    }

    public void a(PayConfig payConfig, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, payConfig, context) == null) {
            if (payConfig != null && context != null) {
                if (!d()) {
                    e(R.string.obfuscated_res_0x7f0f0efb);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PayWalletActivityConfig(context, payConfig)));
                return;
            }
            e(R.string.obfuscated_res_0x7f0f0efa);
        }
    }

    public void b(String str, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TbadkCoreApplication.getInst().appResponseToCmd(2001351) || !TbadkCoreApplication.getInst().isWalletShouldOpen() || Build.VERSION.SDK_INT < 8) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            xi.O(TbadkCoreApplication.getInst().getContext(), i);
        }
    }
}
