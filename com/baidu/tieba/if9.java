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
public class if9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<oi> a(DataRes dataRes, String str) {
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
                        ef9 ef9Var = new ef9();
                        ef9Var.i(list.get(i));
                        ef9Var.l(true);
                        arrayList.add(ef9Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    ef9 ef9Var2 = new ef9();
                    ef9Var2.i(recommendForumInfo);
                    ef9Var2.l(false);
                    arrayList.add(ef9Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                ff9 ff9Var = new ff9();
                ff9Var.g(item);
                arrayList.add(ff9Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                gf9 gf9Var = new gf9();
                gf9Var.n(str);
                gf9Var.l(sugLiveInfo);
                arrayList.add(gf9Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                hf9 hf9Var = new hf9();
                hf9Var.f(str);
                hf9Var.e(sugRankingInfo);
                arrayList.add(hf9Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                df9 df9Var = new df9();
                df9Var.c(str);
                df9Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, df9Var);
                } else {
                    arrayList.add(df9Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
