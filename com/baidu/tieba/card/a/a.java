package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.card.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tieba.card.a> extends v.a {
    protected T emq;

    public a(T t) {
        super(t.getView());
        this.emq = t;
    }

    public T aRg() {
        return this.emq;
    }
}
