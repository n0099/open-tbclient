package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes4.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dgd;
    private T dge;

    public a(T t, T t2) {
        this.dgd = t;
        this.dge = t2;
        setType(1);
    }

    public T atB() {
        return this.dgd;
    }

    public T atC() {
        return this.dge;
    }
}
