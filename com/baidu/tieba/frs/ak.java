package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tieba.model.bg {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.tieba.model.bg
    public void a(String str, long j) {
        String str2;
        g gVar;
        String str3;
        String str4;
        cu cuVar;
        cu cuVar2;
        f a = f.a();
        str2 = this.a.q;
        a.a(str2, false);
        gVar = this.a.L;
        gVar.i().setLike(0);
        str3 = this.a.R;
        if (str3.equals("normal_page")) {
            cuVar2 = this.a.z;
            cuVar2.g(0);
        } else {
            str4 = this.a.R;
            if (str4.equals("frs_page")) {
                cuVar = this.a.z;
                cuVar.h(0);
            }
        }
        com.baidu.tieba.ai.c().e(str);
    }

    @Override // com.baidu.tieba.model.bg
    public void b(String str, long j) {
    }
}
