package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class el6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mr9 a(ol6 ol6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ol6Var)) == null) {
            mr9 mr9Var = new mr9();
            if (ol6Var != null) {
                mr9Var.b = ol6Var.c;
                mr9Var.e = ol6Var.g;
                mr9Var.f = ol6Var.i;
                mr9Var.c = ol6Var.d;
                if (!tm6.a(ol6Var.b)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    mr9Var.a = arrayList;
                    arrayList.addAll(ol6Var.b);
                }
                if (!tm6.a(ol6Var.f)) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    mr9Var.d = arrayList2;
                    arrayList2.addAll(ol6Var.f);
                }
            }
            return mr9Var;
        }
        return (mr9) invokeL.objValue;
    }

    public static void b(jl6 jl6Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, jl6Var, str) == null) {
            try {
                if (jl6Var != null) {
                    kr9.n().z(str, jl6Var.b());
                    kr9.n().x();
                    if (!tm6.b(jl6Var.a())) {
                        HashMap<String, mr9> hashMap = new HashMap<>();
                        for (Map.Entry<String, ol6> entry : jl6Var.a().entrySet()) {
                            hashMap.put(entry.getKey(), a(entry.getValue()));
                        }
                        lr9.a().l(str, hashMap);
                    }
                    lr9.a().h(true, str);
                    return;
                }
                kr9.n().h(str);
                kr9.n().x();
                lr9.a().f(str);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
