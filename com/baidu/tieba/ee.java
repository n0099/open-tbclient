package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes3.dex */
public class ee {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(fc fcVar, ad adVar) {
        InterceptResult invokeLL;
        nc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, fcVar, adVar)) == null) {
            if (fcVar == null || adVar == null) {
                return false;
            }
            for (Field field : dc.b(fcVar.getClass())) {
                if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    String name = field.getName();
                    if (!TextUtils.isEmpty(name) && (a = ge.a(dc.d(fcVar, name))) != null) {
                        Object obj = null;
                        if (adVar instanceof cd) {
                            obj = a.f(new de(field.getGenericType()));
                        } else if (adVar instanceof yc) {
                            obj = a.d(new de(field.getGenericType()));
                        } else if (adVar instanceof bd) {
                            obj = a.e(new de(field.getGenericType()));
                        } else if (adVar instanceof dd) {
                            obj = a.b(new de(field.getGenericType()));
                        } else if (adVar instanceof zc) {
                            obj = a.a(new de(field.getGenericType()));
                        } else if (adVar instanceof ed) {
                            obj = a.c(new de(field.getGenericType()));
                        }
                        if (obj != null) {
                            adVar.a(name, obj);
                        }
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
