package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T bSw;
    private T bSx;

    public a(T t, T t2) {
        this.bSw = t;
        this.bSx = t2;
        setType(1);
    }

    public T aaq() {
        return this.bSw;
    }

    public T aar() {
        return this.bSx;
    }
}
