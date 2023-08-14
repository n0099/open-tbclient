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
public class d19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<ym> a(DataRes dataRes, String str) {
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
                        z09 z09Var = new z09();
                        z09Var.i(list.get(i));
                        z09Var.l(true);
                        arrayList.add(z09Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    z09 z09Var2 = new z09();
                    z09Var2.i(recommendForumInfo);
                    z09Var2.l(false);
                    arrayList.add(z09Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                a19 a19Var = new a19();
                a19Var.g(item);
                arrayList.add(a19Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                b19 b19Var = new b19();
                b19Var.m(str);
                b19Var.l(sugLiveInfo);
                arrayList.add(b19Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                c19 c19Var = new c19();
                c19Var.f(str);
                c19Var.e(sugRankingInfo);
                arrayList.add(c19Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                y09 y09Var = new y09();
                y09Var.c(str);
                y09Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, y09Var);
                } else {
                    arrayList.add(y09Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
