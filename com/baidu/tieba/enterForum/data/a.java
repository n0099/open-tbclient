package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes4.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T drt;
    private T dru;

    public a(T t, T t2) {
        this.drt = t;
        this.dru = t2;
        setType(1);
    }

    public T awa() {
        return this.drt;
    }

    public T awb() {
        return this.dru;
    }
}
