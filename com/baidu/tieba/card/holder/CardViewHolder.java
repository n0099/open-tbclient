package com.baidu.tieba.card.holder;

import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.card.b;
/* loaded from: classes.dex */
public class CardViewHolder<T extends b> extends TypeAdapter.ViewHolder {
    protected T iDP;

    public CardViewHolder(T t) {
        super(t.getView());
        this.iDP = t;
    }

    public T cto() {
        return this.iDP;
    }
}
