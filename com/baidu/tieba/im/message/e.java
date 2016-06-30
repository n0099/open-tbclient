package com.baidu.tieba.im.message;

import com.baidu.adp.lib.h.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ ResponsePullMessage cTJ;
    private final /* synthetic */ ImMessageCenterPojo cTL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cTJ = responsePullMessage;
        this.cTL = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.amO().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.cTL != null) {
                if (userType == 1 || userType == 3) {
                    this.cTL.setGid(String.valueOf("-1000"));
                    this.cTL.setCustomGroupType(-8);
                    if (i == 0) {
                        this.cTL.setUnread_count(0);
                    } else if (i == 1) {
                        this.cTL.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.cTL.setIs_hidden(0);
                    }
                    i.amO().a(this.cTL, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        k.amT().a(b.c(str, 0L), list, true);
    }
}
