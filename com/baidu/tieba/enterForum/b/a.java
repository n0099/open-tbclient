package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T ccr;
    private T ccs;

    public a(T t, T t2) {
        this.ccr = t;
        this.ccs = t2;
        setType(1);
    }

    public T acA() {
        return this.ccr;
    }

    public T acB() {
        return this.ccs;
    }
}
