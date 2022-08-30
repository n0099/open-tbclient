package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes4.dex */
public class fe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(ad adVar, fc fcVar) {
        InterceptResult invokeLL;
        Object b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, adVar, fcVar)) == null) {
            if (fcVar == null || adVar == null) {
                return false;
            }
            List<Field> b2 = dc.b(fcVar.getClass());
            Set<String> keys = adVar.getKeys();
            for (Field field : b2) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name)) {
                        if (keys.contains(name)) {
                            Object b3 = adVar.b(name, field.getGenericType());
                            if (b3 != null) {
                                dc.h(fcVar, name, b3);
                            }
                        } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                            Object b4 = adVar.b(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                            if (b4 != null) {
                                dc.h(fcVar, name, b4);
                            }
                        } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (b = adVar.b(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                            dc.h(fcVar, name, b);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
