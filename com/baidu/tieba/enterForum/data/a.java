package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cXM;
    private T cXN;

    public a(T t, T t2) {
        this.cXM = t;
        this.cXN = t2;
        setType(1);
    }

    public T aqf() {
        return this.cXM;
    }

    public T aqg() {
        return this.cXN;
    }
}
