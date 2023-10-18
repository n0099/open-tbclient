package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ig5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<jg5> a(qg5 qg5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qg5Var)) == null) {
            if (qg5Var.c("\u0089PNG") && qg5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (qg5Var.available() > 0) {
                    arrayList.add(b(qg5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static jg5 b(qg5 qg5Var) throws IOException {
        InterceptResult invokeL;
        jg5 jg5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qg5Var)) == null) {
            int position = qg5Var.position();
            int e = qg5Var.e();
            int d = qg5Var.d();
            if (d == fg5.d) {
                jg5Var = new fg5();
            } else if (d == kg5.k) {
                jg5Var = new kg5();
            } else if (d == lg5.c) {
                jg5Var = new lg5();
            } else if (d == mg5.c) {
                jg5Var = new mg5();
            } else if (d == ng5.c) {
                jg5Var = new ng5();
            } else if (d == og5.f) {
                jg5Var = new og5();
            } else {
                jg5Var = new jg5();
            }
            jg5Var.b = position;
            jg5Var.a = e;
            jg5Var.c(qg5Var);
            qg5Var.e();
            return jg5Var;
        }
        return (jg5) invokeL.objValue;
    }
}
