package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ao2 {
    public static /* synthetic */ Interceptable $ic;
    public static final bo2[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947621829, "Lcom/baidu/tieba/ao2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947621829, "Lcom/baidu/tieba/ao2;");
                return;
            }
        }
        a = new bo2[]{new yn2(), new zn2()};
    }

    public static String a() {
        InterceptResult invokeV;
        bo2[] bo2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            StringBuilder sb = new StringBuilder();
            for (bo2 bo2Var : a) {
                sb.append(bo2Var.b());
                sb.append(bo2Var.enable() ? 1 : 0);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static List b() {
        InterceptResult invokeV;
        bo2[] bo2VarArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            for (bo2 bo2Var : a) {
                if (bo2Var.enable()) {
                    arrayList.add(bo2Var);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
