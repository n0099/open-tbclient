package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T doP;
    private T doQ;

    public a(T t, T t2) {
        this.doP = t;
        this.doQ = t2;
        setType(1);
    }

    public T aqh() {
        return this.doP;
    }

    public T aqi() {
        return this.doQ;
    }
}
