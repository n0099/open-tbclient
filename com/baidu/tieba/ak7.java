package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ak7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<za7<?>> a;
    public ek7 b;
    public dk7 c;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ak7) {
                ak7 ak7Var = (ak7) obj;
                return Intrinsics.areEqual(this.a, ak7Var.a) && Intrinsics.areEqual(this.b, ak7Var.b) && Intrinsics.areEqual(this.c, ak7Var.c);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            ek7 ek7Var = this.b;
            int hashCode2 = (hashCode + (ek7Var == null ? 0 : ek7Var.hashCode())) * 31;
            dk7 dk7Var = this.c;
            return hashCode2 + (dk7Var != null ? dk7Var.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "ModelData(feedList=" + this.a + ", subTabData=" + this.b + ", sortTabData=" + this.c + ')';
        }
        return (String) invokeV.objValue;
    }

    public ak7(List<za7<?>> feedList, ek7 ek7Var, dk7 dk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedList, ek7Var, dk7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        this.a = feedList;
        this.b = ek7Var;
        this.c = dk7Var;
    }

    public /* synthetic */ ak7(List list, ek7 ek7Var, dk7 dk7Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : ek7Var, (i & 4) != 0 ? null : dk7Var);
    }

    public final List<za7<?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final dk7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (dk7) invokeV.objValue;
    }

    public final ek7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (ek7) invokeV.objValue;
    }

    public final void d(dk7 dk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dk7Var) == null) {
            this.c = dk7Var;
        }
    }

    public final void e(ek7 ek7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ek7Var) == null) {
            this.b = ek7Var;
        }
    }
}
