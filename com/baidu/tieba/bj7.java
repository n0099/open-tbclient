package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final List<l67> c;
    public final long d;
    public final m87 e;
    public final List<h87> f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof bj7) {
                bj7 bj7Var = (bj7) obj;
                return Intrinsics.areEqual(this.a, bj7Var.a) && Intrinsics.areEqual(this.b, bj7Var.b) && Intrinsics.areEqual(this.c, bj7Var.c) && this.d == bj7Var.d && Intrinsics.areEqual(this.e, bj7Var.e) && Intrinsics.areEqual(this.f, bj7Var.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            List<l67> list = this.c;
            int hashCode3 = (((((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + c.a(this.d)) * 31) + this.e.hashCode()) * 31;
            List<h87> list2 = this.f;
            return hashCode3 + (list2 != null ? list2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "StaggeredVideoAuthorData(imgUrl=" + this.a + ", imgSchema=" + this.b + ", mainData=" + this.c + ", commentNum=" + this.d + ", videoSchemaData=" + this.e + ", manageItemList=" + this.f + ')';
        }
        return (String) invokeV.objValue;
    }

    public bj7(String str, String str2, List<? extends l67> list, long j, m87 videoSchemaData, List<h87> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, list, Long.valueOf(j), videoSchemaData, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(videoSchemaData, "videoSchemaData");
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = j;
        this.e = videoSchemaData;
        this.f = list2;
    }

    public final long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final List<l67> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final List<h87> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }
}
