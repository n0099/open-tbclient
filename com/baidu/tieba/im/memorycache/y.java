package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class y implements a.b {
    final /* synthetic */ x dbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.dbD = xVar;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        if (imMessageCenterPojo != null) {
            b.asc().a(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
    }
}
