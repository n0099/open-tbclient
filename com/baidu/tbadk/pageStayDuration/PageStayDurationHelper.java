package com.baidu.tbadk.pageStayDuration;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PageStayDurationHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String STAT_SOURCE_TRACE_CONNECTORS = "_";
    public transient /* synthetic */ FieldHolder $fh;

    public PageStayDurationHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String toSourceTraceString(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.getCount(list) <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            for (String str : list) {
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

    public static List<String> trimToSize(List<String> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i)) == null) {
            int count = ListUtils.getCount(list);
            if (count > 0 && i >= 0 && count > i) {
                return new ArrayList(ListUtils.subList(list, count - i, count));
            }
            return list;
        }
        return (List) invokeLI.objValue;
    }
}
