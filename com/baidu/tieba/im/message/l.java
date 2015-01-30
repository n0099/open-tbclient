package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bjv;
    private final /* synthetic */ ImMessageCenterPojo bjx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bjv = responsePullMessage;
        this.bjx = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.MZ().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bjx != null) {
                if (userType == 1 || userType == 3) {
                    this.bjx.setGid(String.valueOf("-1000"));
                    this.bjx.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bjx.setUnread_count(0);
                    } else if (i == 1) {
                        this.bjx.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bjx.setIs_hidden(0);
                    }
                    com.baidu.tieba.im.db.k.MZ().a(this.bjx, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.n.Nj().a(com.baidu.adp.lib.g.c.a(str, 0L), list, true);
    }
}
