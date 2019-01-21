package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes4.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dru;
    private T drv;

    public a(T t, T t2) {
        this.dru = t;
        this.drv = t2;
        setType(1);
    }

    public T awa() {
        return this.dru;
    }

    public T awb() {
        return this.drv;
    }
}
