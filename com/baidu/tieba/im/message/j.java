package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bjv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ResponsePullMessage responsePullMessage) {
        this.bjv = responsePullMessage;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.MZ().a(imMessageCenterPojo, 2);
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.c.MQ().a(str, list, true);
    }
}
