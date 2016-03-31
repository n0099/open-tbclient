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
    final /* synthetic */ ResponsePullMessage cnx;
    private final /* synthetic */ ImMessageCenterPojo cnz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cnx = responsePullMessage;
        this.cnz = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.aey().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.cnz != null) {
                if (userType == 1 || userType == 3) {
                    this.cnz.setGid(String.valueOf("-1000"));
                    this.cnz.setCustomGroupType(-8);
                    if (i == 0) {
                        this.cnz.setUnread_count(0);
                    } else if (i == 1) {
                        this.cnz.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.cnz.setIs_hidden(0);
                    }
                    i.aey().a(this.cnz, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void d(String str, List<CommonMsgPojo> list) {
        k.aeD().a(b.c(str, 0L), list, true);
    }
}
