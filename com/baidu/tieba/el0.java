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
/* loaded from: classes4.dex */
public class el0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, WeakReference<fl0>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947738048, "Lcom/baidu/tieba/el0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947738048, "Lcom/baidu/tieba/el0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static fl0 a(@NonNull qk0 qk0Var) {
        InterceptResult invokeL;
        fl0 fl0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qk0Var)) == null) {
            WeakReference<fl0> weakReference = a.get(qk0Var.e());
            if (weakReference == null || (fl0Var = weakReference.get()) == null) {
                fl0 fl0Var2 = new fl0(qk0Var);
                a.put(qk0Var.e(), new WeakReference<>(fl0Var2));
                return fl0Var2;
            }
            return fl0Var;
        }
        return (fl0) invokeL.objValue;
    }

    public static void b(@NonNull qk0 qk0Var) {
        WeakReference<fl0> remove;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, qk0Var) == null) && (remove = a.remove(qk0Var.e())) != null) {
            remove.clear();
        }
    }
}
