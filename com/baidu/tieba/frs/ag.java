package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.util.AntiHelper;
/* loaded from: classes.dex */
final class ag extends com.baidu.adp.a.h {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        boolean z;
        String str;
        String str2;
        cm cmVar;
        com.baidu.tieba.model.az azVar;
        cm cmVar2;
        com.baidu.tieba.model.az azVar2;
        String str3;
        String str4;
        cm cmVar3;
        cm cmVar4;
        g gVar;
        String str5;
        String str6;
        cm cmVar5;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        String str7;
        g gVar6;
        g gVar7;
        g gVar8;
        cm cmVar6;
        cm cmVar7;
        cm cmVar8;
        cm cmVar9;
        int i;
        g gVar9;
        g gVar10;
        cm cmVar10;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        cm cmVar11;
        String str8;
        g gVar15;
        if (obj == null || !(obj instanceof SignData)) {
            z = false;
        } else {
            f a = f.a();
            str8 = this.a.i;
            a.b(str8);
            gVar15 = this.a.D;
            gVar15.a((SignData) obj);
            z = true;
        }
        str = this.a.J;
        if (str.equals("normal_page")) {
            cmVar11 = this.a.r;
            cmVar11.B();
        } else {
            str2 = this.a.J;
            if (str2.equals("frs_page")) {
                cmVar = this.a.r;
                cmVar.D();
            }
        }
        if (z) {
            gVar = this.a.D;
            AntiData i2 = gVar.i();
            str5 = this.a.J;
            if (str5.equals("normal_page")) {
                cmVar10 = this.a.r;
                gVar11 = this.a.D;
                int signed = gVar11.f().getSignData().getSigned();
                gVar12 = this.a.D;
                int bonusPoint = gVar12.f().getSignData().getBonusPoint();
                gVar13 = this.a.D;
                ForumData f = gVar13.f();
                gVar14 = this.a.D;
                cmVar10.b(signed, bonusPoint, f, gVar14);
            } else {
                str6 = this.a.J;
                if (str6.equals("frs_page")) {
                    cmVar5 = this.a.r;
                    gVar2 = this.a.D;
                    int signed2 = gVar2.f().getSignData().getSigned();
                    gVar3 = this.a.D;
                    int bonusPoint2 = gVar3.f().getSignData().getBonusPoint();
                    gVar4 = this.a.D;
                    ForumData f2 = gVar4.f();
                    gVar5 = this.a.D;
                    cmVar5.a(signed2, bonusPoint2, f2, gVar5);
                }
            }
            if (obj != null && (obj instanceof SignData)) {
                cmVar9 = this.a.r;
                if (cmVar9.l()) {
                    gVar10 = this.a.D;
                    i = gVar10.f().getUser_level() + 1;
                } else {
                    i = -1;
                }
                com.baidu.tieba.r c = com.baidu.tieba.r.c();
                gVar9 = this.a.D;
                c.a(gVar9.f().getName(), ((SignData) obj).getBonusPoint(), i);
            }
            if (AntiHelper.b(i2) || AntiHelper.a(i2) || AntiHelper.c(i2)) {
                str7 = this.a.i;
                i2.setBlock_forum_name(str7);
                gVar6 = this.a.D;
                i2.setBlock_forum_id(gVar6.f().getId());
                gVar7 = this.a.D;
                i2.setUser_name(gVar7.h().getUserName());
                gVar8 = this.a.D;
                i2.setUser_id(gVar8.h().getUserId());
                AntiHelper.a(this.a, i2, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            cmVar6 = this.a.r;
            if (!cmVar6.F()) {
                sb.append(this.a.getString(com.baidu.tieba.a.k.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.a.getString(com.baidu.tieba.a.k.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                cmVar8 = this.a.r;
                cmVar8.a(sb.toString());
                return;
            }
            sb.append(this.a.getString(com.baidu.tieba.a.k.sign_success));
            sb.append(",");
            sb.append(String.format(this.a.getString(com.baidu.tieba.a.k.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(com.baidu.tieba.a.k.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            cmVar7 = this.a.r;
            cmVar7.a(sb.toString());
            return;
        }
        azVar = this.a.G;
        if (azVar.getErrorCode() == 160002) {
            str3 = this.a.J;
            if (str3.equals("normal_page")) {
                cmVar4 = this.a.r;
                cmVar4.f(1);
            } else {
                str4 = this.a.J;
                if (str4.equals("frs_page")) {
                    cmVar3 = this.a.r;
                    cmVar3.e(1);
                }
            }
        }
        cmVar2 = this.a.r;
        azVar2 = this.a.G;
        cmVar2.a(azVar2.getErrorString());
    }
}
