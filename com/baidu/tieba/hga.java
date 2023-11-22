package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
/* loaded from: classes6.dex */
public final class hga implements oa7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final hb7 a;
    public final BdUniqueId b;
    public String c;

    public hga(hb7 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.oa7.c
    public void a(ab7<?> data, za7<?, ?> template, int i) {
        ka7 ka7Var;
        Map<String, String> hashMap;
        f57<?> f57Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof ka7) {
                ka7Var = (ka7) data;
            } else {
                ka7Var = null;
            }
            if (ka7Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            e57 e57Var = new e57();
            e57 e57Var2 = ka7Var.b;
            if (e57Var2 != null) {
                e57Var = e57Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(e57Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            w67 w67Var = ka7Var.a;
            if (w67Var != null && (a = w67Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String d = upa.d(e57Var.a().get("thread_id"), null, null, null);
            xpa.g().d(this.b, d, statisticItem);
            yc8.c(d);
            w67 w67Var2 = ka7Var.a;
            if (w67Var2 == null || (hashMap = w67Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            e57Var.a().put("position_from_1", String.valueOf(i2));
            if (e57Var.a().containsKey("growth_level")) {
                dha dhaVar = new dha();
                jb7.a.b(new n77(dhaVar.getKey(), dhaVar.a(e57Var), hashMap, null, null, 24, null));
            }
            if (e57Var.a().containsKey("recommend_info_business_id")) {
                yga ygaVar = new yga();
                jb7.a.b(new n77(ygaVar.getKey(), ygaVar.a(e57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(e57Var.a().get("thread_type"), "0")) {
                lga lgaVar = new lga();
                jb7.a.b(new n77(lgaVar.getKey(), lgaVar.a(e57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(e57Var.a().get("is_video_card"), "1")) {
                gha ghaVar = new gha();
                jb7.a.b(new n77(ghaVar.getKey(), ghaVar.a(e57Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(e57Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(e57Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", e57Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", e57Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = e57Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(e57Var.a().get("is_live_card"), "1")) {
                qga qgaVar = new qga();
                Map<String, String> map = hashMap;
                jb7.a.b(new n77(qgaVar.getKey(), qgaVar.a(e57Var), map, null, null, 24, null));
                oga ogaVar = new oga();
                jb7.a.b(new n77(ogaVar.getKey(), ogaVar.a(e57Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(e57Var.a().get("is_tie_plus_ad_thread"), "1")) {
                bha.d(e57Var.a());
            }
            if ((data instanceof o57) && (f57Var = ((o57) data).c) != null) {
                for (ab7<? extends Object> ab7Var : f57Var.c()) {
                    if (ab7Var.b() instanceof s47) {
                        for (e57 e57Var3 : ((s47) ab7Var.b()).h()) {
                            if (Intrinsics.areEqual(e57Var3.a().get("rich_text_type"), "tie_plus")) {
                                bha.c(e57Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(e57Var.a().get("has_du_xin_xuan_reply"), "1")) {
                bha.b(e57Var.a());
            }
            if (Intrinsics.areEqual(e57Var.a().get("thread_type"), "74")) {
                tga tgaVar = new tga();
                jb7.a.b(new n77(tgaVar.getKey(), tgaVar.a(e57Var), hashMap, null, null, 24, null));
            }
        }
    }

    @Override // com.baidu.tieba.oa7.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            xpa.g().h(this.b, false);
        }
    }
}
