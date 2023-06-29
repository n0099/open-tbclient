package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class gl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<hl5> a(ol5 ol5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ol5Var)) == null) {
            if (ol5Var.c("\u0089PNG") && ol5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (ol5Var.available() > 0) {
                    arrayList.add(b(ol5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static hl5 b(ol5 ol5Var) throws IOException {
        InterceptResult invokeL;
        hl5 hl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ol5Var)) == null) {
            int position = ol5Var.position();
            int e = ol5Var.e();
            int d = ol5Var.d();
            if (d == dl5.d) {
                hl5Var = new dl5();
            } else if (d == il5.k) {
                hl5Var = new il5();
            } else if (d == jl5.c) {
                hl5Var = new jl5();
            } else if (d == kl5.c) {
                hl5Var = new kl5();
            } else if (d == ll5.c) {
                hl5Var = new ll5();
            } else if (d == ml5.f) {
                hl5Var = new ml5();
            } else {
                hl5Var = new hl5();
            }
            hl5Var.b = position;
            hl5Var.a = e;
            hl5Var.c(ol5Var);
            ol5Var.e();
            return hl5Var;
        }
        return (hl5) invokeL.objValue;
    }
}
