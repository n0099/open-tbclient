package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, long j, long j2);

        void b(int i);

        void success();
    }

    public static void a(String str, a aVar) {
        t73 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, str, aVar) != null) || aVar == null || TextUtils.isEmpty(str) || (M = t73.M()) == null) {
            return;
        }
        if (g94.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = g94.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            df4.h(new yi4(M.b, M.k0(), a2, 1), new k94(M.b, M.k0(), g94.b().c(str, 2), aVar));
        }
    }
}
