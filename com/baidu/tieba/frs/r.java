package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
final class r implements com.baidu.tieba.model.by {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.by
    public final void a(String str, long j) {
        String str2;
        com.baidu.tieba.model.z zVar;
        String str3;
        String str4;
        bs bsVar;
        bs bsVar2;
        com.baidu.tieba.model.o a = com.baidu.tieba.model.o.a();
        str2 = this.a.g;
        a.b(str2);
        zVar = this.a.A;
        zVar.f().setLike(0);
        str3 = this.a.G;
        if (str3.equals("normal_page")) {
            bsVar2 = this.a.p;
            bsVar2.g(0);
        } else {
            str4 = this.a.G;
            if (str4.equals("frs_page")) {
                bsVar = this.a.p;
                bsVar.h(0);
            }
        }
        TiebaApplication.g().f(str);
    }

    @Override // com.baidu.tieba.model.by
    public final void a() {
    }
}
