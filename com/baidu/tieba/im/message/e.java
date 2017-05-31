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
    final /* synthetic */ ResponsePullMessage deg;
    private final /* synthetic */ ImMessageCenterPojo dei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.deg = responsePullMessage;
        this.dei = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            j.aox().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.dei != null) {
                if (userType == 1 || userType == 3) {
                    this.dei.setGid(String.valueOf("-1000"));
                    this.dei.setCustomGroupType(-8);
                    if (i == 0) {
                        this.dei.setUnread_count(0);
                    } else if (i == 1) {
                        this.dei.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.dei.setIs_hidden(0);
                    }
                    j.aox().a(this.dei, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
        l.aoC().a(b.c(str, 0L), list, true);
    }
}
