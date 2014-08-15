package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ CommonGroupChatMessage b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MsglistModel msglistModel, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.a = msglistModel;
        this.b = commonGroupChatMessage;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(this.b.getGroupId(), this.c, false));
    }
}
