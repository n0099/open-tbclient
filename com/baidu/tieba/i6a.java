package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.dc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i6a implements dc7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tc7 a;
    public final BdUniqueId b;

    public i6a(tc7 statStrategy, BdUniqueId pageId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {statStrategy, pageId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(statStrategy, "statStrategy");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.a = statStrategy;
        this.b = pageId;
    }

    @Override // com.baidu.tieba.dc7.b
    public void a(pc7<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            zb7 zb7Var = (zb7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            f87 f87Var = new f87();
            f87 f87Var2 = zb7Var.b;
            if (f87Var2 != null) {
                f87Var = f87Var2;
            }
            if (zb7Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(f87Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            m97 m97Var = zb7Var.a;
            if (m97Var != null && (a = m97Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            vfa.g().c(this.b, statisticItem);
            m97 m97Var2 = zb7Var.a;
            if (m97Var2 == null || (hashMap = m97Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            f87Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(f87Var.a().get("is_video_card"), "1")) {
                g7a g7aVar = new g7a();
                vc7.a.a(new w97(g7aVar.getKey(), g7aVar.a(f87Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(f87Var.a().get("is_live_card"), "1")) {
                p6a p6aVar = new p6a();
                vc7.a.a(new w97(p6aVar.getKey(), p6aVar.a(f87Var), hashMap, null, null, 24, null));
            } else {
                y6a y6aVar = new y6a();
                vc7.a.a(new w97(y6aVar.getKey(), y6aVar.a(f87Var), hashMap, null, null, 24, null));
            }
            b7a b7aVar = new b7a();
            vc7.a.a(new w97(b7aVar.getKey(), b7aVar.a(f87Var), hashMap, b7aVar.b(), b7aVar.d()));
        }
    }
}
