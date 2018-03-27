package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T doS;
    private T doT;

    public a(T t, T t2) {
        this.doS = t;
        this.doT = t2;
        setType(1);
    }

    public T aqi() {
        return this.doS;
    }

    public T aqj() {
        return this.doT;
    }
}
