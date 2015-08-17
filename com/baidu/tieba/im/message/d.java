package com.baidu.tieba.im.message;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ ResponsePullMessage bBo;
    private final /* synthetic */ ImMessageCenterPojo bBq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bBo = responsePullMessage;
        this.bBq = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.Te().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bBq != null) {
                if (userType == 1 || userType == 3) {
                    this.bBq.setGid(String.valueOf("-1000"));
                    this.bBq.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bBq.setUnread_count(0);
                    } else if (i == 1) {
                        this.bBq.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bBq.setIs_hidden(0);
                    }
                    i.Te().a(this.bBq, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        k.Tj().a(com.baidu.adp.lib.g.b.c(str, 0L), list, true);
    }
}
