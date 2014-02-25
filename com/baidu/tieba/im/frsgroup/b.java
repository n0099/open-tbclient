package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.cz;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGroupActivity frsGroupActivity) {
        this.a = frsGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        i iVar;
        i iVar2;
        com.baidu.tieba.im.model.d dVar;
        iVar = this.a.d;
        iVar.d(false);
        iVar2 = this.a.d;
        iVar2.b(true);
        if (sVar == null || !(sVar instanceof cz)) {
            this.a.c(R.string.neterror);
            return;
        }
        cz czVar = (cz) sVar;
        if (czVar.l()) {
            if (czVar.m() > 0) {
                if (!TextUtils.isEmpty(czVar.n())) {
                    this.a.a(czVar.n());
                    return;
                }
                return;
            }
            this.a.c(R.string.neterror);
            return;
        }
        GroupPermData a = czVar.a();
        if (a != null) {
            dVar = this.a.e;
            dVar.a(a);
            this.a.a(a);
        }
    }
}
