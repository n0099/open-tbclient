package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes5.dex */
public interface ao<T> extends wn<T> {
    int g(int i, int i2);

    in<vn, TypeAdapter.ViewHolder> h(vn vnVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
