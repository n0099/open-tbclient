package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes5.dex */
public interface fc0 {
    void E0();

    void a1(List<String> list);

    void h0();

    void i0(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void k(int i);

    void l();

    void p(gc0 gc0Var);

    void showToast(String str);

    void t(List<String> list);

    void u(SearchResultBean searchResultBean);

    void x0(List<? extends LiveRoomEntity> list);
}
