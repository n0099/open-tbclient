package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class y implements a.b {
    final /* synthetic */ x dhE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.dhE = xVar;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        if (imMessageCenterPojo != null) {
            b.auN().a(6, imMessageCenterPojo.getPulled_msgId(), String.valueOf(10));
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
    }
}
