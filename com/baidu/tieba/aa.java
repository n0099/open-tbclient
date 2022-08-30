package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(LinkedList<ca> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkedList)) == null) {
            if (linkedList == null) {
                return false;
            }
            Iterator<ca> it = linkedList.iterator();
            while (it.hasNext()) {
                ca next = it.next();
                if (next != null && next.i()) {
                    next.g();
                    if (next.o() >= next.l()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void b(LinkedList<ca> linkedList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, linkedList) == null) || linkedList == null) {
            return;
        }
        Iterator<ca> it = linkedList.iterator();
        while (it.hasNext()) {
            ca next = it.next();
            if (next != null) {
                next.j();
            }
        }
    }

    public static boolean c(LinkedList<ca> linkedList, int i, BdUniqueId bdUniqueId) {
        InterceptResult invokeLIL;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, linkedList, i, bdUniqueId)) == null) {
            Iterator<ca> it = linkedList.iterator();
            while (it.hasNext()) {
                ca next = it.next();
                if (next != null && (m = next.m()) != null) {
                    if (i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) {
                        return true;
                    }
                    if (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean d(LinkedList<ca> linkedList, y9 y9Var, int i) {
        InterceptResult invokeLLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, linkedList, y9Var, i)) == null) {
            if (y9Var == null) {
                return false;
            }
            Iterator<ca> it = linkedList.iterator();
            while (it.hasNext()) {
                ca next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i && y9Var.onFindMessage(m)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean e(LinkedList<ca> linkedList, int i) {
        InterceptResult invokeLI;
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, linkedList, i)) == null) {
            Iterator<ca> it = linkedList.iterator();
            while (it.hasNext()) {
                ca next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static ca f(LinkedList<ca> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.peek();
        }
        return (ca) invokeL.objValue;
    }

    public static int g(ca caVar, LinkedList<ca> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, caVar, linkedList)) == null) {
            if (caVar == null || linkedList == null) {
                return -1;
            }
            int size = linkedList.size();
            int i = 0;
            while (i < size && linkedList.get(i).n() <= caVar.n()) {
                i++;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static boolean h(ca caVar, LinkedList<ca> linkedList) {
        InterceptResult invokeLL;
        int g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, caVar, linkedList)) == null) {
            if (caVar == null || linkedList == null || (g = g(caVar, linkedList)) < 0 || g > linkedList.size()) {
                return false;
            }
            linkedList.add(g, caVar);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(LinkedList<ca> linkedList, LinkedList<ca> linkedList2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, null, linkedList, linkedList2)) != null) {
            return invokeLL.booleanValue;
        }
        if (linkedList == null || linkedList2 == null || linkedList2.size() <= 0) {
            return false;
        }
        while (true) {
            ca poll = linkedList2.poll();
            if (poll == null) {
                return true;
            }
            h(poll, linkedList);
        }
    }

    public static boolean j(LinkedList<ca> linkedList, LinkedList<ca> linkedList2, ca caVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, linkedList, linkedList2, caVar)) == null) {
            if (caVar == null || linkedList == null || linkedList2 == null || !linkedList.remove(caVar)) {
                return false;
            }
            linkedList2.add(caVar);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static ca k(LinkedList<ca> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<ca> it = linkedList.iterator();
            while (it.hasNext()) {
                ca next = it.next();
                if (next != null && !next.i()) {
                    it.remove();
                    return next;
                }
            }
            return null;
        }
        return (ca) invokeL.objValue;
    }

    public static ca l(LinkedList<ca> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, linkedList)) == null) {
            if (linkedList == null || linkedList.size() <= 0) {
                return null;
            }
            return linkedList.poll();
        }
        return (ca) invokeL.objValue;
    }

    public static void m(LinkedList<ca> linkedList, int i, BdUniqueId bdUniqueId) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65548, null, linkedList, i, bdUniqueId) == null) || linkedList == null) {
            return;
        }
        Iterator<ca> it = linkedList.iterator();
        while (it.hasNext()) {
            ca next = it.next();
            if (next != null && (m = next.m()) != null && ((i != 0 && m.getTag() == bdUniqueId && i == m.getCmd()) || (i == 0 && bdUniqueId != null && m.getTag() == bdUniqueId))) {
                it.remove();
                next.w();
            }
        }
    }

    public static boolean n(ca caVar, LinkedList<ca> linkedList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, caVar, linkedList)) == null) {
            if (caVar == null || linkedList == null) {
                return false;
            }
            return linkedList.remove(caVar);
        }
        return invokeLL.booleanValue;
    }

    public static void o(LinkedList<ca> linkedList, int i) {
        SocketMessage m;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65550, null, linkedList, i) == null) {
            Iterator<ca> it = linkedList.iterator();
            while (it.hasNext()) {
                ca next = it.next();
                if (next != null && (m = next.m()) != null && m.getCmd() == i) {
                    it.remove();
                }
            }
        }
    }

    public static ca p(int i, LinkedList<ca> linkedList) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i, linkedList)) == null) {
            if (linkedList == null) {
                return null;
            }
            Iterator<ca> it = linkedList.iterator();
            while (it.hasNext()) {
                ca next = it.next();
                if (next != null && next.q() == i) {
                    it.remove();
                    next.w();
                    return next;
                }
            }
            return null;
        }
        return (ca) invokeIL.objValue;
    }

    public static int q(LinkedList<ca> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, linkedList)) == null) {
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeL.intValue;
    }
}
