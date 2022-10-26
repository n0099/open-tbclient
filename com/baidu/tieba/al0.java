package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class al0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947618884, "Lcom/baidu/tieba/al0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947618884, "Lcom/baidu/tieba/al0;");
                return;
            }
        }
        a = new HashMap();
    }

    public static bl0 a(mk0 mk0Var) {
        InterceptResult invokeL;
        bl0 bl0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mk0Var)) == null) {
            WeakReference weakReference = (WeakReference) a.get(mk0Var.e());
            if (weakReference == null || (bl0Var = (bl0) weakReference.get()) == null) {
                bl0 bl0Var2 = new bl0(mk0Var);
                a.put(mk0Var.e(), new WeakReference(bl0Var2));
                return bl0Var2;
            }
            return bl0Var;
        }
        return (bl0) invokeL.objValue;
    }

    public static void b(mk0 mk0Var) {
        WeakReference weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, mk0Var) == null) && (weakReference = (WeakReference) a.remove(mk0Var.e())) != null) {
            weakReference.clear();
        }
    }
}
