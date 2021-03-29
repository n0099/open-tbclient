package com.baidu.tieba.horizonalList.widget;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.i0.a1.b.c;
/* loaded from: classes3.dex */
public abstract class ItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f17526a;

    public ItemViewHolder(View view) {
        super(view);
    }

    public abstract void b(c cVar);

    public abstract ItemViewHolder c(View view);

    public abstract void d(int i);

    public void e(View.OnClickListener onClickListener) {
        this.f17526a = onClickListener;
    }
}
