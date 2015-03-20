package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bkF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ResponsePullMessage responsePullMessage) {
        this.bkF = responsePullMessage;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        if (imMessageCenterPojo != null) {
            imMessageCenterPojo.setIs_hidden(1);
            com.baidu.tieba.im.db.k.PT().a(imMessageCenterPojo);
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
    }
}
