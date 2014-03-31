package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends com.baidu.tieba.im.m<Boolean> {
    private final /* synthetic */ long b;
    private final /* synthetic */ long c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(long j, long j2, LinkedList linkedList) {
        this.b = j;
        this.c = j2;
        this.d = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.d().a(this.b, this.c, this.d, true));
    }
}
