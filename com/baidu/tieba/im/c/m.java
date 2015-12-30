package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ a caF;
    private final /* synthetic */ OfficialChatMessage caM;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.caF = aVar;
        this.caM = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Yw().a(com.baidu.tieba.im.util.h.o(this.caM), this.val$list, false));
    }
}
