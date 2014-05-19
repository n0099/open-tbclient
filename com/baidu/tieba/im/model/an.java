package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ MsglistModel b;
    private final /* synthetic */ OfficialChatMessage c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MsglistModel msglistModel, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.b = msglistModel;
        this.c = officialChatMessage;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.d().a(this.c.getUserId(), this.c.getToUserId(), this.d, false));
    }
}
