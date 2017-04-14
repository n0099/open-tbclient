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
    final /* synthetic */ ResponsePullMessage dcn;
    private final /* synthetic */ ImMessageCenterPojo dcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.dcn = responsePullMessage;
        this.dcp = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            j.apD().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.dcp != null) {
                if (userType == 1 || userType == 3) {
                    this.dcp.setGid(String.valueOf("-1000"));
                    this.dcp.setCustomGroupType(-8);
                    if (i == 0) {
                        this.dcp.setUnread_count(0);
                    } else if (i == 1) {
                        this.dcp.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.dcp.setIs_hidden(0);
                    }
                    j.apD().a(this.dcp, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
        l.apI().a(b.c(str, 0L), list, true);
    }
}
