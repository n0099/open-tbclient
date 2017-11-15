package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cjV;
    private T cjW;

    public a(T t, T t2) {
        this.cjV = t;
        this.cjW = t2;
        setType(1);
    }

    public T aeR() {
        return this.cjV;
    }

    public T aeS() {
        return this.cjW;
    }
}
