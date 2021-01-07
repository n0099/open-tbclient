package com.baidu.tieba.card.holder;

import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.card.b;
/* loaded from: classes.dex */
public class CardViewHolder<T extends b> extends TypeAdapter.ViewHolder {
    protected T iAP;

    public CardViewHolder(T t) {
        super(t.getView());
        this.iAP = t;
    }

    public T cvH() {
        return this.iAP;
    }
}
