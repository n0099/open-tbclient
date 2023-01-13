package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes4.dex */
public interface eo<V extends ViewGroup> {
    void a(List<ln> list);

    List<yn> getData();

    zn getListAdapter();

    V getListView();

    void setData(List<? extends yn> list);
}
