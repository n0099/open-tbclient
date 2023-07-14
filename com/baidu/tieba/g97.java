package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class g97 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, ca7> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748836, "Lcom/baidu/tieba/g97;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748836, "Lcom/baidu/tieba/g97;");
                return;
            }
        }
        HashMap<String, ca7> hashMap = new HashMap<>();
        a = hashMap;
        hashMap.put("feed", new vs6());
        a.put("recommend_banner", new ws6());
        a.put("fake_wall", new us6());
        a.put("ala_live_attention", new ss6());
        a.put("browse_location", new ts6());
        a.put("sideway", new xs6());
    }

    public static HashMap<String, ca7> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (HashMap) invokeV.objValue;
    }
}
