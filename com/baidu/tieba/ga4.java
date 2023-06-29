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
public final class ga4 implements qt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public ga4() {
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

    @Override // com.baidu.tieba.qt1
    public void a(j42 j42Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, j42Var) == null) && j42Var != null) {
            d(j42Var.B("action"), j42Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.qt1
    public void b(ji4 ji4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ji4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (ji4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                ji4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(ji4 ji4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ji4Var, str)) == null) {
            Integer a = ha4.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (ji4Var != null) {
                    ji4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        z74 z74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                px2 T2 = px2.T();
                Intrinsics.checkNotNullExpressionValue(T2, "SwanAppController.getInstance()");
                lb2 U = T2.U();
                ji4 ji4Var = null;
                if (U != null) {
                    z74Var = (z74) U.n(z74.class);
                } else {
                    z74Var = null;
                }
                if (z74Var != null) {
                    ji4Var = z74Var.z3();
                }
                if (ji4Var != null && z74Var != null) {
                    z74Var.L3(true);
                }
                return c(ji4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
