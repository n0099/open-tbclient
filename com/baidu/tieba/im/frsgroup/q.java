package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.message.cp;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class q implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        ae aeVar;
        ae aeVar2;
        com.baidu.tieba.im.model.l lVar;
        ae aeVar3;
        ae aeVar4;
        aeVar = this.a.b;
        aeVar.a(false);
        if (sVar == null || !(sVar instanceof cp)) {
            this.a.showToast(R.string.neterror);
            return;
        }
        cp cpVar = (cp) sVar;
        if (cpVar.l()) {
            if (cpVar.m() > 0) {
                if (!TextUtils.isEmpty(cpVar.n())) {
                    this.a.showToast(cpVar.n());
                    return;
                }
                return;
            }
            this.a.showToast(R.string.neterror);
            return;
        }
        this.a.showToast(R.string.members_delete_success);
        aeVar2 = this.a.b;
        aa h = aeVar2.h();
        lVar = this.a.c;
        h.b(lVar.c());
        aeVar3 = this.a.b;
        aeVar3.i();
        aeVar4 = this.a.b;
        aeVar4.h().a();
    }
}
