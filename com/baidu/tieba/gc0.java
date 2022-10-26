package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class gc0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                return list.size();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean c(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (a(list) <= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Object b(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i)) == null) {
            if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
                return null;
            }
            return list.get(i);
        }
        return invokeLI.objValue;
    }
}
