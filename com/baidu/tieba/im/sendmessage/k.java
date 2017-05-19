package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.v<Boolean> {
    final /* synthetic */ a daU;
    private final /* synthetic */ PersonalChatMessage dba;
    private final /* synthetic */ LinkedList val$list;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.daU = aVar;
        this.dba = personalChatMessage;
        this.val$list = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.anD().a(com.baidu.tieba.im.util.h.p(this.dba), this.val$list, false));
    }
}
