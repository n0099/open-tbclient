package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dpb;
    private T dpc;

    public a(T t, T t2) {
        this.dpb = t;
        this.dpc = t2;
        setType(1);
    }

    public T aqi() {
        return this.dpb;
    }

    public T aqj() {
        return this.dpc;
    }
}
