package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class cl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<dl5> a(kl5 kl5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, kl5Var)) == null) {
            if (kl5Var.c("\u0089PNG") && kl5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (kl5Var.available() > 0) {
                    arrayList.add(b(kl5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static dl5 b(kl5 kl5Var) throws IOException {
        InterceptResult invokeL;
        dl5 dl5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kl5Var)) == null) {
            int position = kl5Var.position();
            int e = kl5Var.e();
            int d = kl5Var.d();
            if (d == zk5.d) {
                dl5Var = new zk5();
            } else if (d == el5.k) {
                dl5Var = new el5();
            } else if (d == fl5.c) {
                dl5Var = new fl5();
            } else if (d == gl5.c) {
                dl5Var = new gl5();
            } else if (d == hl5.c) {
                dl5Var = new hl5();
            } else if (d == il5.f) {
                dl5Var = new il5();
            } else {
                dl5Var = new dl5();
            }
            dl5Var.b = position;
            dl5Var.a = e;
            dl5Var.c(kl5Var);
            kl5Var.e();
            return dl5Var;
        }
        return (dl5) invokeL.objValue;
    }
}
