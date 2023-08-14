package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public interface aa7 extends z97 {
    String c(m57 m57Var);

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String b(aa7 aa7Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aa7Var)) == null) ? "" : (String) invokeL.objValue;
        }

        public static Map<String, String> a(aa7 aa7Var, m57 businessInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, aa7Var, businessInfo)) == null) {
                Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
                return new HashMap();
            }
            return (Map) invokeLL.objValue;
        }
    }
}
