package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class ii0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static gy0 a(@NonNull pi0 pi0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pi0Var)) == null) {
            gy0 gy0Var = new gy0();
            gy0Var.h(pi0Var.e());
            gy0Var.n(pi0Var.b);
            gy0Var.m(pi0Var.c.status);
            gy0Var.j(pi0Var.d);
            gy0Var.o(pi0Var.g);
            File file = pi0Var.h;
            if (file != null) {
                gy0Var.f(file.getAbsolutePath());
            } else {
                gy0Var.f("");
            }
            gy0Var.k((int) (pi0Var.i * 1000.0f));
            gy0Var.p((int) (pi0Var.j * 1000.0f));
            gy0Var.l(pi0Var.l);
            gy0Var.g(pi0Var.m);
            ti0 ti0Var = pi0Var.p;
            if (ti0Var != null) {
                gy0Var.i(ti0.a(ti0Var));
            } else {
                gy0Var.i("");
            }
            qi0 qi0Var = pi0Var.q;
            if (qi0Var != null) {
                gy0Var.d(qi0.a(qi0Var));
            } else {
                gy0Var.d("");
            }
            si0 si0Var = pi0Var.r;
            if (si0Var != null) {
                gy0Var.e(si0.a(si0Var));
            } else {
                gy0Var.e("");
            }
            return gy0Var;
        }
        return (gy0) invokeL.objValue;
    }
}
