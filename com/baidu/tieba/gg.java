package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class gg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1000;
            }
            if (str.contains("/excellent/personalized")) {
                return 1002;
            }
            if (!str.contains("/frs/generalTabList") && !str.contains("/frs/page") && !str.contains("/frs/threadlist")) {
                if (str.contains("/pb/page")) {
                    return 1004;
                }
                if (str.contains("/thread/add")) {
                    return 1005;
                }
                if (str.contains("/post/add")) {
                    return 1008;
                }
                return 1000;
            }
            return 1003;
        }
        return invokeL.intValue;
    }
}
