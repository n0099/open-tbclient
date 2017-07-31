package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T bXQ;
    private T bXR;

    public a(T t, T t2) {
        this.bXQ = t;
        this.bXR = t2;
        setType(1);
    }

    public T abh() {
        return this.bXQ;
    }

    public T abi() {
        return this.bXR;
    }
}
