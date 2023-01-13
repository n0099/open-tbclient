package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* renamed from: com.baidu.tieba.do  reason: invalid class name */
/* loaded from: classes4.dex */
public interface Cdo<T> extends zn<T> {
    int b(int i, int i2);

    ln<yn, TypeAdapter.ViewHolder> c(yn ynVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
