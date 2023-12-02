package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
public final class ela implements fb7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yb7 a;
    public final BdUniqueId b;
    public String c;

    public ela(yb7 statStrategy, BdUniqueId pageId) {
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
        this.c = "";
    }

    @Override // com.baidu.tieba.fb7.c
    public void a(rb7<?> data, qb7<?, ?> template, int i) {
        bb7 bb7Var;
        Map<String, String> hashMap;
        w57<?> w57Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof bb7) {
                bb7Var = (bb7) data;
            } else {
                bb7Var = null;
            }
            if (bb7Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            v57 v57Var = new v57();
            v57 v57Var2 = bb7Var.b;
            if (v57Var2 != null) {
                v57Var = v57Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(v57Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            n77 n77Var = bb7Var.a;
            if (n77Var != null && (a = n77Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String d = mua.d(v57Var.a().get("thread_id"), null, null, null);
            pua.g().d(this.b, d, statisticItem);
            yf8.c(d);
            n77 n77Var2 = bb7Var.a;
            if (n77Var2 == null || (hashMap = n77Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            v57Var.a().put("position_from_1", String.valueOf(i2));
            if (v57Var.a().containsKey("growth_level")) {
                ama amaVar = new ama();
                ac7.a.b(new e87(amaVar.getKey(), amaVar.a(v57Var), hashMap, null, null, 24, null));
            }
            if (v57Var.a().containsKey("recommend_info_business_id")) {
                vla vlaVar = new vla();
                ac7.a.b(new e87(vlaVar.getKey(), vlaVar.a(v57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(v57Var.a().get("thread_type"), "0")) {
                ila ilaVar = new ila();
                ac7.a.b(new e87(ilaVar.getKey(), ilaVar.a(v57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(v57Var.a().get("is_video_card"), "1")) {
                dma dmaVar = new dma();
                ac7.a.b(new e87(dmaVar.getKey(), dmaVar.a(v57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(v57Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(v57Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", v57Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", v57Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = v57Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(v57Var.a().get("is_live_card"), "1")) {
                nla nlaVar = new nla();
                Map<String, String> map = hashMap;
                ac7.a.b(new e87(nlaVar.getKey(), nlaVar.a(v57Var), map, null, null, 24, null));
                lla llaVar = new lla();
                ac7.a.b(new e87(llaVar.getKey(), llaVar.a(v57Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(v57Var.a().get("is_tie_plus_ad_thread"), "1")) {
                yla.d(v57Var.a());
            }
            if ((data instanceof f67) && (w57Var = ((f67) data).c) != null) {
                for (rb7<? extends Object> rb7Var : w57Var.c()) {
                    if (rb7Var.b() instanceof j57) {
                        for (v57 v57Var3 : ((j57) rb7Var.b()).h()) {
                            if (Intrinsics.areEqual(v57Var3.a().get("rich_text_type"), "tie_plus")) {
                                yla.c(v57Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(v57Var.a().get("has_du_xin_xuan_reply"), "1")) {
                yla.b(v57Var.a());
            }
            if (Intrinsics.areEqual(v57Var.a().get("thread_type"), "74")) {
                qla qlaVar = new qla();
                ac7.a.b(new e87(qlaVar.getKey(), qlaVar.a(v57Var), hashMap, null, null, 24, null));
            }
        }
    }

    @Override // com.baidu.tieba.fb7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            pua.g().h(this.b, false);
        }
    }
}
