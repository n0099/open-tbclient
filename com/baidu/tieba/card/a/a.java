package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.card.b;
/* loaded from: classes20.dex */
public class a<T extends b> extends af.a {
    protected T idz;

    public a(T t) {
        super(t.getView());
        this.idz = t;
    }

    public T coz() {
        return this.idz;
    }
}
