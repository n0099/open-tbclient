package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ a bHA;
    private final /* synthetic */ CommonGroupChatMessage bHF;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.bHA = aVar;
        this.bHF = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.TW().a(this.bHF.getGroupId(), this.val$list, false));
    }
}
