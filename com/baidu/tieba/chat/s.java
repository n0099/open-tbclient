package com.baidu.tieba.chat;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1197a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ChatListFragment chatListFragment) {
        this.f1197a = chatListFragment;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        BdListView bdListView;
        int i;
        Activity activity;
        com.baidu.tieba.model.f fVar;
        Activity activity2;
        Activity activity3;
        int i2;
        m mVar;
        m mVar2;
        Activity activity4;
        com.baidu.tieba.model.f fVar2;
        com.baidu.tieba.model.f fVar3;
        m mVar3;
        int i3;
        com.baidu.tieba.model.f fVar4;
        m mVar4;
        com.baidu.tieba.model.f fVar5;
        Activity activity5;
        com.baidu.tieba.model.f fVar6;
        Runnable runnable;
        m mVar5;
        com.baidu.tieba.model.f fVar7;
        int i4;
        BdListView bdListView2;
        m mVar6;
        m mVar7;
        bdListView = this.f1197a.Z;
        bdListView.a();
        i = this.f1197a.i;
        switch (i) {
            case 1:
                mVar2 = this.f1197a.aa;
                mVar2.a(false);
                break;
            case 2:
                mVar = this.f1197a.aa;
                mVar.b(false);
                break;
            case 4:
                if (Boolean.TRUE.equals(obj)) {
                    activity2 = this.f1197a.d;
                    activity3 = this.f1197a.d;
                    com.baidu.adp.lib.h.g.a((Context) activity2, activity3.getString(R.string.delete_user_chat_done));
                    ChatListFragment chatListFragment = this.f1197a;
                    i2 = this.f1197a.e;
                    chatListFragment.b(i2, 3);
                    return;
                }
                activity = this.f1197a.d;
                fVar = this.f1197a.c;
                com.baidu.adp.lib.h.g.a((Context) activity, fVar.getErrorString());
                return;
        }
        if (Boolean.TRUE.equals(obj)) {
            fVar3 = this.f1197a.c;
            if (fVar3.c()) {
                mVar7 = this.f1197a.aa;
                mVar7.d(true);
            } else {
                mVar3 = this.f1197a.aa;
                mVar3.d(false);
            }
            i3 = this.f1197a.e;
            if (i3 > 1) {
                mVar6 = this.f1197a.aa;
                mVar6.c(true);
            } else {
                fVar4 = this.f1197a.c;
                int i5 = 0;
                for (RecentChatFriendData recentChatFriendData : fVar4.a()) {
                    i5 = recentChatFriendData.getUnReadCount() + i5;
                }
                com.baidu.adp.lib.h.e.d("unReadCount:" + i5);
                mVar4 = this.f1197a.aa;
                mVar4.c(false);
            }
            fVar5 = this.f1197a.c;
            if (fVar5.d() == 0) {
                mVar5 = this.f1197a.aa;
                fVar7 = this.f1197a.c;
                mVar5.a(fVar7.a());
                i4 = this.f1197a.i;
                if (i4 == 1) {
                    bdListView2 = this.f1197a.Z;
                    bdListView2.setSelection(2);
                }
                this.f1197a.c(TiebaApplication.h().an());
            } else {
                activity5 = this.f1197a.d;
                fVar6 = this.f1197a.c;
                com.baidu.adp.lib.h.g.a((Context) activity5, fVar6.e());
            }
            runnable = this.f1197a.g;
            runnable.run();
            return;
        }
        activity4 = this.f1197a.d;
        fVar2 = this.f1197a.c;
        com.baidu.adp.lib.h.g.a((Context) activity4, fVar2.getErrorString());
    }
}
