package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ep3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;
    public Method b;
    public Method c;
    public Method d;
    public Method e;
    public String f;

    public ep3(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (cls == null) {
            return;
        }
        try {
            Object m = n84.m(cls);
            this.a = m;
            if (m != null) {
                Method i3 = n84.i(cls, "hypnusSetAction", Integer.TYPE, Integer.TYPE);
                this.b = i3;
                if (i3 != null) {
                    i3.setAccessible(true);
                }
                Method i4 = n84.i(cls, "hypnusSetSignatureAction", Integer.TYPE, Integer.TYPE, String.class);
                this.c = i4;
                if (i4 != null) {
                    i4.setAccessible(true);
                }
                Method i5 = n84.i(cls, "isHypnusOK", new Class[0]);
                this.e = i5;
                if (i5 != null) {
                    i5.setAccessible(true);
                }
                f();
            }
        } catch (Throwable unused) {
        }
    }

    public static ep3 a(@NonNull Context context) {
        Class<?> cls;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                cls = n84.b("com.oppo.hypnus.HypnusManager", true);
            } catch (Throwable unused) {
                cls = null;
            }
            return new ep3(cls);
        }
        return (ep3) invokeL.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str2 = this.f;
            if (str2 != null) {
                return str2;
            }
            Method method = this.d;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    if (invoke == null) {
                        str = "308203633082024ba00302010202040875ec17300d06092a864886f70d01010b05003062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d301e170d3135303130373036343930325a170d3235303130343036343930325a3062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d30820122300d06092a864886f70d01010105000382010f003082010a0282010100a4677dd7cdd8d842b767d4a4";
                    } else {
                        str = (String) invoke;
                    }
                    this.f = str;
                } catch (Throwable unused) {
                    this.f = "308203633082024ba00302010202040875ec17300d06092a864886f70d01010b05003062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d301e170d3135303130373036343930325a170d3235303130343036343930325a3062310b300906035504061302383631123010060355040813096775616e67646f6e673111300f060355040713087368656e7a68656e310e300c060355040a13056368696e61310e300c060355040b13056368696e61310c300a06035504031303726f6d30820122300d06092a864886f70d01010105000382010f003082010a0282010100a4677dd7cdd8d842b767d4a4";
                }
            }
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c != null && b() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                Class<?> b = n84.b("com.oppo.hypnus.Hypnus", true);
                if (b != null) {
                    Method i = n84.i(b, "getLocalSignature", new Class[0]);
                    this.d = i;
                    if (i != null) {
                        i.setAccessible(true);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object obj = this.a;
            if (obj == null) {
                return false;
            }
            Method method = this.e;
            if (method == null) {
                return true;
            }
            try {
                Object invoke = method.invoke(obj, new Object[0]);
                if (invoke != null) {
                    return ((Boolean) invoke).booleanValue();
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d(int i, int i2) {
        Object obj;
        Method method;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && (obj = this.a) != null && (method = this.b) != null) {
            try {
                method.invoke(obj, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Throwable unused) {
            }
        }
    }

    public void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) && this.a != null && this.c != null && b() != null) {
            try {
                this.c.invoke(this.a, Integer.valueOf(i), Integer.valueOf(i2), this.f);
            } catch (Throwable unused) {
            }
        }
    }
}
