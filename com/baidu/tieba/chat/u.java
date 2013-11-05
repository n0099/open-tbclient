package com.baidu.tieba.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ChatListFragment chatListFragment) {
        this.f1113a = chatListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar;
        m mVar2;
        Activity activity;
        com.baidu.tieba.im.a<Void> aVar;
        Activity activity2;
        com.baidu.tieba.im.a<Void> aVar2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            mVar = this.f1113a.aa;
            long itemId = mVar.getItemId(i);
            if (itemId == -1) {
                i3 = this.f1113a.e;
                if (i3 > 1) {
                    ChatListFragment.h(this.f1113a);
                    ChatListFragment chatListFragment = this.f1113a;
                    i4 = this.f1113a.e;
                    chatListFragment.b(i4, 2);
                }
            } else if (itemId != -2) {
                mVar2 = this.f1113a.aa;
                RecentChatFriendData recentChatFriendData = (RecentChatFriendData) mVar2.getItem(i);
                if (TiebaApplication.g().s()) {
                    activity5 = this.f1113a.d;
                    StatService.onEvent(activity5, "list_to_chat", "chatlistclick", 1);
                }
                if (recentChatFriendData != null) {
                    String ownerName = recentChatFriendData.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        b(recentChatFriendData);
                        return;
                    } else if (ownerName.equals(SocialConstants.TRUE)) {
                        com.baidu.tieba.mention.t.a().e();
                        com.baidu.tieba.im.pushNotify.a g = com.baidu.tieba.im.pushNotify.a.g();
                        aVar2 = this.f1113a.aj;
                        g.b(false, aVar2);
                        if (TiebaApplication.g().s()) {
                            activity4 = this.f1113a.d;
                            StatService.onEvent(activity4, "chat_list_to_group", "click", 1);
                        }
                        activity3 = this.f1113a.d;
                        MsglistActivity.a(activity3, Integer.parseInt(recentChatFriendData.getFriendId()), recentChatFriendData.getFriendName(), 0);
                        return;
                    } else if (recentChatFriendData.getOwnerName().equals("2")) {
                        a(recentChatFriendData);
                        if (com.baidu.tieba.mention.t.a().t() != null) {
                            com.baidu.tieba.mention.t.a().t().c(0L);
                        }
                        com.baidu.tieba.mention.t.a().f();
                        com.baidu.tieba.im.pushNotify.a g2 = com.baidu.tieba.im.pushNotify.a.g();
                        aVar = this.f1113a.aj;
                        g2.b(false, aVar);
                        activity2 = this.f1113a.d;
                        ValidateActivity.a(activity2);
                        return;
                    } else if (recentChatFriendData.getOwnerName().equals("3")) {
                        a(recentChatFriendData);
                        if (com.baidu.tieba.mention.t.a().t() != null) {
                            com.baidu.tieba.mention.t.a().t().b(0L);
                        }
                        activity = this.f1113a.d;
                        UpdatesActivity.a(activity);
                        return;
                    } else {
                        b(recentChatFriendData);
                        return;
                    }
                }
                com.baidu.adp.lib.h.d.e(ChatListFragment.class.getName(), "onItemClick", " RecentChatFriendData data is null");
            } else {
                ChatListFragment.i(this.f1113a);
                ChatListFragment chatListFragment2 = this.f1113a;
                i2 = this.f1113a.e;
                chatListFragment2.b(i2, 1);
            }
        }
    }

    private void a(RecentChatFriendData recentChatFriendData) {
        com.baidu.tieba.im.m.a(new v(this, recentChatFriendData), null);
    }

    private void b(RecentChatFriendData recentChatFriendData) {
        Activity activity;
        if (recentChatFriendData.getUnReadCount() > 0) {
            com.baidu.tieba.mention.t.a().d(com.baidu.tieba.mention.t.a().o() - recentChatFriendData.getUnReadCount());
            com.baidu.tieba.mention.t.a().i();
            recentChatFriendData.setUnReadCount(0);
        }
        activity = this.f1113a.d;
        ChatActivity.a(activity, recentChatFriendData.getFriendId(), recentChatFriendData.getFriendName(), recentChatFriendData.getFriendPortrait(), null, "chat_list");
    }
}
