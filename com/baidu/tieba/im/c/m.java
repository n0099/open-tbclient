package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ a bmC;
    private final /* synthetic */ OfficialChatMessage bmI;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.bmC = aVar;
        this.bmI = officialChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.PY().a(com.baidu.tieba.im.util.i.o(this.bmI), this.val$list, false));
    }
}
