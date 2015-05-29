package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bpC;
    final /* synthetic */ a bpx;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, CommonGroupChatMessage commonGroupChatMessage, LinkedList linkedList) {
        this.bpx = aVar;
        this.bpC = commonGroupChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Rm().a(this.bpC.getGroupId(), this.val$list, false));
    }
}
