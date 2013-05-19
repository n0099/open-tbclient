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
        com.baidu.tieba.c.ad adVar;
        ba baVar;
        com.baidu.tieba.c.ad adVar2;
        String str;
        String str2;
        ba baVar2;
        ba baVar3;
        String str3;
        String str4;
        ba baVar4;
        com.baidu.tieba.c.p pVar;
        com.baidu.tieba.c.p pVar2;
        ba baVar5;
        ba baVar6;
        com.baidu.tieba.c.p pVar3;
        com.baidu.tieba.c.p pVar4;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.a.ac)) {
            pVar4 = this.a.v;
            pVar4.a((com.baidu.tieba.a.ac) obj);
            z = true;
        }
        if (!z) {
            adVar = this.a.w;
            if (adVar.b() == 22) {
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
            adVar2 = this.a.w;
            baVar.a(adVar2.c());
            return;
        }
        str3 = this.a.A;
        if (str3 == "normal_page") {
            baVar6 = this.a.l;
            pVar3 = this.a.v;
            baVar6.a(1, pVar3.a());
        } else {
            str4 = this.a.A;
            if (str4 == "frs_page") {
                baVar4 = this.a.l;
                pVar = this.a.v;
                com.baidu.tieba.a.s a = pVar.a();
                pVar2 = this.a.v;
                baVar4.a(1, a, pVar2.e());
            }
        }
        baVar5 = this.a.l;
        baVar5.a(this.a.getString(R.string.like_success));
        TiebaApplication.d().h(true);
    }
}
