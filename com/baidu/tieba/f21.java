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
/* loaded from: classes5.dex */
public final class f21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947712132, "Lcom/baidu/tieba/f21;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947712132, "Lcom/baidu/tieba/f21;");
                return;
            }
        }
        z71.a(253.0f);
        z71.a(9.0f);
    }

    public static final jz0 a(ArrayList<fz0> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<fz0> it = arrayList.iterator();
                while (it.hasNext()) {
                    fz0 next = it.next();
                    if (next instanceof jz0) {
                        return (jz0) next;
                    }
                }
                return null;
            }
            return null;
        }
        return (jz0) invokeL.objValue;
    }
}
