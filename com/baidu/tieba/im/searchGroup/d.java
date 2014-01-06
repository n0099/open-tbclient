package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.message.by;
import com.baidu.tieba.im.message.o;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SearchGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchGroupActivity searchGroupActivity) {
        this.a = searchGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(o oVar) {
        g gVar;
        g gVar2;
        g gVar3;
        gVar = this.a.b;
        gVar.b();
        if (oVar == null) {
            this.a.showToast(R.string.neterror);
        } else if (oVar.u() == 103007) {
            try {
                if (oVar instanceof by) {
                    by byVar = (by) oVar;
                    if (!byVar.i()) {
                        gVar3 = this.a.b;
                        gVar3.a(byVar);
                        this.a.a();
                    }
                    gVar2 = this.a.b;
                    gVar2.c();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.c("ResponseGroupInfoMessage invalid");
            }
        }
    }
}
