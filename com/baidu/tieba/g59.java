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
public class g59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<bn> a(DataRes dataRes, String str) {
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
                        c59 c59Var = new c59();
                        c59Var.i(list.get(i));
                        c59Var.l(true);
                        arrayList.add(c59Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    c59 c59Var2 = new c59();
                    c59Var2.i(recommendForumInfo);
                    c59Var2.l(false);
                    arrayList.add(c59Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                d59 d59Var = new d59();
                d59Var.g(item);
                arrayList.add(d59Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                e59 e59Var = new e59();
                e59Var.m(str);
                e59Var.l(sugLiveInfo);
                arrayList.add(e59Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                f59 f59Var = new f59();
                f59Var.f(str);
                f59Var.e(sugRankingInfo);
                arrayList.add(f59Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                b59 b59Var = new b59();
                b59Var.c(str);
                b59Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, b59Var);
                } else {
                    arrayList.add(b59Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
