package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class bi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static zba a(ni6 ni6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ni6Var)) == null) {
            zba zbaVar = new zba();
            if (ni6Var != null) {
                zbaVar.b = ni6Var.c;
                zbaVar.e = ni6Var.g;
                zbaVar.f = ni6Var.i;
                zbaVar.c = ni6Var.d;
                if (!wj6.a(ni6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    zbaVar.a = arrayList;
                    arrayList.addAll(ni6Var.b);
                }
                if (!wj6.a(ni6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    zbaVar.d = arrayList2;
                    arrayList2.addAll(ni6Var.f);
                }
            }
            return zbaVar;
        }
        return (zba) invokeL.objValue;
    }

    public static void b(ii6 ii6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ii6Var, str) == null) {
            try {
                if (ii6Var != null) {
                    xba.n().z(str, ii6Var.b());
                    xba.n().x();
                    if (!wj6.b(ii6Var.a())) {
                        HashMap<String, zba> hashMap = new HashMap<>();
                        for (Map.Entry<String, ni6> entry : ii6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        yba.a().l(str, hashMap);
                    }
                    yba.a().h(true, str);
                    return;
                }
                xba.n().h(str);
                xba.n().x();
                yba.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
