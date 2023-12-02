package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<ii5> a(pi5 pi5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pi5Var)) == null) {
            if (pi5Var.c("\u0089PNG") && pi5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (pi5Var.available() > 0) {
                    arrayList.add(b(pi5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static ii5 b(pi5 pi5Var) throws IOException {
        InterceptResult invokeL;
        ii5 ii5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pi5Var)) == null) {
            int position = pi5Var.position();
            int e = pi5Var.e();
            int d = pi5Var.d();
            if (d == ei5.d) {
                ii5Var = new ei5();
            } else if (d == ji5.k) {
                ii5Var = new ji5();
            } else if (d == ki5.c) {
                ii5Var = new ki5();
            } else if (d == li5.c) {
                ii5Var = new li5();
            } else if (d == mi5.c) {
                ii5Var = new mi5();
            } else if (d == ni5.f) {
                ii5Var = new ni5();
            } else {
                ii5Var = new ii5();
            }
            ii5Var.b = position;
            ii5Var.a = e;
            ii5Var.c(pi5Var);
            pi5Var.e();
            return ii5Var;
        }
        return (ii5) invokeL.objValue;
    }
}
