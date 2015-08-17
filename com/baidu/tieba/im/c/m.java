package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ a bDl;
    private final /* synthetic */ OfficialChatMessage bDr;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.bDl = aVar;
        this.bDr = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Tj().a(com.baidu.tieba.im.util.h.o(this.bDr), this.val$list, false));
    }
}
