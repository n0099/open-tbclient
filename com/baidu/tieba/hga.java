package com.baidu.tieba;

import com.baidu.tieba.nga;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
/* loaded from: classes4.dex */
public class hga {
    public static /* synthetic */ Interceptable $ic;
    public static nga a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947824135, "Lcom/baidu/tieba/hga;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947824135, "Lcom/baidu/tieba/hga;");
                return;
            }
        }
        a = new nga();
    }

    public static <TResult> TResult a(ega<TResult> egaVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, egaVar)) == null) {
            nga.c("await must not be called on the UI thread");
            if (egaVar.g()) {
                return (TResult) nga.b(egaVar);
            }
            nga.b bVar = new nga.b();
            egaVar.c(bVar);
            egaVar.b(bVar);
            bVar.a.await();
            return (TResult) nga.b(egaVar);
        }
        return (TResult) invokeL.objValue;
    }

    public static <TResult> ega<TResult> b(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) ? a.a(gga.a(), callable) : (ega) invokeL.objValue;
    }

    public static <TResult> ega<TResult> call(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, callable)) == null) ? a.a(gga.b(), callable) : (ega) invokeL.objValue;
    }
}
