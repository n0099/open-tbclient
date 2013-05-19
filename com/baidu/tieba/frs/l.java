package com.baidu.tieba.frs;

import com.baidu.tieba.c.bk;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.e {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        boolean z;
        bk bkVar;
        ba baVar;
        bk bkVar2;
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
        ba baVar7;
        ba baVar8;
        com.baidu.tieba.c.p pVar3;
        com.baidu.tieba.c.p pVar4;
        com.baidu.tieba.c.p pVar5;
        if (obj == null || !(obj instanceof com.baidu.tieba.a.aw)) {
            z = false;
        } else {
            pVar5 = this.a.v;
            pVar5.a((com.baidu.tieba.a.aw) obj);
            z = true;
        }
        if (!z) {
            bkVar = this.a.x;
            if (bkVar.b() == 160002) {
                str = this.a.A;
                if (str == "normal_page") {
                    baVar3 = this.a.l;
                    baVar3.f(1);
                } else {
                    str2 = this.a.A;
                    if (str2 == "frs_page") {
                        baVar2 = this.a.l;
                        baVar2.e(1);
                    }
                }
            }
            baVar = this.a.l;
            bkVar2 = this.a.x;
            baVar.a(bkVar2.c());
            return;
        }
        str3 = this.a.A;
        if (str3 == "normal_page") {
            baVar8 = this.a.l;
            pVar3 = this.a.v;
            int b = pVar3.a().g().b();
            pVar4 = this.a.v;
            baVar8.b(b, pVar4.a().g().d());
        } else {
            str4 = this.a.A;
            if (str4 == "frs_page") {
                baVar4 = this.a.l;
                pVar = this.a.v;
                int b2 = pVar.a().g().b();
                pVar2 = this.a.v;
                baVar4.a(b2, pVar2.a().g().d());
            }
        }
        StringBuilder sb = new StringBuilder(100);
        baVar5 = this.a.l;
        if (!baVar5.p()) {
            sb.append(this.a.getString(R.string.sign_success));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.a.aw) obj).c())));
            baVar7 = this.a.l;
            baVar7.a(sb.toString());
            return;
        }
        sb.append(this.a.getString(R.string.sign_success));
        sb.append(",");
        sb.append(String.format(this.a.getString(R.string.sign_point), Integer.valueOf(((com.baidu.tieba.a.aw) obj).d())));
        sb.append("!\n");
        sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.a.aw) obj).c())));
        baVar6 = this.a.l;
        baVar6.a(sb.toString());
    }
}
