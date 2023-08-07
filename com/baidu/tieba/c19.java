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
public class c19 {
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
                        y09 y09Var = new y09();
                        y09Var.i(list.get(i));
                        y09Var.l(true);
                        arrayList.add(y09Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    y09 y09Var2 = new y09();
                    y09Var2.i(recommendForumInfo);
                    y09Var2.l(false);
                    arrayList.add(y09Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                z09 z09Var = new z09();
                z09Var.g(item);
                arrayList.add(z09Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                a19 a19Var = new a19();
                a19Var.m(str);
                a19Var.l(sugLiveInfo);
                arrayList.add(a19Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                b19 b19Var = new b19();
                b19Var.f(str);
                b19Var.e(sugRankingInfo);
                arrayList.add(b19Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                x09 x09Var = new x09();
                x09Var.c(str);
                x09Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, x09Var);
                } else {
                    arrayList.add(x09Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
