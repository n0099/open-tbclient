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
    final /* synthetic */ ResponsePullMessage cou;
    private final /* synthetic */ ImMessageCenterPojo cow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cou = responsePullMessage;
        this.cow = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.aex().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.cow != null) {
                if (userType == 1 || userType == 3) {
                    this.cow.setGid(String.valueOf("-1000"));
                    this.cow.setCustomGroupType(-8);
                    if (i == 0) {
                        this.cow.setUnread_count(0);
                    } else if (i == 1) {
                        this.cow.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.cow.setIs_hidden(0);
                    }
                    i.aex().a(this.cow, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        k.aeC().a(b.c(str, 0L), list, true);
    }
}
