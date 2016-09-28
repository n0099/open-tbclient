package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ a dlX;
    private final /* synthetic */ OfficialChatMessage dme;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.dlX = aVar;
        this.dme = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.asS().a(com.baidu.tieba.im.util.h.p(this.dme), this.val$list, false));
    }
}
