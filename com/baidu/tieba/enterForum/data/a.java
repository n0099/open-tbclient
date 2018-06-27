package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cPp;
    private T cPq;

    public a(T t, T t2) {
        this.cPp = t;
        this.cPq = t2;
        setType(1);
    }

    public T anR() {
        return this.cPp;
    }

    public T anS() {
        return this.cPq;
    }
}
