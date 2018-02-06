package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.card.a;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.card.a> extends r.a {
    protected T dbp;

    public a(T t) {
        super(t.getView());
        this.dbp = t;
    }

    public T alY() {
        return this.dbp;
    }
}
