package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public abstract class ar8<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947624898, "Lcom/baidu/tieba/ar8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947624898, "Lcom/baidu/tieba/ar8;");
        }
    }

    public ar8(String key) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {key};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(key, "key");
        this.a = "default";
        this.a = "key_prefix_" + key;
    }

    public final T a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            Intrinsics.checkNotNullParameter(t, "default");
            return (T) b(t);
        }
        return (T) invokeL.objValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.a = str;
        }
    }

    public final Object b(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            if (t instanceof String) {
                String s = n95.m().s(this.a, (String) t);
                Intrinsics.checkNotNullExpressionValue(s, "getInstance().getString(key, default as String)");
                return s;
            } else if (t instanceof Integer) {
                return Integer.valueOf(n95.m().n(this.a, ((Integer) t).intValue()));
            } else {
                if (t instanceof Long) {
                    return Long.valueOf(n95.m().o(this.a, ((Long) t).longValue()));
                }
                if (t instanceof Boolean) {
                    return Boolean.valueOf(n95.m().i(this.a, ((Boolean) t).booleanValue()));
                }
                if (t instanceof Float) {
                    return Float.valueOf(n95.m().l(this.a, ((Float) t).floatValue()));
                }
                return t;
            }
        }
        return invokeL.objValue;
    }

    public final T d(T value) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, value)) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof String) {
                n95.m().B(this.a, (String) value);
            } else if (value instanceof Integer) {
                n95.m().z(this.a, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                n95.m().A(this.a, ((Long) value).longValue());
            } else if (value instanceof Boolean) {
                n95.m().w(this.a, ((Boolean) value).booleanValue());
            } else if (value instanceof Float) {
                n95.m().y(this.a, ((Float) value).floatValue());
            }
            return value;
        }
        return (T) invokeL.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
