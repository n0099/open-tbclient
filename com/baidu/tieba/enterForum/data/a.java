package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dmk;
    private T dml;

    public a(T t, T t2) {
        this.dmk = t;
        this.dml = t2;
        setType(1);
    }

    public T apt() {
        return this.dmk;
    }

    public T apu() {
        return this.dml;
    }
}
