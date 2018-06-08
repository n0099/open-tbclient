package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cRu;
    private T cRv;

    public a(T t, T t2) {
        this.cRu = t;
        this.cRv = t2;
        setType(1);
    }

    public T aox() {
        return this.cRu;
    }

    public T aoy() {
        return this.cRv;
    }
}
