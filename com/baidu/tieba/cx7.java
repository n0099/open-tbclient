package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            xz7.n();
            l08.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            e08.n().o(TbadkCoreApplication.getInst().getContext());
            m08.b().c();
            h08.i();
            p08.k();
        }
    }
}
