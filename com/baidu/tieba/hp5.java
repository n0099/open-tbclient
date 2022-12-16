package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public hp5() {
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

    public static void b(r15 r15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, r15Var) != null) || r15Var == null) {
            return;
        }
        if (r15Var.b != 0) {
            ry4.l().z("app_entrance_nologin", r15Var.b + "");
        }
        if (r15Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            ry4.l().z("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), r15Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                r = ry4.l().r("app_entrance_nologin", "");
            } else {
                ry4 l = ry4.l();
                r = l.r("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = xg.e(r, 0);
            if (e != 1 && e == 2) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }
}
