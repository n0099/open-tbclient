package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.bb7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ala implements bb7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ub7 a;
    public final BdUniqueId b;
    public String c;

    public ala(ub7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.bb7.c
    public void a(nb7<?> data, mb7<?, ?> template, int i) {
        xa7 xa7Var;
        Map<String, String> hashMap;
        s57<?> s57Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof xa7) {
                xa7Var = (xa7) data;
            } else {
                xa7Var = null;
            }
            if (xa7Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            r57 r57Var = new r57();
            r57 r57Var2 = xa7Var.b;
            if (r57Var2 != null) {
                r57Var = r57Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(r57Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            j77 j77Var = xa7Var.a;
            if (j77Var != null && (a = j77Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String d = nua.d(r57Var.a().get("thread_id"), null, null, null);
            qua.g().d(this.b, d, statisticItem);
            uf8.c(d);
            j77 j77Var2 = xa7Var.a;
            if (j77Var2 == null || (hashMap = j77Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            r57Var.a().put("position_from_1", String.valueOf(i2));
            if (r57Var.a().containsKey("growth_level")) {
                wla wlaVar = new wla();
                wb7.a.b(new a87(wlaVar.getKey(), wlaVar.a(r57Var), hashMap, null, null, 24, null));
            }
            if (r57Var.a().containsKey("recommend_info_business_id")) {
                rla rlaVar = new rla();
                wb7.a.b(new a87(rlaVar.getKey(), rlaVar.a(r57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(r57Var.a().get("thread_type"), "0")) {
                ela elaVar = new ela();
                wb7.a.b(new a87(elaVar.getKey(), elaVar.a(r57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(r57Var.a().get("is_video_card"), "1")) {
                zla zlaVar = new zla();
                wb7.a.b(new a87(zlaVar.getKey(), zlaVar.a(r57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(r57Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(r57Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", r57Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", r57Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = r57Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(r57Var.a().get("is_live_card"), "1")) {
                jla jlaVar = new jla();
                Map<String, String> map = hashMap;
                wb7.a.b(new a87(jlaVar.getKey(), jlaVar.a(r57Var), map, null, null, 24, null));
                hla hlaVar = new hla();
                wb7.a.b(new a87(hlaVar.getKey(), hlaVar.a(r57Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(r57Var.a().get("is_tie_plus_ad_thread"), "1")) {
                ula.d(r57Var.a());
            }
            if ((data instanceof b67) && (s57Var = ((b67) data).c) != null) {
                for (nb7<? extends Object> nb7Var : s57Var.c()) {
                    if (nb7Var.b() instanceof f57) {
                        for (r57 r57Var3 : ((f57) nb7Var.b()).h()) {
                            if (Intrinsics.areEqual(r57Var3.a().get("rich_text_type"), "tie_plus")) {
                                ula.c(r57Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(r57Var.a().get("has_du_xin_xuan_reply"), "1")) {
                ula.b(r57Var.a());
            }
            if (Intrinsics.areEqual(r57Var.a().get("thread_type"), "74")) {
                mla mlaVar = new mla();
                wb7.a.b(new a87(mlaVar.getKey(), mlaVar.a(r57Var), hashMap, null, null, 24, null));
            }
        }
    }

    @Override // com.baidu.tieba.bb7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            qua.g().h(this.b, false);
        }
    }
}
