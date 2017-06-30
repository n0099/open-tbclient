package com.baidu.tieba.card.b;

import com.baidu.adp.widget.ListView.z;
import com.baidu.tieba.card.a;
/* loaded from: classes.dex */
public class a<T extends com.baidu.tieba.card.a> extends z.a {
    protected T bFk;

    public a(T t) {
        super(t.getView());
        this.bFk = t;
    }

    public T Wp() {
        return this.bFk;
    }
}
