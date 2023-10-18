package com.baidu.tieba;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.v67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b3a implements v67.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final l77 a;
    public final BdUniqueId b;
    public String c;

    public b3a(l77 statStrategy, BdUniqueId pageId) {
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

    @Override // com.baidu.tieba.v67.c
    public void a(h77<?> data, g77<?, ?> template, int i) {
        r67 r67Var;
        Map<String, String> hashMap;
        w27<?> w27Var;
        Map<String, String> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, data, template, i) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(template, "template");
            if (data instanceof r67) {
                r67Var = (r67) data;
            } else {
                r67Var = null;
            }
            if (r67Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(this.a.getKey());
            int i2 = i + 1;
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, i2);
            v27 v27Var = new v27();
            v27 v27Var2 = r67Var.b;
            if (v27Var2 != null) {
                v27Var = v27Var2;
            }
            for (Map.Entry<String, String> entry : this.a.a(v27Var).entrySet()) {
                statisticItem.param(entry.getKey(), entry.getValue());
            }
            c47 c47Var = r67Var.a;
            if (c47Var != null && (a = c47Var.a()) != null) {
                for (Map.Entry<String, String> entry2 : a.entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
            }
            String d = oca.d(v27Var.a().get("thread_id"), null, null, null);
            rca.g().d(this.b, d, statisticItem);
            c08.c(d);
            c47 c47Var2 = r67Var.a;
            if (c47Var2 == null || (hashMap = c47Var2.a()) == null) {
                hashMap = new HashMap<>();
            }
            v27Var.a().put("position_from_1", String.valueOf(i2));
            if (v27Var.a().containsKey("growth_level")) {
                x3a x3aVar = new x3a();
                n77.a.a(new n47(x3aVar.getKey(), x3aVar.a(v27Var), hashMap, null, null, 24, null));
            }
            if (v27Var.a().containsKey("recommend_info_business_id")) {
                s3a s3aVar = new s3a();
                n77.a.a(new n47(s3aVar.getKey(), s3aVar.a(v27Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(v27Var.a().get("thread_type"), "0")) {
                f3a f3aVar = new f3a();
                n77.a.a(new n47(f3aVar.getKey(), f3aVar.a(v27Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(v27Var.a().get("is_video_card"), "1")) {
                a4a a4aVar = new a4a();
                n77.a.a(new n47(a4aVar.getKey(), a4aVar.a(v27Var), hashMap, null, null, 24, null));
            }
            if (Intrinsics.areEqual(v27Var.a().get("has_forum_rec_label"), "1") && !Intrinsics.areEqual(v27Var.a().get("thread_id"), this.c)) {
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_REC_THREAD_SHOW);
                statisticItem2.addParam("tid", v27Var.a().get("thread_id")).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam("fid", v27Var.a().get("forum_id"));
                TiebaStatic.log(statisticItem2);
                String str = v27Var.a().get("thread_id");
                if (str == null) {
                    str = "";
                }
                this.c = str;
            }
            if (Intrinsics.areEqual(v27Var.a().get("is_live_card"), "1")) {
                k3a k3aVar = new k3a();
                Map<String, String> map = hashMap;
                n77.a.a(new n47(k3aVar.getKey(), k3aVar.a(v27Var), map, null, null, 24, null));
                i3a i3aVar = new i3a();
                n77.a.a(new n47(i3aVar.getKey(), i3aVar.a(v27Var), map, null, null, 24, null));
            }
            if (Intrinsics.areEqual(v27Var.a().get("is_tie_plus_ad_thread"), "1")) {
                v3a.d(v27Var.a());
            }
            if ((data instanceof d37) && (w27Var = ((d37) data).c) != null) {
                for (h77<? extends Object> h77Var : w27Var.b()) {
                    if (h77Var.b() instanceof o27) {
                        for (v27 v27Var3 : ((o27) h77Var.b()).g()) {
                            if (Intrinsics.areEqual(v27Var3.a().get("rich_text_type"), "tie_plus")) {
                                v3a.c(v27Var3.a());
                            }
                        }
                    }
                }
            }
            if (Intrinsics.areEqual(v27Var.a().get("has_du_xin_xuan_reply"), "1")) {
                v3a.b(v27Var.a());
            }
            if (Intrinsics.areEqual(v27Var.a().get("thread_type"), "74")) {
                n3a n3aVar = new n3a();
                n77.a.a(new n47(n3aVar.getKey(), n3aVar.a(v27Var), hashMap, null, null, 24, null));
            }
        }
    }

    @Override // com.baidu.tieba.v67.c
    public void b(RecyclerView rv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rv) == null) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            rca.g().h(this.b, false);
        }
    }
}
