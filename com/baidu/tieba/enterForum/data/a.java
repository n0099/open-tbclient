package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T csL;
    private T csM;

    public a(T t, T t2) {
        this.csL = t;
        this.csM = t2;
        setType(1);
    }

    public T agL() {
        return this.csL;
    }

    public T agM() {
        return this.csM;
    }
}
