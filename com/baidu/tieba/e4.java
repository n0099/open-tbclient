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
/* loaded from: classes3.dex */
public abstract class e4 implements Comparable<e4> {
    public static /* synthetic */ Interceptable $ic;
    public static final b7<String> c;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;
    public final int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301854, "Lcom/baidu/tieba/e4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301854, "Lcom/baidu/tieba/e4;");
                return;
            }
        }
        c = new b7<>();
    }

    public e4(long j) {
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
        r7 = com.baidu.tieba.e4.c;
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
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return invokeL.longValue;
        }
        int i = 0;
        while (true) {
            b7<String> b7Var = c;
            if (i >= b7Var.b) {
                return 0L;
            }
            if (b7Var.get(i).compareTo(str) == 0) {
                return 1 << i;
            }
            i++;
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

    public boolean a(e4 e4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e4Var)) == null) ? e4Var.hashCode() == hashCode() : invokeL.booleanValue;
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
            if (obj instanceof e4) {
                e4 e4Var = (e4) obj;
                if (this.a != e4Var.a) {
                    return false;
                }
                return a(e4Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b * 7489 : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b(this.a) : (String) invokeV.objValue;
    }
}
