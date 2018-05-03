package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cHe;
    private T cHf;

    public a(T t, T t2) {
        this.cHe = t;
        this.cHf = t2;
        setType(1);
    }

    public T akr() {
        return this.cHe;
    }

    public T aks() {
        return this.cHf;
    }
}
