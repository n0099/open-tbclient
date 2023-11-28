package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.Logger;
import com.baidu.yalog.LoggerManager;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bgc {
    public static /* synthetic */ Interceptable $ic;
    public static Logger a;
    public static final a b;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static final void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            b.b(str, str2);
        }
    }

    @JvmStatic
    public static final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            b.d(str, str2);
        }
    }

    @JvmStatic
    public static final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            b.g(str, str2);
        }
    }

    @JvmStatic
    public static final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) {
            b.j(str, str2);
        }
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                g("sub_process_view", "init succeed");
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b("sub_process_view", str);
            }
        }

        @JvmStatic
        public final void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                d("sub_process_view", str);
            }
        }

        public final void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                Logger logger = bgc.a;
                if (logger != null) {
                    logger.flush(z);
                }
                g("sub_process_view", "flushYalog!");
            }
        }

        @JvmStatic
        public final void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                g("sub_process_view", str);
            }
        }

        public final void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) {
                return;
            }
            bgc.a = LoggerManager.getLogger(str);
        }

        @JvmStatic
        public final void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                if (bgc.a != null) {
                    Logger logger = bgc.a;
                    if (logger == null) {
                        Intrinsics.throwNpe();
                    }
                    logger.d("3925", str, cgc.a(str2));
                    return;
                }
                Log.d(str, cgc.a(str2));
            }
        }

        @JvmStatic
        public final void d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
                if (bgc.a != null) {
                    Logger logger = bgc.a;
                    if (logger == null) {
                        Intrinsics.throwNpe();
                    }
                    logger.e("3925", str, cgc.a(str2));
                    return;
                }
                Log.e(str, cgc.a(str2));
            }
        }

        @JvmStatic
        public final void g(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
                if (bgc.a != null) {
                    Logger logger = bgc.a;
                    if (logger == null) {
                        Intrinsics.throwNpe();
                    }
                    logger.i("3925", str, cgc.a(str2));
                    return;
                }
                Log.i(str, cgc.a(str2));
            }
        }

        @JvmStatic
        public final void j(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
                if (bgc.a != null) {
                    Logger logger = bgc.a;
                    if (logger == null) {
                        Intrinsics.throwNpe();
                    }
                    logger.w("3925", str, cgc.a(str2));
                    return;
                }
                Log.w(str, cgc.a(str2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947645451, "Lcom/baidu/tieba/bgc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947645451, "Lcom/baidu/tieba/bgc;");
                return;
            }
        }
        b = new a(null);
        try {
            Log.i("sub_process_view", "KlogUtil init yalog");
            b.i("yylivesdk");
        } catch (Throwable th) {
            a aVar = b;
            th.printStackTrace();
            aVar.d("sub_process_view", Unit.INSTANCE.toString());
        }
    }
}
