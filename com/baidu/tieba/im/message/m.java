package com.baidu.tieba.im.message;

import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.chat.receiveChatMsgHandler.b {
    final /* synthetic */ ResponsePullMessage a;
    private final /* synthetic */ ImMessageCenterPojo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.a = responsePullMessage;
        this.b = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.a().a(imMessageCenterPojo, 2);
            if (this.b != null) {
                this.b.setGid(String.valueOf("-1000"));
                this.b.setCustomGroupType(-8);
                if (i == 0) {
                    this.b.setUnread_count(0);
                } else if (i == 1) {
                    this.b.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.b.setIs_hidden(0);
                }
                com.baidu.tieba.im.db.k.a().a(this.b, i2);
            }
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setGid(String.valueOf(w.a));
            imMessageCenterPojo2.setCustomGroupType(-1);
            imMessageCenterPojo2.setIs_hidden(1);
            imMessageCenterPojo2.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            com.baidu.tieba.im.db.k.a().a(imMessageCenterPojo2);
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public void a(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.n.c().a(com.baidu.adp.lib.e.b.a(str, 0L), list, true);
    }
}
