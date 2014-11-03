package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w aOa;
    private final /* synthetic */ OfficialChatMessage aOi;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(w wVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.aOa = wVar;
        this.aOi = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.MT().a(com.baidu.tieba.im.util.i.o(this.aOi), this.val$list, false));
    }
}
