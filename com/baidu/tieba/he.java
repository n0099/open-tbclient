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
/* loaded from: classes6.dex */
public class he {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(pc pcVar, id idVar) {
        InterceptResult invokeLL;
        xc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, pcVar, idVar)) == null) {
            if (pcVar != null && idVar != null) {
                for (Field field : nc.b(pcVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = je.a(nc.d(pcVar, name))) != null) {
                            Object obj = null;
                            if (idVar instanceof JsonDataSource) {
                                obj = a.f(new ge(field.getGenericType()));
                            } else if (idVar instanceof BundleDataSource) {
                                obj = a.d(new ge(field.getGenericType()));
                            } else if (idVar instanceof IntentDataSource) {
                                obj = a.e(new ge(field.getGenericType()));
                            } else if (idVar instanceof MapDataSource) {
                                obj = a.b(new ge(field.getGenericType()));
                            } else if (idVar instanceof CursorDataSource) {
                                obj = a.a(new ge(field.getGenericType()));
                            } else if (idVar instanceof ProtobufDataSource) {
                                obj = a.c(new ge(field.getGenericType()));
                            }
                            if (obj != null) {
                                idVar.set(name, obj);
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
