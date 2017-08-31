package com.baidu.tieba.enterForum.b;

import com.baidu.tieba.enterForum.b.e;
/* loaded from: classes.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cbA;
    private T cbz;

    public a(T t, T t2) {
        this.cbz = t;
        this.cbA = t2;
        setType(1);
    }

    public T acC() {
        return this.cbz;
    }

    public T acD() {
        return this.cbA;
    }
}
