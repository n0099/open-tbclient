package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cRV;
    private T cRW;

    public a(T t, T t2) {
        this.cRV = t;
        this.cRW = t2;
        setType(1);
    }

    public T aoq() {
        return this.cRV;
    }

    public T aor() {
        return this.cRW;
    }
}
