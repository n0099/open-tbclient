package com.baidu.tieba.frs.brand.relationbar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes9.dex */
public class b<T extends View> extends RecyclerView.ViewHolder {
    private T hun;

    public b(T t) {
        super(t);
        this.hun = t;
    }

    public T bXG() {
        return this.hun;
    }
}
