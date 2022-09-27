package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class ek0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static f01 a(@NonNull lk0 lk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lk0Var)) == null) {
            f01 f01Var = new f01();
            f01Var.o(lk0Var.e());
            f01Var.u(lk0Var.b);
            f01Var.t(lk0Var.c.status);
            f01Var.q(lk0Var.d);
            f01Var.v(lk0Var.g);
            File file = lk0Var.h;
            if (file != null) {
                f01Var.m(file.getAbsolutePath());
            } else {
                f01Var.m("");
            }
            f01Var.r((int) (lk0Var.i * 1000.0f));
            f01Var.w((int) (lk0Var.j * 1000.0f));
            f01Var.s(lk0Var.l);
            f01Var.n(lk0Var.m);
            pk0 pk0Var = lk0Var.p;
            if (pk0Var != null) {
                f01Var.p(pk0.b(pk0Var));
            } else {
                f01Var.p("");
            }
            mk0 mk0Var = lk0Var.q;
            if (mk0Var != null) {
                f01Var.k(mk0.b(mk0Var));
            } else {
                f01Var.k("");
            }
            ok0 ok0Var = lk0Var.r;
            if (ok0Var != null) {
                f01Var.l(ok0.b(ok0Var));
            } else {
                f01Var.l("");
            }
            return f01Var;
        }
        return (f01) invokeL.objValue;
    }

    public static lk0 b(@NonNull f01 f01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, f01Var)) == null) {
            lk0 lk0Var = new lk0();
            lk0Var.h(f01Var.g());
            lk0Var.b = f01Var.z();
            lk0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == f01Var.y()) {
                    lk0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            lk0Var.d = f01Var.i();
            lk0Var.g = f01Var.A();
            if (!TextUtils.isEmpty(f01Var.e())) {
                lk0Var.h = new File(f01Var.e());
            }
            lk0Var.i = f01Var.j() / 1000.0f;
            lk0Var.j = f01Var.B() / 1000.0f;
            lk0Var.l = f01Var.x();
            lk0Var.m = f01Var.f();
            lk0Var.p = pk0.a(f01Var.h());
            lk0Var.q = mk0.a(f01Var.c());
            lk0Var.r = ok0.a(f01Var.d());
            return lk0Var;
        }
        return (lk0) invokeL.objValue;
    }
}
