package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import java.util.LinkedList;
/* loaded from: classes.dex */
final class c extends com.baidu.tieba.im.m<Boolean> {
    private final /* synthetic */ String b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, LinkedList linkedList) {
        this.b = str;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(this.b, this.c, true));
    }
}
