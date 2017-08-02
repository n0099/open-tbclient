package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T bWK;
    private T bWL;

    public a(T t, T t2) {
        this.bWK = t;
        this.bWL = t2;
        setType(1);
    }

    public T abc() {
        return this.bWK;
    }

    public T abd() {
        return this.bWL;
    }
}
