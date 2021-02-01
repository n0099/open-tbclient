package com.baidu.tieba.ala.alasquare.widget.banner;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes10.dex */
public abstract class AlaBannerViewHolder<T> extends RecyclerView.ViewHolder {
    protected abstract void am(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void k(int i, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onChangeSkinType(int i);

    public AlaBannerViewHolder(View view) {
        super(view);
        am(view);
    }
}
