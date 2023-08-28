package com.baidu.tieba;

import com.baidu.tieba.gwb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes5.dex */
public class awb {
    public static /* synthetic */ Interceptable $ic;
    public static gwb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947631005, "Lcom/baidu/tieba/awb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947631005, "Lcom/baidu/tieba/awb;");
                return;
            }
        }
        a = new gwb();
    }

    public static <TResult> TResult a(xvb<TResult> xvbVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xvbVar)) == null) {
            gwb.c("await must not be called on the UI thread");
            if (xvbVar.g()) {
                return (TResult) gwb.b(xvbVar);
            }
            gwb.b bVar = new gwb.b();
            xvbVar.c(bVar);
            xvbVar.b(bVar);
            bVar.a.await();
            return (TResult) gwb.b(xvbVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> xvb<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(zvb.a(), callable) : (xvb) invokeL.objValue;
    }

    public static <TResult> xvb<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(zvb.b(), callable) : (xvb) invokeL.objValue;
    }
}
