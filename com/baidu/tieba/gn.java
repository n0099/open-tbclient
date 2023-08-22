package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes6.dex */
public interface gn<T> extends cn<T> {
    int g(int i, int i2);

    om<bn, TypeAdapter.ViewHolder> h(bn bnVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
