package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.chat.receiveChatMsgHandler.b {
    final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.a = aaVar;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        if (imMessageCenterPojo != null) {
            c.b().a(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(String str, List<CommonMsgPojo> list) {
    }
}
