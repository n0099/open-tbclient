package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.cq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsGroupActivity frsGroupActivity) {
        this.a = frsGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        g gVar;
        g gVar2;
        com.baidu.tieba.im.model.d dVar;
        gVar = this.a.b;
        gVar.d(false);
        gVar2 = this.a.b;
        gVar2.b(true);
        if (qVar == null || !(qVar instanceof cq)) {
            this.a.b(R.string.neterror);
            return;
        }
        cq cqVar = (cq) qVar;
        if (cqVar.k()) {
            if (cqVar.l() > 0) {
                if (!TextUtils.isEmpty(cqVar.m())) {
                    this.a.a(cqVar.m());
                    return;
                }
                return;
            }
            this.a.b(R.string.neterror);
            return;
        }
        GroupPermData a = cqVar.a();
        if (a != null) {
            dVar = this.a.c;
            dVar.a(a);
            this.a.a(a);
        }
    }
}
