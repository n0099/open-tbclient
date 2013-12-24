package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.message.br;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        aa aaVar;
        aa aaVar2;
        com.baidu.tieba.im.model.m mVar;
        aa aaVar3;
        aa aaVar4;
        aaVar = this.a.b;
        aaVar.a(false);
        if (nVar == null || !(nVar instanceof br)) {
            this.a.showToast(R.string.neterror);
            return;
        }
        br brVar = (br) nVar;
        if (brVar.i()) {
            if (brVar.j() > 0) {
                if (!TextUtils.isEmpty(brVar.k())) {
                    this.a.showToast(brVar.k());
                    return;
                }
                return;
            }
            this.a.showToast(R.string.neterror);
            return;
        }
        this.a.showToast(R.string.members_delete_success);
        aaVar2 = this.a.b;
        w i = aaVar2.i();
        mVar = this.a.c;
        i.b(mVar.c());
        aaVar3 = this.a.b;
        aaVar3.j();
        aaVar4 = this.a.b;
        aaVar4.i().a();
    }
}
