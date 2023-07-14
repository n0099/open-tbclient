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
/* loaded from: classes6.dex */
public class i39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<yn> a(DataRes dataRes, String str) {
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
                        e39 e39Var = new e39();
                        e39Var.i(list.get(i));
                        e39Var.k(true);
                        arrayList.add(e39Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    e39 e39Var2 = new e39();
                    e39Var2.i(recommendForumInfo);
                    e39Var2.k(false);
                    arrayList.add(e39Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                f39 f39Var = new f39();
                f39Var.g(item);
                arrayList.add(f39Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                g39 g39Var = new g39();
                g39Var.m(str);
                g39Var.k(sugLiveInfo);
                arrayList.add(g39Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                h39 h39Var = new h39();
                h39Var.f(str);
                h39Var.e(sugRankingInfo);
                arrayList.add(h39Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                d39 d39Var = new d39();
                d39Var.c(str);
                d39Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, d39Var);
                } else {
                    arrayList.add(d39Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
