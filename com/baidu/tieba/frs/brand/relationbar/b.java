package com.baidu.tieba.frs.brand.relationbar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes4.dex */
public class b<T extends View> extends RecyclerView.ViewHolder {
    private T fBH;

    public b(T t) {
        super(t);
        this.fBH = t;
    }

    public T boI() {
        return this.fBH;
    }
}
