package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ PersonalChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(w wVar, PersonalChatMessage personalChatMessage) {
        this.a = wVar;
        this.b = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.b);
        com.baidu.tieba.im.b.e.a(2, this.b, String.valueOf(this.b.getToUserId()));
    }
}
