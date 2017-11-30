package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T csC;
    private T csD;

    public a(T t, T t2) {
        this.csC = t;
        this.csD = t2;
        setType(1);
    }

    public T agD() {
        return this.csC;
    }

    public T agE() {
        return this.csD;
    }
}
