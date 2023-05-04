package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class gm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public abstract int b();

    public abstract boolean c();

    public gm5() {
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
        this.a = f55.m().i("page_stay_duration_switch", false);
    }

    public boolean a(im5 im5Var) {
        InterceptResult invokeL;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, im5Var)) == null) {
            if (im5Var != null && !im5Var.p()) {
                if (im5Var.a) {
                    im5Var.x(hm5.b(im5Var.h(), 6));
                } else {
                    if (b() > jm5.b().c()) {
                        b = jm5.b().c();
                    } else {
                        b = b();
                    }
                    if (b > 5) {
                        b = 5;
                    }
                    im5Var.x(hm5.b(im5Var.h(), b));
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
            } else if (!jm5.b().f()) {
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
            f55.m().w("page_stay_duration_switch", true);
            this.a = z;
        }
    }
}
