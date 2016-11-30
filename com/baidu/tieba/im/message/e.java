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
    final /* synthetic */ ResponsePullMessage dpv;
    private final /* synthetic */ ImMessageCenterPojo dpx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.dpv = responsePullMessage;
        this.dpx = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.auK().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.dpx != null) {
                if (userType == 1 || userType == 3) {
                    this.dpx.setGid(String.valueOf("-1000"));
                    this.dpx.setCustomGroupType(-8);
                    if (i == 0) {
                        this.dpx.setUnread_count(0);
                    } else if (i == 1) {
                        this.dpx.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.dpx.setIs_hidden(0);
                    }
                    i.auK().a(this.dpx, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        k.auP().a(b.c(str, 0L), list, true);
    }
}
