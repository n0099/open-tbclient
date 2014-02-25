package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.model.by {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.by
    public void a(String str, long j) {
        String str2;
        com.baidu.tieba.model.z zVar;
        String str3;
        String str4;
        br brVar;
        br brVar2;
        com.baidu.tieba.model.o a = com.baidu.tieba.model.o.a();
        str2 = this.a.g;
        a.b(str2);
        zVar = this.a.A;
        zVar.b().setLike(0);
        str3 = this.a.G;
        if (str3.equals("normal_page")) {
            brVar2 = this.a.p;
            brVar2.g(0);
        } else {
            str4 = this.a.G;
            if (str4.equals("frs_page")) {
                brVar = this.a.p;
                brVar.h(0);
            }
        }
        TiebaApplication.g().f(str);
    }

    @Override // com.baidu.tieba.model.by
    public void b(String str, long j) {
    }
}
