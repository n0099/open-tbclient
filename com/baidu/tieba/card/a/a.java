package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.card.b;
/* loaded from: classes8.dex */
public class a<T extends b> extends aa.a {
    protected T gIN;

    public a(T t) {
        super(t.getView());
        this.gIN = t;
    }

    public T bLW() {
        return this.gIN;
    }
}
