package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.card.b;
/* loaded from: classes15.dex */
public class a<T extends b> extends af.a {
    protected T hoj;

    public a(T t) {
        super(t.getView());
        this.hoj = t;
    }

    public T ccE() {
        return this.hoj;
    }
}
