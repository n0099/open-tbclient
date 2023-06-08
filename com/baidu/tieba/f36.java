package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f36() {
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

    public static void b(nc5 nc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, nc5Var) != null) || nc5Var == null) {
            return;
        }
        if (nc5Var.b != 0) {
            n95.m().B("app_entrance_nologin", nc5Var.b + "");
        }
        if (nc5Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            n95.m().B("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), nc5Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                s = n95.m().s("app_entrance_nologin", "");
            } else {
                n95 m = n95.m();
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
