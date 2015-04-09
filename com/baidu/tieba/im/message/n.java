package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bkV;
    private final /* synthetic */ ImMessageCenterPojo bkX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bkV = responsePullMessage;
        this.bkX = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.Qg().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bkX != null) {
                if (userType == 1 || userType == 3) {
                    this.bkX.setGid(String.valueOf("-1000"));
                    this.bkX.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bkX.setUnread_count(0);
                    } else if (i == 1) {
                        this.bkX.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bkX.setIs_hidden(0);
                    }
                    com.baidu.tieba.im.db.k.Qg().a(this.bkX, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.m.Ql().a(com.baidu.adp.lib.g.c.a(str, 0L), list, true);
    }
}
