package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class bd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!StringUtils.isNull(str)) {
                    if (!z && !StringUtils.isNull(sb.toString())) {
                        z = true;
                    }
                    if (z) {
                        sb.append("_");
                    }
                    sb.append(str);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List b(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i)) == null) {
            int count = ListUtils.getCount(list);
            if (count > 0 && i >= 0 && count > i) {
                return new ArrayList(ListUtils.subList(list, count - i, count));
            }
            return list;
        }
        return (List) invokeLI.objValue;
    }
}
