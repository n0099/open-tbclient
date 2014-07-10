package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Comparator;
/* loaded from: classes.dex */
class ba implements Comparator<ChatMessage> {
    final /* synthetic */ MsglistModel a;

    private ba(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(MsglistModel msglistModel, ba baVar) {
        this(msglistModel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ChatMessage chatMessage, ChatMessage chatMessage2) {
        if (chatMessage == null || chatMessage2 == null) {
            return 0;
        }
        if (chatMessage.getRecordId() > chatMessage2.getRecordId()) {
            return 1;
        }
        return chatMessage.getRecordId() < chatMessage2.getRecordId() ? -1 : 0;
    }
}
