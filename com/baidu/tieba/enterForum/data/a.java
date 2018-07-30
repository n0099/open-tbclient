package com.baidu.tieba.enterForum.data;

import com.baidu.tieba.enterForum.data.e;
/* loaded from: classes2.dex */
public class a<T extends e> extends c implements com.baidu.tbadk.mvc.b.a {
    private T cRY;
    private T cRZ;

    public a(T t, T t2) {
        this.cRY = t;
        this.cRZ = t2;
        setType(1);
    }

    public T aoq() {
        return this.cRY;
    }

    public T aor() {
        return this.cRZ;
    }
}
