package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.bx;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.f1153a = frsActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        ba baVar;
        boolean z;
        bx bxVar;
        ba baVar2;
        bx bxVar2;
        String str;
        String str2;
        ba baVar3;
        ba baVar4;
        String str3;
        String str4;
        ba baVar5;
        com.baidu.tieba.model.ac acVar;
        com.baidu.tieba.model.ac acVar2;
        ba baVar6;
        ba baVar7;
        ba baVar8;
        ba baVar9;
        com.baidu.tieba.model.ac acVar3;
        com.baidu.tieba.model.ac acVar4;
        String str5;
        com.baidu.tieba.model.ac acVar5;
        com.baidu.tieba.model.ac acVar6;
        baVar = this.f1153a.o;
        baVar.c(false);
        if (obj == null || !(obj instanceof com.baidu.tieba.data.bb)) {
            z = false;
        } else {
            com.baidu.tieba.model.r a2 = com.baidu.tieba.model.r.a();
            str5 = this.f1153a.e;
            a2.b(str5);
            acVar5 = this.f1153a.x;
            acVar5.a((com.baidu.tieba.data.bb) obj);
            TiebaApplication g = TiebaApplication.g();
            acVar6 = this.f1153a.x;
            g.c(acVar6.a().b());
            z = true;
        }
        if (!z) {
            bxVar = this.f1153a.z;
            if (bxVar.getErrorCode() == 160002) {
                str = this.f1153a.C;
                if (str.equals("normal_page")) {
                    baVar4 = this.f1153a.o;
                    baVar4.f(1);
                } else {
                    str2 = this.f1153a.C;
                    if (str2.equals("frs_page")) {
                        baVar3 = this.f1153a.o;
                        baVar3.e(1);
                    }
                }
            }
            baVar2 = this.f1153a.o;
            bxVar2 = this.f1153a.z;
            baVar2.a(bxVar2.getErrorString());
            return;
        }
        str3 = this.f1153a.C;
        if (str3.equals("normal_page")) {
            baVar9 = this.f1153a.o;
            acVar3 = this.f1153a.x;
            int b = acVar3.a().g().b();
            acVar4 = this.f1153a.x;
            baVar9.b(b, acVar4.a().g().d());
        } else {
            str4 = this.f1153a.C;
            if (str4.equals("frs_page")) {
                baVar5 = this.f1153a.o;
                acVar = this.f1153a.x;
                int b2 = acVar.a().g().b();
                acVar2 = this.f1153a.x;
                baVar5.a(b2, acVar2.a().g().d());
            }
        }
        StringBuilder sb = new StringBuilder(100);
        baVar6 = this.f1153a.o;
        if (!baVar6.p()) {
            sb.append(this.f1153a.getString(R.string.sign_success));
            sb.append("!\n");
            sb.append(String.format(this.f1153a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.data.bb) obj).c())));
            baVar8 = this.f1153a.o;
            baVar8.a(sb.toString());
            return;
        }
        sb.append(this.f1153a.getString(R.string.sign_success));
        sb.append(",");
        sb.append(String.format(this.f1153a.getString(R.string.sign_point), Integer.valueOf(((com.baidu.tieba.data.bb) obj).d())));
        sb.append("!\n");
        sb.append(String.format(this.f1153a.getString(R.string.sign_user), Integer.valueOf(((com.baidu.tieba.data.bb) obj).c())));
        baVar7 = this.f1153a.o;
        baVar7.a(sb.toString());
    }
}
