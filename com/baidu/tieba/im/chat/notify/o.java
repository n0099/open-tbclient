package com.baidu.tieba.im.chat.notify;

import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class o extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ l b;
    private final /* synthetic */ ImMessageCenterShowItemData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.b = lVar;
        this.c = imMessageCenterShowItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.c != null) {
            this.c.setUnReadCount(0);
            if (this.c.getOwnerName().equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                com.baidu.tieba.im.db.d.a().a("apply_join_group");
                com.baidu.tieba.im.pushNotify.a.i().b(this.c);
            } else if (this.c.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.pushNotify.a.i().d(this.c);
                com.baidu.tieba.im.db.d.a().a("group_intro_change");
                com.baidu.tieba.im.db.d.a().a("group_name_change");
                com.baidu.tieba.im.db.d.a().a("group_notice_change");
                com.baidu.tieba.im.db.d.a().a("group_level_up");
                com.baidu.tieba.im.db.d.a().a("dismiss_group");
                com.baidu.tieba.im.db.d.a().a("kick_out");
                com.baidu.tieba.im.db.d.a().a("group_activitys_change");
            } else if (this.c.getOwnerName().equals("6")) {
                com.baidu.tieba.im.pushNotify.a.i().c(this.c);
                com.baidu.tieba.im.db.d.a().a("live_notify");
            }
        }
        return null;
    }
}
