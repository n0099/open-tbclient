package com.baidu.tieba.im.message;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class c implements a.b {
    final /* synthetic */ ResponsePullMessage bFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ResponsePullMessage responsePullMessage) {
        this.bFk = responsePullMessage;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        if (imMessageCenterPojo != null) {
            i.TK().a(imMessageCenterPojo, 2);
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.c.TB().a(str, list, true);
    }
}
