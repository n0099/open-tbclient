package com.baidu.tieba.im.b;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
final class f implements d {
    @Override // com.baidu.tieba.im.b.d
    public final void a(ImMessageCenterPojo imMessageCenterPojo) {
        int a = com.baidu.adp.lib.f.b.a(imMessageCenterPojo.getGid(), 0);
        if (a != 0 && imMessageCenterPojo.getIs_delete() == 0) {
            com.baidu.tbadk.coreExtra.messageCenter.d.a().a(a, imMessageCenterPojo.getPulled_msgId() / 100);
        }
    }
}
