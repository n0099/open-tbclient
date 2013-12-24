package com.baidu.tieba.chat;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class i extends SingleRunnable<Void> {
    final /* synthetic */ RecentChatFriendData a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, RecentChatFriendData recentChatFriendData) {
        this.b = hVar;
        this.a = recentChatFriendData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        if (this.a != null) {
            this.a.setUnReadCount(0);
            com.baidu.adp.lib.h.e.d("updates before updates:" + this.a.getUnReadCount() + "ownerName" + this.a.getOwnerName() + " fid" + this.a.getFriendId() + " uid" + this.a.getOwnerId());
            if (this.a.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.l.a().a("apply_join_group");
                com.baidu.tieba.im.c.a.h().b(this.a);
            } else if (this.a.getOwnerName().equals("3")) {
                com.baidu.tieba.im.c.a.h().c(this.a);
                com.baidu.adp.lib.h.e.d("updates data.getOwnerName():" + this.a.getOwnerName());
                com.baidu.tieba.im.db.l.a().a("group_intro_change");
                com.baidu.tieba.im.db.l.a().a("group_name_change");
                com.baidu.tieba.im.db.l.a().a("group_notice_change");
                com.baidu.tieba.im.db.l.a().a("group_level_up");
                com.baidu.tieba.im.db.l.a().a("dismiss_group");
                com.baidu.tieba.im.db.l.a().a("kick_out");
            }
        }
        return null;
    }
}
