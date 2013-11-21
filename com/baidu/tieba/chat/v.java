package com.baidu.tieba.chat;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class v extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecentChatFriendData f1153a;
    final /* synthetic */ u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, RecentChatFriendData recentChatFriendData) {
        this.b = uVar;
        this.f1153a = recentChatFriendData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        if (this.f1153a != null) {
            this.f1153a.setUnReadCount(0);
            com.baidu.adp.lib.h.d.d("updates before updates:" + this.f1153a.getUnReadCount() + "ownerName" + this.f1153a.getOwnerName() + " fid" + this.f1153a.getFriendId() + " uid" + this.f1153a.getOwnerId());
            if (this.f1153a.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.g.a().a("apply_join_group");
                com.baidu.tieba.im.pushNotify.a.g().b(this.f1153a);
            } else if (this.f1153a.getOwnerName().equals("3")) {
                com.baidu.tieba.im.pushNotify.a.g().c(this.f1153a);
                com.baidu.adp.lib.h.d.d("updates data.getOwnerName():" + this.f1153a.getOwnerName());
                com.baidu.tieba.im.db.g.a().a("group_intro_change");
                com.baidu.tieba.im.db.g.a().a("group_name_change");
                com.baidu.tieba.im.db.g.a().a("group_notice_change");
                com.baidu.tieba.im.db.g.a().a("group_level_up");
            }
        }
        return null;
    }
}
