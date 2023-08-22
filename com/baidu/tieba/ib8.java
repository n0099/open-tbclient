package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ib8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            mg8.n();
            ah8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            tg8.n().o(TbadkCoreApplication.getInst().getContext());
            bh8.b().c();
            wg8.i();
            eh8.k();
        }
    }
}
