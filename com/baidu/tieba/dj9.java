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
public class dj9 {
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
                        zi9 zi9Var = new zi9();
                        zi9Var.k(list.get(i));
                        zi9Var.l(true);
                        arrayList.add(zi9Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    zi9 zi9Var2 = new zi9();
                    zi9Var2.k(recommendForumInfo);
                    zi9Var2.l(false);
                    arrayList.add(zi9Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                aj9 aj9Var = new aj9();
                aj9Var.g(item);
                arrayList.add(aj9Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                bj9 bj9Var = new bj9();
                bj9Var.n(str);
                bj9Var.l(sugLiveInfo);
                arrayList.add(bj9Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                cj9 cj9Var = new cj9();
                cj9Var.f(str);
                cj9Var.e(sugRankingInfo);
                arrayList.add(cj9Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                yi9 yi9Var = new yi9();
                yi9Var.c(str);
                yi9Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, yi9Var);
                } else {
                    arrayList.add(yi9Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
