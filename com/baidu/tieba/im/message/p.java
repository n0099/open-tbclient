package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.im.chat.receiveChatMsgHandler.b {
    final /* synthetic */ ResponsePullMessage a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ResponsePullMessage responsePullMessage) {
        this.a = responsePullMessage;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.c.a().a(str, list, true);
    }
}
