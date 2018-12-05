package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes4.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dnQ;
    private T dnR;

    public a(T t, T t2) {
        this.dnQ = t;
        this.dnR = t2;
        setType(1);
    }

    public T auN() {
        return this.dnQ;
    }

    public T auO() {
        return this.dnR;
    }
}
