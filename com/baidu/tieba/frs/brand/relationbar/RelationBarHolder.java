package com.baidu.tieba.frs.brand.relationbar;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class RelationBarHolder<T extends View> extends RecyclerView.ViewHolder {
    private T joL;

    public RelationBarHolder(T t) {
        super(t);
        this.joL = t;
    }

    public T cFz() {
        return this.joL;
    }
}
