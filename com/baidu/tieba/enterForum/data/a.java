package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dhn;
    private T dho;

    public a(T t, T t2) {
        this.dhn = t;
        this.dho = t2;
        setType(1);
    }

    public T aol() {
        return this.dhn;
    }

    public T aom() {
        return this.dho;
    }
}
