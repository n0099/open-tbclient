package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.e {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.c.ag agVar;
        ba baVar;
        com.baidu.tieba.c.ag agVar2;
        String str;
        String str2;
        ba baVar2;
        ba baVar3;
        String str3;
        String str4;
        ba baVar4;
        com.baidu.tieba.c.s sVar;
        com.baidu.tieba.c.s sVar2;
        ba baVar5;
        ba baVar6;
        com.baidu.tieba.c.s sVar3;
        com.baidu.tieba.c.s sVar4;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.a.ac)) {
            sVar4 = this.a.v;
            sVar4.a((com.baidu.tieba.a.ac) obj);
            z = true;
        }
        if (!z) {
            agVar = this.a.w;
            if (agVar.b() == 22) {
                str = this.a.A;
                if (str == "normal_page") {
                    baVar3 = this.a.l;
                    baVar3.g(1);
                } else {
                    str2 = this.a.A;
                    if (str2 == "frs_page") {
                        baVar2 = this.a.l;
                        baVar2.h(1);
                    }
                }
            }
            baVar = this.a.l;
            agVar2 = this.a.w;
            baVar.a(agVar2.c());
            return;
        }
        str3 = this.a.A;
        if (str3 == "normal_page") {
            baVar6 = this.a.l;
            sVar3 = this.a.v;
            baVar6.a(1, sVar3.a());
        } else {
            str4 = this.a.A;
            if (str4 == "frs_page") {
                baVar4 = this.a.l;
                sVar = this.a.v;
                com.baidu.tieba.a.s a = sVar.a();
                sVar2 = this.a.v;
                baVar4.a(1, a, sVar2.e());
            }
        }
        baVar5 = this.a.l;
        baVar5.a(this.a.getString(R.string.like_success));
        TiebaApplication.e().i(true);
    }
}
