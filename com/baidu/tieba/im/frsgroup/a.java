package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ FrsGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FrsGroupActivity frsGroupActivity) {
        this.a = frsGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        g gVar;
        g gVar2;
        com.baidu.tieba.im.model.c cVar;
        gVar = this.a.b;
        gVar.d(false);
        gVar2 = this.a.b;
        gVar2.b(true);
        if (oVar == null || !(oVar instanceof cb)) {
            this.a.b(R.string.neterror);
            return;
        }
        cb cbVar = (cb) oVar;
        if (cbVar.i()) {
            if (cbVar.j() > 0) {
                if (!TextUtils.isEmpty(cbVar.k())) {
                    this.a.a(cbVar.k());
                    return;
                }
                return;
            }
            this.a.b(R.string.neterror);
            return;
        }
        GroupPermData a = cbVar.a();
        if (a != null) {
            cVar = this.a.c;
            cVar.a(a);
            this.a.a(a);
        }
    }
}
