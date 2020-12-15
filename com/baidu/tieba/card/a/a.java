package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.card.b;
/* loaded from: classes21.dex */
public class a<T extends b> extends af.a {
    protected T iov;

    public a(T t) {
        super(t.getView());
        this.iov = t;
    }

    public T csN() {
        return this.iov;
    }
}
