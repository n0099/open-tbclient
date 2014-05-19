package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ k b;
    private final /* synthetic */ ImMessageCenterShowItemData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.b = kVar;
        this.c = imMessageCenterShowItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.c != null) {
            this.c.setUnReadCount(0);
            BdLog.d("updates before updates:" + this.c.getUnReadCount() + "ownerName" + this.c.getOwnerName() + " fid" + this.c.getFriendId() + " uid" + this.c.getOwnerId());
            if (this.c.getOwnerName().equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                com.baidu.tieba.im.db.d.a().a("apply_join_group");
                com.baidu.tieba.im.pushNotify.a.f().b(this.c);
            } else if (this.c.getOwnerName().equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
                com.baidu.tieba.im.pushNotify.a.f().d(this.c);
                BdLog.d("updates data.getOwnerName():" + this.c.getOwnerName());
                com.baidu.tieba.im.db.d.a().a("group_intro_change");
                com.baidu.tieba.im.db.d.a().a("group_name_change");
                com.baidu.tieba.im.db.d.a().a("group_notice_change");
                com.baidu.tieba.im.db.d.a().a("group_level_up");
                com.baidu.tieba.im.db.d.a().a("dismiss_group");
                com.baidu.tieba.im.db.d.a().a("kick_out");
                com.baidu.tieba.im.db.d.a().a("group_activitys_change");
            } else if (this.c.getOwnerName().equals("6")) {
                com.baidu.tieba.im.pushNotify.a.f().c(this.c);
                BdLog.d("live notify data.getOwnerName():" + this.c.getOwnerName());
                com.baidu.tieba.im.db.d.a().a("live_notify");
            }
        }
        return null;
    }
}
