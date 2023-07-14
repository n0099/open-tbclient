package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class fm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<gm5> a(nm5 nm5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nm5Var)) == null) {
            if (nm5Var.c("\u0089PNG") && nm5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (nm5Var.available() > 0) {
                    arrayList.add(b(nm5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static gm5 b(nm5 nm5Var) throws IOException {
        InterceptResult invokeL;
        gm5 gm5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nm5Var)) == null) {
            int position = nm5Var.position();
            int e = nm5Var.e();
            int d = nm5Var.d();
            if (d == cm5.d) {
                gm5Var = new cm5();
            } else if (d == hm5.k) {
                gm5Var = new hm5();
            } else if (d == im5.c) {
                gm5Var = new im5();
            } else if (d == jm5.c) {
                gm5Var = new jm5();
            } else if (d == km5.c) {
                gm5Var = new km5();
            } else if (d == lm5.f) {
                gm5Var = new lm5();
            } else {
                gm5Var = new gm5();
            }
            gm5Var.b = position;
            gm5Var.a = e;
            gm5Var.c(nm5Var);
            nm5Var.e();
            return gm5Var;
        }
        return (gm5) invokeL.objValue;
    }
}
