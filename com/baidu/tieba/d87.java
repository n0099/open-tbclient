package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class d87 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, z87> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947658502, "Lcom/baidu/tieba/d87;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947658502, "Lcom/baidu/tieba/d87;");
                return;
            }
        }
        HashMap<String, z87> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("feed", new mr6());
        a.put("recommend_banner", new nr6());
        a.put("fake_wall", new lr6());
        a.put("ala_live_attention", new jr6());
        a.put("browse_location", new kr6());
        a.put("sideway", new or6());
    }

    public static HashMap<String, z87> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (HashMap) invokeV.objValue;
    }
}
