package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.oa7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ega implements oa7.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hb7 a;
    public final BdUniqueId b;

    public ega(hb7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.oa7.b
    public void a(ab7<?> data, int i) {
        Map<String, String> hashMap;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, data, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            ka7 ka7Var = (ka7) data;
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            e57 e57Var = new e57();
            e57 e57Var2 = ka7Var.b;
            if (e57Var2 != null) {
                e57Var = e57Var2;
            }
            if (ka7Var.b != null) {
                for (Map.Entry<String, String> entry : this.a.a(e57Var).entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
            }
            w67 w67Var = ka7Var.a;
            if (w67Var != null && (a = w67Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            xpa.g().c(this.b, statisticItem);
            w67 w67Var2 = ka7Var.a;
            if (w67Var2 == null || (hashMap = w67Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            e57Var.a().put("position_from_1", String.valueOf(i2));
            if (Intrinsics.areEqual(e57Var.a().get("is_video_card"), "1")) {
                fha fhaVar = new fha();
                jb7.a.b(new n77(fhaVar.getKey(), fhaVar.a(e57Var), hashMap, null, null, 24, null));
            } else if (Intrinsics.areEqual(e57Var.a().get("is_live_card"), "1")) {
                mga mgaVar = new mga();
                jb7.a.b(new n77(mgaVar.getKey(), mgaVar.a(e57Var), hashMap, null, null, 24, null));
            } else {
                xga xgaVar = new xga();
                jb7.a.b(new n77(xgaVar.getKey(), xgaVar.a(e57Var), hashMap, null, null, 24, null));
            }
            aha ahaVar = new aha();
            jb7.a.b(new n77(ahaVar.getKey(), ahaVar.a(e57Var), hashMap, ahaVar.b(), ahaVar.d()));
            if (Intrinsics.areEqual(e57Var.a().get("thread_type"), "74")) {
                sga sgaVar = new sga();
                sgaVar.b("0");
                jb7.a.b(new n77(sgaVar.getKey(), sgaVar.a(e57Var), hashMap, null, null, 24, null));
            }
        }
    }
}
