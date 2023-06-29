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
public class fx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<xn> a(DataRes dataRes, String str) {
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
                        bx8 bx8Var = new bx8();
                        bx8Var.k(list.get(i));
                        bx8Var.l(true);
                        arrayList.add(bx8Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    bx8 bx8Var2 = new bx8();
                    bx8Var2.k(recommendForumInfo);
                    bx8Var2.l(false);
                    arrayList.add(bx8Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                cx8 cx8Var = new cx8();
                cx8Var.h(item);
                arrayList.add(cx8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                dx8 dx8Var = new dx8();
                dx8Var.m(str);
                dx8Var.l(sugLiveInfo);
                arrayList.add(dx8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                ex8 ex8Var = new ex8();
                ex8Var.f(str);
                ex8Var.e(sugRankingInfo);
                arrayList.add(ex8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ax8 ax8Var = new ax8();
                ax8Var.c(str);
                ax8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ax8Var);
                } else {
                    arrayList.add(ax8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
