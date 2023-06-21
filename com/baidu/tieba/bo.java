package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes5.dex */
public interface bo<T> extends xn<T> {
    int g(int i, int i2);

    jn<wn, TypeAdapter.ViewHolder> h(wn wnVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
