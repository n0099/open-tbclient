package com.baidu.tieba.im.friend;

import com.baidu.tbadk.coreExtra.view.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements at {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.at
    public void a(String str) {
        af afVar;
        if (str == null || str.trim().equals("")) {
            afVar = this.a.b;
            afVar.a(str);
            this.a.a();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.at
    public void b(String str) {
        af afVar;
        afVar = this.a.b;
        afVar.a(str);
        this.a.a();
    }
}
