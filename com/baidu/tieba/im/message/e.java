package com.baidu.tieba.im.message;

import com.baidu.adp.lib.g.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ ResponsePullMessage ddS;
    private final /* synthetic */ ImMessageCenterPojo ddU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.ddS = responsePullMessage;
        this.ddU = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.apK().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.ddU != null) {
                if (userType == 1 || userType == 3) {
                    this.ddU.setGid(String.valueOf("-1000"));
                    this.ddU.setCustomGroupType(-8);
                    if (i == 0) {
                        this.ddU.setUnread_count(0);
                    } else if (i == 1) {
                        this.ddU.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.ddU.setIs_hidden(0);
                    }
                    i.apK().a(this.ddU, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        k.apP().a(b.c(str, 0L), list, true);
    }
}
