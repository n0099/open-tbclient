package com.baidu.tieba.chat;

import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ChatListActivity chatListActivity) {
        this.f956a = chatListActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        v vVar;
        int i;
        com.baidu.tieba.model.c cVar;
        int i2;
        v vVar2;
        v vVar3;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        v vVar4;
        int i3;
        com.baidu.tieba.model.c cVar4;
        v vVar5;
        com.baidu.tieba.model.c cVar5;
        com.baidu.tieba.model.c cVar6;
        Runnable runnable;
        v vVar6;
        com.baidu.tieba.model.c cVar7;
        int i4;
        int i5;
        v vVar7;
        com.baidu.tieba.model.c cVar8;
        v vVar8;
        v vVar9;
        v vVar10;
        v vVar11;
        vVar = this.f956a.f934a;
        vVar.k();
        i = this.f956a.g;
        switch (i) {
            case 1:
                vVar3 = this.f956a.f934a;
                vVar3.h().a(false);
                break;
            case 2:
                vVar2 = this.f956a.f934a;
                vVar2.h().b(false);
                break;
            case 4:
                if (Boolean.TRUE.equals(obj)) {
                    this.f956a.a(this.f956a.getResources().getString(R.string.delete_user_chat_done));
                    ChatListActivity chatListActivity = this.f956a;
                    i2 = this.f956a.c;
                    chatListActivity.a(i2, 3);
                    return;
                }
                ChatListActivity chatListActivity2 = this.f956a;
                cVar = this.f956a.b;
                chatListActivity2.a(cVar.getErrorString());
                return;
        }
        if (Boolean.TRUE.equals(obj)) {
            cVar3 = this.f956a.b;
            if (cVar3.b()) {
                vVar11 = this.f956a.f934a;
                vVar11.h().d(true);
            } else {
                vVar4 = this.f956a.f934a;
                vVar4.h().d(false);
            }
            i3 = this.f956a.c;
            if (i3 > 1) {
                vVar10 = this.f956a.f934a;
                vVar10.h().c(true);
            } else {
                cVar4 = this.f956a.b;
                int i6 = 0;
                for (com.baidu.tieba.data.a.g gVar : cVar4.a()) {
                    i6 = gVar.f() + i6;
                }
                if (i6 > com.baidu.tieba.mention.r.a().j()) {
                    com.baidu.tieba.mention.r.a().e();
                }
                vVar5 = this.f956a.f934a;
                vVar5.h().c(false);
            }
            cVar5 = this.f956a.b;
            if (cVar5.c() == 0) {
                vVar6 = this.f956a.f934a;
                cVar7 = this.f956a.b;
                vVar6.a(cVar7.a());
                i4 = this.f956a.g;
                if (i4 == 1) {
                    vVar9 = this.f956a.f934a;
                    vVar9.b(2);
                }
                i5 = this.f956a.c;
                if (i5 == 1) {
                    cVar8 = this.f956a.b;
                    if (cVar8.a().size() == 0) {
                        vVar8 = this.f956a.f934a;
                        vVar8.a(true);
                    }
                }
                vVar7 = this.f956a.f934a;
                vVar7.a(false);
            } else {
                ChatListActivity chatListActivity3 = this.f956a;
                cVar6 = this.f956a.b;
                chatListActivity3.a(cVar6.d());
            }
            runnable = this.f956a.e;
            runnable.run();
            return;
        }
        ChatListActivity chatListActivity4 = this.f956a;
        cVar2 = this.f956a.b;
        chatListActivity4.a(cVar2.getErrorString());
    }
}
