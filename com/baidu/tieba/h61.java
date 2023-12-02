package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h61 {
    public static /* synthetic */ Interceptable $ic;
    public static w31 a;
    public static k61 b;
    public static y31 c;
    public static j61 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947775558, "Lcom/baidu/tieba/h61;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947775558, "Lcom/baidu/tieba/h61;");
        }
    }

    public h61() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context b2 = hf0.b();
            Intrinsics.checkNotNullExpressionValue(b2, "AdRuntime.applicationContext()");
            return b2;
        }
        return (Context) invokeV.objValue;
    }

    @JvmStatic
    public static final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (ij0.b().a().a("nad__web_view_invoke_by_cmd_default", 1) == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (ij0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) != 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (ij0.b().a().a("nairobi_kernel_type", c51.b()) == c51.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final j61 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (d == null) {
                synchronized (h61.class) {
                    if (d == null) {
                        d = (j61) ServiceManager.getService(j61.a);
                    }
                    if (d == null) {
                        d = j61.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return d;
        }
        return (j61) invokeV.objValue;
    }

    @JvmStatic
    public static final y31 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (h61.class) {
                    if (c == null) {
                        c = (y31) ServiceManager.getService(y31.a);
                    }
                    if (c == null) {
                        c = y31.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return c;
        }
        return (y31) invokeV.objValue;
    }

    @JvmStatic
    public static final w31 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (a == null) {
                synchronized (h61.class) {
                    if (a == null) {
                        a = (w31) ServiceManager.getService(w31.a);
                    }
                    if (a == null) {
                        a = w31.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return a;
        }
        return (w31) invokeV.objValue;
    }

    @JvmStatic
    public static final k61 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (h61.class) {
                    if (b == null) {
                        b = (k61) ServiceManager.getService(k61.a);
                    }
                    if (b == null) {
                        b = k61.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return b;
        }
        return (k61) invokeV.objValue;
    }
}
