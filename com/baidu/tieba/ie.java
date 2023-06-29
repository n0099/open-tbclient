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
public class ie {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final wc a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            if (cls != Boolean.TYPE && cls != Boolean.class) {
                if (cls == Bundle.class) {
                    return new rc((Bundle) obj);
                }
                if (cls != Byte.TYPE && cls != Byte.class) {
                    if (cls != Character.TYPE && cls != Character.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Float.TYPE && cls != Float.class) {
                                if (cls != Integer.TYPE && cls != Integer.class) {
                                    if (cls != Long.TYPE && cls != Long.class) {
                                        if (cls != Short.TYPE && cls != Short.class) {
                                            if (cls == String.class) {
                                                return new gd((String) obj);
                                            }
                                            if (cls.isArray()) {
                                                return new pc(obj);
                                            }
                                            if (cls == SparseArray.class) {
                                                return new fd((SparseArray) obj);
                                            }
                                            if (obj instanceof List) {
                                                return new yc((List) obj);
                                            }
                                            if (obj instanceof Queue) {
                                                return new cd((Queue) obj);
                                            }
                                            if (obj instanceof Map) {
                                                return new ad((Map) obj);
                                            }
                                            if (obj instanceof Set) {
                                                return new dd((Set) obj);
                                            }
                                            if (!mc.e(cls, OrmObject.class)) {
                                                return null;
                                            }
                                            return new bd((OrmObject) obj);
                                        }
                                        return new ed(((Short) obj).shortValue());
                                    }
                                    return new zc(((Long) obj).longValue());
                                }
                                return new xc(((Integer) obj).intValue());
                            }
                            return new vc(((Float) obj).floatValue());
                        }
                        return new uc(((Double) obj).doubleValue());
                    }
                    return new tc(((Character) obj).charValue());
                }
                return new sc(((Byte) obj).byteValue());
            }
            return new qc(((Boolean) obj).booleanValue());
        }
        return (wc) invokeL.objValue;
    }
}
