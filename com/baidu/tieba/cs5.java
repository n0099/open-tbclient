package com.baidu.tieba;

import java.util.List;
/* loaded from: classes5.dex */
public interface cs5 {
    String getCurrentPageKey();

    List<String> getCurrentPageSourceKeyList();

    List<String> getNextPageSourceKeyList();

    ds5 getPageStayFilter();
}
