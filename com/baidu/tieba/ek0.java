package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class ek0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static x01 a(@NonNull lk0 lk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lk0Var)) == null) {
            x01 x01Var = new x01();
            x01Var.o(lk0Var.e());
            x01Var.u(lk0Var.b);
            x01Var.t(lk0Var.c.status);
            x01Var.q(lk0Var.d);
            x01Var.v(lk0Var.g);
            File file = lk0Var.h;
            if (file != null) {
                x01Var.m(file.getAbsolutePath());
            } else {
                x01Var.m("");
            }
            x01Var.r((int) (lk0Var.i * 1000.0f));
            x01Var.w((int) (lk0Var.j * 1000.0f));
            x01Var.s(lk0Var.l);
            x01Var.n(lk0Var.m);
            pk0 pk0Var = lk0Var.p;
            if (pk0Var != null) {
                x01Var.p(pk0.b(pk0Var));
            } else {
                x01Var.p("");
            }
            mk0 mk0Var = lk0Var.q;
            if (mk0Var != null) {
                x01Var.k(mk0.b(mk0Var));
            } else {
                x01Var.k("");
            }
            ok0 ok0Var = lk0Var.r;
            if (ok0Var != null) {
                x01Var.l(ok0.b(ok0Var));
            } else {
                x01Var.l("");
            }
            return x01Var;
        }
        return (x01) invokeL.objValue;
    }

    public static lk0 b(@NonNull x01 x01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, x01Var)) == null) {
            lk0 lk0Var = new lk0();
            lk0Var.h(x01Var.g());
            lk0Var.b = x01Var.z();
            lk0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == x01Var.y()) {
                    lk0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            lk0Var.d = x01Var.i();
            lk0Var.g = x01Var.A();
            if (!TextUtils.isEmpty(x01Var.e())) {
                lk0Var.h = new File(x01Var.e());
            }
            lk0Var.i = x01Var.j() / 1000.0f;
            lk0Var.j = x01Var.B() / 1000.0f;
            lk0Var.l = x01Var.x();
            lk0Var.m = x01Var.f();
            lk0Var.p = pk0.a(x01Var.h());
            lk0Var.q = mk0.a(x01Var.c());
            lk0Var.r = ok0.a(x01Var.d());
            return lk0Var;
        }
        return (lk0) invokeL.objValue;
    }
}
