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
public class i69 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<cn> a(DataRes dataRes, String str) {
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
                        e69 e69Var = new e69();
                        e69Var.i(list.get(i));
                        e69Var.l(true);
                        arrayList.add(e69Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    e69 e69Var2 = new e69();
                    e69Var2.i(recommendForumInfo);
                    e69Var2.l(false);
                    arrayList.add(e69Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                f69 f69Var = new f69();
                f69Var.g(item);
                arrayList.add(f69Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                g69 g69Var = new g69();
                g69Var.m(str);
                g69Var.l(sugLiveInfo);
                arrayList.add(g69Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                h69 h69Var = new h69();
                h69Var.f(str);
                h69Var.e(sugRankingInfo);
                arrayList.add(h69Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                d69 d69Var = new d69();
                d69Var.c(str);
                d69Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, d69Var);
                } else {
                    arrayList.add(d69Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
