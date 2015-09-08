package com.baidu.tieba.im.message;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ ResponsePullMessage bBV;
    private final /* synthetic */ ImMessageCenterPojo bBX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bBV = responsePullMessage;
        this.bBX = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.Tg().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bBX != null) {
                if (userType == 1 || userType == 3) {
                    this.bBX.setGid(String.valueOf("-1000"));
                    this.bBX.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bBX.setUnread_count(0);
                    } else if (i == 1) {
                        this.bBX.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bBX.setIs_hidden(0);
                    }
                    i.Tg().a(this.bBX, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        k.Tl().a(com.baidu.adp.lib.g.b.c(str, 0L), list, true);
    }
}
