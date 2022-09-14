package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Item;
import tbclient.RecommendForumInfo;
import tbclient.SearchSug.DataRes;
import tbclient.SugLiveInfo;
import tbclient.SugRankingInfo;
/* loaded from: classes3.dex */
public class ej7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<Cdo> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                aj7 aj7Var = new aj7();
                aj7Var.j(recommendForumInfo);
                arrayList.add(aj7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                bj7 bj7Var = new bj7();
                bj7Var.j(item);
                arrayList.add(bj7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                cj7 cj7Var = new cj7();
                cj7Var.o(str);
                cj7Var.n(sugLiveInfo);
                arrayList.add(cj7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                dj7 dj7Var = new dj7();
                dj7Var.h(str);
                dj7Var.g(sugRankingInfo);
                arrayList.add(dj7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                zi7 zi7Var = new zi7();
                zi7Var.c(str);
                zi7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, zi7Var);
                } else {
                    arrayList.add(zi7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
