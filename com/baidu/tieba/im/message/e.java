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
    final /* synthetic */ ResponsePullMessage dmc;
    private final /* synthetic */ ImMessageCenterPojo dme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.dmc = responsePullMessage;
        this.dme = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            j.asi().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.dme != null) {
                if (userType == 1 || userType == 3) {
                    this.dme.setGid(String.valueOf("-1000"));
                    this.dme.setCustomGroupType(-8);
                    if (i == 0) {
                        this.dme.setUnread_count(0);
                    } else if (i == 1) {
                        this.dme.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.dme.setIs_hidden(0);
                    }
                    j.asi().a(this.dme, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
        l.asn().a(b.c(str, 0L), list, true);
    }
}
