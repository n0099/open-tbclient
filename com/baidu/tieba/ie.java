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
/* loaded from: classes6.dex */
public class ie {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(id idVar, pc pcVar) {
        InterceptResult invokeLL;
        Object objectByType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, idVar, pcVar)) == null) {
            if (pcVar != null && idVar != null) {
                List<Field> b = nc.b(pcVar.getClass());
                Set<String> keys = idVar.getKeys();
                for (Field field : b) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (keys.contains(name)) {
                                Object objectByType2 = idVar.getObjectByType(name, field.getGenericType());
                                if (objectByType2 != null) {
                                    nc.i(pcVar, name, objectByType2);
                                }
                            } else if (keys.contains(name.toLowerCase(Locale.getDefault()))) {
                                Object objectByType3 = idVar.getObjectByType(name.toLowerCase(Locale.getDefault()), field.getGenericType());
                                if (objectByType3 != null) {
                                    nc.i(pcVar, name, objectByType3);
                                }
                            } else if (keys.contains(name.toUpperCase(Locale.getDefault())) && (objectByType = idVar.getObjectByType(name.toUpperCase(Locale.getDefault()), field.getGenericType())) != null) {
                                nc.i(pcVar, name, objectByType);
                            }
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
