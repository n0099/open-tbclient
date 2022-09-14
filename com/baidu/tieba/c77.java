package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            y97.o();
            na7.n();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            fa7.l().m(TbadkCoreApplication.getInst().getContext());
            oa7.b().c();
            ja7.i();
            ra7.k();
        }
    }
}
