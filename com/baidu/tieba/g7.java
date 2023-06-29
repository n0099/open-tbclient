package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class g7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public boolean c;
    public final float d;
    public int e;
    public int f;
    public int g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g7() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public g7(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f > 0.0f && f < 1.0f) {
            this.d = f;
            int h = q7.h(i, f);
            this.e = (int) (h * f);
            int i4 = h - 1;
            this.g = i4;
            this.f = Long.numberOfLeadingZeros(i4);
            this.b = new int[h];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f);
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 0) {
                if (this.c) {
                    return false;
                }
                this.c = true;
                this.a++;
                return true;
            }
            int d = d(i);
            if (d >= 0) {
                return false;
            }
            int i2 = -(d + 1);
            int[] iArr = this.b;
            iArr[i2] = i;
            int i3 = this.a + 1;
            this.a = i3;
            if (i3 >= this.e) {
                g(iArr.length << 1);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (!(obj instanceof g7)) {
                return false;
            }
            g7 g7Var = (g7) obj;
            if (g7Var.a != this.a || g7Var.c != this.c) {
                return false;
            }
            int[] iArr = this.b;
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                if (iArr[i] != 0 && !g7Var.c(iArr[i])) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int length = this.b.length;
            this.e = (int) (i * this.d);
            int i2 = i - 1;
            this.g = i2;
            this.f = Long.numberOfLeadingZeros(i2);
            int[] iArr = this.b;
            this.b = new int[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    if (i4 != 0) {
                        b(i4);
                    }
                }
            }
        }
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int[] iArr = this.b;
            int e = e(i);
            while (iArr[e] != 0) {
                e = (e + 1) & this.g;
            }
            iArr[e] = i;
        }
    }

    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 0) {
                return this.c;
            }
            if (d(i) >= 0) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            int[] iArr = this.b;
            int e = e(i);
            while (true) {
                int i2 = iArr[e];
                if (i2 == 0) {
                    return -(e + 1);
                }
                if (i2 == i) {
                    return e;
                }
                e = (e + 1) & this.g;
            }
        } else {
            return invokeI.intValue;
        }
    }

    public int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return (int) ((i * (-7046029254386353131L)) >>> this.f);
        }
        return invokeI.intValue;
    }

    public boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i == 0) {
                if (!this.c) {
                    return false;
                }
                this.c = false;
                this.a--;
                return true;
            }
            int d = d(i);
            if (d < 0) {
                return false;
            }
            int[] iArr = this.b;
            int i2 = this.g;
            int i3 = d + 1;
            while (true) {
                int i4 = i3 & i2;
                int i5 = iArr[i4];
                if (i5 != 0) {
                    int e = e(i5);
                    if (((i4 - e) & i2) > ((d - e) & i2)) {
                        iArr[d] = i5;
                        d = i4;
                    }
                    i3 = i4 + 1;
                } else {
                    iArr[d] = 0;
                    this.a--;
                    return true;
                }
            }
        } else {
            return invokeI.booleanValue;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.a;
            for (int i2 : this.b) {
                if (i2 != 0) {
                    i += i2;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0031 -> B:18:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.a == 0) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder(32);
            sb.append('[');
            int[] iArr = this.b;
            int length = iArr.length;
            if (this.c) {
                sb.append("0");
                i = length - 1;
                if (length > 0) {
                    int i2 = iArr[i];
                    if (i2 != 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        sb.append(i2);
                    }
                    length = i;
                    i = length - 1;
                    if (length > 0) {
                    }
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            } else {
                while (true) {
                    i = length - 1;
                    if (length > 0) {
                        int i3 = iArr[i];
                        if (i3 == 0) {
                            length = i;
                        } else {
                            sb.append(i3);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                length = i;
                i = length - 1;
                if (length > 0) {
                }
            }
        } else {
            return (String) invokeV.objValue;
        }
    }
}
