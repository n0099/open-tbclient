package com.baidu.tbadk.pageStayDuration;

import java.util.List;
/* loaded from: classes5.dex */
public interface IPageStayDuration {
    String getCurrentPageKey();

    List<String> getCurrentPageSourceKeyList();

    List<String> getNextPageSourceKeyList();

    PageStayDurationItem getPageStayDurationItem();

    PageStayDurationFilter getPageStayFilter();
}
