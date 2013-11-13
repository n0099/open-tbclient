package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements cj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.f1306a = frsActivity;
    }

    @Override // com.baidu.tieba.model.cj
    public void a(String str, long j) {
        String str2;
        com.baidu.tieba.model.ak akVar;
        String str3;
        String str4;
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
        str2 = this.f1306a.f;
        a2.b(str2);
        akVar = this.f1306a.w;
        akVar.a().setLike(0);
        str3 = this.f1306a.C;
        if (str3.equals("normal_page")) {
            bnVar3 = this.f1306a.n;
            bnVar3.g(0);
        } else {
            str4 = this.f1306a.C;
            if (str4.equals("frs_page")) {
                bnVar = this.f1306a.n;
                bnVar.h(0);
            }
        }
        bnVar2 = this.f1306a.n;
        bnVar2.e().c(false);
        TiebaApplication.g().f(str);
    }

    @Override // com.baidu.tieba.model.cj
    public void b(String str, long j) {
    }
}
