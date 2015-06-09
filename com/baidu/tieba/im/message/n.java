package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bnB;
    private final /* synthetic */ ImMessageCenterPojo bnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bnB = responsePullMessage;
        this.bnD = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.Rw().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bnD != null) {
                if (userType == 1 || userType == 3) {
                    this.bnD.setGid(String.valueOf("-1000"));
                    this.bnD.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bnD.setUnread_count(0);
                    } else if (i == 1) {
                        this.bnD.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bnD.setIs_hidden(0);
                    }
                    com.baidu.tieba.im.db.k.Rw().a(this.bnD, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.m.RB().a(com.baidu.adp.lib.g.c.c(str, 0L), list, true);
    }
}
