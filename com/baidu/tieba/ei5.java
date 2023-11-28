package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ei5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<fi5> a(mi5 mi5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mi5Var)) == null) {
            if (mi5Var.c("\u0089PNG") && mi5Var.c("\r\n\u001a\n")) {
                ArrayList arrayList = new ArrayList();
                while (mi5Var.available() > 0) {
                    arrayList.add(b(mi5Var));
                }
                return arrayList;
            }
            throw new IOException("APNG Format error");
        }
        return (List) invokeL.objValue;
    }

    public static fi5 b(mi5 mi5Var) throws IOException {
        InterceptResult invokeL;
        fi5 fi5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mi5Var)) == null) {
            int position = mi5Var.position();
            int e = mi5Var.e();
            int d = mi5Var.d();
            if (d == bi5.d) {
                fi5Var = new bi5();
            } else if (d == gi5.k) {
                fi5Var = new gi5();
            } else if (d == hi5.c) {
                fi5Var = new hi5();
            } else if (d == ii5.c) {
                fi5Var = new ii5();
            } else if (d == ji5.c) {
                fi5Var = new ji5();
            } else if (d == ki5.f) {
                fi5Var = new ki5();
            } else {
                fi5Var = new fi5();
            }
            fi5Var.b = position;
            fi5Var.a = e;
            fi5Var.c(mi5Var);
            mi5Var.e();
            return fi5Var;
        }
        return (fi5) invokeL.objValue;
    }
}
