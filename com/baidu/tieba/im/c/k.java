package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ a bpy;
    private final /* synthetic */ LinkedList val$list;
    private final /* synthetic */ PersonalChatMessage val$personalChatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.bpy = aVar;
        this.val$personalChatMessage = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.RC().a(com.baidu.tieba.im.util.i.o(this.val$personalChatMessage), this.val$list, false));
    }
}
