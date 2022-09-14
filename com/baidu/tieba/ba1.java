package com.baidu.tieba;

import com.baidu.android.util.soloader.SoLoader;
import com.baidu.perf.signal.register.NativeSignalCapture;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ba1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947638135, "Lcom/baidu/tieba/ba1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947638135, "Lcom/baidu/tieba/ba1;");
                return;
            }
        }
        SoLoader.load(AppRuntime.getAppContext(), "signal-register");
    }

    public static void a(z91 z91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, z91Var) == null) {
            NativeSignalCapture.addANRListener(z91Var);
        }
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            synchronized (NativeSignalCapture.sANRMutex) {
                NativeSignalCapture.registerANR(i);
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            NativeSignalCapture.clearANRListener();
            synchronized (NativeSignalCapture.sANRMutex) {
                NativeSignalCapture.unRegisterANR();
            }
        }
    }
}
