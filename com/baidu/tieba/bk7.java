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
public final class bk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ab7<?>> a;
    public fk7 b;
    public ek7 c;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof bk7) {
                bk7 bk7Var = (bk7) obj;
                return Intrinsics.areEqual(this.a, bk7Var.a) && Intrinsics.areEqual(this.b, bk7Var.b) && Intrinsics.areEqual(this.c, bk7Var.c);
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
            fk7 fk7Var = this.b;
            int hashCode2 = (hashCode + (fk7Var == null ? 0 : fk7Var.hashCode())) * 31;
            ek7 ek7Var = this.c;
            return hashCode2 + (ek7Var != null ? ek7Var.hashCode() : 0);
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

    public bk7(List<ab7<?>> feedList, fk7 fk7Var, ek7 ek7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedList, fk7Var, ek7Var};
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
        this.b = fk7Var;
        this.c = ek7Var;
    }

    public /* synthetic */ bk7(List list, fk7 fk7Var, ek7 ek7Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : fk7Var, (i & 4) != 0 ? null : ek7Var);
    }

    public final List<ab7<?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final ek7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (ek7) invokeV.objValue;
    }

    public final fk7 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (fk7) invokeV.objValue;
    }

    public final void d(ek7 ek7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ek7Var) == null) {
            this.c = ek7Var;
        }
    }

    public final void e(fk7 fk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fk7Var) == null) {
            this.b = fk7Var;
        }
    }
}
