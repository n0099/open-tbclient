package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bju;
    private final /* synthetic */ ImMessageCenterPojo bjw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bju = responsePullMessage;
        this.bjw = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.MU().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bjw != null) {
                if (userType == 1 || userType == 3) {
                    this.bjw.setGid(String.valueOf("-1000"));
                    this.bjw.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bjw.setUnread_count(0);
                    } else if (i == 1) {
                        this.bjw.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bjw.setIs_hidden(0);
                    }
                    com.baidu.tieba.im.db.k.MU().a(this.bjw, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.n.Ne().a(com.baidu.adp.lib.g.c.a(str, 0L), list, true);
    }
}
