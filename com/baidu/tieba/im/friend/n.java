package com.baidu.tieba.im.friend;

import java.util.ArrayList;
/* loaded from: classes.dex */
class n extends com.baidu.adp.base.g {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        y yVar;
        y yVar2;
        af afVar;
        af afVar2;
        af afVar3;
        yVar = this.a.a;
        yVar.j();
        this.a.closeLoadingDialog();
        if (obj == null) {
            afVar = this.a.b;
            if (afVar.getErrorCode() != 0) {
                afVar2 = this.a.b;
                if (afVar2.getErrorString() != null) {
                    InviteFriendListActivity inviteFriendListActivity = this.a;
                    afVar3 = this.a.b;
                    inviteFriendListActivity.showToast(afVar3.getErrorString());
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.f fVar = (com.baidu.tieba.im.data.f) obj;
        ArrayList<com.baidu.tieba.im.data.e> a = fVar == null ? null : fVar.a();
        if (fVar != null && fVar.b() && (a == null || a.size() <= 0)) {
            this.a.showToast(this.a.getString(com.baidu.tieba.u.invite_friend_no_data_now));
        }
        if (fVar != null) {
            yVar2 = this.a.a;
            yVar2.a(fVar);
        }
    }
}
