package com.baidu.tieba.im.friend;

import com.baidu.tieba.view.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements cb {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // com.baidu.tieba.view.cb
    public void a(String str) {
        com.baidu.tieba.im.model.h hVar;
        if (str == null || str.trim().equals("")) {
            hVar = this.a.b;
            hVar.a(str);
            this.a.a();
        }
    }

    @Override // com.baidu.tieba.view.cb
    public void b(String str) {
        com.baidu.tieba.im.model.h hVar;
        hVar = this.a.b;
        hVar.a(str);
        this.a.a();
    }
}
