package com.baidu.tieba.chat;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f946a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ChatListActivity chatListActivity) {
        this.f946a = chatListActivity;
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
        vVar = this.f946a.f924a;
        vVar.g();
        i = this.f946a.g;
        switch (i) {
            case 1:
                vVar3 = this.f946a.f924a;
                vVar3.d().a(false);
                break;
            case 2:
                vVar2 = this.f946a.f924a;
                vVar2.d().b(false);
                break;
            case 4:
                if (Boolean.TRUE.equals(obj)) {
                    this.f946a.a(this.f946a.getResources().getString(R.string.delete_user_chat_done));
                    ChatListActivity chatListActivity = this.f946a;
                    i2 = this.f946a.c;
                    chatListActivity.a(i2, 3);
                    return;
                }
                ChatListActivity chatListActivity2 = this.f946a;
                cVar = this.f946a.b;
                chatListActivity2.a(cVar.getErrorString());
                return;
        }
        if (Boolean.TRUE.equals(obj)) {
            cVar3 = this.f946a.b;
            if (cVar3.b()) {
                vVar11 = this.f946a.f924a;
                vVar11.d().d(true);
            } else {
                vVar4 = this.f946a.f924a;
                vVar4.d().d(false);
            }
            i3 = this.f946a.c;
            if (i3 > 1) {
                vVar10 = this.f946a.f924a;
                vVar10.d().c(true);
            } else {
                cVar4 = this.f946a.b;
                int i6 = 0;
                for (com.baidu.tieba.data.a.g gVar : cVar4.a()) {
                    i6 = gVar.f() + i6;
                }
                if (i6 > TiebaApplication.f().ah()) {
                    TiebaApplication.f().ac();
                }
                vVar5 = this.f946a.f924a;
                vVar5.d().c(false);
            }
            cVar5 = this.f946a.b;
            if (cVar5.c() == 0) {
                vVar6 = this.f946a.f924a;
                cVar7 = this.f946a.b;
                vVar6.a(cVar7.a());
                i4 = this.f946a.g;
                if (i4 == 1) {
                    vVar9 = this.f946a.f924a;
                    vVar9.b(0);
                }
                i5 = this.f946a.c;
                if (i5 == 1) {
                    cVar8 = this.f946a.b;
                    if (cVar8.a().size() == 0) {
                        vVar8 = this.f946a.f924a;
                        vVar8.a(true);
                    }
                }
                vVar7 = this.f946a.f924a;
                vVar7.a(false);
            } else {
                ChatListActivity chatListActivity3 = this.f946a;
                cVar6 = this.f946a.b;
                chatListActivity3.a(cVar6.d());
            }
            runnable = this.f946a.e;
            runnable.run();
            return;
        }
        ChatListActivity chatListActivity4 = this.f946a;
        cVar2 = this.f946a.b;
        chatListActivity4.a(cVar2.getErrorString());
    }
}
