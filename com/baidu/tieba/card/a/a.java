package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.card.a;
/* loaded from: classes3.dex */
public class a<T extends com.baidu.tieba.card.a> extends v.a {
    protected T eGZ;

    public a(T t) {
        super(t.getView());
        this.eGZ = t;
    }

    public T bar() {
        return this.eGZ;
    }
}
