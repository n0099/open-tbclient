package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class ht5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public abstract int b();

    public abstract boolean c();

    public ht5() {
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
        this.a = da5.p().l("page_stay_duration_switch", false);
    }

    public boolean a(jt5 jt5Var) {
        InterceptResult invokeL;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jt5Var)) == null) {
            if (jt5Var != null && !jt5Var.p()) {
                if (jt5Var.a) {
                    jt5Var.x(it5.b(jt5Var.h(), 6));
                } else {
                    if (b() > kt5.b().c()) {
                        b = kt5.b().c();
                    } else {
                        b = b();
                    }
                    if (b > 5) {
                        b = 5;
                    }
                    jt5Var.x(it5.b(jt5Var.h(), b));
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
            } else if (!kt5.b().f()) {
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
            da5.p().A("page_stay_duration_switch", true);
            this.a = z;
        }
    }
}
