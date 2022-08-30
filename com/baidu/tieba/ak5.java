package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ak5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ak5() {
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

    public static void b(vx4 vx4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, vx4Var) == null) || vx4Var == null) {
            return;
        }
        if (vx4Var.b != 0) {
            tu4.k().y("app_entrance_nologin", vx4Var.b + "");
        }
        if (vx4Var.a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        tu4.k().y("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), vx4Var.a + "");
    }

    public int a() {
        InterceptResult invokeV;
        String q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                q = tu4.k().q("app_entrance_nologin", "");
            } else {
                tu4 k = tu4.k();
                q = k.q("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int e = pg.e(q, 0);
            return (e != 1 && e == 2) ? 1 : 2;
        }
        return invokeV.intValue;
    }
}
