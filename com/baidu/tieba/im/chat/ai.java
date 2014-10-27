package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w aNM;
    private final /* synthetic */ OfficialChatMessage aNU;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(w wVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.aNM = wVar;
        this.aNU = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.MP().a(com.baidu.tieba.im.util.i.o(this.aNU), this.val$list, false));
    }
}
