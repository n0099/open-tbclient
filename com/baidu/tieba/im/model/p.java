package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ChatMessage;
import java.util.Comparator;
/* loaded from: classes.dex */
class p implements Comparator<ChatMessage> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistModel f1824a;

    private p(MsglistModel msglistModel) {
        this.f1824a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(MsglistModel msglistModel, i iVar) {
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
