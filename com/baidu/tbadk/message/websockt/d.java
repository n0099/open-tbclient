package com.baidu.tbadk.message.websockt;

import com.baidu.adp.framework.message.g;
import com.google.protobuf.MessageLite;
/* loaded from: classes.dex */
public abstract class d extends g {
    private int a;

    protected abstract MessageLite h();

    public d(int i) {
        super(i);
        this.a = 0;
    }

    @Override // com.baidu.adp.framework.message.g
    public final Object a() {
        return h();
    }

    public final int k() {
        return this.a;
    }

    public final void g(int i) {
        this.a = i;
    }
}
