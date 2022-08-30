package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class fc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(List<T> list, List<T> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, list, list2)) == null) {
            if (e(list2) || list == null) {
                return false;
            }
            return list.addAll(list2);
        }
        return invokeLL.booleanValue;
    }

    public static <T> int b(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }
        return invokeL.intValue;
    }

    public static <T> T c(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i)) == null) {
            if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
                return null;
            }
            return list.get(i);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> T d(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (T) c(list, list.size() - 1);
        }
        return (T) invokeL.objValue;
    }

    public static <T> boolean e(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) ? b(list) <= 0 : invokeL.booleanValue;
    }

    public static <T> boolean f(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) ? map == null || map.isEmpty() : invokeL.booleanValue;
    }

    public static <T> T g(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, list, i)) == null) {
            if (e(list) || list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return list.remove(i);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> void h(List<T> list, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65543, null, list, i, i2) == null) || e(list) || i < 0 || i2 < 0 || i > b(list) - 1 || i2 > b(list) - 1) {
            return;
        }
        Collections.swap(list, i, i2);
    }
}
