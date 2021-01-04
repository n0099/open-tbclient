package com.baidu.tieba.frs.brand.relationbar;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class RelationBarHolder<T extends View> extends RecyclerView.ViewHolder {
    private T jnL;

    public RelationBarHolder(T t) {
        super(t);
        this.jnL = t;
    }

    public T cId() {
        return this.jnL;
    }
}
