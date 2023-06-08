package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i75 {
    public static /* synthetic */ Interceptable $ic;
    public static final i75 a;
    @JvmField
    public static final n95 b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947806434, "Lcom/baidu/tieba/i75;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947806434, "Lcom/baidu/tieba/i75;");
                return;
            }
        }
        a = new i75();
        n95 a2 = w65.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getKvCache()");
        b = a2;
    }

    public i75() {
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

    public final String a(String dialogName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dialogName)) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            return n95.q("KEY_FREQUENCE_DIALOG_STRATEGY_COUNTER") + '_' + dialogName;
        }
        return (String) invokeL.objValue;
    }

    public final void c(String dialogName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogName) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            String a2 = a(dialogName);
            n95 n95Var = b;
            n95Var.z(a2, n95Var.n(a2, 0) + 1);
        }
    }

    public final void b(String dialogName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogName) == null) {
            Intrinsics.checkNotNullParameter(dialogName, "dialogName");
            zq8 yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.c("YunDialogManager", "重置弹窗 " + dialogName + " 的本地频次记录");
            b.z(a(dialogName), 0);
        }
    }
}
