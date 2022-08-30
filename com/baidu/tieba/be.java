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
/* loaded from: classes3.dex */
public class be {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final List<Object> a(de deVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, deVar, i)) == null) {
            Class<?> a = deVar.a();
            if (a != List.class && a != ArrayList.class) {
                if (a == LinkedList.class) {
                    return new LinkedList();
                }
                Object g = dc.g(a, i);
                if (g == null) {
                    g = dc.f(a);
                }
                if (g instanceof List) {
                    return (List) g;
                }
                return null;
            }
            return new ArrayList(i);
        }
        return (List) invokeLI.objValue;
    }

    public static final Map<String, Object> b(de deVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, deVar, i)) == null) {
            Class<?> a = deVar.a();
            Type[] b = deVar.b();
            if (dc.e(a, Map.class)) {
                if (b != null && b.length >= 2 && b[0] == String.class) {
                    if (a == Map.class) {
                        return new HashMap(i);
                    }
                    Object g = dc.g(a, i);
                    if (g == null) {
                        g = dc.f(a);
                    }
                    if (g instanceof Map) {
                        return (Map) g;
                    }
                    return null;
                } else if (a == Map.class) {
                    return new HashMap(i);
                } else {
                    Object g2 = dc.g(a, i);
                    if (g2 == null) {
                        g2 = dc.f(a);
                    }
                    if (g2 instanceof Map) {
                        return (Map) g2;
                    }
                    return null;
                }
            }
            return null;
        }
        return (Map) invokeLI.objValue;
    }

    public static final Queue<Object> c(de deVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, deVar, i)) == null) {
            Class<?> a = deVar.a();
            if (a == Queue.class) {
                return new LinkedList();
            }
            Object g = dc.g(a, i);
            if (g == null) {
                g = dc.f(a);
            }
            if (g instanceof Queue) {
                return (Queue) g;
            }
            return null;
        }
        return (Queue) invokeLI.objValue;
    }

    public static final Set<Object> d(de deVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, deVar, i)) == null) {
            Class<?> a = deVar.a();
            if (a == Set.class) {
                return new HashSet();
            }
            Object g = dc.g(a, i);
            if (g == null) {
                g = dc.f(a);
            }
            if (g instanceof Set) {
                return (Set) g;
            }
            return null;
        }
        return (Set) invokeLI.objValue;
    }
}
