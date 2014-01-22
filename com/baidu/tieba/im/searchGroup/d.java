package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.message.ck;
import com.baidu.tieba.im.message.q;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SearchGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchGroupActivity searchGroupActivity) {
        this.a = searchGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(q qVar) {
        g gVar;
        g gVar2;
        g gVar3;
        gVar = this.a.b;
        gVar.b();
        if (qVar == null) {
            this.a.showToast(R.string.neterror);
        } else if (qVar.w() == 103007) {
            try {
                if (qVar instanceof ck) {
                    ck ckVar = (ck) qVar;
                    if (!ckVar.k()) {
                        gVar3 = this.a.b;
                        gVar3.a(ckVar);
                        this.a.a();
                    }
                    gVar2 = this.a.b;
                    gVar2.c();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.c("ResponseGroupInfoMessage invalid");
            }
        }
    }
}
