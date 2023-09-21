package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ic8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            kl8.n();
            yl8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            rl8.n().o(TbadkCoreApplication.getInst().getContext());
            zl8.b().c();
            ul8.i();
            dm8.k();
        }
    }
}
