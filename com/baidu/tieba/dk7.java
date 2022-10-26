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
/* loaded from: classes3.dex */
public class dk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                zj7 zj7Var = new zj7();
                zj7Var.j(recommendForumInfo);
                arrayList.add(zj7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                ak7 ak7Var = new ak7();
                ak7Var.j(item);
                arrayList.add(ak7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                bk7 bk7Var = new bk7();
                bk7Var.o(str);
                bk7Var.n(sugLiveInfo);
                arrayList.add(bk7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                ck7 ck7Var = new ck7();
                ck7Var.h(str);
                ck7Var.g(sugRankingInfo);
                arrayList.add(ck7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                yj7 yj7Var = new yj7();
                yj7Var.c(str);
                yj7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, yj7Var);
                } else {
                    arrayList.add(yj7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
