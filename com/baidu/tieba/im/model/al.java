package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ MsglistModel b;
    private final /* synthetic */ PersonalChatMessage c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(MsglistModel msglistModel, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.b = msglistModel;
        this.c = personalChatMessage;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(this.c.getUserId(), this.c.getToUserId(), this.d, false));
    }
}
