package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class fk0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static y01 a(@NonNull mk0 mk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mk0Var)) == null) {
            y01 y01Var = new y01();
            y01Var.o(mk0Var.e());
            y01Var.u(mk0Var.b);
            y01Var.t(mk0Var.c.status);
            y01Var.q(mk0Var.d);
            y01Var.v(mk0Var.g);
            File file = mk0Var.h;
            if (file != null) {
                y01Var.m(file.getAbsolutePath());
            } else {
                y01Var.m("");
            }
            y01Var.r((int) (mk0Var.i * 1000.0f));
            y01Var.w((int) (mk0Var.j * 1000.0f));
            y01Var.s(mk0Var.l);
            y01Var.n(mk0Var.m);
            qk0 qk0Var = mk0Var.p;
            if (qk0Var != null) {
                y01Var.p(qk0.b(qk0Var));
            } else {
                y01Var.p("");
            }
            nk0 nk0Var = mk0Var.q;
            if (nk0Var != null) {
                y01Var.k(nk0.b(nk0Var));
            } else {
                y01Var.k("");
            }
            pk0 pk0Var = mk0Var.r;
            if (pk0Var != null) {
                y01Var.l(pk0.b(pk0Var));
            } else {
                y01Var.l("");
            }
            return y01Var;
        }
        return (y01) invokeL.objValue;
    }

    public static mk0 b(@NonNull y01 y01Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, y01Var)) == null) {
            mk0 mk0Var = new mk0();
            mk0Var.h(y01Var.g());
            mk0Var.b = y01Var.z();
            mk0Var.c = AdDownloadStatus.NONE;
            AdDownloadStatus[] values = AdDownloadStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                AdDownloadStatus adDownloadStatus = values[i];
                if (adDownloadStatus.status == y01Var.y()) {
                    mk0Var.c = adDownloadStatus;
                    break;
                }
                i++;
            }
            mk0Var.d = y01Var.i();
            mk0Var.g = y01Var.A();
            if (!TextUtils.isEmpty(y01Var.e())) {
                mk0Var.h = new File(y01Var.e());
            }
            mk0Var.i = y01Var.j() / 1000.0f;
            mk0Var.j = y01Var.B() / 1000.0f;
            mk0Var.l = y01Var.x();
            mk0Var.m = y01Var.f();
            mk0Var.p = qk0.a(y01Var.h());
            mk0Var.q = nk0.a(y01Var.c());
            mk0Var.r = pk0.a(y01Var.d());
            return mk0Var;
        }
        return (mk0) invokeL.objValue;
    }
}
