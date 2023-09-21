package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class al0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static u31 a(@NonNull hl0 hl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hl0Var)) == null) {
            u31 u31Var = new u31();
            u31Var.o(hl0Var.e());
            u31Var.u(hl0Var.b);
            u31Var.t(hl0Var.c.status);
            u31Var.q(hl0Var.d);
            u31Var.v(hl0Var.g);
            File file = hl0Var.h;
            if (file != null) {
                u31Var.m(file.getAbsolutePath());
            } else {
                u31Var.m("");
            }
            u31Var.r((int) (hl0Var.i * 1000.0f));
            u31Var.w((int) (hl0Var.j * 1000.0f));
            u31Var.s(hl0Var.l);
            u31Var.n(hl0Var.m);
            ll0 ll0Var = hl0Var.p;
            if (ll0Var != null) {
                u31Var.p(ll0.b(ll0Var));
            } else {
                u31Var.p("");
            }
            il0 il0Var = hl0Var.q;
            if (il0Var != null) {
                u31Var.k(il0.b(il0Var));
            } else {
                u31Var.k("");
            }
            kl0 kl0Var = hl0Var.r;
            if (kl0Var != null) {
                u31Var.l(kl0.b(kl0Var));
            } else {
                u31Var.l("");
            }
            return u31Var;
        }
        return (u31) invokeL.objValue;
    }

    public static hl0 b(@NonNull u31 u31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, u31Var)) == null) {
            hl0 hl0Var = new hl0();
            hl0Var.h(u31Var.g());
            hl0Var.b = u31Var.z();
            hl0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == u31Var.y()) {
                    hl0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            hl0Var.d = u31Var.i();
            hl0Var.g = u31Var.A();
            if (!TextUtils.isEmpty(u31Var.e())) {
                hl0Var.h = new File(u31Var.e());
            }
            hl0Var.i = u31Var.j() / 1000.0f;
            hl0Var.j = u31Var.B() / 1000.0f;
            hl0Var.l = u31Var.x();
            hl0Var.m = u31Var.f();
            hl0Var.p = ll0.a(u31Var.h());
            hl0Var.q = il0.a(u31Var.c());
            hl0Var.r = kl0.a(u31Var.d());
            return hl0Var;
        }
        return (hl0) invokeL.objValue;
    }
}
