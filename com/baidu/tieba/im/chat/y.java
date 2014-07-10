package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w b;
    private final /* synthetic */ CommonGroupChatMessage c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.b = wVar;
        this.c = commonGroupChatMessage;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(this.c.getGroupId(), this.d, false));
    }
}
