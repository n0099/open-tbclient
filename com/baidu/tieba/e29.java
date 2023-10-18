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
public class e29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<yh> a(DataRes dataRes, String str) {
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
                        a29 a29Var = new a29();
                        a29Var.i(list.get(i));
                        a29Var.l(true);
                        arrayList.add(a29Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    a29 a29Var2 = new a29();
                    a29Var2.i(recommendForumInfo);
                    a29Var2.l(false);
                    arrayList.add(a29Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                b29 b29Var = new b29();
                b29Var.g(item);
                arrayList.add(b29Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                c29 c29Var = new c29();
                c29Var.m(str);
                c29Var.l(sugLiveInfo);
                arrayList.add(c29Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                d29 d29Var = new d29();
                d29Var.f(str);
                d29Var.e(sugRankingInfo);
                arrayList.add(d29Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                z19 z19Var = new z19();
                z19Var.c(str);
                z19Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, z19Var);
                } else {
                    arrayList.add(z19Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
