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
public class fe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(nc ncVar, gd gdVar) {
        InterceptResult invokeLL;
        vc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ncVar, gdVar)) == null) {
            if (ncVar != null && gdVar != null) {
                for (Field field : lc.b(ncVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = he.a(lc.d(ncVar, name))) != null) {
                            Object obj = null;
                            if (gdVar instanceof JsonDataSource) {
                                obj = a.f(new ee(field.getGenericType()));
                            } else if (gdVar instanceof BundleDataSource) {
                                obj = a.d(new ee(field.getGenericType()));
                            } else if (gdVar instanceof IntentDataSource) {
                                obj = a.e(new ee(field.getGenericType()));
                            } else if (gdVar instanceof MapDataSource) {
                                obj = a.b(new ee(field.getGenericType()));
                            } else if (gdVar instanceof CursorDataSource) {
                                obj = a.a(new ee(field.getGenericType()));
                            } else if (gdVar instanceof ProtobufDataSource) {
                                obj = a.c(new ee(field.getGenericType()));
                            }
                            if (obj != null) {
                                gdVar.set(name, obj);
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
