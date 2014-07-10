package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import java.util.LinkedList;
/* loaded from: classes.dex */
class v extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ String b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(String str, LinkedList linkedList) {
        this.b = str;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(this.b, this.c, true));
    }
}
