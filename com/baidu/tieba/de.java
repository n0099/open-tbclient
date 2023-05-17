package com.baidu.tieba;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes5.dex */
public class de {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final rc a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new mc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new bd((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new kc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new ad((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new tc((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new xc((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new vc((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new yc((Set) obj);
                                            }
                                            if (!hc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new wc((OrmObject) obj);
                                        }
                                        return new zc(((Short) obj).shortValue());
                                    }
                                    return new uc(((Long) obj).longValue());
                                }
                                return new sc(((Integer) obj).intValue());
                            }
                            return new qc(((Float) obj).floatValue());
                        }
                        return new pc(((Double) obj).doubleValue());
                    }
                    return new oc(((Character) obj).charValue());
                }
                return new nc(((Byte) obj).byteValue());
            }
            return new lc(((Boolean) obj).booleanValue());
        }
        return (rc) invokeL.objValue;
    }
}
