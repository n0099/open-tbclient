package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public String k;
    public int l;
    public int m;
    public float n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f31() {
        this(0.0f, 0.0f, null, null, null, null, null, null, null, 0, null, 0, 0, 0.0f, 16383, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue(), (String) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7], (String) objArr[8], ((Integer) objArr[9]).intValue(), (String) objArr[10], ((Integer) objArr[11]).intValue(), ((Integer) objArr[12]).intValue(), ((Float) objArr[13]).floatValue(), ((Integer) objArr[14]).intValue(), (DefaultConstructorMarker) objArr[15]);
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
            if (this != obj) {
                if (obj instanceof f31) {
                    f31 f31Var = (f31) obj;
                    return Float.compare(this.a, f31Var.a) == 0 && Float.compare(this.b, f31Var.b) == 0 && Intrinsics.areEqual(this.c, f31Var.c) && Intrinsics.areEqual(this.d, f31Var.d) && Intrinsics.areEqual(this.e, f31Var.e) && Intrinsics.areEqual(this.f, f31Var.f) && Intrinsics.areEqual(this.g, f31Var.g) && Intrinsics.areEqual(this.h, f31Var.h) && Intrinsics.areEqual(this.i, f31Var.i) && this.j == f31Var.j && Intrinsics.areEqual(this.k, f31Var.k) && this.l == f31Var.l && this.m == f31Var.m && Float.compare(this.n, f31Var.n) == 0;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int floatToIntBits = ((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31;
            String str = this.c;
            int hashCode = (floatToIntBits + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.d;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.e;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.g;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.h;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.i;
            int hashCode7 = (((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + this.j) * 31;
            String str8 = this.k;
            return ((((((hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.l) * 31) + this.m) * 31) + Float.floatToIntBits(this.n);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "NadLottiePopParams(widthInParent=" + this.a + ", whRatio=" + this.b + ", bgColor=" + this.c + ", lottie=" + this.d + ", lottieText=" + this.e + ", lottieShowMode=" + this.f + ", bgImageUrl=" + this.g + ", contentImageUrl=" + this.h + ", imgKeyPath=" + this.i + ", layoutGravity=" + this.j + ", margins=" + this.k + ", showTime=" + this.l + ", displayTime=" + this.m + ", lottieStartProgress=" + this.n + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public f31(float f, float f2, String bgColor, String lottie, String lottieText, String lottieShowMode, String bgImageUrl, String contentImageUrl, String imgKeyPath, int i, String margins, int i2, int i3, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), bgColor, lottie, lottieText, lottieShowMode, bgImageUrl, contentImageUrl, imgKeyPath, Integer.valueOf(i), margins, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(bgColor, "bgColor");
        Intrinsics.checkNotNullParameter(lottie, "lottie");
        Intrinsics.checkNotNullParameter(lottieText, "lottieText");
        Intrinsics.checkNotNullParameter(lottieShowMode, "lottieShowMode");
        Intrinsics.checkNotNullParameter(bgImageUrl, "bgImageUrl");
        Intrinsics.checkNotNullParameter(contentImageUrl, "contentImageUrl");
        Intrinsics.checkNotNullParameter(imgKeyPath, "imgKeyPath");
        Intrinsics.checkNotNullParameter(margins, "margins");
        this.a = f;
        this.b = f2;
        this.c = bgColor;
        this.d = lottie;
        this.e = lottieText;
        this.f = lottieShowMode;
        this.g = bgImageUrl;
        this.h = contentImageUrl;
        this.i = imgKeyPath;
        this.j = i;
        this.k = margins;
        this.l = i2;
        this.m = i3;
        this.n = f3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ f31(float f, float f2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, int i3, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r5, r6, r7, r8, r9, r4, r10, r11, r12, r13, r0);
        float f4;
        float f5;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        int i5;
        String str15;
        int i6;
        int i7;
        float f6;
        if ((i4 & 1) != 0) {
            f4 = 0.43f;
        } else {
            f4 = f;
        }
        if ((i4 & 2) != 0) {
            f5 = 1.0f;
        } else {
            f5 = f2;
        }
        if ((i4 & 4) != 0) {
            str9 = "";
        } else {
            str9 = str;
        }
        if ((i4 & 8) != 0) {
            str10 = "";
        } else {
            str10 = str2;
        }
        if ((i4 & 16) != 0) {
            str11 = "";
        } else {
            str11 = str3;
        }
        if ((i4 & 32) != 0) {
            str12 = "auto";
        } else {
            str12 = str4;
        }
        if ((i4 & 64) != 0) {
            str13 = "";
        } else {
            str13 = str5;
        }
        if ((i4 & 128) != 0) {
            str14 = "";
        } else {
            str14 = str6;
        }
        String str16 = (i4 & 256) == 0 ? str7 : "";
        if ((i4 & 512) != 0) {
            i5 = 48;
        } else {
            i5 = i;
        }
        if ((i4 & 1024) != 0) {
            str15 = "0_0_0_0";
        } else {
            str15 = str8;
        }
        if ((i4 & 2048) != 0) {
            i6 = 3;
        } else {
            i6 = i2;
        }
        if ((i4 & 4096) != 0) {
            i7 = 7;
        } else {
            i7 = i3;
        }
        if ((i4 & 8192) != 0) {
            f6 = 0.0f;
        } else {
            f6 = f3;
        }
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.n;
        }
        return invokeV.floatValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final float m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return invokeV.floatValue;
    }

    public final float n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a;
        }
        return invokeV.floatValue;
    }
}
