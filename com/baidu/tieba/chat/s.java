package com.baidu.tieba.chat;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ChatListFragment chatListFragment) {
        this.f975a = chatListFragment;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        BdListView bdListView;
        int i;
        Activity activity;
        com.baidu.tieba.model.e eVar;
        Activity activity2;
        Activity activity3;
        int i2;
        l lVar;
        l lVar2;
        Activity activity4;
        com.baidu.tieba.model.e eVar2;
        com.baidu.tieba.model.e eVar3;
        l lVar3;
        int i3;
        com.baidu.tieba.model.e eVar4;
        l lVar4;
        com.baidu.tieba.model.e eVar5;
        Activity activity5;
        com.baidu.tieba.model.e eVar6;
        Runnable runnable;
        l lVar5;
        com.baidu.tieba.model.e eVar7;
        int i4;
        int i5;
        com.baidu.tieba.ae aeVar;
        com.baidu.tieba.model.e eVar8;
        com.baidu.tieba.ae aeVar2;
        BdListView bdListView2;
        l lVar6;
        l lVar7;
        bdListView = this.f975a.Y;
        bdListView.a();
        i = this.f975a.h;
        switch (i) {
            case 1:
                lVar2 = this.f975a.Z;
                lVar2.a(false);
                break;
            case 2:
                lVar = this.f975a.Z;
                lVar.b(false);
                break;
            case 4:
                if (Boolean.TRUE.equals(obj)) {
                    activity2 = this.f975a.c;
                    activity3 = this.f975a.c;
                    UtilHelper.a((Context) activity2, activity3.getString(R.string.delete_user_chat_done));
                    ChatListFragment chatListFragment = this.f975a;
                    i2 = this.f975a.d;
                    chatListFragment.a(i2, 3);
                    return;
                }
                activity = this.f975a.c;
                eVar = this.f975a.b;
                UtilHelper.a((Context) activity, eVar.getErrorString());
                return;
        }
        if (Boolean.TRUE.equals(obj)) {
            eVar3 = this.f975a.b;
            if (eVar3.b()) {
                lVar7 = this.f975a.Z;
                lVar7.d(true);
            } else {
                lVar3 = this.f975a.Z;
                lVar3.d(false);
            }
            i3 = this.f975a.d;
            if (i3 <= 1) {
                eVar4 = this.f975a.b;
                int i6 = 0;
                for (com.baidu.tieba.data.a.g gVar : eVar4.a()) {
                    i6 = gVar.f() + i6;
                }
                if (i6 > com.baidu.tieba.mention.s.a().l()) {
                    com.baidu.tieba.mention.s.a().f();
                }
                lVar4 = this.f975a.Z;
                lVar4.c(false);
            } else {
                lVar6 = this.f975a.Z;
                lVar6.c(true);
            }
            eVar5 = this.f975a.b;
            if (eVar5.c() != 0) {
                activity5 = this.f975a.c;
                eVar6 = this.f975a.b;
                UtilHelper.a((Context) activity5, eVar6.d());
            } else {
                lVar5 = this.f975a.Z;
                eVar7 = this.f975a.b;
                lVar5.a(eVar7.a());
                i4 = this.f975a.h;
                if (i4 == 1) {
                    bdListView2 = this.f975a.Y;
                    bdListView2.setSelection(2);
                }
                i5 = this.f975a.d;
                if (i5 == 1) {
                    eVar8 = this.f975a.b;
                    if (eVar8.a().size() == 0) {
                        aeVar2 = this.f975a.ad;
                        aeVar2.b(0);
                        this.f975a.b(TiebaApplication.g().ap());
                    }
                }
                aeVar = this.f975a.ad;
                aeVar.b(8);
                this.f975a.b(TiebaApplication.g().ap());
            }
            runnable = this.f975a.f;
            runnable.run();
            return;
        }
        activity4 = this.f975a.c;
        eVar2 = this.f975a.b;
        UtilHelper.a((Context) activity4, eVar2.getErrorString());
    }
}
