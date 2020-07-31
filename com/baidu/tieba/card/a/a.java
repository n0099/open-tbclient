package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.card.b;
/* loaded from: classes15.dex */
public class a<T extends b> extends ad.a {
    protected T hbs;

    public a(T t) {
        super(t.getView());
        this.hbs = t;
    }

    public T bSs() {
        return this.hbs;
    }
}
