package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements cj {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.cj
    public void a(String str, long j) {
        String str2;
        com.baidu.tieba.model.ak akVar;
        String str3;
        String str4;
        bo boVar;
        bo boVar2;
        com.baidu.tieba.model.z a = com.baidu.tieba.model.z.a();
        str2 = this.a.f;
        a.b(str2);
        akVar = this.a.w;
        akVar.a().setLike(0);
        str3 = this.a.C;
        if (str3.equals("normal_page")) {
            boVar2 = this.a.n;
            boVar2.g(0);
        } else {
            str4 = this.a.C;
            if (str4.equals("frs_page")) {
                boVar = this.a.n;
                boVar.h(0);
            }
        }
        TiebaApplication.g().g(str);
    }

    @Override // com.baidu.tieba.model.cj
    public void b(String str, long j) {
    }
}
