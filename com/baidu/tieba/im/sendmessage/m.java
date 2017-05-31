package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.util.v<Boolean> {
    final /* synthetic */ a dgr;
    private final /* synthetic */ OfficialChatMessage dgy;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.dgr = aVar;
        this.dgy = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.aoC().a(com.baidu.tieba.im.util.h.p(this.dgy), this.val$list, false));
    }
}
