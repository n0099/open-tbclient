package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes4.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T dqH;
    private T dqI;

    public a(T t, T t2) {
        this.dqH = t;
        this.dqI = t2;
        setType(1);
    }

    public T avC() {
        return this.dqH;
    }

    public T avD() {
        return this.dqI;
    }
}
