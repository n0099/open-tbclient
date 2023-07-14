package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ao6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SafeVarargs
    public static String a(Pair<String, String>... pairArr) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pairArr)) == null) {
            if (!xn6.e(pairArr)) {
                JSONObject jSONObject = new JSONObject();
                for (Pair<String, String> pair : pairArr) {
                    if (pair != null && (str = pair.first) != null) {
                        try {
                            jSONObject.put(str, pair.second);
                        } catch (Exception e) {
                            vn6.b("newHybrid", "toJsonStr err:" + e);
                        }
                    }
                }
                return jSONObject.toString();
            }
            return "{}";
        }
        return (String) invokeL.objValue;
    }
}
