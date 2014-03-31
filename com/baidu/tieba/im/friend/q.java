package com.baidu.tieba.im.friend;
/* loaded from: classes.dex */
final class q implements com.baidu.tbadk.coreExtra.view.ag {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ag
    public final void a(String str) {
        af afVar;
        if (str == null || str.trim().equals("")) {
            afVar = this.a.b;
            afVar.a(str);
            this.a.a();
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ag
    public final void b(String str) {
        af afVar;
        afVar = this.a.b;
        afVar.a(str);
        this.a.a();
    }
}
