package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public interface bo<V extends ViewGroup> {
    void addAdapters(List<in> list);

    List<vn> getData();

    wn getListAdapter();

    V getListView();

    void setData(List<? extends vn> list);
}
