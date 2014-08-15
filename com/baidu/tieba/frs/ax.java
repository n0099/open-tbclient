package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.ForumData;
/* loaded from: classes.dex */
class ax implements dk {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dk
    public void a(i iVar, j jVar) {
        g gVar;
        g gVar2;
        cu cuVar;
        g gVar3;
        g gVar4;
        if (iVar.a) {
            this.a.showToast(this.a.getString(com.baidu.tieba.x.add_fan_sucess));
            gVar = this.a.L;
            gVar.n().b(1);
            gVar2 = this.a.L;
            gVar2.n().c(iVar.c);
            cuVar = this.a.z;
            gVar3 = this.a.L;
            ForumData i = gVar3.i();
            gVar4 = this.a.L;
            cuVar.a(1, i, gVar4, false);
            com.baidu.tieba.ai.c().e(true);
            return;
        }
        this.a.showToast(TextUtils.isEmpty(jVar.d) ? this.a.getString(com.baidu.tieba.x.add_fan_error) : jVar.d);
        if (jVar.c != 120002) {
            return;
        }
        this.a.D();
    }
}
