package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.na7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class dga implements na7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gb7 a;
    public final BdUniqueId b;

    public dga(gb7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.na7.b
    public void a(za7<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            ja7 ja7Var = (ja7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            d57 d57Var = new d57();
            d57 d57Var2 = ja7Var.b;
            if (d57Var2 != null) {
                d57Var = d57Var2;
            }
            if (ja7Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(d57Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            v67 v67Var = ja7Var.a;
            if (v67Var != null && (a = v67Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            wpa.g().c(this.b, statisticItem);
            v67 v67Var2 = ja7Var.a;
            if (v67Var2 == null || (hashMap = v67Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            d57Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(d57Var.a().get("is_video_card"), "1")) {
                eha ehaVar = new eha();
                ib7.a.b(new m77(ehaVar.getKey(), ehaVar.a(d57Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(d57Var.a().get("is_live_card"), "1")) {
                lga lgaVar = new lga();
                ib7.a.b(new m77(lgaVar.getKey(), lgaVar.a(d57Var), hashMap, null, null, 24, null));
            } else {
                wga wgaVar = new wga();
                ib7.a.b(new m77(wgaVar.getKey(), wgaVar.a(d57Var), hashMap, null, null, 24, null));
            }
            zga zgaVar = new zga();
            ib7.a.b(new m77(zgaVar.getKey(), zgaVar.a(d57Var), hashMap, zgaVar.b(), zgaVar.d()));
            if (Intrinsics.areEqual(d57Var.a().get("thread_type"), "74")) {
                rga rgaVar = new rga();
                rgaVar.b("0");
                ib7.a.b(new m77(rgaVar.getKey(), rgaVar.a(d57Var), hashMap, null, null, 24, null));
            }
        }
    }
}
