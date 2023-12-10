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
/* loaded from: classes5.dex */
public class ej9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<pi> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<RecommendForumInfo> list = dataRes.forum_cards;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) != null) {
                        aj9 aj9Var = new aj9();
                        aj9Var.k(list.get(i));
                        aj9Var.l(true);
                        arrayList.add(aj9Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    aj9 aj9Var2 = new aj9();
                    aj9Var2.k(recommendForumInfo);
                    aj9Var2.l(false);
                    arrayList.add(aj9Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                bj9 bj9Var = new bj9();
                bj9Var.g(item);
                arrayList.add(bj9Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                cj9 cj9Var = new cj9();
                cj9Var.n(str);
                cj9Var.l(sugLiveInfo);
                arrayList.add(cj9Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                dj9 dj9Var = new dj9();
                dj9Var.f(str);
                dj9Var.e(sugRankingInfo);
                arrayList.add(dj9Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                zi9 zi9Var = new zi9();
                zi9Var.c(str);
                zi9Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, zi9Var);
                } else {
                    arrayList.add(zi9Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
