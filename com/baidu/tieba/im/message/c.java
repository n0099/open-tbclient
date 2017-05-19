package com.baidu.tieba.im.message;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class c implements a.b {
    final /* synthetic */ ResponsePullMessage cYG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ResponsePullMessage responsePullMessage) {
        this.cYG = responsePullMessage;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        if (imMessageCenterPojo != null) {
            j.anx().a(imMessageCenterPojo, 2);
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.c.ano().b(str, list, true);
    }
}
