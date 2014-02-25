package com.baidu.tieba.im.friend;

import com.baidu.tieba.view.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ci {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // com.baidu.tieba.view.ci
    public void a(String str) {
        com.baidu.tieba.im.model.h hVar;
        if (str == null || str.trim().equals("")) {
            hVar = this.a.b;
            hVar.a(str);
            this.a.a();
        }
    }

    @Override // com.baidu.tieba.view.ci
    public void b(String str) {
        com.baidu.tieba.im.model.h hVar;
        hVar = this.a.b;
        hVar.a(str);
        this.a.a();
    }
}
