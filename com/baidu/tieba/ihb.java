package com.baidu.tieba;

import com.baidu.tieba.ohb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes6.dex */
public class ihb {
    public static /* synthetic */ Interceptable $ic;
    public static ohb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947854918, "Lcom/baidu/tieba/ihb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947854918, "Lcom/baidu/tieba/ihb;");
                return;
            }
        }
        a = new ohb();
    }

    public static <TResult> TResult a(fhb<TResult> fhbVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fhbVar)) == null) {
            ohb.c("await must not be called on the UI thread");
            if (fhbVar.g()) {
                return (TResult) ohb.b(fhbVar);
            }
            ohb.b bVar = new ohb.b();
            fhbVar.c(bVar);
            fhbVar.b(bVar);
            bVar.a.await();
            return (TResult) ohb.b(fhbVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> fhb<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(hhb.a(), callable) : (fhb) invokeL.objValue;
    }

    public static <TResult> fhb<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(hhb.b(), callable) : (fhb) invokeL.objValue;
    }
}
