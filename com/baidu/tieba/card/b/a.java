package com.baidu.tieba.card.b;

import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.card.a;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.card.a> extends y.a {
    private T bgi;

    public a(T t) {
        super(t.getView());
        this.bgi = t;
    }

    public T PP() {
        return this.bgi;
    }
}
