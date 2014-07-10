package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import java.util.LinkedList;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ long b;
    private final /* synthetic */ long c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(long j, long j2, LinkedList linkedList) {
        this.b = j;
        this.c = j2;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(this.b, this.c, this.d, true));
    }
}
