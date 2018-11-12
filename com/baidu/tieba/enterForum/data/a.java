package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes4.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dhi;
    private T dhj;

    public a(T t, T t2) {
        this.dhi = t;
        this.dhj = t2;
        setType(1);
    }

    public T atb() {
        return this.dhi;
    }

    public T atc() {
        return this.dhj;
    }
}
