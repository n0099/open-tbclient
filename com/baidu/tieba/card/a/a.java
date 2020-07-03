package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.card.b;
/* loaded from: classes8.dex */
public class a<T extends b> extends ad.a {
    protected T gVN;

    public a(T t) {
        super(t.getView());
        this.gVN = t;
    }

    public T bPg() {
        return this.gVN;
    }
}
