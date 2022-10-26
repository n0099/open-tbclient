package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class fk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static g01 a(mk0 mk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mk0Var)) == null) {
            g01 g01Var = new g01();
            g01Var.o(mk0Var.e());
            g01Var.u(mk0Var.b);
            g01Var.t(mk0Var.c.status);
            g01Var.q(mk0Var.d);
            g01Var.v(mk0Var.g);
            File file = mk0Var.h;
            if (file != null) {
                g01Var.m(file.getAbsolutePath());
            } else {
                g01Var.m("");
            }
            g01Var.r((int) (mk0Var.i * 1000.0f));
            g01Var.w((int) (mk0Var.j * 1000.0f));
            g01Var.s(mk0Var.l);
            g01Var.n(mk0Var.m);
            qk0 qk0Var = mk0Var.p;
            if (qk0Var != null) {
                g01Var.p(qk0.b(qk0Var));
            } else {
                g01Var.p("");
            }
            nk0 nk0Var = mk0Var.q;
            if (nk0Var != null) {
                g01Var.k(nk0.b(nk0Var));
            } else {
                g01Var.k("");
            }
            pk0 pk0Var = mk0Var.r;
            if (pk0Var != null) {
                g01Var.l(pk0.b(pk0Var));
            } else {
                g01Var.l("");
            }
            return g01Var;
        }
        return (g01) invokeL.objValue;
    }

    public static mk0 b(g01 g01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g01Var)) == null) {
            mk0 mk0Var = new mk0();
            mk0Var.h(g01Var.g());
            mk0Var.b = g01Var.z();
            mk0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == g01Var.y()) {
                    mk0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            mk0Var.d = g01Var.i();
            mk0Var.g = g01Var.A();
            if (!TextUtils.isEmpty(g01Var.e())) {
                mk0Var.h = new File(g01Var.e());
            }
            mk0Var.i = g01Var.j() / 1000.0f;
            mk0Var.j = g01Var.B() / 1000.0f;
            mk0Var.l = g01Var.x();
            mk0Var.m = g01Var.f();
            mk0Var.p = qk0.a(g01Var.h());
            mk0Var.q = nk0.a(g01Var.c());
            mk0Var.r = pk0.a(g01Var.d());
            return mk0Var;
        }
        return (mk0) invokeL.objValue;
    }
}
