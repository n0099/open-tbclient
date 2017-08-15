package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T bYC;
    private T bYD;

    public a(T t, T t2) {
        this.bYC = t;
        this.bYD = t2;
        setType(1);
    }

    public T abC() {
        return this.bYC;
    }

    public T abD() {
        return this.bYD;
    }
}
