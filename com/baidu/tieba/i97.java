package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            ec7.o();
            tc7.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            lc7.n().o(TbadkCoreApplication.getInst().getContext());
            uc7.b().c();
            pc7.i();
            xc7.k();
        }
    }
}
