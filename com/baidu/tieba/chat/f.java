package com.baidu.tieba.chat;

import com.baidu.tieba.data.chat.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class f extends com.baidu.tieba.im.c<Void> {
    final /* synthetic */ e a;
    private final /* synthetic */ ImMessageCenterShowItemData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = eVar;
        this.c = imMessageCenterShowItemData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        if (this.c != null) {
            this.c.setUnReadCount(0);
            com.baidu.adp.lib.util.f.e("updates before updates:" + this.c.getUnReadCount() + "ownerName" + this.c.getOwnerName() + " fid" + this.c.getFriendId() + " uid" + this.c.getOwnerId());
            if (this.c.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.c.a().a("apply_join_group");
                com.baidu.tieba.im.c.a.f().b(this.c);
            } else if (this.c.getOwnerName().equals("3")) {
                com.baidu.tieba.im.c.a.f().c(this.c);
                com.baidu.adp.lib.util.f.e("updates data.getOwnerName():" + this.c.getOwnerName());
                com.baidu.tieba.im.db.c.a().a("group_intro_change");
                com.baidu.tieba.im.db.c.a().a("group_name_change");
                com.baidu.tieba.im.db.c.a().a("group_notice_change");
                com.baidu.tieba.im.db.c.a().a("group_level_up");
                com.baidu.tieba.im.db.c.a().a("dismiss_group");
                com.baidu.tieba.im.db.c.a().a("kick_out");
                com.baidu.tieba.im.db.c.a().a("group_activitys_change");
            }
        }
        return null;
    }
}
