package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmName;
@JvmName(name = "LayerUtils")
/* loaded from: classes3.dex */
public final class a01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947561255, "Lcom/baidu/tieba/a01;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947561255, "Lcom/baidu/tieba/a01;");
                return;
            }
        }
        v41.a(253.0f);
        v41.a(9.0f);
    }

    public static final dx0 a(ArrayList<zw0> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<zw0> it = arrayList.iterator();
                while (it.hasNext()) {
                    zw0 next = it.next();
                    if (next instanceof dx0) {
                        return (dx0) next;
                    }
                }
                return null;
            }
            return null;
        }
        return (dx0) invokeL.objValue;
    }
}
