package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cHh;
    private T cHi;

    public a(T t, T t2) {
        this.cHh = t;
        this.cHi = t2;
        setType(1);
    }

    public T akr() {
        return this.cHh;
    }

    public T aks() {
        return this.cHi;
    }
}
