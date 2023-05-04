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
public class ek8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<in> a(DataRes dataRes, String str) {
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
                        ak8 ak8Var = new ak8();
                        ak8Var.j(list.get(i));
                        ak8Var.k(true);
                        arrayList.add(ak8Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    ak8 ak8Var2 = new ak8();
                    ak8Var2.j(recommendForumInfo);
                    ak8Var2.k(false);
                    arrayList.add(ak8Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                bk8 bk8Var = new bk8();
                bk8Var.g(item);
                arrayList.add(bk8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                ck8 ck8Var = new ck8();
                ck8Var.m(str);
                ck8Var.k(sugLiveInfo);
                arrayList.add(ck8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                dk8 dk8Var = new dk8();
                dk8Var.f(str);
                dk8Var.e(sugRankingInfo);
                arrayList.add(dk8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                zj8 zj8Var = new zj8();
                zj8Var.c(str);
                zj8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, zj8Var);
                } else {
                    arrayList.add(zj8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
