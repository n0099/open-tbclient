package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w aOa;
    private final /* synthetic */ PersonalChatMessage aOh;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(w wVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.aOa = wVar;
        this.aOh = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.MU().a(com.baidu.tieba.im.util.i.o(this.aOh), this.val$list, false));
    }
}
