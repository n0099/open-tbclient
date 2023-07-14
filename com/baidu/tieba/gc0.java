package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes6.dex */
public interface gc0 {
    void D0();

    void Y0(List<String> list);

    void g0();

    void h(int i);

    void h0(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void i();

    void m(hc0 hc0Var);

    void p(List<String> list);

    void r(SearchResultBean searchResultBean);

    void showToast(String str);

    void w0(List<? extends LiveRoomEntity> list);
}
