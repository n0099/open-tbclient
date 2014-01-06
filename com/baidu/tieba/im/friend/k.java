package com.baidu.tieba.im.friend;

import com.baidu.tieba.view.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements bl {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // com.baidu.tieba.view.bl
    public void a(String str) {
        com.baidu.tieba.im.model.g gVar;
        if (str == null || str.trim().equals("")) {
            gVar = this.a.b;
            gVar.a(str);
            this.a.a();
        }
    }

    @Override // com.baidu.tieba.view.bl
    public void b(String str) {
        com.baidu.tieba.im.model.g gVar;
        gVar = this.a.b;
        gVar.a(str);
        this.a.a();
    }
}
