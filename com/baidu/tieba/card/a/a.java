package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.card.b;
/* loaded from: classes21.dex */
public class a<T extends b> extends af.a {
    protected T hKm;

    public a(T t) {
        super(t.getView());
        this.hKm = t;
    }

    public T cjq() {
        return this.hKm;
    }
}
