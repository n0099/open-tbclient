package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class a09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(String str) {
        df<byte[]> e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && (e = kv4.e(str, TbadkCoreApplication.getCurrentAccount())) != null) {
            e.g("0", null);
        }
    }

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            a("tb.rec_frs_update");
        }
    }
}
