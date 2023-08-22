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
/* loaded from: classes6.dex */
public final class h94 implements rs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public h94() {
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

    @Override // com.baidu.tieba.rs1
    public void a(k32 k32Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, k32Var) == null) && k32Var != null) {
            d(k32Var.B("action"), k32Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.rs1
    public void b(kh4 kh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (kh4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                kh4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(kh4 kh4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, kh4Var, str)) == null) {
            Integer a = i94.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (kh4Var != null) {
                    kh4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        a74 a74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                qw2 T2 = qw2.T();
                Intrinsics.checkNotNullExpressionValue(T2, "SwanAppController.getInstance()");
                ma2 U = T2.U();
                kh4 kh4Var = null;
                if (U != null) {
                    a74Var = (a74) U.n(a74.class);
                } else {
                    a74Var = null;
                }
                if (a74Var != null) {
                    kh4Var = a74Var.z3();
                }
                if (kh4Var != null && a74Var != null) {
                    a74Var.L3(true);
                }
                return c(kh4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
