package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class eg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ty9 a(qg6 qg6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qg6Var)) == null) {
            ty9 ty9Var = new ty9();
            if (qg6Var != null) {
                ty9Var.b = qg6Var.c;
                ty9Var.e = qg6Var.g;
                ty9Var.f = qg6Var.i;
                ty9Var.c = qg6Var.d;
                if (!zh6.a(qg6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ty9Var.a = arrayList;
                    arrayList.addAll(qg6Var.b);
                }
                if (!zh6.a(qg6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ty9Var.d = arrayList2;
                    arrayList2.addAll(qg6Var.f);
                }
            }
            return ty9Var;
        }
        return (ty9) invokeL.objValue;
    }

    public static void b(lg6 lg6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, lg6Var, str) == null) {
            try {
                if (lg6Var != null) {
                    ry9.n().z(str, lg6Var.b());
                    ry9.n().x();
                    if (!zh6.b(lg6Var.a())) {
                        HashMap<String, ty9> hashMap = new HashMap<>();
                        for (Map.Entry<String, qg6> entry : lg6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        sy9.a().l(str, hashMap);
                    }
                    sy9.a().h(true, str);
                    return;
                }
                ry9.n().h(str);
                ry9.n().x();
                sy9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
