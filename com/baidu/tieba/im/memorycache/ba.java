package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tieba.im.chat.receiveChatMsgHandler.b {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.a = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        c.b().a(-2, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(String str, List<CommonMsgPojo> list) {
    }
}
