package com.baidu.tieba.chat;

import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class w extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecentChatFriendData f1201a;
    final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, RecentChatFriendData recentChatFriendData) {
        this.b = vVar;
        this.f1201a = recentChatFriendData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        if (this.f1201a != null) {
            this.f1201a.setUnReadCount(0);
            com.baidu.adp.lib.h.e.d("updates before updates:" + this.f1201a.getUnReadCount() + "ownerName" + this.f1201a.getOwnerName() + " fid" + this.f1201a.getFriendId() + " uid" + this.f1201a.getOwnerId());
            if (this.f1201a.getOwnerName().equals("2")) {
                com.baidu.tieba.im.db.l.a().a("apply_join_group");
                com.baidu.tieba.im.pushNotify.a.h().b(this.f1201a);
            } else if (this.f1201a.getOwnerName().equals("3")) {
                com.baidu.tieba.im.pushNotify.a.h().c(this.f1201a);
                com.baidu.adp.lib.h.e.d("updates data.getOwnerName():" + this.f1201a.getOwnerName());
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
