package com.baidu.tieba.im.message;

import com.baidu.adp.lib.g.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ ResponsePullMessage cYG;
    private final /* synthetic */ ImMessageCenterPojo cYI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cYG = responsePullMessage;
        this.cYI = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            j.anx().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.cYI != null) {
                if (userType == 1 || userType == 3) {
                    this.cYI.setGid(String.valueOf("-1000"));
                    this.cYI.setCustomGroupType(-8);
                    if (i == 0) {
                        this.cYI.setUnread_count(0);
                    } else if (i == 1) {
                        this.cYI.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.cYI.setIs_hidden(0);
                    }
                    j.anx().a(this.cYI, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
        l.anC().a(b.c(str, 0L), list, true);
    }
}
