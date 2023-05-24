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
/* loaded from: classes4.dex */
public class am8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<rn> a(DataRes dataRes, String str) {
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
                        wl8 wl8Var = new wl8();
                        wl8Var.k(list.get(i));
                        wl8Var.l(true);
                        arrayList.add(wl8Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    wl8 wl8Var2 = new wl8();
                    wl8Var2.k(recommendForumInfo);
                    wl8Var2.l(false);
                    arrayList.add(wl8Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                xl8 xl8Var = new xl8();
                xl8Var.h(item);
                arrayList.add(xl8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                yl8 yl8Var = new yl8();
                yl8Var.m(str);
                yl8Var.l(sugLiveInfo);
                arrayList.add(yl8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                zl8 zl8Var = new zl8();
                zl8Var.f(str);
                zl8Var.e(sugRankingInfo);
                arrayList.add(zl8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                vl8 vl8Var = new vl8();
                vl8Var.c(str);
                vl8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, vl8Var);
                } else {
                    arrayList.add(vl8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
