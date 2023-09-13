package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes6.dex */
public interface ib0 {
    void U(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void W0(List<String> list);

    void h(int i);

    void hideLoading();

    void i();

    void m(jb0 jb0Var);

    void o(List<String> list);

    void q(SearchResultBean searchResultBean);

    void showToast(String str);

    void w0(List<? extends LiveRoomEntity> list);

    void z0();
}
