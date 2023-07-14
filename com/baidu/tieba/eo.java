package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public interface eo<V extends ViewGroup> {
    void addAdapters(List<ln> list);

    List<yn> getData();

    zn getListAdapter();

    V getListView();

    void setData(List<? extends yn> list);
}
