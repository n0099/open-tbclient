package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ck;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements ck {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.f1311a = frsActivity;
    }

    @Override // com.baidu.tieba.model.ck
    public void a(String str, long j) {
        String str2;
        com.baidu.tieba.model.ak akVar;
        String str3;
        String str4;
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
        str2 = this.f1311a.f;
        a2.b(str2);
        akVar = this.f1311a.w;
        akVar.a().setLike(0);
        str3 = this.f1311a.C;
        if (str3.equals("normal_page")) {
            bnVar2 = this.f1311a.n;
            bnVar2.g(0);
        } else {
            str4 = this.f1311a.C;
            if (str4.equals("frs_page")) {
                bnVar = this.f1311a.n;
                bnVar.h(0);
            }
        }
        TiebaApplication.g().f(str);
    }

    @Override // com.baidu.tieba.model.ck
    public void b(String str, long j) {
    }
}
