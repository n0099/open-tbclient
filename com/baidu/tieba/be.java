package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.BundleDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.CursorDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.IntentDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.JsonDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.MapDataSource;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.source.ProtobufDataSource;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
public class be {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(jc jcVar, cd cdVar) {
        InterceptResult invokeLL;
        rc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jcVar, cdVar)) == null) {
            if (jcVar != null && cdVar != null) {
                for (Field field : hc.b(jcVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = de.a(hc.d(jcVar, name))) != null) {
                            Object obj = null;
                            if (cdVar instanceof JsonDataSource) {
                                obj = a.f(new ae(field.getGenericType()));
                            } else if (cdVar instanceof BundleDataSource) {
                                obj = a.d(new ae(field.getGenericType()));
                            } else if (cdVar instanceof IntentDataSource) {
                                obj = a.e(new ae(field.getGenericType()));
                            } else if (cdVar instanceof MapDataSource) {
                                obj = a.b(new ae(field.getGenericType()));
                            } else if (cdVar instanceof CursorDataSource) {
                                obj = a.a(new ae(field.getGenericType()));
                            } else if (cdVar instanceof ProtobufDataSource) {
                                obj = a.c(new ae(field.getGenericType()));
                            }
                            if (obj != null) {
                                cdVar.set(name, obj);
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
