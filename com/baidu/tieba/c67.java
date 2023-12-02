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
/* loaded from: classes5.dex */
public final class c67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d67 a;
    public final List<l67> b;
    public final List<l67> c;
    public final VirtualImageCustomState d;
    public final e87 e;
    public final e87 f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c67) {
                c67 c67Var = (c67) obj;
                return Intrinsics.areEqual(this.a, c67Var.a) && Intrinsics.areEqual(this.b, c67Var.b) && Intrinsics.areEqual(this.c, c67Var.c) && Intrinsics.areEqual(this.d, c67Var.d) && Intrinsics.areEqual(this.e, c67Var.e) && Intrinsics.areEqual(this.f, c67Var.f);
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
            e87 e87Var = this.e;
            int hashCode3 = (hashCode2 + (e87Var == null ? 0 : e87Var.hashCode())) * 31;
            e87 e87Var2 = this.f;
            return hashCode3 + (e87Var2 != null ? e87Var2.hashCode() : 0);
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

    public c67(d67 imageData, List<? extends l67> mainData, List<? extends l67> extraData, VirtualImageCustomState virtualImageCustomState, e87 e87Var, e87 e87Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageData, mainData, extraData, virtualImageCustomState, e87Var, e87Var2};
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
        this.e = e87Var;
        this.f = e87Var2;
    }

    public final e87 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (e87) invokeV.objValue;
    }

    public final List<l67> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final d67 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (d67) invokeV.objValue;
    }

    public final List<l67> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final e87 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (e87) invokeV.objValue;
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
