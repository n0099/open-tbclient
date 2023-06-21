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
/* loaded from: classes5.dex */
public final class da4 implements nt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public da4() {
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

    @Override // com.baidu.tieba.nt1
    public void a(g42 g42Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, g42Var) == null) && g42Var != null) {
            d(g42Var.B("action"), g42Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.nt1
    public void b(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gi4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (gi4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                gi4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(gi4 gi4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gi4Var, str)) == null) {
            Integer a = ea4.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (gi4Var != null) {
                    gi4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        w74 w74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                mx2 T2 = mx2.T();
                Intrinsics.checkNotNullExpressionValue(T2, "SwanAppController.getInstance()");
                ib2 U = T2.U();
                gi4 gi4Var = null;
                if (U != null) {
                    w74Var = (w74) U.n(w74.class);
                } else {
                    w74Var = null;
                }
                if (w74Var != null) {
                    gi4Var = w74Var.z3();
                }
                if (gi4Var != null && w74Var != null) {
                    w74Var.L3(true);
                }
                return c(gi4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
