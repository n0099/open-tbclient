package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes6.dex */
public interface hn<T> extends dn<T> {
    int g(int i, int i2);

    pm<cn, TypeAdapter.ViewHolder> h(cn cnVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
