package com.baidu.tieba;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes3.dex */
public class ce {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Object a(ArrayList<Object> arrayList, de deVar) {
        InterceptResult invokeLL;
        Object a;
        Object a2;
        Object a3;
        Object a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, arrayList, deVar)) == null) {
            if (arrayList != null && deVar != null) {
                Class<?> a5 = deVar.a();
                Type[] b = deVar.b();
                int i = 0;
                if (a5.isArray()) {
                    Object newInstance = Array.newInstance(a5.getComponentType(), arrayList.size());
                    Iterator<Object> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object a6 = he.a(it.next()).a(new de(a5.getComponentType()));
                        if (a6 != null) {
                            Array.set(newInstance, i, a6);
                        }
                        i++;
                    }
                    return newInstance;
                } else if (dc.e(a5, List.class)) {
                    List<Object> a7 = be.a(deVar, arrayList.size());
                    if (a7 != null) {
                        Iterator<Object> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            nd a8 = he.a(it2.next());
                            if (b != null && b.length >= 1 && (a4 = a8.a(new de(b[0]))) != null) {
                                a7.add(a4);
                            }
                        }
                    }
                    return a7;
                } else if (dc.e(a5, Queue.class)) {
                    Queue<Object> c = be.c(deVar, arrayList.size());
                    if (c != null) {
                        Iterator<Object> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            nd a9 = he.a(it3.next());
                            if (b != null && b.length >= 1 && (a3 = a9.a(new de(b[0]))) != null) {
                                c.add(a3);
                            }
                        }
                    }
                    return c;
                } else if (dc.e(a5, Set.class)) {
                    Set<Object> d = be.d(deVar, arrayList.size());
                    if (d != null) {
                        Iterator<Object> it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            nd a10 = he.a(it4.next());
                            if (b != null && b.length >= 1 && (a2 = a10.a(new de(b[0]))) != null) {
                                d.add(a2);
                            }
                        }
                    }
                    return d;
                } else if (dc.e(a5, Map.class)) {
                    Map<String, Object> b2 = be.b(deVar, arrayList.size());
                    if (b2 != null) {
                        Iterator<Object> it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            nd a11 = he.a(it5.next());
                            if (b != null && b.length >= 2) {
                                a = a11.a(new de(b[1]));
                            } else {
                                a = a11.a(new de(String.class));
                            }
                            if (a != null) {
                                b2.put(String.valueOf(i), a);
                            }
                            i++;
                        }
                    }
                    return b2;
                } else if (a5 == SparseArray.class) {
                    SparseArray sparseArray = new SparseArray();
                    Iterator<Object> it6 = arrayList.iterator();
                    int i2 = 0;
                    while (it6.hasNext()) {
                        Object next = it6.next();
                        nd a12 = he.a(next);
                        if (b != null && b.length >= 1 && a12.a(new de(b[0])) != null) {
                            sparseArray.put(i2, next);
                        }
                        i2++;
                    }
                    return sparseArray;
                } else if (a5 == Bundle.class) {
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object b(Object obj, de deVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, deVar)) == null) {
            if (obj == null || deVar == null || !obj.getClass().isArray()) {
                return null;
            }
            int length = Array.getLength(obj);
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    arrayList.add(obj2);
                }
            }
            return a(arrayList, deVar);
        }
        return invokeLL.objValue;
    }

    public static final Object c(List<Object> list, de deVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, deVar)) == null) {
            if (list == null || deVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj : list) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, deVar);
        }
        return invokeLL.objValue;
    }

    public static final Object d(Queue<Object> queue, de deVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, queue, deVar)) == null) {
            if (queue == null || deVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(queue.size());
            for (Object obj : queue) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, deVar);
        }
        return invokeLL.objValue;
    }

    public static final Object e(Set<Object> set, de deVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, set, deVar)) == null) {
            if (set == null || deVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(set.size());
            for (Object obj : set) {
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, deVar);
        }
        return invokeLL.objValue;
    }

    public static final Object f(SparseArray<Object> sparseArray, de deVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sparseArray, deVar)) == null) {
            if (sparseArray == null || deVar == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(sparseArray.size());
            for (int i = 0; i < sparseArray.size(); i++) {
                Object obj = sparseArray.get(sparseArray.keyAt(i));
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            return a(arrayList, deVar);
        }
        return invokeLL.objValue;
    }
}
