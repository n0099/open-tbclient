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

    public static r31 a(@NonNull hl0 hl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hl0Var)) == null) {
            r31 r31Var = new r31();
            r31Var.o(hl0Var.e());
            r31Var.u(hl0Var.b);
            r31Var.t(hl0Var.c.status);
            r31Var.q(hl0Var.d);
            r31Var.v(hl0Var.g);
            File file = hl0Var.h;
            if (file != null) {
                r31Var.m(file.getAbsolutePath());
            } else {
                r31Var.m("");
            }
            r31Var.r((int) (hl0Var.i * 1000.0f));
            r31Var.w((int) (hl0Var.j * 1000.0f));
            r31Var.s(hl0Var.l);
            r31Var.n(hl0Var.m);
            ll0 ll0Var = hl0Var.p;
            if (ll0Var != null) {
                r31Var.p(ll0.b(ll0Var));
            } else {
                r31Var.p("");
            }
            il0 il0Var = hl0Var.q;
            if (il0Var != null) {
                r31Var.k(il0.b(il0Var));
            } else {
                r31Var.k("");
            }
            kl0 kl0Var = hl0Var.r;
            if (kl0Var != null) {
                r31Var.l(kl0.b(kl0Var));
            } else {
                r31Var.l("");
            }
            return r31Var;
        }
        return (r31) invokeL.objValue;
    }

    public static hl0 b(@NonNull r31 r31Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, r31Var)) == null) {
            hl0 hl0Var = new hl0();
            hl0Var.h(r31Var.g());
            hl0Var.b = r31Var.z();
            hl0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == r31Var.y()) {
                    hl0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            hl0Var.d = r31Var.i();
            hl0Var.g = r31Var.A();
            if (!TextUtils.isEmpty(r31Var.e())) {
                hl0Var.h = new File(r31Var.e());
            }
            hl0Var.i = r31Var.j() / 1000.0f;
            hl0Var.j = r31Var.B() / 1000.0f;
            hl0Var.l = r31Var.x();
            hl0Var.m = r31Var.f();
            hl0Var.p = ll0.a(r31Var.h());
            hl0Var.q = il0.a(r31Var.c());
            hl0Var.r = kl0.a(r31Var.d());
            return hl0Var;
        }
        return (hl0) invokeL.objValue;
    }
}
