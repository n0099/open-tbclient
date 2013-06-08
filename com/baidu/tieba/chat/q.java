package com.baidu.tieba.chat;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.e {
    final /* synthetic */ ChatListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ChatListActivity chatListActivity) {
        this.a = chatListActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        v vVar;
        int i;
        com.baidu.tieba.c.c cVar;
        int i2;
        v vVar2;
        v vVar3;
        com.baidu.tieba.c.c cVar2;
        com.baidu.tieba.c.c cVar3;
        v vVar4;
        int i3;
        com.baidu.tieba.c.c cVar4;
        v vVar5;
        com.baidu.tieba.c.c cVar5;
        com.baidu.tieba.c.c cVar6;
        int i4;
        Runnable runnable;
        v vVar6;
        com.baidu.tieba.c.c cVar7;
        int i5;
        int i6;
        v vVar7;
        com.baidu.tieba.c.c cVar8;
        v vVar8;
        v vVar9;
        v vVar10;
        v vVar11;
        vVar = this.a.c;
        vVar.g();
        i = this.a.i;
        switch (i) {
            case 1:
                vVar3 = this.a.c;
                vVar3.d().a(false);
                break;
            case 2:
                vVar2 = this.a.c;
                vVar2.d().b(false);
                break;
            case 4:
                if (Boolean.TRUE.equals(obj)) {
                    this.a.a(this.a.getResources().getString(R.string.delete_user_chat_done));
                    ChatListActivity chatListActivity = this.a;
                    i2 = this.a.e;
                    chatListActivity.b(i2, 3);
                    return;
                }
                ChatListActivity chatListActivity2 = this.a;
                cVar = this.a.d;
                chatListActivity2.a(cVar.c());
                return;
        }
        if (Boolean.TRUE.equals(obj)) {
            cVar3 = this.a.d;
            if (cVar3.e()) {
                vVar11 = this.a.c;
                vVar11.d().d(true);
            } else {
                vVar4 = this.a.c;
                vVar4.d().d(false);
            }
            i3 = this.a.e;
            if (i3 > 1) {
                vVar10 = this.a.c;
                vVar10.d().c(true);
            } else {
                cVar4 = this.a.d;
                int i7 = 0;
                for (com.baidu.tieba.a.a.g gVar : cVar4.d()) {
                    i7 = gVar.f() + i7;
                }
                if (i7 > TiebaApplication.d().ae()) {
                    TiebaApplication.d().Z();
                }
                vVar5 = this.a.c;
                vVar5.d().c(false);
            }
            cVar5 = this.a.d;
            if (cVar5.f() == 0) {
                vVar6 = this.a.c;
                cVar7 = this.a.d;
                vVar6.a(cVar7.d());
                i5 = this.a.i;
                if (i5 == 1) {
                    vVar9 = this.a.c;
                    vVar9.b(0);
                }
                i6 = this.a.e;
                if (i6 == 1) {
                    cVar8 = this.a.d;
                    if (cVar8.d().size() == 0) {
                        vVar8 = this.a.c;
                        vVar8.a(true);
                    }
                }
                vVar7 = this.a.c;
                vVar7.a(false);
            } else {
                ChatListActivity chatListActivity3 = this.a;
                cVar6 = this.a.d;
                chatListActivity3.a(cVar6.g());
            }
            i4 = this.a.i;
            if (i4 == 3) {
                this.a.a((int) R.drawable.tips_addchat, 0);
            }
            runnable = this.a.g;
            runnable.run();
            return;
        }
        ChatListActivity chatListActivity4 = this.a;
        cVar2 = this.a.d;
        chatListActivity4.a(cVar2.c());
    }
}
