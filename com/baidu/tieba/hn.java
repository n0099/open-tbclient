package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes6.dex */
public interface hn<V extends ViewGroup> {
    void addAdapters(List<om> list);

    List<bn> getData();

    cn getListAdapter();

    V getListView();

    void setData(List<? extends bn> list);
}
