package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class an8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            fw8.n();
            tw8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            mw8.n().o(TbadkCoreApplication.getInst().getContext());
            uw8.b().c();
            pw8.i();
            yw8.k();
        }
    }
}
