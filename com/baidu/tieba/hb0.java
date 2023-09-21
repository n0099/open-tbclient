package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes6.dex */
public interface hb0 {
    void Q(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void V0(List<String> list);

    void h(int i);

    void hideLoading();

    void i();

    void m(ib0 ib0Var);

    void o(List<String> list);

    void p(SearchResultBean searchResultBean);

    void showToast(String str);

    void u0(List<? extends LiveRoomEntity> list);

    void y0();
}
