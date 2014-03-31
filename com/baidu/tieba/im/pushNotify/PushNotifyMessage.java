package com.baidu.tieba.im.pushNotify;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public class PushNotifyMessage extends SocketResponsedMessage {
    private long a;
    private long b;
    private long c;
    private int d;

    @Override // com.baidu.adp.framework.message.c
    public final /* bridge */ /* synthetic */ void a(int i, Object obj) {
    }

    public final int d() {
        return this.d;
    }

    public final void d(int i) {
        this.d = i;
    }

    public final long i() {
        return this.c;
    }

    public final void b(long j) {
        this.c = j;
    }

    public final long j() {
        return this.b;
    }

    public final void c(long j) {
        this.b = j;
    }

    public final long k() {
        return this.a;
    }

    public final void d(long j) {
        this.a = j;
    }

    public PushNotifyMessage() {
        super(202006);
    }
}
