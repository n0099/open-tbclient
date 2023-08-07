package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes5.dex */
public interface dn<T> extends zm<T> {
    int g(int i, int i2);

    lm<ym, TypeAdapter.ViewHolder> h(ym ymVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
