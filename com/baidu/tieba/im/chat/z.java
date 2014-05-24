package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ CommonGroupChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.a = wVar;
        this.b = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.b);
        BdLog.d("SHANG sendMessage to queue");
    }
}
