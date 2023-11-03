package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public interface hb7 extends gb7 {
    String c(d57 d57Var);

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String b(hb7 hb7Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hb7Var)) == null) ? "" : (String) invokeL.objValue;
        }

        public static Map<String, String> a(hb7 hb7Var, d57 businessInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, hb7Var, businessInfo)) == null) {
                Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
                return new HashMap();
            }
            return (Map) invokeLL.objValue;
        }
    }
}
