package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class hda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65536, null, z) == null) {
            StatisticItem param = new StatisticItem("c15224").param("uid", TbadkCoreApplication.getCurrentAccount());
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            param.param("obj_type", i).eventStat();
        }
    }

    public static final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            new StatisticItem("c15223").param("uid", TbadkCoreApplication.getCurrentAccount()).eventStat();
        }
    }
}
