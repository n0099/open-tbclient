package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ a dgf;
    private final /* synthetic */ CommonGroupChatMessage dgk;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.dgf = aVar;
        this.dgk = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.apB().b(this.dgk.getGroupId(), this.val$list, false));
    }
}
