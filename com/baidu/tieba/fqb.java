package com.baidu.tieba;

import com.baidu.tieba.lqb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes5.dex */
public class fqb {
    public static /* synthetic */ Interceptable $ic;
    public static lqb a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947774194, "Lcom/baidu/tieba/fqb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947774194, "Lcom/baidu/tieba/fqb;");
                return;
            }
        }
        a = new lqb();
    }

    public static <TResult> TResult a(cqb<TResult> cqbVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cqbVar)) == null) {
            lqb.c("await must not be called on the UI thread");
            if (cqbVar.g()) {
                return (TResult) lqb.b(cqbVar);
            }
            lqb.b bVar = new lqb.b();
            cqbVar.c(bVar);
            cqbVar.b(bVar);
            bVar.a.await();
            return (TResult) lqb.b(cqbVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> cqb<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(eqb.a(), callable) : (cqb) invokeL.objValue;
    }

    public static <TResult> cqb<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(eqb.b(), callable) : (cqb) invokeL.objValue;
    }
}
