package com.baidu.tieba.card.holder;

import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.n0.z.b;
/* loaded from: classes4.dex */
public class CardViewHolder<T extends b> extends TypeAdapter.ViewHolder {

    /* renamed from: e  reason: collision with root package name */
    public T f14285e;

    public CardViewHolder(T t) {
        super(t.l());
        this.f14285e = t;
    }

    public T b() {
        return this.f14285e;
    }
}
