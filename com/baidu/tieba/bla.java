package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.fb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class bla implements fb7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yb7 a;
    public final BdUniqueId b;

    public bla(yb7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.fb7.b
    public void a(rb7<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            bb7 bb7Var = (bb7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            v57 v57Var = new v57();
            v57 v57Var2 = bb7Var.b;
            if (v57Var2 != null) {
                v57Var = v57Var2;
            }
            if (bb7Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(v57Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            n77 n77Var = bb7Var.a;
            if (n77Var != null && (a = n77Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            pua.g().c(this.b, statisticItem);
            n77 n77Var2 = bb7Var.a;
            if (n77Var2 == null || (hashMap = n77Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            v57Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(v57Var.a().get("is_video_card"), "1")) {
                cma cmaVar = new cma();
                ac7.a.b(new e87(cmaVar.getKey(), cmaVar.a(v57Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(v57Var.a().get("is_live_card"), "1")) {
                jla jlaVar = new jla();
                ac7.a.b(new e87(jlaVar.getKey(), jlaVar.a(v57Var), hashMap, null, null, 24, null));
            } else {
                ula ulaVar = new ula();
                ac7.a.b(new e87(ulaVar.getKey(), ulaVar.a(v57Var), hashMap, null, null, 24, null));
            }
            xla xlaVar = new xla();
            ac7.a.b(new e87(xlaVar.getKey(), xlaVar.a(v57Var), hashMap, xlaVar.b(), xlaVar.d()));
            if (Intrinsics.areEqual(v57Var.a().get("thread_type"), "74")) {
                pla plaVar = new pla();
                plaVar.b("0");
                ac7.a.b(new e87(plaVar.getKey(), plaVar.a(v57Var), hashMap, null, null, 24, null));
            }
        }
    }
}
