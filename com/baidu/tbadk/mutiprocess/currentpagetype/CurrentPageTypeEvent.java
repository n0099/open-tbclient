package com.baidu.tbadk.mutiprocess.currentpagetype;

import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes3.dex */
public class CurrentPageTypeEvent extends SerializableEvent {
    public CurrentPageTypeHelper.PageType currentPageType;

    public CurrentPageTypeEvent(CurrentPageTypeHelper.PageType pageType) {
        this.currentPageType = pageType;
        setType(3);
    }
}
