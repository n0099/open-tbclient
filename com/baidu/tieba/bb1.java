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
/* loaded from: classes5.dex */
public final class bb1 {
    public static /* synthetic */ Interceptable $ic;
    public static q81 a;
    public static eb1 b;
    public static s81 c;
    public static db1 d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947639096, "Lcom/baidu/tieba/bb1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947639096, "Lcom/baidu/tieba/bb1;");
        }
    }

    public bb1() {
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
            Context b2 = tj0.b();
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
            if (un0.b().a().a("nad__web_view_invoke_by_cmd_default", 1) == 1) {
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
            if (un0.b().a().a("nad_web_view_forbid_kb_opt_switch", 0) != 1) {
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
            if (un0.b().a().a("nairobi_kernel_type", w91.b()) == w91.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @JvmStatic
    public static final db1 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (d == null) {
                synchronized (bb1.class) {
                    if (d == null) {
                        d = (db1) ServiceManager.getService(db1.a);
                    }
                    if (d == null) {
                        d = db1.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return d;
        }
        return (db1) invokeV.objValue;
    }

    @JvmStatic
    public static final s81 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == null) {
                synchronized (bb1.class) {
                    if (c == null) {
                        c = (s81) ServiceManager.getService(s81.a);
                    }
                    if (c == null) {
                        c = s81.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return c;
        }
        return (s81) invokeV.objValue;
    }

    @JvmStatic
    public static final q81 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (a == null) {
                synchronized (bb1.class) {
                    if (a == null) {
                        a = (q81) ServiceManager.getService(q81.a);
                    }
                    if (a == null) {
                        a = q81.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return a;
        }
        return (q81) invokeV.objValue;
    }

    @JvmStatic
    public static final eb1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (b == null) {
                synchronized (bb1.class) {
                    if (b == null) {
                        b = (eb1) ServiceManager.getService(eb1.a);
                    }
                    if (b == null) {
                        b = eb1.b;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return b;
        }
        return (eb1) invokeV.objValue;
    }
}
