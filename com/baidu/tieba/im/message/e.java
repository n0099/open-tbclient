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
    final /* synthetic */ ResponsePullMessage cUp;
    private final /* synthetic */ ImMessageCenterPojo cUr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cUp = responsePullMessage;
        this.cUr = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.apj().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.cUr != null) {
                if (userType == 1 || userType == 3) {
                    this.cUr.setGid(String.valueOf("-1000"));
                    this.cUr.setCustomGroupType(-8);
                    if (i == 0) {
                        this.cUr.setUnread_count(0);
                    } else if (i == 1) {
                        this.cUr.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.cUr.setIs_hidden(0);
                    }
                    i.apj().a(this.cUr, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        k.apo().a(b.c(str, 0L), list, true);
    }
}
