package com.baidu.tieba.chat;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ChatListFragment chatListFragment) {
        this.f1110a = chatListFragment;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        BdListView bdListView;
        int i;
        com.baidu.tieba.model.f fVar;
        Activity activity;
        Activity activity2;
        int i2;
        m mVar;
        m mVar2;
        com.baidu.tieba.model.f fVar2;
        com.baidu.tieba.model.f fVar3;
        m mVar3;
        int i3;
        com.baidu.tieba.model.f fVar4;
        m mVar4;
        com.baidu.tieba.model.f fVar5;
        com.baidu.tieba.model.f fVar6;
        Runnable runnable;
        m mVar5;
        com.baidu.tieba.model.f fVar7;
        int i4;
        BdListView bdListView2;
        m mVar6;
        m mVar7;
        bdListView = this.f1110a.Z;
        bdListView.a();
        i = this.f1110a.i;
        switch (i) {
            case 1:
                mVar2 = this.f1110a.aa;
                mVar2.a(false);
                break;
            case 2:
                mVar = this.f1110a.aa;
                mVar.b(false);
                break;
            case 4:
                if (Boolean.TRUE.equals(obj)) {
                    activity = this.f1110a.d;
                    activity2 = this.f1110a.d;
                    UtilHelper.a((Context) activity, activity2.getString(R.string.delete_user_chat_done));
                    ChatListFragment chatListFragment = this.f1110a;
                    i2 = this.f1110a.e;
                    chatListFragment.b(i2, 3);
                    return;
                }
                ChatListFragment chatListFragment2 = this.f1110a;
                fVar = this.f1110a.c;
                chatListFragment2.b(fVar.getErrorString());
                return;
        }
        if (Boolean.TRUE.equals(obj)) {
            fVar3 = this.f1110a.c;
            if (fVar3.c()) {
                mVar7 = this.f1110a.aa;
                mVar7.d(true);
            } else {
                mVar3 = this.f1110a.aa;
                mVar3.d(false);
            }
            i3 = this.f1110a.e;
            if (i3 > 1) {
                mVar6 = this.f1110a.aa;
                mVar6.c(true);
            } else {
                fVar4 = this.f1110a.c;
                int i5 = 0;
                for (RecentChatFriendData recentChatFriendData : fVar4.a()) {
                    i5 = recentChatFriendData.getUnReadCount() + i5;
                }
                com.baidu.adp.lib.h.d.d("unReadCount:" + i5);
                mVar4 = this.f1110a.aa;
                mVar4.c(false);
            }
            fVar5 = this.f1110a.c;
            if (fVar5.d() == 0) {
                mVar5 = this.f1110a.aa;
                fVar7 = this.f1110a.c;
                mVar5.a(fVar7.a());
                i4 = this.f1110a.i;
                if (i4 == 1) {
                    bdListView2 = this.f1110a.Z;
                    bdListView2.setSelection(2);
                }
                this.f1110a.c(TiebaApplication.g().as());
            } else {
                ChatListFragment chatListFragment3 = this.f1110a;
                fVar6 = this.f1110a.c;
                chatListFragment3.b(fVar6.getErrorString());
            }
            runnable = this.f1110a.g;
            runnable.run();
            return;
        }
        ChatListFragment chatListFragment4 = this.f1110a;
        fVar2 = this.f1110a.c;
        chatListFragment4.b(fVar2.getErrorString());
    }
}
