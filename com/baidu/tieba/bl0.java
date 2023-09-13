package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class bl0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static v31 a(@NonNull il0 il0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, il0Var)) == null) {
            v31 v31Var = new v31();
            v31Var.o(il0Var.e());
            v31Var.u(il0Var.b);
            v31Var.t(il0Var.c.status);
            v31Var.q(il0Var.d);
            v31Var.v(il0Var.g);
            File file = il0Var.h;
            if (file != null) {
                v31Var.m(file.getAbsolutePath());
            } else {
                v31Var.m("");
            }
            v31Var.r((int) (il0Var.i * 1000.0f));
            v31Var.w((int) (il0Var.j * 1000.0f));
            v31Var.s(il0Var.l);
            v31Var.n(il0Var.m);
            ml0 ml0Var = il0Var.p;
            if (ml0Var != null) {
                v31Var.p(ml0.b(ml0Var));
            } else {
                v31Var.p("");
            }
            jl0 jl0Var = il0Var.q;
            if (jl0Var != null) {
                v31Var.k(jl0.b(jl0Var));
            } else {
                v31Var.k("");
            }
            ll0 ll0Var = il0Var.r;
            if (ll0Var != null) {
                v31Var.l(ll0.b(ll0Var));
            } else {
                v31Var.l("");
            }
            return v31Var;
        }
        return (v31) invokeL.objValue;
    }

    public static il0 b(@NonNull v31 v31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, v31Var)) == null) {
            il0 il0Var = new il0();
            il0Var.h(v31Var.g());
            il0Var.b = v31Var.z();
            il0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == v31Var.y()) {
                    il0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            il0Var.d = v31Var.i();
            il0Var.g = v31Var.A();
            if (!TextUtils.isEmpty(v31Var.e())) {
                il0Var.h = new File(v31Var.e());
            }
            il0Var.i = v31Var.j() / 1000.0f;
            il0Var.j = v31Var.B() / 1000.0f;
            il0Var.l = v31Var.x();
            il0Var.m = v31Var.f();
            il0Var.p = ml0.a(v31Var.h());
            il0Var.q = jl0.a(v31Var.c());
            il0Var.r = ll0.a(v31Var.d());
            return il0Var;
        }
        return (il0) invokeL.objValue;
    }
}
