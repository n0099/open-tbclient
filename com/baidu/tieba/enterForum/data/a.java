package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dlP;
    private T dlQ;

    public a(T t, T t2) {
        this.dlP = t;
        this.dlQ = t2;
        setType(1);
    }

    public T apo() {
        return this.dlP;
    }

    public T app() {
        return this.dlQ;
    }
}
