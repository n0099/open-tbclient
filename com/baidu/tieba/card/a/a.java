package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.a;
/* loaded from: classes6.dex */
public class a<T extends com.baidu.tieba.card.a> extends q.a {
    protected T dcH;

    public a(T t) {
        super(t.getView());
        this.dcH = t;
    }

    public T arr() {
        return this.dcH;
    }
}
