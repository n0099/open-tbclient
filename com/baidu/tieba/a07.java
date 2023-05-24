package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b07 a;
    public final List<e07> b;
    public final List<e07> c;
    public final VirtualImageCustomState d;
    public final z07 e;
    public final z07 f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a07) {
                a07 a07Var = (a07) obj;
                return Intrinsics.areEqual(this.a, a07Var.a) && Intrinsics.areEqual(this.b, a07Var.b) && Intrinsics.areEqual(this.c, a07Var.c) && Intrinsics.areEqual(this.d, a07Var.d) && Intrinsics.areEqual(this.e, a07Var.e) && Intrinsics.areEqual(this.f, a07Var.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            VirtualImageCustomState virtualImageCustomState = this.d;
            int hashCode2 = (hashCode + (virtualImageCustomState == null ? 0 : virtualImageCustomState.hashCode())) * 31;
            z07 z07Var = this.e;
            int hashCode3 = (hashCode2 + (z07Var == null ? 0 : z07Var.hashCode())) * 31;
            z07 z07Var2 = this.f;
            return hashCode3 + (z07Var2 != null ? z07Var2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "CardVirtualHeadData(imageData=" + this.a + ", mainData=" + this.b + ", extraData=" + this.c + ", stateData=" + this.d + ", showStatData=" + this.e + ", clickStatData=" + this.f + ')';
        }
        return (String) invokeV.objValue;
    }

    public a07(b07 imageData, List<? extends e07> mainData, List<? extends e07> extraData, VirtualImageCustomState virtualImageCustomState, z07 z07Var, z07 z07Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageData, mainData, extraData, virtualImageCustomState, z07Var, z07Var2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(imageData, "imageData");
        Intrinsics.checkNotNullParameter(mainData, "mainData");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        this.a = imageData;
        this.b = mainData;
        this.c = extraData;
        this.d = virtualImageCustomState;
        this.e = z07Var;
        this.f = z07Var2;
    }

    public final z07 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (z07) invokeV.objValue;
    }

    public final List<e07> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final b07 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (b07) invokeV.objValue;
    }

    public final List<e07> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final z07 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (z07) invokeV.objValue;
    }

    public final VirtualImageCustomState f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }
}
