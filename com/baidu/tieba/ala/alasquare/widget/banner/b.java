package com.baidu.tieba.ala.alasquare.widget.banner;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes4.dex */
public abstract class b<T> extends RecyclerView.ViewHolder {
    protected abstract void al(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void k(int i, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onChangeSkinType(int i);

    public b(View view) {
        super(view);
        al(view);
    }
}
