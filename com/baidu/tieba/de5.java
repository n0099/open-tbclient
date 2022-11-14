package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class de5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public abstract int b();

    public abstract boolean c();

    public de5() {
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
        this.a = py4.k().h("page_stay_duration_switch", false);
    }

    public boolean a(fe5 fe5Var) {
        InterceptResult invokeL;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fe5Var)) == null) {
            if (fe5Var != null && !fe5Var.p()) {
                if (fe5Var.a) {
                    fe5Var.x(ee5.b(fe5Var.h(), 6));
                } else {
                    if (b() > ge5.b().c()) {
                        b = ge5.b().c();
                    } else {
                        b = b();
                    }
                    if (b > 5) {
                        b = 5;
                    }
                    fe5Var.x(ee5.b(fe5Var.h(), b));
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

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
            } else if (!ge5.b().f()) {
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
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.a != z) {
            py4.k().u("page_stay_duration_switch", true);
            this.a = z;
        }
    }
}
