package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.message.ct;
import com.baidu.tieba.im.message.s;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class d implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ SearchGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchGroupActivity searchGroupActivity) {
        this.a = searchGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(s sVar) {
        g gVar;
        g gVar2;
        g gVar3;
        gVar = this.a.b;
        gVar.c();
        if (sVar == null) {
            this.a.showToast(R.string.neterror);
        } else if (sVar.w() == 103007) {
            try {
                if (sVar instanceof ct) {
                    ct ctVar = (ct) sVar;
                    if (!ctVar.l()) {
                        gVar3 = this.a.b;
                        gVar3.a(ctVar);
                        this.a.a();
                    }
                    gVar2 = this.a.b;
                    gVar2.d();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.d("ResponseGroupInfoMessage invalid");
            }
        }
    }
}
