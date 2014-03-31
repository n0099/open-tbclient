package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* loaded from: classes.dex */
public abstract class ResponseCommitMessage extends SocketResponsedMessage {
    private long a;
    private long b;
    private String c;

    public ResponseCommitMessage(int i) {
        super(i);
    }

    public final long d() {
        return this.a;
    }

    public final void b(long j) {
        this.a = j;
    }

    public final long i() {
        return this.b;
    }

    public final void c(long j) {
        this.b = j;
    }

    public final String j() {
        return this.c;
    }

    public final void a(String str) {
        this.c = str;
    }
}
