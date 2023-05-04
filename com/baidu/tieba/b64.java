package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b64 implements lp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public b64() {
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
        this.a = new ArrayList<>();
    }

    @Override // com.baidu.tieba.lp1
    public void a(e02 e02Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, e02Var) == null) && e02Var != null) {
            d(e02Var.B("action"), e02Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.lp1
    public void b(ee4 ee4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ee4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (ee4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                ee4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(ee4 ee4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ee4Var, str)) == null) {
            Integer a = c64.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (ee4Var != null) {
                    ee4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        u34 u34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                kt2 U = kt2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                g72 V = U.V();
                ee4 ee4Var = null;
                if (V != null) {
                    u34Var = (u34) V.n(u34.class);
                } else {
                    u34Var = null;
                }
                if (u34Var != null) {
                    ee4Var = u34Var.A3();
                }
                if (ee4Var != null && u34Var != null) {
                    u34Var.M3(true);
                }
                return c(ee4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
