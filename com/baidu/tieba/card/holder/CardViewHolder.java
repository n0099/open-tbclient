package com.baidu.tieba.card.holder;

import com.baidu.adp.widget.ListView.TypeAdapter;
import d.b.j0.x.b;
/* loaded from: classes4.dex */
public class CardViewHolder<T extends b> extends TypeAdapter.ViewHolder {

    /* renamed from: e  reason: collision with root package name */
    public T f14954e;

    public CardViewHolder(T t) {
        super(t.m());
        this.f14954e = t;
    }

    public T b() {
        return this.f14954e;
    }
}
