package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w aOa;
    private final /* synthetic */ CommonGroupChatMessage aOf;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(w wVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.aOa = wVar;
        this.aOf = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.MA().a(this.aOf.getGroupId(), this.val$list, false));
    }
}
