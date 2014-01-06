package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.message.bu;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        aa aaVar;
        aa aaVar2;
        com.baidu.tieba.im.model.m mVar;
        aa aaVar3;
        aa aaVar4;
        aaVar = this.a.b;
        aaVar.a(false);
        if (oVar == null || !(oVar instanceof bu)) {
            this.a.showToast(R.string.neterror);
            return;
        }
        bu buVar = (bu) oVar;
        if (buVar.i()) {
            if (buVar.j() > 0) {
                if (!TextUtils.isEmpty(buVar.k())) {
                    this.a.showToast(buVar.k());
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
