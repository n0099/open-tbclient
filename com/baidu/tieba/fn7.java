package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            aq7.n();
            oq7.m();
            LocalViewSize.getInstance().initial(TbadkCoreApplication.getInst().getContext());
            hq7.n().o(TbadkCoreApplication.getInst().getContext());
            pq7.b().c();
            kq7.i();
            sq7.k();
        }
    }
}
