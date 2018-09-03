package com.baidu.tieba.card.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.card.a;
/* loaded from: classes2.dex */
public class a<T extends com.baidu.tieba.card.a> extends q.a {
    protected T cDf;

    public a(T t) {
        super(t.getView());
        this.cDf = t;
    }

    public T ajC() {
        return this.cDf;
    }
}
