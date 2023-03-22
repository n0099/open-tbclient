package com.baidu.tieba;

import android.graphics.Paint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zr6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class bs6 implements zr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final yr6 b;
    public final String c;
    public final int d;
    public final boolean e;
    public final Integer f;
    public final String g;
    public final Integer h;
    public int i;
    public boolean j;
    public boolean k;
    public String l;
    public int m;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof bs6) {
                bs6 bs6Var = (bs6) obj;
                return Intrinsics.areEqual(this.a, bs6Var.a) && Intrinsics.areEqual(this.b, bs6Var.b) && Intrinsics.areEqual(this.c, bs6Var.c) && this.d == bs6Var.d && this.e == bs6Var.e && Intrinsics.areEqual(this.f, bs6Var.f) && Intrinsics.areEqual(this.g, bs6Var.g) && Intrinsics.areEqual(this.h, bs6Var.h);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            yr6 yr6Var = this.b;
            int hashCode2 = (hashCode + (yr6Var == null ? 0 : yr6Var.hashCode())) * 31;
            String str = this.c;
            int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.d) * 31;
            boolean z = this.e;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode3 + i) * 31;
            Integer num = this.f;
            int hashCode4 = (i2 + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.g;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num2 = this.h;
            return hashCode5 + (num2 != null ? num2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "EnableDegradeTextData(text=" + this.a + ", textColor=" + this.b + ", schema=" + this.c + ", priority=" + this.d + ", degradeEnable=" + this.e + ", degradeLength=" + this.f + ", degradeSuffix=" + this.g + ", degradePriority=" + this.h + ')';
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zr6
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zr6
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final yr6 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (yr6) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zr6
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zr6
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k = false;
        }
    }

    @Override // com.baidu.tieba.zr6
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = this.d;
            this.j = this.e;
            this.k = true;
            String str = this.a;
            this.l = str;
            this.m = str.length();
        }
    }

    @Override // com.baidu.tieba.zr6
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            this.m--;
            StringBuilder sb = new StringBuilder();
            String substring = this.a.substring(0, this.m);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(this.g);
            this.l = sb.toString();
            int i = this.m;
            Integer num = this.f;
            Intrinsics.checkNotNull(num);
            if (i > num.intValue()) {
                return false;
            }
            Integer num2 = this.h;
            Intrinsics.checkNotNull(num2);
            this.i = num2.intValue();
            this.j = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(zr6 zr6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zr6Var)) == null) {
            return zr6.a.a(this, zr6Var);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.zr6
    public int h(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            Paint paint = new Paint();
            paint.setTextSize(i);
            return (int) paint.measureText(this.l);
        }
        return invokeII.intValue;
    }
}
