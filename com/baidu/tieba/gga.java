package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
/* loaded from: classes6.dex */
public final class gga implements na7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final gb7 a;
    public final BdUniqueId b;
    public String c;

    public gga(gb7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.na7.c
    public void a(za7<?> data, ya7<?, ?> template, int i) {
        ja7 ja7Var;
        Map<String, String> hashMap;
        e57<?> e57Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof ja7) {
                ja7Var = (ja7) data;
            } else {
                ja7Var = null;
            }
            if (ja7Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            d57 d57Var = new d57();
            d57 d57Var2 = ja7Var.b;
            if (d57Var2 != null) {
                d57Var = d57Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(d57Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            v67 v67Var = ja7Var.a;
            if (v67Var != null && (a = v67Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String d = tpa.d(d57Var.a().get("thread_id"), null, null, null);
            wpa.g().d(this.b, d, statisticItem);
            xc8.c(d);
            v67 v67Var2 = ja7Var.a;
            if (v67Var2 == null || (hashMap = v67Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            d57Var.a().put("position_from_1", String.valueOf(i2));
            if (d57Var.a().containsKey("growth_level")) {
                cha chaVar = new cha();
                ib7.a.b(new m77(chaVar.getKey(), chaVar.a(d57Var), hashMap, null, null, 24, null));
            }
            if (d57Var.a().containsKey("recommend_info_business_id")) {
                xga xgaVar = new xga();
                ib7.a.b(new m77(xgaVar.getKey(), xgaVar.a(d57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(d57Var.a().get("thread_type"), "0")) {
                kga kgaVar = new kga();
                ib7.a.b(new m77(kgaVar.getKey(), kgaVar.a(d57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(d57Var.a().get("is_video_card"), "1")) {
                fha fhaVar = new fha();
                ib7.a.b(new m77(fhaVar.getKey(), fhaVar.a(d57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(d57Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(d57Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", d57Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", d57Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = d57Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(d57Var.a().get("is_live_card"), "1")) {
                pga pgaVar = new pga();
                Map<String, String> map = hashMap;
                ib7.a.b(new m77(pgaVar.getKey(), pgaVar.a(d57Var), map, null, null, 24, null));
                nga ngaVar = new nga();
                ib7.a.b(new m77(ngaVar.getKey(), ngaVar.a(d57Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(d57Var.a().get("is_tie_plus_ad_thread"), "1")) {
                aha.d(d57Var.a());
            }
            if ((data instanceof n57) && (e57Var = ((n57) data).c) != null) {
                for (za7<? extends Object> za7Var : e57Var.c()) {
                    if (za7Var.b() instanceof r47) {
                        for (d57 d57Var3 : ((r47) za7Var.b()).h()) {
                            if (Intrinsics.areEqual(d57Var3.a().get("rich_text_type"), "tie_plus")) {
                                aha.c(d57Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(d57Var.a().get("has_du_xin_xuan_reply"), "1")) {
                aha.b(d57Var.a());
            }
            if (Intrinsics.areEqual(d57Var.a().get("thread_type"), "74")) {
                sga sgaVar = new sga();
                ib7.a.b(new m77(sgaVar.getKey(), sgaVar.a(d57Var), hashMap, null, null, 24, null));
            }
        }
    }

    @Override // com.baidu.tieba.na7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            wpa.g().h(this.b, false);
        }
    }
}
