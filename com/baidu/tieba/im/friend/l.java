package com.baidu.tieba.im.friend;

import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
class l extends com.baidu.adp.a.g {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(InviteFriendListActivity inviteFriendListActivity) {
        this.a = inviteFriendListActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        t tVar;
        t tVar2;
        com.baidu.tieba.im.model.g gVar;
        com.baidu.tieba.im.model.g gVar2;
        com.baidu.tieba.im.model.g gVar3;
        tVar = this.a.a;
        tVar.m();
        this.a.closeLoadingDialog();
        if (obj == null) {
            gVar = this.a.b;
            if (gVar.getErrorCode() != 0) {
                gVar2 = this.a.b;
                if (gVar2.getErrorString() != null) {
                    InviteFriendListActivity inviteFriendListActivity = this.a;
                    gVar3 = this.a.b;
                    inviteFriendListActivity.showToast(gVar3.getErrorString());
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
            tVar2 = this.a.a;
            tVar2.a(eVar);
        }
    }
}
