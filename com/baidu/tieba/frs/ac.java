package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.model.cc;
import com.baidu.tieba.util.AntiHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        boolean z;
        String str;
        String str2;
        bo boVar;
        cc ccVar;
        bo boVar2;
        cc ccVar2;
        String str3;
        String str4;
        bo boVar3;
        bo boVar4;
        com.baidu.tieba.model.ak akVar;
        String str5;
        String str6;
        bo boVar5;
        com.baidu.tieba.model.ak akVar2;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        String str7;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        com.baidu.tieba.model.ak akVar8;
        bo boVar6;
        bo boVar7;
        bo boVar8;
        bo boVar9;
        int i;
        com.baidu.tieba.model.ak akVar9;
        com.baidu.tieba.model.ak akVar10;
        bo boVar10;
        com.baidu.tieba.model.ak akVar11;
        com.baidu.tieba.model.ak akVar12;
        com.baidu.tieba.model.ak akVar13;
        com.baidu.tieba.model.ak akVar14;
        bo boVar11;
        String str8;
        com.baidu.tieba.model.ak akVar15;
        if (obj == null || !(obj instanceof SignData)) {
            z = false;
        } else {
            com.baidu.tieba.model.z a = com.baidu.tieba.model.z.a();
            str8 = this.a.f;
            a.b(str8);
            akVar15 = this.a.w;
            akVar15.a((SignData) obj);
            z = true;
        }
        str = this.a.C;
        if (str.equals("normal_page")) {
            boVar11 = this.a.n;
            boVar11.w();
        } else {
            str2 = this.a.C;
            if (str2.equals("frs_page")) {
                boVar = this.a.n;
                boVar.y();
            }
        }
        if (z) {
            akVar = this.a.w;
            AntiData d = akVar.d();
            str5 = this.a.C;
            if (str5.equals("normal_page")) {
                boVar10 = this.a.n;
                akVar11 = this.a.w;
                int signed = akVar11.a().getSignData().getSigned();
                akVar12 = this.a.w;
                int bonusPoint = akVar12.a().getSignData().getBonusPoint();
                akVar13 = this.a.w;
                ForumData a2 = akVar13.a();
                akVar14 = this.a.w;
                boVar10.b(signed, bonusPoint, a2, akVar14);
            } else {
                str6 = this.a.C;
                if (str6.equals("frs_page")) {
                    boVar5 = this.a.n;
                    akVar2 = this.a.w;
                    int signed2 = akVar2.a().getSignData().getSigned();
                    akVar3 = this.a.w;
                    int bonusPoint2 = akVar3.a().getSignData().getBonusPoint();
                    akVar4 = this.a.w;
                    ForumData a3 = akVar4.a();
                    akVar5 = this.a.w;
                    boVar5.a(signed2, bonusPoint2, a3, akVar5);
                }
            }
            if (obj != null && (obj instanceof SignData)) {
                boVar9 = this.a.n;
                if (boVar9.e()) {
                    akVar10 = this.a.w;
                    i = akVar10.a().getUser_level() + 1;
                } else {
                    i = -1;
                }
                TiebaApplication g = TiebaApplication.g();
                akVar9 = this.a.w;
                g.a(akVar9.a().getName(), ((SignData) obj).getBonusPoint(), i);
            }
            if (AntiHelper.b(d) || AntiHelper.a(d) || AntiHelper.c(d)) {
                str7 = this.a.f;
                d.setBlock_forum_name(str7);
                akVar6 = this.a.w;
                d.setBlock_forum_id(akVar6.a().getId());
                akVar7 = this.a.w;
                d.setUser_name(akVar7.c().getName());
                akVar8 = this.a.w;
                d.setUser_id(akVar8.c().getId());
                AntiHelper.a(this.a, d, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            boVar6 = this.a.n;
            if (!boVar6.A()) {
                sb.append(this.a.getString(R.string.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                boVar8 = this.a.n;
                boVar8.a(sb.toString());
                return;
            }
            sb.append(this.a.getString(R.string.sign_success));
            sb.append(",");
            sb.append(String.format(this.a.getString(R.string.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            boVar7 = this.a.n;
            boVar7.a(sb.toString());
            return;
        }
        ccVar = this.a.z;
        if (ccVar.getErrorCode() == 160002) {
            str3 = this.a.C;
            if (str3.equals("normal_page")) {
                boVar4 = this.a.n;
                boVar4.f(1);
            } else {
                str4 = this.a.C;
                if (str4.equals("frs_page")) {
                    boVar3 = this.a.n;
                    boVar3.e(1);
                }
            }
        }
        boVar2 = this.a.n;
        ccVar2 = this.a.z;
        boVar2.a(ccVar2.getErrorString());
    }
}
