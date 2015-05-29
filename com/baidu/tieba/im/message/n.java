package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bnA;
    private final /* synthetic */ ImMessageCenterPojo bnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bnA = responsePullMessage;
        this.bnC = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.Rv().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bnC != null) {
                if (userType == 1 || userType == 3) {
                    this.bnC.setGid(String.valueOf("-1000"));
                    this.bnC.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bnC.setUnread_count(0);
                    } else if (i == 1) {
                        this.bnC.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bnC.setIs_hidden(0);
                    }
                    com.baidu.tieba.im.db.k.Rv().a(this.bnC, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.m.RA().a(com.baidu.adp.lib.g.c.c(str, 0L), list, true);
    }
}
