package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage beH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ResponsePullMessage responsePullMessage) {
        this.beH = responsePullMessage;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.MJ().a(imMessageCenterPojo, 2);
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void b(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.c.MA().a(str, list, true);
    }
}
