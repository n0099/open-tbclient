package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
@JvmName(name = "CardUtil")
/* loaded from: classes5.dex */
public final class cm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(os<?> osVar, int i, int i2) {
        qt qtVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65536, null, osVar, i, i2) == null) {
            if (osVar instanceof qt) {
                qtVar = (qt) osVar;
            } else {
                qtVar = null;
            }
            if (qtVar == null) {
                return;
            }
            qtVar.f.k(i, i2);
        }
    }
}
