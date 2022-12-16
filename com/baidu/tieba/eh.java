package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class eh {
    public static /* synthetic */ Interceptable $ic;
    public static Handler a;
    public static Handler b;
    public transient /* synthetic */ FieldHolder $fh;

    public eh() {
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

    public static Handler a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (eh.class) {
                    if (b == null) {
                        HandlerThread handlerThread = new HandlerThread("UiUtils-Background");
                        handlerThread.start();
                        b = new Handler(handlerThread.getLooper());
                    }
                }
            }
            return b;
        }
        return (Handler) invokeV.objValue;
    }

    public static Handler b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (eh.class) {
                    if (a == null) {
                        a = new Handler(Looper.getMainLooper());
                    }
                }
            }
            return a;
        }
        return (Handler) invokeV.objValue;
    }

    public static void c(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, runnable) == null) {
            b().post(runnable);
        }
    }

    public static void d(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, runnable) == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                a().post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void e(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, runnable) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                b().post(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static void f(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65542, null, runnable, j) == null) {
            b().postDelayed(runnable, j);
        }
    }
}
