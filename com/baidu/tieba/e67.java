package com.baidu.tieba;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class e67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final SparseArray<String> d;
    public final SparseArray<String> e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e67() {
        this(null, null, null, null, null, null, null, null, 0, 511, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1], (String) objArr[2], (SparseArray) objArr[3], (SparseArray) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7], ((Integer) objArr[8]).intValue(), ((Integer) objArr[9]).intValue(), (DefaultConstructorMarker) objArr[10]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof e67) {
                e67 e67Var = (e67) obj;
                return Intrinsics.areEqual(this.a, e67Var.a) && Intrinsics.areEqual(this.b, e67Var.b) && Intrinsics.areEqual(this.c, e67Var.c) && Intrinsics.areEqual(this.d, e67Var.d) && Intrinsics.areEqual(this.e, e67Var.e) && Intrinsics.areEqual(this.f, e67Var.f) && Intrinsics.areEqual(this.g, e67Var.g) && Intrinsics.areEqual(this.h, e67Var.h) && this.i == e67Var.i;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.a;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            SparseArray<String> sparseArray = this.d;
            int hashCode4 = (hashCode3 + (sparseArray == null ? 0 : sparseArray.hashCode())) * 31;
            SparseArray<String> sparseArray2 = this.e;
            int hashCode5 = (hashCode4 + (sparseArray2 == null ? 0 : sparseArray2.hashCode())) * 31;
            String str4 = this.f;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.g;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.h;
            return ((hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.i;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "FeedFeedbackPostData(tid=" + this.a + ", fid=" + this.b + ", nid=" + this.c + ", feedBackReasonMap=" + this.d + ", feedBackExtraMap=" + this.e + ", weight=" + this.f + ", source=" + this.g + ", extra=" + this.h + ", threadType=" + this.i + ')';
        }
        return (String) invokeV.objValue;
    }

    public e67(String str, String str2, String str3, SparseArray<String> sparseArray, SparseArray<String> sparseArray2, String str4, String str5, String str6, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, sparseArray, sparseArray2, str4, str5, str6, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = sparseArray;
        this.e = sparseArray2;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ e67(String str, String str2, String str3, SparseArray sparseArray, SparseArray sparseArray2, String str4, String str5, String str6, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, r6, r7, r8, r2, r0);
        String str7;
        String str8;
        String str9;
        SparseArray sparseArray3;
        SparseArray sparseArray4;
        String str10;
        String str11;
        int i3;
        if ((i2 & 1) != 0) {
            str7 = null;
        } else {
            str7 = str;
        }
        if ((i2 & 2) != 0) {
            str8 = null;
        } else {
            str8 = str2;
        }
        if ((i2 & 4) != 0) {
            str9 = null;
        } else {
            str9 = str3;
        }
        if ((i2 & 8) != 0) {
            sparseArray3 = null;
        } else {
            sparseArray3 = sparseArray;
        }
        if ((i2 & 16) != 0) {
            sparseArray4 = null;
        } else {
            sparseArray4 = sparseArray2;
        }
        if ((i2 & 32) != 0) {
            str10 = null;
        } else {
            str10 = str4;
        }
        if ((i2 & 64) != 0) {
            str11 = null;
        } else {
            str11 = str5;
        }
        String str12 = (i2 & 128) == 0 ? str6 : null;
        if ((i2 & 256) != 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final SparseArray<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final SparseArray<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }
}
