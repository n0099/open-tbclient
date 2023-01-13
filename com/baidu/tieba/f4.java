package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class f4 implements Comparable<f4> {
    public static /* synthetic */ Interceptable $ic;
    public static final c7<String> c;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302815, "Lcom/baidu/tieba/f4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302815, "Lcom/baidu/tieba/f4;");
                return;
            }
        }
        c = new c7<>();
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b * 7489;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return b(this.a);
        }
        return (String) invokeV.objValue;
    }

    public f4(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j;
        this.b = Long.numberOfTrailingZeros(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
        r7 = com.baidu.tieba.f4.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r0 >= r7.b) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
        return r7.get(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            int i = -1;
            while (j != 0 && (i = i + 1) < 63 && ((j >> i) & 1) == 0) {
            }
            return null;
        }
        return (String) invokeJ.objValue;
    }

    public static final long c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int i = 0;
            while (true) {
                c7<String> c7Var = c;
                if (i < c7Var.b) {
                    if (c7Var.get(i).compareTo(str) == 0) {
                        return 1 << i;
                    }
                    i++;
                } else {
                    return 0L;
                }
            }
        } else {
            return invokeL.longValue;
        }
    }

    public static final long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            long c2 = c(str);
            if (c2 > 0) {
                return c2;
            }
            c.a(str);
            return 1 << (c.b - 1);
        }
        return invokeL.longValue;
    }

    public boolean a(f4 f4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f4Var)) == null) {
            if (f4Var.hashCode() == hashCode()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f4)) {
                return false;
            }
            f4 f4Var = (f4) obj;
            if (this.a != f4Var.a) {
                return false;
            }
            return a(f4Var);
        }
        return invokeL.booleanValue;
    }
}
