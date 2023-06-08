package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            b98.n();
            p98.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            i98.n().o(TbadkCoreApplication.getInst().getContext());
            q98.b().c();
            l98.i();
            t98.k();
        }
    }
}
