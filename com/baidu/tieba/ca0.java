package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes3.dex */
public interface ca0 {
    void A0(List<? extends LiveRoomEntity> list);

    void F0();

    void a1(List<String> list);

    void i0();

    void j0(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void k(int i);

    void l();

    void p(da0 da0Var);

    void showToast(String str);

    void t(List<String> list);

    void u(SearchResultBean searchResultBean);
}
