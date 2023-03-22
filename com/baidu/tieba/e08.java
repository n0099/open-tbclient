package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public abstract class e08<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k08<T> a;
    public Function2<? super View, ? super k08<T>, Unit> b;

    public e08(k08<T> data) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }

    public boolean e(e08<?> other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (this.a.e().c() != 2 && other.a.e().c() != 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final k08<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (k08) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super com.baidu.tieba.k08<T>, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, com.baidu.tieba.k08<T>, kotlin.Unit> */
    public final Function2<View, k08<T>, Unit> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (Function2<? super View, ? super k08<T>, Unit>) this.b;
        }
        return (Function2) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return Objects.hashCode(this.a);
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        e08 e08Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            k08<T> k08Var = null;
            if (obj instanceof e08) {
                e08Var = (e08) obj;
            } else {
                e08Var = null;
            }
            k08<T> k08Var2 = this.a;
            if (e08Var != null) {
                k08Var = e08Var.a;
            }
            return Objects.equals(k08Var2, k08Var);
        }
        return invokeL.booleanValue;
    }

    public final void f(Function2<? super View, ? super k08<T>, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, function2) == null) {
            this.b = function2;
        }
    }
}
