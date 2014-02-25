package com.baidu.tieba.im.friend;

import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
class k extends com.baidu.adp.a.g {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        u uVar;
        u uVar2;
        com.baidu.tieba.im.model.h hVar;
        com.baidu.tieba.im.model.h hVar2;
        com.baidu.tieba.im.model.h hVar3;
        uVar = this.a.a;
        uVar.m();
        this.a.closeLoadingDialog();
        if (obj == null) {
            hVar = this.a.b;
            if (hVar.getErrorCode() != 0) {
                hVar2 = this.a.b;
                if (hVar2.getErrorString() != null) {
                    InviteFriendListActivity inviteFriendListActivity = this.a;
                    hVar3 = this.a.b;
                    inviteFriendListActivity.showToast(hVar3.getErrorString());
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.tieba.im.data.e eVar = (com.baidu.tieba.im.data.e) obj;
        ArrayList<com.baidu.tieba.im.data.d> a = eVar == null ? null : eVar.a();
        if (eVar != null && eVar.b() && (a == null || a.size() <= 0)) {
            this.a.showToast(this.a.getString(R.string.invite_friend_no_data_now));
        }
        if (eVar != null) {
            uVar2 = this.a.a;
            uVar2.a(eVar);
        }
    }
}
