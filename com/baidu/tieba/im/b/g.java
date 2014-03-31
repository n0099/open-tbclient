package com.baidu.tieba.im.b;

import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements d {
    @Override // com.baidu.tieba.im.b.d
    public final void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (x.a != 0) {
            com.baidu.tbadk.coreExtra.messageCenter.d.a().a(x.a, imMessageCenterPojo.getPulled_msgId() / 100);
        }
    }
}
