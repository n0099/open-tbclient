package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.card.a;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.card.a> extends r.a {
    protected T dbd;

    public a(T t) {
        super(t.getView());
        this.dbd = t;
    }

    public T alX() {
        return this.dbd;
    }
}
