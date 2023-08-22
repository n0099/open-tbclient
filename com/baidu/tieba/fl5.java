package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class fl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<gl5> a(nl5 nl5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nl5Var)) == null) {
            if (nl5Var.c("\u0089PNG") && nl5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (nl5Var.available() > 0) {
                    arrayList.add(b(nl5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static gl5 b(nl5 nl5Var) throws IOException {
        InterceptResult invokeL;
        gl5 gl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nl5Var)) == null) {
            int position = nl5Var.position();
            int e = nl5Var.e();
            int d = nl5Var.d();
            if (d == cl5.d) {
                gl5Var = new cl5();
            } else if (d == hl5.k) {
                gl5Var = new hl5();
            } else if (d == il5.c) {
                gl5Var = new il5();
            } else if (d == jl5.c) {
                gl5Var = new jl5();
            } else if (d == kl5.c) {
                gl5Var = new kl5();
            } else if (d == ll5.f) {
                gl5Var = new ll5();
            } else {
                gl5Var = new gl5();
            }
            gl5Var.b = position;
            gl5Var.a = e;
            gl5Var.c(nl5Var);
            nl5Var.e();
            return gl5Var;
        }
        return (gl5) invokeL.objValue;
    }
}
