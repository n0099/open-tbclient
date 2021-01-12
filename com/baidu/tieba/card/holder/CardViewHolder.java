package com.baidu.tieba.card.holder;

import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.card.b;
/* loaded from: classes.dex */
public class CardViewHolder<T extends b> extends TypeAdapter.ViewHolder {
    protected T iwi;

    public CardViewHolder(T t) {
        super(t.getView());
        this.iwi = t;
    }

    public T crP() {
        return this.iwi;
    }
}
