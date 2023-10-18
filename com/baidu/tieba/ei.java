package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public interface ei<V extends ViewGroup> {
    void addAdapters(List<lh> list);

    List<yh> getData();

    zh getListAdapter();

    V getListView();

    void setData(List<? extends yh> list);
}
