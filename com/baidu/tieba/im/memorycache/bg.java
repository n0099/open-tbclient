package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.tieba.im.chat.receiveChatMsgHandler.b {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.a = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        c.b().a(imMessageCenterPojo);
        c.b().a(-1, imMessageCenterPojo.getPulled_msgId(), String.valueOf(com.baidu.tieba.im.chat.w.a));
        if (z) {
            MessageManager.getInstance().sendMessage(new NewMsgArriveRequestMessage(3));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(String str, List<CommonMsgPojo> list) {
    }
}
