package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.message.cg;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        ac acVar;
        ac acVar2;
        com.baidu.tieba.im.model.n nVar;
        ac acVar3;
        ac acVar4;
        acVar = this.a.b;
        acVar.a(false);
        if (qVar == null || !(qVar instanceof cg)) {
            this.a.showToast(R.string.neterror);
            return;
        }
        cg cgVar = (cg) qVar;
        if (cgVar.k()) {
            if (cgVar.l() > 0) {
                if (!TextUtils.isEmpty(cgVar.m())) {
                    this.a.showToast(cgVar.m());
                    return;
                }
                return;
            }
            this.a.showToast(R.string.neterror);
            return;
        }
        this.a.showToast(R.string.members_delete_success);
        acVar2 = this.a.b;
        y i = acVar2.i();
        nVar = this.a.c;
        i.b(nVar.c());
        acVar3 = this.a.b;
        acVar3.j();
        acVar4 = this.a.b;
        acVar4.i().a();
    }
}
