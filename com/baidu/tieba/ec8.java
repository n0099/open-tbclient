package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ec8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            oh8.n();
            ci8.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            vh8.n().o(TbadkCoreApplication.getInst().getContext());
            di8.b().c();
            yh8.i();
            gi8.k();
        }
    }
}
