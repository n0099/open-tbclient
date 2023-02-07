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
public final class a74 implements kq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Integer> a;

    public a74() {
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

    @Override // com.baidu.tieba.kq1
    public void a(d12 d12Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, d12Var) == null) && d12Var != null) {
            d(d12Var.B("action"), d12Var.B("menuItemName"));
        }
    }

    @Override // com.baidu.tieba.kq1
    public void b(df4 df4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, df4Var) != null) || this.a.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.a.iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (df4Var != null) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                df4Var.l(id.intValue());
            }
        }
    }

    public final boolean c(df4 df4Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, df4Var, str)) == null) {
            Integer a = b74.a(str);
            if (a != null) {
                if (!this.a.contains(a)) {
                    this.a.add(a);
                }
                if (df4Var != null) {
                    df4Var.l(a.intValue());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2) {
        InterceptResult invokeLL;
        t44 t44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (str != null && str.hashCode() == 3202370 && str.equals("hide")) {
                ju2 U = ju2.U();
                Intrinsics.checkNotNullExpressionValue(U, "SwanAppController.getInstance()");
                f82 V = U.V();
                df4 df4Var = null;
                if (V != null) {
                    t44Var = (t44) V.n(t44.class);
                } else {
                    t44Var = null;
                }
                if (t44Var != null) {
                    df4Var = t44Var.x3();
                }
                if (df4Var != null && t44Var != null) {
                    t44Var.J3(true);
                }
                return c(df4Var, str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
