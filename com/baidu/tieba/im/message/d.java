package com.baidu.tieba.im.message;

import com.baidu.adp.lib.h.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ ResponsePullMessage cUp;
    private final /* synthetic */ ImMessageCenterPojo cUq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cUp = responsePullMessage;
        this.cUq = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.apj().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.cUq != null) {
                this.cUq.setGid(String.valueOf("-1001"));
                this.cUq.setCustomGroupType(-7);
                if (i == 0) {
                    this.cUq.setUnread_count(0);
                } else if (i == 1) {
                    this.cUq.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.cUq.setIs_hidden(0);
                }
                i.apj().a(this.cUq, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        l.app().a(b.c(str, 0L), list, true);
    }
}
