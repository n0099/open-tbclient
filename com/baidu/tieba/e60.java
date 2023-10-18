package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes5.dex */
public interface e60 {
    void Q(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void V0(List<String> list);

    void h(int i);

    void hideLoading();

    void i();

    void m(f60 f60Var);

    void o(List<String> list);

    void p(SearchResultBean searchResultBean);

    void showToast(String str);

    void u0(List<? extends LiveRoomEntity> list);

    void y0();
}
