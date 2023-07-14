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
/* loaded from: classes6.dex */
public final class i87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j87 a;
    public final List<n87> b;
    public final List<n87> c;
    public final VirtualImageCustomState d;
    public final u97 e;
    public final u97 f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i87) {
                i87 i87Var = (i87) obj;
                return Intrinsics.areEqual(this.a, i87Var.a) && Intrinsics.areEqual(this.b, i87Var.b) && Intrinsics.areEqual(this.c, i87Var.c) && Intrinsics.areEqual(this.d, i87Var.d) && Intrinsics.areEqual(this.e, i87Var.e) && Intrinsics.areEqual(this.f, i87Var.f);
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
            u97 u97Var = this.e;
            int hashCode3 = (hashCode2 + (u97Var == null ? 0 : u97Var.hashCode())) * 31;
            u97 u97Var2 = this.f;
            return hashCode3 + (u97Var2 != null ? u97Var2.hashCode() : 0);
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

    public i87(j87 imageData, List<? extends n87> mainData, List<? extends n87> extraData, VirtualImageCustomState virtualImageCustomState, u97 u97Var, u97 u97Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageData, mainData, extraData, virtualImageCustomState, u97Var, u97Var2};
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
        this.e = u97Var;
        this.f = u97Var2;
    }

    public final u97 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (u97) invokeV.objValue;
    }

    public final List<n87> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final j87 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (j87) invokeV.objValue;
    }

    public final List<n87> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final u97 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (u97) invokeV.objValue;
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
