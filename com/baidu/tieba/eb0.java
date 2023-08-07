package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes5.dex */
public interface eb0 {
    void W0(List<String> list);

    void g0(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void h(int i);

    void hideLoading();

    void i();

    void l(fb0 fb0Var);

    void o(List<String> list);

    void q(SearchResultBean searchResultBean);

    void showToast(String str);

    void v0(List<? extends LiveRoomEntity> list);

    void y0();
}
