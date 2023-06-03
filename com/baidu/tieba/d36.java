package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d36() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(lc5 lc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, lc5Var) != null) || lc5Var == null) {
            return;
        }
        if (lc5Var.b != 0) {
            l95.m().B("app_entrance_nologin", lc5Var.b + "");
        }
        if (lc5Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            l95.m().B("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), lc5Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                s = l95.m().s("app_entrance_nologin", "");
            } else {
                l95 m = l95.m();
                s = m.s("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = tg.e(s, 0);
            if (e != 1 && e == 2) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }
}
