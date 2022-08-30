package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class dj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<ej0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947706335, "Lcom/baidu/tieba/dj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947706335, "Lcom/baidu/tieba/dj0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static ej0 a(@NonNull pi0 pi0Var) {
        InterceptResult invokeL;
        ej0 ej0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pi0Var)) == null) {
            WeakReference<ej0> weakReference = a.get(pi0Var.e());
            if (weakReference == null || (ej0Var = weakReference.get()) == null) {
                ej0 ej0Var2 = new ej0(pi0Var);
                a.put(pi0Var.e(), new WeakReference<>(ej0Var2));
                return ej0Var2;
            }
            return ej0Var;
        }
        return (ej0) invokeL.objValue;
    }

    public static void b(@NonNull pi0 pi0Var) {
        WeakReference<ej0> remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, pi0Var) == null) || (remove = a.remove(pi0Var.e())) == null) {
            return;
        }
        remove.clear();
    }
}
