package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b57 a;
    public final List<h57> b;
    public final List<h57> c;
    public final c67 d;
    public final c67 e;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a57) {
                a57 a57Var = (a57) obj;
                return Intrinsics.areEqual(this.a, a57Var.a) && Intrinsics.areEqual(this.b, a57Var.b) && Intrinsics.areEqual(this.c, a57Var.c) && Intrinsics.areEqual(this.d, a57Var.d) && Intrinsics.areEqual(this.e, a57Var.e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            c67 c67Var = this.d;
            int hashCode2 = (hashCode + (c67Var == null ? 0 : c67Var.hashCode())) * 31;
            c67 c67Var2 = this.e;
            return hashCode2 + (c67Var2 != null ? c67Var2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "CardHeadData(imageData=" + this.a + ", mainData=" + this.b + ", extraData=" + this.c + ", statData=" + this.d + ", statData2=" + this.e + ')';
        }
        return (String) invokeV.objValue;
    }

    public a57(b57 imageData, List<? extends h57> mainData, List<? extends h57> extraData, c67 c67Var, c67 c67Var2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageData, mainData, extraData, c67Var, c67Var2};
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
        this.d = c67Var;
        this.e = c67Var2;
    }

    public final List<h57> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final b57 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (b57) invokeV.objValue;
    }

    public final List<h57> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final c67 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (c67) invokeV.objValue;
    }

    public final c67 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (c67) invokeV.objValue;
    }
}
