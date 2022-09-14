package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes4.dex */
public interface fo<V extends ViewGroup> {
    int getContentViewsCount();

    int getFooterViewsCount();

    int getHeaderViewsCount();

    V getListView();

    boolean removeHeaderView(View view2);
}
