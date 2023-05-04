package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class ic8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(String key, String uid, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, key, uid, str) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(uid, "uid");
            StatisticItem.make(key).param("uid", uid).param("content", str).eventStat();
        }
    }

    public static final void b(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            StatisticItem param = new StatisticItem("c15227").param("uid", TbadkCoreApplication.getCurrentAccount());
            if (z) {
                i = 2;
            } else {
                i = 1;
            }
            param.param("obj_type", i).eventStat();
        }
    }
}
