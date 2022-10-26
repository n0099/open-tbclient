package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes3.dex */
public class ci0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, Map map, Map map2, String str2) {
        InterceptResult invokeLLLL;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, map, map2, str2)) == null) {
            if (map != null) {
                str3 = (String) map.get(str);
                if (TextUtils.isEmpty(str3)) {
                    str3 = (String) map.get("default");
                }
            } else {
                str3 = null;
            }
            if (!TextUtils.isEmpty(str3)) {
                str = str3;
            }
            if (map2 != null) {
                str4 = (String) map2.get(str);
            } else {
                str4 = null;
            }
            if (TextUtils.equals(str4, "__CMD_NONE__")) {
                return null;
            }
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
            return str2;
        }
        return (String) invokeLLLL.objValue;
    }
}
