package com.baidu.tieba.card.holder;

import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.i0.x.b;
/* loaded from: classes4.dex */
public class CardViewHolder<T extends b> extends TypeAdapter.ViewHolder {

    /* renamed from: e  reason: collision with root package name */
    public T f14946e;

    public CardViewHolder(T t) {
        super(t.m());
        this.f14946e = t;
    }

    public T b() {
        return this.f14946e;
    }
}
