package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class ct3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, hashMap)) == null) {
            StringBuilder sb = new StringBuilder();
            if (hashMap != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append("&");
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("?code2=");
            ys3 ys3Var = new ys3();
            sb2.append(ys3Var.a(sb.toString() + "b" + System.currentTimeMillis() + "=1"));
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("&b" + System.currentTimeMillis());
            sb4.append("=");
            sb4.append("1");
            return sb3 + sb4.toString();
        }
        return (String) invokeLL.objValue;
    }
}
