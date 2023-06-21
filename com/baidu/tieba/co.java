package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public interface co<V extends ViewGroup> {
    void addAdapters(List<jn> list);

    List<wn> getData();

    xn getListAdapter();

    V getListView();

    void setData(List<? extends wn> list);
}
