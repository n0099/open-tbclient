package com.baidu.tieba;

import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.live.feed.search.model.data.SearchResultBean;
import java.util.List;
/* loaded from: classes4.dex */
public interface eb0 {
    void B0();

    void X0(List<String> list);

    void e0();

    void f0(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2);

    void k(int i);

    void l();

    void q(fb0 fb0Var);

    void showToast(String str);

    void t(List<String> list);

    void u(SearchResultBean searchResultBean);

    void w0(List<? extends LiveRoomEntity> list);
}
