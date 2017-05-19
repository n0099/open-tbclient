package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T bGh;
    private T bGi;

    public a(T t, T t2) {
        this.bGh = t;
        this.bGi = t2;
        setType(1);
    }

    public T VR() {
        return this.bGh;
    }

    public T VS() {
        return this.bGi;
    }
}
