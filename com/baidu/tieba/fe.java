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
/* loaded from: classes5.dex */
public class fe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Object a(ArrayList<Object> arrayList, ge geVar) {
        InterceptResult invokeLL;
        Object a;
        Object a2;
        Object a3;
        Object a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, arrayList, geVar)) == null) {
            if (arrayList != null && geVar != null) {
                Class<?> a5 = geVar.a();
                Type[] b = geVar.b();
                int i = 0;
                if (a5.isArray()) {
                    Object newInstance = Array.newInstance(a5.getComponentType(), arrayList.size());
                    Iterator<Object> it = arrayList.iterator();
                    while (it.hasNext()) {
                        Object a6 = ke.a(it.next()).a(new ge(a5.getComponentType()));
                        if (a6 != null) {
                            Array.set(newInstance, i, a6);
                        }
                        i++;
                    }
                    return newInstance;
                } else if (nc.e(a5, List.class)) {
                    List<Object> a7 = ee.a(geVar, arrayList.size());
                    if (a7 != null) {
                        Iterator<Object> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            qd a8 = ke.a(it2.next());
                            if (b != null && b.length >= 1 && (a4 = a8.a(new ge(b[0]))) != null) {
                                a7.add(a4);
                            }
                        }
                    }
                    return a7;
                } else if (nc.e(a5, Queue.class)) {
                    Queue<Object> c = ee.c(geVar, arrayList.size());
                    if (c != null) {
                        Iterator<Object> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            qd a9 = ke.a(it3.next());
                            if (b != null && b.length >= 1 && (a3 = a9.a(new ge(b[0]))) != null) {
                                c.add(a3);
                            }
                        }
                    }
                    return c;
                } else if (nc.e(a5, Set.class)) {
                    Set<Object> d = ee.d(geVar, arrayList.size());
                    if (d != null) {
                        Iterator<Object> it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            qd a10 = ke.a(it4.next());
                            if (b != null && b.length >= 1 && (a2 = a10.a(new ge(b[0]))) != null) {
                                d.add(a2);
                            }
                        }
                    }
                    return d;
                } else if (nc.e(a5, Map.class)) {
                    Map<String, Object> b2 = ee.b(geVar, arrayList.size());
                    if (b2 != null) {
                        Iterator<Object> it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            qd a11 = ke.a(it5.next());
                            if (b != null && b.length >= 2) {
                                a = a11.a(new ge(b[1]));
                            } else {
                                a = a11.a(new ge(String.class));
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
                        qd a12 = ke.a(next);
                        if (b != null && b.length >= 1 && a12.a(new ge(b[0])) != null) {
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

    public static final Object b(Object obj, ge geVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, geVar)) == null) {
            if (obj == null || geVar == null || !obj.getClass().isArray()) {
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
            return a(arrayList, geVar);
        }
        return invokeLL.objValue;
    }

    public static final Object c(List<Object> list, ge geVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, geVar)) == null) {
            if (list != null && geVar != null) {
                ArrayList arrayList = new ArrayList(list.size());
                for (Object obj : list) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, geVar);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object d(Queue<Object> queue, ge geVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, queue, geVar)) == null) {
            if (queue != null && geVar != null) {
                ArrayList arrayList = new ArrayList(queue.size());
                for (Object obj : queue) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, geVar);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object e(Set<Object> set, ge geVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, set, geVar)) == null) {
            if (set != null && geVar != null) {
                ArrayList arrayList = new ArrayList(set.size());
                for (Object obj : set) {
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, geVar);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final Object f(SparseArray<Object> sparseArray, ge geVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sparseArray, geVar)) == null) {
            if (sparseArray != null && geVar != null) {
                ArrayList arrayList = new ArrayList(sparseArray.size());
                for (int i = 0; i < sparseArray.size(); i++) {
                    Object obj = sparseArray.get(sparseArray.keyAt(i));
                    if (obj != null) {
                        arrayList.add(obj);
                    }
                }
                return a(arrayList, geVar);
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
