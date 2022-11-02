package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes3.dex */
public interface co<V extends ViewGroup> {
    void a(List<jn> list);

    List<wn> getData();

    xn getListAdapter();

    V getListView();

    void setData(List<? extends wn> list);
}
