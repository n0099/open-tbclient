package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.card.a;
/* loaded from: classes5.dex */
public class a<T extends com.baidu.tieba.card.a> extends v.a {
    protected T fIB;

    public a(T t) {
        super(t.getView());
        this.fIB = t;
    }

    public T btc() {
        return this.fIB;
    }
}
