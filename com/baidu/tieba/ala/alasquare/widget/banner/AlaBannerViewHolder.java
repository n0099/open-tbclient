package com.baidu.tieba.ala.alasquare.widget.banner;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes4.dex */
public abstract class AlaBannerViewHolder<T> extends RecyclerView.ViewHolder {
    public AlaBannerViewHolder(View view) {
        super(view);
        b(view);
    }

    public abstract void a(int i, T t);

    public abstract void b(View view);

    public abstract void c(int i);
}
