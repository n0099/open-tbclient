package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T bYD;
    private T bYE;

    public a(T t, T t2) {
        this.bYD = t;
        this.bYE = t2;
        setType(1);
    }

    public T abz() {
        return this.bYD;
    }

    public T abA() {
        return this.bYE;
    }
}
