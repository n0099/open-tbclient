package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class ic5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public ic5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bx4.k().h("page_stay_duration_switch", false);
    }

    public boolean a(kc5 kc5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, kc5Var)) == null) {
            if (kc5Var == null || kc5Var.p()) {
                return false;
            }
            if (kc5Var.a) {
                kc5Var.x(jc5.b(kc5Var.h(), 6));
            } else {
                int c = b() > lc5.b().c() ? lc5.b().c() : b();
                if (c > 5) {
                    c = 5;
                }
                kc5Var.x(jc5.b(kc5Var.h(), c));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public abstract int b();

    public abstract boolean c();

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return this.a;
            }
            if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
                e(false);
                return false;
            } else if (!lc5.b().f()) {
                e(false);
                return false;
            } else {
                e(true);
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || this.a == z) {
            return;
        }
        bx4.k().u("page_stay_duration_switch", true);
        this.a = z;
    }
}
