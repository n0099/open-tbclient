package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zr6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class as6 implements zr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final String g;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public int k;
    public boolean l;
    public boolean m;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof as6) {
                as6 as6Var = (as6) obj;
                return Intrinsics.areEqual(this.a, as6Var.a) && Intrinsics.areEqual(this.b, as6Var.b) && this.c == as6Var.c && this.d == as6Var.d && this.e == as6Var.e && this.f == as6Var.f && Intrinsics.areEqual(this.g, as6Var.g) && Intrinsics.areEqual(this.h, as6Var.h) && Intrinsics.areEqual(this.i, as6Var.i) && Intrinsics.areEqual(this.j, as6Var.j);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            String str = this.b;
            int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            boolean z = this.f;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode2 + i) * 31;
            String str2 = this.g;
            int hashCode3 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.h;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.i;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.j;
            return hashCode5 + (num3 != null ? num3.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "EnableDegradeIconData(url=" + this.a + ", schema=" + this.b + ", width=" + this.c + ", height=" + this.d + ", priority=" + this.e + ", degradeEnable=" + this.f + ", degradeUrl=" + this.g + ", degradeWidth=" + this.h + ", degradeHeight=" + this.i + ", degradePriority=" + this.j + ')';
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zr6
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zr6
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.zr6
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Integer num = this.j;
            Intrinsics.checkNotNull(num);
            this.k = num.intValue();
            this.l = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final Integer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (Integer) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public final Integer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (Integer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zr6
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.zr6
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.m = false;
        }
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zr6
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.k = this.e;
            this.l = this.f;
            this.m = true;
        }
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
        float f;
        int i3;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
            if (this.f) {
                if (this.l) {
                    f = i2 * this.c;
                    i3 = this.d;
                } else {
                    float f2 = i2;
                    Intrinsics.checkNotNull(this.h);
                    f = f2 * num.intValue();
                    Integer num2 = this.i;
                    Intrinsics.checkNotNull(num2);
                    i3 = num2.intValue();
                }
            } else {
                f = i2 * this.c;
                i3 = this.d;
            }
            return (int) (f / i3);
        }
        return invokeII.intValue;
    }
}
