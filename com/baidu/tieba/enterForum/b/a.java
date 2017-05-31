package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T bLW;
    private T bLX;

    public a(T t, T t2) {
        this.bLW = t;
        this.bLX = t2;
        setType(1);
    }

    public T WU() {
        return this.bLW;
    }

    public T WV() {
        return this.bLX;
    }
}
