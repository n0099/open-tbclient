package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import java.util.LinkedList;
/* loaded from: classes.dex */
final class b extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String a;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, LinkedList linkedList) {
        this.a = str;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().a(this.a, this.c, true));
    }
}
