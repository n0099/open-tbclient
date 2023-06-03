package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            z88.n();
            n98.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            g98.n().o(TbadkCoreApplication.getInst().getContext());
            o98.b().c();
            j98.i();
            r98.k();
        }
    }
}
