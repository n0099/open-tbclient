package com.baidu.tieba.card.holder;

import com.baidu.adp.widget.ListView.TypeAdapter;
import d.a.o0.z.b;
/* loaded from: classes4.dex */
public class CardViewHolder<T extends b> extends TypeAdapter.ViewHolder {

    /* renamed from: e  reason: collision with root package name */
    public T f14424e;

    public CardViewHolder(T t) {
        super(t.m());
        this.f14424e = t;
    }

    public T b() {
        return this.f14424e;
    }
}
