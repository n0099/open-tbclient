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
public class ge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(oc ocVar, hd hdVar) {
        InterceptResult invokeLL;
        wc a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, ocVar, hdVar)) == null) {
            if (ocVar != null && hdVar != null) {
                for (Field field : mc.b(ocVar.getClass())) {
                    if (field != null && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        if (!TextUtils.isEmpty(name) && (a = ie.a(mc.d(ocVar, name))) != null) {
                            Object obj = null;
                            if (hdVar instanceof JsonDataSource) {
                                obj = a.f(new fe(field.getGenericType()));
                            } else if (hdVar instanceof BundleDataSource) {
                                obj = a.d(new fe(field.getGenericType()));
                            } else if (hdVar instanceof IntentDataSource) {
                                obj = a.e(new fe(field.getGenericType()));
                            } else if (hdVar instanceof MapDataSource) {
                                obj = a.b(new fe(field.getGenericType()));
                            } else if (hdVar instanceof CursorDataSource) {
                                obj = a.a(new fe(field.getGenericType()));
                            } else if (hdVar instanceof ProtobufDataSource) {
                                obj = a.c(new fe(field.getGenericType()));
                            }
                            if (obj != null) {
                                hdVar.set(name, obj);
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
