package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i0a implements i97.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y97 a;
    public final BdUniqueId b;

    public i0a(y97 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.i97.b
    public void a(u97<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            e97 e97Var = (e97) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            l57 l57Var = new l57();
            l57 l57Var2 = e97Var.b;
            if (l57Var2 != null) {
                l57Var = l57Var2;
            }
            if (e97Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(l57Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            s67 s67Var = e97Var.a;
            if (s67Var != null && (a = s67Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            t9a.g().c(this.b, statisticItem);
            s67 s67Var2 = e97Var.a;
            if (s67Var2 == null || (hashMap = s67Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            l57Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(l57Var.a().get("is_video_card"), "1")) {
                g1a g1aVar = new g1a();
                aa7.a.a(new c77(g1aVar.getKey(), g1aVar.a(l57Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(l57Var.a().get("is_live_card"), "1")) {
                p0a p0aVar = new p0a();
                aa7.a.a(new c77(p0aVar.getKey(), p0aVar.a(l57Var), hashMap, null, null, 24, null));
            } else {
                y0a y0aVar = new y0a();
                aa7.a.a(new c77(y0aVar.getKey(), y0aVar.a(l57Var), hashMap, null, null, 24, null));
            }
            b1a b1aVar = new b1a();
            aa7.a.a(new c77(b1aVar.getKey(), b1aVar.a(l57Var), hashMap, b1aVar.b(), b1aVar.d()));
        }
    }
}
