package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes5.dex */
public class de {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<Object> a(fe feVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, feVar, i)) == null) {
            Class<?> a = feVar.a();
            if (a != List.class && a != ArrayList.class) {
                if (a == LinkedList.class) {
                    return new LinkedList();
                }
                Object h = mc.h(a, i);
                if (h == null) {
                    h = mc.g(a);
                }
                if (h instanceof List) {
                    return (List) h;
                }
                return null;
            }
            return new ArrayList(i);
        }
        return (List) invokeLI.objValue;
    }

    public static final Queue<Object> c(fe feVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, feVar, i)) == null) {
            Class<?> a = feVar.a();
            if (a == Queue.class) {
                return new LinkedList();
            }
            Object h = mc.h(a, i);
            if (h == null) {
                h = mc.g(a);
            }
            if (h instanceof Queue) {
                return (Queue) h;
            }
            return null;
        }
        return (Queue) invokeLI.objValue;
    }

    public static final Set<Object> d(fe feVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, feVar, i)) == null) {
            Class<?> a = feVar.a();
            if (a == Set.class) {
                return new HashSet();
            }
            Object h = mc.h(a, i);
            if (h == null) {
                h = mc.g(a);
            }
            if (h instanceof Set) {
                return (Set) h;
            }
            return null;
        }
        return (Set) invokeLI.objValue;
    }

    public static final Map<String, Object> b(fe feVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, feVar, i)) == null) {
            Class<?> a = feVar.a();
            Type[] b = feVar.b();
            if (!mc.e(a, Map.class)) {
                return null;
            }
            if (b != null && b.length >= 2 && b[0] == String.class) {
                if (a == Map.class) {
                    return new HashMap(i);
                }
                Object h = mc.h(a, i);
                if (h == null) {
                    h = mc.g(a);
                }
                if (!(h instanceof Map)) {
                    return null;
                }
                return (Map) h;
            } else if (a == Map.class) {
                return new HashMap(i);
            } else {
                Object h2 = mc.h(a, i);
                if (h2 == null) {
                    h2 = mc.g(a);
                }
                if (!(h2 instanceof Map)) {
                    return null;
                }
                return (Map) h2;
            }
        }
        return (Map) invokeLI.objValue;
    }
}
