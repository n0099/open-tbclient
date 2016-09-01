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
    final /* synthetic */ ResponsePullMessage dio;
    private final /* synthetic */ ImMessageCenterPojo diq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.dio = responsePullMessage;
        this.diq = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.aso().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.diq != null) {
                if (userType == 1 || userType == 3) {
                    this.diq.setGid(String.valueOf("-1000"));
                    this.diq.setCustomGroupType(-8);
                    if (i == 0) {
                        this.diq.setUnread_count(0);
                    } else if (i == 1) {
                        this.diq.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.diq.setIs_hidden(0);
                    }
                    i.aso().a(this.diq, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        k.ast().a(b.c(str, 0L), list, true);
    }
}
