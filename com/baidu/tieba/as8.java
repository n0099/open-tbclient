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
public class as8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<vn> a(DataRes dataRes, String str) {
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
                        wr8 wr8Var = new wr8();
                        wr8Var.k(list.get(i));
                        wr8Var.l(true);
                        arrayList.add(wr8Var);
                    }
                }
            } else {
                RecommendForumInfo recommendForumInfo = dataRes.forum_card;
                if (recommendForumInfo != null) {
                    wr8 wr8Var2 = new wr8();
                    wr8Var2.k(recommendForumInfo);
                    wr8Var2.l(false);
                    arrayList.add(wr8Var2);
                }
            }
            Item item = dataRes.item_card;
            if (item != null) {
                xr8 xr8Var = new xr8();
                xr8Var.h(item);
                arrayList.add(xr8Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                yr8 yr8Var = new yr8();
                yr8Var.m(str);
                yr8Var.l(sugLiveInfo);
                arrayList.add(yr8Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                zr8 zr8Var = new zr8();
                zr8Var.f(str);
                zr8Var.e(sugRankingInfo);
                arrayList.add(zr8Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                vr8 vr8Var = new vr8();
                vr8Var.c(str);
                vr8Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, vr8Var);
                } else {
                    arrayList.add(vr8Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
