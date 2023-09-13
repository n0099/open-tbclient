package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i77 extends o77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hq6 d;
    public final w97 e;
    public final w97 f;
    public final w97 g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947806496, "Lcom/baidu/tieba/i77;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947806496, "Lcom/baidu/tieba/i77;");
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i77) {
                i77 i77Var = (i77) obj;
                return Intrinsics.areEqual(this.d, i77Var.d) && Intrinsics.areEqual(this.e, i77Var.e) && Intrinsics.areEqual(this.f, i77Var.f) && Intrinsics.areEqual(this.g, i77Var.g);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int hashCode = this.d.hashCode() * 31;
            w97 w97Var = this.e;
            int hashCode2 = (hashCode + (w97Var == null ? 0 : w97Var.hashCode())) * 31;
            w97 w97Var2 = this.f;
            int hashCode3 = (hashCode2 + (w97Var2 == null ? 0 : w97Var2.hashCode())) * 31;
            w97 w97Var3 = this.g;
            return hashCode3 + (w97Var3 != null ? w97Var3.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "CardPeiWanUiState(peiWanData=" + this.d + ", cardClickStat=" + this.e + ", voiceClickStat=" + this.f + ", cardShow=" + this.g + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i77(hq6 peiWanData, w97 w97Var, w97 w97Var2, w97 w97Var3) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {peiWanData, w97Var, w97Var2, w97Var3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Function2) objArr2[0], (Function1) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(peiWanData, "peiWanData");
        this.d = peiWanData;
        this.e = w97Var;
        this.f = w97Var2;
        this.g = w97Var3;
    }

    public final w97 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (w97) invokeV.objValue;
    }

    public final w97 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (w97) invokeV.objValue;
    }

    public final hq6 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (hq6) invokeV.objValue;
    }

    public final w97 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (w97) invokeV.objValue;
    }
}
