package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cjI;
    private T cjJ;

    public a(T t, T t2) {
        this.cjI = t;
        this.cjJ = t2;
        setType(1);
    }

    public T aeF() {
        return this.cjI;
    }

    public T aeG() {
        return this.cjJ;
    }
}
