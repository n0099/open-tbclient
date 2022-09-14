package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class f4 implements Iterable<e4>, Comparator<e4>, Comparable<f4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final b7<e4> b;
    public boolean c;

    public f4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new b7<>();
        this.c = true;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i();
            int i = this.b.b;
            long j = this.a + 71;
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 = (i2 * 7) & 65535;
                j += this.a * this.b.get(i3).hashCode() * i2;
            }
            return (int) (j ^ (j >> 32));
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: b */
    public final int compare(e4 e4Var, e4 e4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e4Var, e4Var2)) == null) ? (int) (e4Var.a - e4Var2.a) : invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(f4 f4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f4Var)) != null) {
            return invokeL.intValue;
        }
        if (f4Var == this) {
            return 0;
        }
        long j = this.a;
        long j2 = f4Var.a;
        if (j != j2) {
            return j < j2 ? -1 : 1;
        }
        i();
        f4Var.i();
        int i = 0;
        while (true) {
            b7<e4> b7Var = this.b;
            if (i >= b7Var.b) {
                return 0;
            }
            int compareTo = b7Var.get(i).compareTo(f4Var.b.get(i));
            if (compareTo != 0) {
                if (compareTo < 0) {
                    return -1;
                }
                return compareTo > 0 ? 1 : 0;
            }
            i++;
        }
    }

    public final void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.a = j | this.a;
        }
    }

    public final boolean e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) ? j != 0 && (this.a & j) == j : invokeJ.booleanValue;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj instanceof f4) {
                if (obj == this) {
                    return true;
                }
                return g((f4) obj, true);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) != null) {
            return invokeJ.intValue;
        }
        if (!e(j)) {
            return -1;
        }
        int i = 0;
        while (true) {
            b7<e4> b7Var = this.b;
            if (i >= b7Var.b) {
                return -1;
            }
            if (b7Var.get(i).a == j) {
                return i;
            }
            i++;
        }
    }

    public final boolean g(f4 f4Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(1048585, this, f4Var, z)) != null) {
            return invokeLZ.booleanValue;
        }
        if (f4Var == this) {
            return true;
        }
        if (f4Var == null || this.a != f4Var.a) {
            return false;
        }
        if (!z) {
            return true;
        }
        i();
        f4Var.i();
        int i = 0;
        while (true) {
            b7<e4> b7Var = this.b;
            if (i >= b7Var.b) {
                return true;
            }
            if (!b7Var.get(i).a(f4Var.b.get(i))) {
                return false;
            }
            i++;
        }
    }

    public final void h(e4 e4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, e4Var) == null) {
            int f = f(e4Var.a);
            if (f < 0) {
                d(e4Var.a);
                this.b.a(e4Var);
                this.c = false;
            } else {
                this.b.l(f, e4Var);
            }
            i();
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? a() : invokeV.intValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.c) {
            return;
        }
        this.b.sort(this);
        this.c = true;
    }

    @Override // java.lang.Iterable
    public final Iterator<e4> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b.iterator() : (Iterator) invokeV.objValue;
    }
}
