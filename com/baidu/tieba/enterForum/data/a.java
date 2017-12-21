package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T csP;
    private T csQ;

    public a(T t, T t2) {
        this.csP = t;
        this.csQ = t2;
        setType(1);
    }

    public T agK() {
        return this.csP;
    }

    public T agL() {
        return this.csQ;
    }
}
