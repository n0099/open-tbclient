package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes5.dex */
public interface dn<V extends ViewGroup> {
    int getContentViewsCount();

    int getFooterViewsCount();

    int getHeaderViewsCount();

    V getListView();

    boolean removeHeaderView(View view2);
}
