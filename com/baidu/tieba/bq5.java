package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class bq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bq5() {
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

    public static void b(c25 c25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, c25Var) != null) || c25Var == null) {
            return;
        }
        if (c25Var.b != 0) {
            cz4.l().z("app_entrance_nologin", c25Var.b + "");
        }
        if (c25Var.a != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
            cz4.l().z("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), c25Var.a + "");
        }
    }

    public int a() {
        InterceptResult invokeV;
        String r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                r = cz4.l().r("app_entrance_nologin", "");
            } else {
                cz4 l = cz4.l();
                r = l.r("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = yg.e(r, 0);
            if (e != 1 && e == 2) {
                return 1;
            }
            return 2;
        }
        return invokeV.intValue;
    }
}
