package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.n0.c1.b.c;
/* loaded from: classes4.dex */
public abstract class ItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f16805a;

    public ItemViewHolder(View view) {
        super(view);
    }

    public abstract void b(c cVar);

    public abstract ItemViewHolder c(View view);

    public abstract void d(int i2);

    public void e(View.OnClickListener onClickListener) {
        this.f16805a = onClickListener;
    }
}
