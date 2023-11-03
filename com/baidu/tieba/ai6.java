package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ai6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static yba a(mi6 mi6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mi6Var)) == null) {
            yba ybaVar = new yba();
            if (mi6Var != null) {
                ybaVar.b = mi6Var.c;
                ybaVar.e = mi6Var.g;
                ybaVar.f = mi6Var.i;
                ybaVar.c = mi6Var.d;
                if (!vj6.a(mi6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    ybaVar.a = arrayList;
                    arrayList.addAll(mi6Var.b);
                }
                if (!vj6.a(mi6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ybaVar.d = arrayList2;
                    arrayList2.addAll(mi6Var.f);
                }
            }
            return ybaVar;
        }
        return (yba) invokeL.objValue;
    }

    public static void b(hi6 hi6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, hi6Var, str) == null) {
            try {
                if (hi6Var != null) {
                    wba.n().z(str, hi6Var.b());
                    wba.n().x();
                    if (!vj6.b(hi6Var.a())) {
                        HashMap<String, yba> hashMap = new HashMap<>();
                        for (Map.Entry<String, mi6> entry : hi6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        xba.a().l(str, hashMap);
                    }
                    xba.a().h(true, str);
                    return;
                }
                wba.n().h(str);
                wba.n().x();
                xba.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
