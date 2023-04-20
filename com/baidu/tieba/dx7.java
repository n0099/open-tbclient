package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            yz7.n();
            m08.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            f08.n().o(TbadkCoreApplication.getInst().getContext());
            n08.b().c();
            i08.i();
            q08.k();
        }
    }
}
