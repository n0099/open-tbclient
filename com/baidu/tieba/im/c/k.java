package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ a cfe;
    private final /* synthetic */ PersonalChatMessage cfk;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.cfe = aVar;
        this.cfk = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.abi().a(com.baidu.tieba.im.util.h.o(this.cfk), this.val$list, false));
    }
}
