package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ih9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, jSONObject)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str + "?");
            Iterator<String> keys = jSONObject.keys();
            boolean z = true;
            while (keys.hasNext()) {
                if (z) {
                    String next = keys.next();
                    if (next != null) {
                        sb.append(next + "=" + jSONObject.optString(next));
                        z = false;
                    }
                } else {
                    String next2 = keys.next();
                    if (next2 != null) {
                        sb.append("&");
                        sb.append(next2 + "=" + jSONObject.optString(next2));
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
