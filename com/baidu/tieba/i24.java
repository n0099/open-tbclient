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
/* loaded from: classes4.dex */
public final class i24 implements sl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public i24() {
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

    @Override // com.baidu.tieba.sl1
    public void a(lw1 lw1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, lw1Var) == null) && lw1Var != null) {
            d(lw1Var.B("action"), lw1Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.sl1
    public void b(la4 la4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, la4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (la4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                la4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(la4 la4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, la4Var, str)) == null) {
            Integer a = j24.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (la4Var != null) {
                    la4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        b04 b04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                rp2 U = rp2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                n32 V = U.V();
                la4 la4Var = null;
                if (V != null) {
                    b04Var = (b04) V.n(b04.class);
                } else {
                    b04Var = null;
                }
                if (b04Var != null) {
                    la4Var = b04Var.x3();
                }
                if (la4Var != null && b04Var != null) {
                    b04Var.J3(true);
                }
                return c(la4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
