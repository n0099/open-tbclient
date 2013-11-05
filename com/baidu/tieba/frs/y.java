package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.model.cg;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1301a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.f1301a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        ba baVar;
        boolean z;
        cg cgVar;
        ba baVar2;
        cg cgVar2;
        String str;
        String str2;
        ba baVar3;
        ba baVar4;
        String str3;
        String str4;
        ba baVar5;
        com.baidu.tieba.model.ak akVar;
        com.baidu.tieba.model.ak akVar2;
        ba baVar6;
        ba baVar7;
        ba baVar8;
        ba baVar9;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        String str5;
        com.baidu.tieba.model.ak akVar5;
        com.baidu.tieba.model.ak akVar6;
        baVar = this.f1301a.o;
        baVar.c(false);
        if (obj == null || !(obj instanceof SignData)) {
            z = false;
        } else {
            com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
            str5 = this.f1301a.e;
            a2.b(str5);
            akVar5 = this.f1301a.x;
            akVar5.a((SignData) obj);
            TiebaApplication g = TiebaApplication.g();
            akVar6 = this.f1301a.x;
            g.c(akVar6.a().getName());
            z = true;
        }
        if (z) {
            str3 = this.f1301a.C;
            if (str3.equals("normal_page")) {
                baVar9 = this.f1301a.o;
                akVar3 = this.f1301a.x;
                int signed = akVar3.a().getSignData().getSigned();
                akVar4 = this.f1301a.x;
                baVar9.b(signed, akVar4.a().getSignData().getBonusPoint());
            } else {
                str4 = this.f1301a.C;
                if (str4.equals("frs_page")) {
                    baVar5 = this.f1301a.o;
                    akVar = this.f1301a.x;
                    int signed2 = akVar.a().getSignData().getSigned();
                    akVar2 = this.f1301a.x;
                    baVar5.a(signed2, akVar2.a().getSignData().getBonusPoint());
                }
            }
            StringBuilder sb = new StringBuilder(100);
            baVar6 = this.f1301a.o;
            if (!baVar6.q()) {
                sb.append(this.f1301a.getString(R.string.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.f1301a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                baVar8 = this.f1301a.o;
                baVar8.a(sb.toString());
                return;
            }
            sb.append(this.f1301a.getString(R.string.sign_success));
            sb.append(",");
            sb.append(String.format(this.f1301a.getString(R.string.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.f1301a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            baVar7 = this.f1301a.o;
            baVar7.a(sb.toString());
            return;
        }
        cgVar = this.f1301a.z;
        if (cgVar.getErrorCode() == 160002) {
            str = this.f1301a.C;
            if (str.equals("normal_page")) {
                baVar4 = this.f1301a.o;
                baVar4.f(1);
            } else {
                str2 = this.f1301a.C;
                if (str2.equals("frs_page")) {
                    baVar3 = this.f1301a.o;
                    baVar3.e(1);
                }
            }
        }
        baVar2 = this.f1301a.o;
        cgVar2 = this.f1301a.z;
        baVar2.a(cgVar2.getErrorString());
    }
}
