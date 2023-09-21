package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class cm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<dm5> a(km5 km5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, km5Var)) == null) {
            if (km5Var.c("\u0089PNG") && km5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (km5Var.available() > 0) {
                    arrayList.add(b(km5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static dm5 b(km5 km5Var) throws IOException {
        InterceptResult invokeL;
        dm5 dm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, km5Var)) == null) {
            int position = km5Var.position();
            int e = km5Var.e();
            int d = km5Var.d();
            if (d == zl5.d) {
                dm5Var = new zl5();
            } else if (d == em5.k) {
                dm5Var = new em5();
            } else if (d == fm5.c) {
                dm5Var = new fm5();
            } else if (d == gm5.c) {
                dm5Var = new gm5();
            } else if (d == hm5.c) {
                dm5Var = new hm5();
            } else if (d == im5.f) {
                dm5Var = new im5();
            } else {
                dm5Var = new dm5();
            }
            dm5Var.b = position;
            dm5Var.a = e;
            dm5Var.c(km5Var);
            km5Var.e();
            return dm5Var;
        }
        return (dm5) invokeL.objValue;
    }
}
