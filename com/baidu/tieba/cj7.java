package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            xl7.n();
            lm7.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            em7.n().o(TbadkCoreApplication.getInst().getContext());
            mm7.b().c();
            hm7.i();
            pm7.k();
        }
    }
}
