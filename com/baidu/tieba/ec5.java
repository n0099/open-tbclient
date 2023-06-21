package com.baidu.tieba;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ec5 {
    public static /* synthetic */ Interceptable $ic;
    public static Domain a;
    public static boolean b;
    public static fc5 c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947729554, "Lcom/baidu/tieba/ec5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947729554, "Lcom/baidu/tieba/ec5;");
                return;
            }
        }
        a = Domain.DOMAIN_ONLINE;
        b = true;
        c = null;
    }

    public static fc5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return (fc5) invokeV.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (TbConfig.USE_OLD_LOGIN) {
                b = true;
                return;
            }
            if (Build.VERSION.SDK_INT < 9) {
                if (TbadkCoreApplication.getInst().isLowVersionPassV6ShouldOpen()) {
                    b = false;
                } else {
                    b = true;
                }
            } else if (TbadkCoreApplication.getInst().isPassportV6ShouldOpen()) {
                b = false;
            } else {
                b = true;
            }
            if (Build.VERSION.SDK_INT <= 10 && !b && UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.getInst().getContext())) {
                TbadkCoreApplication.getInst().incPassportV6CrashCount();
                b = true;
            }
        }
    }

    public static void c() {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && c == null && (runTask = MessageManager.getInstance().runTask(2001268, fc5.class)) != null && runTask.getData() != null) {
            c = (fc5) runTask.getData();
        }
    }
}
