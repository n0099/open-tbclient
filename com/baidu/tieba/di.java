package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class di {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302536, "Lcom/baidu/tieba/di;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302536, "Lcom/baidu/tieba/di;");
                return;
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("java.lang.String", "java.lang.String");
        a.put("java.lang.Integer", "java.lang.Integer");
        a.put("java.lang.Double", "java.lang.Double");
        a.put("java.lang.Float", "java.lang.Float");
        a.put("java.lang.Boolean", "java.lang.Boolean");
        a.put("java.lang.Character", "java.lang.Character");
        a.put("java.lang.Short", "java.lang.Short");
        a.put("java.lang.Long", "java.lang.Long");
        a.put("java.lang.Byte", "java.lang.Byte");
        a.put("java.util.Date", "java.util.Date");
        a.put("java.lang.Integer", "java.lang.Integer");
        a.put("java.lang.Integer", "java.lang.Integer");
    }

    public static Object a(Object obj, Field field) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, field)) == null) {
            Object obj2 = null;
            if (obj != null && field != null) {
                boolean isAccessible = field.isAccessible();
                field.setAccessible(true);
                try {
                    obj2 = field.get(obj);
                } catch (Throwable unused) {
                }
                field.setAccessible(isAccessible);
            }
            return obj2;
        }
        return invokeLL.objValue;
    }
}
