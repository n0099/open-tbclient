package com.baidu.tieba.frs.brand.relationbar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes4.dex */
public class b<T extends View> extends RecyclerView.ViewHolder {
    private T fvW;

    public b(T t) {
        super(t);
        this.fvW = t;
    }

    public T bmr() {
        return this.fvW;
    }
}
