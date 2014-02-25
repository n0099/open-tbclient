package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import java.util.LinkedList;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.c<Boolean> {
    private final /* synthetic */ String a;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, LinkedList linkedList) {
        this.a = str;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().a(this.a, this.c, true));
    }
}
