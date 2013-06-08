package com.baidu.tieba.frs;

import com.baidu.tieba.c.bn;
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
        bn bnVar;
        ba baVar;
        bn bnVar2;
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
        ba baVar7;
        ba baVar8;
        com.baidu.tieba.c.s sVar3;
        com.baidu.tieba.c.s sVar4;
        com.baidu.tieba.c.s sVar5;
        if (obj == null || !(obj instanceof com.baidu.tieba.a.ax)) {
            z = false;
        } else {
            sVar5 = this.a.v;
            sVar5.a((com.baidu.tieba.a.ax) obj);
            z = true;
        }
        if (!z) {
            bnVar = this.a.x;
            if (bnVar.b() == 160002) {
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
            bnVar2 = this.a.x;
            baVar.a(bnVar2.c());
            return;
        }
        str3 = this.a.A;
        if (str3 == "normal_page") {
            baVar8 = this.a.l;
            sVar3 = this.a.v;
            int b = sVar3.a().g().b();
            sVar4 = this.a.v;
            baVar8.b(b, sVar4.a().g().d());
        } else {
            str4 = this.a.A;
            if (str4 == "frs_page") {
                baVar4 = this.a.l;
                sVar = this.a.v;
                int b2 = sVar.a().g().b();
                sVar2 = this.a.v;
                baVar4.a(b2, sVar2.a().g().d());
            }
        }
        StringBuilder sb = new StringBuilder(100);
        baVar5 = this.a.l;
        if (!baVar5.p()) {
            sb.append(this.a.getString(R.string.sign_success));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.a.ax) obj).c())));
            baVar7 = this.a.l;
            baVar7.a(sb.toString());
            return;
        }
        sb.append(this.a.getString(R.string.sign_success));
        sb.append(",");
        sb.append(String.format(this.a.getString(R.string.sign_point), Integer.valueOf(((com.baidu.tieba.a.ax) obj).d())));
        sb.append("!\n");
        sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.a.ax) obj).c())));
        baVar6 = this.a.l;
        baVar6.a(sb.toString());
    }
}
