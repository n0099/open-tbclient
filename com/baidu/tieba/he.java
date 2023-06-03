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
/* loaded from: classes6.dex */
public class he {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final vc a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new qc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new fd((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new oc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new ed((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new xc((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new bd((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new zc((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new cd((Set) obj);
                                            }
                                            if (!lc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new ad((OrmObject) obj);
                                        }
                                        return new dd(((Short) obj).shortValue());
                                    }
                                    return new yc(((Long) obj).longValue());
                                }
                                return new wc(((Integer) obj).intValue());
                            }
                            return new uc(((Float) obj).floatValue());
                        }
                        return new tc(((Double) obj).doubleValue());
                    }
                    return new sc(((Character) obj).charValue());
                }
                return new rc(((Byte) obj).byteValue());
            }
            return new pc(((Boolean) obj).booleanValue());
        }
        return (vc) invokeL.objValue;
    }
}
