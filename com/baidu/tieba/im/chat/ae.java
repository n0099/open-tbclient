package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w aNM;
    private final /* synthetic */ CommonGroupChatMessage aNR;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(w wVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.aNM = wVar;
        this.aNR = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Mw().a(this.aNR.getGroupId(), this.val$list, false));
    }
}
