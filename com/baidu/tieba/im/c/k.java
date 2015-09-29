package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ a bGU;
    private final /* synthetic */ PersonalChatMessage bHa;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bGU = aVar;
        this.bHa = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.TU().a(com.baidu.tieba.im.util.h.o(this.bHa), this.val$list, false));
    }
}
