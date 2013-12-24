package com.baidu.tieba.chat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.av;
import com.baidu.tieba.ao;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.tieba.mention.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ ChatListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatListFragment chatListFragment) {
        this.a = chatListFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar;
        a aVar2;
        Activity activity;
        com.baidu.tieba.im.a<Void> aVar3;
        Activity activity2;
        com.baidu.tieba.im.a<Void> aVar4;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        int i2;
        int i3;
        int i4;
        if (i >= 0) {
            aVar = this.a.Z;
            long itemId = aVar.getItemId(i);
            if (itemId == -1) {
                i3 = this.a.d;
                if (i3 > 1) {
                    ChatListFragment.f(this.a);
                    ChatListFragment chatListFragment = this.a;
                    i4 = this.a.d;
                    chatListFragment.b(i4, 2);
                }
            } else if (itemId != -2) {
                aVar2 = this.a.Z;
                RecentChatFriendData recentChatFriendData = (RecentChatFriendData) aVar2.getItem(i);
                if (TiebaApplication.h().t()) {
                    activity5 = this.a.c;
                    StatService.onEvent(activity5, "list_to_chat", "chatlistclick", 1);
                }
                if (recentChatFriendData != null) {
                    String ownerName = recentChatFriendData.getOwnerName();
                    if (TextUtils.isEmpty(ownerName)) {
                        b(recentChatFriendData);
                        return;
                    } else if (ownerName.equals(SocialConstants.TRUE)) {
                        com.baidu.tieba.im.c.a h = com.baidu.tieba.im.c.a.h();
                        aVar4 = this.a.aj;
                        h.b(false, aVar4);
                        if (TiebaApplication.h().t()) {
                            activity4 = this.a.c;
                            StatService.onEvent(activity4, "chat_list_to_group", "click", 1);
                        }
                        activity3 = this.a.c;
                        GroupChatActivity.a(activity3, Integer.parseInt(recentChatFriendData.getFriendId()), recentChatFriendData.getFriendName(), 0L, "msg_lstb");
                        return;
                    } else if (recentChatFriendData.getOwnerName().equals("2")) {
                        a(recentChatFriendData);
                        if (t.a().u() != null) {
                            t.a().u().d(0L);
                        }
                        com.baidu.tieba.im.c.a h2 = com.baidu.tieba.im.c.a.h();
                        aVar3 = this.a.aj;
                        h2.b(false, aVar3);
                        activity2 = this.a.c;
                        ValidateActivity.a(activity2);
                        return;
                    } else if (recentChatFriendData.getOwnerName().equals("3")) {
                        a(recentChatFriendData);
                        if (t.a().u() != null) {
                            t.a().u().b(0L);
                        }
                        activity = this.a.c;
                        UpdatesActivity.a(activity);
                        return;
                    } else {
                        b(recentChatFriendData);
                        return;
                    }
                }
                com.baidu.adp.lib.h.e.e(ChatListFragment.class.getName(), "onItemClick", " RecentChatFriendData data is null");
            } else {
                ChatListFragment.g(this.a);
                ChatListFragment chatListFragment2 = this.a;
                i2 = this.a.d;
                chatListFragment2.b(i2, 1);
            }
        }
    }

    private void a(RecentChatFriendData recentChatFriendData) {
        com.baidu.tieba.im.m.a(new i(this, recentChatFriendData), null);
    }

    private void b(RecentChatFriendData recentChatFriendData) {
        Activity activity;
        Activity activity2;
        if (recentChatFriendData.getUnReadCount() > 0) {
            t.a().d(t.a().p() - recentChatFriendData.getUnReadCount());
            t.a().j();
            recentChatFriendData.setUnReadCount(0);
        }
        try {
            long parseLong = Long.parseLong(recentChatFriendData.getFriendId());
            activity = this.a.c;
            ao.a(activity, "tab_msg_personal_chat_click");
            new av("pchat", SocialConstants.TRUE).start();
            activity2 = this.a.c;
            PersonalChatActivity.a(activity2, parseLong, recentChatFriendData.getFriendName(), recentChatFriendData.getFriendPortrait(), 0, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
