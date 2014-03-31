package com.baidu.tieba.im.chat.notify;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
final class i extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ h b;
    private final /* synthetic */ ImMessageCenterShowItemData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.b = hVar;
        this.c = imMessageCenterShowItemData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        if (this.c != null) {
            this.c.setUnReadCount(0);
            com.baidu.adp.lib.util.f.e("updates before updates:" + this.c.getUnReadCount() + "ownerName" + this.c.getOwnerName() + " fid" + this.c.getFriendId() + " uid" + this.c.getOwnerId());
            if (this.c.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.d.a().a("apply_join_group");
                com.baidu.tieba.im.pushNotify.a.d().a(this.c);
                return null;
            } else if (this.c.getOwnerName().equals("3")) {
                com.baidu.tieba.im.pushNotify.a.d().b(this.c);
                com.baidu.adp.lib.util.f.e("updates data.getOwnerName():" + this.c.getOwnerName());
                com.baidu.tieba.im.db.d.a().a("group_intro_change");
                com.baidu.tieba.im.db.d.a().a("group_name_change");
                com.baidu.tieba.im.db.d.a().a("group_notice_change");
                com.baidu.tieba.im.db.d.a().a("group_level_up");
                com.baidu.tieba.im.db.d.a().a("dismiss_group");
                com.baidu.tieba.im.db.d.a().a("kick_out");
                com.baidu.tieba.im.db.d.a().a("group_activitys_change");
                return null;
            } else {
                return null;
            }
        }
        return null;
    }
}
