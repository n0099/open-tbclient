package com.baidu.tieba;

import com.baidu.tieba.nwa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes4.dex */
public class hwa {
    public static /* synthetic */ Interceptable $ic;
    public static nwa a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947839511, "Lcom/baidu/tieba/hwa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947839511, "Lcom/baidu/tieba/hwa;");
                return;
            }
        }
        a = new nwa();
    }

    public static <TResult> TResult a(ewa<TResult> ewaVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ewaVar)) == null) {
            nwa.c("await must not be called on the UI thread");
            if (ewaVar.g()) {
                return (TResult) nwa.b(ewaVar);
            }
            nwa.b bVar = new nwa.b();
            ewaVar.c(bVar);
            ewaVar.b(bVar);
            bVar.a.await();
            return (TResult) nwa.b(ewaVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> ewa<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(gwa.a(), callable) : (ewa) invokeL.objValue;
    }

    public static <TResult> ewa<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(gwa.b(), callable) : (ewa) invokeL.objValue;
    }
}
