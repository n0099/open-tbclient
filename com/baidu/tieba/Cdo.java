package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* renamed from: com.baidu.tieba.do  reason: invalid class name */
/* loaded from: classes5.dex */
public interface Cdo<V extends ViewGroup> {
    void addAdapters(List<kn> list);

    List<xn> getData();

    yn getListAdapter();

    V getListView();

    void setData(List<? extends xn> list);
}
